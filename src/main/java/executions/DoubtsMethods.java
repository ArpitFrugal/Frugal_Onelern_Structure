package executions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.Doubts;
import pageObjects.LoginPage;
import resources.BaseLogin;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class DoubtsMethods extends BaseLogin {
    public Doubts dou;
    public LoginPage log;
    public WebDriver driver;
    public DoubtsMethods(WebDriver driver2) {
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

    // Landing page check
    public boolean LandingPageValidateTest(String actual_header){
        if (actual_header.contains("Doubts")) {
            System.out.println("Doubts Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean studentLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.dou = new Doubts(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        wait.until(ExpectedConditions.elementToBeClickable(dou.DoubtsToggle()));
        dou.DoubtsToggle().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.GetHeader()));

        String actual_header = dou.GetHeader().getText();
        return LandingPageValidateTest(actual_header);
    }
    public boolean teacherLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.dou = new Doubts(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        wait.until(ExpectedConditions.elementToBeClickable(dou.DoubtsToggle()));
        dou.DoubtsToggle().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.GetHeader()));

        String actual_header = dou.GetHeader().getText();
        return LandingPageValidateTest(actual_header);
    }

    // ask a doubt button
    public boolean AskButtonValidateTest(String actual_header){
        if (actual_header.contains("Ask a Doubt")) {
            System.out.println("Doubts Module is active");
            return true;
        }
        else {
            return false;
        }
    }
    public boolean studentAskADoubt(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.dou = new Doubts(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        wait.until(ExpectedConditions.elementToBeClickable(dou.DoubtsToggle()));
        dou.DoubtsToggle().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.AskDoubtBtn()));

        dou.AskDoubtBtn().click();

        String actual_header = dou.AskDoubtHeader().getText();
        return AskButtonValidateTest(actual_header);
    }

    // view count check

    public boolean ViewCountValidateTest(int actualresult, int expectedresult){
        System.out.println(actualresult+" "+expectedresult);
        if(actualresult == expectedresult){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }
    public boolean studentViewCountCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.dou = new Doubts(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        wait.until(ExpectedConditions.elementToBeClickable(dou.DoubtsToggle()));
        dou.DoubtsToggle().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.DoubtsCards().get(0)));
        int numberOfDoubts = dou.DoubtsCards().size();
        if(numberOfDoubts > 0){
            int prevCount = Integer.parseInt(dou.ViewCount().getText());
            dou.FirstDoubt().click();
            wait.until(ExpectedConditions.elementToBeClickable(dou.ViewCount()));
            Thread.sleep(2000);
            int currCount = Integer.parseInt(dou.ViewCount().getText());

            return ViewCountValidateTest(currCount, prevCount+1);
        }
        else{
            return ViewCountValidateTest(-1, -1);
        }
    }

    public boolean teacherViewCountCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.dou = new Doubts(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        wait.until(ExpectedConditions.elementToBeClickable(dou.DoubtsToggle()));
        dou.DoubtsToggle().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.DoubtsCards().get(0)));
        int numberOfDoubts = dou.DoubtsCards().size();
        if(numberOfDoubts > 0){
            int prevCount = Integer.parseInt(dou.ViewCount().getText());
            dou.FirstDoubt().click();
            wait.until(ExpectedConditions.elementToBeClickable(dou.ViewCount()));
            Thread.sleep(2000);
            int currCount = Integer.parseInt(dou.ViewCount().getText());

            return ViewCountValidateTest(currCount, prevCount+1);
        }
        else{
            return ViewCountValidateTest(-1, -1);
        }
    }

    // new doubt check
    Map<String, String> doubtContentMap = new HashMap<String, String>() {{
        put("Grade 1", "New Doubt 1");
        put("Grade 2", "New Doubt 2");
        put("Grade 3", "New Doubt 3");
        put("Grade 4", "New Doubt 4");
        put("Grade 5", "New Doubt 5");
    }};
    public boolean StudentAskDoubtValidateTest(String createdSubjectDetails, String selectedSubject, String selectedLesson, String createdQuestionDetails, String doubtContent) {
        selectedSubject = selectedSubject.split("-")[0].strip();
        System.out.println(createdSubjectDetails+"\n"+selectedSubject+"\n"+selectedLesson+"\n"+createdQuestionDetails+"\n"+doubtContent);
        if(createdSubjectDetails.contains(selectedSubject) && createdSubjectDetails.contains(selectedLesson) && createdQuestionDetails.contains(doubtContent)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean studentAskNewDoubt(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.dou = new Doubts(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        wait.until(ExpectedConditions.elementToBeClickable(dou.DoubtsToggle()));
        dou.DoubtsToggle().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.AskDoubtBtn()));

        dou.AskDoubtBtn().click();


        String selectedSubject = null, selectedLesson = null;
        List<WebElement> doubtoptions = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div/div[1]//select"));

        for(WebElement webElement:doubtoptions){
            webElement.click();
            Thread.sleep(2000);
            webElement.sendKeys(Keys.ARROW_DOWN);
            webElement.sendKeys(Keys.ENTER);
        }
        int i=0;
        for(WebElement webElement:doubtoptions){
            Select select = new Select(webElement);
            if(i==0){
                selectedSubject = select.getFirstSelectedOption().getText();
            }
            else{
                selectedLesson = select.getFirstSelectedOption().getText();
            }
            i++;
            Thread.sleep(3000);
        }

        if (mob >= 9000000001l && mob <= 9000000020l) {// English
            dou.QuestionTextBox().click();
            dou.QuestionTextBox().sendKeys(doubtContentMap.get("Grade 1"));
            dou.SubmitBtn().click();

            wait.until(ExpectedConditions.elementToBeClickable(dou.CreatedSubjectDetails()));
            Thread.sleep(5000);
            // verify created doubt content
            String CreatedSubjectDetails = dou.CreatedSubjectDetails().getText();
            String CreatedQuestionDetails = dou.CreatedQuestionDetails().getText();
            doubtContentMap.put("SubjectGrade1", CreatedSubjectDetails);
            return StudentAskDoubtValidateTest(CreatedSubjectDetails, selectedSubject, selectedLesson, CreatedQuestionDetails, doubtContentMap.get("Grade 1"));
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) {// English
            dou.QuestionTextBox().click();
            dou.QuestionTextBox().sendKeys(doubtContentMap.get("Grade 2"));
            dou.SubmitBtn().click();

            wait.until(ExpectedConditions.elementToBeClickable(dou.CreatedSubjectDetails()));
            // verify created doubt content
            String CreatedSubjectDetails = dou.CreatedSubjectDetails().getText();
            String CreatedQuestionDetails = dou.CreatedQuestionDetails().getText();
            doubtContentMap.put("SubjectGrade2", CreatedSubjectDetails);
            return StudentAskDoubtValidateTest(CreatedSubjectDetails, selectedSubject, selectedLesson, CreatedQuestionDetails, doubtContentMap.get("Grade 2"));

        }

        else if (mob >= 9000000041l && mob <= 9000000060l) {// English
            dou.QuestionTextBox().click();
            dou.QuestionTextBox().sendKeys(doubtContentMap.get("Grade 3"));
            dou.SubmitBtn().click();

            wait.until(ExpectedConditions.elementToBeClickable(dou.CreatedSubjectDetails()));
            // verify created doubt content
            String CreatedSubjectDetails = dou.CreatedSubjectDetails().getText();
            String CreatedQuestionDetails = dou.CreatedQuestionDetails().getText();
            doubtContentMap.put("SubjectGrade3", CreatedSubjectDetails);
            return StudentAskDoubtValidateTest(CreatedSubjectDetails, selectedSubject, selectedLesson, CreatedQuestionDetails, doubtContentMap.get("Grade 3"));
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) {
            dou.QuestionTextBox().click();
            dou.QuestionTextBox().sendKeys(doubtContentMap.get("Grade 4"));
            dou.SubmitBtn().click();

            wait.until(ExpectedConditions.elementToBeClickable(dou.CreatedSubjectDetails()));
            // verify created doubt content
            String CreatedSubjectDetails = dou.CreatedSubjectDetails().getText();
            String CreatedQuestionDetails = dou.CreatedQuestionDetails().getText();
            doubtContentMap.put("SubjectGrade4", CreatedSubjectDetails);
            return StudentAskDoubtValidateTest(CreatedSubjectDetails, selectedSubject, selectedLesson, CreatedQuestionDetails, doubtContentMap.get("Grade 4"));
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) {
            dou.QuestionTextBox().click();
            dou.QuestionTextBox().sendKeys(doubtContentMap.get("Grade 5"));
            dou.SubmitBtn().click();

            wait.until(ExpectedConditions.elementToBeClickable(dou.CreatedSubjectDetails()));
            // verify created doubt content
            String CreatedSubjectDetails = dou.CreatedSubjectDetails().getText();
            String CreatedQuestionDetails = dou.CreatedQuestionDetails().getText();
            doubtContentMap.put("SubjectGrade5", CreatedSubjectDetails);
            return StudentAskDoubtValidateTest(CreatedSubjectDetails, selectedSubject, selectedLesson, CreatedQuestionDetails, doubtContentMap.get("Grade 5"));
        }
        return false;


    }

    public boolean TeacherViewDoubtValidateTest(String subjectDetails, String SubjectfromStudent, String contentDetails, String contentfromStudent) {

        if (subjectDetails.contains(SubjectfromStudent) && contentDetails.contains(contentfromStudent)){
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherViewNewDoubt(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.dou = new Doubts(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        wait.until(ExpectedConditions.elementToBeClickable(dou.DoubtsToggle()));
        dou.DoubtsToggle().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.CreatedSubjectDetails()));

        String subjectDetails = dou.CreatedSubjectDetails().getText();
        String contentDetails = dou.CreatedQuestionDetails().getText();
        if (mob >= 9000000101l && mob <= 9000000104l) {
            return TeacherViewDoubtValidateTest(subjectDetails, doubtContentMap.get("SubjectGrade1"), contentDetails, doubtContentMap.get("Grade 1"));
        }

        else if (mob >= 9000000105l && mob <= 9000000108l) {
            return TeacherViewDoubtValidateTest(subjectDetails, doubtContentMap.get("SubjectGrade2"), contentDetails, doubtContentMap.get("Grade 2"));
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {
            return TeacherViewDoubtValidateTest(subjectDetails, doubtContentMap.get("SubjectGrade3"), contentDetails, doubtContentMap.get("Grade 3"));
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            return TeacherViewDoubtValidateTest(subjectDetails, doubtContentMap.get("SubjectGrade4"), contentDetails, doubtContentMap.get("Grade 4"));
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            return TeacherViewDoubtValidateTest(subjectDetails, doubtContentMap.get("SubjectGrade5"), contentDetails, doubtContentMap.get("Grade 5"));
        }
        return false;
    }

    // Multimedia check
    public boolean MultimediaUploadValidateTest(boolean flag1, boolean flag2){
        if (flag1) {
            System.out.println("Image is inserted successfully.");
        }
        else {
            System.out.println("Image is not inserted.");
        }
        if (flag2) {
            System.out.println("Video is inserted successfully.");
        }
        else {
            System.out.println("Video is not inserted.");
        }

        if (flag1 && flag2) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean studentUploadMultimedia(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.dou = new Doubts(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        wait.until(ExpectedConditions.elementToBeClickable(dou.DoubtsToggle()));
        dou.DoubtsToggle().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.AskDoubtBtn()));

        dou.AskDoubtBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.InsertImageOption()));
Thread.sleep(2000);
        dou.InsertImageOption().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.ImageByUrl()));

        dou.ImageByUrl().click();

        dou.imageUrlInput().click();
        dou.imageUrlInput().sendKeys("https://media.istockphoto.com/photos/sample-red-grunge-round-stamp-on-white-background-picture-id491520707");
        wait.until(ExpectedConditions.elementToBeClickable(dou.InsertBtn()));

        dou.InsertBtn().click();
        boolean flag1 = dou.insertedImage().isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(dou.UndoOption()));
Thread.sleep(2000);
        dou.UndoOption().click();
        dou.RedoOption().click();

        dou.InsertVideoOption().click();

        dou.VideoUrlInput().click();
        dou.VideoUrlInput().sendKeys("https://youtu.be/rUWxSEwctFU");
        wait.until(ExpectedConditions.elementToBeClickable(dou.InsertBtn()));
        dou.InsertBtn().click();
        boolean flag2 = dou.insertedVideo().isDisplayed();

        return MultimediaUploadValidateTest(flag1, flag2);
    }


    // Filter functionality
    public boolean textCheck(String actual_text, String expected_text){
        if (actual_text.contains(expected_text)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean FilterFunctionalityValidateTest(boolean flag1, boolean flag2, boolean flag3) {
        System.out.println(flag1+" "+flag2+" " +flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean studentFilterFunctionalityCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        boolean flag1 = false, flag2 = false, flag3 = false;
        int no_of_doubts;
        String selectedFilterSubject;

        this.dou = new Doubts(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        wait.until(ExpectedConditions.elementToBeClickable(dou.DoubtsToggle()));
        dou.DoubtsToggle().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.FilterSubjectFirstSubject_Student()));

        dou.FilterSubjectFirstSubject_Student().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.FilterSubjectFirstSubject_Student()));
Thread.sleep(2000);
        selectedFilterSubject = dou.FilterSubjectFirstSubject_Student().getText();
        no_of_doubts = dou.displayedDoubtSubjectDetails().size();
        for(int i=1; i<=no_of_doubts;i++){
            WebElement webElement = driver.findElement(By.xpath("//div[contains(@class, 'doubts-card')]["+i+"]//div[contains(@class, 'subject-details')]"));
            flag1 = textCheck(webElement.getText(), selectedFilterSubject);
            if(!flag1){
                break;
            }
        }
        dou.FilterSubjectFirstSubject_Student().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.FilterSubjectSecondSubject_Student()));

        dou.FilterSubjectSecondSubject_Student().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.FilterSubjectSecondSubject_Student()));
        Thread.sleep(2000);
        selectedFilterSubject = dou.FilterSubjectSecondSubject_Student().getText();
        no_of_doubts = dou.displayedDoubtSubjectDetails().size();
        for(int i=1; i<=no_of_doubts;i++){
            WebElement webElement = driver.findElement(By.xpath("//div[contains(@class, 'doubts-card')]["+i+"]//div[contains(@class, 'subject-details')]"));
            flag2 = textCheck(webElement.getText(), selectedFilterSubject);
            if(!flag2){
                break;
            }
        }
        dou.FilterSubjectSecondSubject_Student().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.FilterSubjectThirdSubject_Student()));

        dou.FilterSubjectThirdSubject_Student().click();
        wait.until(ExpectedConditions.elementToBeClickable(dou.FilterSubjectThirdSubject_Student()));
        Thread.sleep(2000);
        selectedFilterSubject = dou.FilterSubjectThirdSubject_Student().getText();
        no_of_doubts = dou.displayedDoubtSubjectDetails().size();
        for(int i=1; i<=no_of_doubts;i++){
            WebElement webElement = driver.findElement(By.xpath("//div[contains(@class, 'doubts-card')]["+i+"]//div[contains(@class, 'subject-details')]"));
            flag3 = textCheck(webElement.getText(), selectedFilterSubject);
            if(!flag3){
                break;
            }
        }
        dou.FilterSubjectThirdSubject_Student().click();

        return FilterFunctionalityValidateTest(flag1, flag2, flag3);
    }

    public boolean teacherFilterFunctionalityCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1 = false, flag2 = false, flag3 = false;
        int no_of_doubts;
        String selectedFilterSubject;

        this.dou = new Doubts(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);

        dou.FilterSubjectFirstSubject_Teacher().click();
        dou.FilterSubjectSecondSubject_Teacher().click();
        dou.FilterSubjectThirdSubject_Teacher().click();

        dou.FilterSubjectFirstSubject_Teacher().click();
        Thread.sleep(5000);

        selectedFilterSubject = dou.FilterSubjectFirstSubject_Teacher().getText();
        no_of_doubts = dou.displayedDoubtSubjectDetails().size();
        for(int i=1; i<=no_of_doubts;i++){
            WebElement webElement = driver.findElement(By.xpath("//div[contains(@class, 'doubts-card')]["+i+"]//div[contains(@class, 'subject-details')]"));
            flag1 = textCheck(webElement.getText(), selectedFilterSubject);
            if(!flag1){
                break;
            }
        }

        dou.FilterSubjectSecondSubject_Teacher().click();
        Thread.sleep(2000);

        dou.FilterSubjectFirstSubject_Teacher().click();
        Thread.sleep(2000);


        dou.FilterSubjectSecondSubject_Teacher().click();
        Thread.sleep(5000);

        selectedFilterSubject = dou.FilterSubjectSecondSubject_Teacher().getText();
        no_of_doubts = dou.displayedDoubtSubjectDetails().size();
        for(int i=1; i<=no_of_doubts;i++){
            WebElement webElement = driver.findElement(By.xpath("//div[contains(@class, 'doubts-card')]["+i+"]//div[contains(@class, 'subject-details')]"));
            flag2 = textCheck(webElement.getText(), selectedFilterSubject);
            if(!flag2){
                break;
            }
        }

        dou.FilterSubjectThirdSubject_Teacher().click();
        Thread.sleep(2000);

        dou.FilterSubjectSecondSubject_Teacher().click();
        Thread.sleep(2000);


        dou.FilterSubjectThirdSubject_Teacher().click();
        Thread.sleep(5000);

        selectedFilterSubject = dou.FilterSubjectThirdSubject_Teacher().getText();
        no_of_doubts = dou.displayedDoubtSubjectDetails().size();
        for(int i=1; i<=no_of_doubts;i++){
            WebElement webElement = driver.findElement(By.xpath("//div[contains(@class, 'doubts-card')]["+i+"]//div[contains(@class, 'subject-details')]"));
            flag3 = textCheck(webElement.getText(), selectedFilterSubject);
            if(!flag3){
                break;
            }
        }

        dou.FilterSubjectThirdSubject_Teacher().click();
        Thread.sleep(2000);

        return FilterFunctionalityValidateTest(flag1, flag2, flag3);
    }


    // doubt reply check
    public boolean DoubtReplyValidateTest(boolean flag) {
        if(flag){
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean CompareText(String actual_result, String expected_result) {
        return Objects.equals(actual_result, expected_result);
    }

    public boolean CompareVal(int actual_result, int expected_result) {
        return actual_result == expected_result;
    }

    public boolean DoubtreplyCheck(WebDriver driver) throws IOException, InterruptedException {
        this.dou = new Doubts(driver);
        boolean flag1, flag2, flag3, flag4, flag5, flag6;
        String Student_mobile_number = "9000000001";
        String Teacher_mobile_number = "9000000101";
        String password = "123456";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement logoutelement;

        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", Student_mobile_number, password);
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);

        // ask doubt
        dou.AskDoubtBtn().click();
        Thread.sleep(5000);

        String selectedSubject = null, selectedLesson = null;
        List<WebElement> doubtoptions = driver.findElements(By.xpath("/html/body/div[4]/div[1]/div/div[1]//select"));

        for(WebElement webElement:doubtoptions){
            webElement.click();
            webElement.sendKeys(Keys.ARROW_DOWN);
            webElement.sendKeys(Keys.ENTER);
            Thread.sleep(2000);
        }
        int i=0;
        for(WebElement webElement:doubtoptions){
            Select select = new Select(webElement);
            if(i==0){
                selectedSubject = select.getFirstSelectedOption().getText();
            }
            else if(i==1){
                selectedLesson = select.getFirstSelectedOption().getText();
            }
            i++;
            Thread.sleep(3000);
        }
        dou.QuestionTextBox().click();
        dou.QuestionTextBox().sendKeys("ABCD TEST");
        Thread.sleep(2000);
        dou.SubmitBtn().click();

        Thread.sleep(5000);

        // -------------------------

        driver.navigate().to("https://test.onelern.school/");
        dou.HomepageMenuBtn().click();
        logoutelement = dou.logoutBtn();
        js.executeScript("arguments[0].scrollIntoView();", logoutelement);
        Thread.sleep(2000);
        logoutelement.click();
        driver.navigate().refresh();
        dou.StudentAccount().click();
        dou.backBtnLoginPage().click();

        user.userLogin("teacher", Teacher_mobile_number, password);
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);
        // reply to doubt
        dou.firstDoubt().click();
        Thread.sleep(2000);


        // reply doubt
        int prevAnsweredCount = Integer.parseInt(dou.answered_count().getText().strip());
        dou.ReplyInputBox().click();
        dou.ReplyInputBox().sendKeys("OK");
        Thread.sleep(2000);

        dou.ReplySubmitBtn().click();
        Thread.sleep(2000);

        int CurrAnsweredCount = Integer.parseInt(dou.answered_count().getText());
        // validate answered count- curr == prev+1
        flag1 = CompareVal(CurrAnsweredCount, prevAnsweredCount + 1);

        driver.navigate().to("https://test.onelern.school/");
        dou.HomepageMenuBtn().click();
        logoutelement = dou.logoutBtn();
        js.executeScript("arguments[0].scrollIntoView();", logoutelement);
        logoutelement.click();
        driver.navigate().refresh();
        dou.StudentAccount().click();

        dou.backBtnLoginPage().click();

        user.userLogin("student", Student_mobile_number, password);
        Thread.sleep(2000);
        dou.StudentImageClick().click();
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);
        dou.firstDoubt().click();
        Thread.sleep(2000);

        int StudentCheckAnsweredCount = Integer.parseInt(dou.answered_count().getText());
        // validate answered count  -     == 1
        flag2 = CompareVal(StudentCheckAnsweredCount, 1);
        dou.markThisAnswerBtn().click();
        Thread.sleep(2000);

        int number_of_greenchecks = dou.greenCheckMark().size();
        // validate green check count        == 3
        flag3 = CompareVal(number_of_greenchecks, 3);

        String bestanswerelement = dou.bestAnswerText().getText();
//        validate Best Answer     == Best Answer
        flag4 = CompareText(bestanswerelement, "Best Answer");

        int ResolvedTextCount = dou.resolvedText().size();
        // validate resolved text count     == 2
        flag5 = CompareVal(ResolvedTextCount, 2);

        // checking resolved text in teacher account
        driver.navigate().to("https://test.onelern.school/");
        dou.HomepageMenuBtn().click();
        logoutelement = dou.logoutBtn();
        js.executeScript("arguments[0].scrollIntoView();", logoutelement);
        logoutelement.click();
        driver.navigate().refresh();
        dou.StudentAccount().click();

        dou.backBtnLoginPage().click();

        user.userLogin("teacher", Teacher_mobile_number, password);
        Thread.sleep(2000);
        dou.DoubtsToggle().click();
        Thread.sleep(2000);

        String statusText = dou.statusText().getText();
//        validate statustext    == Resolved

        flag6 = CompareText(statusText, "Resolved");

        return DoubtReplyValidateTest(flag1 && flag2 && flag3 && flag4 && flag5 && flag6);
    }


}
