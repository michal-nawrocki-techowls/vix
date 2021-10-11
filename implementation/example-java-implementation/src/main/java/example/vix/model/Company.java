package example.vix.model;

public class Company {

    private String token;
    private String name;
    private Integer tokenTtlInDays;
    private String dirName;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTokenTtlInDays() {
        return tokenTtlInDays;
    }

    public void setTokenTtlInDays(Integer tokenTtlInDays) {
        this.tokenTtlInDays = tokenTtlInDays;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }
}
