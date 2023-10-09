package org.macnss.Services;

import org.macnss.dao.impl.EmployeeHistoryDAO;
import org.macnss.entity.EmployeeHistory;

import java.sql.SQLException;

public class EmployeeHistoryService {
    private final EmployeeHistoryDAO employeeHistoryDAO = new EmployeeHistoryDAO();
    public EmployeeHistory createHistory(EmployeeHistory employeeHistory,String companyId,String employeeId) throws SQLException {
        if (employeeHistoryDAO.insert(employeeHistory,companyId,employeeId) != null){
            return employeeHistory;
        } else return null;
    }
    public EmployeeHistory getHistory(String id) throws SQLException {
        EmployeeHistory employeeHistory = new EmployeeHistory();
        if (employeeHistoryDAO.get(id) != null){
            return employeeHistory;
        }
        return null;
    }
}
