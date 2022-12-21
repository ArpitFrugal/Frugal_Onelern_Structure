package executions;

import io.qameta.allure.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pageObjects.Assignments;
import pageObjects.LoginPage;
import resources.BaseLogin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AssignmentMethods extends BaseLogin {
    public Assignments asg;
    public LoginPage log;
    public WebDriver driver;

    public AssignmentMethods(WebDriver driver2) {
        super(driver2);
    }

    public boolean CancelledPageValidateTest(boolean flag){
        System.out.println(flag);
        if (flag) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherCancelledPageCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.asg = new Assignments(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        asg.rightswipemodules().click();
        Thread.sleep(1000);
        asg.rightswipemodules().click();

        asg.AssignmentsToggle().click();
        Thread.sleep(2000);

        asg.CreateNewBtn().click();

        asg.AssignmentName().click();
        asg.AssignmentName().sendKeys("Cancelled Assignment");

        Select AssignmentSubject = new Select(asg.AssignmentSubject());
        AssignmentSubject.selectByIndex(1);

        Select AssignmentRewardType = new Select(asg.AssignmentRewardType());
        AssignmentRewardType.selectByIndex(1);
//        Select AssignmentType = new Select(asg.AssignmentType());
//        AssignmentType.selectByIndex(1);
//        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();

        asg.AssignmentDetailsSubmitBtn().click();

        asg.QuestionDescription().click();
        asg.QuestionDescription().sendKeys("Question");

        asg.AttachLink().click();
        asg.LinkInputBox().click();
        asg.LinkInputBox().sendKeys("www.google.com");
        asg.AddLinkSubmit().click();

        for(WebElement webElement:asg.FileTypes()){
            webElement.click();
            Thread.sleep(500);
        }
        asg.FileSizeLimit().click();
        asg.FileSizeLimit().sendKeys("1");

        asg.AssignStudentsBtn().click();
        Thread.sleep(2000);

        asg.SelectStudentsBtn().click();
        Thread.sleep(2000);

        asg.SelectAllOption().click();

        asg.AddStudentsBtn().click();

        asg.ScheduleBtn().click();
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

        asg.StartDateInputBox().click();
        asg.StartDateInputBox().sendKeys(currdate);
        asg.StartDateInputBox().sendKeys(currmonth);
        asg.StartDateInputBox().sendKeys(curryear);
        Thread.sleep(2000);
        asg.EndDateInputBox().click();
        asg.EndDateInputBox().sendKeys(enddate);
        asg.EndDateInputBox().sendKeys(endmonth);
        asg.EndDateInputBox().sendKeys(endyear);

        WebElement InstructionsTextBox = driver.findElement(By.xpath("//textarea"));

        InstructionsTextBox.click();
        InstructionsTextBox.sendKeys("instructions");

        asg.PublishBtn().click();

        driver.findElement(By.xpath("//*[contains(@class,'test-actions')]//a")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[contains(@class,'bottom-fix')]/div")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[contains(@class,'modal-footer')]//button[2]")).click();
        Thread.sleep(2000);

//        asg.CancelledTabPage().click();
        boolean flag=true;
        for(WebElement webElement:asg.AssignmentStatus()){
            if(!webElement.getText().contains("Cancelled")){
                flag= false;
                break;
            }
        }
        return CancelledPageValidateTest(flag);
    }

    public boolean CompletedPageValidateTest(boolean flag){
        System.out.println(flag);
        if (flag) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherCompletedPageCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.asg = new Assignments(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        asg.rightswipemodules().click();
        Thread.sleep(1000);
        asg.rightswipemodules().click();

        asg.AssignmentsToggle().click();
        Thread.sleep(2000);

        asg.CreateNewBtn().click();

        Thread.sleep(2000);
        asg.AssignmentName().click();
        asg.AssignmentName().sendKeys("New Assignment");

//        System.out.println(1);
        Select AssignmentSubject = new Select(asg.AssignmentSubject());
        AssignmentSubject.selectByIndex(1);
        Thread.sleep(2000);

//        System.out.println(2);
        Select AssignmentRewardType = new Select(asg.AssignmentRewardType());
        AssignmentRewardType.selectByIndex(1);
        Thread.sleep(2000);

//        System.out.println(3);
//        Select AssignmentType = new Select(asg.AssignmentType());
//        AssignmentType.selectByIndex(1);
//        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();


//        System.out.println(4);
        asg.AssignmentDetailsSubmitBtn().click();

        asg.QuestionDescription().click();
        asg.QuestionDescription().sendKeys("Question");

        asg.AttachLink().click();
        asg.LinkInputBox().click();
        asg.LinkInputBox().sendKeys("www.google.com");
        asg.AddLinkSubmit().click();

        for(WebElement webElement:asg.FileTypes()){
            webElement.click();
            Thread.sleep(500);
        }
        asg.FileSizeLimit().click();
        asg.FileSizeLimit().sendKeys("1");

        asg.AssignStudentsBtn().click();
        Thread.sleep(2000);

        asg.SelectStudentsBtn().click();
        Thread.sleep(2000);

        asg.SelectAllOption().click();

        asg.AddStudentsBtn().click();

        asg.ScheduleBtn().click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[@for='individual']")).click();

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(formatter.parse(str));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal.add(Calendar.DAY_OF_MONTH, 2);
        String dateAfter = formatter.format(cal.getTime());

        String enddate = dateAfter.split("/")[0];
        String endmonth = dateAfter.split("/")[1];
        String endyear = dateAfter.split("/")[2];

        asg.StartDateInputBox().click();
        asg.StartDateInputBox().sendKeys(currdate);
        asg.StartDateInputBox().sendKeys(currmonth);
        asg.StartDateInputBox().sendKeys(curryear);

        asg.EndDateInputBox().click();
        asg.EndDateInputBox().sendKeys(enddate);
        asg.EndDateInputBox().sendKeys(endmonth);
        asg.EndDateInputBox().sendKeys(endyear);

        WebElement InstructionsTextBox = driver.findElement(By.xpath("//textarea"));

        InstructionsTextBox.click();
        InstructionsTextBox.sendKeys("instructions");

        asg.PublishBtn().click();

        Thread.sleep(2000);
        asg.CompletedTabPage().click();
        boolean flag=true;
        for(WebElement webElement:asg.AssignmentStatus()){
            if(!(webElement.getText().contains("Evaluated") || webElement.getText().contains("Completed"))){
                flag= false;
                break;
            }
        }
        return CompletedPageValidateTest(flag);
    }


    public boolean DraftPageValidateTest(boolean flag){
        System.out.println(flag);
        if (flag) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherDraftsPageCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.asg = new Assignments(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        asg.rightswipemodules().click();
        Thread.sleep(1000);
        asg.rightswipemodules().click();

        asg.AssignmentsToggle().click();
        Thread.sleep(2000);

        asg.CreateNewBtn().click();

        Thread.sleep(2000);
        asg.AssignmentName().click();
        asg.AssignmentName().sendKeys("Drafted Assignment");

//        System.out.println(1);
        Select AssignmentSubject = new Select(asg.AssignmentSubject());
        AssignmentSubject.selectByIndex(1);
        Thread.sleep(2000);

//        System.out.println(2);
        Select AssignmentRewardType = new Select(asg.AssignmentRewardType());
        AssignmentRewardType.selectByIndex(1);
        Thread.sleep(2000);

//        System.out.println(3);
//        Select AssignmentType = new Select(asg.AssignmentType());
//        AssignmentType.selectByIndex(1);
//        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();


//        System.out.println(4);
        asg.AssignmentDetailsSubmitBtn().click();

        asg.QuestionDescription().click();
        asg.QuestionDescription().sendKeys("Question");

        asg.AttachLink().click();
        asg.LinkInputBox().click();
        asg.LinkInputBox().sendKeys("www.google.com");
        asg.AddLinkSubmit().click();

        for(WebElement webElement:asg.FileTypes()){
            webElement.click();
            Thread.sleep(500);
        }
//        asg.AssignStudentsBtn().click();
//
//
//        asg.SelectStudentsBtn().click();
//
//        Thread.sleep(2000);
//        asg.SelectAllOption().click();
//
//        asg.AddStudentsBtn().click();

        asg.SaveAsDraft().click();

        Thread.sleep(2000);
//        asg.DraftsTabPage().click();
        boolean flag=false;
        for(WebElement webElement:asg.AssignmentNames()){
            if(webElement.getText().contains("Drafted Assignment")){
                flag= true;
                break;
            }
        }
        return DraftPageValidateTest(flag);
    }

    public boolean OngoingPageValidateTest(boolean flag){
        System.out.println(flag);
        if (flag) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherOngoingPageCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.asg = new Assignments(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        asg.rightswipemodules().click();
        Thread.sleep(1000);
        asg.rightswipemodules().click();

        asg.AssignmentsToggle().click();
        Thread.sleep(2000);

        asg.CreateNewBtn().click();

        asg.AssignmentName().click();
        asg.AssignmentName().sendKeys("New Assignment");

        Select AssignmentSubject = new Select(asg.AssignmentSubject());
        AssignmentSubject.selectByIndex(1);

        Select AssignmentRewardType = new Select(asg.AssignmentRewardType());
        AssignmentRewardType.selectByIndex(1);
//        Select AssignmentType = new Select(asg.AssignmentType());
//        AssignmentType.selectByIndex(1);
//        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();

        asg.AssignmentDetailsSubmitBtn().click();

        asg.QuestionDescription().click();
        asg.QuestionDescription().sendKeys("Question");

        asg.AttachLink().click();
        asg.LinkInputBox().click();
        asg.LinkInputBox().sendKeys("www.google.com");
        asg.AddLinkSubmit().click();

        for(WebElement webElement:asg.FileTypes()){
            webElement.click();
            Thread.sleep(500);
        }
        asg.FileSizeLimit().click();
        asg.FileSizeLimit().sendKeys("1");

        asg.AssignStudentsBtn().click();
        Thread.sleep(2000);

        asg.SelectStudentsBtn().click();
        Thread.sleep(2000);

        asg.SelectAllOption().click();

        asg.AddStudentsBtn().click();

        asg.ScheduleBtn().click();
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
        String str = formatter.format(date);
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

        asg.StartDateInputBox().click();
        asg.StartDateInputBox().sendKeys(currdate);
        asg.StartDateInputBox().sendKeys(currmonth);
        asg.StartDateInputBox().sendKeys(curryear);
        Thread.sleep(2000);
        asg.EndDateInputBox().click();
        asg.EndDateInputBox().sendKeys(enddate);
        asg.EndDateInputBox().sendKeys(endmonth);
        asg.EndDateInputBox().sendKeys(endyear);

        WebElement InstructionsTextBox = driver.findElement(By.xpath("//textarea"));

        InstructionsTextBox.click();
        InstructionsTextBox.sendKeys("instructions");

        asg.PublishBtn().click();

        Thread.sleep(2000);
        asg.OngoingTabPage().click();
        boolean flag=true;
        for(WebElement webElement:asg.AssignmentStatus()){
            if(!webElement.getText().contains("Ongoing")){
                flag= false;
                break;
            }
        }
        return OngoingPageValidateTest(flag);
    }


    public boolean ScheduledPageValidateTest(boolean flag){
        System.out.println(flag);
        if (flag) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherScheduledPageCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.asg = new Assignments(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        asg.rightswipemodules().click();
        Thread.sleep(1000);
        asg.rightswipemodules().click();

        asg.AssignmentsToggle().click();
        Thread.sleep(2000);

        asg.CreateNewBtn().click();

        Thread.sleep(2000);
        asg.AssignmentName().click();
        asg.AssignmentName().sendKeys("New Assignment");

//        System.out.println(1);
        Select AssignmentSubject = new Select(asg.AssignmentSubject());
        AssignmentSubject.selectByIndex(1);
        Thread.sleep(2000);

//        System.out.println(2);
        Select AssignmentRewardType = new Select(asg.AssignmentRewardType());
        AssignmentRewardType.selectByIndex(1);
        Thread.sleep(2000);

//        System.out.println(3);
//        Select AssignmentType = new Select(asg.AssignmentType());
//        AssignmentType.selectByIndex(1);
//        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();


//        System.out.println(4);
        asg.AssignmentDetailsSubmitBtn().click();

        asg.QuestionDescription().click();
        asg.QuestionDescription().sendKeys("Question");

        asg.AttachLink().click();
        asg.LinkInputBox().click();
        asg.LinkInputBox().sendKeys("www.google.com");
        asg.AddLinkSubmit().click();

        for(WebElement webElement:asg.FileTypes()){
            webElement.click();
            Thread.sleep(500);
        }

        asg.FileSizeLimit().click();
        asg.FileSizeLimit().sendKeys("1");

        asg.AssignStudentsBtn().click();
        Thread.sleep(2000);
        asg.SelectStudentsBtn().click();

        Thread.sleep(2000);
        asg.SelectAllOption().click();

        asg.AddStudentsBtn().click();

        asg.ScheduleBtn().click();
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

        asg.StartDateInputBox().click();
        asg.StartDateInputBox().sendKeys(currdate);
        asg.StartDateInputBox().sendKeys(currmonth);
        asg.StartDateInputBox().sendKeys(curryear);
        Thread.sleep(2000);
        asg.EndDateInputBox().click();
        asg.EndDateInputBox().sendKeys(enddate);
        asg.EndDateInputBox().sendKeys(endmonth);
        asg.EndDateInputBox().sendKeys(endyear);

        WebElement InstructionsTextBox = driver.findElement(By.xpath("//textarea"));

        InstructionsTextBox.click();
        InstructionsTextBox.sendKeys("instructions");

        asg.PublishBtn().click();

        Thread.sleep(2000);
        boolean flag=true;
        for(WebElement webElement:asg.AssignmentStatus()){
            if(!webElement.getText().contains("Scheduled")){
                flag= false;
                break;
            }
        }
        return ScheduledPageValidateTest(flag);
    }


    public boolean LandingPageValidateTest(String actual_header, String expected_header){
        System.out.println(actual_header+"\n"+expected_header);
        if (actual_header.contains(expected_header)) {
            System.out.println("Assignments Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.asg = new Assignments(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        asg.rightswipemodules().click();
        Thread.sleep(1000);
        asg.rightswipemodules().click();

        asg.AssignmentsToggle().click();
        Thread.sleep(2000);

        String actual_header = asg.GetHeader();
        Thread.sleep(1000);
        String expected_header = "Assignments";
        return LandingPageValidateTest(actual_header, expected_header);
    }
    public boolean studentLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.asg = new Assignments(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        asg.StudentImageClick().click();
        asg.AssignmentsToggle().click();

        String actual_header = asg.GetHeader();
        String expected_header = "Scheduled Assignments";
        return LandingPageValidateTest(actual_header, expected_header);
    }

    public boolean CreateAssignmentValidateTest(boolean flag){
        System.out.println(flag);
        if (flag) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherCreateAssignmentCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.asg = new Assignments(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        asg.rightswipemodules().click();
        Thread.sleep(1000);
        asg.rightswipemodules().click();

        asg.AssignmentsToggle().click();
        Thread.sleep(2000);

        asg.CreateNewBtn().click();

        asg.AssignmentName().click();
        asg.AssignmentName().sendKeys("New Assignment");

        Select AssignmentSubject = new Select(asg.AssignmentSubject());
        AssignmentSubject.selectByIndex(1);

        Select AssignmentRewardType = new Select(asg.AssignmentRewardType());
        AssignmentRewardType.selectByIndex(1);
//        Select AssignmentType = new Select(asg.AssignmentType());
//        AssignmentType.selectByIndex(1);
//        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();

        asg.AssignmentDetailsSubmitBtn().click();

        asg.QuestionDescription().click();
        asg.QuestionDescription().sendKeys("Question");

        asg.AttachLink().click();
        asg.LinkInputBox().click();
        asg.LinkInputBox().sendKeys("www.google.com");
        asg.AddLinkSubmit().click();

        for(WebElement webElement:asg.FileTypes()){
            webElement.click();
            Thread.sleep(500);
        }
        asg.FileSizeLimit().click();
        asg.FileSizeLimit().sendKeys("1");

        asg.AssignStudentsBtn().click();
        Thread.sleep(2000);

        asg.SelectStudentsBtn().click();
        Thread.sleep(2000);

        asg.SelectAllOption().click();

        asg.AddStudentsBtn().click();

        asg.ScheduleBtn().click();
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

        asg.StartDateInputBox().click();
        asg.StartDateInputBox().sendKeys(currdate);
        asg.StartDateInputBox().sendKeys(currmonth);
        asg.StartDateInputBox().sendKeys(curryear);
        Thread.sleep(2000);
        asg.EndDateInputBox().click();
        asg.EndDateInputBox().sendKeys(enddate);
        asg.EndDateInputBox().sendKeys(endmonth);
        asg.EndDateInputBox().sendKeys(endyear);

        WebElement InstructionsTextBox = driver.findElement(By.xpath("//textarea"));

        InstructionsTextBox.click();
        InstructionsTextBox.sendKeys("instructions");

        asg.PublishBtn().click();

        Thread.sleep(3000);
        List<WebElement> assignments = driver.findElements(By.xpath("//h1"));

        boolean flag=false;
        for(WebElement webElement:assignments){
            if(webElement.getText().contains("New Assignment")){
                flag = true;
                break;
            }
        }
        return CreateAssignmentValidateTest(flag);
    }

    public boolean teacherCreateAssignmentForStudentCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.asg = new Assignments(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        asg.rightswipemodules().click();
        Thread.sleep(1000);
        asg.rightswipemodules().click();

        asg.AssignmentsToggle().click();
        Thread.sleep(2000);

        asg.CreateNewBtn().click();
//
        Thread.sleep(2000);
        asg.AssignmentName().click();
        asg.AssignmentName().sendKeys("New Assignment");

//        System.out.println(1);
        Select AssignmentSubject = new Select(asg.AssignmentSubject());
        AssignmentSubject.selectByIndex(1);
        Thread.sleep(2000);

//        System.out.println(2);
        Select AssignmentRewardType = new Select(asg.AssignmentRewardType());
        AssignmentRewardType.selectByIndex(1);
        Thread.sleep(2000);

//        System.out.println(3);
//        Select AssignmentType = new Select(asg.AssignmentType());
//        AssignmentType.selectByIndex(1);
//        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();


//        System.out.println(4);
        asg.AssignmentDetailsSubmitBtn().click();

        asg.QuestionDescription().click();
        asg.QuestionDescription().sendKeys("Question");

        asg.AttachLink().click();
        asg.LinkInputBox().click();
        asg.LinkInputBox().sendKeys("www.google.com");
        asg.AddLinkSubmit().click();

        for(WebElement webElement:asg.FileTypes()){
            webElement.click();
            Thread.sleep(500);
        }

        asg.FileSizeLimit().click();
        asg.FileSizeLimit().sendKeys("1");

        asg.AssignStudentsBtn().click();
        Thread.sleep(2000);
        asg.SelectStudentsBtn().click();

        Thread.sleep(2000);
        asg.SelectAllOption().click();

        asg.AddStudentsBtn().click();

        asg.ScheduleBtn().click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[@for='individual']")).click();


        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String str = formatter.format(date);

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

        Calendar cal = Calendar.getInstance();
        try{
            cal.setTime(formatter.parse(str));
        }catch(ParseException e){
            e.printStackTrace();
        }

        // use add() method to add the days to the given date
        cal.add(Calendar.DAY_OF_MONTH, 2);
        String dateAfter = formatter.format(cal.getTime());

        String enddate = dateAfter.split("/")[0];
        String endmonth = dateAfter.split("/")[1];
        String endyear = dateAfter.split("/")[2];

        asg.StartDateInputBox().click();
        asg.StartDateInputBox().sendKeys(currdate);
        asg.StartDateInputBox().sendKeys(currmonth);
        asg.StartDateInputBox().sendKeys(curryear);

        asg.EndDateInputBox().click();
        asg.EndDateInputBox().sendKeys(enddate);
        asg.EndDateInputBox().sendKeys(endmonth);
        asg.EndDateInputBox().sendKeys(endyear);

        WebElement InstructionsTextBox = driver.findElement(By.xpath("//textarea"));

        InstructionsTextBox.click();
        InstructionsTextBox.sendKeys("instructions");

        asg.PublishBtn().click();


        return true;
    }

    List<String> PaginationText = List.of("1 - 10", "11 - 20", "21 - 30", "31 - 40", "41 - 50", "51 - 60", "61 - 70", "71 - 80", "81 - 90", "91 - 100", "101 - 120");
    public boolean CheckEnabled(WebElement nextNavigate) {
        return !nextNavigate.getAttribute("class").contains("disabled");
    }

    public boolean PaginationValidateTest(String Actual_Text, String Expected_Text) {
        System.out.println(Actual_Text + " "+ Expected_Text);
        return Actual_Text.contains(Expected_Text);
    }

    public boolean studentPaginationCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.asg = new Assignments(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        asg.AssignmentsToggle().click();

        boolean flag1 = true, flag2 = true, flag3 = true, flag4 = true;
        String CurrPaginationText;
        int i=0;
        // one click forward
        if(CheckEnabled(asg.NextNavigate())){
            asg.NextNavigate().click(); Thread.sleep(2000);
            i+=1;
            CurrPaginationText = asg.PaginationText().getText(); Thread.sleep(2000);
            flag1= PaginationValidateTest(CurrPaginationText, PaginationText.get(i)); Thread.sleep(2000);
        }

        // two clicks forward
        if(CheckEnabled(asg.NextNavigate())) {
            asg.NextNavigate().click(); Thread.sleep(2000);
            i+=1;
            if(CheckEnabled(asg.NextNavigate())){
                asg.NextNavigate().click(); Thread.sleep(2000);
                i+=1;
            }
            CurrPaginationText = asg.PaginationText().getText(); Thread.sleep(2000);
            flag2= PaginationValidateTest(CurrPaginationText, PaginationText.get(i)); Thread.sleep(2000);
        }



        // one click back
        if(CheckEnabled(asg.BackNavigate())){
            asg.BackNavigate().click(); Thread.sleep(2000);
            i-=1;
            CurrPaginationText = asg.PaginationText().getText();
            flag3= PaginationValidateTest(CurrPaginationText, PaginationText.get(i));
        }

        // two click back
        if(CheckEnabled(asg.BackNavigate())){
            asg.BackNavigate().click(); Thread.sleep(2000);
            i-=1;
            if(CheckEnabled(asg.BackNavigate())){
                asg.BackNavigate().click(); Thread.sleep(2000);
                i-=1;
            }
            CurrPaginationText = asg.PaginationText().getText();
            flag4= PaginationValidateTest(CurrPaginationText, PaginationText.get(i));
        }


        if(flag1 && flag2 && flag3 && flag4){
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean StartAssignmentValidateTest(boolean flag1, boolean flag2){
        System.out.println(flag1+" "+flag2);
        if (flag1 && flag2) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }
    public boolean studentStartAssignment(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.asg = new Assignments(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);

        asg.AssignmentsToggle().click();

        asg.FirstAssignment().click();

        asg.startAssignment().click();
        Thread.sleep(2000);
        asg.AttachFileInputBox().click();
        asg.AttachFileInputBox().sendKeys("www.sample.com");

        asg.AssignmentAnswerInputBox().click();
        Thread.sleep(2000);
        asg.AssignmentAnswerInputBox().sendKeys("Answer");
        Thread.sleep(2000);

        asg.submitAssignment().click();

        asg.GoToDashboardBtn().click();
        Thread.sleep(2000);

        asg.FirstAssignment().click();
        Thread.sleep(2000);
        String contentDisplayed = asg.mainContent().getText();

        System.out.println(contentDisplayed);
        boolean flag1 = contentDisplayed.contains("sample.com");
        boolean flag2 = contentDisplayed.contains("Answer");

        return StartAssignmentValidateTest(flag1, flag2);
    }


}
