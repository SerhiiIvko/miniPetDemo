//package com.softServe.ivko.web.servlet;
//
//import com.softServe.ivko.service.ManagerService;
//import com.softServe.ivko.service.ManagerServiceImpl;
//import com.softServe.ivko.validator.ManagerValidator;
//import com.softServe.ivko.validator.ManagerValidatorImpl;
//import com.softServe.ivko.web.dto.ManagerCreateDto;
//import org.junit.Test;
//import org.mockito.Mockito;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//
//public class ManagerServletTest extends Mockito {
//
//    @Test
//    public void testServlet() throws Exception {
//        HttpServletRequest request = mock(HttpServletRequest.class);
//        HttpServletResponse response = mock(HttpServletResponse.class);
//        StringWriter stringWriter = new StringWriter();
//        PrintWriter writer = new PrintWriter(stringWriter);
//
//        when(request.getParameter("name")).thenReturn("name");
//        when(request.getParameter("password")).thenReturn("password");
//        when(response.getWriter()).thenReturn(writer);
////        ManagerCreateDto managerCreateDto = new ManagerCreateDto("name", "surname", 25, "www@rr.com", "qqq");
//        ManagerCreateDto managerCreateDto = mock(ManagerCreateDto.class);
////        ManagerValidator validator = new ManagerValidatorImpl();
//        ManagerValidator validator = mock(ManagerValidatorImpl.class);
//        validator.validateManagerCredentials(managerCreateDto.getEmail(), managerCreateDto.getPassword(), true);
//        ManagerServlet managerServlet = mock(ManagerServlet.class);
//        ManagerService managerService = mock(ManagerServiceImpl.class);
//        managerService.registerManager(managerCreateDto);
//        managerServlet.doPost(request, response);
//
//        verify(request, atLeast(1)).getParameter("name");
//        writer.flush(); // it may not have been flushed yet...
////        assertTrue(stringWriter.toString().contains("My expected string"));
//    }
//}