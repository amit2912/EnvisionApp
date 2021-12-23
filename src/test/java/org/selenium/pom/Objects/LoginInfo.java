package org.selenium.pom.Objects;

public class LoginInfo
{
    private String accID;
    public LoginInfo(String accID,String mailID,String passID)
    {
        this.accID=accID;
        this.mailID=mailID;
        this.passID=passID;
    }

    public LoginInfo() {
        
    }

    public String getAccID() {
        return accID;
    }

    public LoginInfo setAccID(String accID) {
        this.accID = accID;
        return this;
    }

    public String getEmailID() {
       return emailID;
    }

    public LoginInfo setEmailID(String emailID) {
       this.emailID = emailID;
       return this;
    }

    public String getPassID() {
        return passID;
    }

    public LoginInfo setPassID(String passID) {
        this.passID = passID;
        return this;
    }

    private String emailID;
    private String passID;

    public String getAccountID() {
       return accountID;
    }

    public LoginInfo setAccountID(String accountID) {
        this.accountID = accountID;
        return this;
    }

    public String getMailID() {
        return mailID;
    }

    public LoginInfo setMailID(String mailID) {
        this.mailID = mailID;
        return this;
    }

    private String accountID;
    private String mailID;

}
