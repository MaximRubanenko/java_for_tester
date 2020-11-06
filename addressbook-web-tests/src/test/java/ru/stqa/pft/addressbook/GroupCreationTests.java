package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests  extends TestBase{

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation("new");
    fillGroupForm(new GroupDate("Home2", "Home and Private contacts", "My houme contacts"));
    submitGroup("submit");
    showNewGroup("groups");
    logout("Logout");
  }

}
