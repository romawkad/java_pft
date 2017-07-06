package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

/**
 * Created by RomanovaD on 03.07.2017.
 */
public class ContactRemoveFromGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test_group").withHeader("test_header").withFooter("test_footer"));
        }
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            GroupData group = app.db().groups().iterator().next();
            app.contact().create(new ContactData().withName("test_name").withSurname("test_surname")
                    .withAddress("test_address").inGroup(group));
        }
    }

    @Test
    public void testRemoveContactFromGroup() {
        Contacts contacts = app.db().contacts();
        ContactData modifiedContact;
        GroupData group;
        if (contacts.stream().anyMatch((c) -> c.getGroups().size() > 0)) {
            modifiedContact = contacts.stream().filter((c) -> c.getGroups().size() > 0).iterator().next();
            group = modifiedContact.getGroups().iterator().next();
        } else {
            modifiedContact = contacts.iterator().next();
            group = app.db().groups().iterator().next();
            app.contact().addToGroup(modifiedContact, group);
        }
        Groups before = modifiedContact.getGroups();
        app.goTo().homePage();
        app.contact().removeFromGroup(modifiedContact, group);
        Groups after = app.db().contactById(modifiedContact.getId()).getGroups();
        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(group)));
    }
}
