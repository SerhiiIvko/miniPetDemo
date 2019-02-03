package com.softServe.ivko.validator;

import com.softServe.ivko.exception.ValidationException;
import com.softServe.ivko.web.dto.ManagerCreateDto;
import org.apache.commons.lang3.StringUtils;

public class ManagerValidatorImpl implements ManagerValidator {

    @Override
    public void validateManagerCredentials(String email, String password, boolean create) {
        if (StringUtils.isEmpty(email) || (create && StringUtils.isEmpty(password))) {
            throw new ValidationException("Invalid credentials: " + email);
        }
    }

    @Override
    public void validateManager(ManagerCreateDto createDto, boolean create) {
        validateManagerCredentials(createDto.getEmail(), createDto.getPassword(), create);
        if (StringUtils.isEmpty(createDto.getName())) {
            throw new ValidationException("Invalid manager name: " + createDto.getName());
        }
    }
}