package org.macnss.entity;

import java.util.Date;

public class EmployeeHistory {
    private Date date;
    private float salaire;
    private int numberOfJour;
    private Company company;
    private Employee employee;

    public EmployeeHistory(Date date, float salaire, int numberOfJour) {
        this.date = date;
        this.salaire = salaire;
        this.numberOfJour = numberOfJour;
    }
    public EmployeeHistory(){

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    public int getNumberOfJour() {
        return numberOfJour;
    }

    public void setNumberOfJour(int numberOfJour) {
        this.numberOfJour = numberOfJour;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
