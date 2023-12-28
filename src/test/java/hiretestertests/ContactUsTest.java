package hiretestertests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsTest extends AbstractTest{


    @Test
    public void emailValidationTest(){
        String emailError = new ContactUsPage(driver).openContactUsPage()
                        .fillForm("Nadia", "email", "Some text message")
                        .getEmailError();
        Assert.assertEquals(emailError,"Your e-mail address must be in the following format: name@domain.com");

    }

    @Test
    public void captchaAppearingTest() {
        boolean isCaptcha = new ContactUsPage(driver).openContactUsPage()
                        .fillForm("Nadia", "tester234532@gmail.com", "Some text message")
                        .checkPrivacyPolicy()
                        .isCaptchaBlock();
        Assert.assertTrue(isCaptcha);
    }

}
