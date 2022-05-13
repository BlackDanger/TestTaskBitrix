package tests;

import extensions.Config;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;
import pages.TasksPage;

public class BitrixTest extends TestBase{
    SoftAssert softAssert = new SoftAssert();
    public MainPage mainPage;
    public TasksPage tasksPage;
    @BeforeMethod
    public void beforeEach(){
        mainPage = new MainPage();
        tasksPage = new TasksPage();
    }

    @Test
    public void taskFunctionalTest() {
        mainPage.russianLangChoose()
                .enterLogin(Config.get().login())
                .nextButtonClick()
                .enterPassword(Config.get().password())
                .nextButtonClick()
                .goToBitrixButton()
                .menuSwitcherClick()
                .choosingFilterIfItIsEmpty()
                .addTaskButtonClick()
                .setTaskButtonClick();
        softAssert.assertTrue(tasksPage.errorMessageIsDisplayed(),"Сообщение об ошибке 'Не указано название задачи' не отобразилось");
        tasksPage.enterTasksName("Задача 1")
                .setTaskButtonClick();
        softAssert.assertTrue(tasksPage.taskWasAdded(), "Задача 1 не отобразилась в таблице задач");
        tasksPage.addTaskButtonClick()
                .enterTasksName("Задача 2")
                .setAndAddTaskButtonClick();
        softAssert.assertTrue(tasksPage.successMessageIsDisplayed(), "Сообщение 'Задача сохранена. Посмотреть' не отобразилось");
        tasksPage.cancelButtonClick();
        softAssert.assertTrue(tasksPage.taskWasAdded(), "Задача 2 не отобразилась в таблице задач");
        tasksPage.chooseAllCheckBoxClick()
                .confirmButtonClick()
                .chooseActionDropDownClick()
                .deleteElementDropDownClick()
                .applyButtonClick()
                .continueButtonClick();
        softAssert.assertTrue(tasksPage.createTaskMessageIsDisplayed(), "Сообщение 'Создайте задачу' не отобразилось");
        softAssert.assertAll();

    }
}
