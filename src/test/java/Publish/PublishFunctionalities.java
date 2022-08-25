package Publish;

import executions.PublishMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.Publish;
import resources.Base;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import testResource.Listners;
import testResource.ReadExcelFile;

public class PublishFunctionalities extends Base{
//    private final Logger demoLogger = LogManager.getLogger(PublishFunctionalities.class.getName());
    public WebDriver driver;
    public Publish pub;

    public PublishMethods pubmethods;

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
//        demoLogger.info("Standard logic building");
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        pub = new Publish(driver); // Structured page object model function defined
        pubmethods = new PublishMethods(driver);
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the publish module.")
    @Story("TPUBFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentdata", priority = 1)
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(pubmethods.studentLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Publish module.")
    @Story("PUBFT-01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherdata", priority = 2)
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(pubmethods.teacherLanding(driver, mobNumber, password));
    }


    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Publish module.")
    @Story("PUBFT-02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherdata", priority = 3)
    public void teacherPublishNewContentBtnCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(pubmethods.teacherPublishNewContentBtnCheck(driver, mobNumber, password));
    }


    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully publish new content.")
    @Story("PUBFT-03")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherdata", priority = 4)
    public void teacherPublishNewContentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(pubmethods.teacherPublishNewContentCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view the published content published by teacher.")
    @Story("TPUBFS_02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentdata", priority = 5)
    public void studentPublishNewContentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(pubmethods.studentPublishNewContentCheck(driver, mobNumber, password));
    }


    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully view and like the published content.")
    @Story("TPUBFS_03")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentdata", priority = 6)
    public void studentPublishViewsandLikes(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(pubmethods.studentPublishViewsandLikes(driver, mobNumber, password));
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully navigate to next pages.")
    @Story("TPUBFS_04")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "studentdata", priority = 7)
    public void studentPublishPagination(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(pubmethods.studentPublishPagination(driver, mobNumber, password));
    }

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully navigate to next pages.")
    @Story("PUBFT-04")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "teacherdata", priority = 8)
    public void teacherPublishPagination(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(pubmethods.teacherPublishPagination(driver, mobNumber, password));
    }


    // PublishTeacherCategoryFilters_Student

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully filter content according to Teacher.")
    @Story("TPUBFS_05")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentdata", priority = 9)
    public void studentTeacherCategoryFilters(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(pubmethods.studentPublishTeacherFilter(driver, mobNumber, password));
    }

    // PublishSubjectLessonCategoryFilters_Teacher

    @Epic("This story represents the Publish module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully filter the content according to book.")
    @Story("PUBFT-05")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherdata", priority = 10)
    public void teacherSubjectLessonCategoryFilters(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(pubmethods.teacherSubjectLessonCategoryFilters(driver, mobNumber, password));
    }






    @AfterMethod // Method will work After each method inside this class
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "studentdata")
    public Object[][] getstudentData() {
//		Object[][] loginData = { { "9000000001", "123456" } };
        Object[][] loginData = ReadExcelFile.TestcasesCredentials("student");

        return loginData;
    }
    @DataProvider(name = "teacherdata")
    public Object[][] getteacherData() {
//		Object[][] loginData = { { "9000000101", "123456" } };
        Object[][] loginData = ReadExcelFile.TestcasesCredentials("teacher");

        return loginData;
    }

}
