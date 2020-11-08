package ru.stqa.pft.addressbook.tests.tests;


import org.testng.annotations.*;


public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    app.gotoContactPage();
    app.gotoContactHome();
    app.selectContact();
    app.deleteSelectedContacts();
    app.gotoContactHome();

  }

}
