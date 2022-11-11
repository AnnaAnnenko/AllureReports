package qa.annenko;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotationsFoundTest {

    AnnotationsSteps step = new AnnotationsSteps();

    @Test
    @Feature("Issue в репозитории")
    @Story("Создать issue")
    @Owner("Abramova")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверить название issue – тест с аннотацией @Step")
    public void checkIssueNumber() {
        step.openMainPage();
        step.searchOnMainPage();
        step.clickRepositoryInList();
        step.openPageIssue();
        step.checkNumberOfIssue();
    }
}
