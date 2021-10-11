package example.vix.service;

import example.vix.model.Company;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "app.db")
public class CompanyService {

    private List<Company> companies;

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Company findOneByToken(String token) {
        return companies.stream().filter(c -> c.getToken().equals(token)).findFirst().orElse(null);
    }

}
