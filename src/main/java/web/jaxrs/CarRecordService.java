package web.jaxrs;

import dto.CarDTO;
import persistence.CarService;
import web.context.EntityManagerContextListener;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/car_record")
public class CarRecordService {
    private CarService carservice;

    @Context
    public void setServletContext(ServletContext servletContext) {
        EntityManager entityManager = (EntityManager)
                servletContext.getAttribute(
                        EntityManagerContextListener.ENTITY_MANAGER
                );
        this.carservice = new CarService(entityManager);
    }

    @GET
    @Path("/cars")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CarDTO> getCars(){
        return carservice.getAllCars();
    }

    @POST
    @Path("/cars")
    @Produces({MediaType.APPLICATION_JSON})
    public CarDTO saveCar(CarDTO carDTO){
        return carservice.saveNewCar(carDTO);
    }

}
