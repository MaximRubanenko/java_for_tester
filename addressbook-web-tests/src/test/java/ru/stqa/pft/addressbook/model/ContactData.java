package ru.stqa.pft.addressbook.model;

public class ContactData {
  private  String firstname;
  private  String middlename;
  private  String lastname;
  private  String email;



  public ContactData(String firstname, String middlename, String lastname, String email) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getEmail() {
    return email;
  }
  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

}
