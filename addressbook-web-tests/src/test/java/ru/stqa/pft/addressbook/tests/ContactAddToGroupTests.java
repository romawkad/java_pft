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
public class ContactAddToGroupTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withName("test_name").withSurname("test_surname").withAddress("test_address"));
        }

        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test_group").withHeader("test_header").withFooter("test_footer"));
        }
    }

    @Test
    public void testAddContactToGroup() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = new ContactData();
        GroupData group = new GroupData();
        if (before.stream().anyMatch((c) -> c.getGroups().size() < app.db().groups().size())) {
            modifiedContact = before.stream().filter((c) -> c.getGroups().size() < app.db().groups().size()).iterator().next();
            Groups contactGroups = modifiedContact.getGroups();
            if (modifiedContact.getGroups().size() == 0) {
                group = app.db().groups().iterator().next();
            } else {
                Groups groups = app.db().groups();
                for (GroupData g : contactGroups) {
                    groups = groups.without(g);
                }
                group = groups.iterator().next();
            }
        } else if (before.stream().anyMatch((c) -> c.getGroups().size() == app.db().groups().size())) {
            modifiedContact = before.stream().filter((c) -> c.getGroups().size() == app.db().groups().size()).iterator().next();
            group = modifiedContact.getGroups().iterator().next();
            app.contact().removeFromGroup(modifiedContact, group);

        }
        app.goTo().homePage();
        app.contact().addToGroup(modifiedContact, group);
        ContactData contact = modifiedContact.inGroup(group);
        assertEquals(app.contact().count(), before.size());
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
        }
    }

