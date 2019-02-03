package com.softServe.ivko.converter;

import com.softServe.ivko.model.Manager;
import com.softServe.ivko.web.dto.ManagerCreateDto;
import com.softServe.ivko.web.dto.ManagerViewDto;

public class ManagerConverter {
    public ManagerViewDto asManagerDto(Manager manager) {
        ManagerViewDto dto = new ManagerViewDto();
        dto.setAge(manager.getAge());
        dto.setId(manager.getId());
        dto.setSurname(manager.getSurname());
        dto.setEmail(manager.getEmail());
        dto.setName(manager.getName());
        return dto;
    }

    public Manager asManager(ManagerCreateDto createDto) {
        Manager manager = new Manager();
        manager.setId(createDto.getId());
        manager.setEmail(createDto.getEmail());
        manager.setPassword(createDto.getPassword());
        manager.setName(createDto.getName());
        manager.setSurname(createDto.getSurname());
        manager.setAge(createDto.getAge());
        return manager;
    }
}