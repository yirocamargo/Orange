package Orange.Pages;

import Orange.Steps.ButtonPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(how = How.ID, using = "txtUsername")
    private WebElement txtUser;

    @FindBy(how = How.ID, using = "txtPassword")
    private WebElement txtPass;
    private ButtonPages buttonPages;


    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.buttonPages = new ButtonPages(driver);
    }

    public void diligenciarLogin(String user, String pass){
        txtUser.sendKeys(user);
        txtPass.sendKeys(pass);
        buttonPages.btnLogIn();
    }
}
