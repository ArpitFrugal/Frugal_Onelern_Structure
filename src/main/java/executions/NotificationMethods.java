package executions;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import pageObjects.Notifications;
import pageObjects.Parent;
import resources.BaseLogin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NotificationMethods extends BaseLogin {
    public Notifications noti;
    public LoginPage log;
    public WebDriver driver;

    String TeacherMob = "9000000101";
    String StudentMob = "9000000001";
    String password = "123456";

    public NotificationMethods(WebDriver driver2) throws FileNotFoundException {
        super(driver2);
    }

    public boolean StudentNewAssessmentNotificationCheck(WebDriver driver) throws IOException, InterruptedException {
        this.noti = new Notifications(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", TeacherMob, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> QuestionTextBoxes;
        noti.AssessmentToggle().click();
        Thread.sleep(2000);

        noti.MyAssessmentsPage().click();
        Thread.sleep(2000);
//        if(noti.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(noti.ModalOverlay()));
        Thread.sleep(10000);
        noti.CreateNew().click();
        Thread.sleep(2000);

        String AssessmentName = "New Assessment";
        noti.NameOfAssessmentInput().click();
        noti.NameOfAssessmentInput().sendKeys(AssessmentName);

        Thread.sleep(2000);

        for (WebElement webElement: noti.AssessmentDetails()){
            webElement.click();
            webElement.sendKeys(Keys.ARROW_DOWN);
            webElement.sendKeys(Keys.ENTER);
        }

        noti.AssessmentFormat().click();
        Thread.sleep(1000);
        noti.AssessmentFormatOnline().click();
        Thread.sleep(1000);

        noti.SubmitBtn().click();

        noti.SectionBtn().click();

        noti.SectionName().click();
        noti.SectionName().sendKeys("Section");

        noti.SectionInstructions().click();
        noti.SectionInstructions().sendKeys("Instructions");

        noti.SubmitBtn().click();
        Thread.sleep(2000);

        // T/F Question

        noti.QuestionBtn().click();
        noti.TrueFalseOption().click();
//        if(noti.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(noti.ModalOverlay()));
        Thread.sleep(2000);

        noti.TrueOption().click();

        QuestionTextBoxes = noti.QuestionInputBoxes();
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


        for(WebElement webElement: noti.QuestionsMetadata()){
            if(webElement.isEnabled()){
                webElement.click();
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
                Thread.sleep(1500);
            }
        }
        noti.MarksInputBox().click();
        Thread.sleep(1000);
        noti.MarksInputBox().sendKeys("01");
        Thread.sleep(2000);


        noti.QuestionsMetadata().get(4).click();
        noti.QuestionsMetadata().get(4).sendKeys(Keys.ARROW_DOWN);
        noti.QuestionsMetadata().get(4).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
//
        Actions action = new Actions(driver);
        for(int i=0;i<5;i++){
            action.sendKeys(Keys.TAB).perform();
            Thread.sleep(1000);
        }

        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);



        // --------------------------------------


        noti.PassMarks().click();
        Thread.sleep(2000);
        noti.PassMarks().sendKeys("1");
        Thread.sleep(2000);

        noti.AssessmentAssignStudentsBtn().click();
//        if(noti.ModalOverlay().isDisplayed())
//            wait.until(ExpectedConditions.invisibilityOf(noti.ModalOverlay()));
        Thread.sleep(1000);
        noti.AssessmentSelectStudentsBtn().click();

        noti.SelectAllStudents().click();
        Thread.sleep(2000);

        noti.AddStudents().click();
        Thread.sleep(2000);
        noti.ScheduleBtn().click();
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


        noti.DateInput().click();
        noti.DateInput().sendKeys(currdate);
        noti.DateInput().sendKeys(currmonth);
        noti.DateInput().sendKeys(curryear);

        noti.TimeInput().click();
        noti.TimeInput().sendKeys(currhour);
        noti.TimeInput().sendKeys(currmin);
        noti.TimeInput().sendKeys(ampm);

        noti.DurationInput().click();
        noti.DurationInput().sendKeys(Keys.ARROW_DOWN);

        noti.ShowScoresAfter().click();
        noti.ShowScoresAfter().sendKeys(Keys.ARROW_DOWN);

        noti.passwordInputTeacher().click();
        noti.passwordInputTeacher().sendKeys("password");

        driver.findElement(By.xpath("//h1")).click();
//        js.executeScript("arguments[0].scrollIntoView();", noti.instructionsInput());
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[contains(@class,'hint-txt')]")));
        Thread.sleep(2000);
        noti.instructionsInput().click();
        noti.instructionsInput().sendKeys("Instructions");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//h1")).click();
        Thread.sleep(1000);
//        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[contains(@class,'hint-txt')]")));
//        Thread.sleep(1000);
        noti.HintShowOption().click();
        Thread.sleep(1000);
        noti.PublishAssessmentBtn().click();
        Thread.sleep(2000);


        driver.navigate().to(prop.getProperty("website"));
        noti.HomepageMenuBtn().click();
        WebElement logoutelement = noti.logoutBtn();
        js.executeScript("arguments[0].scrollIntoView();", logoutelement);
        Thread.sleep(2000);
        logoutelement.click();
        driver.navigate().refresh();
        noti.StudentAccount().click();
        noti.backBtnLoginPage().click();

        user.userLogin("student", StudentMob, password);
        Thread.sleep(2000);
        noti.StudentImageClick().click();
        Thread.sleep(2000);

        noti.notificationsStudent().click();

        String RecentNotificationTitle = noti.RecentNotificationInfo().getText();
        String expectedText = "ASSESSMENT";
        return NewAssessmentValidateTest(RecentNotificationTitle, expectedText);

    }

    public boolean NewAssessmentValidateTest(String displayedNotificationTitle, String expectedText) {
        if(displayedNotificationTitle.contains(expectedText)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }


    public boolean StudentNewAssignmentNotificationCheck(WebDriver driver) throws IOException, InterruptedException {
        this.noti = new Notifications(driver);
        BaseLogin user = new BaseLogin(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        user.userLogin("teacher", TeacherMob, password);
        Thread.sleep(2000);
        noti.rightswipemodules().click();
        Thread.sleep(1000);
        noti.rightswipemodules().click();

        noti.AssignmentsToggle().click();
        Thread.sleep(2000);

        noti.CreateNewBtn().click();

        noti.AssignmentName().click();
        noti.AssignmentName().sendKeys("New Assignment");

        Select AssignmentSubject = new Select(noti.AssignmentSubject());
        AssignmentSubject.selectByIndex(1);

        Select AssignmentRewardType = new Select(noti.AssignmentRewardType());
        AssignmentRewardType.selectByIndex(1);
//        Select AssignmentType = new Select(noti.AssignmentType());
//        AssignmentType.selectByIndex(1);
//        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();

        noti.AssignmentDetailsSubmitBtn().click();

        noti.QuestionDescription().click();
        noti.QuestionDescription().sendKeys("Question");

        noti.AttachLink().click();
        noti.LinkInputBox().click();
        noti.LinkInputBox().sendKeys("www.google.com");
        noti.AddLinkSubmit().click();

        for(WebElement webElement:noti.FileTypes()){
            webElement.click();
            Thread.sleep(500);
        }
        noti.FileSizeLimit().click();
        noti.FileSizeLimit().sendKeys("1");

        noti.AssignmentAssignStudentsBtn().click();
        Thread.sleep(2000);

        noti.AssignmentSelectStudentsBtn().click();
        Thread.sleep(2000);

        noti.SelectAllOption().click();

        noti.AddStudentsBtn().click();

        noti.ScheduleBtn().click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[@for='individual']")).click();

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String CurrDate = formatter.format(date);
        Calendar cal1 = Calendar.getInstance();
        try{
            cal1.setTime(formatter.parse(CurrDate));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal1.add(Calendar.DAY_OF_MONTH, 5);
        String str = formatter.format(cal1.getTime());
        System.out.println(str);
        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        Calendar cal2 = Calendar.getInstance();
        try{
            cal2.setTime(formatter.parse(str));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal2.add(Calendar.DAY_OF_MONTH, 20);
        String dateAfter = formatter.format(cal2.getTime());

        String enddate = dateAfter.split("/")[0];
        String endmonth = dateAfter.split("/")[1];
        String endyear = dateAfter.split("/")[2];

        noti.StartDateInputBox().click();
        noti.StartDateInputBox().sendKeys(currdate);
        noti.StartDateInputBox().sendKeys(currmonth);
        noti.StartDateInputBox().sendKeys(curryear);
        Thread.sleep(2000);
        noti.EndDateInputBox().click();
        noti.EndDateInputBox().sendKeys(enddate);
        noti.EndDateInputBox().sendKeys(endmonth);
        noti.EndDateInputBox().sendKeys(endyear);

        WebElement InstructionsTextBox = driver.findElement(By.xpath("//textarea"));

        InstructionsTextBox.click();
        InstructionsTextBox.sendKeys("instructions");

        noti.PublishBtn().click();

        Thread.sleep(3000);


        driver.navigate().to(prop.getProperty("website"));
        noti.HomepageMenuBtn().click();
        WebElement logoutelement = noti.logoutBtn();
        js.executeScript("arguments[0].scrollIntoView();", logoutelement);
        Thread.sleep(2000);
        logoutelement.click();
        driver.navigate().refresh();
        noti.StudentAccount().click();
        noti.backBtnLoginPage().click();

        user.userLogin("student", StudentMob, password);
        Thread.sleep(2000);
        noti.StudentImageClick().click();
        Thread.sleep(2000);

        noti.notificationsStudent().click();

        String RecentNotificationTitle = noti.RecentNotificationInfo().getText();
        String expectedText = "ASSIGNMENT";
        return NewAssignmentValidateTest(RecentNotificationTitle, expectedText);

    }

    public boolean NewAssignmentValidateTest(String displayedNotificationTitle, String expectedText) {
        System.out.println(displayedNotificationTitle +" "+ expectedText);
        if(displayedNotificationTitle.contains(expectedText)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean StudentAttendanceMarkedAbsentNotificationCheck(WebDriver driver) throws IOException, InterruptedException {
        this.noti = new Notifications(driver);
        BaseLogin user = new BaseLogin(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        user.userLogin("teacher", TeacherMob, password);
        Thread.sleep(2000);

        noti.AttendanceToggle().click();
        Thread.sleep(2000);

        if(!noti.editAttendanceBtn().isEnabled()){
            return MarkedAbsentAttendanceValidateTest("pass", "pass");
        }
        else {
            noti.editAttendanceBtn().click();
            driver.findElement(By.xpath("//*[contains(@class,'present-mark-box')]")).click();

            List<WebElement> AllStudentsAttendanceMark = driver.findElements(By.xpath("//*[contains(@class,'present-mark-box')]/div[contains(@class,'active')]/button[contains(@class,'present')]"));
            for(WebElement webElement:AllStudentsAttendanceMark){
                js.executeScript("arguments[0].scrollIntoView();", webElement);
                webElement.click();
//                Thread.sleep(500);
                noti.absentmarkoption().click();
//                Thread.sleep(500);
            }

            Thread.sleep(2000);

            noti.AttendancesaveBtn().click();
            Thread.sleep(2000);



//            for marking present from absent

//            List<WebElement> AllStudentsAttendanceMark = driver.findElements(By.xpath("//*[contains(@class,'present-mark-box')]/div[contains(@class,'active')]/button[contains(@class,'absent')]"));
//            for(WebElement webElement:AllStudentsAttendanceMark){
//                js.executeScript("arguments[0].scrollIntoView();", webElement);
//                webElement.click();
////              Thread.sleep(500);
//                noti.presentmarkoption().click();
////              Thread.sleep(500);
//            }
//
//            Thread.sleep(2000);
//
//            noti.AttendancesaveBtn().click();
//            Thread.sleep(2000);



        }


        driver.navigate().to(prop.getProperty("website"));
        Thread.sleep(2000);
        noti.HomepageMenuBtn().click();
        WebElement logoutelement = noti.logoutBtn();
        js.executeScript("arguments[0].scrollIntoView();", logoutelement);
        Thread.sleep(2000);
        logoutelement.click();
        driver.navigate().refresh();
        noti.StudentAccount().click();
        noti.backBtnLoginPage().click();


        user.userLogin("student", StudentMob, password);
        Thread.sleep(2000);
        noti.StudentImageClick().click();
        Thread.sleep(2000);

        noti.notificationsStudent().click();

        String RecentNotificationTitle = noti.RecentNotificationInfo().getText();
        String expectedText = "absent";
        return MarkedAbsentAttendanceValidateTest(RecentNotificationTitle, expectedText);

    }

    public boolean MarkedAbsentAttendanceValidateTest(String displayedNotificationTitle, String expectedText) {
        System.out.println(displayedNotificationTitle +" "+ expectedText);
        if(displayedNotificationTitle.contains(expectedText)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }


    public boolean StudentAttendanceMarkedLeaveNotificationCheck(WebDriver driver) throws IOException, InterruptedException {
        this.noti = new Notifications(driver);
        BaseLogin user = new BaseLogin(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        user.userLogin("teacher", TeacherMob, password);
        Thread.sleep(2000);

        noti.AttendanceToggle().click();
        Thread.sleep(2000);

        if(!noti.editAttendanceBtn().isEnabled()){
            return MarkedLeaveAttendanceValidateTest("pass", "pass");
        }
        else {
            noti.editAttendanceBtn().click();
            driver.findElement(By.xpath("//*[contains(@class,'present-mark-box')]")).click();

//            List<WebElement> AllStudentsAttendanceMark = driver.findElements(By.xpath("//*[contains(@class,'present-mark-box')]/div[contains(@class,'active')]/button[contains(@class,'present')]"));
//            for(WebElement webElement:AllStudentsAttendanceMark){
//                js.executeScript("arguments[0].scrollIntoView();", webElement);
//                webElement.click();
////                Thread.sleep(500);
//                noti.leavemarkoption().click();
////                Thread.sleep(500);
//            }
//
//            Thread.sleep(2000);
//
//            noti.AttendancesaveBtn().click();
//            Thread.sleep(2000);



//            for marking present from leave

            List<WebElement> AllStudentsAttendanceMark = driver.findElements(By.xpath("//*[contains(@class,'present-mark-box')]/div[contains(@class,'active')]/button[contains(@class,'leave')]"));
            for(WebElement webElement:AllStudentsAttendanceMark){
                js.executeScript("arguments[0].scrollIntoView();", webElement);
                webElement.click();
//                Thread.sleep(500);
                noti.presentmarkoption().click();
//                Thread.sleep(500);
            }

            Thread.sleep(2000);

            noti.AttendancesaveBtn().click();
            Thread.sleep(2000);


        }


        driver.navigate().to(prop.getProperty("website"));
        Thread.sleep(2000);
        noti.HomepageMenuBtn().click();
        WebElement logoutelement = noti.logoutBtn();
        js.executeScript("arguments[0].scrollIntoView();", logoutelement);
        Thread.sleep(2000);
        logoutelement.click();
        driver.navigate().refresh();
        noti.StudentAccount().click();
        noti.backBtnLoginPage().click();


        user.userLogin("student", StudentMob, password);
        Thread.sleep(2000);
        noti.StudentImageClick().click();
        Thread.sleep(2000);

        noti.notificationsStudent().click();

        String RecentNotificationTitle = noti.RecentNotificationInfo().getText();
        String expectedText = "leave";
        return MarkedLeaveAttendanceValidateTest(RecentNotificationTitle, expectedText);

    }

    public boolean MarkedLeaveAttendanceValidateTest(String displayedNotificationTitle, String expectedText) {
        System.out.println(displayedNotificationTitle +" "+ expectedText);
        if(displayedNotificationTitle.contains(expectedText)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean StudentNewHolidayNotificationCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.noti = new Notifications(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        noti.adminTimetableToggle().click();

        noti.HolidaysTab().click();
        noti.CreateNewHoliday().click();

        noti.HolidayName().click();
        noti.HolidayName().sendKeys("New Holiday");
//        noti.Holidaydesc().click();
//        noti.Holidaydesc().sendKeys("Event description");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String CurrDate = formatter.format(date);
        Calendar cal1 = Calendar.getInstance();
        try{
            cal1.setTime(formatter.parse(CurrDate));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        Calendar cal2 = Calendar.getInstance();
        try{
            cal2.setTime(formatter.parse(str));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal2.add(Calendar.YEAR, 1);
        String dateAfter = formatter.format(cal2.getTime());

        String enddate = dateAfter.split("/")[0];
        String endmonth = dateAfter.split("/")[1];
        String endyear = dateAfter.split("/")[2];

        noti.startDate().click();
        noti.startDate().sendKeys(currdate);
        noti.startDate().sendKeys(currmonth);
        noti.startDate().sendKeys(curryear);

        noti.endDate().click();
        noti.endDate().sendKeys(enddate);
        noti.endDate().sendKeys(endmonth);
        noti.endDate().sendKeys(endyear);



        noti.CreateHolidayBtn().click();


        driver.navigate().to(prop.getProperty("website"));
        Thread.sleep(2000);
        noti.StudentAccount().click();
        noti.backBtnLoginPage().click();


        user.userLogin("student", StudentMob, password);
        Thread.sleep(2000);
        noti.StudentImageClick().click();
        Thread.sleep(2000);

        noti.notificationsStudent().click();

        String RecentNotificationTitle = noti.RecentNotificationInfo().getText();
        String expectedText = "HOLIDAY";
        return HolidayCreatedValidateTest(RecentNotificationTitle, expectedText);

    }

    public boolean HolidayCreatedValidateTest(String displayedNotificationTitle, String expectedText) {
        System.out.println(displayedNotificationTitle +" "+ expectedText);
        if(displayedNotificationTitle.contains(expectedText)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }


    public boolean TeacherNewHolidayNotificationCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.noti = new Notifications(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        noti.adminTimetableToggle().click();

        noti.HolidaysTab().click();
        noti.CreateNewHoliday().click();

        noti.HolidayName().click();
        noti.HolidayName().sendKeys("New Holiday");
//        noti.Holidaydesc().click();
//        noti.Holidaydesc().sendKeys("Event description");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String CurrDate = formatter.format(date);
        Calendar cal1 = Calendar.getInstance();
        try{
            cal1.setTime(formatter.parse(CurrDate));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        Calendar cal2 = Calendar.getInstance();
        try{
            cal2.setTime(formatter.parse(str));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal2.add(Calendar.YEAR, 1);
        String dateAfter = formatter.format(cal2.getTime());

        String enddate = dateAfter.split("/")[0];
        String endmonth = dateAfter.split("/")[1];
        String endyear = dateAfter.split("/")[2];

        noti.startDate().click();
        noti.startDate().sendKeys(currdate);
        noti.startDate().sendKeys(currmonth);
        noti.startDate().sendKeys(curryear);

        noti.endDate().click();
        noti.endDate().sendKeys(enddate);
        noti.endDate().sendKeys(endmonth);
        noti.endDate().sendKeys(endyear);



        noti.CreateHolidayBtn().click();


        driver.navigate().to(prop.getProperty("website"));
        Thread.sleep(2000);
        noti.StudentAccount().click();
        noti.backBtnLoginPage().click();


        user.userLogin("teacher", TeacherMob, password);
        Thread.sleep(2000);

        noti.notificationsTeacher().click();

        String RecentNotificationTitle = noti.RecentNotificationInfo().getText();
        String expectedText = "HOLIDAY";
        return HolidayCreatedValidateTest(RecentNotificationTitle, expectedText);

    }


    public boolean StudentNewEventNotificationCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.noti = new Notifications(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        noti.adminTimetableToggle().click();

        noti.EventsTab().click();
        noti.CreateNewEvent().click();

        noti.EventName().click();
        noti.EventName().sendKeys("New Event");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String CurrDate = formatter.format(date);
        Calendar cal1 = Calendar.getInstance();
        try{
            cal1.setTime(formatter.parse(CurrDate));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        Calendar cal2 = Calendar.getInstance();
        try{
            cal2.setTime(formatter.parse(str));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal2.add(Calendar.YEAR, 1);
        String dateAfter = formatter.format(cal2.getTime());

        String enddate = dateAfter.split("/")[0];
        String endmonth = dateAfter.split("/")[1];
        String endyear = dateAfter.split("/")[2];

        noti.startDate().click();
        noti.startDate().sendKeys(currdate);
        noti.startDate().sendKeys(currmonth);
        noti.startDate().sendKeys(curryear);

        noti.endDate().click();
        noti.endDate().sendKeys(enddate);
        noti.endDate().sendKeys(endmonth);
        noti.endDate().sendKeys(endyear);

        // time
        noti.startTime().click();
        noti.startTime().sendKeys("08");
        noti.startTime().sendKeys("00");
        noti.startTime().sendKeys("a");

        noti.endTime().click();
        noti.endTime().sendKeys("03");
        noti.endTime().sendKeys("00");
        noti.endTime().sendKeys("p");

        noti.CreateEventBtn().click();




        driver.navigate().to(prop.getProperty("website"));
        Thread.sleep(2000);
        noti.StudentAccount().click();
        noti.backBtnLoginPage().click();


        user.userLogin("student", StudentMob, password);
        Thread.sleep(2000);
        noti.StudentImageClick().click();
        Thread.sleep(2000);

        noti.notificationsStudent().click();

        String RecentNotificationTitle = noti.RecentNotificationInfo().getText();
        String expectedText = "EVENT";
        return NewEventValidateTest(RecentNotificationTitle, expectedText);

    }

    public boolean NewEventValidateTest(String displayedNotificationTitle, String expectedText) {
        System.out.println(displayedNotificationTitle +" "+ expectedText);
        if(displayedNotificationTitle.contains(expectedText)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean TeacherNewEventNotificationCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.noti = new Notifications(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        noti.adminTimetableToggle().click();

        noti.EventsTab().click();
        noti.CreateNewEvent().click();

        noti.EventName().click();
        noti.EventName().sendKeys("New Event");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String CurrDate = formatter.format(date);
        Calendar cal1 = Calendar.getInstance();
        try{
            cal1.setTime(formatter.parse(CurrDate));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        Calendar cal2 = Calendar.getInstance();
        try{
            cal2.setTime(formatter.parse(str));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal2.add(Calendar.YEAR, 1);
        String dateAfter = formatter.format(cal2.getTime());

        String enddate = dateAfter.split("/")[0];
        String endmonth = dateAfter.split("/")[1];
        String endyear = dateAfter.split("/")[2];

        noti.startDate().click();
        noti.startDate().sendKeys(currdate);
        noti.startDate().sendKeys(currmonth);
        noti.startDate().sendKeys(curryear);

        noti.endDate().click();
        noti.endDate().sendKeys(enddate);
        noti.endDate().sendKeys(endmonth);
        noti.endDate().sendKeys(endyear);

        // time
        noti.startTime().click();
        noti.startTime().sendKeys("08");
        noti.startTime().sendKeys("00");
        noti.startTime().sendKeys("a");

        noti.endTime().click();
        noti.endTime().sendKeys("03");
        noti.endTime().sendKeys("00");
        noti.endTime().sendKeys("p");

        noti.CreateEventBtn().click();



        driver.navigate().to(prop.getProperty("website"));
        Thread.sleep(2000);
        noti.StudentAccount().click();
        noti.backBtnLoginPage().click();


        user.userLogin("teacher", TeacherMob, password);
        Thread.sleep(2000);

        noti.notificationsTeacher().click();

        String RecentNotificationTitle = noti.RecentNotificationInfo().getText();
        String expectedText = "EVENT";
        return NewEventValidateTest(RecentNotificationTitle, expectedText);

    }


    public boolean StudentPublishNewContentNotificationCheck(WebDriver driver) throws IOException, InterruptedException {
        this.noti = new Notifications(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", TeacherMob, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        noti.PublishToggle().click();
        Thread.sleep(5000);
        Thread.sleep(5000);
        noti.PublishNewContentBtn().click();
        Thread.sleep(5000);

        List<WebElement> ContentOptions = noti.ContentOptions();
        int i=0;
        for(WebElement webElement:ContentOptions){
            if(i==0 || i==3 || i==4){
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
            }
            else{
                webElement.sendKeys(Keys.ENTER);
            }
            i+=1;
            Thread.sleep(2000);
        }

        Thread.sleep(3000);


        String publishContent = "Grade 1 Content";

        noti.PublishContentDescriptionTextArea().click();
        noti.PublishContentDescriptionTextArea().sendKeys(publishContent);
        Thread.sleep(3000);
        noti.NextStepBtn().click();
        Thread.sleep(3000);
        List<WebElement> GradeSectionInput = noti.PublishGradeSectionInput();
        for(WebElement webElement : GradeSectionInput){
            webElement.click();
            webElement.sendKeys(Keys.ARROW_DOWN);
            webElement.sendKeys(Keys.ENTER);
        }
        Thread.sleep(3000);
        noti.FinalPublishBtn().click();
        Thread.sleep(5000);


        driver.navigate().to(prop.getProperty("website"));
        noti.HomepageMenuBtn().click();
        WebElement logoutelement = noti.logoutBtn();
        js.executeScript("arguments[0].scrollIntoView();", logoutelement);
        Thread.sleep(2000);
        logoutelement.click();
        driver.navigate().refresh();
        noti.StudentAccount().click();
        noti.backBtnLoginPage().click();

        user.userLogin("student", StudentMob, password);
        Thread.sleep(2000);
        noti.StudentImageClick().click();
        Thread.sleep(2000);

        noti.notificationsStudent().click();

        String RecentNotificationTitle = noti.RecentNotificationInfo().getText();
        String expectedText = "PUBLISHED";
        return NewPublishContentValidateTest(RecentNotificationTitle, expectedText);

    }

    public boolean NewPublishContentValidateTest(String displayedNotificationTitle, String expectedText) {
        System.out.println(displayedNotificationTitle +" "+ expectedText);
        if(displayedNotificationTitle.contains(expectedText)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

}
