package executions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.Library;
import pageObjects.LoginPage;
import resources.Base;
import resources.BaseLogin;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class LibraryMethods extends BaseLogin {
    public Library lib;
    public LoginPage log;
    public WebDriver driver;
    JavascriptExecutor js;

    public LibraryMethods(WebDriver driver2) {
        super(driver2);
    }

    public void ThreadSleep5000() throws InterruptedException {
        Thread.sleep(5000);
    }
    public void ThreadSleep3000() throws InterruptedException {
        Thread.sleep(3000);
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

    public boolean studentLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        studentblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        lib.LibraryToggle().click();
        ThreadSleep5000();
        String Headingtext_actual = lib.WorkbookHeading().getText();
        String Headingtext_expected = "Library";
        if (Headingtext_actual.equals(Headingtext_expected)) {
            System.out.println("Library Module is active");
            return true;
        }
        else {
            return false;
        }
    }
    public boolean teacherLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        ThreadSleep5000();
        lib.LibraryToggle().click();
        ThreadSleep5000();
        String Headingtext_actual = lib.WorkbookHeading().getText();
        String Headingtext_expected = "Library";
        if (Headingtext_actual.equals(Headingtext_expected)) {
            System.out.println("Library Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    // Grade Check
    public boolean GradeCheckValidateTest(String actual_grade, String expected_grade){
        if (actual_grade.equals(expected_grade)) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }
    public boolean CheckStudentBookGrade(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        lib.LibraryToggle().click();
        ThreadSleep5000();
        if (mob >= 9000000001l && mob <= 9000000020l) {// English
            String actual_grade = lib.EnglishGradeTextGrade1().getText();
            String expected_grade = "GRADE 1";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) {// English
            String actual_grade = lib.EnglishGradeTextGrade2().getText();
            String expected_grade = "GRADE 2";

            return GradeCheckValidateTest(actual_grade, expected_grade);

        }

        else if (mob >= 9000000041l && mob <= 9000000060l) {// English
            String actual_grade = lib.EnglishGradeTextGrade3().getText();
            String expected_grade = "GRADE 3";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) {
            String actual_grade = lib.EnglishGradeTextGrade4().getText();
            String expected_grade = "GRADE 4";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) {
            String actual_grade = lib.EnglishGradeTextGrade5().getText();
            String expected_grade = "GRADE 5";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }
        return false;
    }

    public boolean CheckTeacherBookGrade(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        ThreadSleep5000();
        lib.LibraryToggle().click();
        if (mob >= 9000000101l && mob <= 9000000104l) {
            String actual_grade = lib.EnglishGradeTextGrade1().getText();
            String expected_grade = "GRADE 1";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) {
            String actual_grade = lib.EnglishGradeTextGrade2().getText();
            String expected_grade = "GRADE 2";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {
            String actual_grade = lib.EnglishGradeTextGrade3().getText();
            String expected_grade = "GRADE 3";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            String actual_grade = lib.EnglishGradeTextGrade4().getText();
            String expected_grade = "GRADE 4";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            String actual_grade = lib.EnglishGradeTextGrade5().getText();
            String expected_grade = "GRADE 5";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }
        return false;
    }


    // Workbook name verify
    public boolean WorkbookNameValidateTest(WebDriver driver, String expected_text, String actual_text){
        if(actual_text.equals(expected_text)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean StudentWorkbookCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        lib.LibraryToggle().click();
        ThreadSleep5000();

        // Scrolling page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (mob >= 9000000001l && mob <= 9000000020l) { // Environmental Studies Coursebook - Part A
            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
            String text = lib.WorkbookHeading().getText();
            String workbookName = "Environmental Studies Coursebook - Part A";

            return  WorkbookNameValidateTest(driver, workbookName, text);
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = lib.WorkbookHeading().getText();
            String workbookName = "English Coursebook - Part A";

            return  WorkbookNameValidateTest(driver, workbookName, text);
        }
        else if (mob >= 9000000041l && mob <= 9000000060l) { // Mathematics Coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = lib.WorkbookHeading().getText();
            String workbookName = "Mathematics Coursebook - Part A";

            return  WorkbookNameValidateTest(driver, workbookName, text);
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = lib.WorkbookHeading().getText();
            String workbookName = "English Coursebook - Part A";

            return  WorkbookNameValidateTest(driver, workbookName, text);
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) { // Mathematics Coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = lib.WorkbookHeading().getText();
            String workbookName = "Mathematics Coursebook - Part A";

            return  WorkbookNameValidateTest(driver, workbookName, text);
        }
        return false;
    }

    public boolean TeacherWorkbookCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        lib.LibraryToggle().click();
        ThreadSleep5000();

        // Scrolling page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            WebElement element = lib.EnvironmentalcoursebookGrade1();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = lib.WorkbookHeading().getText();
            String workbookName = "Environmental Studies Coursebook - Part A";

            return  WorkbookNameValidateTest(driver, workbookName, text);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = lib.WorkbookHeading().getText();
            String workbookName = "English Coursebook - Part A";

            return  WorkbookNameValidateTest(driver, workbookName, text);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics Coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = lib.WorkbookHeading().getText();
            String workbookName = "Mathematics Coursebook - Part A";

            return  WorkbookNameValidateTest(driver, workbookName, text);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = lib.WorkbookHeading().getText();
            String workbookName = "English Coursebook - Part A";

            return  WorkbookNameValidateTest(driver, workbookName, text);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = lib.WorkbookHeading().getText();
            String workbookName = "Mathematics Coursebook - Part A";

            return  WorkbookNameValidateTest(driver, workbookName, text);
        }
        return false;
    }

    public boolean LessonNameValidate(String unitName, String text, String insideHeading) {
        System.out.println(unitName + "\n" + text +"\n" + insideHeading);
        if(unitName.equals(text) && text.equals(insideHeading)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    // Lesson Name verify

    public boolean StudentLessonNameCheck(WebDriver driver, String mobNumber, String password) throws  IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        ThreadSleep5000();
        lib.LibraryToggle().click();
        ThreadSleep5000();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String unitName, text, insideHeading;
        if (mob >= 9000000001l && mob <= 9000000020l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2, flag3;
            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
            lib.FirstLesson().click();
            ThreadSleep5000();


//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag3 = LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

            lib.ThirdLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag1=  LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag3 = LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000041l && mob <= 9000000060l) { // Mathematics coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag1=  LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag3= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag3 = LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) { // Mathematics Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag3= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 & flag3;
        }
        return false;
    }

    public boolean TeacherLessonNameCheck(WebDriver driver, String mobNumber, String password) throws  IOException, InterruptedException {

        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        ThreadSleep5000();
        lib.LibraryToggle().click();
        ThreadSleep5000();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String unitName, text, insideHeading;
        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2, flag3;
            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag3= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

            lib.ThirdLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag3= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag3= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag3= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();
            ThreadSleep5000();

            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            ThreadSleep5000();
            text = lib.LessonHeadingText();
            ThreadSleep5000();
            lib.FirstTopic().click();
            ThreadSleep5000();
            insideHeading = lib.InsideLessonHeading().getText();

            flag3= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 & flag3;
        }
        return false;
    }

    //Lesson topic verify
    public boolean LessonTopicValidate(String unitname, String text){
        System.out.println(unitname + "\n" + text);
        if(unitname.contains(text)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }


    public boolean StudentLessonTopicCheck(WebDriver driver, String mobNumber, String password) throws  IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        ThreadSleep5000();
        lib.LibraryToggle().click();
        ThreadSleep5000();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String unitname, text;
        if (mob >= 9000000001l && mob <= 9000000020l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2, flag3;
            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
            lib.FirstLesson().click();
            ThreadSleep5000();


//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();
            ThreadSleep5000();
            text = lib.EnvFirstLessonFirstTopicRefGrade1().getText();
            ThreadSleep5000();

            flag1= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.EnvFirstLessonSecondTopicRefGrade1().getText();
            ThreadSleep5000();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.EnvFirstLessonThirdTopicRefGrade1().getText();
            ThreadSleep5000();

            flag3= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

            lib.ThirdLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.EngThirdLessonFirstTopicRefGrade2().getText();
            ThreadSleep5000();

            flag1= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.EngThirdLessonSecondTopicRefGrade2().getText();
            ThreadSleep5000();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.EngThirdLessonThirdTopicRefGrade2().getText();
            ThreadSleep5000();

            flag3= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000041l && mob <= 9000000060l) { // Mathematics coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonFirstTopicRefGrade3().getText();
            ThreadSleep5000();

            flag1 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonSecondTopicRefGrade3().getText();
            ThreadSleep5000();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonThirdTopicRefGrade3().getText();
            ThreadSleep5000();

            flag3= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.EngFirstLessonFirstTopicRefGrade4().getText();
            ThreadSleep5000();

            flag1= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.EngFirstLessonSecondTopicRefGrade4().getText();
            ThreadSleep5000();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.EngFirstLessonThirdTopicRefGrade4().getText();
            ThreadSleep5000();

            flag3 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) { // Mathematics Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonFirstTopicRefGrade5().getText();
            ThreadSleep5000();

            flag1= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonSecondTopicRefGrade5().getText();
            ThreadSleep5000();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonThirdTopicRefGrade5().getText();
            ThreadSleep5000();

            flag3= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 && flag3;
        }
        return false;
    }

    public boolean TeacherLessonTopicCheck(WebDriver driver, String mobNumber, String password) throws  IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        ThreadSleep5000();
        lib.LibraryToggle().click();
        ThreadSleep5000();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String unitname, text;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2, flag3;
            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
            lib.FirstLesson().click();
            ThreadSleep5000();


//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();
            ThreadSleep5000();
            text = lib.EnvFirstLessonFirstTopicRefGrade1().getText();
            ThreadSleep5000();

            flag1 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.EnvFirstLessonSecondTopicRefGrade1().getText();
            ThreadSleep5000();

            flag2 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.EnvFirstLessonThirdTopicRefGrade1().getText();
            ThreadSleep5000();

            flag3 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 && flag3;
        }
        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

            lib.ThirdLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.EngThirdLessonFirstTopicRefGrade2().getText();
            ThreadSleep5000();

            flag1 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.EngThirdLessonSecondTopicRefGrade2().getText();
            ThreadSleep5000();

            flag2 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.EngThirdLessonThirdTopicRefGrade2().getText();
            ThreadSleep5000();

            flag3 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 && flag3;
        }
        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonFirstTopicRefGrade3().getText();
            ThreadSleep5000();

            flag1 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonSecondTopicRefGrade3().getText();
            ThreadSleep5000();

            flag2 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonThirdTopicRefGrade3().getText();
            ThreadSleep5000();

            flag3 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 && flag3;
        }
        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.EngFirstLessonFirstTopicRefGrade4().getText();
            ThreadSleep5000();

            flag1 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.EngFirstLessonSecondTopicRefGrade4().getText();
            ThreadSleep5000();

            flag2 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.EngFirstLessonThirdTopicRefGrade4().getText();
            ThreadSleep5000();

            flag3 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 && flag3;
        }
        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            lib.FirstLesson().click();
            ThreadSleep5000();

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonFirstTopicRefGrade5().getText();
            ThreadSleep5000();

            flag1 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonSecondTopicRefGrade5().getText();
            ThreadSleep5000();

            flag2 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            ThreadSleep5000();

            text = lib.MathFirstLessonThirdTopicRefGrade5().getText();
            ThreadSleep5000();

            flag3 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            ThreadSleep5000();
            return flag1 && flag2 && flag3;
        }
        return false;
    }


    // Audio Check
    public boolean AudioCheckValidateTest(String curr_time){
        System.out.println(curr_time);
        if(curr_time.equals("0:00")){
            return false;
        }
        else{
            System.out.println("Audio played");
            return true;
        }
    }
    public boolean StudentAudioCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        Thread.sleep(5000);
        lib.LibraryToggle().click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (mob >= 9000000001l && mob <= 9000000020l){ // Environmental Studies Coursebook - Part A
            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep3000();
            lib.SecondLesson().click();
            ThreadSleep3000();

            lib.FirstTopic().click();
            ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000(); ThreadSleep5000();

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000021l && mob <= 9000000040l){ // English Coursebook - Part A
            lib.EnglishCoursebookGrade2().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000(); ThreadSleep5000();

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000041l && mob <= 9000000060l){ // English Coursebook - Part A
            lib.EnglishCoursebookGrade3().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000(); ThreadSleep5000();

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000061l && mob <= 9000000080l){ // English Coursebook - Part A
            lib.EnglishCoursebookGrade4().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000(); ThreadSleep5000();

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000081l && mob <= 9000000100l){ // English Coursebook - Part A
            lib.EnglishCoursebookGrade5().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000(); ThreadSleep5000();

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        return false;
    }

    public boolean teacherAudiocheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        ThreadSleep5000();
        lib.LibraryToggle().click();
        ThreadSleep5000();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (mob >= 9000000101l && mob <= 9000000104l) { // English Coursebook - Part A
            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep3000();
            lib.SecondLesson().click();
            ThreadSleep3000();

            lib.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000(); ThreadSleep5000();

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            lib.EnglishCoursebookGrade2().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000(); ThreadSleep5000();

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000109l && mob <= 9000000112l) { // English Coursebook - Part A
            lib.EnglishCoursebookGrade3().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000(); ThreadSleep5000();

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            lib.EnglishCoursebookGrade4().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000(); ThreadSleep5000();

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000117l && mob <= 9000000120l) { // English Coursebook - Part A
            lib.EnglishCoursebookGrade5().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000(); ThreadSleep5000();

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        return false;
    }


    // Video Check

    public void VideoPlay(){
        js.executeScript("document.getElementsByTagName('video')[0].play()");
    }
    public String VideoStatus(){
        String str= js.executeScript("if(document.getElementsByTagName('video')[0].paused){return 'fail';}else{return 'pass';}").toString();
        return str;
    }
    public void ScrollToVideo(WebElement element){
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public boolean ValidateVideoStatus(){
        String video_status = VideoStatus();
        System.out.println(video_status);
        if (Objects.equals(video_status, "pass")) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean studentVideocheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        ThreadSleep3000();
        this.lib = new Library(driver);
        lib.LibraryToggle().click();
        ThreadSleep3000();

        // Scrolling Page
        js = (JavascriptExecutor) driver;
        if (mob >= 9000000001l && mob <= 9000000020l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2;
            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.videosPageTab().click();
            ThreadSleep3000();
            lib.VideoWatchBtn().click();
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            // check video
            flag1= ValidateVideoStatus();

            // close the video modal-box
            lib.VideoModalboxCloseBtn().click();

            //contents
            lib.ContentsPageTab().click();
            ThreadSleep3000();

            //click first topic
            lib.FirstTopic().click();
            ThreadSleep3000();

            ScrollToVideo(lib.EnvVideoPathGrade1());
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            flag2= ValidateVideoStatus();

            return flag1 && flag2;
        }
        else if (mob >= 9000000021l && mob <= 9000000040l) { // English Coursebook - Part A
            boolean flag1, flag2;
            Thread.sleep(10000);
            lib.EnglishCoursebookGrade2().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.videosPageTab().click();
            ThreadSleep3000();
            lib.VideoWatchBtn().click();
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            // check video
            flag1= ValidateVideoStatus();

            // close the video modal-box
            lib.VideoModalboxCloseBtn().click();

            //contents
            lib.ContentsPageTab().click();
            ThreadSleep3000();

            //click first topic
            lib.FirstTopic().click();
            ThreadSleep3000();

            ScrollToVideo(lib.EngVideoPathGrade2());
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            flag2= ValidateVideoStatus();

            return flag1 && flag2;
        }
        else if (mob >= 9000000041l && mob <= 9000000060l) { // English Coursebook - Part A
            boolean flag1, flag2;
            Thread.sleep(10000);
            lib.EnglishCoursebookGrade3().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.videosPageTab().click();
            ThreadSleep3000();
            lib.VideoWatchBtn().click();
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            // check video
            flag1= ValidateVideoStatus();

            // close the video modal-box
            lib.VideoModalboxCloseBtn().click();

            //contents
            lib.ContentsPageTab().click();
            ThreadSleep3000();

            //click first topic
            lib.FirstTopic().click();
            ThreadSleep3000();

            ScrollToVideo(lib.EngVideoPathGrade3());
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            flag2= ValidateVideoStatus();

            return flag1 && flag2;
        }
        else if (mob >= 9000000061l && mob <= 9000000080l) { // English Coursebook - Part A
            boolean flag1, flag2;
            Thread.sleep(10000);
            lib.EnglishCoursebookGrade4().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.videosPageTab().click();
            ThreadSleep3000();
            lib.VideoWatchBtn().click();
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            // check video
            flag1= ValidateVideoStatus();

            // close the video modal-box
            lib.VideoModalboxCloseBtn().click();

            //contents
            lib.ContentsPageTab().click();
            ThreadSleep3000();

            //click first topic
            lib.FirstTopic().click();
            ThreadSleep3000();

            ScrollToVideo(lib.EngVideoPathGrade4());
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            flag2= ValidateVideoStatus();

            return flag1 && flag2;
        }
        else if (mob >= 9000000081l && mob <= 9000000100l) { // Mathematics Coursebook - Part A
            boolean flag1, flag2;
            Thread.sleep(10000);
            lib.MathematicsCoursebookGrade5().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.videosPageTab().click();
            ThreadSleep3000();
            lib.VideoWatchBtn().click();
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            // check video
            flag1= ValidateVideoStatus();

            // close the video modal-box
            lib.VideoModalboxCloseBtn().click();

            //contents
            lib.ContentsPageTab().click();
            ThreadSleep3000();

            //click first topic
            lib.FirstTopic().click();
            ThreadSleep3000();

            ScrollToVideo(lib.MathVideoPathGrade5());
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            flag2= ValidateVideoStatus();
            return flag1 && flag2;
        }
        return false;
    }


    public boolean teacherVideocheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        ThreadSleep5000();
        lib.LibraryToggle().click();
        ThreadSleep5000();

        // Scrolling Page
        js = (JavascriptExecutor) driver;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2;
            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.videosPageTab().click();
            ThreadSleep3000();
            lib.VideoWatchBtn().click();
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            // check video
            flag1= ValidateVideoStatus();

            // close the video modal-box
            lib.VideoModalboxCloseBtn().click();

            //contents
            lib.ContentsPageTab().click();
            ThreadSleep3000();

            //click first topic
            lib.FirstTopic().click();
            ThreadSleep3000();

            ScrollToVideo(lib.EnvVideoPathGrade1());
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            flag2= ValidateVideoStatus();

            return flag1 && flag2;
        }
        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            boolean flag1, flag2;
            Thread.sleep(10000);
            lib.EnglishCoursebookGrade2().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.videosPageTab().click();
            ThreadSleep3000();
            lib.VideoWatchBtn().click();
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            // check video
            flag1= ValidateVideoStatus();

            // close the video modal-box
            lib.VideoModalboxCloseBtn().click();

            //contents
            lib.ContentsPageTab().click();
            ThreadSleep3000();

            //click first topic
            lib.FirstTopic().click();
            ThreadSleep3000();

            ScrollToVideo(lib.EngVideoPathGrade2());
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            flag2= ValidateVideoStatus();
            return flag1 && flag2;

        }
        else if (mob >= 9000000109l && mob <= 9000000112l) { // English Coursebook - Part A
            boolean flag1, flag2;
            Thread.sleep(10000);
            lib.EnglishCoursebookGrade3().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.videosPageTab().click();
            ThreadSleep3000();
            lib.VideoWatchBtn().click();
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            // check video
            flag1= ValidateVideoStatus();

            // close the video modal-box
            lib.VideoModalboxCloseBtn().click();

            //contents
            lib.ContentsPageTab().click();
            ThreadSleep3000();

            //click first topic
            lib.FirstTopic().click();
            ThreadSleep3000();

            ScrollToVideo(lib.EngVideoPathGrade3());
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            flag2= ValidateVideoStatus();

            return flag1 && flag2;
        }
        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            boolean flag1, flag2;
            Thread.sleep(10000);
            lib.EnglishCoursebookGrade4().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.videosPageTab().click();
            ThreadSleep3000();
            lib.VideoWatchBtn().click();
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            // check video
            flag1= ValidateVideoStatus();

            // close the video modal-box
            lib.VideoModalboxCloseBtn().click();

            //contents
            lib.ContentsPageTab().click();
            ThreadSleep3000();

            //click first topic
            lib.FirstTopic().click();
            ThreadSleep3000();

            ScrollToVideo(lib.EngVideoPathGrade4());
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            flag2= ValidateVideoStatus();
            return flag1 && flag2;

        }
        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            boolean flag1, flag2;
            Thread.sleep(10000);
            lib.MathematicsCoursebookGrade5().click();
            ThreadSleep3000();
            lib.FirstLesson().click();
            ThreadSleep3000();

            lib.videosPageTab().click();
            ThreadSleep3000();
            lib.VideoWatchBtn().click();
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            // check video
            flag1= ValidateVideoStatus();

            // close the video modal-box
            lib.VideoModalboxCloseBtn().click();

            //contents
            lib.ContentsPageTab().click();
            ThreadSleep3000();

            //click first topic
            lib.FirstTopic().click();
            ThreadSleep3000();

            ScrollToVideo(lib.MathVideoPathGrade5());
            ThreadSleep3000();

            // play video
            VideoPlay();
            ThreadSleep3000();

            flag2= ValidateVideoStatus();

            return flag1 && flag2;
        }
        return false;
    }

    // Search Check

    public boolean SearchCheckValidateTest(int expected_count, int countInSearchBox, int search_elements_size){
        System.out.println(expected_count +" "+ countInSearchBox+ " "+search_elements_size);
        if(countInSearchBox == expected_count && search_elements_size == expected_count ){
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean StudentSearchCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        ThreadSleep3000();
        lib.LibraryToggle().click();
        ThreadSleep3000();

        if (mob >= 9000000001l && mob <= 9000000020l){ // Environmental Studies Coursebook - Part A
            String search_text= "good";
            int expected_count=4;

            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep3000();
            //click third lesson
            lib.ThirdLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.SearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            return SearchCheckValidateTest(expected_count, countInSearchBox, search_elements_size);
        }
        else if (mob >= 9000000021l && mob <= 9000000040l){ // English Coursebook - Part A
            String search_text= "read";
            int expected_count= 3;

            lib.EnglishCoursebookGrade2().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.SearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            return SearchCheckValidateTest(expected_count, countInSearchBox, search_elements_size);
        }
        else if (mob >= 9000000041l && mob <= 9000000060l){ // Mathematics Coursebook - Part A
            String search_text= "digit";
            int expected_count= 3;

            lib.MathematicsCoursebookGrade3().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.SearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            return SearchCheckValidateTest(expected_count, countInSearchBox, search_elements_size);
        }
        else if (mob >= 9000000061l && mob <= 9000000080l){ // English Coursebook - Part A
            String search_text= "read";
            int expected_count= 3;

            lib.EnglishCoursebookGrade4().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.SearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            return SearchCheckValidateTest(expected_count, countInSearchBox, search_elements_size);
        }
        else if (mob >= 9000000081l && mob <= 9000000100l){ // English Coursebook - Part A
            String search_text= "learn";
            int expected_count= 2;

            lib.EnglishCoursebookGrade5().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.SearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            return SearchCheckValidateTest(expected_count, countInSearchBox, search_elements_size);
        }
        return false;
    }


    public boolean TeacherSearchCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        Thread.sleep(5000);
        lib.LibraryToggle().click();
        ThreadSleep5000();

        if (mob >= 9000000101l && mob <= 9000000104l){ // Environmental Studies Coursebook - Part A
            String search_text= "good";
            int expected_count=4;

            lib.EnvironmentalcoursebookGrade1().click();
            ThreadSleep3000();
            //click third lesson
            lib.ThirdLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.TeacherSearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            return SearchCheckValidateTest(expected_count, countInSearchBox, search_elements_size);
        }
        else if (mob >= 9000000105l && mob <= 9000000108l){ // English Coursebook - Part A
            String search_text= "read";
            int expected_count= 3;

            lib.EnglishCoursebookGrade2().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.TeacherSearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            return SearchCheckValidateTest(expected_count, countInSearchBox, search_elements_size);
        }
        else if (mob >= 9000000109l && mob <= 9000000112l){ // Mathematics Coursebook - Part A
            String search_text= "digit";
            int expected_count= 3;

            lib.MathematicsCoursebookGrade3().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.TeacherSearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            return SearchCheckValidateTest(expected_count, countInSearchBox, search_elements_size);
        }
        else if (mob >= 9000000113l && mob <= 9000000116l){ // English Coursebook - Part A
            String search_text= "read";
            int expected_count= 3;

            lib.EnglishCoursebookGrade4().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.TeacherSearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            return SearchCheckValidateTest(expected_count, countInSearchBox, search_elements_size);
        }
        else if (mob >= 9000000117l && mob <= 9000000120l){ // English Coursebook - Part A
            String search_text= "learn";
            int expected_count= 2;

            lib.EnglishCoursebookGrade5().click();
            ThreadSleep3000();
            //click first lesson
            lib.FirstLesson().click();
            ThreadSleep3000();

            // click on search icon
            lib.TeacherSearchIcon().click();

            //input the text
            lib.SearchInput().sendKeys(search_text);

            ThreadSleep3000();
            List<WebElement> search_elements= lib.HighlightTexts();

            int countInSearchBox= Integer.parseInt(lib.TotalCount());
            int search_elements_size = search_elements.size();

            return SearchCheckValidateTest(expected_count, countInSearchBox, search_elements_size);
        }
        return false;
    }

}
