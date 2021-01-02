package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;

public class EditPasswordHelper extends HelperBase{
  public EditPasswordHelper(ApplicationManager app) {
    super(app);
  }

  public void login(UserData user) {
    wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
    type(By.name("username"), user.getUsername());
    click(By.cssSelector("input[value='Войти']"));
    type(By.name("password"), user.getPassword());
    click(By.cssSelector("input[value='Войти']"));

  }
  public void change(int id){
    click(By.xpath("//a[@href='/mantisbt-2.24.2/manage_overview_page.php']"));
    click(By.xpath("//a[@href='/mantisbt-2.24.2/manage_user_page.php']"));
    click(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']", id)));
    click(By.cssSelector("input[value='Сбросить пароль']"));
  }


  public void finishChanges(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"), password);
    type(By.name("password_confirm"), password);
    wd.findElement(By.tagName("button")).click();
  }

}
