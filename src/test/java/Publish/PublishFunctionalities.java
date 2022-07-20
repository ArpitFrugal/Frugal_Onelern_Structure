package Publish;

import executions.NotebookMethods;
import executions.PublishMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Notebook;
import pageObjects.Publish;
import resources.Base;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class PublishFunctionalities extends Base {
    public WebDriver driver;
    public Publish pub;

    public PublishMethods pubmethods;
    public String student = "student";
    public String teacher = "teacher";

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        pub = new Publish(driver); // Structured page object model function defined
        pubmethods = new PublishMethods(driver);
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the publish module.")
    @Story("PUBFS_01")
    @Test(dataProvider = "studentdata")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(pubmethods.studentLanding(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Publish module.")
    @Story("PUBFT-01")
    @Test(dataProvider = "teacherdata")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(pubmethods.teacherLanding(driver, mobNumber, password), true);
    }


    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Publish module.")
    @Story("PUBFT-02")
    @Test(dataProvider = "teacherdata")
    public void teacherPublishNewContentBtnCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(pubmethods.teacherPublishNewContentBtnCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view the published content published by teacher.")
    @Story("PUBFS_02")
    @Test(dataProvider = "studentdata", priority = 2)
    public void studentPublishNewContentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(pubmethods.studentPublishNewContentCheck(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully publish new content.")
    @Story("PUBFT-03")
    @Test(dataProvider = "teacherdata", priority = 1)
    public void teacherPublishNewContentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(pubmethods.teacherPublishNewContentCheck(driver, mobNumber, password), true);
    }

    




        @AfterMethod // Method will work After each method inside this class
    public void tearDown() {
        driver.close();
    }

    @DataProvider(name = "studentdata")
    public Object[][] getstudentData() throws FileAlreadyExistsException {

//        Object loginData[][] = { { "9000000001", "123456" }, { "9000000024", "123456" }, { "9000000046", "123456" },
//                { "9000000069", "123456" }, { "9000000081", "123456" } };
        Object loginData[][] = { { "9000000001", "123456" } };

        return loginData;
    }
    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = { { "9000000101", "123456" }, { "9000000105", "123456" }, { "9000000110", "123456" },
//                { "9000000114", "123456" }, { "9000000120", "123456" } };
        Object loginData[][] = { { "9000000101", "123456" } };

        return loginData;
    }

}
