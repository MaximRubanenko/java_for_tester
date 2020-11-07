package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    gotoGroupPage();
    initialGroupCreation();
    fillGroupForm(new GroupDAta("StartGroup1", "textHeader", "textFooter"));
    submitForm();
    returnToGroupPage();
    logout();
  }


}
