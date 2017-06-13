package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test (enabled = false)
    public void testContactModification() {
        app.goTo().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Петр", "Петрович", "Петров",  "г.Москва, ул. Автозаводская, д.23 ", "+74951111111", "+79153456734", "+74956786352", "petrov@mail.ru", null));
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactModification(before.size() - 1);
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(),"Катя", "Вованович", "Пупкин", "г.Москва, ул. Нагатинская, д.1 ", "+74952222222", "+79153333333", "+74954444444", "ivanovich@mail.ru", null );
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }
}
