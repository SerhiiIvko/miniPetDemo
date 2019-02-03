package com.softServe.ivko.validator;

import com.softServe.ivko.web.dto.ManagerCreateDto;

public interface ManagerValidator {
    void validateManagerCredentials(String email, String password, boolean create);
    void validateManager(ManagerCreateDto createDto, boolean create);
}