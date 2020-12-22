package ru.stqa.pft.addressbook.tests.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.tests.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation()  {
    app.getNavigationHelper().gotoGroupPage("groups");
    app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
  }

}
