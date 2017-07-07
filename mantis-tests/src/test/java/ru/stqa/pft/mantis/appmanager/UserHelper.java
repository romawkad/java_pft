package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by RomanovaD on 06.07.2017.
 */
public class UserHelper extends HelperBase {

    public UserHelper(ApplicationManager app) {
        super(app);
    }

    public void loginAdmin() {
        wd.get(app.getProperty("web.baseURL") + "/login_page.php");
        type(By.name("username"), app.getProperty("web.adminLogin"));
        type(By.name("password"), app.getProperty("web.adminPassword"));
        click(By.cssSelector("input[value='Войти']"));
    }

    public void selectById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']", id))).click();
    }

    public void resetPassword(){
        click(By.cssSelector("input[value='Сбросить пароль']"));
    }

    public void changePassword(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Изменить учетную запись']"));
    }

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Изменить учетную запись']"));
    }

}
