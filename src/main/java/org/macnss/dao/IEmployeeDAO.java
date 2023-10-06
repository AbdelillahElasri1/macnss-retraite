package org.macnss.dao;

import org.macnss.Database.Database;
import org.macnss.entity.Employee;

import java.sql.Connection;
import java.util.Date;

public interface IEmployeeDAO extends DAO<Employee> {
    Connection connection = Database.getConnection();
    final String MATRICULE = "matricule";
    final String FIRSTNAME = "firstName";
    final String LASTNAME = "lastName";
    final String BIRTHDAY = "birthday";
    final String SALAIRE = "salaire";
    final String STATUS = "status";
}
