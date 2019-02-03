package com.softServe.ivko.service;

import com.softServe.ivko.web.dto.ManagerCreateDto;
import com.softServe.ivko.web.dto.ManagerViewDto;

import java.util.List;

public interface ManagerService {
    ManagerViewDto registerManager(ManagerCreateDto createDto);
    List<ManagerViewDto> getAllManagers();
    ManagerViewDto getManagerById(long id);
    ManagerViewDto updateManager(ManagerCreateDto createDto);
    void updateManagers(List<ManagerCreateDto> createDtoList);
    void deleteManager(ManagerCreateDto createDto);
}