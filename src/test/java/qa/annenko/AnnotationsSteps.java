package qa.annenko;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AnnotationsSteps {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 81;

    @Step("Открываем главную страницу GitHub")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("Вводим в поисковую строку " + REPOSITORY)
    public void searchOnMainPage() {
        $("[data-test-selector='nav-search-input']").click();
        $("[data-test-selector='nav-search-input']").sendKeys("eroshenkoam/allure-example");
        $("[data-test-selector='nav-search-input']").pressEnter();
    }
    @Step("Кликаем по репозиторию " + REPOSITORY)
    public void clickRepositoryInList() {
        $(By.linkText("eroshenkoam/allure-example")).click();
    }
    @Step("Открываем вкладку Issue")
    public void openPageIssue() {
        $("#issues-tab").click();
    }
    @Step("Проверяем наличие Issue с номером " + ISSUE)
    public void checkNumberOfIssue() {
        $(withText("#81")).should(Condition.exist);
    }
}