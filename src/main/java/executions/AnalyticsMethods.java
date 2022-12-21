package executions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.Analytics;
import pageObjects.Assessment;
import pageObjects.LoginPage;
import resources.BaseLogin;

import java.io.IOException;
import java.util.List;

public class AnalyticsMethods extends BaseLogin {
    public Analytics ana;
    public LoginPage log;
    public WebDriver driver;

    public AnalyticsMethods(WebDriver driver2) {
        super(driver2);
    }


    public boolean EOLTAttemptedCountValidateTest(int actual, int expected){
        System.out.println(actual+" "+expected);
        if(actual == expected){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }
    public boolean EoLTStudentsCountCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(3000);
        ana.PerformanceTab().click();
        boolean flag1, flag2, flag3;

        ana.ViewEoLT().click();
//        System.out.println(ana.recentLevelsTotalStudents());
        List<WebElement> LevelsStudents=ana.LevelsStudents();

        int count = 0;
        for(int i=0;i<LevelsStudents.size();i++){
            System.out.println(i);
            count+= Integer.parseInt(List.of(LevelsStudents.get(i).getText().split("\n")).get(0));
        }
        return EOLTAttemptedCountValidateTest(count, ana.recentLevelsTotalStudents());
    }

    public boolean CompareVal(int actual, int expected){
        System.out.println(actual + " "+expected);
        return actual == expected;
    }
    public boolean EOSQAttemptedCountValidateTest(boolean flag1, boolean flag2, boolean flag3){
        System.out.println(flag1 + " "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean EoSQAttemptedCountCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(3000);
        ana.PerformanceTab().click();
        boolean flag1, flag2, flag3;
        Thread.sleep(2000);
        ana.ViewWEoSQ().click();
        Thread.sleep(2000);
//        ana.EoSQLesson1().click();
        ana.EoSQAttemptedTopic1().click();

        System.out.println(ana.AttemptedCount());
        System.out.println(List.of(ana.AttemptedCount().split(" ")));
        int attemptedCount = Integer.parseInt(List.of(ana.AttemptedCount().split(" ")).get(1));
        int displayedStudents = ana.AttemptedStudents().size();

        flag1 = CompareVal(attemptedCount, displayedStudents);
        Select attemptedSwitch = new Select(ana.AttemptedSwitch());
        attemptedSwitch.selectByValue("2");
        Thread.sleep(2000);
        System.out.println(ana.AttemptedCount());
        System.out.println(List.of(ana.AttemptedCount().split(" ")));
        int nonattemptedCount = Integer.parseInt(List.of(ana.AttemptedCount().split(" ")).get(2));
        displayedStudents = ana.AttemptedStudents().size();

        flag2 = CompareVal(nonattemptedCount, displayedStudents);

        System.out.println(attemptedCount+" "+nonattemptedCount+" "+Integer.parseInt(ana.overallScore().getText()));
        flag3 = CompareVal(attemptedCount+ nonattemptedCount, Integer.parseInt(ana.overallScore().getText()));

        return EOSQAttemptedCountValidateTest(flag1, flag2, flag3);
    }

    public boolean ValCompare(String prevUrl, String currUrl) {
        return prevUrl.equals(currUrl);
    }

    public boolean EOSQLessonsTopicValidateTest(boolean flag){
        if(flag){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean EoSQLessonTopicsCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();

        ana.ViewWEoSQ().click();

        int i=0, j=0;
        boolean flag = true;
        for(i=0;i<ana.LessonTopics().size();i++){
            List<WebElement> LessonTopics = ana.LessonTopics();
            Thread.sleep(2000);
            int percentage = (int)Math.ceil(Double.parseDouble(List.of(ana.TopicsPercentage().get(i).getText().split(" ")).get(0)));
            if(percentage == 0){
                String classname =  LessonTopics.get(i).getAttribute("class");
                String tobepresent = "pointer-events-none";
                flag = classname.contains(tobepresent);
            }
            if(percentage != 0){
//                System.out.println(1);
                String prevUrl = driver.getCurrentUrl();
                LessonTopics.get(i).click();
                Thread.sleep(2000);
                String currUrl = driver.getCurrentUrl();
                flag = !ValCompare(prevUrl, currUrl);
                Thread.sleep(2000);
                ana.backBtn().click();
            }
        }
        return EOSQLessonsTopicValidateTest(flag);
    }

    String[] grades = {"Grade 1", "Grade 2", "Grade 3", "Grade 4", "Grade 5"};

    public boolean EOSQStudentGradeValidateTest(String Actual, String Expected){
        System.out.println(Actual + " "+Expected);
        if(Actual.contains(Expected)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }


    public boolean EOSQStudentProfileGradeCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();

        ana.ViewWEoSQ().click();

//        ana.EoSQLesson1().click();
        ana.EoSQAttemptedTopic1().click();

        ana.DisplayedStudentName().click();

        if(mob >= 9000000101l && mob <= 9000000104l){
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[0];

            EOSQStudentGradeValidateTest(GradeSection, expectedgrade);
        }
        else if (mob >= 9000000105l && mob <= 9000000108l) {
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[1];

            EOSQStudentGradeValidateTest(GradeSection, expectedgrade);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[2];

            EOSQStudentGradeValidateTest(GradeSection, expectedgrade);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[3];

            EOSQStudentGradeValidateTest(GradeSection, expectedgrade);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[4];

            EOSQStudentGradeValidateTest(GradeSection, expectedgrade);
        }


        return false;
    }

    public boolean EOSQStudentProfileValidateTest(boolean flag1, boolean flag2, boolean flag3){
        System.out.println(flag1 + " "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean EOSQStudentProfileCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();
        boolean flag1, flag2, flag3;

        ana.ViewWEoSQ().click();

//        ana.EoSQLesson1().click();
        ana.EoSQAttemptedTopic1().click();

        String DisplayedStudentName = ana.DisplayedStudentName().getText();
        ana.DisplayedStudentName().click();

        String heading = ana.GetHeader();
        flag1 = heading.contains(DisplayedStudentName);

        String path = ana.NavigationPath().getText();
        flag2 = path.contains(DisplayedStudentName);

        String StudentName = ana.StudentProfileName().getText();
        flag3 = StudentName.contains(DisplayedStudentName);

        return EOSQStudentProfileValidateTest(flag1, flag2, flag3);

    }

    public boolean EOSQStudentsCountValidateTest(int actual, int expected){
        System.out.println(actual+" "+expected);
        if(actual == expected){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean EoSQStudentsCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();

        ana.ViewWEoSQ().click();

//        ana.EoSQLesson1().click();
        ana.EoSQAttemptedTopic1().click();


        Thread.sleep(3000);
        System.out.println(ana.AttemptedCount());
        System.out.println(List.of(ana.AttemptedCount().split(" ")));
        int attemptedCount = Integer.parseInt(List.of(ana.AttemptedCount().split(" ")).get(1));
        int displayedStudents = ana.AttemptedStudents().size();

        return EOSQStudentsCountValidateTest(attemptedCount, displayedStudents);
    }

    public boolean EOSQTopicsEnabledDisabledValidateTest(boolean flag){
        if(flag){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean EoSQTopicsenabledisableCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();

        ana.ViewWEoSQ().click();
        List<WebElement> LessonTopics = ana.LessonTopics();
        int i=0, j=0;
        boolean flag = true;
        for(i=0;i<LessonTopics.size();i++){
            int percentage = (int)Math.ceil(Double.parseDouble(List.of(ana.TopicsPercentage().get(i).getText().split(" ")).get(0)));
            System.out.println(List.of(ana.TopicsPercentage().get(i).getText().split(" ")).get(0));
//            int percentage =0;
            if(percentage == 0){
                String className = LessonTopics.get(i).getAttribute("class");
                if(!className.contains("pointer-events-none")){
                    flag=false;
                    break;
                }
            }
            else{
                String className = LessonTopics.get(i).getAttribute("class");
                if(className.contains("pointer-events-none")){
                    flag=false;
                    break;
                }
            }
        }

        return EOSQTopicsEnabledDisabledValidateTest(flag);
    }

    public boolean TeacherLandingValidateTest(String actual_header){
        if (actual_header.equals("Analytics")) {
            System.out.println("Analytics Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);

        String actual_header = ana.GetHeader();
        return TeacherLandingValidateTest(actual_header);
    }

    public boolean LOAttemptedCountValidateTest(boolean flag1, boolean flag2, boolean flag3){
        System.out.println(flag1 + " "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean LearningOutcomesAttemptedCountCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean flag1, flag2, flag3;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        String LearningOutcome = driver.findElement(By.xpath("//div[contains(@class, 'lo-block')]//table//tbody/tr/td")).getText();

        ana.LearningOutcomeOpenBtn().click();
        Thread.sleep(2000);
        System.out.println(ana.AttemptedCount());
        System.out.println(List.of(ana.AttemptedCount().split(" ")));
        int attemptedCount = Integer.parseInt(List.of(ana.AttemptedCount().split(" ")).get(1));
        int displayedStudents = ana.AttemptedStudents().size();

        flag1 = CompareVal(attemptedCount, displayedStudents);
        Select attemptedSwitch = new Select(ana.AttemptedSwitch());
        attemptedSwitch.selectByValue("2");
        Thread.sleep(2000);
        System.out.println(ana.AttemptedCount());
        System.out.println(List.of(ana.AttemptedCount().split(" ")));
        int nonattemptedCount = Integer.parseInt(List.of(ana.AttemptedCount().split(" ")).get(2));
        displayedStudents = ana.AttemptedStudents().size();

        flag2 = CompareVal(nonattemptedCount, displayedStudents);

        flag3 = CompareVal(attemptedCount+ nonattemptedCount, Integer.parseInt(ana.overallScore().getText()));

        return LOAttemptedCountValidateTest(flag1, flag2, flag3);
    }

    public boolean CompareText(String actual, String expected){
        return actual.contains(expected);
    }

    public boolean LOValidateTest(boolean flag1, boolean flag2){
        System.out.println(flag1 + " "+flag2);
        if (flag1 && flag2) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean LearningOutcomesCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean flag1, flag2;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        String LearningOutcome = driver.findElement(By.xpath("//div[contains(@class, 'lo-block')]//table//tbody/tr/td")).getText();
        ana.LearningOutcomeOpenBtn().click();

        String heading = ana.GetHeader();
        flag1 = CompareText(heading, LearningOutcome);

        String path = ana.NavigationPath().getText();
        flag2 = CompareText(path, LearningOutcome);

        return LOValidateTest(flag1, flag2);
    }

    public boolean LOFilterValidateTest(boolean flag1, boolean flag2){
        System.out.println(flag1 + " "+flag2);
        if (flag1 && flag2) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean LearningOutcomesFilterCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int no_of_LO_displayed;
        boolean flag1 = false, flag2 = false;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Select filterOptions = new Select(ana.LearningOutcomesFilterDropdown());

        filterOptions.selectByValue("1");
        Thread.sleep(2000);
        no_of_LO_displayed = ana.LearningOutcomes().size();
        System.out.println(no_of_LO_displayed);
        flag1 = CompareVal(no_of_LO_displayed, 1);

        filterOptions.selectByValue("2");
        Thread.sleep(2000);
        no_of_LO_displayed = ana.LearningOutcomes().size();
        System.out.println(no_of_LO_displayed);
        if(no_of_LO_displayed<2){
            flag2 = CompareVal(no_of_LO_displayed, 1);
        }
        else{
            flag2 = CompareVal(no_of_LO_displayed, 2);
        }

        return LOFilterValidateTest(flag1, flag2);
    }

//    String[] grades = {"Grade 1", "Grade 2", "Grade 3", "Grade 4", "Grade 5"};
    public boolean LOStudentGradeValidateTest(String Actual, String Expected){
        System.out.println(Actual + " "+Expected);
        if(Actual.contains(Expected)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }
    public boolean LOStudentProfileGradeCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        ana.LearningOutcomeOpenBtn().click();
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Thread.sleep(3000);

        ana.DisplayedStudentName().click();

        if(mob >= 9000000101l && mob <= 9000000104l){
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[0];

            return LOStudentGradeValidateTest(GradeSection, expectedgrade);
        }
        else if (mob >= 9000000105l && mob <= 9000000108l) {
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[1];

            return LOStudentGradeValidateTest(GradeSection, expectedgrade);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[2];

            return LOStudentGradeValidateTest(GradeSection, expectedgrade);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[3];

            return LOStudentGradeValidateTest(GradeSection, expectedgrade);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            String GradeSection = ana.topSection().getText();
            String expectedgrade = grades[4];

            return LOStudentGradeValidateTest(GradeSection, expectedgrade);
        }
        return false;
    }

    public boolean LOStudentProfileValidateTest(boolean flag1, boolean flag2, boolean flag3){
        System.out.println(flag1 + " "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean LOStudentProfileCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        boolean flag1, flag2, flag3;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);
        ana.LearningOutcomeOpenBtn().click();
        Thread.sleep(3000);

        String DisplayedStudentName = ana.DisplayedStudentName().getText();
        ana.DisplayedStudentName().click();

        String heading = ana.GetHeader();
        flag1 = heading.contains(DisplayedStudentName);

        String path = ana.NavigationPath().getText();
        flag2 = path.contains(DisplayedStudentName);

        String StudentName = ana.StudentProfileName().getText();
        flag3 = StudentName.contains(DisplayedStudentName);

        return LOStudentProfileValidateTest(flag1, flag2, flag3);
    }

    public boolean LOStudentsCountValidateTest(int actual, int expected){
        System.out.println(actual+" "+expected);
        if(actual == expected){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }
    public boolean LearningOutcomesStudentsCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.ana = new Analytics(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        ana.AnalyticsToggle().click();
        Thread.sleep(2000);
        ana.PerformanceTab().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        ana.LearningOutcomeOpenBtn().click();
        Thread.sleep(3000);
        System.out.println(ana.AttemptedCount());
        System.out.println(List.of(ana.AttemptedCount().split(" ")));
        int attemptedCount = Integer.parseInt(List.of(ana.AttemptedCount().split(" ")).get(1));
        int displayedStudents = ana.AttemptedStudents().size();

        return LOStudentsCountValidateTest(attemptedCount, displayedStudents);
    }


}
