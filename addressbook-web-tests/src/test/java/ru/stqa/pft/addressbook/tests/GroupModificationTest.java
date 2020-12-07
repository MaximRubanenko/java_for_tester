package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreConditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withGroupName("StartGroup1"));
    }
  }

  @Test
  public void testGroupModification() {

    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    //GroupData group = new GroupData(before.get(index).getId(), "StartGroup100", "textHeader100", "textFooter100");
    GroupData group = new GroupData().withId(before.get(index).getId()).withGroupName("StartGroup100").
            withGroupHeader("textHeader100").withGroupFooter("textFooter100");
    app.group().modify(index, group);

    List<GroupData> after = app.group().list();

    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);
    Assert.assertEquals(before, after);
  }


}
