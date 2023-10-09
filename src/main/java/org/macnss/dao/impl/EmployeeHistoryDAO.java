package org.macnss.dao.impl;

import org.macnss.dao.IEmployeeHistory;
import org.macnss.entity.EmployeeHistory;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeHistoryDAO implements IEmployeeHistory {
    @Override
    public EmployeeHistory insert(EmployeeHistory employeeHistory , String companyId,String employeeId) {
        String query = "INSERT INTO employeeHistory (matricule,company_id,date,salaire,numberOfJour) VALUES (?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,employeeId);
            preparedStatement.setString(2,companyId);
            preparedStatement.setDate(3, (Date) employeeHistory.getDate());
            preparedStatement.setFloat(4,employeeHistory.getSalaire());
            preparedStatement.setInt(5,employeeHistory.getNumberOfJour());
            int row = preparedStatement.executeUpdate();
            if (row > 0){
                return  employeeHistory;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void calcRetraite(EmployeeHistory employeeHistory) {

    }

    @Override
    public EmployeeHistory insert(EmployeeHistory employeeHistory) throws SQLException {
        return null;
    }

    @Override
    public EmployeeHistory update(EmployeeHistory employeeHistory) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String slag) throws SQLException {
        return false;
    }

    @Override
    public EmployeeHistory get(String id) throws SQLException {
        String query = "SELECT * FROM employeeHistory WHERE matricule = ?";
        EmployeeHistory employeeHistory = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Date date_created = resultSet.getDate("date");
                float salary = resultSet.getFloat("salaire");
                int numberOfDays = resultSet.getInt("numberOfJour");
                employeeHistory = new EmployeeHistory(date_created,salary,numberOfDays);
            }
        }
        return employeeHistory;
    }

    @Override
    public List<EmployeeHistory> getAll() throws SQLException {
        String query = "SELECT * FROM employeeHistory ";
        return null;
    }
}
