package web.context;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class EntityManagerContextListener implements ServletContextListener {

    public static final String ENTITY_MANAGER_FACTORY = "entityManagerFactory";
    public static final String ENTITY_MANAGER = "entityManager";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        sce.getServletContext().setAttribute(ENTITY_MANAGER_FACTORY,entityManagerFactory);
        sce.getServletContext().setAttribute(ENTITY_MANAGER,entityManager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        EntityManagerFactory emf =
                (EntityManagerFactory)sce.getServletContext().getAttribute(ENTITY_MANAGER_FACTORY);
        EntityManager em =
                (EntityManager)sce.getServletContext().getAttribute(ENTITY_MANAGER);
        em.close();
        emf.close();
    }
}
