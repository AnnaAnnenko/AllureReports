package qa.annenko;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class ListenerTest {

    @Test
    public void listenerFoundTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $("[data-test-selector='nav-search-input']").click();
        $("[data-test-selector='nav-search-input']").sendKeys("eroshenkoam/allure-example");
        $("[data-test-selector='nav-search-input']").pressEnter();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $(withText("#81")).should(Condition.exist);
    }
}