package org.macnss.dao.impl;

import org.macnss.dao.IEmployeeDAO;
import org.macnss.entity.Employee;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDao implements IEmployeeDAO {
    @Override
    public Employee insert(Employee employee)  {
        String query = "INSERT INTO employee (matricule, firstName, lastName,birthday,status) VALUES (?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,employee.getMatricule());
            preparedStatement.setString(2,employee.getFirstName());
            preparedStatement.setString(3,employee.getLastName());
            preparedStatement.setDate(4, (Date) employee.getBirthday());
            preparedStatement.setString(5, String.valueOf(employee.getStatus()));
            int row = preparedStatement.executeUpdate();
            if (row > 0){
                return employee;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee update(Employee employee) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String slag) throws SQLException {
        return false;
    }

    @Override
    public Employee get(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        return null;
    }

}
