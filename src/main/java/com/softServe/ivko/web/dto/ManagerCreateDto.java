package com.softServe.ivko.web.dto;

import java.io.Serializable;

public class ManagerCreateDto implements Serializable {
    private static final long serialVersionUID = 751014166558232361L;
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String password;

    public ManagerCreateDto(String name, String surname, Integer age, String email, String password) {
        this(null, name, surname, age, email, password);
    }

    public ManagerCreateDto(Long id, String name, String surname, Integer age, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerCreateDto that = (ManagerCreateDto) o;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(that.getSurname()) : that.getSurname() != null) return false;
        if (getAge() != null ? !getAge().equals(that.getAge()) : that.getAge() != null) return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        return getPassword() != null ? getPassword().equals(that.getPassword()) : that.getPassword() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }
}