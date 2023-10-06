package org.macnss.controllers;

import org.macnss.Services.CompanyService;
import org.macnss.entity.Admin;
import org.macnss.entity.Company;
import org.macnss.helpers.UniqueCodeGenerator;

import java.sql.SQLException;
import java.text.ParseException;

public class CompanyController extends Controller{
    CompanyService companyService = new CompanyService();
    EmployeeController employeeController = new EmployeeController();
    public void index(){
        System.out.println("welcome to our space company ");
        System.out.println("1- register .");
        System.out.println("2- login .");
        System.out.print("-> ");
        int option  = scanner.nextInt();
        switch (option){
            case 1 -> this.register();
            case 2 -> this.login();
        }
    }
    public void register(){
        Company company = new Company();
        System.out.println("Register : ");
        System.out.println("enter name :");
        System.out.print("-> ");
        String name = scanner.next();
        System.out.println("enter email :");
        System.out.print("-> ");
        String email = scanner.next();
        System.out.println("enter password :");
        System.out.print("-> ");
        String password = scanner.next();
        company.setId(UniqueCodeGenerator.code());
        company.setName(name);
        company.setEmail(email);
        company.setPassword(password);
        if (companyService.register(company) != null){
            System.out.println("success register.");
        }else {
            System.out.println("access denied.");
        }


    }
    public void login(){
        System.out.println("Login : ");
        System.out.println("enter email :");
        System.out.print("-> ");
        String email = scanner.next();
        System.out.println("enter password :");
        System.out.print("-> ");
        String password = scanner.next();
        try {
            if(companyService.login(email,password) != null){
                System.out.println("company login successfully.");
                this.panel();
            }else {
                System.out.println("company not found .");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void panel() throws SQLException, ParseException {
        System.out.println("1- create employee.");
        System.out.println("2- update employee.");
        System.out.println("3- get employee.");
        System.out.println("4- get all employee.");
        System.out.println("5- delete employee.");
        int option = scanner.nextInt();
        switch (option){
            case 1 -> employeeController.saveEmployee();
        }
    }
}
