package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.TestBase;

import static com.codeborne.selenide.Selenide.*;

public class TasksPage extends TestBase {
    private final SelenideElement filterInWork = $x("//div[text()='В работе']");
    private final SelenideElement filterField = $("#TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N_search_container");
    private final SelenideElement inWorkTitle = $x("//span[@title='В работе']");
    private final SelenideElement addTaskButton = $("#tasks-buttonAdd");
    private final SelenideElement setTaskButton = $x("//button[@data-bx-id='task-edit-submit'  and (normalize-space(translate(text(),' ', ' ')) = 'Поставить задачу')]");
    private final SelenideElement errorMessage = $x("//div[contains(concat(' ',@class,' '), ' error ')]");
    private final SelenideElement tasksName = $x("//input[@data-bx-id='task-edit-title']");
    private final ElementsCollection tasks = $$x("//a[contains(concat(' ',@class,' '), ' task-title ')]");
    private final SelenideElement setAndAddTaskButton = $x("//button[contains(text(),'и создать еще')]");
    private final SelenideElement successMessage = $x("//div[contains(text(),'Задача сохранена.')]");
    private final SelenideElement cancelButton = $x("//a[@data-bx-id='task-edit-cancel-button']");
    private final SelenideElement chooseAllCheckBox = $x("//label[contains(concat(' ',@title,' '), ' Применить действие для всех записей в списке ')]");
    private final SelenideElement chooseActionDropDown = $("#action_button_TASKS_GRID_ROLE_ID_4096_0_ADVANCED_N_control");
    private final SelenideElement deleteElementDropDown = $x("//span[@data-value='delete']");
    private final SelenideElement applyButton = $("#apply_button_control");
    private final SelenideElement confirmButton = $x("//span[text()='Подтвердить']");
    private final SelenideElement continueButton = $x("//span[text()='Продолжить']");
    private final SelenideElement createTaskMessage = $x("//div[text()='Создайте задачу']");


    String taskName;
    WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), 4);


    public TasksPage choosingFilterIfItIsEmpty(){
        if (!filterInWork.isDisplayed()) {
            filterField.click();
            inWorkTitle.click();
        }
        return this;
    }

    public TasksPage addTaskButtonClick(){
        addTaskButton.click();
        frameSwitch(0);
        return this;
    }

    public TasksPage setTaskButtonClick(){
        setTaskButton.click();
        frameSwitch(1);
        return this;
    }

    public boolean errorMessageIsDisplayed(){
        frameSwitch(0);
        return errorMessage.isDisplayed();
    }

    public TasksPage enterTasksName(String taskName){
        this.taskName = taskName;
        tasksName.sendKeys(taskName);
        return this;
    }

    public boolean taskWasAdded(){
        wait.until(ExpectedConditions.visibilityOf(tasks.get(0)));
        int ind = tasks.indexOf(tasks.stream().
                filter(x->x.getText().equals(taskName))
                .findAny()
                .orElse(null));
        SelenideElement neededTask = tasks.get(ind);
        return neededTask.exists();
    }

    public TasksPage setAndAddTaskButtonClick(){
        setAndAddTaskButton.click();
        frameSwitch(1);
        return this;
    }

    public boolean successMessageIsDisplayed(){
        frameSwitch(0);
        return successMessage.isDisplayed();
    }

    public TasksPage cancelButtonClick(){
        cancelButton.click();
        frameSwitch(1);
        return this;
    }

    public TasksPage chooseAllCheckBoxClick(){
        chooseAllCheckBox.click();
        return this;
    }

    public TasksPage chooseActionDropDownClick(){
        chooseActionDropDown.click();
        return this;
    }

    public TasksPage deleteElementDropDownClick(){
        deleteElementDropDown.click();
        return this;
    }

    public TasksPage applyButtonClick(){
        applyButton.click();
        return this;
    }

    public TasksPage confirmButtonClick(){
        confirmButton.click();
        return this;
    }

    public TasksPage continueButtonClick(){
        continueButton.click();
        return this;
    }

    public boolean createTaskMessageIsDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(createTaskMessage));
        return createTaskMessage.isDisplayed();
    }

    public void frameSwitch(int choice){
        switch (choice) {
            case (0):
                wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt($x("//iframe[@class='side-panel-iframe']")));
                break;
            case (1):
                switchTo().parentFrame();
                break;
        }
    }
}
