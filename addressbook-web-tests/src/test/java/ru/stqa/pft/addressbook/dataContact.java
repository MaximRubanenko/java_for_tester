package ru.stqa.pft.addressbook;

public class dataContact {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String title;
  private final String company;
  private final String workPhone;
  private final String email;

  public dataContact(String firstname, String middlename, String lastname, String title, String company, String workPhone, String email) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.title = title;
    this.company = company;
    this.workPhone = workPhone;
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

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getEmail() {
    return email;
  }
}
