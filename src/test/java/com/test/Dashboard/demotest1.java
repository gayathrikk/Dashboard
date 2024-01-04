package com.test.Dashboard;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class demotest1{

	 private RemoteWebDriver driver;

	    @BeforeTest
	    public void setup() throws MalformedURLException 
	    {
	        DesiredCapabilities dc = DesiredCapabilities.chrome();
	        URL url = new URL("http://172.20.23.7:5555/wd/hub");
	        driver = new RemoteWebDriver(url, dc);
	    }

@Test(priority=1)
public void login() throws InterruptedException
{
driver.get("http://dev2mani.humanbrain.in/annotation/portal");
driver.manage().window().maximize();
String currentURL = driver.getCurrentUrl();
System.out.println("Current URL: " + currentURL);
WebDriverWait wait = new WebDriverWait(driver, 60);
driver.switchTo().defaultContent(); // Switch back to default content
Actions actions = new Actions(driver);
Thread.sleep(2000);
  actions.sendKeys("D").perform();
  Thread.sleep(2000);
WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Analytics']")));
if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
   viewerElement.click();
   System.out.println("Analytics icon is clicked");
} else {
   System.out.println("Analytics icon is not clickable");
}

System.out.println("************************Login validation start***********************");


String parentWindow = driver.getWindowHandle();
WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Log In ']")));
if (loginButton != null) {
    loginButton.click();
    System.out.println("Login button clicked successfully.");
} else {
    System.out.println("Login button is not clicked.");
}

wait.until(ExpectedConditions.numberOfWindowsToBe(2));
Set<String> allWindows = driver.getWindowHandles();
for (String window : allWindows) {
   if (!window.equals(parentWindow)) {
       driver.switchTo().window(window);
       break;
   }
}
WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
if (emailInput != null && emailInput.isDisplayed()) {
    emailInput.sendKeys("teamsoftware457");
    System.out.println("Email was entered successfully.");
} else {
   System.out.println("Email was not entered.");
}


WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
if (nextButton1 != null) {
    nextButton1.click();
    System.out.println("Next button 1 is clicked.");
} else {
    System.out.println("Next button 1 is not clicked.");
}

WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Enter your password']")));
passwordInput.sendKeys("Health#123");
if (passwordInput.getAttribute("value").equals("Health#123")) {
    System.out.println("Password was entered successfully.");
} else {
    System.out.println("Password was not entered.");
}


WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
if (nextButton2 != null) {
    nextButton2.click();
    System.out.println("Next button 2 is clicked.");
} else {
    System.out.println("Next button 2 is not clicked.");
}


driver.switchTo().window(parentWindow);
System.out.println("Login successfully");

System.out.println("************************Login validation done***********************");
Thread.sleep(3000);
       
}

@Test(priority=2)
public void competitions() throws InterruptedException {
   WebDriverWait wait = new WebDriverWait(driver, 60);
   
System.out.println("************************Competitions Tab Start***********************");


WebElement competitionsELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Competitions')]")));
if (competitionsELement.isEnabled() && competitionsELement.isDisplayed()) {
competitionsELement.click();
   System.out.println("Competitions tab is clicked");
}
else {
System.out.println("Competitions tab is not clickable");
}
}

@Test(priority=3)
public void hostCompetitions() throws InterruptedException {
System.out.println("************************Host Competitions Tab Start***********************");

   WebDriverWait wait = new WebDriverWait(driver, 60);

WebElement hostELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'Host a Competition')]")));

if (hostELement.isEnabled() && hostELement.isDisplayed()) {
hostELement.click();
   System.out.println("Host a competition button is clicked");
}
else {
System.out.println("Host a competition button is not clickable");
}
Thread.sleep(2000);

   WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

   // Switch to the iframe
   driver.switchTo().frame(iframeElement);

WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
if (userInput != null && userInput.isDisplayed()) {
userInput.sendKeys("admin");
    System.out.println("Username was entered successfully.");
} else {
   System.out.println("Username was not entered.");
}
Thread.sleep(2000);

WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
if (passInput != null && passInput.isDisplayed()) {
passInput.click();
passInput.sendKeys("admin");
    System.out.println("Password was entered successfully.");
} else {
   System.out.println("Password was not entered.");
}
Thread.sleep(2000);
driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
System.out.println("Login button clicked successfully");

WebElement nameELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_name']")));
if (nameELement.isEnabled() && nameELement.isDisplayed()) {
nameELement.sendKeys("Automation_competitions-2");
   System.out.println("Name entered successfully");
}
else {
System.out.println("Name is not entered");
}
Thread.sleep(2000);

WebElement descriptionELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@id='id_description']")));
if (descriptionELement.isEnabled() && descriptionELement.isDisplayed()) {
descriptionELement.sendKeys("Automation to add a new competition");
   System.out.println("Description entered successfully");
}
else {
System.out.println("Description is not entered");
}
Thread.sleep(2000);


WebElement piplineELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-id_pipeline-container']")));
if (piplineELement.isEnabled() && piplineELement.isDisplayed()) {
piplineELement.click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Search']"))).sendKeys("CellDetection", Keys.ENTER);

   System.out.println("Pipeline is selected successfully");
}
else {
System.out.println("Pipeline is not selected");
}
Thread.sleep(2000);


WebElement createdByELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-id_user-container']")));
if (createdByELement.isEnabled() && createdByELement.isDisplayed()) {
createdByELement.click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Search']"))).sendKeys("Software team", Keys.ENTER);
   System.out.println("Created by is selected successfully");
}
else {
System.out.println("Created by is not selected");
}
Thread.sleep(3000);


WebElement dateELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Today')]")));
if (dateELement.isEnabled() && dateELement.isDisplayed()) {
dateELement.click();
   System.out.println("Date entered successfully");
}
else {
System.out.println("Date is not entered");
}
Thread.sleep(3000);


WebElement timeELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Now')]")));
if (timeELement.isEnabled() && timeELement.isDisplayed()) {
timeELement.click();
   System.out.println("Time entered successfully");
}
else {
System.out.println("Time is not entered");
}
Thread.sleep(3000);


WebElement saveELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type, 'submit')]")));
if (saveELement.isEnabled() && saveELement.isDisplayed()) {
saveELement.click();
   System.out.println("Competitions saved successfully");
}
else {
System.out.println("Competitions is not saved");
}
Thread.sleep(3000);

driver.switchTo().defaultContent();


WebElement exitELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nb-icon[@icon='close-outline']")));
if (exitELement.isEnabled() && exitELement.isDisplayed()) {
exitELement.click();
   System.out.println("Exit button was clicked successfully");
}
else {
System.out.println("Exit button is not clickable");
}
Thread.sleep(3000);

System.out.println("************************Host Competitions Tab end***********************");

}

@Test(priority=4)
public void datasets() throws InterruptedException {
System.out.println("************************Dataset Tab Start***********************");

   WebDriverWait wait = new WebDriverWait(driver, 60);

WebElement competitionsELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Datasets')]")));
if (competitionsELement.isEnabled() && competitionsELement.isDisplayed()) {
competitionsELement.click();
   System.out.println("Datasets icon is clicked");
}
else {
System.out.println("Datasets icon is not clickable");
}
}

@Test(priority=5)
public void addDataset() throws InterruptedException {

System.out.println("************************Add Dataset start***********************");

   WebDriverWait wait = new WebDriverWait(driver, 60);

WebElement hostELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(), 'Add Dataset')]")));

if (hostELement.isEnabled() && hostELement.isDisplayed()) {
hostELement.click();
   System.out.println("Add Dataset button is clicked");
}
else {
System.out.println("Add Dataset button is not clickable");
}
Thread.sleep(2000);

   WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

   // Switch to the iframe
   driver.switchTo().frame(iframeElement);

WebElement nameELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_name']")));
if (nameELement.isEnabled() && nameELement.isDisplayed()) {
nameELement.sendKeys("Automation_Datasets_2");
   System.out.println("Name entered successfully");
}
else {
System.out.println("Name is not entered");
}
Thread.sleep(2000);

WebElement ontologyELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-id_ontology-container']")));
if (ontologyELement.isEnabled() && ontologyELement.isDisplayed()) {
ontologyELement.click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Search']"))).sendKeys("Atlas", Keys.ENTER);

   System.out.println("Ontology is selected successfully");
}
else {
System.out.println("Ontology is not selected");
}
Thread.sleep(2000);

WebElement descriptionELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@id='id_description']")));
if (descriptionELement.isEnabled() && descriptionELement.isDisplayed()) {
descriptionELement.sendKeys("Writing this to add a new dataset for testing");
   System.out.println("Description entered successfully");
}
else {
System.out.println("Description is not entered");
}
Thread.sleep(2000);



WebElement createdByELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-id_user-container']")));
if (createdByELement.isEnabled() && createdByELement.isDisplayed()) {
createdByELement.click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Search']"))).sendKeys("Software team", Keys.ENTER);
   System.out.println("Created by is selected successfully");
}
else {
System.out.println("Created by is not selected");
}
Thread.sleep(3000);


WebElement dateELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Today')]")));
if (dateELement.isEnabled() && dateELement.isDisplayed()) {
dateELement.click();
   System.out.println("Date entered successfully");
}
else {
System.out.println("Date is not entered");
}
Thread.sleep(3000);


WebElement timeELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Now')]")));
if (timeELement.isEnabled() && timeELement.isDisplayed()) {
timeELement.click();
   System.out.println("Time entered successfully");
}
else {
System.out.println("Time is not entered");
}
Thread.sleep(3000);


WebElement saveELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type, 'submit')]")));
if (saveELement.isEnabled() && saveELement.isDisplayed()) {
saveELement.click();
   System.out.println("Datasets saved successfully");
}
else {
System.out.println("Datasets is not saved");
}
Thread.sleep(3000);

driver.switchTo().defaultContent();


WebElement exitELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//button//nb-icon[@icon='close-outline']")));
if (exitELement.isEnabled() && exitELement.isDisplayed()) {
exitELement.click();
   System.out.println("Exit button was clicked successfully");
}
else {
System.out.println("Exit button is not clickable");
}
Thread.sleep(3000);



WebElement backELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Back']")));
if (backELement.isEnabled() && backELement.isDisplayed()) {
backELement.click();
   System.out.println("Back button clicked successfully");
}
else {
System.out.println("Back button is not clickable");
}
Thread.sleep(5000);
Actions actions = new Actions(driver);
actions.sendKeys("D").perform();
Thread.sleep(2000);
System.out.println("************************Adding dataset done***********************");

}

@Test(priority=6)
public void viewer() throws InterruptedException {
WebDriverWait wait = new WebDriverWait(driver, 60);

System.out.println("************************In mouse brain select one section and add dataset***********************");


WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Viewer']")));
if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
   viewerElement.click();
   System.out.println("Analytics icon is clicked");
} else {
   System.out.println("Analytics icon is not clickable");
}

Thread.sleep(2000);

wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[7]/td[1]" ))).click();

Thread.sleep(2000);

wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[8]/td[2]" ))).click();

Thread.sleep(5000);

wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tbody/tr[11]/td[3]" ))).click();

Thread.sleep(5000);
WebElement imageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[text()='96'])[1]")));
if (imageElement.isEnabled() && imageElement.isDisplayed()) {
imageElement.click();
   System.out.println("Section is selected successfully");
} else {
   System.out.println("Section is not selected");
}
Thread.sleep(2000);

WebElement markDatasetElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Mark Dataset']")));
if (markDatasetElement.isEnabled() && markDatasetElement.isDisplayed()) {
markDatasetElement.click();
   System.out.println("Mark Datasets icon is clicked");
} else {
   System.out.println("Mark Datasets icon is not clickable");
}
Thread.sleep(2000);

WebElement selectDatasetElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select")));
if (selectDatasetElement.isEnabled() && selectDatasetElement.isDisplayed()) {
selectDatasetElement.click();
   System.out.println("Select Dataset dropdown is clicked");
} else {
   System.out.println("Select Dataset dropdown is not clickable");
}
Thread.sleep(2000);

WebElement dropdownDatasetElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//option[text()='Automation_Datasets_2']")));
if (dropdownDatasetElement.isEnabled() && dropdownDatasetElement.isDisplayed()) {
dropdownDatasetElement.click();
   System.out.println("Dataset is selected successfully");
} else {
   System.out.println("Dataset is not selected");
}
Thread.sleep(2000);

WebElement addButtonElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='ADD']")));
if (addButtonElement.isEnabled() && addButtonElement.isDisplayed()) {
addButtonElement.click();
   System.out.println("Dataset is added successfully");
} else {
   System.out.println("Dataset is not added");
}
Thread.sleep(2000);



Thread.sleep(5000);
Actions actions = new Actions(driver);
actions.sendKeys("D").perform();
Thread.sleep(2000);

System.out.println("************************Dataset added done***********************");


}

@Test(priority=7)
public void competitions_2() throws InterruptedException {
   WebDriverWait wait = new WebDriverWait(driver, 60);
   
System.out.println("************************ Analytics tab start***********************");

   WebElement viewerElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Analytics']")));
if (viewerElement.isEnabled() && viewerElement.isDisplayed()) {
   viewerElement.click();
   System.out.println("Analytics icon is clicked");
} else {
   System.out.println("Analytics icon is not clickable");
}
   
System.out.println("************************Competitions Tab Start***********************");


WebElement competitionsELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Competitions')]")));
if (competitionsELement.isEnabled() && competitionsELement.isDisplayed()) {
competitionsELement.click();
   System.out.println("Competitions icon is clicked");
}
else {
System.out.println("Competitions icon is not clickable");
}
Thread.sleep(2000);

WebElement SelectcompetitionsELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h6[text()='Automation_competitions-2']")));
if (SelectcompetitionsELement.isEnabled() && SelectcompetitionsELement.isDisplayed()) {
SelectcompetitionsELement.click();
   System.out.println("Respective Competition is clicked");
}
else {
System.out.println("Competition is not clickable");
}
Thread.sleep(2000);

}

@Test(priority=8)
public void associateData() throws InterruptedException {

System.out.println("************************Associate Dataset start***********************");
   WebDriverWait wait = new WebDriverWait(driver, 60);


WebElement dataELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='tab-link'])[2]")));
if (dataELement.isEnabled() && dataELement.isDisplayed()) {
dataELement.click();
   System.out.println("Data button is clicked");
}
else {
System.out.println("Data button is not clickable");
}
Thread.sleep(2000);

WebElement associateELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Associate Dataset']")));
if (associateELement.isEnabled() && associateELement.isDisplayed()) {
associateELement.click();
   System.out.println("Associate Dataset button is clicked");
}
else {
System.out.println("Associate Dataset button is not clickable");
}
Thread.sleep(2000);

WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

   // Switch to the iframe
   driver.switchTo().frame(iframeElement);

WebElement nameELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='id_name']")));
if (nameELement.isEnabled() && nameELement.isDisplayed()) {
nameELement.sendKeys("Automation_AssociateDataset-2");
    System.out.println("Name written successfully");
}
else {
System.out.println("Name is not written");
}
Thread.sleep(2000);

WebElement descriptionELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@id='id_description']")));
if (descriptionELement.isEnabled() && descriptionELement.isDisplayed()) {
descriptionELement.sendKeys("Automation to add new Associate Dataset");
   System.out.println("Description written successfully");
}
else {
System.out.println("Description is not written");
}
Thread.sleep(3000);

WebElement competitionELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@id='select2-id_competition-container'])[1]")));
if (competitionELement.isEnabled() && competitionELement.isDisplayed()) {
competitionELement.click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Search']"))).sendKeys("Automation_competitions-2", Keys.ENTER);
    System.out.println("Competition selected successfully");
}
else {
System.out.println("Competiton is not selected");
}
Thread.sleep(2000);

WebElement datasetELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-id_dataset-container']")));
if (datasetELement.isEnabled() && datasetELement.isDisplayed()) {
datasetELement.click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Search']"))).sendKeys("Automation_Datasets_2", Keys.ENTER);
    System.out.println("Dataset selected successfully");
}
else {
System.out.println("Dataset is not selected");
}
Thread.sleep(2000);


WebElement saveELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type, 'submit')]")));
if (saveELement.isEnabled() && saveELement.isDisplayed()) {
saveELement.click();
   System.out.println("Associate Dataset saved successfully");
}
else {
System.out.println("Associate Dataset is not saved");
}
Thread.sleep(2000);

driver.switchTo().defaultContent();


WebElement exitELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nb-icon[@icon='close-outline']")));
if (exitELement.isEnabled() && exitELement.isDisplayed()) {
exitELement.click();
   System.out.println("Exit button was clicked successfully");
}
else {
System.out.println("Exit button is not clickable");
}
Thread.sleep(3000);

System.out.println("************************Associate Dataset end***********************");


}

@Test(priority=9)
public void addCode() throws InterruptedException {
   WebDriverWait wait = new WebDriverWait(driver, 60);


System.out.println("************************Add code start***********************");

WebElement codeELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='tab-link'])[3]")));
if (codeELement.isEnabled() && codeELement.isDisplayed()) {
codeELement.click();
   System.out.println("Code button is clicked");
}
else {
System.out.println("Code button is not clickable");
}
Thread.sleep(2000);


WebElement AddcodeELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Add Code']")));
if (AddcodeELement.isEnabled() && AddcodeELement.isDisplayed()) {
AddcodeELement.click();
   System.out.println("Add Code button is clicked");
}
else {
System.out.println("Add Code button is not clickable");
}
Thread.sleep(2000);

WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

   // Switch to the iframe
   driver.switchTo().frame(iframeElement);

WebElement fileNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='id_filename']")));
if (fileNameElement != null && fileNameElement.isDisplayed()) {
fileNameElement.sendKeys("automation_1.py");
    System.out.println("Filename was entered successfully.");
} else {
   System.out.println("Filename was not entered.");
}
Thread.sleep(2000);


WebElement userELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-id_user-container']")));
if (userELement.isEnabled() && userELement.isDisplayed()) {
userELement.click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Search']"))).sendKeys("Software team", Keys.ENTER);
   System.out.println("Username is selected successfully");
}
else {
System.out.println("Username is not selected");
}
Thread.sleep(3000);

WebElement saveELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type, 'submit')]")));
if (saveELement.isEnabled() && saveELement.isDisplayed()) {
saveELement.click();
   System.out.println("Analytics Code saved successfully");
}
else {
System.out.println("Analytics Code is not saved");
}
Thread.sleep(2000);

driver.switchTo().defaultContent();


WebElement exitELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nb-icon[@icon='close-outline']")));
if (exitELement.isEnabled() && exitELement.isDisplayed()) {
exitELement.click();
   System.out.println("Exit button was clicked successfully");
}
else {
System.out.println("Exit button is not clickable");
}
Thread.sleep(3000);

System.out.println("************************Add code end***********************");


}

@Test(priority=10)
public void associateCode() throws InterruptedException {

   WebDriverWait wait = new WebDriverWait(driver, 60);


System.out.println("************************Associate code start***********************");

WebElement associateELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Associate Code']")));
if (associateELement.isEnabled() && associateELement.isDisplayed()) {
associateELement.click();
   System.out.println("Associate Dataset button is clicked");
}
else {
System.out.println("Associate Dataset button is not clickable");
}
Thread.sleep(2000);

WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

   // Switch to the iframe
   driver.switchTo().frame(iframeElement);
   
   WebElement competitionELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-id_competition-container']")));
if (competitionELement.isEnabled() && competitionELement.isDisplayed()) {
competitionELement.click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Search']"))).sendKeys("Automation_competitions-2", Keys.ENTER);
    System.out.println("Competition selected successfully");
}
else {
System.out.println("Competiton is not selected");
}
Thread.sleep(2000);

WebElement userELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-id_user-container']")));
if (userELement.isEnabled() && userELement.isDisplayed()) {
userELement.click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Search']"))).sendKeys("Software team", Keys.ENTER);
   System.out.println("User is selected successfully");
}
else {
System.out.println("User is not selected");
}
Thread.sleep(3000);

WebElement codeELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@id='select2-id_code-container']")));
if (codeELement.isEnabled() && codeELement.isDisplayed()) {
codeELement.click();
wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-label='Search']"))).sendKeys("automation_1.py", Keys.ENTER);
   System.out.println("Code is selected successfully");
}
else {
System.out.println("Code is not selected");
}
Thread.sleep(3000);

WebElement saveELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@type, 'submit')]")));
if (saveELement.isEnabled() && saveELement.isDisplayed()) {
saveELement.click();
   System.out.println("Associate Dataset saved successfully");
}
else {
System.out.println("Associate Dataset is not saved");
}
Thread.sleep(2000);

driver.switchTo().defaultContent();


WebElement exitELement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//nb-icon[@icon='close-outline']")));
if (exitELement.isEnabled() && exitELement.isDisplayed()) {
exitELement.click();
   System.out.println("Exit button was clicked successfully");
}
else {
System.out.println("Exit button is not clickable");
}
Thread.sleep(3000);
System.out.println("************************Associate code end***********************");

}

@AfterTest
public void afterTest() {
driver.quit();
}

}