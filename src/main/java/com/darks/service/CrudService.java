package com.darks.service;
/**
 * @author Er. Arundeep Randev
 * @since Jan 2025
 *
 */
import java.util.List;

public interface CrudService<ID, T> {
    List<T> findAll();
    T findById(ID id);

}
