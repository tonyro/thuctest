package my.corp;

import my.corp.requirements.Clinovo;
import my.corp.steps.ClinovoUserSteps;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@Story(Clinovo.Login.UserLogin.class)
@RunWith(ThucydidesRunner.class)
public class LoginTest {
	
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://jenkins.clinovo.com/clincapture/")
    public Pages pages;

    @Steps
    public ClinovoUserSteps clinovoUser;
    
    @Test
    @Issue("#406")
    @Title("The user creates new Rule.")
    @WithTag("scope:smoke")
    public void log_in_to_clincapture() {
    	clinovoUser.is_on_login_page();
    	clinovoUser.enters_credentials("root", "Password.001");
    	clinovoUser.clicks_login_button();
    	clinovoUser.should_see_task_menu();
    	clinovoUser.go_to_rules_studio();
    	clinovoUser.create_new_rule();
    }

    
    @Pending @Test
    @WithTag("scope:regression")
    public void loging_in_to_clincapture_with_incorrect_login() {
    }
    
    @Pending @Test
    @WithTag("scope:regression")
    public void loging_in_to_clincapture_with_incorrect_password() {
    }
    
    @Pending @Test
    @WithTag("scope:regression")
    public void create_new_rule () {
    	log_in_to_clincapture();
    	clinovoUser.go_to_rules_studio();
    }
}
