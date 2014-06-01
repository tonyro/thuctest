package my.corp.pages;

import net.thucydides.core.annotations.At;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;


public class LoginPage extends PageObject{
	
	@FindBy(id="username")
	private WebElementFacade login;
	
	@FindBy(id="j_password")
	private WebElementFacade password;
	
	@FindBy(name="submit")
	private WebElementFacade loginButton;

	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enter_login_name(String loginName) {
        element(login).type(loginName);
	}
	
	public void enter_password(String pasword) {
        element(password).type(pasword);
	}
	
	public void click_login_button() {
		element(loginButton).click();
	}
}
