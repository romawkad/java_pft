package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withName("Катя").withSurname("Петровна").withAddress("Адрес1").withGroup("test1").withMail("pupkin@mail.ru")
                .withHomePhone("+74951111111").withMobilePhone("+79153467896").withWorkPhone("+74952222222");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test
    public void testBadContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withName("Катя").withSurname("Петровна").withAddress("Адрес1").withGroup("test1").withMail("pupkin@mail.ru").withMobilePhone("+79153467896");    //.withLastname("Петров").withAddress("Адрес1").withMobilePhone("+7111111111").withMail("petrov@mail.ru");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(app.contact().count(), equalTo(before.size()));
        assertThat(after, equalTo(before));
    }

}
