package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

// Пока не работает
public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {

    super(wd);
  }

  public void sumbitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData) {
    type("firstname", contactData.getFirstname());
    type("lastname", contactData.getLastname());
    type("email", contactData.getEmail());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContact() {
    click(By.id("10"));
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void initModifyContact() {
    click(By.xpath("//a[contains(@href,'edit.php?id=10')]"));
  }

  public void submitContactUpdate() {
    click(By.xpath("//input[22]"));
  }
}
