package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends AbstractPage{

    private final By userNameField = By.cssSelector("[name='name']");
    private final By emailField = By.cssSelector("[name='email']");
    private final By messageTextArea = By.cssSelector("[name='message']");
    private final By emailErrorMessage = By.cssSelector("[id='email-error']");
    private final By privacyPolicyCheckbox = By.cssSelector("[name='privacy-policy-agreement']");
    private final By captchaDiv = By.cssSelector("[class='footer__controls footer__controls_visible']");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsPage openContactUsPage(){
        driver.get("https://hire-tester.com/who-we-are/");
        return this;
    }

    public ContactUsPage fillForm(String name, String email, String textArea){
        driver.findElement(userNameField).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(messageTextArea).sendKeys(textArea);
        return this;
    }

    public ContactUsPage fillFormWait(String name, String email, String textArea){
        getElement(userNameField, 7).sendKeys(name);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(messageTextArea).sendKeys(textArea);
        return this;
    }

    public ContactUsPage checkPrivacyPolicy(){
        //driver.findElement(privacyPolicyCheckbox).click();
        clickJS(privacyPolicyCheckbox);
        return this;
    }

    public String getEmailError(){
        return driver.findElement(emailErrorMessage).getText();
    }

    public boolean isCaptchaBlock(){
        return driver.findElement(captchaDiv).isDisplayed();
    }


}
