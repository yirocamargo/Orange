package Orange.Pages;

import Orange.Steps.ButtonPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PimPage {

    private ButtonPages buttonPages;
    private WebDriver driver;

    @FindBy(how = How.NAME, using = "firstName")
    private WebElement txtName;

    @FindBy(how = How.NAME, using = "lastName")
    private WebElement txtLastname;

    @FindBy(how = How.XPATH, using = "//input[@type='file']")
    private WebElement inputFoto;

    public PimPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.buttonPages = new ButtonPages(driver);
    }

    public void llegarAddEmployee(){
        buttonPages.btnPim();
        buttonPages.btnAddEmployee();
    }

    public void diligenciarEmployee(String name, String lastName, String rutaFoto){

        txtName.sendKeys(name);
        txtLastname.sendKeys(lastName);

        if (driver instanceof org.openqa.selenium.remote.RemoteWebDriver) {
            ((org.openqa.selenium.remote.RemoteWebDriver) driver)
                    .setFileDetector(new org.openqa.selenium.remote.LocalFileDetector());
        }

        if (rutaFoto != null && !rutaFoto.isEmpty()) {
            inputFoto.sendKeys(rutaFoto);
        }

        buttonPages.btnSave();
    }

}
