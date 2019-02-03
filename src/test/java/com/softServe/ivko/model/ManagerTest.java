//package com.softServe.ivko.model;
//
//import org.junit.Assert;
//import org.junit.Test;
//
//public class ManagerTest {
//    private Manager manager;
//
//    @Test
//    public void getId() {
//        //GIVEN:
//        manager = new Manager();
//        long expectedId = 1L;
//        long actualId;
//
//        //WHEN:
//        manager.setId(expectedId);
//        actualId = manager.getId();
//
//        //THEN:
//        Assert.assertEquals(expectedId, actualId);
//    }
//
//    @Test
//    public void getName() {
//        //GIVEN:
//        manager = new Manager();
//        String expectedName = "Ivan";
//        String actualName;
//
//        //WHEN:
//        manager.setName(expectedName);
//        actualName = manager.getName();
//
//        //THEN:
//        Assert.assertEquals(expectedName, actualName);
//    }
//
//    @Test
//    public void getSurname() {
//        //GIVEN:
//        manager = new Manager();
//        String expectedSurname = "Danilov";
//        String actualSurname;
//
//        //WHEN:
//        manager.setName(expectedSurname);
//        actualSurname = manager.getName();
//
//        //THEN:
//        Assert.assertEquals(expectedSurname, actualSurname);
//    }
//
//    @Test
//    public void getAge() {
//        //GIVEN:
//        manager = new Manager();
//        int expectedAge = 25;
//        int actualAge;
//
//        //WHEN:
//        manager.setAge(expectedAge);
//        actualAge = manager.getAge();
//
//        //THEN:
//        Assert.assertEquals(expectedAge, actualAge);
//    }
//
//    @Test
//    public void getEmail() {
//        //GIVEN:
//        manager = new Manager();
//        String expectedEmail = "ivan-danilov@gmail.com";
//        String actualEmail;
//
//        //WHEN:
//        manager.setEmail(expectedEmail);
//        actualEmail = manager.getEmail();
//
//        //THEN:
//        Assert.assertEquals(expectedEmail, actualEmail);
//    }
//}