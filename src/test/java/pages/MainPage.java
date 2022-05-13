package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends TestBase {
    private final SelenideElement loginField = $x("//input[@id='login']");
    private final SelenideElement passwordField = $x("//input[@type='password']");
    private final SelenideElement nextButton = $x("//button[@data-action='submit']");
    private final SelenideElement langLabel = $x("//span[@class = 'b24-network-auth-cover-lang-text']");
    private final SelenideElement russianLangSlot = $x("//span[text()='Русский' and @class = 'menu-popup-item-text']");
    private final SelenideElement goToBitrixButton = $x("//a[contains(concat(' ',@class,' '), ' b24network-profile-item-btn ')]");

    public MainPage enterLogin(String login){
        loginField.sendKeys(login);
        return this;
    }

    public MainPage enterPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public MainPage nextButtonClick(){
        nextButton.shouldBe(Condition.visible);
        nextButton.click();
        return this;
    }

    public MainPage russianLangChoose(){
        langLabel.click();
        russianLangSlot.click();
        return this;
    }

    public MyBitrixMainPage goToBitrixButton(){
        goToBitrixButton.click();
        return new MyBitrixMainPage();
    }

}
