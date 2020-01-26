package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rafae
 */
public class Database {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        if (emf == null) {
            connectDatabase();
        }
        return emf.createEntityManager();
    }

    private static void connectDatabase() {
        emf = Persistence.createEntityManagerFactory("mydatabase.odb");
    }

}
