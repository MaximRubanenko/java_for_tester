package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void sumbitContactCreation() {
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

  public void selectContact(int index) {
    //click(By.name("selected[]"));
    wd.findElements(By.name("selected[]")).get(index).click();
    //  wd.findElements(By.name("selected[]")).get(index).click();
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


  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    sumbitContactCreation();
    returnToHomePage();
  }

  private void returnToHomePage() {
    click(By.linkText("home"));
  }


  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));

    for (WebElement element : elements){
      List<WebElement> cells = element.findElements(By.tagName("td"));
      //int id = Integer.parseInt(element.findElement(By.tagName("td")).getAttribute("id"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String lastname = cells.get(1).getText();
      String name = cells.get(2).getText();
      contacts.add(new ContactData(id, name,null, lastname,null));
    }
    return contacts;
  }

  public void showContacts(List<ContactData> l) {
      for(ContactData c: l){
      System.out.println("id: "+ c.getId() + "Name: "+c.getFirstname()+ " Lastname: "+ c.getLastname());

    }
  }
}
