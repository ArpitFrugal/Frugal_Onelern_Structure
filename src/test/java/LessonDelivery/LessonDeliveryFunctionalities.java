package LessonDelivery;

import executions.LessonDeliveryMethods;
import executions.StudentGroupsMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LessonDelivery;
import pageObjects.StudentGroups;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class LessonDeliveryFunctionalities extends Base {
    public WebDriver driver;
    public LessonDelivery ld;

    public LessonDeliveryMethods ldmethods;

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
//        demoLogger.info("Standard logic building");
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        ld = new LessonDelivery(driver); // Structured page object model function defined
        ldmethods = new LessonDeliveryMethods(driver);
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Lesson Delivery module.")
    @Story("LDFT_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.teacherLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To see if a teacher of a specific grade has the correct grade book")
    @Story("LIBFT_02")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void CheckTeacherBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.CheckTeacherBookGrade(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("To check if the teacher workbook name is the same as that mentioned in the Lesson Delivery image")
    @Story("LDFT_03")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherWorkbookCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherWorkbookCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LDFT_04")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherLessonNameCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson plan name should be clearly visible.")
    @Story("LDFT_05")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherLessonPlanNameCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherLessonPlanNameCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson plan overview should be clearly visible.")
    @Story("LDFT_06")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherLessonPlanOverviewCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherLessonPlanOverviewCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson plan components should be clearly visible.")
    @Story("LDFT_07")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherLessonPlanComponentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherLessonPlanComponentCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Teacher should be able to start, resume, and end sessions whenever needed.")
    @Story("LDFT_08")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherStartEndSessionCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherStartEndSessionCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Teacher should be able to view the correct tags tagged to the learning plans.")
    @Story("LDFT_09")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherCompletedOngoingTagCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherCompletedOngoingTagCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Teacher should be able to able to create learning plan successfully.")
    @Story("LDFT_10")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherCreateLearningPlanCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherCreateLearningPlanCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Teacher should be able to able to edit the learning plan successfully.")
    @Story("LDFT_11")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherEditLearningPlanCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherEditLearningPlanCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Teacher should be able to able to delete the learning plan successfully.")
    @Story("LDFT_12")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherDeleteLearningPlanCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherDeleteLearningPlanCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Teacher should be able to able to view the correct completion percentage successfully.")
    @Story("LDFT_13")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherCompletePercentageCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherCompletePercentageCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Teacher should be able to insert link while creating learning plan successfully.")
    @Story("LDFT_14")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherInsertLinkCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherInsertLinkCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Teacher should be able to insert image while creating learning plan successfully.")
    @Story("LDFT_15")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherInsertImageCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherInsertImageCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Teacher should be able to insert PDF while creating learning plan successfully.")
    @Story("LDFT_16")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherInsertPDFCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherInsertPDFCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Teacher should be able to insert Audio while creating learning plan successfully.")
    @Story("LDFT_17")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherInsertAudioCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherInsertAudioCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Lesson Delivery module of the onelern_school project.")
    @Description("Teacher should be able to insert Video while creating learning plan successfully.")
    @Story("LDFT_18")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "teacherData")
    public void TeacherInsertVideoCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(ldmethods.TeacherInsertVideoCheck(driver, mobNumber, password));
    }

    @AfterMethod // Method will work After each method inside this class
    public void tearDown() {
        driver.quit();
    }


    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
        Object loginData[][] = {{"9000000101", "123456"}};
        return loginData;
//        return getTeacherData();
    }
}
