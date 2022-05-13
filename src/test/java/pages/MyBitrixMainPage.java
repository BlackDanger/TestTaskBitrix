package pages;

import com.codeborne.selenide.SelenideElement;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.$;

public class MyBitrixMainPage extends TestBase {
    private final SelenideElement menuSwitcher = $("#menu-items-block");

    public TasksPage menuSwitcherClick(){
        menuSwitcher.click();
        return new TasksPage();
    }
}
