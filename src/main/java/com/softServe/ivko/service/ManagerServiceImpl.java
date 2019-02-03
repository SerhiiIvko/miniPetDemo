package com.softServe.ivko.service;

import com.softServe.ivko.converter.ManagerConverter;
import com.softServe.ivko.dao.ManagerDao;
import com.softServe.ivko.dao.ManagerDaoImpl;
import com.softServe.ivko.model.Manager;
import com.softServe.ivko.validator.ManagerValidator;
import com.softServe.ivko.validator.ManagerValidatorImpl;
import com.softServe.ivko.web.dto.ManagerCreateDto;
import com.softServe.ivko.web.dto.ManagerViewDto;

import java.util.List;
import java.util.stream.Collectors;

public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao = new ManagerDaoImpl();
    private ManagerValidator managerValidator = new ManagerValidatorImpl();
    private ManagerConverter managerConverter = new ManagerConverter();

    @Override
    public ManagerViewDto registerManager(ManagerCreateDto createDto) {
        managerValidator.validateManager(createDto, true);
        Manager manager = managerConverter.asManager(createDto);
        manager = managerDao.create(manager);
        return managerConverter.asManagerDto(manager);
    }

    public ManagerViewDto updateManager(ManagerCreateDto createDto) {
        managerValidator.validateManager(createDto, false);
        Manager manager = managerConverter.asManager(createDto);
        manager = managerDao.update(manager);
        return managerConverter.asManagerDto(manager);
    }

    @Override
    public void updateManagers(List<ManagerCreateDto> createDtoList) {
        createDtoList.forEach(managerCreateDto -> managerValidator.validateManager(managerCreateDto, false));
        List<Manager> managers = createDtoList
                .stream()
                .map(managerCreateDto -> managerConverter.asManager(managerCreateDto))
                .collect(Collectors.toList());
        managerDao.update(managers);
    }

    @Override
    public void deleteManager(ManagerCreateDto createDto) {
        Manager manager = managerConverter.asManager(createDto);
        managerDao.deleteManager(manager);
    }

    @Override
    public List<ManagerViewDto> getAllManagers() {
        List<Manager> managers = managerDao.getAll();
        return managers
                .stream()
                .map(manager -> managerConverter.asManagerDto(manager))
                .collect(Collectors.toList());
    }

    @Override
    public ManagerViewDto getManagerById(long id) {
        Manager manager = managerDao.getById(id);
        return managerConverter.asManagerDto(manager);
    }
}