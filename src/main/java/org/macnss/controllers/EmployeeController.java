package org.macnss.controllers;

import org.macnss.Enum.Status;
import org.macnss.Services.EmployeeService;
import org.macnss.entity.Company;
import org.macnss.entity.Employee;
import org.macnss.helpers.UniqueCodeGenerator;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.concurrent.TimeUnit;

public class EmployeeController extends  Controller{
        private final EmployeeService employeeService = new EmployeeService();


        Employee employee = new Employee();
        public void saveEmployee() throws ParseException, SQLException {
            System.out.println("Form add Employee");
            System.out.println("Enter firstName : ");
            System.out.print("-> ");
            String fistName = scanner.next();
            System.out.println("Enter lastName : ");
            System.out.print("-> ");
            String lastName = scanner.next();
            System.out.println("Enter salaire : ");
            System.out.print("-> ");
            int salaire = scanner.nextInt();
            System.out.println("Enter birthday (yyyy-MM-dd) : ");
            System.out.print("-> ");
            String birthday = scanner.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = dateFormat.parse(birthday);
            Date covertDate = new Date(date.getTime());
            Date dateNow = new Date(System.currentTimeMillis());
            long birthdayMs = covertDate.getTime();
            long date_now = dateNow.getTime();
            long timeDeff = Math.abs(date_now - birthdayMs);
            long daysDeff = TimeUnit.DAYS.convert(timeDeff,TimeUnit.MILLISECONDS);


            employee.setMatricule(UniqueCodeGenerator.code());
            employee.setFirstName(fistName);
            employee.setLastName(lastName);
            employee.setBirthday(covertDate);
            employee.setSalaire(salaire);
            Company company = new Company();
            employee.setCompany(company);
            if (daysDeff >= 20075){
                String retraite = String.valueOf(Status.RETRAITE);
                employee.setStatus(Status.valueOf(retraite));
            }else {
                String non_retraite = String.valueOf(Status.NON_RETRAITE);
                employee.setStatus(Status.valueOf(non_retraite));
            }
            if (employeeService.createEmployee(employee) != null){
                System.out.println("employee added success");
            }else {
                System.out.println("employee not added");
            }

        }
}
