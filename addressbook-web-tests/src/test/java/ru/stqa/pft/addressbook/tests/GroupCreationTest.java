package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validGroup() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new GroupData().withGroupName("test1").withGroupHeader("header1").withGroupFooter("footer1")});
    list.add(new Object[] {new GroupData().withGroupName("test2").withGroupHeader("header2").withGroupFooter("footer2")});
    list.add(new Object[] {new GroupData().withGroupName("test3").withGroupHeader("header3").withGroupFooter("footer3")});

    return list.iterator();
  }

  @Test(dataProvider = "validGroup")
  public void testGroupCreation(GroupData group) {

    app.goTo().groupPage();
    Groups before = app.group().all();
    app.group().create(group);
    assertThat(app.group().count(), equalTo(before.size() + 1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }


}
