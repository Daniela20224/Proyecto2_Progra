/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Alison Espinoza
 */
public class GenericDAOImpl<T, ID extends Serializable>
        implements GenericDAO<T, ID> {
    protected EntityManager em = JPAUtil.getEntityManager();
    private Class<T> entityClass;

    public GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public void create(T entity) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entity);
        tx.commit();
    }

    @Override
    public T update(T entity) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        T merged = em.merge(entity);
        tx.commit();
        return merged;
    }

    @Override
    public void delete(T entity) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        tx.commit();
    }

    @Override
    public T findById(ID id) {
        return em.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        String q = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        System.out.println(q);
        return em.createQuery(q, entityClass).getResultList();
    }
}
