package my.corp.pages;

import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

/**
 * Created by Anton on 04.06.2014.
 */
public class HomePage extends PageObject {

    @FindBy(id="nav_Tasks_link")
    private WebElementFacade lTasksMenu;

    @FindBy(linkText="Rules")
    private WebElementFacade lRules;



    public HomePage (WebDriver driver) {
        super(driver);
    }


    public boolean task_menu_is_visible() { return lTasksMenu.isVisible(); }

    public void go_to_manage_rules_page() {
        lTasksMenu.click();
        lRules.click();
    }
}
