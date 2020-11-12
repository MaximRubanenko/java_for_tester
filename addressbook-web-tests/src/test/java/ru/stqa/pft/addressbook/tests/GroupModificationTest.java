package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTest extends TestBase {
  @Test
  public void testGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    if (app.getContactHelper().count("selected[]") > 0) {
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().initGroupModification();
      app.getGroupHelper().fillGroupForm(new GroupData("StartGroup100", "textHeader100", "textFooter100"));
      app.getGroupHelper().submitGroupModification();
      app.getGroupHelper().returnToGroupPage();
    } else  {
      Assert.fail("There are no Group to modification");
    }
  }
}
