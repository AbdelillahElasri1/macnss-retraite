package org.macnss.Services;

import org.macnss.dao.impl.EmployeeDao;
import org.macnss.entity.Employee;

import java.sql.SQLException;

public class EmployeeService {
    private final EmployeeDao employeeDao = new EmployeeDao();
    public Employee createEmployee(Employee employee) throws SQLException {
        if (employeeDao.insert(employee) != null){
            return employee;
        }else {
            return null;
        }
    }
}
