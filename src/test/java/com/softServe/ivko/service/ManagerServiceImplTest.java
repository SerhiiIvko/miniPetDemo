package com.softServe.ivko.service;

import com.softServe.ivko.converter.ManagerConverter;
import com.softServe.ivko.dao.ManagerDao;
import com.softServe.ivko.dao.ManagerDaoImpl;
import com.softServe.ivko.model.Manager;
import com.softServe.ivko.validator.ManagerValidator;
import com.softServe.ivko.validator.ManagerValidatorImpl;
import com.softServe.ivko.web.dto.ManagerCreateDto;
import com.softServe.ivko.web.dto.ManagerViewDto;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

public class ManagerServiceImplTest {
//    @Mock private ManagerDao managerDao = new ManagerDaoImpl();
//    @Mock private ManagerViewDto viewDto;
//    @Mock private ManagerCreateDto createDto;
//    @Mock private ManagerValidator managerValidator;
//    @Mock private ManagerConverter managerConverter;
//    @Mock private Manager manager;
//    private boolean create;

    @Test
    public void registerManager() {
//        create = true;
//        managerValidator = new ManagerValidatorImpl();
//        managerConverter = new ManagerConverter();
//        createDto = new ManagerCreateDto("Jimm", "Carry", 25, "jimm@co.uk", "111");
//        viewDto = new ManagerViewDto();
//        viewDto.setId(2L);
//        viewDto.setAge(25);
//        viewDto.setName("Jimm");
//        viewDto.setSurname("Carry");
//        viewDto.setEmail("jimm@co.uk");
//        managerValidator.validateManager(createDto, create);
//        manager = managerConverter.asManager(createDto);
//        manager = managerDao.create(manager);
//        ManagerViewDto viewDto1 = managerConverter.asManagerDto(manager);
//        Assert.assertEquals(viewDto, viewDto1);
    }

    @Test
    public void updateManager() {
    }

    @Test
    public void updateManagers() {
    }

    @Test
    public void deleteManager() {
    }

    @Test
    public void getAllManagers() {
    }

    @Test
    public void getManagerById() {
    }
}
//    @Mock private DataSource dataSourceMock;
//    @Mock private Connection connectionMock;
//    @Mock private PreparedStatement preparedStatementMock;
//    @Mock private Statement statementMock;
//    @Mock private ResultSet resultSetMock;
//    @Mock private Group groupMock;
//
//    private GroupDao groupDao;
//
//    public GroupDaoTest() {
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void nullAddThrowsException() {
//        // GIVEN:
//        try {
//            when(dataSourceMock.getConnection()).thenReturn(connectionMock);
//            groupDao = new GroupDao(dataSourceMock);
//            when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);
//
//            // WHEN:
//            groupDao.add(null);
//
//            // THEN
//            verify(connectionMock, times(0)).prepareStatement(anyString());
//            verify(connectionMock, times(0)).close();
//            verify(preparedStatementMock, times(0)).setInt(1, anyInt());
//            verify(preparedStatementMock, times(0)).setString(2, anyString());
//            verify(preparedStatementMock, times(0)).setTimestamp(3, anyObject());
//            verify(preparedStatementMock, times(0)).setString(4, anyString());
//            verify(preparedStatementMock, times(0)).executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }