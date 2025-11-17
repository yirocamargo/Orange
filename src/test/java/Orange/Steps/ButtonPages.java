package Orange.Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ButtonPages {

    private WebDriver driver;
    private Questions questions;


    @FindBy(how = How.XPATH, using = "//button[@type=\"submit\"]")
    private WebElement btnLogIn;

    @FindBy(how = How.XPATH, using = "//a[@class='oxd-main-menu-item']//span[normalize-space()='PIM']")
    private WebElement btnPim;

    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Add Employee']")
    private WebElement btnAddEmployee;

    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Save']")
    private WebElement btnSave;

    @FindBy(how = How.XPATH, using = "//img[@class=\"employee-image\"]")
    private WebElement btnImg;

    @FindBy(how = How.XPATH, using = "//span[normalize-space()='Directory']")
    private WebElement btnDirectory;



    public ButtonPages(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.questions = new Questions(driver);
    }

    public void btnLogIn() {
        btnLogIn.isDisplayed();
        btnLogIn.click();
    }
    public void btnPim() { btnPim.click();}

    public void btnAddEmployee() { btnAddEmployee.click(); }

    public void btnSave() { btnSave.click();  }

    public void btnImg() {   btnImg.click(); }

    public void btnDirectory() {   btnDirectory.click(); }


    public void btnlistUse(String useRole) {
        WebElement btnList = driver.findElement(By.xpath("//select//option[text()='"+useRole+"']"));
        btnList.click();
    }


}