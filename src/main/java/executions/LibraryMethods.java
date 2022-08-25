package executions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Library;
import pageObjects.LoginPage;
import resources.Base;
import resources.BaseLogin;

import java.io.IOException;
import java.time.Duration;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.lib = new Library(driver);
        lib.LibraryToggle().click();
//        ThreadSleep5000();
        wait.until(ExpectedConditions.elementToBeClickable(lib.WorkbookHeading()));
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.lib = new Library(driver);
        lib.LibraryToggle().click();
//        ThreadSleep5000();
        wait.until(ExpectedConditions.elementToBeClickable(lib.WorkbookHeading()));
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        lib.LibraryToggle().click();
        if (mob >= 9000000001l && mob <= 9000000020l) {// English
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishGradeTextGrade1()));
            String actual_grade = lib.EnglishGradeTextGrade1().getText();
            String expected_grade = "GRADE 1";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) {// English
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishGradeTextGrade2()));
            String actual_grade = lib.EnglishGradeTextGrade2().getText();
            String expected_grade = "GRADE 2";

            return GradeCheckValidateTest(actual_grade, expected_grade);

        }

        else if (mob >= 9000000041l && mob <= 9000000060l) {// English
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishGradeTextGrade3()));
            String actual_grade = lib.EnglishGradeTextGrade3().getText();
            String expected_grade = "GRADE 3";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) {
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishGradeTextGrade4()));
            String actual_grade = lib.EnglishGradeTextGrade4().getText();
            String expected_grade = "GRADE 4";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) {
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishGradeTextGrade5()));
            String actual_grade = lib.EnglishGradeTextGrade5().getText();
            String expected_grade = "GRADE 5";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }
        return false;
    }

    public boolean CheckTeacherBookGrade(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        wait.until(ExpectedConditions.elementToBeClickable(lib.LibraryToggle()));
        lib.LibraryToggle().click();
        if (mob >= 9000000101l && mob <= 9000000104l) {
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishGradeTextGrade1()));
            String actual_grade = lib.EnglishGradeTextGrade1().getText();
            String expected_grade = "GRADE 1";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) {
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishGradeTextGrade2()));
            String actual_grade = lib.EnglishGradeTextGrade2().getText();
            String expected_grade = "GRADE 2";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishGradeTextGrade3()));
            String actual_grade = lib.EnglishGradeTextGrade3().getText();
            String expected_grade = "GRADE 3";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishGradeTextGrade4()));
            String actual_grade = lib.EnglishGradeTextGrade4().getText();
            String expected_grade = "GRADE 4";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishGradeTextGrade5()));
            String actual_grade = lib.EnglishGradeTextGrade5().getText();
            String expected_grade = "GRADE 5";

            return GradeCheckValidateTest(actual_grade, expected_grade);
        }
        return false;
    }


    // Workbook name verify
    public boolean WorkbookNameValidateTest(String expected_text, String actual_text){
        System.out.println(expected_text+"\n"+actual_text);
        if(actual_text.equals(expected_text)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean StudentWorkbookCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        lib.LibraryToggle().click();


        // Scrolling page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (mob >= 9000000001l && mob <= 9000000020l) { // Environmental Studies Coursebook - Part A
            lib.EnvironmentalcoursebookGrade1().click();
//            wait.until(ExpectedConditions.elementToBeClickable(lib.WorkbookHeading()));
//            wait.until(ExpectedConditions.textToBePresentInElement(lib.WorkbookHeading(), "Environmental Studies Coursebook - Part A"));
            Thread.sleep(3000);
            String text = lib.WorkbookHeading().getText();
            String workbookName = "Environmental Studies Coursebook - Part A";

            return  WorkbookNameValidateTest(workbookName, text);
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
//            wait.until(ExpectedConditions.elementToBeClickable(lib.WorkbookHeading()));
            Thread.sleep(3000);
            String text = lib.WorkbookHeading().getText();
            String workbookName = "English Coursebook - Part A";

            return  WorkbookNameValidateTest(workbookName, text);
        }
        else if (mob >= 9000000041l && mob <= 9000000060l) { // Mathematics Coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
//            wait.until(ExpectedConditions.elementToBeClickable(lib.WorkbookHeading()));
            Thread.sleep(3000);
            String text = lib.WorkbookHeading().getText();
            String workbookName = "Mathematics Coursebook - Part A";

            return  WorkbookNameValidateTest(workbookName, text);
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
//            wait.until(ExpectedConditions.elementToBeClickable(lib.WorkbookHeading()));
            Thread.sleep(3000);
            String text = lib.WorkbookHeading().getText();
            String workbookName = "English Coursebook - Part A";

            return  WorkbookNameValidateTest(workbookName, text);
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) { // Mathematics Coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
//            wait.until(ExpectedConditions.elementToBeClickable(lib.WorkbookHeading()));
            Thread.sleep(3000);
            String text = lib.WorkbookHeading().getText();
            String workbookName = "Mathematics Coursebook - Part A";

            return  WorkbookNameValidateTest(workbookName, text);
        }
        return false;
    }

    public boolean TeacherWorkbookCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        lib.LibraryToggle().click();

        // Scrolling page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            WebElement element = lib.EnvironmentalcoursebookGrade1();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
//            wait.until(ExpectedConditions.elementToBeClickable(lib.WorkbookHeading()));
            Thread.sleep(3000);
            String text = lib.WorkbookHeading().getText();
            String workbookName = "Environmental Studies Coursebook - Part A";

            return  WorkbookNameValidateTest(workbookName, text);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
//            wait.until(ExpectedConditions.elementToBeClickable(lib.WorkbookHeading()));
            Thread.sleep(3000);
            String text = lib.WorkbookHeading().getText();
            String workbookName = "English Coursebook - Part A";

            return  WorkbookNameValidateTest(workbookName, text);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics Coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
//            wait.until(ExpectedConditions.elementToBeClickable(lib.WorkbookHeading()));
            Thread.sleep(3000);
            String text = lib.WorkbookHeading().getText();
            String workbookName = "Mathematics Coursebook - Part A";

            return  WorkbookNameValidateTest(workbookName, text);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
//            wait.until(ExpectedConditions.elementToBeClickable(lib.WorkbookHeading()));
            Thread.sleep(3000);
            String text = lib.WorkbookHeading().getText();
            String workbookName = "English Coursebook - Part A";

            return  WorkbookNameValidateTest(workbookName, text);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
//            wait.until(ExpectedConditions.elementToBeClickable(lib.WorkbookHeading()));
            Thread.sleep(3000);
            String text = lib.WorkbookHeading().getText();
            String workbookName = "Mathematics Coursebook - Part A";

            return  WorkbookNameValidateTest(workbookName, text);
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        wait.until(ExpectedConditions.elementToBeClickable(lib.LibraryToggle()));
        lib.LibraryToggle().click();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String unitName, text, insideHeading;
        if (mob >= 9000000001l && mob <= 9000000020l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2, flag3;
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvironmentalcoursebookGrade1()));
            lib.EnvironmentalcoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();


//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondLesson()));

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdLesson()));

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
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
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

            lib.ThirdLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag1=  LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondLesson()));

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdLesson()));

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag3 = LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();

            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000041l && mob <= 9000000060l) { // Mathematics coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag1=  LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondLesson()));

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdLesson()));

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag3= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();

            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondLesson()));

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdLesson()));

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag3 = LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();

            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) { // Mathematics Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondLesson()));

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdLesson()));
//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag3= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            return flag1 && flag2 & flag3;
        }
        return false;
    }

    public boolean TeacherLessonNameCheck(WebDriver driver, String mobNumber, String password) throws  IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.lib = new Library(driver);
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        wait.until(ExpectedConditions.elementToBeClickable(lib.LibraryToggle()));
        lib.LibraryToggle().click();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String unitName, text, insideHeading;
        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2, flag3;
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvironmentalcoursebookGrade1()));
            lib.EnvironmentalcoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();


//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondLesson()));

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdLesson()));

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag3 = LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            ThreadSleep5000();
            System.out.println(flag1+" "+flag2+" "+flag3);
            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

            lib.ThirdLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag1=  LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondLesson()));

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdLesson()));

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();
            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag3 = LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();

            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag1=  LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondLesson()));

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdLesson()));

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag3= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();

            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();
            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondLesson()));

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdLesson()));

//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag3 = LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();

            return flag1 && flag2 & flag3;
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));

//          Topic Test -1
            WebElement FirstLesson = lib.FirstLesson();
            unitName = lib.FirstLessonText().getText();
            FirstLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag1= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondLesson()));

//          Topic Test -2
            WebElement SecondLesson = lib.SecondLesson();
            unitName = lib.SecondLessonText().getText();
            SecondLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag2= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdLesson()));
//          Topic Test -3
            WebElement ThirdLesson = lib.ThirdLesson();
            unitName = lib.ThirdLessonText().getText();
            ThirdLesson.click();

            text = lib.LessonHeadingText();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));
            lib.FirstTopic().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.InsideLessonHeading()));
            Thread.sleep(2000);
            insideHeading = lib.InsideLessonHeading().getText();

            flag3= LessonNameValidate(unitName, text, insideHeading);

            lib.BackButton().click();
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        wait.until(ExpectedConditions.elementToBeClickable(lib.LibraryToggle()));
        lib.LibraryToggle().click();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String unitname, text;
        if (mob >= 9000000001l && mob <= 9000000020l) { // Environmental Studies Coursebook - Part A
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvironmentalcoursebookGrade1()));
            boolean flag1, flag2, flag3;
            lib.EnvironmentalcoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvFirstLessonFirstTopicRefGrade1()));
            text = lib.EnvFirstLessonFirstTopicRefGrade1().getText();

            flag1= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondTopic()));

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvFirstLessonSecondTopicRefGrade1()));

            text = lib.EnvFirstLessonSecondTopicRefGrade1().getText();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdTopic()));

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvFirstLessonThirdTopicRefGrade1()));

            text = lib.EnvFirstLessonThirdTopicRefGrade1().getText();

            flag3= LessonTopicValidate(unitname, text);

            lib.BackButton().click();

            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

            lib.ThirdLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngThirdLessonFirstTopicRefGrade2()));

            text = lib.EngThirdLessonFirstTopicRefGrade2().getText();

            flag1= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondTopic()));

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngThirdLessonSecondTopicRefGrade2()));

            text = lib.EngThirdLessonSecondTopicRefGrade2().getText();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdTopic()));

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngThirdLessonThirdTopicRefGrade2()));

            text = lib.EngThirdLessonThirdTopicRefGrade2().getText();

            flag3= LessonTopicValidate(unitname, text);

            lib.BackButton().click();

            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000041l && mob <= 9000000060l) { // Mathematics coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathFirstLessonFirstTopicRefGrade3()));

            text = lib.MathFirstLessonFirstTopicRefGrade3().getText();

            flag1 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondTopic()));

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathFirstLessonSecondTopicRefGrade3()));

            text = lib.MathFirstLessonSecondTopicRefGrade3().getText();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdTopic()));

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathFirstLessonThirdTopicRefGrade3()));

            text = lib.MathFirstLessonThirdTopicRefGrade3().getText();

            flag3= LessonTopicValidate(unitname, text);

            lib.BackButton().click();

            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));

            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngFirstLessonFirstTopicRefGrade4()));

            text = lib.EngFirstLessonFirstTopicRefGrade4().getText();

            flag1= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondTopic()));

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngFirstLessonSecondTopicRefGrade4()));

            text = lib.EngFirstLessonSecondTopicRefGrade4().getText();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdTopic()));

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngFirstLessonThirdTopicRefGrade4()));

            text = lib.EngFirstLessonThirdTopicRefGrade4().getText();

            flag3 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();

            return flag1 && flag2 && flag3;
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) { // Mathematics Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));

            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathFirstLessonFirstTopicRefGrade5()));

            text = lib.MathFirstLessonFirstTopicRefGrade5().getText();

            flag1= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondTopic()));

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathFirstLessonSecondTopicRefGrade5()));

            text = lib.MathFirstLessonSecondTopicRefGrade5().getText();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdTopic()));

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathFirstLessonThirdTopicRefGrade5()));

            text = lib.MathFirstLessonThirdTopicRefGrade5().getText();

            flag3= LessonTopicValidate(unitname, text);

            lib.BackButton().click();

            return flag1 && flag2 && flag3;
        }
        return false;
    }

    public boolean TeacherLessonTopicCheck(WebDriver driver, String mobNumber, String password) throws  IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        wait.until(ExpectedConditions.elementToBeClickable(lib.LibraryToggle()));
        lib.LibraryToggle().click();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String unitname, text;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvironmentalcoursebookGrade1()));
            boolean flag1, flag2, flag3;
            lib.EnvironmentalcoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvFirstLessonFirstTopicRefGrade1()));
            text = lib.EnvFirstLessonFirstTopicRefGrade1().getText();

            flag1= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondTopic()));

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvFirstLessonSecondTopicRefGrade1()));

            text = lib.EnvFirstLessonSecondTopicRefGrade1().getText();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdTopic()));

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvFirstLessonThirdTopicRefGrade1()));

            text = lib.EnvFirstLessonThirdTopicRefGrade1().getText();

            flag3= LessonTopicValidate(unitname, text);

            lib.BackButton().click();

            return flag1 && flag2 && flag3;
        }
        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

            lib.ThirdLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngThirdLessonFirstTopicRefGrade2()));

            text = lib.EngThirdLessonFirstTopicRefGrade2().getText();

            flag1= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondTopic()));

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngThirdLessonSecondTopicRefGrade2()));

            text = lib.EngThirdLessonSecondTopicRefGrade2().getText();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdTopic()));

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngThirdLessonThirdTopicRefGrade2()));

            text = lib.EngThirdLessonThirdTopicRefGrade2().getText();

            flag3= LessonTopicValidate(unitname, text);

            lib.BackButton().click();

            return flag1 && flag2 && flag3;
        }
        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();

            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathFirstLessonFirstTopicRefGrade3()));

            text = lib.MathFirstLessonFirstTopicRefGrade3().getText();

            flag1 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondTopic()));

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathFirstLessonSecondTopicRefGrade3()));

            text = lib.MathFirstLessonSecondTopicRefGrade3().getText();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdTopic()));

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathFirstLessonThirdTopicRefGrade3()));

            text = lib.MathFirstLessonThirdTopicRefGrade3().getText();

            flag3= LessonTopicValidate(unitname, text);

            lib.BackButton().click();

            return flag1 && flag2 && flag3;
        }
        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));

            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngFirstLessonFirstTopicRefGrade4()));

            text = lib.EngFirstLessonFirstTopicRefGrade4().getText();

            flag1= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondTopic()));

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngFirstLessonSecondTopicRefGrade4()));

            text = lib.EngFirstLessonSecondTopicRefGrade4().getText();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdTopic()));

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngFirstLessonThirdTopicRefGrade4()));

            text = lib.EngFirstLessonThirdTopicRefGrade4().getText();

            flag3 = LessonTopicValidate(unitname, text);

            lib.BackButton().click();

            return flag1 && flag2 && flag3;
        }
        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            boolean flag1, flag2, flag3;
            WebElement element = lib.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));

            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

//          Topic Test -1
            WebElement FirstTopic = lib.FirstTopic();
            unitname = FirstTopic.getText();
            FirstTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathFirstLessonFirstTopicRefGrade5()));

            text = lib.MathFirstLessonFirstTopicRefGrade5().getText();

            flag1= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondTopic()));

//          Topic Test -2
            WebElement SecondTopic = lib.SecondTopic();
            unitname = SecondTopic.getText();
            SecondTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathFirstLessonSecondTopicRefGrade5()));

            text = lib.MathFirstLessonSecondTopicRefGrade5().getText();

            flag2= LessonTopicValidate(unitname, text);

            lib.BackButton().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdTopic()));

//          Topic Test -3
            WebElement ThirdTopic = lib.ThirdTopic();
            unitname = ThirdTopic.getText();
            ThirdTopic.click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathFirstLessonThirdTopicRefGrade5()));

            text = lib.MathFirstLessonThirdTopicRefGrade5().getText();

            flag3= LessonTopicValidate(unitname, text);

            lib.BackButton().click();

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        wait.until(ExpectedConditions.elementToBeClickable(lib.LibraryToggle()));
        lib.LibraryToggle().click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (mob >= 9000000001l && mob <= 9000000020l){ // Environmental Studies Coursebook - Part A
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvironmentalcoursebookGrade1()));
            lib.EnvironmentalcoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondLesson()));
            lib.SecondLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

            lib.FirstTopic().click();
            ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(lib.AudioPlayBtn()));
            Thread.sleep(3000);
            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000021l && mob <= 9000000040l){ // English Coursebook - Part A
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade2()));
            lib.EnglishCoursebookGrade2().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngCommunicationTopic()));

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(lib.AudioPlayBtn()));
            Thread.sleep(3000);

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000041l && mob <= 9000000060l){ // English Coursebook - Part A
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade3()));
            lib.EnglishCoursebookGrade3().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngCommunicationTopic()));

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(lib.AudioPlayBtn()));
            Thread.sleep(3000);

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000061l && mob <= 9000000080l){ // English Coursebook - Part A
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade4()));
            lib.EnglishCoursebookGrade4().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngCommunicationTopic()));

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(lib.AudioPlayBtn()));
            Thread.sleep(3000);

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000081l && mob <= 9000000100l){ // English Coursebook - Part A
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade5()));
            lib.EnglishCoursebookGrade5().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngCommunicationTopic()));

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            Thread.sleep(3000);

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        return false;
    }

    public boolean teacherAudiocheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        wait.until(ExpectedConditions.elementToBeClickable(lib.LibraryToggle()));
        lib.LibraryToggle().click();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (mob >= 9000000101l && mob <= 9000000104l) { // English Coursebook - Part A
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvironmentalcoursebookGrade1()));
            lib.EnvironmentalcoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SecondLesson()));
            lib.SecondLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

            lib.FirstTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(lib.AudioPlayBtn()));
            Thread.sleep(3000);

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade2()));
            lib.EnglishCoursebookGrade2().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngCommunicationTopic()));

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(lib.AudioPlayBtn()));
            Thread.sleep(3000);

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000109l && mob <= 9000000112l) { // English Coursebook - Part A
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade3()));
            lib.EnglishCoursebookGrade3().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngCommunicationTopic()));

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(lib.AudioPlayBtn()));
            Thread.sleep(3000);

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade4()));
            lib.EnglishCoursebookGrade4().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngCommunicationTopic()));

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(lib.AudioPlayBtn()));
            Thread.sleep(3000);

            lib.AudioPlayBtn().click();
            ThreadSleep5000();

            String curr_time = lib.CurrPlayTime().getText();
            return AudioCheckValidateTest(curr_time);
        }
        else if (mob >= 9000000117l && mob <= 9000000120l) { // English Coursebook - Part A
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade5()));
            lib.EnglishCoursebookGrade5().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.EngCommunicationTopic()));

            lib.EngCommunicationTopic().click();
            ThreadSleep5000(); ThreadSleep5000();

            WebElement element = lib.AudioPlayer();
            js.executeScript("arguments[0].scrollIntoView();", element);
            wait.until(ExpectedConditions.elementToBeClickable(lib.AudioPlayBtn()));
            Thread.sleep(3000);

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
        this.lib = new Library(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        wait.until(ExpectedConditions.elementToBeClickable(lib.LibraryToggle()));
        lib.LibraryToggle().click();

        // Scrolling Page
        js = (JavascriptExecutor) driver;
        if (mob >= 9000000001l && mob <= 9000000020l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2;
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvironmentalcoursebookGrade1()));
            lib.EnvironmentalcoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.videosPageTab()));

            lib.videosPageTab().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.VideoWatchBtn()));
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
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade2()));
            lib.EnglishCoursebookGrade2().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.videosPageTab()));

            lib.videosPageTab().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.VideoWatchBtn()));
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
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade3()));
            lib.EnglishCoursebookGrade3().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.videosPageTab()));

            lib.videosPageTab().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.VideoWatchBtn()));
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
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade4()));
            lib.EnglishCoursebookGrade4().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.videosPageTab()));

            lib.videosPageTab().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.VideoWatchBtn()));
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
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathematicsCoursebookGrade5()));
            lib.MathematicsCoursebookGrade5().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.videosPageTab()));

            lib.videosPageTab().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.VideoWatchBtn()));
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
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        wait.until(ExpectedConditions.elementToBeClickable(lib.LibraryToggle()));
        lib.LibraryToggle().click();

        // Scrolling Page
        js = (JavascriptExecutor) driver;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            boolean flag1, flag2;
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvironmentalcoursebookGrade1()));
            lib.EnvironmentalcoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.videosPageTab()));

            lib.videosPageTab().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.VideoWatchBtn()));
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
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade2()));
            lib.EnglishCoursebookGrade2().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.videosPageTab()));

            lib.videosPageTab().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.VideoWatchBtn()));
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
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade3()));
            lib.EnglishCoursebookGrade3().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.videosPageTab()));

            lib.videosPageTab().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.VideoWatchBtn()));
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
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade4()));
            lib.EnglishCoursebookGrade4().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.videosPageTab()));

            lib.videosPageTab().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.VideoWatchBtn()));
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
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathematicsCoursebookGrade5()));
            lib.MathematicsCoursebookGrade5().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.videosPageTab()));

            lib.videosPageTab().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.VideoWatchBtn()));
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
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstTopic()));

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        studentblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        wait.until(ExpectedConditions.elementToBeClickable(lib.LibraryToggle()));
        lib.LibraryToggle().click();

        if (mob >= 9000000001l && mob <= 9000000020l){ // Environmental Studies Coursebook - Part A
            String search_text= "good";
            int expected_count=4;
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvironmentalcoursebookGrade1()));
            lib.EnvironmentalcoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdLesson()));
            //click third lesson
            lib.ThirdLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SearchIcon()));
            Thread.sleep(3000);

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade2()));
            lib.EnglishCoursebookGrade2().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            //click first lesson
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SearchIcon()));
            Thread.sleep(3000);

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathematicsCoursebookGrade3()));
            lib.MathematicsCoursebookGrade3().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            //click first lesson
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SearchIcon()));
            Thread.sleep(3000);

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade4()));
            lib.EnglishCoursebookGrade4().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            //click first lesson
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SearchIcon()));
            Thread.sleep(3000);

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade5()));
            lib.EnglishCoursebookGrade5().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            //click first lesson
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.SearchIcon()));
            Thread.sleep(3000);

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Long mob = Long.parseLong(mobNumber);
        teacherblock(driver, mobNumber, password);
        this.lib = new Library(driver);
        wait.until(ExpectedConditions.elementToBeClickable(lib.LibraryToggle()));
        lib.LibraryToggle().click();

        if (mob >= 9000000101l && mob <= 9000000104l){ // Environmental Studies Coursebook - Part A
            String search_text= "good";
            int expected_count=4;
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnvironmentalcoursebookGrade1()));
            lib.EnvironmentalcoursebookGrade1().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.ThirdLesson()));
            //click third lesson
            lib.ThirdLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.TeacherSearchIcon()));
            Thread.sleep(3000);

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade2()));
            lib.EnglishCoursebookGrade2().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            //click first lesson
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.TeacherSearchIcon()));
            Thread.sleep(3000);

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.MathematicsCoursebookGrade3()));
            lib.MathematicsCoursebookGrade3().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            //click first lesson
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.TeacherSearchIcon()));
            Thread.sleep(3000);

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade4()));
            lib.EnglishCoursebookGrade4().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            //click first lesson
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.TeacherSearchIcon()));
            Thread.sleep(3000);

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
            wait.until(ExpectedConditions.elementToBeClickable(lib.EnglishCoursebookGrade5()));
            lib.EnglishCoursebookGrade5().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.FirstLesson()));
            //click first lesson
            lib.FirstLesson().click();
            wait.until(ExpectedConditions.elementToBeClickable(lib.TeacherSearchIcon()));
            Thread.sleep(3000);

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
