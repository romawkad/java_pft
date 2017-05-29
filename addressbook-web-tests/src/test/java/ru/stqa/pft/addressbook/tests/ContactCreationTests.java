package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().createContact(new ContactData("Петр", "Петрович", "Петров",  "г.Москва, ул. Автозаводская, д.23 ", "+74951111111", "+79153456734", "+74956786352", "petrov@mail.ru", "test1"));
    }

}
