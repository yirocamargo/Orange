package Orange.Pages;

import Orange.Steps.ButtonPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

public class AdminPage {

    @FindBy(how = How.ID, using = "systemUser_employeeName_empName")
    private WebElement txtEmployeeName;

    @FindBy(how = How.ID, using = "systemUser_userName")
    private WebElement txtUserName;

    @FindBy(how = How.ID, using = "systemUser_password")
    private WebElement txtPassword;

    @FindBy(how = How.ID, using = "systemUser_confirmPassword")
    private WebElement txtConfirmPassword;
    private ButtonPages buttonPages;

    public AdminPage(WebDriver driver){
        this.buttonPages = new ButtonPages(driver);
        PageFactory.initElements(driver,this);
    }

    public void llegarAddUser () {
        buttonPages.btnAdmin();
        buttonPages.btnAdd();
    }

    public void diligenciarAddUser(String employeeName,String userName,String password,String confirmPassword){
        txtEmployeeName.sendKeys();
        txtUserName.sendKeys();
        txtPassword.sendKeys();
        txtConfirmPassword.sendKeys();
    }
}
