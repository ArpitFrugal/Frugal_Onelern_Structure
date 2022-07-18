package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LoginPage {
    public WebDriver driver;
    By studentSignIn = By.id("student");
    By teacherSignIn = By.id("teacher");
    By othersSignIn = By.id("others");
    By password = By.id("user-password");
    By submitButton = By.id("user-submit");
    By PasswordSubmit = By.id("password-submit");
    By loginWithPassword = By.xpath("/html/body/div[4]/div/div/div[2]/button[2]");
    By okText = By.id("ok-btn");
    By UserName = By.id("mobile-number");

    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");

    // constructor
    public LoginPage(WebDriver driver2) {
        // TODO Auto-generated constructor stub
        this.driver = driver2;
    }
    // Get Student login page access
    public WebElement getStudentSignIn() {
        return driver.findElement(studentSignIn);
    }
    // Get Teacher login page access
    public WebElement getTeacherSignIn() {
        return driver.findElement(teacherSignIn);
    }
    // Get Student Others page access
    public WebElement getOthersSignIn() {
        return driver.findElement(othersSignIn);
    }
    // Get username block access
    public WebElement getUserName() {
        return driver.findElement(UserName);
    }
    // Get password block access
    public WebElement getPassword() {
        return driver.findElement(password);
    }
    // Get Submit button
    public WebElement getSubmitButton() {
        return driver.findElement(submitButton);
    }
    //Get Password Submit Button
    public WebElement getPasswordButton() {
        return driver.findElement(PasswordSubmit);
    }
    // Get login with password text
    public WebElement getloginWithPassword() {
        return driver.findElement(loginWithPassword);
    }
    // Get ok text
    public WebElement okText() {
        return driver.findElement(okText);
    }
    public WebElement StudentImageClick() {
        return driver.findElement(StudentImageClick);
    }
}