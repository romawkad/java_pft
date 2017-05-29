package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Иван", "Иванович", "Иванов", "г.Москва, ул. Нагатинская, д.1 ", "+74952222222", "+79153333333", "+74954444444", "ivanovich@mail.ru", null ), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().gotoHomePage();

    }
}
