package my.corp.pages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("http://jenkins.clinovo.com/clincapture/ViewRuleAssignment")
@At("http://jenkins.clinovo.com/clincapture/ViewRuleAssignment")
public class ManageRulesPage extends PageObject{
	
	@FindBy(name="createRule")
	private WebElementFacade bCreateRule;


    public ManageRulesPage(WebDriver driver) {
        super(driver);
    }
	
	public void click_create_rule_button() {
		bCreateRule.click();
	}
}
