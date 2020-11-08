package ru.stqa.pft.addressbook.tests.tests;


import org.testng.annotations.*;


public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }
  private void gotoGroupPage() {
  }
}
