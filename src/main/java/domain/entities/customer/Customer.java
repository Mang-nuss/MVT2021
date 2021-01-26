package domain.entities.customer;


public class Customer {
    private int Id;
    private String UserName;
    private String Password;
    private String CustomerNumber;

    public Customer() {
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public void setCustomerNumber(String customerNumber) {
        CustomerNumber = customerNumber;
    }

    public String getCustomerNumber() {
        return CustomerNumber;
    }
}
