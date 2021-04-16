package persistence;

import dto.CarDTO;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


public class CarService {
    private EntityManager entityManager;

    public CarService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveNewCar(CarDTO carDTO){
        CarRecord record = asRecordForNewCar(carDTO);
        entityManager.getTransaction().begin();
        entityManager.persist(record);
        entityManager.getTransaction().commit();
    }

    public List<CarDTO> getAllCars() {
        List<CarRecord> car_records = entityManager.createQuery("select c from CarRecord c", CarRecord.class).getResultList();
        List<CarDTO> carDTOS = new ArrayList<CarDTO>();
        for (CarRecord carRecord:car_records) {
            carDTOS.add(new CarDTO.Builder()
                    .withId(carRecord.getId())
                    .withBrand(carRecord.getBrand())
                    .withModel(carRecord.getModel())
                    .withPlate(carRecord.getPlate())
                    .withYear(carRecord.getYear())
                    .build());
        }
        return carDTOS;
    }

    public CarDTO getCar(long id) {
        CarRecord carRecord = entityManager.find(CarRecord.class,id);
        CarDTO cardto = new CarDTO.Builder()
                .withId(carRecord.getId())
                .withBrand(carRecord.getBrand())
                .withModel(carRecord.getModel())
                .withPlate(carRecord.getPlate())
                .withYear(carRecord.getYear())
                .build();

        return cardto;
    }

    public void deleteCar(long id) {
        CarRecord carRecord = entityManager.find(CarRecord.class,id);
        entityManager.getTransaction().begin();
        entityManager.remove(carRecord);
        entityManager.getTransaction().commit();
    }

    private CarRecord asRecordForNewCar(CarDTO carDTO) {
        CarRecord record = new CarRecord();
        record.setBrand(carDTO.getBrand());
        record.setModel(carDTO.getModel());
        record.setPlate(carDTO.getPlate());
        record.setYear(carDTO.getYear());
        return record;
    }
}
