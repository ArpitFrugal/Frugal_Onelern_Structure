package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Publish {
    public WebDriver driver;
    public static int contentSequenceCounter = 1;
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
    By PublishGradeSectionInput = By.xpath("//select[contains(@class,'form-select')]");
    By FinalPublishBtn = By.xpath("/html/body/footer/div[2]/button[2]");

    // student publish module
    By PublishContentOnTop = By.xpath("//*[contains(@class,'doubts-card')][1]/div");
    By BackAfterPublish = By.xpath("/html/body/nav/div[1]/div/span[1]");
    By FirstContentTime = By.xpath("/html/body/div/div/div[2]/div[2]/table/tbody/tr[1]/td[4]");
    By OutsideViewCount = By.xpath("//span[contains(@class,'view-count')]");
    By ContentMetaData = By.xpath("//*[contains(@class,'doubts-card')]//div");
    By InsideViewCount = By.xpath("/html/body/div/div[5]/div[1]/div[1]/span");
    By LikeBtn = By.xpath("//button[text()='Yes']");
    By DisLikeBtn = By.xpath("//button[text()='No']");
    By LikeCount = By.xpath("/html/body/div/div[5]/div[1]/div[2]/span");
    // pagination
    By BackNavigate = By.xpath("//*[contains(@class,'option prev')]");
    By NextNavigate = By.xpath("//*[contains(@class,'option next')]");
    By PaginationText = By.className("pagination-text");
    // Teacher filter
    By TeacherNameInput = By.xpath("//input[@placeholder='Search Teacher']");
    By FirstTeacherInList = By.xpath("//*[@class='listItem']");
    By DoubtCards = By.xpath("//*[contains(@class,'doubts-card')]");

    // Book filter
    By TeacherFilterOptions = By.xpath("//*[@class= 'form-select svelte-egeff7']");
    By ContentList = By.xpath("//tr[@class= 'svelte-egeff7']");
    By FirstCategoryFilterOption = By.xpath("//*[@for='showing_0']");


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
    public List<WebElement> PublishGradeSectionInput(){return driver.findElements(PublishGradeSectionInput);}
    public WebElement StudentNamesInput(){return driver.findElement(StudentNamesInput);}
    public WebElement FinalPublishBtn(){return driver.findElement(FinalPublishBtn);}
    public WebElement PublishContentOnTop(){return driver.findElement(PublishContentOnTop);}
    public WebElement BackAfterPublish(){return driver.findElement(BackAfterPublish);}
    public WebElement FirstContentTime(){return driver.findElement(FirstContentTime);}
    public WebElement OutsideViewCount(){return driver.findElement(OutsideViewCount);}
    public WebElement ContentMetaData(){return driver.findElement(ContentMetaData);}
    public WebElement InsideViewCount(){return driver.findElement(InsideViewCount);}
    public WebElement LikeBtn(){return driver.findElement(LikeBtn);}
    public WebElement DisLikeBtn(){return driver.findElement(DisLikeBtn);}
    public WebElement LikeCount(){return driver.findElement(LikeCount);}

    // pagination
    public WebElement BackNavigate(){return driver.findElement(BackNavigate);}
    public WebElement NextNavigate(){return driver.findElement(NextNavigate);}
    public WebElement PaginationText(){return driver.findElement(PaginationText);}

    // filters
    public WebElement TeacherNameInput(){return driver.findElement(TeacherNameInput);}
    public WebElement FirstTeacherInList(){return driver.findElement(FirstTeacherInList);}
    public List<WebElement> DoubtCards(){return driver.findElements(DoubtCards);}
    public List<WebElement> TeacherFilterOptions(){return driver.findElements(TeacherFilterOptions);}
    public List<WebElement> ContentList(){return driver.findElements(ContentList);}
    public WebElement FirstCategoryFilterOption(){return driver.findElement(FirstCategoryFilterOption);}
}
