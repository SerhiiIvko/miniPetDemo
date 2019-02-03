package com.softServe.ivko.dao;

import com.softServe.ivko.exception.ApplicationException;
import com.ibatis.common.jdbc.ScriptRunner;
import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {

    private static DBManager Instance;
    private DataSource dataSource;
    private static final String SCHEMA_SCRIPT = "/home/ivko/IdeaProjects/EPAM_homework/epam_homework/homework_13/src/main/resources/schema.sql";
    private static final String DATA_SCRIPT = "/home/ivko/IdeaProjects/EPAM_homework/epam_homework/homework_13/src/main/resources/data.sql";

    public static DBManager getInstance() {
        if (Instance == null) {
            Instance = new DBManager();
        }
        return Instance;
    }

    private DBManager() {
    }

    public void initialize(Properties properties) {
        try {
            dataSource = createMySQLDataSource(properties);
            loadScript(SCHEMA_SCRIPT);
            loadScript(DATA_SCRIPT);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private DataSource createMySQLDataSource(Properties properties) throws NullPointerException, SQLException {
        MysqlDataSource mysqlDS;
        mysqlDS = new MysqlDataSource();
        mysqlDS.setUrl(properties.getProperty("MYSQL_URL"));
        mysqlDS.setUser(properties.getProperty("MYSQL_USERNAME"));
        mysqlDS.setPassword(properties.getProperty("MYSQL_PASSWORD"));
        mysqlDS.setAutoReconnect(true);
        mysqlDS.setUseSSL(false);
        mysqlDS.setServerTimezone("UTC");
        return mysqlDS;
    }

    public void loadScript(String scriptName) {
        try {
            Connection connection = dataSource.getConnection();
            ScriptRunner runner = new ScriptRunner(connection, false, true);
            runner.runScript(new BufferedReader(new FileReader(scriptName)));
            dataSource.getConnection().close();
        } catch (Exception e) {
            throw new ApplicationException("Failed to start the DB", e);
        }
    }

    public void stopDb() {
        if (dataSource != null) {
            try {
                dataSource.getConnection().close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}