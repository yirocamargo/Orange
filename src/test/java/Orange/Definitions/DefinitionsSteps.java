package Orange.Definitions;

import Orange.Pages.LoginPage;
import Orange.Pages.PimPage;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import Orange.Steps.Connection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.sql.SQLException;

public class DefinitionsSteps {

    private WebDriver driver;
    private Connection conexion = new Connection();
    private LoginPage loginPage;
    private PimPage pimPage;

    @Given("^open browser$")
    public void open_browser() {

        this.conexion = new Connection();
        this.driver = this.conexion.abrirNavegador();

    }

    @And("^diligenciar user (.*) and contraseña (.*)")
    public void diligenciarLogin(String user, String pass){
        this.loginPage=  new LoginPage(driver);
        this.loginPage.diligenciarLogin(user, pass);
    }

    @And("^llegar a la opcion agregar empleados")
    public void llegarAddEmployee(){
        this.pimPage=  new PimPage(driver);
        this.pimPage.llegarAddEmployee();
    }

    @When("^diligencie name (.*) middl(.*) y apellido (.*)")
    public void dilenciarEmployee(String name, String middleName, String lastName) throws SQLException {
        this.pimPage = new PimPage(driver);
        this.pimPage.diligenciarEmployee(name, middleName, lastName);
    }
}