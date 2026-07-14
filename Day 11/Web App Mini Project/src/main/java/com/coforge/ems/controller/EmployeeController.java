package com.coforge.ems.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.coforge.ems.exception.InvalidEmployeeObjectException;
import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;
import com.coforge.ems.util.ApplicationProperties;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

	private EmployeeService service = new EmployeeService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String eidParam = request.getParameter("eid");
		response.setContentType("text/plain");

		if (eidParam != null && !eidParam.trim().isEmpty()) {
			try {
				int eid = Integer.parseInt(eidParam);
				Employee employee = service.findEmployee(eid);
				if (employee != null) {
					response.getWriter().write(employee.getEname() + " " + employee.getEsalary() + " " + employee.getDno());
				} else {
					response.getWriter().write("NOT_FOUND");
				}
			} catch (NumberFormatException e) {
				response.getWriter().write("INVALID_ID");
			} catch (Exception e) {
				response.getWriter().write("DB_ERROR");
			}
		} else {
			response.getWriter().write("INVALID_ID");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("emsButton");
		
		int eid = 0;
		String ename = "";
		int esalary = 0, dno = 0;
		Employee employee = null;
		String result = "";
		
		switch(action) {
		case "Insert":
			eid = Integer.parseInt(request.getParameter("eid"));
			ename = request.getParameter("ename");
			esalary = Integer.parseInt(request.getParameter("esalary"));
			dno = Integer.parseInt(request.getParameter("dno"));
			employee = new Employee(eid, ename, esalary, dno);
			try {
				int n = service.createEmployee(employee);
				if(n == 1) {
					result = ApplicationProperties.insertSuccess;
				}
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.dbFailed;
			} catch (SQLException e) {
				result = ApplicationProperties.dbFailed;
			} catch (InvalidEmployeeObjectException e) {
				result = ApplicationProperties.validationFailed;
			}
			
			response.sendRedirect("index.jsp?result="+result);
			break;
		case "Update":
			eid = Integer.parseInt(request.getParameter("eid"));
			ename = request.getParameter("ename");
			esalary = Integer.parseInt(request.getParameter("esalary"));
			dno = Integer.parseInt(request.getParameter("dno"));
			employee = new Employee(eid, ename, esalary, dno);
			try {
				int n = service.updateEmployee(employee);
				if(n == 1) {
					result = ApplicationProperties.updateSuccess;
				}
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.dbFailed;
			} catch (SQLException e) {
				result = ApplicationProperties.dbFailed;
			} catch (InvalidEmployeeObjectException e) {
				result = ApplicationProperties.validationFailed;
			}
			response.sendRedirect("index.jsp?result="+result);
			break;
		case "Delete":
			eid = Integer.parseInt(request.getParameter("eid"));
			try {
				int n = service.deleteEmployee(eid);
				if(n == 1) {
					result = ApplicationProperties.deleteSuccess;
				}
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.dbFailed;
			} catch (SQLException e) {
				result = ApplicationProperties.dbFailed;
			} catch (InvalidEmployeeObjectException e) {
				result = ApplicationProperties.validationFailed;
			}
			response.sendRedirect("index.jsp?result="+result);
			break;
		case "Find":
			eid = Integer.parseInt(request.getParameter("eid"));
			try {
				employee = service.findEmployee(eid);
				if(employee != null) {
					result = employee.toString();
				} else {
					result = ApplicationProperties.noRecordFound;
				}
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.dbFailed;
			} catch (SQLException e) {
				result = ApplicationProperties.dbFailed;
			} catch (InvalidEmployeeObjectException e) {
				result = ApplicationProperties.validationFailed;
			}
			response.sendRedirect("index.jsp?result="+result);
			break;
		case "FindAll":
			try {
				List<Employee> employees = service.findAllEmployee();
				result = employees.toString();
			} catch (ClassNotFoundException e) {
				result = ApplicationProperties.dbFailed;
			} catch (SQLException e) {
				result = ApplicationProperties.dbFailed;
			}
			response.sendRedirect("index.jsp?result="+result);
			break;
		}
	}

}
