package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

  public GroupHelper(FirefoxDriver wd) {
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
}
