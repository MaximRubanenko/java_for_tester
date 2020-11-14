package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void sumbitContactCreation() {
//    click(By.xpath("(//input[@name='submit'])[2]"));
    click(By.xpath("(//input[@name='submit'])"));
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
      click(By.name("selected[]"));
   }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void initModifyContact() {
    click(By.cssSelector("img[alt='Edit']"));
  }

  public void submitContactUpdate() {
    click(By.name("update"));
  }
}
