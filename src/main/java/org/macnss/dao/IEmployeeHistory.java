package org.macnss.dao;

import org.macnss.Database.Database;
import org.macnss.entity.EmployeeHistory;

import java.sql.Connection;

public interface IEmployeeHistory extends DAO<EmployeeHistory> {
    Connection connection = Database.getConnection();
    public EmployeeHistory insert(EmployeeHistory employeeHistory,String companyId,String employeeId);
    public void calcRetraite(EmployeeHistory employeeHistory);
}
