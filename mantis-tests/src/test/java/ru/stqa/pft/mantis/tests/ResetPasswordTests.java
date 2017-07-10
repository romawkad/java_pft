package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

/**
 * Created by RomanovaD on 06.07.2017.
 */
public class ResetPasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testResetPassword() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        String password = String.format("password%s", now);
        app.user().loginAdmin();
        app.goTo().accountPage();
        app.goTo().manageUserPage();
        UserData user = app.db().users().stream().filter((u) -> !u.getUsername().equals("administrator")).iterator().next();
        app.user().selectById(user.getId());
        app.user().resetPassword();
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 20000);
        String confirmationLink = findConfirmationLink(mailMessages, user.getEmail());
        app.user().changePassword(confirmationLink, password);
        Assert.assertTrue(app.newSession().login(user.getUsername(), password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }
}
