package com.softServe.ivko.dao;

import com.softServe.ivko.model.Manager;

import java.util.List;

public interface ManagerDao {
    Manager getById(Long id);
    Manager getByEmail(String email);
    List<Manager> getAll();
    Manager create(Manager manager);
    Manager update(Manager manager);
    void update(List<Manager> managers);
    void deleteManager(Manager manager);
}