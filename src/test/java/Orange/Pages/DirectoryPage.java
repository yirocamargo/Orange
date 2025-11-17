package Orange.Pages;

import Orange.Steps.ButtonPages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class DirectoryPage {

    private WebDriver driver;
    private ButtonPages buttonPages;


    @FindBy(how = How.XPATH, using = "//input[contains(@placeholder,'Type for hints')]")
    private WebElement txtEmployeename;

    @FindBy(how = How.XPATH, using = "//button[normalize-space()='Search']")
    private WebElement btnSearch;

    @FindBy(how = How.XPATH, using = "//div[@role='listbox']")
    private WebElement btnList;


    
    public DirectoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.buttonPages = new ButtonPages(driver);
    }

    public void llegarDirectory()  {
        buttonPages.btnDirectory();
    }

    public void busquedaDirectory(String name, String lastName){

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(txtEmployeename));
        txtEmployeename.click();
        txtEmployeename.clear();
        txtEmployeename.sendKeys(name);

        By listBoxLocator = By.xpath("//div[@role='listbox']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(listBoxLocator));

        String fullName = name + " " + lastName;
        By optionLocator = By.xpath("//div[@role='option']//span[normalize-space()='" + fullName + "']");
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
        option.click();

        wait.until(ExpectedConditions.elementToBeClickable(btnSearch));
        btnSearch.click();
    }

    public void validarInfoBasicaEmpleado(String name, String lastName) {

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);

            WebElement directoryContainer = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.cssSelector("div.orangehrm-corporate-directory")
                    )
            );

            List<WebElement> cards = directoryContainer.findElements(
                    By.cssSelector("div.orangehrm-directory-card")
            );

            if (cards.isEmpty()) {
                throw new AssertionError("No se encontraron tarjetas de empleados en el Directory.");
            }

            boolean found = false;
            String expectedFullName = (name + " " + lastName).trim();

            for (WebElement card : cards) {
                WebElement nameHeader = card.findElement(
                        By.cssSelector("p.orangehrm-directory-card-header")
                );

                String rawText = nameHeader.getText();
                String normalizedText = rawText.replaceAll("\\s+", " ").trim();

                System.out.println("Nombre en tarjeta: [" + normalizedText + "]");

                if (normalizedText.equalsIgnoreCase(expectedFullName)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new AssertionError(
                        "La información del empleado no coincide. Se esperaba encontrar: ["
                                + expectedFullName + "] en las tarjetas del Directory."
                );
            }
            //✅ Si todo salió bien, marcamos la sesión como PASSED en BrowserStack
            setBrowserStackStatus("passed",
                    "Empleado encontrado correctamente en el Directory: " + expectedFullName);

        } catch (AssertionError e) {
            // Si hay fallo de validación, marcamos como FAILED en BrowserStack
            setBrowserStackStatus("failed", e.getMessage());
            throw e; // dejamos que el test falle normalmente
        } finally {
            // Cerramos el driver tanto en local como en BrowserStack
            if (driver != null) {
                driver.quit();
            }
        }
    }

    // 👇 Helper para marcar el estado en BrowserStack
    private void setBrowserStackStatus(String status, String reason) {
        try {
            // Solo lo usamos cuando corremos en BrowserStack
            String runOn = System.getProperty("runOn", "browserstack");
            if (!"browserstack".equalsIgnoreCase(runOn)) {
                return;
            }

            if (driver instanceof JavascriptExecutor) {
                ((JavascriptExecutor) driver).executeScript(
                        "browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\""
                                + status + "\", \"reason\": \"" + reason + "\"}}"
                );
            }
        } catch (Exception ex) {
            // No rompemos el test si algo falla al reportar el estado
            System.out.println("No se pudo actualizar el estado en BrowserStack: " + ex.getMessage());
        }
    }

}
