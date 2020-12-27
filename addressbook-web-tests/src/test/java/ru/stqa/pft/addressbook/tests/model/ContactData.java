package ru.stqa.pft.addressbook.tests.model;

public class ContactData {
  public int id;
  public final String name;
  public final String meddleName;
  public final String lastName;
  public final String nickname;
  public final String title;
  public final String address;
  public final String company;
  public final String group;

  public ContactData(String ivan, String name, String meddleName, String lastName, String nickname, String title, String address, String company, String group) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.meddleName = meddleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.address = address;
    this.company = company;
    this.group = group;
  }

  public ContactData(int id, String ivan, String name, String meddleName, String lastName, String nickname, String title, String address, String company, String group) {
    this.id = id;
    this.name = name;
    this.meddleName = meddleName;
    this.lastName = lastName;
    this.nickname = nickname;
    this.title = title;
    this.address = address;
    this.company = company;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }



  public String getMeddleName() {
    return meddleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getAddress() {
    return address;
  }

  public String getCompany() {
    return company;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    return name != null ? name.equals(that.name) : that.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
}
