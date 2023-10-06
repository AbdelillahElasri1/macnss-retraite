package org.macnss.dao.impl;

import org.macnss.dao.ICompanyDAO;
import org.macnss.entity.Company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CompanyDAO implements ICompanyDAO {

    @Override
    public Company insert(Company company) throws SQLException {
        return null;
    }

    @Override
    public Company update(Company company) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String slag) throws SQLException {
        return false;
    }

    @Override
    public Company get(String id) throws SQLException {
        return null;
    }

    @Override
    public List<Company> getAll() throws SQLException {
        return null;
    }

    @Override
    public Company register(Company company) {
        String query = "INSERT INTO "+ TABLE +" (id,name,email,password) VALUES (?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,company.getId());
            preparedStatement.setString(2, company.getName());
            preparedStatement.setString(3, company.getEmail());
            preparedStatement.setString(4, company.getPassword());
            int row = preparedStatement.executeUpdate();
            if (row > 0){
                return company;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Company login(String email,String password) {
        Company company = new Company();
        String query = "SELECT * FROM " + TABLE + " WHERE email = ? AND password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()){
                company.setId(res.getString(ID));
                company.setName(res.getString(NAME));
                company.setEmail(res.getString(EMAIL));
                company.setPassword(res.getString(PASSWORD));
            } else {
                return null;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return company;
    }
}
