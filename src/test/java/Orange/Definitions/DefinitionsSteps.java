package Orange.Definitions;

import Orange.Pages.LoginPage;
import Orange.Pages.PimPage;
import Orange.Pages.DirectoryPage;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import Orange.Steps.Connection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class DefinitionsSteps {

    private WebDriver driver;
    private Connection conexion = new Connection();
    private LoginPage loginPage;
    private PimPage pimPage;
    private DirectoryPage directoryPage;

    @Given("^open browser$")
    public void open_browser() throws Exception {
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

    @And("^diligencie name (.*) y apellido (.*) rutaFoto (.*)" )
    public void dilenciarEmployee(String name, String lastName, String rutaFoto){
        this.pimPage = new PimPage(driver);
        this.pimPage.diligenciarEmployee(name, lastName, rutaFoto);
    }

    @And("^llegar a la opcion directory")
    public void llegarDirectory(){
        this.directoryPage = new DirectoryPage(driver);
        this.directoryPage.llegarDirectory();
    }

    @And("^busqueda name (.*) y apellido (.*)")
    public void busquedaDirectory(String name, String lastName){
        this.directoryPage = new DirectoryPage(driver);
        this.directoryPage.busquedaDirectory(name, lastName);
    }

    @When("^validar info name (.*) y apellido (.*)")
    public void validarInfoBasicaEmpleado(String name, String lastName){
        this.directoryPage = new DirectoryPage(driver);
        this.directoryPage.validarInfoBasicaEmpleado(name, lastName);
    }


}