package my.corp;

import my.corp.requirements.Clinovo;
import my.corp.steps.ClinovoUserSteps;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anton on 17.05.2014.
 */

@Story(Clinovo.RuleStudio.CreateNewRule.class)
@RunWith(ThucydidesRunner.class)
public class CreateNewRuleTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://jenkins.clinovo.com/clincapture/")
    public Pages pages;

    @Steps
    public ClinovoUserSteps clinovoUser;

    @Test
    public void createNewRuleNavigatingThroughTabs() {
        clinovoUser.login_to_cc("root", "Password.001");
        clinovoUser.go_to_rules_studio();
        clinovoUser.navigate_through_tabs("PRO", "Low Dose", "Procedure", "v.1");
        clinovoUser.build_expression("dtmStrokeOnset", "<", "Current date");
        // TODO Put clinovoUser.enter_rule_details(args) here
    }
}
