package ru.stqa.pft.addressbook.tests.tests;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.tests.model.GroupData;


public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
    gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }
  private void gotoGroupPage() {
  }
}
