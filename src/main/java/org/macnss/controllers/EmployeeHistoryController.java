package org.macnss.controllers;

import org.macnss.Services.EmployeeHistoryService;
import org.macnss.dao.impl.EmployeeHistoryDAO;
import org.macnss.entity.EmployeeHistory;

import java.sql.Date;
import java.sql.SQLException;
import java.util.function.Supplier;

public class EmployeeHistoryController extends Controller{
    private final EmployeeHistoryService employeeHistoryService = new EmployeeHistoryService();
    private final EmployeeHistoryDAO employeeHistoryDAO = new EmployeeHistoryDAO();
    EmployeeHistory employeeHistory = new EmployeeHistory();
    public void saveHistory() throws SQLException {
        System.out.println("set details of employee :");
        System.out.println("enter employee matricule : ");
        System.out.print("-> ");
        String employeeMAtricule = scanner.next();
        System.out.println("enter company id : ");
        System.out.print("-> ");
        String company_id = scanner.next();
        System.out.println("enter salary of employee : ");
        System.out.print("-> ");
        float salary = scanner.nextFloat();
        System.out.println("enter number of days : ");
        System.out.print("-> ");
        int numberOfDays = scanner.nextInt();
        Date date_created = new Date(System.currentTimeMillis());
        employeeHistory.setSalaire(salary);
        employeeHistory.setNumberOfJour(numberOfDays);
        employeeHistory.setDate(date_created);
        employeeHistoryService.createHistory(employeeHistory,company_id,employeeMAtricule);
        System.out.println("employee details saved successfully.");
    }
    public void getHistory() throws SQLException {
        System.out.println("History of employee");
        System.out.println("enter the matricule of employee : ");
        System.out.print("-> ");
        String matricule = scanner.next();
        System.out.println("the history information of employee : ");
        EmployeeHistory employeeHistory1 = employeeHistoryDAO.get(matricule);
        if (employeeHistory1.getNumberOfJour() <= 3240){
            Supplier<Double> calculPrixRetaiteParMois = () ->
                    employeeHistory1.getSalaire() * (50 / 100.0);
            double prixRetaraiteParMois = calculPrixRetaiteParMois.get();
            System.out.println("the retraite price : " + prixRetaraiteParMois);
        }else if (employeeHistory1.getNumberOfJour() >= 7560){
            Supplier<Double> calculprixRetraiteParMois = () ->
                    employeeHistory1.getSalaire() * (70 / 100.0);
            double prixRetraiteParMois = calculprixRetraiteParMois.get();
            System.out.println("the retraite price : " + prixRetraiteParMois);
        }else {
            int nombreDeFoisDe216 = (employeeHistory1.getNumberOfJour()-3240)/216;
            Supplier<Double> calculprixRetraiteParMois = () ->
                    (double) (employeeHistory1.getSalaire() * nombreDeFoisDe216/100) + ((employeeHistory1.getSalaire()) / 2);

            double prixRetraiteParMois = calculprixRetraiteParMois.get();
            System.out.println("the retraite price : " + prixRetraiteParMois);
        }
    }
}
