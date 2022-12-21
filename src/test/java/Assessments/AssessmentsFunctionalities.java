package Assessments;

import executions.AssessmentMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Assessment;
import resources.Base;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class AssessmentsFunctionalities extends Base {
    public Assessment ass;
    public AssessmentMethods assMethods;
    public WebDriver driver;

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        ass = new Assessment(driver); // Structured page object model function defined
        assMethods = new AssessmentMethods(driver);
    }
    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the Assessment module.")
    @Story("ASSFS_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "studentData")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(assMethods.studentLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Assessment module.")
    @Story("ASSFT_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(assMethods.teacherLanding(driver, mobNumber, password));
    }


    // Attempt assessment


    // View report btn check

    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully open the report.")
    @Story("ASSFS_03")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "studentData")
    public void StudentViewReportBtnCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(assMethods.StudentViewReportBtnCheck(driver, mobNumber, password));
    }




    // search functionality
    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully search an assessment.")
    @Story("ASSFS_06")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "studentData")
    public void studentSearchAssessmentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(assMethods.studentSearchAssessmentCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully search an assessment.")
    @Story("ASSFT_08")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void teacherSearchAssessmentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(assMethods.teacherSearchAssessmentCheck(driver, mobNumber, password));
    }


    // Create assessment online

    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully create Online assessment for the students.")
    @Story("ASSFT_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherCreateAssessment_Online(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(assMethods.teacherCreateAssessment_Online(driver, mobNumber, password));
    }

    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully create Pen & paper assessment for the students.")
    @Story("ASSFT_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherCreateAssessment_PenPaper(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(assMethods.teacherCreateAssessment_PenPaper(driver, mobNumber, password));
    }

    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully fetch ongoing assessments from ongoing tab.")
    @Story("ASSFT_05")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void teacherOngoingAssessmentsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(assMethods.teacherOngoingAssessmentsCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully draft assessment for the students.")
    @Story("ASSFT_03")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void teacherDraftAssessmentsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(assMethods.teacherDraftAssessmentsCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Assessment module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully fetch completed assessments from ongoing tab.")
    @Story("ASSFT_07")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "teacherData")
    public void teacherCompletedAssessmentsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(assMethods.teacherCompletedAssessmentsCheck(driver, mobNumber, password));
    }





        @AfterMethod // Method will work After each method inside this class
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "studentData")
    public Object[][] getstudentData() throws FileAlreadyExistsException {
//		Object loginData[][] = { { "9000000001", "123456" } };
//        return loginData;
        return getStudentData();
    }

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
