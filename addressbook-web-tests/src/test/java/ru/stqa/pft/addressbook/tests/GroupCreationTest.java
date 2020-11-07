package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initialGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("StartGroup1", "textHeader", "textFooter"));
    app.getGroupHelper().submitGroupForm();
    app.getGroupHelper().returnToGroupPage();
    //app.sessionHelper.logout();
  }


}
