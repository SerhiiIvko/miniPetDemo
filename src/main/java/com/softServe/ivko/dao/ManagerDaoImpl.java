package com.softServe.ivko.dao;

import com.softServe.ivko.exception.ApplicationException;
import com.softServe.ivko.model.Manager;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerDaoImpl implements ManagerDao {
    private static final String MANAGER_BY_ID_QUERY = "select * from manager where id = '%s'";
    private static final String MANAGER_BY_EMAIL_QUERY = "select * from manager where email = '%s'";
    private static final String ALL_MANAGERS_QUERY = "select * from manager";
    private static final String ERROR_MESSAGE_PATTERN = "Manager not found by %s: %s";

    @Override
    public Manager getById(Long id) {
        return getManagerByQuery(String.format(MANAGER_BY_ID_QUERY, id),
                String.format(ERROR_MESSAGE_PATTERN, "id", id));
    }

    @Override
    public Manager getByEmail(String email) {
        return getManagerByQuery(String.format(MANAGER_BY_EMAIL_QUERY, email),
                String.format(ERROR_MESSAGE_PATTERN, "email", email));
    }

    private Manager getManagerByQuery(String query, String errorMessage) {
        Manager manager = null;
        try (Connection connection = retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                manager = new Manager();
                manager.setId(resultSet.getLong("id"));
                manager.setName(resultSet.getString("name"));
                manager.setSurname(resultSet.getString("surname"));
                manager.setEmail(resultSet.getString("email"));
                manager.setPassword(resultSet.getString("password"));
                manager.setAge(resultSet.getInt("age"));
            }
        } catch (Exception e) {
            throw new ApplicationException("Failed to load manager from DB", e);
        }
        if (manager == null) {
            throw new ApplicationException(errorMessage);
        }
        return manager;
    }

    @Override
    public List<Manager> getAll() {
        List<Manager> managers = new ArrayList<>();
        try (Connection connection = retrieveConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(ALL_MANAGERS_QUERY);
            while (resultSet.next()) {
                Manager manager = new Manager();
                manager.setId(resultSet.getLong("id"));
                manager.setName(resultSet.getString("name"));
                manager.setSurname(resultSet.getString("surname"));
                manager.setEmail(resultSet.getString("email"));
                manager.setPassword(resultSet.getString("password"));
                manager.setAge(resultSet.getInt("age"));
                managers.add(manager);
            }
        } catch (Exception e) {
            throw new ApplicationException("Failed to load manager from DB", e);
        }
        return managers;
    }

    private static final String INSERT_MANAGER_QUERY = "insert into manager (name, surname, age, email, password) values (?, ?, ?, ?, ?)";

    @Override
    public Manager create(Manager manager) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_MANAGER_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, manager.getName());
            statement.setString(2, manager.getSurname());
            statement.setInt(3, manager.getAge());
            statement.setString(4, manager.getEmail());
            statement.setString(5, manager.getPassword());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                manager.setId(generatedKeys.getLong(1));
            }
        } catch (Exception e) {
            throw new ApplicationException("Failed to insert manager into DB", e);
        }
        return manager;
    }

    private static final String UPDATE_MANAGER_QUERY = "update manager set name=?, surname=?, age=?, email=?%s where id=?";
    private static final String UPDATE_PASSWORD_PART = ", password=?";

    @Override
    public Manager update(Manager manager) {
        boolean needUpdatePassword = StringUtils.isNotEmpty(manager.getPassword());
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(String.format(UPDATE_MANAGER_QUERY,
                     needUpdatePassword ? UPDATE_PASSWORD_PART : ""))) {
            int parameterCounter = 1;
            statement.setString(parameterCounter++, manager.getName());
            statement.setString(parameterCounter++, manager.getSurname());
            statement.setInt(parameterCounter++, manager.getAge());
            statement.setString(parameterCounter++, manager.getEmail());
            if (needUpdatePassword) {
                statement.setString(parameterCounter++, manager.getPassword());
            }
            statement.setLong(parameterCounter, manager.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new ApplicationException("Failed to update manager", e);
        }
        return manager;
    }

    @Override
    public void update(List<Manager> managers) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(String.format(UPDATE_MANAGER_QUERY, ""))) {
            for (Manager manager : managers) {
                statement.setString(1, manager.getName());
                statement.setString(2, manager.getSurname());
                statement.setInt(3, manager.getAge());
                statement.setString(4, manager.getEmail());
                statement.setLong(5, manager.getId());
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (Exception e) {
            throw new ApplicationException("Failed to update managers", e);
        }
    }

    private static final String DELETE_MANAGER_QUERY = "delete from manager where id=?";

    @Override
    public void deleteManager(Manager manager) {
        try (Connection connection = retrieveConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_MANAGER_QUERY)) {
            statement.setLong(1, manager.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new ApplicationException("Failed to delete manager", e);
        }
    }

    private Connection retrieveConnection() throws SQLException {
        return DBManager.getInstance().getConnection();
    }
}