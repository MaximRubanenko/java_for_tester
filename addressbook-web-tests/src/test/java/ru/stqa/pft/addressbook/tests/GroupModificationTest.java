package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreConditions() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("StartGroup1", null, null));
    }
  }

  @Test
  public void testGroupModification() {

    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "StartGroup100", "textHeader100", "textFooter100");
    app.getGroupHelper().modifyGroup(index, group);

    List<GroupData> after = app.getGroupHelper().getGroupList();

    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Assert.assertEquals(before, after);
  }


}
