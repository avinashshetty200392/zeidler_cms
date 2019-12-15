package pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.CommonMethods;
import utility.Waits;

public class UploadImageObjects {
	private WebDriver driver;
	private String uploadImageName;
	private int initialCountOfImagesInGrid;
	
	
	public UploadImageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//form[@class='module']")
	private WebElement loginForm;
	
	@FindBy(xpath = "//a[@class='login_logo']")
	private WebElement loginLogo;
	
	@FindBy(id = "user")
	private WebElement emailField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//p[@class='welcome']//img")
	private WebElement userLogo;

	@FindBy(xpath = "//strong[contains(text(),'Timber')]")
	private WebElement timberLogo;

	@FindBy(xpath = "//article[@class='bigtree']/a")
	private WebElement footerLogo;

	@FindBy(xpath = "//nav[@class='main']/section/ul/li[4]")
	private WebElement filesTab;

	@FindBy(xpath = "//nav[@class='main']/section/ul/li[4]/a")
	private WebElement filesTabStatus;

	@FindBy(xpath = "//a[contains(text(),'Add Images')]")
	private WebElement addImagesTab;

	@FindBy(xpath = "//div[@id='page']/h1/a[contains(text(),'Add Images')]")
	private WebElement addImagesBreadCrumb;
	
	@FindBy(xpath = "//form[@id='file_manager_dropzone']")
	private WebElement dragAndDropForm;
	
	@FindBy(xpath = "//input[@class='blue button js-continue-button disabled' and @value='Continue']")
	private WebElement continueButtonDisabledStatus;
	
	@FindBy(xpath = "//div[@class='dz-image']")
	private WebElement uploadedImage;
	
	@FindBy(xpath = "//div[@class='dz-filename']/span")
	private WebElement imageName;
	
	@FindBy(xpath = "//input[@class='blue button js-continue-button' and @value='Continue']")
	private WebElement continueButtonEnabledStatus;
	
	@FindBy(xpath = "//div[@class='jcrop-holder']")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//span[@class='page_icon crop']")
	private WebElement originalImage;
	
	@FindBy(xpath = "//div[@id='preview_1']")
	private WebElement croppedImage;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Crop Image']")
	private WebElement cropImageButton;
	
	@FindBy(xpath = "//span[@class='count current']")
	private WebElement currentPage;
	
	@FindBy(xpath = "//span[@class='count total']")
	private WebElement totalCountOfPage;
	
	@FindBy(xpath = "//div[@id='page']/h1/a[contains(text(),'Edit File')]")
	private WebElement editFileBreadCrumb;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Update File']")
	private WebElement updateFileButton;
	
	@FindBy(xpath = "//nav[@id='sub_nav']/a")
	private WebElement navBar;
	
	@FindBy(xpath = "//h3[contains(text(),'File Manager')]")
	private WebElement fileManagerPopup;
	
	@FindBy(xpath = "//div[@class='table']//ul/li/section[2]/a")
	private WebElement uploadedImageInGrid;
	
	@FindBy(xpath = "//div[@class='table']//ul/li")
	private List<WebElement> uploadedImagesInTable;
	
	public void enterUrl(String url)
	{
		driver.get(url);
	}
	public void verifyCmsLoginPage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.and(
				ExpectedConditions.visibilityOf(loginForm),
				ExpectedConditions.visibilityOf(loginLogo)));
	}
	
	public void enterEmail(String email)
	{
		Waits.waitforSeconds(driver, 10, emailField);
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String pwd)
	{
		Waits.waitforSeconds(driver, 10, passwordField);
		passwordField.clear();
		passwordField.sendKeys(pwd);
	}
	
	public void clickOnLoginButton()
	{
		Waits.waitforSeconds(driver, 10, loginButton);
		loginButton.click();
	}
	
	public void verifyCmsAdminDashboard()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.and(
				ExpectedConditions.visibilityOf(userLogo),
				ExpectedConditions.titleIs(driver.getTitle()),
				ExpectedConditions.visibilityOf(footerLogo)));
	}
	
	public void verifyFilesPage()
	{
		Waits.waitforSeconds(driver, 10, filesTab);
		filesTab.click();
		if (filesTabStatus.getAttribute("class").equalsIgnoreCase("active")) {
			System.out.println("I am on Files page");
		} else {
			System.out.println("I am not on Files page");
		}
		initialCountOfImagesInGrid = uploadedImagesInTable.size();
	}
	
	public void clickOnAddImagesTab()
	{
		Waits.waitforSeconds(driver, 10, addImagesTab);
		addImagesTab.click();
	}
	
	public void verifyAddImagesPage()
	{
		Waits.waitforSeconds(driver, 10, continueButtonDisabledStatus);
	}
	
	public void verifyAddImagesBreadcrumb()
	{
		Waits.waitforSeconds(driver, 10, addImagesBreadCrumb);
		if (addImagesBreadCrumb.getAttribute("class").equalsIgnoreCase(" last")) {
			System.out.println("I am on Add Images page");
		} else {
			System.out.println("I am not on Add Images page");
		}
	}
	
	public void clickOnDragAndDropSection()
	{
			Waits.waitforSeconds(driver, 10, dragAndDropForm);
			dragAndDropForm.click();
	}
	
	public void browseImage() throws Throwable
	{
		uploadImageName="admin.jpg";
		CommonMethods.browseWindowPopUp(uploadImageName);
	}
	
	public void verifyTileWithinDragAndDropSection()
	{
		Waits.waitforSeconds(driver, 10, uploadedImage);
		Waits.waitforSeconds(driver, 10, imageName);
		if(uploadedImage.isDisplayed() || imageName.getAttribute("innerHTML").equalsIgnoreCase("admin.jpg")){
			System.out.println("File Uploaded successfully");
		}
		else
		{
			System.out.println("File not uploaded successfully");
		}
	}
	
	public void verifyContinueButtonStatus()
	{
		Waits.waitforSeconds(driver, 10, continueButtonEnabledStatus);
		if(continueButtonEnabledStatus.isEnabled())
		{
			System.out.println("Continue button enabled");
		}
		else
		{
			System.out.println("Continue button disabled");
		}
	}
	
	public void clickOnContinueButton()
	{
		continueButtonEnabledStatus.click();
	}
	
	public void verifyCroppingImagePage()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.and(
				ExpectedConditions.visibilityOf(pageTitle),
				ExpectedConditions.visibilityOf(originalImage),
				ExpectedConditions.visibilityOf(croppedImage)));
	}
	
	public void clickOnCropImageButton() throws InterruptedException
	{
		Waits.waitforSeconds(driver, 10, cropImageButton);
		Waits.waitforSeconds(driver, 10, totalCountOfPage);
		int tcop = Integer.valueOf(totalCountOfPage.getAttribute("innerHTML"));
		
		for(int i=1;i<=tcop;i++)
		{
			Thread.sleep(1000);
			Waits.waitforSeconds(driver, 10, cropImageButton);
			cropImageButton.click();

		}
	}
	
	public void verifyEditFilePage()
	{
		Waits.waitforSeconds(driver, 10, editFileBreadCrumb);
		if (editFileBreadCrumb.getAttribute("class").equalsIgnoreCase(" last")) {
			System.out.println("I am on Edit File page");
		} else {
			System.out.println("I am not on Edit File page");
		}
	}
	
	public void verifyUpdateFilebutton()
	{
		Waits.waitforSeconds(driver, 10, updateFileButton);
		if(updateFileButton.isDisplayed())
		{
			System.out.println("Update File button is displayed");
		}
		else
		{
			System.out.println("Update File button is not displayed");
		}
	}
	
	public void clickOnUpdateFileButton()
	{
		updateFileButton.click();
	}
	
	public void verifyAgainFilesPage()
	{
		Waits.waitforSeconds(driver, 10, navBar);
		System.out.println("I am on File page");
	}
	
	public void imageUploadedMessage()
	{
		Waits.waitforSeconds(driver, 10, fileManagerPopup);
		System.out.println("Image uploaded successfully");
	}
	
	public void verifyUploadedImagesInGrid()
	{
		Waits.waitforSeconds(driver, 10, uploadedImageInGrid);
		int finalCountOfImagesInGrid=uploadedImagesInTable.size();
		if(finalCountOfImagesInGrid==(initialCountOfImagesInGrid+1))
		{
			System.out.println("Uploaded image is visible in result grid");
		}
		else
		{
			System.out.println("Uploaded image is not visible in result grid");
		}
	}
	
	public void closeBrowser()
	{
		 CommonMethods.tearDown(driver);
	}
}
