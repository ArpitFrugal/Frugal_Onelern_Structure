package executions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import pageObjects.Notebook;
import resources.BaseLogin;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
public class NotebookMethods extends BaseLogin {
    public Notebook note;
    public LoginPage log;
    public WebDriver driver;


    public NotebookMethods(WebDriver driver2) throws FileNotFoundException {
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

    // landing page check

    public boolean NotebookPageLandingValidateTest(String actual_header){
        if (actual_header.equals("Notebook")) {
            System.out.println("Notebook Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean studentLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        studentblock(driver, mobNumber, password);
        this.note = new Notebook(driver);
        note.NotebookToggle().click();
        Thread.sleep(2000);

        String actual_header = note.GetHeader();
        return NotebookPageLandingValidateTest(actual_header);
    }
    public boolean teacherLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        teacherblock(driver, mobNumber, password);
        this.note = new Notebook(driver);
        note.NotebookToggle().click();
        Thread.sleep(2000);

        String actual_header = note.GetHeader();
        return NotebookPageLandingValidateTest(actual_header);
    }

    // Grade Check

    public boolean NotebookGradeCheckValidateTest(String actual_grade, String expected_grade){
        System.out.println(actual_grade +" "+expected_grade);
        if (actual_grade.contains(expected_grade)) {
            System.out.println("PASSED");
            return true;
        } else {
            return false;
        }
    }

    public boolean CheckStudentBookGrade(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver,mobNumber,password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.note = new Notebook(driver);
        wait.until(ExpectedConditions.elementToBeClickable(note.NotebookToggle()));
        note.NotebookToggle().click();
        Thread.sleep(2000);
        if (mob >= 9000000001l && mob <= 9000000020l) {// English
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 1 ";

            return NotebookGradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) {// English
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 2 ";

            return NotebookGradeCheckValidateTest(actual_grade, expected_grade);

        }

        else if (mob >= 9000000041l && mob <= 9000000060l) {// English
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 3 ";

            return NotebookGradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 4 ";

            return NotebookGradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 5 ";

            return NotebookGradeCheckValidateTest(actual_grade, expected_grade);
        }
        return false;
    }

    public boolean CheckTeacherBookGrade(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver,mobNumber,password);
        this.note = new Notebook(driver);
        wait.until(ExpectedConditions.elementToBeClickable(note.NotebookToggle()));
        note.NotebookToggle().click();
        if (mob >= 9000000101l && mob <= 9000000104l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 1 ";

            return NotebookGradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 2 ";

            return NotebookGradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 3 ";

            return NotebookGradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 4 ";

            return NotebookGradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            String actual_grade = note.CoursebooksGradeTextGrade().getText();
            String expected_grade = "GRADE 5 ";

            return NotebookGradeCheckValidateTest(actual_grade, expected_grade);
        }
        return false;
    }

    // Lesson Name Check
    public boolean LessonNameValidateTest(String LessonName, String LessonHeading){
        System.out.println(LessonName+"\n"+LessonHeading);
        if(LessonName.equals(LessonHeading)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean StudentLessonNameCheck(WebDriver driver, String mobNumber, String password) throws  IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.note = new Notebook(driver);

        note.NotebookToggle().click();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String LessonName, LessonHeading;
        if (mob >= 9000000001l && mob <= 9000000020l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2, flag3;
            wait.until(ExpectedConditions.elementToBeClickable(note.EnvironmentalCoursebookGrade1()));
            note.EnvironmentalCoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.SecondLesson()));

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            flag3= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) { // Mathematics Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = note.MathematicsCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

            note.FirstLesson().click(); //2-Digit Numbers click()
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.SecondLesson()));

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            flag3= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);
            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000041l && mob <= 9000000060l) { // Social Workbook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = note.SocialStudiesCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.SecondLesson()));

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            flag3= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);
            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) { // Science Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = note.ScienceCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));
//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.SecondLesson()));

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            flag3= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);
            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) { // Social Studies Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = note.SocialStudiesCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.SecondLesson()));

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            flag3= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);
            return flag1 && flag2 && flag3;
        }
        return false;
    }

    public boolean TeacherLessonNameCheck(WebDriver driver, String mobNumber, String password) throws  IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.note = new Notebook(driver);
        note.NotebookToggle().click();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String LessonName, LessonHeading;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2, flag3;
            wait.until(ExpectedConditions.elementToBeClickable(note.EnvironmentalCoursebookGrade1()));
            note.EnvironmentalCoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.SecondLesson()));

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            flag3= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);
            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // Mathematics Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = note.MathematicsCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

            note.FirstLesson().click(); //2-Digit Numbers click()
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.SecondLesson()));

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            flag3= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Social Workbook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = note.SocialStudiesCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.SecondLesson()));

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            flag3= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);
            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // Science Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = note.ScienceCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));
//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.SecondLesson()));

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            flag3= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);
            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Social Studies Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = note.SocialStudiesCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.SecondLesson()));

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

//          Lesson-3
            note.ThirdLesson().click();
            Thread.sleep(5000);
            LessonName = note.ThirdLessonText();
            LessonHeading = note.LessonHeading();

            flag3= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

            return flag1 && flag2 && flag3;
        }
        return false;
    }

    // highlights notes bookmarks

    public boolean ValidateHighlightNotesBookmark(String highlighted_text, String content_in_notebook) {
        if(content_in_notebook.contains(highlighted_text) || content_in_notebook.equals("blank")){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }
    public boolean CheckStudentHighlightsNotesBookmarks(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException, UnsupportedFlavorException {
        this.note = new Notebook(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Map<String, String> map = new HashMap<>();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        wait.until(ExpectedConditions.elementToBeClickable(note.LibraryToggle()));
        note.LibraryToggle().click();

        if (mob >= 9000000001l && mob <= 9000000020l) {// English
            wait.until(ExpectedConditions.elementToBeClickable(note.EnvironmentalCoursebookGrade1()));
            note.EnvironmentalCoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.EnvFirstLessonFirstTopicRefGrade1();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();
            Thread.sleep(2000);
            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 1", highlighted_text);

            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to("https://test.onelern.school/"+"notebook");
            wait.until(ExpectedConditions.elementToBeClickable(note.EnvironmentalCoursebookGrade1()));

            note.EnvironmentalCoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.SearchIcon()));

            note.SearchIcon().click();
            ThreadSleep5000();

            String searchcontent = map.get("Grade 1");
            note.SearchInput().sendKeys(searchcontent);
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.BackButton()));
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.LibraryToggle()));

            note.LibraryToggle().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.EnvironmentalCoursebookGrade1()));

            note.EnvironmentalCoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));
            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.EnvFirstLessonFirstTopicRefGrade1();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(note.deleteBtn()));
            note.deleteBtn().click();
            ThreadSleep5000();

            return ValidateHighlightNotesBookmark(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) {// Mathematics
            wait.until(ExpectedConditions.elementToBeClickable(note.EnglishCoursebookGrade2()));
            note.EnglishCoursebookGrade2().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

            note.ThirdLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.EngThirdLessonFirstTopicRefGrade2();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 2", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to("https://test.onelern.school/"+"notebook");

            wait.until(ExpectedConditions.elementToBeClickable(note.EnglishCoursebookGrade2()));
            note.EnglishCoursebookGrade2().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

            note.ThirdLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.SearchIcon()));

            note.SearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 2"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.BackButton()));
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.LibraryToggle()));

            note.LibraryToggle().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.EnglishCoursebookGrade2()));

            note.EnglishCoursebookGrade2().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));
            note.ThirdLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.EngThirdLessonFirstTopicRefGrade2();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(note.deleteBtn()));
            note.deleteBtn().click();
            ThreadSleep5000();

            return ValidateHighlightNotesBookmark(highlighted_text, content_in_notebook);

        }

        else if (mob >= 9000000041l && mob <= 9000000060l) {// Social Studies
            wait.until(ExpectedConditions.elementToBeClickable(note.MathematicsCoursebookGrade3()));
            note.MathematicsCoursebookGrade3().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.MathFirstLessonFirstTopicRefGrade3();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 3", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to("https://test.onelern.school/"+"notebook");

            wait.until(ExpectedConditions.elementToBeClickable(note.MathematicsCoursebookGrade3()));
            note.MathematicsCoursebookGrade3().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.SearchIcon()));

            note.SearchIcon().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.SearchInput()));

            note.SearchInput().sendKeys(map.get("Grade 3"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.BackButton()));
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.LibraryToggle()));

            note.LibraryToggle().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.MathematicsCoursebookGrade3()));

            note.MathematicsCoursebookGrade3().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));
            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.MathFirstLessonFirstTopicRefGrade3();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(note.deleteBtn()));
            note.deleteBtn().click();
            ThreadSleep5000();

            return ValidateHighlightNotesBookmark(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) {
            wait.until(ExpectedConditions.elementToBeClickable(note.EnglishCoursebookGrade4()));
            note.EnglishCoursebookGrade4().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.EngFirstLessonFirstTopicRefGrade4();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 4", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to("https://test.onelern.school/"+"notebook");
            wait.until(ExpectedConditions.elementToBeClickable(note.EnglishCoursebookGrade4()));

            note.EnglishCoursebookGrade4().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.SearchIcon()));

            note.SearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 4"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.BackButton()));
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.LibraryToggle()));

            note.LibraryToggle().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.EnglishCoursebookGrade4()));

            note.EnglishCoursebookGrade4().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));
            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.EngFirstLessonFirstTopicRefGrade4();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(note.deleteBtn()));
            note.deleteBtn().click();
            ThreadSleep5000();

            return ValidateHighlightNotesBookmark(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) {
            wait.until(ExpectedConditions.elementToBeClickable(note.MathematicsCoursebookGrade5()));
            note.MathematicsCoursebookGrade5().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.MathFirstLessonFirstTopicRefGrade5();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 5", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to("https://test.onelern.school/"+"notebook");
            wait.until(ExpectedConditions.elementToBeClickable(note.MathematicsCoursebookGrade5()));

            note.MathematicsCoursebookGrade5().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.SearchIcon()));

            note.SearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 5"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.BackButton()));
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.LibraryToggle()));

            note.LibraryToggle().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.MathematicsCoursebookGrade5()));

            note.MathematicsCoursebookGrade5().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));
            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.MathFirstLessonFirstTopicRefGrade5();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(note.deleteBtn()));
            note.deleteBtn().click();
            ThreadSleep5000();

            return ValidateHighlightNotesBookmark(highlighted_text, content_in_notebook);
        }
        return false;
    }

    public boolean CheckTeacherHighlightsNotesBookmarks(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException, UnsupportedFlavorException {
        this.note = new Notebook(driver);
        Map<String, String> map = new HashMap<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        wait.until(ExpectedConditions.elementToBeClickable(note.LibraryToggle()));
        note.LibraryToggle().click();
        if (mob >= 9000000101l && mob <= 9000000104l) {// English
            wait.until(ExpectedConditions.elementToBeClickable(note.EnvironmentalCoursebookGrade1()));
            note.EnvironmentalCoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.EnvFirstLessonFirstTopicRefGrade1();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();
            Thread.sleep(2000);
            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 1", highlighted_text);

            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to("https://test.onelern.school/"+"notebook");
            wait.until(ExpectedConditions.elementToBeClickable(note.EnvironmentalCoursebookGrade1()));

            note.EnvironmentalCoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.TeacherSearchIcon()));

            note.TeacherSearchIcon().click();
            ThreadSleep5000();

            String searchcontent = map.get("Grade 1");
            note.SearchInput().sendKeys(searchcontent);
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.BackButton()));
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.LibraryToggle()));

            note.LibraryToggle().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.EnvironmentalCoursebookGrade1()));

            note.EnvironmentalCoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));
            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.EnvFirstLessonFirstTopicRefGrade1();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(note.deleteBtn()));
            note.deleteBtn().click();
            ThreadSleep5000();

            return ValidateHighlightNotesBookmark(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) {// Mathematics
            wait.until(ExpectedConditions.elementToBeClickable(note.EnglishCoursebookGrade2()));
            note.EnglishCoursebookGrade2().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

            note.ThirdLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.EngThirdLessonFirstTopicRefGrade2();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 2", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to("https://test.onelern.school/"+"notebook");

            wait.until(ExpectedConditions.elementToBeClickable(note.EnglishCoursebookGrade2()));
            note.EnglishCoursebookGrade2().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));

            note.ThirdLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.TeacherSearchIcon()));

            note.TeacherSearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 2"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.BackButton()));
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.LibraryToggle()));

            note.LibraryToggle().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.EnglishCoursebookGrade2()));

            note.EnglishCoursebookGrade2().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.ThirdLesson()));
            note.ThirdLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.EngThirdLessonFirstTopicRefGrade2();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(note.deleteBtn()));
            note.deleteBtn().click();
            ThreadSleep5000();

            return ValidateHighlightNotesBookmark(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {// Social Studies
            wait.until(ExpectedConditions.elementToBeClickable(note.MathematicsCoursebookGrade3()));
            note.MathematicsCoursebookGrade3().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.MathFirstLessonFirstTopicRefGrade3();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 3", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to("https://test.onelern.school/"+"notebook");

            wait.until(ExpectedConditions.elementToBeClickable(note.MathematicsCoursebookGrade3()));
            note.MathematicsCoursebookGrade3().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.TeacherSearchIcon()));

            note.TeacherSearchIcon().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.SearchInput()));

            note.SearchInput().sendKeys(map.get("Grade 3"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.BackButton()));
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.LibraryToggle()));

            note.LibraryToggle().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.MathematicsCoursebookGrade3()));

            note.MathematicsCoursebookGrade3().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));
            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.MathFirstLessonFirstTopicRefGrade3();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(note.deleteBtn()));
            note.deleteBtn().click();
            ThreadSleep5000();

            return ValidateHighlightNotesBookmark(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            wait.until(ExpectedConditions.elementToBeClickable(note.EnglishCoursebookGrade4()));
            note.EnglishCoursebookGrade4().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.EngFirstLessonFirstTopicRefGrade4();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 4", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to("https://test.onelern.school/"+"notebook");
            wait.until(ExpectedConditions.elementToBeClickable(note.EnglishCoursebookGrade4()));

            note.EnglishCoursebookGrade4().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.TeacherSearchIcon()));

            note.TeacherSearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 4"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.BackButton()));
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.LibraryToggle()));

            note.LibraryToggle().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.EnglishCoursebookGrade4()));

            note.EnglishCoursebookGrade4().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));
            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.EngFirstLessonFirstTopicRefGrade4();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(note.deleteBtn()));
            note.deleteBtn().click();
            ThreadSleep5000();

            return ValidateHighlightNotesBookmark(highlighted_text, content_in_notebook);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            wait.until(ExpectedConditions.elementToBeClickable(note.MathematicsCoursebookGrade5()));
            note.MathematicsCoursebookGrade5().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));

            note.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = note.MathFirstLessonFirstTopicRefGrade5();
            Actions action = new Actions(driver);
            int element_width = element.getSize().getWidth();
            int init_xOffset = element_width/2;

            action.moveToElement(element,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element,100, 0).click().keyUp(Keys.SHIFT).build().perform();

            action.keyDown(Keys.CONTROL).sendKeys("c").perform();
            String highlighted_text = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            ThreadSleep5000();
            System.out.println(highlighted_text);
            map.put("Grade 5", highlighted_text);
            note.greenBtn().click();
            ThreadSleep5000();

            driver.navigate().to("https://test.onelern.school/"+"notebook");
            wait.until(ExpectedConditions.elementToBeClickable(note.MathematicsCoursebookGrade5()));

            note.MathematicsCoursebookGrade5().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));

            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.TeacherSearchIcon()));

            note.TeacherSearchIcon().click();
            ThreadSleep5000();

            note.SearchInput().sendKeys(map.get("Grade 5"));
            ThreadSleep5000();

            List<WebElement> contents = note.contents();
            String content_in_notebook;
            if(contents.size() >0){
                content_in_notebook = contents.get(contents.size()-1).getText();
            }
            else{
                content_in_notebook = "blank";
            }

            // Remove Highlighted content
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.BackButton()));
            Thread.sleep(2000);
            note.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.LibraryToggle()));

            note.LibraryToggle().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.MathematicsCoursebookGrade5()));

            note.MathematicsCoursebookGrade5().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstLesson()));
            note.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(note.FirstTopic()));
            note.FirstTopic().click();
            ThreadSleep5000();
            ThreadSleep5000();
            WebElement element1 = note.MathFirstLessonFirstTopicRefGrade5();
            action.moveToElement(element1,-init_xOffset,0).click().keyDown(Keys.SHIFT).moveToElement(element1,60, 0).click().keyUp(Keys.SHIFT).build().perform();
            wait.until(ExpectedConditions.elementToBeClickable(note.deleteBtn()));
            note.deleteBtn().click();
            ThreadSleep5000();

            return ValidateHighlightNotesBookmark(highlighted_text, content_in_notebook);
        }
        return false;
    }

}
