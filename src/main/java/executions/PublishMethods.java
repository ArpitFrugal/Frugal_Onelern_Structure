package executions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.LoginPage;
import pageObjects.Publish;
import resources.BaseLogin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublishMethods extends BaseLogin {
    public Publish pub;
    public LoginPage log;
    public WebDriver driver;
    JavascriptExecutor js;
    Map<String, String> map = new HashMap<>();


    public PublishMethods(WebDriver driver2) {
        super(driver2);
    }

    public void ThreadSleep5000() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void studentblock(WebDriver driver, String mobileNo, String pass) throws InterruptedException, IOException {
        this.log = new LoginPage(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobileNo, pass);
    }
    public void teacherblock(WebDriver driver, String mobileNo, String pass) throws InterruptedException, IOException {
        this.log = new LoginPage(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobileNo, pass);
    }

    // Landing page check
    public boolean LandingPageValidateTest(String actual_header, String expected_header ){
        System.out.println(actual_header + " "+ expected_header);
        if (actual_header.equals(expected_header)) {
            System.out.println("Notebook Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean studentLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        pub.StudentImageClick().click();
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(2000);

        String actual_header = pub.PublishGetHeader();
        String expected_header = "Teacher Published Content";
        return LandingPageValidateTest(actual_header, expected_header);
    }

    public boolean teacherLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(2000);

        String actual_header = pub.PublishGetHeader();
        String expected_header = "Publish Content";
        return LandingPageValidateTest(actual_header, expected_header);
    }


    // New Content Btn Check
    public boolean PublishNewBtnValidateTest(List<WebElement> tabs){
        if (tabs.size() > 1) {
            System.out.println("Notebook Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherPublishNewContentBtnCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(5000);

        pub.PublishNewContentBtn().click();
        Thread.sleep(2000);
        List<WebElement> tabs = pub.PublishNewContentTabs();

        return PublishNewBtnValidateTest(tabs);
    }

    // publish content

    public boolean NewContentValidateTest(String actual_text, String expected_text) {
        System.out.println(actual_text+" "+expected_text);
        if(actual_text.contains(expected_text)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean studentPublishNewContentCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        pub.StudentImageClick().click();
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(2000);

        String FirstContent = pub.PublishContentOnTop().getText();
        if (mob >= 9000000001l && mob <= 9000000020l) {
            String GradeContent = map.get("Grade 1");
            return NewContentValidateTest(FirstContent, GradeContent);
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) {
            String GradeContent = map.get("Grade 2");
            return NewContentValidateTest(FirstContent, GradeContent);
        }

        else if (mob >= 9000000041l && mob <= 9000000060l) {
            String GradeContent = map.get("Grade 3");
            return NewContentValidateTest(FirstContent, GradeContent);
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) {
            String GradeContent = map.get("Grade 4");
            return NewContentValidateTest(FirstContent, GradeContent);
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) {
            String GradeContent = map.get("Grade 5");
            return NewContentValidateTest(FirstContent, GradeContent);
        }
        return false;
    }


    public boolean teacherPublishNewContentCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(5000);

        pub.PublishNewContentBtn().click();
        Thread.sleep(5000);

        List<WebElement> ContentOptions = pub.ContentOptions();
        int i=0;
        for(WebElement webElement:ContentOptions){
            if(i==0 || i==3 || i==4){
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
            }
            else{
                webElement.sendKeys(Keys.ENTER);
            }
            i+=1;
            Thread.sleep(2000);
        }
        Thread.sleep(3000);

        if(mob >= 9000000101l && mob <= 9000000104l){
            String publishContent = "Grade 1 Content";
            map.put("Grade 1",publishContent);

            pub.PublishContentDescriptionTextArea().click();
            pub.PublishContentDescriptionTextArea().sendKeys(publishContent);
            Thread.sleep(3000);
            pub.NextStepBtn().click();
            Thread.sleep(3000);
            pub.IndividualOption().click();
            pub.StudentNamesInput().click();
            pub.StudentNamesInput().sendKeys(Keys.ARROW_DOWN);
            pub.StudentNamesInput().sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            pub.FinalPublishBtn().click();
            Thread.sleep(5000);
            pub.BackAfterPublish().click();

            String actual_time = pub.FirstContentTime().getText();
            String expected_time = "a minute ago";
            return NewContentValidateTest(actual_time, expected_time);
        }
        else if (mob >= 9000000105l && mob <= 9000000108l) {
            String publishContent = "Grade 2 Content";
            map.put("Grade 2",publishContent);

            pub.PublishContentDescriptionTextArea().click();
            pub.PublishContentDescriptionTextArea().sendKeys(publishContent);
            Thread.sleep(3000);
            pub.NextStepBtn().click();
            Thread.sleep(3000);
            pub.IndividualOption().click();
            pub.StudentNamesInput().click();
            pub.StudentNamesInput().sendKeys(Keys.ARROW_DOWN);
            pub.StudentNamesInput().sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            pub.FinalPublishBtn().click();
            Thread.sleep(5000);
            pub.BackAfterPublish().click();

            String actual_time = pub.FirstContentTime().getText();
            String expected_time = "a minute ago";
            return NewContentValidateTest(actual_time, expected_time);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {
            String publishContent = "Grade 3 Content";
            map.put("Grade 3",publishContent);

            pub.PublishContentDescriptionTextArea().click();
            pub.PublishContentDescriptionTextArea().sendKeys(publishContent);
            Thread.sleep(3000);
            pub.NextStepBtn().click();
            Thread.sleep(3000);
            pub.IndividualOption().click();
            pub.StudentNamesInput().click();
            pub.StudentNamesInput().sendKeys(Keys.ARROW_DOWN);
            pub.StudentNamesInput().sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            pub.FinalPublishBtn().click();
            Thread.sleep(5000);
            pub.BackAfterPublish().click();

            String actual_time = pub.FirstContentTime().getText();
            String expected_time = "a minute ago";
            return NewContentValidateTest(actual_time, expected_time);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            String publishContent = "Grade 4 Content";
            map.put("Grade 4",publishContent);

            pub.PublishContentDescriptionTextArea().click();
            pub.PublishContentDescriptionTextArea().sendKeys(publishContent);
            Thread.sleep(3000);
            pub.NextStepBtn().click();
            Thread.sleep(3000);
            pub.IndividualOption().click();
            pub.StudentNamesInput().click();
            pub.StudentNamesInput().sendKeys(Keys.ARROW_DOWN);
            pub.StudentNamesInput().sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            pub.FinalPublishBtn().click();
            Thread.sleep(5000);
            pub.BackAfterPublish().click();

            String actual_time = pub.FirstContentTime().getText();
            String expected_time = "a minute ago";
            return NewContentValidateTest(actual_time, expected_time);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            String publishContent = "Grade 5 Content";
            map.put("Grade 5",publishContent);

            pub.PublishContentDescriptionTextArea().click();
            pub.PublishContentDescriptionTextArea().sendKeys(publishContent);
            Thread.sleep(3000);
            pub.NextStepBtn().click();
            Thread.sleep(3000);
            pub.IndividualOption().click();
            pub.StudentNamesInput().click();
            pub.StudentNamesInput().sendKeys(Keys.ARROW_DOWN);
            pub.StudentNamesInput().sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            pub.FinalPublishBtn().click();
            Thread.sleep(5000);
            pub.BackAfterPublish().click();

            String actual_time = pub.FirstContentTime().getText();
            String expected_time = "a minute ago";
            return NewContentValidateTest(actual_time, expected_time);
        }
        return false;
    }



}
