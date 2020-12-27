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
    this.id = 0;
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

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    if (meddleName != null ? !meddleName.equals(that.meddleName) : that.meddleName != null) return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
    if (title != null ? !title.equals(that.title) : that.title != null) return false;
    if (address != null ? !address.equals(that.address) : that.address != null) return false;
    if (company != null ? !company.equals(that.company) : that.company != null) return false;
    return group != null ? group.equals(that.group) : that.group == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (meddleName != null ? meddleName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (company != null ? company.hashCode() : 0);
    result = 31 * result + (group != null ? group.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }
}
