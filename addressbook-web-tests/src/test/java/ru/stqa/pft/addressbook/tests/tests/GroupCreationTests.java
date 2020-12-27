package ru.stqa.pft.addressbook.tests.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.tests.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation()  {
    app.goTo().GroupPage("groups");
    List<GroupData> before = app.group().List();
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    List<GroupData> after = app.group().List();
    Assert.assertEquals(after.size(), before.size() + 1);

    //Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
