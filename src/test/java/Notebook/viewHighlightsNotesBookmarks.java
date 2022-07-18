package Notebook;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.Notebook;
import resources.Base;
import testResource.BaseLogin;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public class viewHighlightsNotesBookmarks extends Base {
    public Notebook note;
    public LoginPage log;
    public WebDriver driver;

    @BeforeMethod
    public void standardLogic() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        note = new Notebook(driver);
        log = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    public void ThreadSleep5000() throws InterruptedException {
        Thread.sleep(5000);
    }

    public void ValidateTest(String actual_grade, String expected_grade){
        if (actual_grade.equals(expected_grade)) {
            System.out.println("PASSED");
        } else {
            Assert.fail();
        }
    }

    @Epic("This story represents the Notebook module of the onelern_school project.")
    @Description("To see if a student can view highlights, notes and bookmarks from library in Notebook")
    @Story("NOTFS_05")
    @Test(dataProvider = "Studentdata")
    public void CheckStudentHighlightsNotesBookmarks(String mobNumber, String password) throws IOException, InterruptedException, UnsupportedFlavorException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        ThreadSleep5000();
        note.StudentImageClick().click();
        ThreadSleep5000();
        note.LibraryToggle().click();

        if (mob >= 9000000001l && mob <= 9000000020l) {// English
            note.EnvironmentalCoursebookGrade1().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            ThreadSleep5000();

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.EnvFirstLessonFirstTopicRefGrade1();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

//            action.moveToElement(element).doubleClick().clickAndHold().moveByOffset(50,0).release().perform();
//            action.moveToElement(element).clickAndHold().moveByOffset(50,0).release().perform();
             action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);

            note.greenBtn().click();
            ThreadSleep5000();

            note.BackButton().click();
            ThreadSleep5000(); ThreadSleep5000();

            note.BackButton().click();
            ThreadSleep5000(); ThreadSleep5000();

            note.BackButton().click();
            ThreadSleep5000(); ThreadSleep5000();

            note.NotebookToggle().click();
            ThreadSleep5000();

            note.EnvironmentalCoursebookGrade1().click();
            ThreadSleep5000();

            note.FirstLesson().click();
            Thread.sleep(2000);

            note.SearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(highlighted_text);
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook = contents.get(contents.size()-1).getText();

            // Remove Highlighted content
            note.BackButton().click();
            ThreadSleep5000();
            note.BackButton().click();
            ThreadSleep5000();

            note.LibraryToggle().click();
            ThreadSleep5000();

            note.EnvironmentalCoursebookGrade1().click();
            ThreadSleep5000();
            note.FirstLesson().click();
            ThreadSleep5000();
            note.FirstTopic().click();
            ThreadSleep5000();


            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,50, 0).click().keyUp(Keys.SHIFT).build().perform();

            note.deleteBtn().click();
            ThreadSleep5000();

            ValidateHighlight(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) {// English
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 2 ";

            ValidateTest(actual_grade, expected_grade);

        }

        else if (mob >= 9000000041l && mob <= 9000000060l) {// English
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 3 ";

            ValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 4 ";

            ValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 5 ";

            ValidateTest(actual_grade, expected_grade);
        }

    }

    private void ValidateHighlight(String highlighted_text, String content_in_notebook) {
        if(content_in_notebook.contains(highlighted_text)){
            System.out.println("PASSED");
        }
        else{
            Assert.fail();
        }
    }

    @Epic("This story represents the Library module of the onelern_school project.")
    @Description("To see if a teacher can view highlights, notes and bookmarks from library in Notebook")
    @Story("NOTFT_05")
    @Test(dataProvider = "Teachersdata")
    public void CheckTeacherHighlightsNotesBookmarks(String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        ThreadSleep5000();
        note.NotebookToggle().click();
        if (mob >= 9000000101l && mob <= 9000000104l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 1 ";

            ValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 2 ";

            ValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 3 ";

            ValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 4 ";

            ValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 5 ";

            ValidateTest(actual_grade, expected_grade);
        }

    }




    @DataProvider(name = "Studentdata")
    public Object[][] getstudentData() throws FileAlreadyExistsException {

//        Object loginData[][] = { { "9000000001", "123456" }, { "9000000024", "123456" }, { "9000000046", "123456" },
//                { "9000000069", "123456" }, { "9000000081", "123456" } };

        Object loginData[][] = { { "9000000001", "123456" }};
        return loginData;
    }

    @DataProvider(name = "Teachersdata")
    public Object[][] getteacherData() throws FileAlreadyExistsException {

        Object loginData[][] = { { "9000000101", "123456" }, { "9000000105", "123456" }, { "9000000110", "123456" },
                { "9000000114", "123456" }, { "9000000120", "123456" } };
//        Object loginData[][] = { { "9000000101", "123456" }};
        return loginData;
    }

}
