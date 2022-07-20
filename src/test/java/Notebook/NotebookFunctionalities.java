package Notebook;

import executions.LibraryMethods;
import executions.NotebookMethods;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.Library;
import pageObjects.Notebook;
import resources.Base;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class NotebookFunctionalities extends Base {
    public Notebook note;
    public WebDriver driver;
    public NotebookMethods notemethods;
    public String student = "student";
    public String teacher = "teacher";

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        note = new Notebook(driver); // Structured page object model function defined
        notemethods = new NotebookMethods(driver);
    }

    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("Examine whether or not the student can successfully get inside the notebook module.")
    @Story("NOTFS_01")
    @Test(dataProvider = "studentdata")
    public void studentLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(notemethods.studentLanding(driver, mobNumber, password),true);
    }
    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("Examine whether or not the teacher can successfully get inside the Notebook module.")
    @Story("NOTFT-01")
    @Test(dataProvider = "teacherdata")
    public void teacherLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(notemethods.teacherLanding(driver, mobNumber, password),true);
    }

    // Grade Check
    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("To see if a student in a specific grade has the correct grade book")
    @Story("NOTFS_02")
    @Test(dataProvider = "studentdata")
    public void CheckStudentBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(notemethods.CheckStudentBookGrade(driver,mobNumber,password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To see if a teacher of a specific grade has the correct grade book")
    @Story("NOTFT_02")
    @Test(dataProvider = "teacherdata")
    public void CheckTeacherBookGrade(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertEquals(notemethods.CheckTeacherBookGrade(driver, mobNumber, password), true);
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFS_03")
    @Test(dataProvider = "studentdata")
    public void StudentLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertEquals(notemethods.StudentLessonNameCheck(driver, mobNumber, password), true);
    }
    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("Whichever option is selected, the lesson name should be clearly visible.")
    @Story("LIBFT_03")
    @Test(dataProvider = "teacherdata")
    public void TeacherLessonNameCheck(String mobNumber, String password) throws  IOException, InterruptedException {
        Assert.assertEquals(notemethods.TeacherLessonNameCheck(driver, mobNumber, password), true);
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
