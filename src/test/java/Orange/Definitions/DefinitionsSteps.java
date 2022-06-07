package Orange.Definitions;

import Orange.DataExcel.ExcelReader;
import Orange.Pages.AdminPage;
import Orange.Pages.LoginPage;
import Orange.Pages.PimPage;
import cucumber.api.java.en.When;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import Orange.Steps.Connection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DefinitionsSteps {

    private WebDriver driver;
    private Connection conexion = new Connection();
    private LoginPage loginPage;
    private PimPage pimPage;
    private AdminPage adminPage;
    private static String useRole;
    private static String employeeName;
    private static String userName;
    private static String password;
    private static String confirmPassword;

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

    @And("^llegar a la opcion agregar empleados$")
    public void llegarAddEmployee(){
        this.pimPage=  new PimPage(driver);
        this.pimPage.llegarAddEmployee();
    }

    @When("^diligencie name (.*) middl(.*) y apellido (.*)")
    public void dilenciarEmployee(String name, String middleName, String lastName) throws SQLException {
        this.pimPage = new PimPage(driver);
        this.pimPage.diligenciarEmployee(name, middleName, lastName);
    }

    @And("^llegar a agregar un usuario$")
    public void llegarAddUser(){
        this.adminPage=  new AdminPage(driver);
        this.adminPage.llegarAddUser();
    }

    @When("^diligencie el nombre de la hoja (.*) y numero de columna (.*)")
    public void diligenciarAddUser( String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
        this.adminPage = new AdminPage(driver);
        ExcelReader excelReader = new ExcelReader();
        List<Map<String, String>> testData = excelReader.getData("src/test/resources/testData/pruebasExcel.xlsx", sheetName);

        useRole = testData.get(rowNumber).get("useRole");
        employeeName = testData.get(rowNumber).get("employeeName");
        userName = testData.get(rowNumber).get("userName");
        password = testData.get(rowNumber).get("password");
        confirmPassword = testData.get(rowNumber).get("confirmPassword");

        adminPage.diligenciarAddUser(useRole,employeeName, userName, password, confirmPassword);
    }

}