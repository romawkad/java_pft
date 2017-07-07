package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

/**
 * Created by RomanovaD on 06.07.2017.
 */
public class NavigationHelper extends HelperBase {

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    public void accountPage(){
        click(By.linkText("управление"));
    }

    public void manageUserPage() {
        click(By.linkText("Управление пользователями"));

    }
}
