package Orange.Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ButtonPages {

	private WebDriver driver;
	private Questions questions;


	@FindBy(how = How.ID, using = "btnLogin")
	private WebElement btnLogIn;

	@FindBy(how = How.ID, using = "menu_pim_viewPimModule")
	private WebElement btnPim;

	@FindBy(how = How.ID, using = "menu_pim_addEmployee")
	private WebElement btnAddEmployee;

	@FindBy(how = How.ID, using = "btnSave")
	private WebElement btnSave;

	@FindBy(how = How.ID, using = "menu_admin_viewAdminModule")
	private WebElement btnAdmin;

	@FindBy(how = How.ID, using = "btnAdd")
	private WebElement btnAdd;

	public ButtonPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.questions = new Questions(driver);
	}

	public void btnLogIn() {
		btnLogIn.isDisplayed();
		btnLogIn.click();
	}
	public void btnPim() {
		btnPim.click();
	}
	public void btnAddEmployee() {
		btnAddEmployee.click();
	}
	public void btnSave() {
		btnSave.click();
	}
	public void btnAdmin() {
		btnAdmin.click();
	}
	public void btnAdd() {
		btnAdd.click();
	}


}
