package Orange.Steps;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;


public class Connection {

	private WebDriver driver;

	@Before
	@Step

    //browserstack
    public WebDriver abrirNavegador() throws Exception {

        String runOn = System.getProperty("runOn", "browserstack");

        System.out.println("#################################");
        System.out.println("###   VALOR DE runOn = " + runOn);
        System.out.println("#################################");

        driver = crearDriverBrowserStack();
        if (runOn.equalsIgnoreCase("browserstack")) {
            System.out.println("###   CREANDO DRIVER EN BROWSERSTACK");
            driver = crearDriverBrowserStack();
        } else {
            System.out.println("###   CREANDO DRIVER LOCAL");
            driver = crearDriverLocal();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return this.driver;

    }

    // -----------------------
    //   DRIVER LOCAL
    // -----------------------
    private WebDriver crearDriverLocal() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        return driver;

    }

    // -----------------------
    //   DRIVER BROWSERSTACK
    // -----------------------
    private WebDriver crearDriverBrowserStack() throws Exception {

        String USERNAME = "yiroenriquecamar_516esH";
        String ACCESS_KEY = "C3eLAuDwmXJBs7q1ALdx";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "11");
        caps.setCapability("name", "OrangeHRM Automation - Selenium 3");

        String url = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

        WebDriver driver = new RemoteWebDriver(new URL(url), caps);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        return driver;

    }

}
