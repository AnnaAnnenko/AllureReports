package qa.annenko;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 81;

    @Test
    public void lambdaFoundTest() {

        step("Открываем главную страницу gitHub", () -> {
                    open("https://github.com");
                }
        );
        step("Вводим в поисковую строку " + REPOSITORY, () -> {
                    $("[data-test-selector='nav-search-input']").click();
                    $("[data-test-selector='nav-search-input']").sendKeys("eroshenkoam/allure-example");
                    $("[data-test-selector='nav-search-input']").pressEnter();
                }
        );
        step("Кликаем по репозиторию " + REPOSITORY, () -> {
                    $(By.linkText("eroshenkoam/allure-example")).click();
                }
        );
        step("Переходим на вкладку Issue", () -> {
                    $("#issues-tab").click();
                }
        );
        step("Проверяем, что есть Issue под номером " + ISSUE, () -> {
                    $(withText("#81")).should(Condition.exist);
                }
        );
    }
}