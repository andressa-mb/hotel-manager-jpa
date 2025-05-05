package br.com.senac.hotel.web.conection;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "Hotel-BD";

    private static EntityManager manager;
    private static EntityManagerFactory fabrica;

    public static EntityManager getEntityManager() {
        if (fabrica == null || !fabrica.isOpen()) {
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        if (manager == null || !manager.isOpen()) {
            manager = fabrica.createEntityManager();
        }

        return manager;
    }

    public static void closeEntityManager() {
        if (manager.isOpen() && manager != null) {
            manager.close();
            fabrica.close();
        }
    }
}
