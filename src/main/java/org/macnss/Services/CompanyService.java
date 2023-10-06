package org.macnss.Services;

import org.macnss.dao.impl.CompanyDAO;
import org.macnss.entity.Company;

public class CompanyService {
    CompanyDAO companyDAO = new CompanyDAO();
    public Company register(Company company){
        if (companyDAO.register(company) != null){
            return company;
        }else
        return null;
    }
    public Company login(String email, String password){
        Company company = companyDAO.login(email, password);
        if (company != null){
            return company;
        }else {
            return null;
        }
    }
}
