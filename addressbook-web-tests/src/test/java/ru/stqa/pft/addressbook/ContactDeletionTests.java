package ru.stqa.pft.addressbook;


import org.testng.annotations.*;


public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    gotoContactPage();
    gotoContactHome();
    selectContact();
    deleteSelectedContacts();
    gotoContactHome();

  }

}
