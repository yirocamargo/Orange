package Orange.Steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class Questions {

	private WebDriver driver;

	public Questions(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@Step
	public void impliciWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Step
	public void aceptAlert() {

		String mensaje =driver.switchTo().alert().getText();
		System.out.println(mensaje);
		driver.switchTo().alert().accept();

		if(mensaje.equals("This user already exist.")) {
			System.out.println("entro");
		}
	}

	@Step
	public void tiempoSegundos(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Step
	public void AsserWelcome(String userNameP) {
		String mensaje = driver.findElement(By.xpath("//li/a[contains(text(), 'Welcome')]")).getText();
		Assert.assertEquals("Welcome " + userNameP + "", mensaje);

	}

	@Step
	public void AsserProduct(String laptopP) {
		String mensaje = driver.findElement(By.xpath("//td[text() = '" + laptopP + "']")).getText();
		Assert.assertEquals("" + laptopP + "", mensaje);

	}

	@Step
	public void AsserPurchase() {
		String mensaje = driver.findElement(By.xpath("//div[@class = 'sweet-alert  showSweetAlert visible']/h2"))
				.getText();
		Assert.assertEquals("Thank you for your purchase!", mensaje);

	}
	
	@Step
	public void AsserThat() {
		String mensaje =driver.switchTo().alert().getText();
		System.out.println(mensaje);
		//driver.switchTo().alert().dismiss();
	}
}