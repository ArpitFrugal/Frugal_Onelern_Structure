package executions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.Attendance;
import pageObjects.LoginPage;
import resources.BaseLogin;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendanceMethods extends BaseLogin {

    public Attendance att;
    public LoginPage log;
    public WebDriver driver;

    public AttendanceMethods(WebDriver driver2) {
        super(driver2);
    }


    public boolean LandingPageValidateTest(String actual_header){
        if (actual_header.contains("Attendance")) {
            System.out.println("Attendance Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean studentLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.att = new Attendance(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        String actual_header = att.GetHeader().getText();
        return LandingPageValidateTest(actual_header);
    }

    public boolean teacherLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.att = new Attendance(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        String actual_header = att.GetHeader().getText();
        return LandingPageValidateTest(actual_header);
    }


    // PALH

    public boolean AttendancePALHValidateTest(boolean flag){
        if (flag) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }
    public boolean valCompare(int presentCount, int daysPresent) {
        return presentCount == daysPresent;
    }

    public boolean studentPALHCountCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.att = new Attendance(driver);
        boolean flag1, flag2, flag3, flag4;
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        String presentcounttext = att.presentCountStudent().getText();
        String absentcounttext = att.absentCountStudent().getText();;
        String leavecounttext = att.leaveCountStudent().getText();
        String holidaycounttext = att.holidayCountStudent().getText();

        int presentCount = Integer.parseInt(presentcounttext.split(" ")[1]);
        int absentCount = Integer.parseInt(absentcounttext.split(" ")[1]);
        int leaveCount = Integer.parseInt(leavecounttext.split(" ")[1]);
        int holidayCount = Integer.parseInt(holidaycounttext.split(" ")[1]);

        int dayspresent = att.presentMarksStudent().size();
        int daysabsent = att.absentMarksStudent().size();
        int daysleave = att.leaveMarksStudent().size();
        int daysholiday = att.holidayMarksStudent().size();

        flag1 = valCompare(presentCount, dayspresent);
        flag2 = valCompare(absentCount, daysabsent);
        flag3 = valCompare(leaveCount, daysleave);
        flag4 = valCompare(holidayCount, daysholiday);


        return AttendancePALHValidateTest(flag1 && flag2 && flag3 && flag4);
    }

    public boolean teacherPALCountCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.att = new Attendance(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        boolean markedForToday = att.notMarkedTeacher().size() >0;
        if(!markedForToday){
            driver.findElement(By.xpath("//*[contains(@class,'active')]")).click();
            Thread.sleep(2000);
            int totalcount = Integer.parseInt(att.totalCountTeacher().getText().split(" ")[2]);
            int presentcount = Integer.parseInt(att.presentCountTeacher().getText().split(" ")[1]);
            int absentcount = Integer.parseInt(att.absentCountTeacher().getText().split(" ")[1]);
            int leavecount = Integer.parseInt(att.leaveCountTeacher().getText().split(" ")[1]);
            System.out.println(totalcount+" "+presentcount+" "+absentcount+" "+leavecount);
            return AttendancePALHValidateTest(totalcount == presentcount+absentcount+leavecount);

        }
        else{
            att.editAttendanceBtn().click();
            driver.findElement(By.xpath("//*[contains(@class,'present-mark-box')]")).click();
            WebElement element = att.attendancemarkoption();
            js.executeScript("arguments[0].scrollIntoView();", element);
            element.click();

            Thread.sleep(2000);
            att.absentmarkoption().click();
            Thread.sleep(2000);

            att.attendancemarkoption().click();
            Thread.sleep(2000);
            att.leavemarkoption().click();
            Thread.sleep(2000);

            att.saveBtn().click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[contains(@class,'active')]/*[contains(@class,'week-day')]")).click();
            Thread.sleep(2000);

            System.out.println(Arrays.toString(att.presentCountTeacher().getText().split(" ")));
            int totalcount = Integer.parseInt(att.totalCountTeacher().getText().split(" ")[2]);
            int presentcount = Integer.parseInt(att.presentCountTeacher().getText().split(" ")[1]);
            int absentcount = Integer.parseInt(att.absentCountTeacher().getText().split(" ")[1]);
            int leavecount = Integer.parseInt(att.leaveCountTeacher().getText().split(" ")[1]);
            System.out.println(totalcount+" "+presentcount+" "+absentcount+" "+leavecount);
            return AttendancePALHValidateTest(totalcount == presentcount+absentcount+leavecount);
        }
    }

    // mark holiday
    private boolean MarkHolidayBtnValidateTest(int actual, int expected) {
        if(actual == expected){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean teacherMarkHolidayCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.att = new Attendance(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        boolean markedForToday = att.notMarkedTeacher().size() > 0;

        if(!markedForToday){
            att.markasholidayBtn().click();
            return MarkHolidayBtnValidateTest(att.holidayMarksTeacher().size(), Integer.parseInt(att.totalCountTeacher().getText().split(" ")[2]));
        }
        else{
            System.out.println("Attendance already marked for the day.");
            att.markasholidayBtn().click();
            boolean flag = MarkHolidayBtnValidateTest(att.holidayMarksTeacher().size(), Integer.parseInt(att.totalCountTeacher().getText().split(" ")[2]));
            att.markasholidayBtn().click();
            return flag;
        }
    }
    
    
    // Percentage Check
    Map<String, Integer> NonWorkingDays  = new HashMap<String, Integer>() {{ 
        put("June 2022", 4); put("July 2022", 5); put("August 2022", 4);
        put("September 2022", 4); put("October 2022", 5); put("November 2022", 4);
        put("December 2022", 4); put("January 2023", 5); put("February 2023", 4);
        put("March 2023", 4); put("April 2023", 5); put("May 2023", 4);
    }};
    private boolean PercentageValidateTest(int calculated, int displayed) {
        System.out.println(calculated +" "+displayed);
        if(calculated == displayed){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean studentPercentageCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.att = new Attendance(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        int attendancePercentage = Integer.parseInt(att.AttendancePercentage().getText().split(" ")[1].split("%")[0]);
        int totaldaysinmonth = att.AllDaysList().size();

        int totalWorkingDays = totaldaysinmonth - NonWorkingDays.get(att.DisplayedMonthStudent().getText()) - att.holidayMarksStudent().size();

        int numberOfPresentDays = att.presentMarksStudent().size();
        return PercentageValidateTest((int)(((float)numberOfPresentDays/totalWorkingDays)*100), attendancePercentage);
//        ValidateTest(Math.round((float)numberOfPresentDays/totalWorkingDays), attendancePercentage);
    }
    
    // Pagination
    List<String> months = List.of("June 2022", "July 2022", "August 2022", "September 2022", "October 2022",
            "November 2022", "December 2022", "January 2023", "February 2023", "March 2023", "April 2023", "May 2023");
    public boolean ValidateMonth(String actual_month, String expected_month){
        System.out.println(actual_month+" "+expected_month);
        if (actual_month.contains(expected_month)) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }
    private boolean PaginationValidateTest(boolean flag) {
        if(flag){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean studentPaginationCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.att = new Attendance(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        String CurrMonthDisplayed = att.DisplayedMonthStudent().getText();
        int monthindex = months.indexOf(CurrMonthDisplayed);
        boolean flag1, flag2, flag3;
        att.PaginationLeftBtn().click();
        flag1= ValidateMonth(att.DisplayedMonthStudent().getText(), months.get(monthindex-1));

        att.PaginationLeftBtn().click();
        flag2= ValidateMonth(att.DisplayedMonthStudent().getText(), months.get(monthindex-2));

        att.PaginationRightBtn().click();
        flag3 = ValidateMonth(att.DisplayedMonthStudent().getText(), months.get(monthindex-1));

        return PaginationValidateTest(flag1 && flag2 && flag3);
    }

    public boolean teacherPaginationCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.att = new Attendance(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        att.AttendanceToggle().click();
        Thread.sleep(2000);

        String CurrMonthDisplayed = att.DisplayedMonthTeacher().getAttribute("value");
        int monthindex = months.indexOf(CurrMonthDisplayed);
        boolean flag1, flag2, flag3;
        att.PaginationLeftBtn().click();
        flag1= ValidateMonth(att.DisplayedMonthTeacher().getAttribute("value"), months.get(monthindex-1));
        Thread.sleep(5000);
        att.PaginationLeftBtn().click();
        flag2= ValidateMonth(att.DisplayedMonthTeacher().getAttribute("value"), months.get(monthindex-2));
        Thread.sleep(5000);
        att.PaginationRightBtn().click();
        flag3 = ValidateMonth(att.DisplayedMonthTeacher().getAttribute("value"), months.get(monthindex-1));

        return PaginationValidateTest(flag1 && flag2 && flag3);
    }
}
