package executions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.LoginPage;
import pageObjects.Notebook;
import resources.BaseLogin;

import java.io.IOException;

public class NotebookMethods extends BaseLogin {
    public Notebook note;
    public LoginPage log;
    public WebDriver driver;
    JavascriptExecutor js;

    public NotebookMethods(WebDriver driver2) {
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
        this.note = new Notebook(driver);
        Thread.sleep(2000);
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
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver,mobNumber,password);
        this.note = new Notebook(driver);
        Thread.sleep(2000);
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
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.note = new Notebook(driver);

        note.NotebookToggle().click();
        Thread.sleep(5000);

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String LessonName, LessonHeading;
        if (mob >= 9000000001l && mob <= 9000000020l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2, flag3;
            note.EnvironmentalCoursebookGrade1().click();
            Thread.sleep(5000);

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

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
            Thread.sleep(5000);
            element.click();

            note.FirstLesson().click(); //2-Digit Numbers click()
            Thread.sleep(5000);

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

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
            Thread.sleep(3000);
            element.click();

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

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
            Thread.sleep(5000);
            element.click();
            Thread.sleep(5000);
//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

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
            Thread.sleep(5000);
            element.click();
            Thread.sleep(5000);

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

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
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.note = new Notebook(driver);
        note.NotebookToggle().click();
        Thread.sleep(5000);

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String LessonName, LessonHeading;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2, flag3;
            note.EnvironmentalCoursebookGrade1().click();
            Thread.sleep(5000);

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

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
            Thread.sleep(5000);
            element.click();

            note.FirstLesson().click(); //2-Digit Numbers click()
            Thread.sleep(5000);

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

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
            Thread.sleep(3000);
            element.click();

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

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
            Thread.sleep(5000);
            element.click();
            Thread.sleep(5000);
//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

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
            Thread.sleep(5000);
            element.click();
            Thread.sleep(5000);

//          lesson-1
            note.FirstLesson().click();
            Thread.sleep(5000);
            LessonName = note.FirstLessonText();
            LessonHeading = note.LessonHeading();

            flag1= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

//          Lesson-2
            note.SecondLesson().click();
            Thread.sleep(5000);
            LessonName = note.SecondLessonText();
            LessonHeading = note.LessonHeading();

            flag2= LessonNameValidateTest(LessonName, LessonHeading);
            Thread.sleep(5000);

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



}
