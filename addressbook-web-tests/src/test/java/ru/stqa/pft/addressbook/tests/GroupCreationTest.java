package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.gotoGroupPage();
    app.initialGroupCreation();
    app.fillGroupForm(new GroupData("StartGroup1", "textHeader", "textFooter"));
    app.submitForm();
    app.returnToGroupPage();
    app.logout();
  }


}
