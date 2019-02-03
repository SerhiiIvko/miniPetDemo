//package com.softServe.ivko.validator;
//
//import com.softServe.ivko.exception.ValidationException;
//import com.softServe.ivko.web.dto.ManagerCreateDto;
//import org.junit.Test;
//
//public class ManagerValidatorImplTest {
//    private ManagerValidatorImpl validator;
//    private ManagerCreateDto createDto;
//
//    @Test
//    public void validateManagerCredentialsWhenCorrect() {
//        validator = new ManagerValidatorImpl();
//        String email = "sss@gg.com";
//        String password = "www";
//        boolean create = true;
//        createDto = new ManagerCreateDto("ddd", "aaa", 25, email, password);
//        validator.validateManagerCredentials(email, password, create);
//    }
//
//    @Test(expected = ValidationException.class)
//    public void validateManagerCredentialsWhenIncorrectEmail() {
//        validator = new ManagerValidatorImpl();
//        String email = "";
//        String password = "www";
//        boolean create = true;
//        createDto = new ManagerCreateDto("jimm", "carry", 25, email, password);
//        validator.validateManagerCredentials(email, password, create);
//    }
//
//    @Test(expected = ValidationException.class)
//    public void validateManagerCredentialsWhenIncorrectPassword() {
//        validator = new ManagerValidatorImpl();
//        String email = "www@ff.com";
//        String password = "";
//        boolean create = true;
//        createDto = new ManagerCreateDto("jimm", "carry", 25, email, password);
//        validator.validateManagerCredentials(email, password, create);
//    }
//
//    @Test
//    public void validateManager() {
//        validator = new ManagerValidatorImpl();
//        String email = "sss@gg.com";
//        String password = "www";
//        boolean create = true;
//        createDto = new ManagerCreateDto("ddd", "aaa", 25, email, password);
//        validator.validateManager(createDto, create);
//    }
//
//    @Test(expected = ValidationException.class)
//    public void validateManagerWhenNameIncorrect() {
//        validator = new ManagerValidatorImpl();
//        String email = "sss@gg.com";
//        String password = "www";
//        boolean create = true;
//        createDto = new ManagerCreateDto("", "aaa", 25, email, password);
//        validator.validateManager(createDto, create);
//    }
//}