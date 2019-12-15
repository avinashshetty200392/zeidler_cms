Feature: As a logged in Admin user
I should be able to upload images through the FILES sections on CMS Admin
so that I can use these images while creating content on the site

Background:
Given I enter url as "https://demo.bigtreecms.org/admin/login/" in the url bar of the browser
And I am on CMS login page
And I enter email as "demo@bigtreecms.org"
And I enter password as "demo"
When I click on Login button
Then I should navigate to CMS Admin Dashboard


Scenario: Verify image upload functionality by manually adding files of extension .png, .gif and .jpg
Given I am on Files page
And I click on Add Images tab
And I navigate to Add Images page
And I can see Breadcrumb as Files > Home > Add Images below navigational bar of the page
And I click on Drag and Drop section
And I browse the file with one of the extension .png, .gif and .jpg
And I can see a tile added within Drag and Drop section
And I can see Continue button enabled
And I click on Continue button
And I navigate to Cropping image page
And I click on Crop Image button till I reach Edit File page
And I am on Edit File page
And I can see Update File button
When I click on Update File button
Then I should navigate to Files page
And I should see a message as File Manager Updated File
And I should see a row added with uploaded image and few information in the below grid
And I should see browser closed

