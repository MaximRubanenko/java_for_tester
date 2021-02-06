package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreConditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withGroupName("StartGroup1"));
    }
  }

  @Test
  public void testGroupModification() {

    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId())
            .withGroupName("StartGroup100")
            .withGroupHeader("textHeader100")
            .withGroupFooter("textFooter100");
    app.group().modify(group);
    Groups after = app.group().all();
    Assert.assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.witout(modifiedGroup).withAdded(group)));

  }


}
