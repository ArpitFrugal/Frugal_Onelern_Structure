package executions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Assessment;
import pageObjects.LoginPage;
import resources.BaseLogin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AssessmentMethods extends BaseLogin {
    public Assessment ass;
    public LoginPage log;
    public WebDriver driver;

    public AssessmentMethods(WebDriver driver2) {
        super(driver2);
    }
    public boolean LandingPageValidateTest(String actual_header, String expected_header){
        if (expected_header.contains(actual_header)) {
            System.out.println("Assessment Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean studentLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ass = new Assessment(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        String actual_header = ass.GetHeader().getText();
        return LandingPageValidateTest(actual_header, "Scheduled Assessments");
    }
    public boolean teacherLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ass = new Assessment(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        String actual_header = ass.GetHeader().getText();
        return LandingPageValidateTest(actual_header, "Assessments");
    }

    // Attempt assessments


    // View report btn

    public boolean ViewReportBtnValidateTest(String actual_text, String expected_text){
        if(actual_text.contains(expected_text)) {
            System.out.println("PASSED");
            return true;
        }
        else
            return false;
    }

    public boolean StudentViewReportBtnCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ass = new Assessment(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        ass.AssessmentsSearch().click();
        ass.AssessmentsSearch().sendKeys("New Assessment");

        ass.FirstAssessmentDisplayedStudent().click();

        String heading = ass.ModuleHeading().getText();
        return ViewReportBtnValidateTest(heading, "Student Report");
    }



    // Search Functionality

    public boolean SearchFunctionalityValidateTest(int actual_result) {
        System.out.println(actual_result);
        if(actual_result == 1) {
            System.out.println("PASSED");
            return true;
        }
        else
            return false;
    }

    public boolean studentSearchAssessmentCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ass = new Assessment(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        ass.AssessmentsSearch().click();
        ass.AssessmentsSearch().sendKeys("Assessment13579");

        int NoOfAssessmentsDisplayed = driver.findElements(By.xpath("//*[contains(@class,'assessment-box')]//h1[text()='Assessment13579']")).size();

        return SearchFunctionalityValidateTest(NoOfAssessmentsDisplayed);
    }

    public boolean teacherSearchAssessmentCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ass = new Assessment(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        ass.MyAssessmentsPage().click();
        Thread.sleep(2000);

        ass.CompletedTabPage().click();

        ass.AssessmentsSearch().click();
        ass.AssessmentsSearch().sendKeys("Assessment13579");

        int NoOfAssessmentsDisplayed = driver.findElements(By.xpath("//*[contains(@class,'assessment-box')]//h1[text()='Assessment13579']")).size();

        return SearchFunctionalityValidateTest(NoOfAssessmentsDisplayed);
    }


    // Create assessment online

    public boolean CreateOnlineAssessmentValidateTest(String displayedAssessmentName, String assessmentName) {
        if(displayedAssessmentName.contains(assessmentName)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean teacherCreateAssessment_Online(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ass = new Assessment(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> QuestionTextBoxes;
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        ass.MyAssessmentsPage().click();
        Thread.sleep(2000);
//        if(ass.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(10000);
        ass.CreateNew().click();
        Thread.sleep(2000);

        String AssessmentName = "New Assessment";
        ass.NameOfAssessmentInput().click();
        ass.NameOfAssessmentInput().sendKeys(AssessmentName);

        Thread.sleep(2000);

        for (WebElement webElement:ass.AssessmentDetails()){
            webElement.click();
            webElement.sendKeys(Keys.ARROW_DOWN);
            webElement.sendKeys(Keys.ENTER);
        }

        ass.AssessmentFormat().click();
        Thread.sleep(1000);
        ass.AssessmentFormatOnline().click();
        Thread.sleep(1000);

        ass.SubmitBtn().click();

        ass.SectionBtn().click();

        ass.SectionName().click();
        ass.SectionName().sendKeys("Section");

        ass.SectionInstructions().click();
        ass.SectionInstructions().sendKeys("Instructions");

        ass.SubmitBtn().click();
        Thread.sleep(2000);

        // T/F Question

        ass.QuestionBtn().click();
        ass.TrueFalseOption().click();
//        if(ass.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(2000);

        ass.TrueOption().click();

        QuestionTextBoxes = ass.QuestionInputBoxes();
        int cnt=0;
        for(WebElement webElement: QuestionTextBoxes){
            if(cnt == 0){
                webElement.click();
                webElement.sendKeys("Question");
            } else if (cnt == 1) {
                webElement.click();
                webElement.sendKeys("Instructions");
            }else if (cnt == 2) {
                WebElement Element = QuestionTextBoxes.get(3);
                js.executeScript("arguments[0].scrollIntoView();", Element);
                webElement.click();
                webElement.sendKeys("Hints");
            }else if (cnt == 3) {
                webElement.click();
                webElement.sendKeys("Solution");
            }
            cnt++;
        }


        for(WebElement webElement:ass.QuestionsMetadata()){
            if(webElement.isEnabled()){
                webElement.click();
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
                Thread.sleep(1500);
            }
        }
        ass.MarksInputBox().click();
        Thread.sleep(1000);
        ass.MarksInputBox().sendKeys("01");
        Thread.sleep(2000);


        ass.QuestionsMetadata().get(4).click();
        ass.QuestionsMetadata().get(4).sendKeys(Keys.ARROW_DOWN);
        ass.QuestionsMetadata().get(4).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
//
        Actions action = new Actions(driver);
        for(int i=0;i<5;i++){
            action.sendKeys(Keys.TAB).perform();
            Thread.sleep(1000);
        }

        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);


        // - -------------------------------------

//        ass.QuestionBtn().click();
//        ass.MCQOption().click();
////        if(ass.ModalOverlay().isDisplayed())
////            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
//        Thread.sleep(5000);
//
//        driver.findElement(By.xpath("//div[contains(@class,'check')]")).click();
//        Thread.sleep(1000);
//        QuestionTextBoxes = ass.QuestionInputBoxes();
//        cnt=0;
//        for(WebElement webElement: QuestionTextBoxes){
//            if(cnt == 0){
//                webElement.click();
//                webElement.sendKeys("Question");
//            } else if (cnt == 1) {
//                webElement.click();
//                webElement.sendKeys("Option1");
//            }else if (cnt == 2) {
//                WebElement Element = QuestionTextBoxes.get(4);
//                js.executeScript("arguments[0].scrollIntoView();", Element);
//                webElement.click();
//                webElement.sendKeys("Option2");
//            }else if (cnt == 3) {
//                webElement.click();
//                webElement.sendKeys("Option3");
//            }else if (cnt == 4) {
//                webElement.click();
//                webElement.sendKeys("Option4");
//            }else if (cnt == 5) {
//                WebElement Element = QuestionTextBoxes.get(QuestionTextBoxes.size() - 1);
//                js.executeScript("arguments[0].scrollIntoView();", Element);
//                webElement.click();
//                webElement.sendKeys("Instructions");
//            }else if (cnt == 6) {
//                webElement.click();
//                webElement.sendKeys("Hints");
//            }else if (cnt == 7) {
//                webElement.click();
//                webElement.sendKeys("Solution");
//            }
//            cnt++;
//        }
//
//        for(WebElement webElement:ass.QuestionsMetadata()){
//            if(webElement.isEnabled()){
//                webElement.click();
//                webElement.sendKeys(Keys.ARROW_DOWN);
//                webElement.sendKeys(Keys.ENTER);
//                Thread.sleep(1500);
//            }
//        }
//
//        ass.MarksInputBox().click();
//        Thread.sleep(1000);
//        ass.MarksInputBox().sendKeys("01");
//        Thread.sleep(2000);
//
//
//        ass.QuestionsMetadata().get(4).click();
//        ass.QuestionsMetadata().get(4).sendKeys(Keys.ARROW_DOWN);
//        ass.QuestionsMetadata().get(4).sendKeys(Keys.ENTER);
//        Thread.sleep(1000);
//
////        Actions action = new Actions(driver);
//        for(int i=0;i<5;i++){
//            action.sendKeys(Keys.TAB).perform();
//            Thread.sleep(1000);
//        }
//
//        action.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(2000);
//
//
//        // --------------------------------------
//
//        ass.QuestionBtn().click();
//        ass.FillBlanksOption().click();
////        if(ass.ModalOverlay().isDisplayed())
////            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
//        Thread.sleep(2000);
//        QuestionTextBoxes = ass.QuestionInputBoxes();
//        cnt=0;
//        for(WebElement webElement: QuestionTextBoxes){
//            if(cnt == 0){
//                webElement.click();
//                webElement.sendKeys("Question");
//            } else if (cnt == 1) {
//                webElement.click();
//                webElement.sendKeys("Instructions");
//            }else if (cnt == 2) {
//                WebElement Element = QuestionTextBoxes.get(3);
//                js.executeScript("arguments[0].scrollIntoView();", Element);
//                webElement.click();
//                webElement.sendKeys("Hints");
//            }else if (cnt == 3) {
//                webElement.click();
//                webElement.sendKeys("Solution");
//            }
//            cnt++;
//        }
//
//        ass.FBCorrectAnswer().click();
//        ass.FBCorrectAnswer().sendKeys("Answer");
//
//
//
//        for(WebElement webElement:ass.QuestionsMetadata()){
//            if(webElement.isEnabled()){
//                webElement.click();
//                webElement.sendKeys(Keys.ARROW_DOWN);
//                webElement.sendKeys(Keys.ENTER);
//                Thread.sleep(1500);
//            }
//        }
//        ass.MarksInputBox().click();
//        Thread.sleep(1000);
//        ass.MarksInputBox().sendKeys("01");
//        Thread.sleep(2000);
//
//
//        ass.QuestionsMetadata().get(4).click();
//        ass.QuestionsMetadata().get(4).sendKeys(Keys.ARROW_DOWN);
//        ass.QuestionsMetadata().get(4).sendKeys(Keys.ENTER);
//        Thread.sleep(1000);
//
////        Actions action = new Actions(driver);
//        for(int i=0;i<5;i++){
//            action.sendKeys(Keys.TAB).perform();
//            Thread.sleep(1000);
//        }
//
//        action.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(2000);
//
//        // ----------------------------------------------
//
//        ass.QuestionBtn().click();
//        ass.MRQOption().click();
////        if(ass.ModalOverlay().isDisplayed())
////            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
//        Thread.sleep(2000);
//
//        driver.findElement(By.xpath("//div[contains(@class,'check')]")).click();
//        QuestionTextBoxes = ass.QuestionInputBoxes();
//        cnt=0;
//        for(WebElement webElement: QuestionTextBoxes){
//            if(cnt == 0){
//                webElement.click();
//                webElement.sendKeys("Question");
//            } else if (cnt == 1) {
//                webElement.click();
//                webElement.sendKeys("Option1");
//            }else if (cnt == 2) {
//                WebElement Element = QuestionTextBoxes.get(4);
//                js.executeScript("arguments[0].scrollIntoView();", Element);
//                webElement.click();
//                webElement.sendKeys("Option2");
//            }else if (cnt == 3) {
//                webElement.click();
//                webElement.sendKeys("Option3");
//            }else if (cnt == 4) {
//                webElement.click();
//                webElement.sendKeys("Option4");
//            }else if (cnt == 5) {
//                WebElement Element = QuestionTextBoxes.get(QuestionTextBoxes.size() - 1);
//                js.executeScript("arguments[0].scrollIntoView();", Element);
//                webElement.click();
//                webElement.sendKeys("Instructions");
//            }else if (cnt == 6) {
//                webElement.click();
//                webElement.sendKeys("Hints");
//            }else if (cnt == 7) {
//                webElement.click();
//                webElement.sendKeys("Solution");
//            }
//            cnt++;
//        }
//
//
//        for(WebElement webElement:ass.QuestionsMetadata()){
//            if(webElement.isEnabled()){
//                webElement.click();
//                webElement.sendKeys(Keys.ARROW_DOWN);
//                webElement.sendKeys(Keys.ENTER);
//                Thread.sleep(1000);
//            }
//        }
//        ass.MarksInputBox().click();
//        Thread.sleep(1000);
//        ass.MarksInputBox().sendKeys("01");
//        Thread.sleep(2000);
//
//
//        ass.QuestionsMetadata().get(4).click();
//        ass.QuestionsMetadata().get(4).sendKeys(Keys.ARROW_DOWN);
//        ass.QuestionsMetadata().get(4).sendKeys(Keys.ENTER);
//        Thread.sleep(1000);
//
////        Actions action = new Actions(driver);
//        for(int i=0;i<5;i++){
//            action.sendKeys(Keys.TAB).perform();
//            Thread.sleep(1000);
//        }
//
//        action.sendKeys(Keys.ENTER).perform();
//        Thread.sleep(2000);


        // --------------------------------------


        ass.PassMarks().click();
        Thread.sleep(2000);
        ass.PassMarks().sendKeys("1");
        Thread.sleep(2000);

        ass.AssignStudentsBtn().click();
//        if(ass.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(1000);
        ass.SelectStudentsBtn().click();

        ass.SelectAllStudents().click();
        Thread.sleep(2000);

        ass.AddStudents().click();
        Thread.sleep(2000);
        ass.ScheduleBtn().click();
        Thread.sleep(2000);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
        String dateString = dateFormat.format(new Date(Calendar.getInstance().getTimeInMillis() + 2*60*1000));
        String currhour = dateString.split("\\.")[0];
        String currmin  = dateString.split("\\.")[1].split(" ")[0];
        String ampm = dateString.split("\\.")[1].split(" ")[1];


        ass.DateInput().click();
        ass.DateInput().sendKeys(currdate);
        ass.DateInput().sendKeys(currmonth);
        ass.DateInput().sendKeys(curryear);

        ass.TimeInput().click();
        ass.TimeInput().sendKeys(currhour);
        ass.TimeInput().sendKeys(currmin);
        ass.TimeInput().sendKeys(ampm);

        ass.DurationInput().click();
        ass.DurationInput().sendKeys(Keys.ARROW_DOWN);

        ass.ShowScoresAfter().click();
        ass.ShowScoresAfter().sendKeys(Keys.ARROW_DOWN);

        ass.passwordInputTeacher().click();
        ass.passwordInputTeacher().sendKeys("password");

        driver.findElement(By.xpath("//h1")).click();
//        js.executeScript("arguments[0].scrollIntoView();", ass.instructionsInput());
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[contains(@class,'hint-txt')]")));
        Thread.sleep(2000);
        ass.instructionsInput().click();
        ass.instructionsInput().sendKeys("Instructions");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//h1")).click();
        Thread.sleep(1000);
//        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[contains(@class,'hint-txt')]")));
//        Thread.sleep(1000);
        ass.HintShowOption().click();
        Thread.sleep(1000);
        ass.PublishAssessmentBtn().click();
        Thread.sleep(2000);
        String DisplayedAssessmentName = ass.FirstAssessmentDisplayedTeacher().getText();

        return CreateOnlineAssessmentValidateTest(DisplayedAssessmentName, AssessmentName);
    }


    // Create assessment pen paper
    public boolean CreatePenPaperAssessmentValidateTest(WebElement questionPaperPreview) {
        if(questionPaperPreview.isDisplayed()) {
            System.out.println("PASSED");
            return true;
        }
        else
            return false;
    }
    public boolean teacherCreateAssessment_PenPaper(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ass = new Assessment(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        ass.MyAssessmentsPage().click();
        Thread.sleep(2000);
//        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(1000);
        ass.CreateNew().click();
        Thread.sleep(2000);

        String AssessmentName = "PP Assessment";
        ass.NameOfAssessmentInput().click();
        ass.NameOfAssessmentInput().sendKeys(AssessmentName);

        Thread.sleep(2000);

        for (WebElement webElement:ass.AssessmentDetails()){
            webElement.click();
            webElement.sendKeys(Keys.ARROW_DOWN);
            webElement.sendKeys(Keys.ENTER);
        }

        ass.AssessmentFormat().click();
        Thread.sleep(1000);
        ass.AssessmentFormatPenPaper().click();
        Thread.sleep(1000);

        ass.SubmitBtn().click();
//        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(1000);
        ass.SectionBtn().click();

        ass.SectionName().click();
        ass.SectionName().sendKeys("Section");

        ass.SectionInstructions().click();
        ass.SectionInstructions().sendKeys("Instructions");

        ass.SubmitBtn().click();
        Thread.sleep(2000);
        ass.QuestionBtn().click();

        ass.ShortAnswerOption().click();

//        if(ass.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(2000);

//        driver.findElement(By.xpath("//button[contains(@class, 'toolbar-btn')]")).click();
//        Thread.sleep(1000);
        List<WebElement> QuestionTextBoxes = ass.QuestionInputBoxes();
        int cnt=0;
        for(WebElement webElement: QuestionTextBoxes){
            if(cnt == 0){
                webElement.click();
                webElement.sendKeys("Question");
            } else if (cnt == 1) {
                webElement.click();
                webElement.sendKeys("Instructions");
            }else if (cnt == 2) {
                webElement.click();
                webElement.sendKeys("Hints");
            }else if (cnt == 3) {
                js.executeScript("arguments[0].scrollIntoView();", webElement);
                webElement.click();
                webElement.sendKeys("Solution");
            }
            cnt++;
        }

        for(WebElement webElement:ass.QuestionsMetadata()){
            if(webElement.isEnabled()){
                webElement.click();
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
                Thread.sleep(1000);
            }
        }
        ass.QuestionsMetadata().get(4).click();
        ass.QuestionsMetadata().get(4).sendKeys(Keys.ARROW_DOWN);
        ass.QuestionsMetadata().get(4).sendKeys(Keys.ENTER);


        ass.MarksInputBox().click();
        Thread.sleep(1000);
        ass.MarksInputBox().sendKeys("5");
        Thread.sleep(2000);

        ass.AddThisQuestionBtn().click();
        Thread.sleep(2000);
        ass.PassMarks().click();
        Thread.sleep(2000);
        ass.PassMarks().sendKeys("2");
        Thread.sleep(2000);

        ass.AssignStudentsBtn().click();
//        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(1000);
        ass.SelectStudentsBtn().click();
        Thread.sleep(1000);
        ass.SelectAllStudents().click();
        Thread.sleep(2000);

        ass.AddStudents().click();
        Thread.sleep(2000);
        ass.ScheduleBtn().click();
        Thread.sleep(2000);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
        String dateString = dateFormat.format(new Date(Calendar.getInstance().getTimeInMillis() + 60*1000));
        String currhour = dateString.split("\\.")[0];
        String currmin  = dateString.split("\\.")[1].split(" ")[0];
        String ampm = dateString.split("\\.")[1].split(" ")[1];


        ass.DateInput().click();
        ass.DateInput().sendKeys(currdate);
        ass.DateInput().sendKeys(currmonth);
        ass.DateInput().sendKeys(curryear);

        ass.TimeInput().click();
        ass.TimeInput().sendKeys(currhour);
        ass.TimeInput().sendKeys(currmin);
        ass.TimeInput().sendKeys(ampm);

        ass.DurationInput().click();
        ass.DurationInput().sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        ass.instructionsInput().click();
        ass.instructionsInput().sendKeys("Instructions");
        Thread.sleep(1000);

        ass.PublishAssessmentBtn().click();
        Thread.sleep(1000);
//        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));

        return CreatePenPaperAssessmentValidateTest(ass.questionPaperPreview());
    }


    // Ongoing Assessments

    public boolean OngoingAssessmentsValidateTest(int size) {
        if(size > 0) {
            System.out.println("PASSED");
            return true;
        }
        else
            return false;
    }

    public boolean teacherOngoingAssessmentsCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ass = new Assessment(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ass.MyAssessmentsPage().click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));

        ass.OngoingTabPage().click();

        return OngoingAssessmentsValidateTest(ass.StatusTagOnAssessment().size());
    }

    // Drafts Check

    public boolean DraftsCheckValidateTest(boolean flag1, boolean flag2, boolean flag3) {
        System.out.println(flag1+" "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3) {
            System.out.println("PASSED");
            return true;
        }
        else
            return false;
    }
    public boolean TextCheck(String pageSource) {
        return pageSource.contains("Question Paper");
    }

    public boolean ValueCompare(int expected_count, int actual_count) {
        System.out.println(expected_count+" "+actual_count);
        return expected_count == actual_count;
    }

    public boolean teacherDraftAssessmentsCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ass = new Assessment(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ass.MyAssessmentsPage().click();
        Thread.sleep(2000);


//        if(ass.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(2000);

        boolean flag1, flag2, flag3;

        ass.DraftsTabPage().click();

        int no_of_assessments =ass.AssessmentCards().size();
        System.out.println(no_of_assessments);
        if(no_of_assessments > 0){
            flag1= ValueCompare(no_of_assessments, ass.DraftPublishBtn().size());

            ass.OutsideEditBtnDrafts().click();
            Thread.sleep(1000);
            flag2 = TextCheck(driver.getPageSource());
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[contains(@class,'back-btn')]")).click();
            Thread.sleep(5000);
            ass.DraftsTabPage().click();
            Thread.sleep(1000);
            ass.deleteDraft().click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[contains(@class,'modal-footer')]//button[2]")).click();
//            ass.DraftsTabPage().click();
            Thread.sleep(2000);
            List<WebElement> assessmentcards = ass.AssessmentCards();
            flag3 = ValueCompare(no_of_assessments -1, assessmentcards.size());

            return DraftsCheckValidateTest(flag1, flag2, flag3);
        }
        else {
            String CurrUrl = driver.getCurrentUrl();
            boolean flag = CurrUrl.contains("drafts");
            if(flag)
                return DraftsCheckValidateTest(flag, flag, flag);
            else
                return DraftsCheckValidateTest(false, false, false);
        }
    }

    // Completed assessments validate test
    public boolean CompletedAssessmentsValidateTest(boolean flag1, boolean flag2) {
        if(flag1 && flag2) {
            System.out.println("PASSED");
            return true;
        }
        else
            return false;
    }

    public boolean teacherCompletedAssessmentsCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ass = new Assessment(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ass.AssessmentToggle().click();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ass.MyAssessmentsPage().click();
        Thread.sleep(2000);
//        wait.until(ExpectedConditions.invisibilityOf(ass.ModalOverlay()));
        Thread.sleep(2000);
        ass.CompletedTabPage().click();

        boolean flag = true;
        List<WebElement> assessmentsstatus = ass.StatusTagOnAssessment();
        for(WebElement webElement:assessmentsstatus){
            if(!Objects.equals(webElement.getText(), "SUBMITTED") && !Objects.equals(webElement.getText(), "COMPLETED")){
                flag = false;
                break;
            }
        }

        return CompletedAssessmentsValidateTest(ass.StatusTagOnAssessment().size() > 0, flag);
    }

}
