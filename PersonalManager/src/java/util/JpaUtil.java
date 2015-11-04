package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vitor
 */
public class JpaUtil {

    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("PersonalManagerPU");

    public static EntityManager getEntityManager() {

        return (emf.createEntityManager());

    }

    public static void close() {
        emf.close();
    }

}
