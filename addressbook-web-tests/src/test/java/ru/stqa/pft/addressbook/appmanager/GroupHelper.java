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
    click(By.xpath("(//input[@name='selected[]'])"));
  }

  public void initGroupModification() {
    click(By.xpath("(//input[@name='edit'])"));
  }

  public void submitGroupModification() {
    click(By.xpath("(//input[@name='update'])"));
  }

  public void createGroup(GroupData group) {
    initialGroupCreation();
    fillGroupForm(group);
    submitGroupForm();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getGroupCount() {
  return wd.findElements(By.name("selected[]")).size();

  }
}
