package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testBase.basePage;

public class homePage extends basePage {

    // WebElements
    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameBox;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordBox;

    @FindBy(xpath = "//input[@value='Log In']")
    WebElement loginBtn;

    @FindBy(xpath = "//h1[@class='title']")
    WebElement pageTitle;

    // Constructor
    public homePage() {
        PageFactory.initElements(driver, this); // Initialize WebElements
    }

    // Methods to interact with WebElements
    public void sendUsername(String username) {
        usernameBox.clear();
        usernameBox.sendKeys(username);
    }

    public void sendPassword(String password) {
        passwordBox.clear();
        passwordBox.sendKeys(password);
    }

    public void clickLogin() {
        loginBtn.click();
    }

    // Method to get the page title
    public String getPageTitle() {
        return pageTitle.getText();
    }
}