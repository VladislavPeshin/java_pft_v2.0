package ru.stqa.pft.addressbook.tests.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.tests.model.ContactData;
import ru.stqa.pft.addressbook.tests.model.GroupData;

import java.util.List;

import static org.hibernate.boot.registry.StandardServiceRegistryBuilder.destroy;

public class HbConnectionTest {
  private SessionFactory sessionFactory;

  @BeforeClass
  protected void setUp() throws Exception {

    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    try {
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    catch (Exception e) {
      e.printStackTrace();
      destroy( registry );
    }
  }

  @Test
  public void testHbConnection(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List <ContactData> result = session.createQuery( "from ContactData where deprecated = '0000-00-00 00:00:00'").list();
    session.getTransaction().commit();
    session.close();
    for ( ContactData contact : result ) {
      System.out.println(contact.getGroups());
    }

  }
}
