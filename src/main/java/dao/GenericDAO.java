/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Alison Espinoza
 */
public interface GenericDAO<T, ID extends Serializable> {
    void create(T entity);
    T update(T entity);
    void delete(T entity);
    T findById(ID id);
    List<T> findAll();
}
