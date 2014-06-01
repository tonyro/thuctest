package my.corp.steps;

import my.corp.pages.LoginPage;
import my.corp.pages.ManageRulesPage;
import my.corp.pages.RuleDesignerPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import static org.fest.assertions.Assertions.assertThat;

public class ClinovoUserSteps extends ScenarioSteps {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4917738550746893596L;

	public ClinovoUserSteps(Pages pages) {
		super(pages);
	}

	private LoginPage loginPage;
	private ManageRulesPage manageRulesPage;

    private LoginPage onLoginPage() {
        return getPages().get(LoginPage.class);
    }
    private ManageRulesPage onManageRulesPage() {
        return getPages().get(ManageRulesPage.class);
    }
    private RuleDesignerPage onRuleDesignerPage() { return getPages().get(RuleDesignerPage.class); }

    
    @Step
    public void enters_credentials(String login, String password) {
        onLoginPage().enter_login_name(login);
        onLoginPage().enter_password(password);
    }
    
    @Step
    public void clicks_login_button() {
        onLoginPage().click_login_button();
    }
    
    @Step
    public void is_on_login_page() {
        onLoginPage().open();
    }

    @Step
    public void login_to_cc(String login, String password) {
        is_on_login_page();
        enters_credentials(login, password);
        clicks_login_button();
        should_see_task_menu();
    }
    
    @Step
    public void should_see_task_menu() {
    	assertThat(onManageRulesPage().task_menu_is_visible()).isTrue();
    }
    
    @Step
    public void go_to_rules_studio() {
        onManageRulesPage().go_to_rules_studio();
        onManageRulesPage().click_create_rule_button();
        onRuleDesignerPage().verify_studies_tab();
    }

    @Step
    public void navigate_through_tabs(String study, String event, String crf, String crfVersion) {
        onRuleDesignerPage().click_on_study(study);
        onRuleDesignerPage().verify_events_tab();
        onRuleDesignerPage().click_on_event(event);
        onRuleDesignerPage().verify_crfs_tab();
        onRuleDesignerPage().click_on_crf(crf);
        onRuleDesignerPage().verify_crf_versions_tab();
        onRuleDesignerPage().click_on_crf_version(crfVersion);
        onRuleDesignerPage().verify_items_tab();
    }

    @Step
    public void build_expression(String...itemNames) {
        onRuleDesignerPage().drag_n_drop_from_items_to_expression_area(itemNames);
    }
    
    @Step
    public void create_new_rule() {
        onManageRulesPage().click_create_rule_button();
        onRuleDesignerPage().verify_studies_tab();
       /* onManageRulesPage().enter_rule_name();
        onManageRulesPage().check_dde_rule();
        onManageRulesPage().check_send_email_action();
        onManageRulesPage().enter_email_address();
        onManageRulesPage().enter_email_message();
        onRuleDesignerPage().drag_n_drop_text_tile();
        assertThat(onRuleDesignerPage().is_text_data_available()).isTrue();
        */
    }
}
