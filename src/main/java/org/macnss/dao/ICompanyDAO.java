package org.macnss.dao;

import org.macnss.Database.Database;
import org.macnss.entity.Company;

import java.sql.Connection;

public interface ICompanyDAO extends DAO<Company>{
    final Connection connection = Database.getConnection();
    final String TABLE = "companies";
    final String ID = "id";
    final String NAME = "name";
    final String EMAIL = "email";
    final String PASSWORD = "password";
    public Company register(Company company);
    public Company login(String email, String password);

}
