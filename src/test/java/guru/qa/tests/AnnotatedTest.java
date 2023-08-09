package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.steps.WebStepsSavina;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


public class AnnotatedTest extends TestBase {

    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final Integer ISSUE_NUMBER = 82;


    @Test
    public void testAnnotatedSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStepsSavina steps = new WebStepsSavina();

        // Здесь вызываются методы со спрятаннымми в них действиями из WebSteps
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }


}
