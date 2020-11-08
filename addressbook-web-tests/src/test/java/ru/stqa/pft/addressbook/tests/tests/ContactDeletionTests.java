package ru.stqa.pft.addressbook.tests.tests;


import org.testng.annotations.*;


public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    app.getNavigationHelper().gotoContactHome();
    app.getGroupHelper().selectContact();
    app.getGroupHelper().deleteSelectedContacts();
    app.getNavigationHelper().gotoContactHome();

  }

}
