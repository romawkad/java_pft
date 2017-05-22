package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Петр", "Петрович", "Петров", "petrovich", "Мой контакт", "T-One", "г.Москва, ул. Автозаводская, д.23 ", "+74951111111", "+79153456734", "+74956786352", "+74956783245", "petrov1@mail.ru", "petrov2@mail.ru", "petrov3@mail.ru", "petrovich-home.ru", "1870", "Мой первый контакт", "г. Москва, ул.Ленина, д.5", "home-page.ru"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().returnToHomePage();
    }

}
