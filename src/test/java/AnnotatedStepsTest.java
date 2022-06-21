import org.junit.jupiter.api.Test;

class AnnotatedStepsTest extends TestBase{

    @Test
    void debitCardTest() {
        WebSteps steps = new WebSteps();

        steps.openDebitCardPage();
        steps.clickOnCardPreferences();
        steps.chooseClassicAndSubmit();
        steps.checkFirstCardOnPage();
    }
}
