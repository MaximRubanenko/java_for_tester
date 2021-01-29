package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;


public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {     super(wd);  }

  public void sumbitContactCreation() {
    click(By.xpath("(//input[@name='submit'])"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("home"),contactData.getHome());
    type(By.name("mobile"),contactData.getMobile());
    type(By.name("work"),contactData.getWork());
    type(By.name("email"),contactData.getEmail());
    type(By.name("email2"),contactData.getEmail2());
    type(By.name("email3"),contactData.getEmail3());
    type(By.name("address"),contactData.getAddress());
    type(By.name("address2"),contactData.getAddress2());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void deleteContact() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
    //Contacts contactCache = null;
  }

  public void delete(ContactData c) {
    selectContactById(c.getId());
    deleteContact();
    contactCache = null;
  }

  private void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void initModifyContact(int index) {
    click(By.xpath("//input[@id=" + index + "]/../../td[8]/a"));
    //click(By.xpath("//input[@id='%s' + index + '']/../../td[8]/a"));
  }

  public void submitContactUpdate() {
    click(By.name("update"));
    contactCache = null;
  }

  public boolean isThereAContact() {
    return !isElementPresent(By.name("selected[]"));
  }

  public void createContact(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    sumbitContactCreation();
    contactCache = null;
    returnToHomePage();
  }

  private void returnToHomePage() {
    click(By.linkText("home"));
  }
  private Contacts contactCache = null;

  public Contacts allContact() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));

    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      String lastname = cells.get(1).getText();
      String name = cells.get(2).getText();
      String[] emails = cells.get(4).getText().split("\n");
      String[] address = cells.get(3).getText().split("\n");
      String[] phones = cells.get(5).getText().split("\n");

//В кэш записывать значения не разбивая по полям
      contactCache.add(new ContactData().withId(id).withFirstname(name).withLastname(lastname)
              .withHomePhone(phones[0])
              .withMobilePhone(phones[1])
              .withWorkPhone(phones[2])
              .withEmail(emails[0])
              .withEmail2(emails[1])
              .withEmail3(emails[2])
              .withAddress(address[0])
          //    .withAddress2(address[1])
      );
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initModifyContact(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    //String address2 = wd.findElement(By.name("address2")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmail(email).withEmail2(email2)
            .withEmail3(email3).withAddress(address);
    //.withAddress2(address2);
  }
}
