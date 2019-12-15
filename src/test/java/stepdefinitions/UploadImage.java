package stepdefinitions;

import org.openqa.selenium.WebDriver;
import pageobjects.UploadImageObjects;
import utility.CommonMethods;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UploadImage {
	public WebDriver driver;
	public String uploadImageName;
	public int initialCountOfImagesInGrid;
	UploadImageObjects uio;
	
	public UploadImage() {
		this.driver = CommonMethods.initializeDriver();
	}

	@Given("^I enter url as \"([^\"]*)\" in the url bar of the browser$")
	public void i_enter_url_as_in_the_url_bar_of_the_browser(String url) {
		uio = new UploadImageObjects(driver);
		uio.enterUrl(url);
	}

	@Given("^I am on CMS login page$")
	public void i_am_on_cms_login_page() {
		uio.verifyCmsLoginPage();
	}

	@Given("^I enter email as \"([^\"]*)\"$")
	public void i_enter_email_as(String email) throws Throwable {
		uio.enterEmail(email);
	}
	
	@Given("^I enter password as \"([^\"]*)\"$")
	public void i_enter_password_as(String password) throws Throwable {
		uio.enterPassword(password);
	}

	@When("^I click on Login button$")
	public void i_click_on_Login_button() throws Throwable {
		uio.clickOnLoginButton();
	}

	@Then("^I should navigate to CMS Admin Dashboard$")
	public void i_should_navigate_to_CMS_Admin_Dashboard() throws Throwable {
		uio.verifyCmsAdminDashboard();
	}

	@Given("^I am on Files page$")
	public void i_am_on_Files_page() throws Throwable {
		uio.verifyFilesPage();
	}

	@Given("^I click on Add Images tab$")
	public void i_click_on_Add_Images_tab() throws Throwable {
		uio.clickOnAddImagesTab();
	}

	@Given("^I navigate to Add Images page$")
	public void i_navigate_to_Add_Images_page() throws Throwable {
		uio.verifyAddImagesPage();
	}
	
	@Given("^I can see Breadcrumb as Files > Home > Add Images below navigational bar of the page$")
	public void i_can_see_Breadcrumb_as_Files_Home_Add_Images_below_navigational_bar_of_the_page() throws Throwable {
		uio.verifyAddImagesBreadcrumb();
	}
	
	@Given("^I click on Drag and Drop section$")
	public void i_click_on_Drag_and_Drop_section() throws Throwable {
	  uio.clickOnDragAndDropSection();
	}
	
	@Given("^I browse the file with one of the extension \\.png, \\.gif and \\.jpg$")
	public void i_browse_the_file_with_one_of_the_extension_png_gif_and_jpg() throws Throwable {
		uio.browseImage();    
	}
	
	@Given("^I can see a tile added within Drag and Drop section$")
	public void i_can_see_a_tile_added_within_Drag_and_Drop_section() throws Throwable {
		uio.verifyTileWithinDragAndDropSection(); 
	}
	
	@Given("^I can see Continue button enabled$")
	public void i_can_see_Continu_button_enabled() throws Throwable {
		uio.verifyContinueButtonStatus();
	}
	
	@Given("^I click on Continue button$")
	public void i_click_on_Continue_button() throws Throwable {
		uio.clickOnContinueButton();
	}
	
	@Given("^I navigate to Cropping image page$")
	public void i_navigate_to_Cropping_image_page() throws Throwable {
		uio.verifyCroppingImagePage();
	}
	
	@Given("^I click on Crop Image button till I reach Edit File page$")
	public void i_click_on_Crop_Image_button_till_I_reach_Edit_File_page() throws Throwable {
		uio.clickOnCropImageButton();
	}
	
	@Given("^I am on Edit File page$")
	public void i_am_on_edit_file_page() throws Throwable {
		uio.verifyEditFilePage();
	}
	
	@Given("^I can see Update File button$")
	public void i_can_see_Update_File_button() throws Throwable {
		uio.verifyUpdateFilebutton();
	}
	
	@When("^I click on Update File button$")
	public void i_click_on_Update_File_button() throws Throwable {
		uio.clickOnUpdateFileButton();
	}
	
	@Then("^I should navigate to Files page$")
	public void i_should_navigate_to_Files_page() throws Throwable {
		uio.verifyAgainFilesPage();
	}
	
	@Then("^I should see a message as File Manager Updated File$")
	public void i_should_see_a_message_as_File_Manager_Updated_File() throws Throwable {	
		uio.imageUploadedMessage();
	}
	
	@Then("^I should see a row added with uploaded image and few information in the below grid$")
	public void i_should_see_a_row_added_with_uploaded_image_and_few_information_in_the_below_grid() throws Throwable {
		uio.verifyUploadedImagesInGrid();
	}
	
	@Then("^I should see browser closed$")
	public void i_should_see_browser_closed() throws Throwable {
	   uio.closeBrowser();
	}
}
