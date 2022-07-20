package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Publish {
    public WebDriver driver;

    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
    By PublishToggle = By.id("publish");
    //    By GetHeader = By.xpath("/html/body/header/div[1]/h2");
    By PublishGetHeader = By.xpath("/html/body/nav/div[1]/span[2]");

    // publish new content btn
    By PublishNewContentBtn = By.xpath("/html/body/div/button");
    By PublishNewContentTabs = By.xpath("//*[contains(@class,'tab-btn')]");

    //Publish new content
    By ContentOptions = By.xpath("//*[@class='form-select svelte-qh94tu']");

    By PublishContentDescriptionTextArea = By.xpath("//*[@placeholder='Description']");
    By NextStepBtn = By.xpath("/html/body/footer/div[2]/button[2]");
    By IndividualOption = By.id("individual");
    By StudentNamesInput = By.id("lang");
    By FinalPublishBtn = By.xpath("/html/body/footer/div[2]/button[2]");

    // student publish module
    By PublishContentOnTop = By.xpath("//*[contains(@class,'doubts-card')][1]/div");
    By BackAfterPublish = By.xpath("/html/body/nav/div[1]/div/span[1]");
    By FirstContentTime = By.xpath("/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]");

    public Publish(WebDriver driver2) { this.driver = driver2; }
    public WebElement PublishToggle() { return driver.findElement(PublishToggle); }

    public WebElement StudentImageClick() { return driver.findElement(StudentImageClick); }
    public String PublishGetHeader(){return driver.findElement(PublishGetHeader).getText();}
    public WebElement PublishNewContentBtn(){return driver.findElement(PublishNewContentBtn);}
    public List<WebElement> PublishNewContentTabs(){return driver.findElements(PublishNewContentTabs);}

    public List<WebElement> ContentOptions(){return driver.findElements(ContentOptions);}
    public WebElement PublishContentDescriptionTextArea(){return driver.findElement(PublishContentDescriptionTextArea);}
    public WebElement NextStepBtn(){return driver.findElement(NextStepBtn);}
    public WebElement IndividualOption(){return driver.findElement(IndividualOption);}
    public WebElement StudentNamesInput(){return driver.findElement(StudentNamesInput);}
    public WebElement FinalPublishBtn(){return driver.findElement(FinalPublishBtn);}
    public WebElement PublishContentOnTop(){return driver.findElement(PublishContentOnTop);}
    public WebElement BackAfterPublish(){return driver.findElement(BackAfterPublish);}
    public WebElement FirstContentTime(){return driver.findElement(FirstContentTime);}



}
