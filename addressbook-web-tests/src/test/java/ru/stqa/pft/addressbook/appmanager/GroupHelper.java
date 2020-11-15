package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.tests.GroupCreationTest;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupForm() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupDAta) {
    type("group_name", groupDAta.getGroupName());
    type("group_header", groupDAta.getGroupHeader());
    type("group_footer", groupDAta.getGroupFooter());
  }

  public void initialGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroup() {
    click(By.xpath("(//input[@name='delete'])"));
  }

  public void selectGroup() {
    if (! isElementPresent(By.name("selected[]"))) {
      System.out.println("Element does not present ****************************");
      CreateGroup();
    }
    click(By.xpath("(//input[@name='selected[]'])"));
  }

  public void initGroupModification() {
    click(By.xpath("(//input[@name='edit'])"));
  }

  public void submitGroupModification() {
    click(By.xpath("(//input[@name='update'])"));
  }

  public void CreateGroup() {
    initialGroupCreation();
    fillGroupForm(new GroupData("StartGroup1", "textHeader", "textFooter"));
    submitGroupForm();
    returnToGroupPage();
  }
}
