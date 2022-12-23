package executions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.LessonDelivery;
import pageObjects.LoginPage;
import resources.BaseLogin;

import java.io.IOException;
import java.util.List;

public class LessonDeliveryMethods extends BaseLogin {
    public LessonDelivery ld;
    public LoginPage log;
    public WebDriver driver;

    public LessonDeliveryMethods(WebDriver driver2) {
        super(driver2);
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
    public void ThreadSleep5000() throws InterruptedException {
        Thread.sleep(5000);
    }
    public boolean CompletedOngoingValidateTest(boolean flag1) {
        System.out.println(flag1);
        if(flag1){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean TeacherCompletedOngoingTagCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            boolean flag = false;
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            Thread.sleep(2000);
            if(ld.LearningPlanStatus().getText().contains("Completed")){
                // completed
                flag = true;
            }
            else if (ld.LearningPlanStatus().getText().contains("Start")) {
                // not yet started
                Thread.sleep(2000);
                ld.LearningPlanStatus().click();
                Thread.sleep(2000);
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            else {
                // on going
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[contains(text(),'Resume')]")).click();
                Thread.sleep(2000);
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            return CompletedOngoingValidateTest(flag);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            boolean flag = false;
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            if(ld.LearningPlanStatus().getText().contains("Completed")){
                // completed
                flag = true;
            }
            else if (driver.getPageSource().contains("Start")) {
                // not yet started
                driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            else {
                // on going
                driver.findElement(By.xpath("//button[contains(text(),'Resume')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            return CompletedOngoingValidateTest(flag);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            boolean flag = false;
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            if(ld.LearningPlanStatus().getText().contains("Completed")){
                // completed
                flag = true;
            }
            else if (driver.getPageSource().contains("Start")) {
                // not yet started
                driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            else {
                // on going
                driver.findElement(By.xpath("//button[contains(text(),'Resume')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            return CompletedOngoingValidateTest(flag);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            boolean flag = false;
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            if(ld.LearningPlanStatus().getText().contains("Completed")){
                // completed
                flag = true;
            }
            else if (driver.getPageSource().contains("Start")) {
                // not yet started
                driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            else {
                // on going
                driver.findElement(By.xpath("//button[contains(text(),'Resume')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            return CompletedOngoingValidateTest(flag);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            boolean flag = false;
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            if(ld.LearningPlanStatus().getText().contains("Completed")){
                // completed
                flag = true;
            }
            else if (driver.getPageSource().contains("Start")) {
                // not yet started
                driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            else {
                // on going
                driver.findElement(By.xpath("//button[contains(text(),'Resume')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            return CompletedOngoingValidateTest(flag);
        }
        return false;
    }

    public boolean CompletePercentageValidateTest(int CalculatedPercentage) {
        if(CalculatedPercentage >0){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean TeacherCompletePercentageCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }
        ld.FirstLesson().click();
        Thread.sleep(1000);

        int Total_no_of_plans = ld.LearningPlans().size();
        int completed_plans = driver.findElements(By.xpath("//*[contains(@class, 'completed')]")).size();

        return CompletePercentageValidateTest(completed_plans/Total_no_of_plans);
    }

    private boolean CreateLearningPlanValidateTest(String ContentDisplayed, String description) {
        if(ContentDisplayed.contains(description)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean TeacherCreateLearningPlanCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }
        ld.FirstLesson().click();
        Thread.sleep(1000);

        ld.LessonPlanMode().click();
        Thread.sleep(2000);
        ld.CreateLearningPlanBtn().click();
        Thread.sleep(2000);

        ld.LearningPlanInputs().get(1).click();
        ld.LearningPlanInputs().get(1).sendKeys("Description");

        ld.LearningPlanInputs().get(2).click();
        ld.LearningPlanInputs().get(2).sendKeys("Content");

        ld.LearningPlanSubmitBtn().click();
        Thread.sleep(2000);

        String LearningPlanContent = ld.CustomLearningPlans().get(ld.CustomLearningPlans().size()-1).getText();

        return CreateLearningPlanValidateTest(LearningPlanContent, "Description");
    }

    private boolean DeleteLearningPlanValidateTest(int initialCount, int FinalCount) {
        if(initialCount == FinalCount){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean TeacherDeleteLearningPlanCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }
        ld.FirstLesson().click();
        Thread.sleep(1000);

        ld.LessonPlanMode().click();
        Thread.sleep(2000);

        if(ld.LearningPlans().size() > 0){
            System.out.println(1);
            int initial_no_of_plans = ld.LearningPlans().size();
            ld.DeleteBtn().click();
            ld.ConfirmDeleteBtn().click();
            Thread.sleep(2000);
            int final_no_of_plans = ld.LearningPlans().size();

            return DeleteLearningPlanValidateTest(initial_no_of_plans, final_no_of_plans + 1);

        }
        else{
            System.out.println(2);
            // create
            ld.CreateLearningPlanBtn().click();
            Thread.sleep(2000);

            ld.LearningPlanInputs().get(1).click();
            ld.LearningPlanInputs().get(1).sendKeys("Description");

            ld.LearningPlanInputs().get(2).click();
            ld.LearningPlanInputs().get(2).sendKeys("Content");

            ld.LearningPlanSubmitBtn().click();
            Thread.sleep(2000);

            // delete
            int initial_no_of_plans = ld.LearningPlans().size();
            ld.DeleteBtn().click();
            ld.ConfirmDeleteBtn().click();
            Thread.sleep(2000);
            int final_no_of_plans = ld.LearningPlans().size();

            return DeleteLearningPlanValidateTest(initial_no_of_plans, final_no_of_plans + 1);
        }
    }

    private boolean EditLearningPlanValidateTest(String ContentDisplayed, String expected) {
        if (ContentDisplayed.contains(expected)) {
            System.out.println("PASSED");
            return true;
        } else {
            return false;
        }
    }

    public boolean TeacherEditLearningPlanCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
        } else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

        } else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

        } else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        } else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }
        ld.FirstLesson().click();
        Thread.sleep(1000);

        ld.LessonPlanMode().click();
        Thread.sleep(2000);

        if (ld.LearningPlans().size() > 0) {
            ld.EditBtn().click();
            String Heading = ld.WorkbookHeading().getText();
            return EditLearningPlanValidateTest(Heading, "Update Learning Plan");
        } else {
            // create
            ld.CreateLearningPlanBtn().click();
            Thread.sleep(2000);

            ld.LearningPlanInputs().get(1).click();
            ld.LearningPlanInputs().get(1).sendKeys("Description");

            ld.LearningPlanInputs().get(2).click();
            ld.LearningPlanInputs().get(2).sendKeys("Content");

            ld.LearningPlanSubmitBtn().click();
            Thread.sleep(2000);

            // edit
            ld.EditBtn().click();
            String Heading = ld.WorkbookHeading().getText();
            return EditLearningPlanValidateTest(Heading, "Update Learning Plan");
        }
    }

    public boolean GradeValidateTest(String actual_grade, String expected_grade){
        if (actual_grade.contains(expected_grade)) {
            System.out.println("PASSED");
            return true;
        } else {
            return false;
        }
    }
    public boolean CheckTeacherBookGrade(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        if (mob >= 9000000101l && mob <= 9000000104l) {
            String actual_grade = ld.EnglishGradeTextGrade1().getText();
            String expected_grade = "GRADE 1";

            return GradeValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) {
            String actual_grade = ld.EnglishGradeTextGrade2().getText();
            String expected_grade = "GRADE 2";

            return GradeValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {
            String actual_grade = ld.EnglishGradeTextGrade3().getText();
            String expected_grade = "GRADE 3";

            return GradeValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            String actual_grade = ld.EnglishGradeTextGrade4().getText();
            String expected_grade = "GRADE 4";

            return GradeValidateTest(actual_grade, expected_grade);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            String actual_grade = ld.EnglishGradeTextGrade5().getText();
            String expected_grade = "GRADE 5";

            return GradeValidateTest(actual_grade, expected_grade);
        }
        return false;
    }

    public boolean InsertAudioValidateTest(WebElement insertedImage, String DisplayedFileFormat) {
        if(insertedImage.isDisplayed() && DisplayedFileFormat.contains("mp3")){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }
    public boolean TeacherInsertAudioCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }
        ld.FirstLesson().click();
        Thread.sleep(1000);

        ld.LessonPlanMode().click();
        Thread.sleep(2000);

        ld.CreateLearningPlanBtn().click();
        Thread.sleep(2000);

        ld.LearningPlanInputs().get(1).click();
        ld.LearningPlanInputs().get(1).sendKeys("Description");

        ld.LearningPlanInputs().get(2).click();
        ld.LearningPlanInputs().get(2).sendKeys("Content");

        ld.AudioFileSelectionOption().sendKeys(System.getProperty("user.dir")+"/SampleFiles/audio.mp3");

        Thread.sleep(3000);
        ld.LearningPlanSubmitBtn().click();
        Thread.sleep(2000);

        ld.LearningPlans().get(ld.LearningPlans().size() -1).click();
        WebElement insertedImage = ld.FilePreview();
        List<String> DisplayedFile = List.of(ld.DisplayedFileFormat().getText().split("\\."));
        String DisplayedFileFormat = DisplayedFile.get(DisplayedFile.size() -1);
        return InsertAudioValidateTest(insertedImage, DisplayedFileFormat);
    }

    public boolean InsertImageValidateTest(WebElement insertedImage, String DisplayedFileFormat) {
        if(insertedImage.isDisplayed() && DisplayedFileFormat.contains("jpg")){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }
    public boolean TeacherInsertImageCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }
        ld.FirstLesson().click();
        Thread.sleep(1000);

        ld.LessonPlanMode().click();
        Thread.sleep(2000);

        ld.CreateLearningPlanBtn().click();
        Thread.sleep(2000);

        ld.LearningPlanInputs().get(1).click();
        ld.LearningPlanInputs().get(1).sendKeys("Description");

        ld.LearningPlanInputs().get(2).click();
        ld.LearningPlanInputs().get(2).sendKeys("Content");

        ld.ImageFileSelectionOption().sendKeys(System.getProperty("user.dir")+"/SampleFiles/jpgimg.jpg");

        Thread.sleep(3000);
        ld.LearningPlanSubmitBtn().click();
        Thread.sleep(2000);

        ld.LearningPlans().get(ld.LearningPlans().size() -1).click();
        WebElement insertedImage = ld.FilePreview();
        List<String> DisplayedFile = List.of(ld.DisplayedFileFormat().getText().split("\\."));
        String DisplayedFileFormat = DisplayedFile.get(DisplayedFile.size() -1);
        return InsertImageValidateTest(insertedImage, DisplayedFileFormat);
    }

    public boolean InsertLinkValidateTest(String insertedlink) {
        if(insertedlink.contains("google.com")){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean TeacherInsertLinkCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }
        ld.FirstLesson().click();
        Thread.sleep(1000);

        ld.LessonPlanMode().click();
        Thread.sleep(2000);

        ld.CreateLearningPlanBtn().click();
        Thread.sleep(2000);

        ld.LearningPlanInputs().get(1).click();
        ld.LearningPlanInputs().get(1).sendKeys("Description");

        ld.LearningPlanInputs().get(2).click();
        ld.LearningPlanInputs().get(2).sendKeys("Content");

        ld.FileSelectionOptions().get(1).click();
        ld.LinkInputBox().click();
        ld.LinkInputBox().sendKeys("google.com");
        ld.AddLinkBtn().click();

        ld.LearningPlanSubmitBtn().click();
        Thread.sleep(2000);

        ld.LearningPlans().get(ld.LearningPlans().size() -1).click();
        String insertedLinkText = ld.previewLink().getText();
        return InsertLinkValidateTest(insertedLinkText);

    }

    public boolean InsertPDFValidateTest(WebElement insertedImage, String DisplayedFileFormat) {
        if(insertedImage.isDisplayed() && DisplayedFileFormat.contains("pdf")){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }
    public boolean TeacherInsertPDFCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }
        ld.FirstLesson().click();
        Thread.sleep(1000);

        ld.LessonPlanMode().click();
        Thread.sleep(2000);

        ld.CreateLearningPlanBtn().click();
        Thread.sleep(2000);

        ld.LearningPlanInputs().get(1).click();
        ld.LearningPlanInputs().get(1).sendKeys("Description");

        ld.LearningPlanInputs().get(2).click();
        ld.LearningPlanInputs().get(2).sendKeys("Content");

        ld.PDFFileSelectionOption().sendKeys(System.getProperty("user.dir")+"/SampleFiles/pdf.pdf");

        Thread.sleep(3000);
        ld.LearningPlanSubmitBtn().click();
        Thread.sleep(2000);

        ld.LearningPlans().get(ld.LearningPlans().size() -1).click();
        WebElement insertedImage = ld.FilePreview();
        List<String> DisplayedFile = List.of(ld.DisplayedFileFormat().getText().split("\\."));
        String DisplayedFileFormat = DisplayedFile.get(DisplayedFile.size() -1);
        return InsertPDFValidateTest(insertedImage, DisplayedFileFormat);
    }

    public boolean InsertVideoValidateTest(WebElement insertedImage, String DisplayedFileFormat) {
        if(insertedImage.isDisplayed() && DisplayedFileFormat.contains("mp4")){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean TeacherInsertVideoCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

        }
        ld.FirstLesson().click();
        Thread.sleep(1000);

        ld.LessonPlanMode().click();
        Thread.sleep(2000);

        ld.CreateLearningPlanBtn().click();
        Thread.sleep(2000);

        ld.LearningPlanInputs().get(1).click();
        ld.LearningPlanInputs().get(1).sendKeys("Description");

        ld.LearningPlanInputs().get(2).click();
        ld.LearningPlanInputs().get(2).sendKeys("Content");

        ld.VideoFileSelectionOption().sendKeys(System.getProperty("user.dir")+"/SampleFiles/video.mp4");

        Thread.sleep(3000);
        ld.LearningPlanSubmitBtn().click();
        Thread.sleep(2000);

        ld.LearningPlans().get(ld.LearningPlans().size() -1).click();
        WebElement insertedImage = ld.FilePreview();
        List<String> DisplayedFile = List.of(ld.DisplayedFileFormat().getText().split("\\."));
        String DisplayedFileFormat = DisplayedFile.get(DisplayedFile.size() -1);
        return InsertVideoValidateTest(insertedImage, DisplayedFileFormat);
    }

    public boolean TeacherLandingValidateTest(String actual_header){
        if (actual_header.contains("Lesson Delivery")) {
            System.out.println("Lesson Delivery Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ld.LessonDeliveryToggle().click();
        Thread.sleep(2000);

        String actual_header = ld.GetHeader();
        return TeacherLandingValidateTest(actual_header);
    }

    public boolean LessonNameValidateTest(Boolean flag1, Boolean flag2, Boolean flag3) {
        System.out.println(flag1+" "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean CheckHeading(String Expected, String Actual){
        return Actual.contains(Expected);
    }

    public boolean TeacherLessonNameCheck(WebDriver driver, String mobNumber, String password) throws  IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();

        // Scrolling Page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String ExpectedLessonName, ActualLessonName;
        boolean flag1, flag2, flag3;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.FirstLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag1 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.SecondLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag2 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.ThirdLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag3 = CheckHeading(ExpectedLessonName, ActualLessonName);

            return LessonNameValidateTest(flag1, flag2, flag3);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.FirstLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag1 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.SecondLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag2 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.ThirdLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag3 = CheckHeading(ExpectedLessonName, ActualLessonName);

            return LessonNameValidateTest(flag1, flag2, flag3);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.FirstLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag1 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.SecondLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag2 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.ThirdLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag3 = CheckHeading(ExpectedLessonName, ActualLessonName);

            return LessonNameValidateTest(flag1, flag2, flag3);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.FirstLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag1 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.SecondLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag2 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.ThirdLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag3 = CheckHeading(ExpectedLessonName, ActualLessonName);

            return LessonNameValidateTest(flag1, flag2, flag3);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.FirstLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag1 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -2
            ld.SecondLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.SecondLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag2 = CheckHeading(ExpectedLessonName, ActualLessonName);

//          Lesson -3
            ld.ThirdLesson().click();
            Thread.sleep(1000);

            ExpectedLessonName = ld.ThirdLesson().getText();
            ActualLessonName = ld.DisplayedLessonName().getText();

            flag3 = CheckHeading(ExpectedLessonName, ActualLessonName);

            return LessonNameValidateTest(flag1, flag2, flag3);
        }
        return false;
    }

    public boolean LessonPlanNameValidateTest(boolean flag1, boolean flag2, boolean flag3) {
        System.out.println(flag1+" "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean TeacherLessonPlanNameCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String blackColor = "#131536";
        String blueColor = "rgba(71, 75, 255, 1)";
        boolean flag1, flag2, flag3, flag4;
        String classname;
        WebElement expandedComponent;
        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            Thread.sleep(2000);
            WebElement FirstComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button"));
            if(!String.valueOf(FirstComponent.getClass()).contains("collapsed")){
                ld.TeachComponent().click();
            }
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]// button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag1 = expandedComponent.isDisplayed();
//            flag1 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.TeachComponent().click();

            Thread.sleep(2000);

            ld.ApplyComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.ApplyComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag2 = expandedComponent.isDisplayed();
//            flag2 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            Thread.sleep(2000);

            ld.AssessComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.AssessComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag3 = expandedComponent.isDisplayed();
            Thread.sleep(1000);
            ld.AssessComponent().click();

            Thread.sleep(2000);

            ld.ReviewComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.ReviewComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]// button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag4 = expandedComponent.isDisplayed();
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            return LessonPlanNameValidateTest(flag1, flag2, flag3);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            Thread.sleep(2000);
            WebElement FirstComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button"));
            if(!String.valueOf(FirstComponent.getClass()).contains("collapsed")){
                ld.TeachComponent().click();
            }
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]// button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag1 = expandedComponent.isDisplayed();
//            flag1 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.TeachComponent().click();

            Thread.sleep(2000);

            ld.ApplyComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.ApplyComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag2 = expandedComponent.isDisplayed();
//            flag2 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            Thread.sleep(2000);

            ld.AssessComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.AssessComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag3 = expandedComponent.isDisplayed();
            Thread.sleep(1000);
            ld.AssessComponent().click();

            Thread.sleep(2000);

            ld.ReviewComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.ReviewComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]// button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag4 = expandedComponent.isDisplayed();
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            return LessonPlanNameValidateTest(flag1, flag2, flag3);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            Thread.sleep(2000);
            WebElement FirstComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button"));
            if(!String.valueOf(FirstComponent.getClass()).contains("collapsed")){
                ld.TeachComponent().click();
            }
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]// button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag1 = expandedComponent.isDisplayed();
//            flag1 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.TeachComponent().click();

            Thread.sleep(2000);

            ld.ApplyComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.ApplyComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag2 = expandedComponent.isDisplayed();
//            flag2 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            Thread.sleep(2000);

            ld.AssessComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.AssessComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag3 = expandedComponent.isDisplayed();
            Thread.sleep(1000);
            ld.AssessComponent().click();

            Thread.sleep(2000);

            ld.ReviewComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.ReviewComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]// button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag4 = expandedComponent.isDisplayed();
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            return LessonPlanNameValidateTest(flag1, flag2, flag3);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            Thread.sleep(2000);
            WebElement FirstComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button"));
            if(!String.valueOf(FirstComponent.getClass()).contains("collapsed")){
                ld.TeachComponent().click();
            }
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]// button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag1 = expandedComponent.isDisplayed();
//            flag1 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.TeachComponent().click();

            Thread.sleep(2000);

            ld.ApplyComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.ApplyComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag2 = expandedComponent.isDisplayed();
//            flag2 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            Thread.sleep(2000);

            ld.AssessComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.AssessComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag3 = expandedComponent.isDisplayed();
            Thread.sleep(1000);
            ld.AssessComponent().click();

            Thread.sleep(2000);

            ld.ReviewComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.ReviewComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]// button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag4 = expandedComponent.isDisplayed();
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            return LessonPlanNameValidateTest(flag1, flag2, flag3);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();
            Thread.sleep(2000);
            WebElement FirstComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button"));
            if(!String.valueOf(FirstComponent.getClass()).contains("collapsed")){
                ld.TeachComponent().click();
            }
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]// button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag1 = expandedComponent.isDisplayed();
//            flag1 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.TeachComponent().click();

            Thread.sleep(2000);

            ld.ApplyComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.ApplyComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag2 = expandedComponent.isDisplayed();
//            flag2 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            Thread.sleep(2000);

            ld.AssessComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.AssessComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]//button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag3 = expandedComponent.isDisplayed();
            Thread.sleep(1000);
            ld.AssessComponent().click();

            Thread.sleep(2000);

            ld.ReviewComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.ReviewComponent().getAttribute("class"));
            expandedComponent = driver.findElement(By.xpath("//*[contains(@class,'accordion-header')]// button[not(contains(@class,'collapsed')) and @aria-expanded='true']"));
            flag4 = expandedComponent.isDisplayed();
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            return LessonPlanNameValidateTest(flag1, flag2, flag3);
        }
        return false;
    }

    public boolean ColorCheck(String actual, String expected){
        System.out.println(actual+" "+expected);
        return actual.contains(expected);
    }
    public boolean LessonPlanComponentsValidateTest(boolean flag1, boolean flag2, boolean flag3, boolean flag4) {
        System.out.println(flag1+" "+flag2+" "+flag3+" "+flag4);
        if(flag1 && flag2 && flag3 && flag4){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean ClassCheck(String actual, String expected){
        System.out.println(actual+" "+expected);
        return !actual.contains(expected);
    }
    public boolean TeacherLessonPlanComponentCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String blackColor = "#131536";
        String blueColor = "rgba(71, 75, 255, 1)";
        boolean flag1, flag2, flag3, flag4;
        String classname;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.TeachComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getAttribute("class"));
            flag1 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.TeachComponent().click();

//            driver.findElement(By.xpath("//*[contains(@id,'flush-headingTwo')]/button")).click();
//            Thread.sleep(5000);
//            String classname1 = String.valueOf(driver.findElement(By.xpath("//*[contains(@id,'flush-headingTwo')]/button")).getAttribute("class"));
//            flag2 = ClassCheck(classname1, "collapsed");
//            Thread.sleep(1000);
//            ld.ApplyComponent().click();

            ld.ApplyComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.ApplyComponent().getAttribute("class"));
            flag2 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            ld.AssessComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.AssessComponent().getAttribute("class"));
            flag3 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.AssessComponent().click();

            ld.ReviewComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.ReviewComponent().getAttribute("class"));
            flag4 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            return LessonPlanComponentsValidateTest(flag1, flag2, flag3, flag4);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.TeachComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag1 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.TeachComponent().click();

            ld.ApplyComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag2 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            ld.AssessComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag3 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.AssessComponent().click();

            ld.ReviewComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag4 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            return LessonPlanComponentsValidateTest(flag1, flag2, flag3, flag4);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.TeachComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag1 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.TeachComponent().click();

            ld.ApplyComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag2 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            ld.AssessComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag3 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.AssessComponent().click();

            ld.ReviewComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag4 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            return LessonPlanComponentsValidateTest(flag1, flag2, flag3, flag4);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.TeachComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag1 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.TeachComponent().click();

            ld.ApplyComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag2 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            ld.AssessComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag3 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.AssessComponent().click();

            ld.ReviewComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag4 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            return LessonPlanComponentsValidateTest(flag1, flag2, flag3, flag4);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.TeachComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag1 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.TeachComponent().click();

            ld.ApplyComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag2 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ApplyComponent().click();

            ld.AssessComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag3 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.AssessComponent().click();

            ld.ReviewComponent().click();
            Thread.sleep(5000);
            classname = String.valueOf(ld.TeachComponent().getClass());
            flag4 = ClassCheck(classname, "collapsed");
            Thread.sleep(1000);
            ld.ReviewComponent().click();

            return LessonPlanComponentsValidateTest(flag1, flag2, flag3, flag4);
        }

        return false;
    }

    public boolean LessonPlanOverviewValidateTest(boolean HeaderCheck, boolean ModalBoxCheck) {
        if(HeaderCheck && ModalBoxCheck){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean TeacherLessonPlanOverviewCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.LessonPlanOverviewBtn().click();

            return LessonPlanOverviewValidateTest(ld.LessonPlanOverviewModalHeader().getText().contains("Learning Plan Overview"), ld.ModalDialogBox().isDisplayed());

        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.LessonPlanOverviewBtn().click();

            return LessonPlanOverviewValidateTest(ld.LessonPlanOverviewModalHeader().getText().contains("Learning Plan Overview"), ld.ModalDialogBox().isDisplayed());

        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.LessonPlanOverviewBtn().click();

            return LessonPlanOverviewValidateTest(ld.LessonPlanOverviewModalHeader().getText().contains("Learning Plan Overview"), ld.ModalDialogBox().isDisplayed());


        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.LessonPlanOverviewBtn().click();

            return LessonPlanOverviewValidateTest(ld.LessonPlanOverviewModalHeader().getText().contains("Learning Plan Overview"), ld.ModalDialogBox().isDisplayed());

        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

//          Lesson -1
            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            ld.LessonPlanOverviewBtn().click();

            return LessonPlanOverviewValidateTest(ld.LessonPlanOverviewModalHeader().getText().contains("Learning Plan Overview"), ld.ModalDialogBox().isDisplayed());

        }

        return false;
    }

    public boolean StartEndSessionValidateTest(boolean flag1) {
        System.out.println(flag1);
        if(flag1){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean TeacherStartEndSessionCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);

        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            boolean flag = false;
            ld.EnvironmentalcoursebookGrade1().click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            if(ld.LearningPlanStatus().getText().contains("Completed")){
                // completed
                flag = true;
            }
            else if (driver.getPageSource().contains("Start")) {
                // not yet started
                driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            else {
                // on going
                driver.findElement(By.xpath("//button[contains(text(),'Resume')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            return StartEndSessionValidateTest(flag);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            boolean flag = false;
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            if(ld.LearningPlanStatus().getText().contains("Completed")){
                // completed
                flag = true;
            }
            else if (driver.getPageSource().contains("Start")) {
                // not yet started
                driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            else {
                // on going
                driver.findElement(By.xpath("//button[contains(text(),'Resume')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            return StartEndSessionValidateTest(flag);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics coursebook - Part A
            boolean flag = false;
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(3000);
            element.click();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            if(ld.LearningPlanStatus().getText().contains("Completed")){
                // completed
                flag = true;
            }
            else if (driver.getPageSource().contains("Start")) {
                // not yet started
                driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            else {
                // on going
                driver.findElement(By.xpath("//button[contains(text(),'Resume')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            return StartEndSessionValidateTest(flag);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            boolean flag = false;
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            if(ld.LearningPlanStatus().getText().contains("Completed")){
                // completed
                flag = true;
            }
            else if (driver.getPageSource().contains("Start")) {
                // not yet started
                driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            else {
                // on going
                driver.findElement(By.xpath("//button[contains(text(),'Resume')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            return StartEndSessionValidateTest(flag);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            boolean flag = false;
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();

            ld.FirstLesson().click();
            Thread.sleep(1000);

            ld.FirstLearningPlan().click();

            if(ld.LearningPlanStatus().getText().contains("Completed")){
                // completed
                flag = true;
            }
            else if (driver.getPageSource().contains("Start")) {
                // not yet started
                driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            else {
                // on going
                driver.findElement(By.xpath("//button[contains(text(),'Resume')]")).click();
                flag = driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).isDisplayed();
                driver.findElement(By.xpath("//button[contains(text(),'Pause')]")).click();
            }
            return StartEndSessionValidateTest(flag);
        }

        return false;
    }

    public boolean WorkbookNameValidateTest(String expected_text, String actual_text){
        System.out.println(actual_text+" "+expected_text);
        if(actual_text.contains(expected_text)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean TeacherWorkbookCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ld = new LessonDelivery(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        ThreadSleep5000();
        ld.LessonDeliveryToggle().click();
        ThreadSleep5000();

        // Scrolling page
        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (mob >= 9000000101l && mob <= 9000000104l) { // Environmental Studies Coursebook - Part A
            WebElement element = ld.EnvironmentalcoursebookGrade1();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = ld.WorkbookHeading().getText();
            String workbookName = "Lesson Delivery";

            return WorkbookNameValidateTest(workbookName, text);
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade2();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = ld.WorkbookHeading().getText();
            String workbookName = "Lesson Delivery";

            return WorkbookNameValidateTest(workbookName, text);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade3();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = ld.WorkbookHeading().getText();
            String workbookName = "Lesson Delivery";

            return WorkbookNameValidateTest(workbookName, text);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) { // English Coursebook - Part A
            WebElement element = ld.EnglishCoursebookGrade4();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = ld.WorkbookHeading().getText();
            String workbookName = "Lesson Delivery";

            return WorkbookNameValidateTest(workbookName, text);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) { // Mathematics Coursebook - Part A
            WebElement element = ld.MathematicsCoursebookGrade5();
            js.executeScript("arguments[0].scrollIntoView();", element);
            ThreadSleep5000();
            element.click();
            ThreadSleep5000();
            String text = ld.WorkbookHeading().getText();
            String workbookName = "Lesson Delivery";

            return WorkbookNameValidateTest(workbookName, text);
        }

        return false;
    }

}
