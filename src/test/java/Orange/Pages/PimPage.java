package Orange.Pages;

import Orange.BaseDatos.ConsultDataBase;
import Orange.BaseDatos.InsertEmployee;
import Orange.Steps.ButtonPages;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLException;

public class PimPage {

    private ButtonPages buttonPages;
    private ConsultDataBase consultDataBase;
    private InsertEmployee insertEmployee;
    @FindBy(how = How.ID, using = "firstName")
    private WebElement txtName;

    @FindBy(how = How.ID, using = "lastName")
    private WebElement txtLastname;

    @FindBy(how = How.ID, using = "middleName")
    private WebElement txtmiddleName;

    public PimPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.buttonPages = new ButtonPages(driver);
    }

    public void llegarAddEmployee(){
        buttonPages.btnPim();
        buttonPages.btnAddEmployee();
    }

    public void diligenciarEmployee(String name, String middleName, String lastName) throws SQLException {
        txtName.sendKeys(name);
        txtLastname.sendKeys(lastName);
        txtmiddleName.sendKeys(middleName);
        buttonPages.btnSave();
        insertEmployee.insertAddEmployee(name,middleName, lastName);
        consultDataBase.consultUsers();
    }

}
