/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author Alison Espinoza
 */
public class JPAUtil {
    private static final EntityManagerFactory emf =
        Persistence.createEntityManagerFactory("com.mycompany_Proyecto2_Progra_jar_1.0-SNAPSHOTPU");
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}

