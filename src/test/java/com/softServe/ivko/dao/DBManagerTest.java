package com.softServe.ivko.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DBManagerTest {
    @Mock
    private DataSource dataSourceMock;
    @Mock
    private Connection connectionMock;
    @Mock
    private PreparedStatement preparedStatementMock;

    @Test
    public void getInstance() {
        DBManager firstInstance;
        DBManager secondInstance;
        firstInstance = DBManager.getInstance();
        secondInstance = DBManager.getInstance();
        Assert.assertEquals(firstInstance, secondInstance);
    }

    @Test
    public void getConnection() throws SQLException {
        when(dataSourceMock.getConnection()).thenReturn(connectionMock);
        when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
        verify(connectionMock, times(0)).prepareStatement(anyString());
        verify(connectionMock, times(0)).close();
    }
}