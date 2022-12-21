package Analytics;

import executions.AnalyticsMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Analytics;
import resources.Base;
import testResource.BaseLogin;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class AnalyticsFunctionalities extends Base {
    public WebDriver driver;
    public Analytics ana;
    public AnalyticsMethods anamethods;

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
//        demoLogger.info("Standard logic building");
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        ana = new Analytics(driver); // Structured page object model function defined
        anamethods = new AnalyticsMethods(driver);
    }

    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Analytics module.")
    @Story("ANAFT_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.teacherLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to filter the learning outcomes according to the count needed.")
    @Story("ANAFT_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void LearningOutcomesFilterCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.LearningOutcomesFilterCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to open the learning outcomes successfully.")
    @Story("ANAFT_04")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void LearningOutcomesCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.LearningOutcomesCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to view all the attempted students.")
    @Story("ANAFT_05")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void LearningOutcomesStudentsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.LearningOutcomesStudentsCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to see attempted and non-attempted students successfully.")
    @Story("ANAFT_06")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void LearningOutcomesAttemptedCountCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.LearningOutcomesAttemptedCountCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to see the student's profile.")
    @Story("ANAFT_07")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void LOStudentProfileCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.LOStudentProfileCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to see the student's grade in his/her profile.")
    @Story("ANAFT_08")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void LOStudentProfileGradeCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.LOStudentProfileGradeCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to select only topics with accuracy greater than 0%.")
    @Story("ANAFT_09")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void EoSQTopicsenabledisableCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.EoSQTopicsenabledisableCheck(driver, mobNumber, password));
    }

    @Description("Examine whether or not the teacher should be able to view the lessons and can open them to view detailed scores.")
    @Story("ANAFT_10")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void EoSQLessonTopicsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.EoSQLessonTopicsCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to view all the attempted students in EoSQ Performance.")
    @Story("ANAFT_11")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void EoSQStudentsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.EoSQStudentsCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to see attempted and non-attempted students successfully.")
    @Story("ANAFT_12")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void EoSQAttemptedCountCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.EoSQAttemptedCountCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to see the student's profile.")
    @Story("ANAFT_13")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void EOSQStudentProfileCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.EOSQStudentProfileCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to see the student's grade in his/her profile.")
    @Story("ANAFT_14")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void EOSQStudentProfileGradeCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.EOSQStudentProfileGradeCheck(driver, mobNumber, password));
    }
    @Epic("This story represents the Analytics module of the onelern_school project.")
    @Description("Examine whether or not the teacher should be able to see total students successfully.")
    @Story("ANAFT_15")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "teacherData")
    public void EoLTStudentsCountCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(anamethods.EoLTStudentsCountCheck(driver, mobNumber, password));
    }

    @DataProvider(name = "teacherData")
    public Object[][] getteacherData() throws FileAlreadyExistsException {
//        Object loginData[][] = {{"9000000101", "123456"}};
//        return loginData;
        return getTeacherData();
    }
}
