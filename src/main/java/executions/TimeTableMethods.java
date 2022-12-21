package executions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.Analytics;
import pageObjects.LoginPage;
import pageObjects.TimeTable;
import resources.BaseLogin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeTableMethods extends BaseLogin {
    public TimeTable tim;
    public LoginPage log;
    public WebDriver driver;

    public TimeTableMethods(WebDriver driver2) {
        super(driver2);
    }


    public boolean AdminCreateEventValidateTest(boolean flag) {
        System.out.println(flag);
        if(flag){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean adminCreateEventCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.EventsTab().click();
        tim.CreateNewEvent().click();

        tim.EventName().click();
        tim.EventName().sendKeys("New Event");

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

        tim.startDate().click();
        tim.startDate().sendKeys(currdate);
        tim.startDate().sendKeys(currmonth);
        tim.startDate().sendKeys(curryear);

        tim.endDate().click();
        tim.endDate().sendKeys(enddate);
        tim.endDate().sendKeys(endmonth);
        tim.endDate().sendKeys(endyear);

        // time
        tim.startTime().click();
        tim.startTime().sendKeys("08");
        tim.startTime().sendKeys("00");
        tim.startTime().sendKeys("a");

        tim.endTime().click();
        tim.endTime().sendKeys("03");
        tim.endTime().sendKeys("00");
        tim.endTime().sendKeys("p");

        tim.CreateEventBtn().click();

        List<WebElement> AllEventsName = tim.AllEventsName();
        boolean flag = false;

        for(WebElement webElement: AllEventsName){
            if(webElement.getText().contains("New Event")){
                flag = true;
                break;
            }
        }

        return AdminCreateEventValidateTest(flag);
    }

    public boolean AdminCreateHolidayValidateTest(boolean flag) {
        System.out.println(flag);
        if(flag){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean adminCreateHolidayCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.HolidaysTab().click();
        tim.CreateNewHoliday().click();

        tim.HolidayName().click();
        tim.HolidayName().sendKeys("New Holiday");
//        tim.Holidaydesc().click();
//        tim.Holidaydesc().sendKeys("Event description");

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

        tim.startDate().click();
        tim.startDate().sendKeys(currdate);
        tim.startDate().sendKeys(currmonth);
        tim.startDate().sendKeys(curryear);

        tim.endDate().click();
        tim.endDate().sendKeys(enddate);
        tim.endDate().sendKeys(endmonth);
        tim.endDate().sendKeys(endyear);



        tim.CreateHolidayBtn().click();

        List<WebElement> AllHolidaysName = tim.AllHolidaysName();
        boolean flag = false;

        for(WebElement webElement: AllHolidaysName){
            if(webElement.getText().contains("New Holiday")){
                flag = true;
                break;
            }
        }

        return AdminCreateHolidayValidateTest(flag);
    }


    public boolean AdminCreateTemplateValidateTest(boolean flag) {
        System.out.println(flag);
        if(flag){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }


    public boolean adminCreateTemplateCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.TemplatesBtn().click();

        tim.CreateTemplate().click();

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy hh.mm aa");
        String CurrDate = formatter.format(date);
        String CurrDate1 = formatter1.format(date);

        tim.templateName().click();
        tim.templateName().sendKeys("New Template " + CurrDate1);

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

        tim.startDate().click();
        tim.startDate().sendKeys(currdate);
        tim.startDate().sendKeys(currmonth);
        tim.startDate().sendKeys(curryear);

        tim.endDate().click();
        tim.endDate().sendKeys(enddate);
        tim.endDate().sendKeys(endmonth);
        tim.endDate().sendKeys(endyear);

        // time
        tim.startTime().click();
        tim.startTime().sendKeys("08");
        tim.startTime().sendKeys("00");
        tim.startTime().sendKeys("a");

        tim.endTime().click();
        tim.endTime().sendKeys("03");
        tim.endTime().sendKeys("00");
        tim.endTime().sendKeys("p");


        tim.SelectWeekHoliday().click();
        tim.Weekday().click();

        tim.NextButton().click();
        Thread.sleep(2000);
        tim.AddMoreSessionsBtn().click();

        tim.Session1Name().click();
        tim.Session1Name().sendKeys("Session1");

        tim.Session2Name().click();
        tim.Session2Name().sendKeys("Session2");
        Thread.sleep(2000);

        Select sessiontype1 = new Select(tim.Session1sessiontype());
        sessiontype1.selectByIndex(1);
        Thread.sleep(2000);
        Select sessiontype2 = new Select(tim.Session2sessiontype());
        sessiontype2.selectByIndex(1);

        Thread.sleep(2000);
        tim.Session1endTime().click();
        Thread.sleep(1000);
        tim.Session1endTime().sendKeys("09");
        Thread.sleep(1000);
        tim.Session1endTime().sendKeys("00");
        tim.Session1endTime().sendKeys("a");

        Thread.sleep(2000);
        tim.Session2endTime().click();
        Thread.sleep(1000);
        tim.Session2endTime().sendKeys("10");
        tim.Session2endTime().sendKeys("00");
        tim.Session2endTime().sendKeys("a");

        tim.CreateTemplateSubmitBtn().click();
        Thread.sleep(3000);
        tim.backBtn().click();

        boolean flag=false;
        for(WebElement webElement:tim.TemplateCards()){
            if(webElement.getText().contains("New Template")){
                flag = true;
                break;
            }
        }

        List<WebElement> TemplateCards = driver.findElements(By.xpath("//*[contains(@class, 'menu-icon')]"));

        TemplateCards.get(TemplateCards.size()-1).click();
        tim.DeleteBtn().click();
        tim.ConfirmDelete().click();

        return AdminCreateTemplateValidateTest(flag);
    }

    public boolean AdminDeleteEventValidateTest(int before, int after) {
        System.out.println(before+" "+after);
        if(before == after + 1){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean adminDeleteEventCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.EventsTab().click();

        Thread.sleep(1000);
        List<WebElement> AllEventsName = tim.AllEventsName();

        Thread.sleep(1000);
        int beforeEventsCount = AllEventsName.size();
        driver.findElement(By.xpath("//*[contains(@class, 'menu-icon')]")).click();
        Thread.sleep(1000);
        tim.EventsDeleteBtn().click();
        tim.ConfirmDelete().click();
        Thread.sleep(1000);
        int afterEventsCount = tim.AllEventsName().size();

        return AdminDeleteEventValidateTest(beforeEventsCount, afterEventsCount);
    }

    public boolean AdminDeleteHolidayValidateTest(int before, int after) {
        System.out.println(before+" "+after);
        if(before == after + 1){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean adminDeleteHolidayCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.HolidaysTab().click();
        tim.HolidaySearchBox().click();
        tim.HolidaySearchBox().sendKeys("New");

        Thread.sleep(1000);
        List<WebElement> AllHolidaysName = tim.AllHolidaysName();

        Thread.sleep(1000);
        int beforeEventsCount = AllHolidaysName.size();
        driver.findElement(By.xpath("//*[contains(@class, 'menu-icon')]")).click();
        Thread.sleep(1000);
        tim.HolidaysDeleteBtn().click();
        tim.ConfirmDelete().click();
        Thread.sleep(1000);
        int afterEventsCount = tim.AllEventsName().size();

        return AdminDeleteHolidayValidateTest(beforeEventsCount, afterEventsCount);
    }

    public boolean DeleteTemplateValidateTest(int before, int after) {
        System.out.println(before+" "+after);
        if(before > after){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }


    public boolean adminDeleteTemplateCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();
        Thread.sleep(2000);
        tim.TemplatesBtn().click();

        tim.CreateTemplate().click();

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy hh.mm aa");
        String CurrDate = formatter.format(date);
        String CurrDate1 = formatter1.format(date);

        tim.templateName().click();
        tim.templateName().sendKeys("New Template " + CurrDate1);
//        tim.templateName().sendKeys("Newtemplate1");

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

        tim.startDate().click();
        tim.startDate().sendKeys(currdate);
        tim.startDate().sendKeys(currmonth);
        tim.startDate().sendKeys(curryear);

        tim.endDate().click();
        tim.endDate().sendKeys(enddate);
        tim.endDate().sendKeys(endmonth);
        tim.endDate().sendKeys(endyear);

        // time
        tim.startTime().click();
        tim.startTime().sendKeys("08");
        tim.startTime().sendKeys("00");
        tim.startTime().sendKeys("a");

        tim.endTime().click();
        tim.endTime().sendKeys("03");
        tim.endTime().sendKeys("00");
        tim.endTime().sendKeys("p");


        tim.SelectWeekHoliday().click();
        tim.Weekday().click();

        tim.NextButton().click();
        Thread.sleep(2000);
        tim.AddMoreSessionsBtn().click();

        tim.Session1Name().click();
        tim.Session1Name().sendKeys("Session1");

        tim.Session2Name().click();
        tim.Session2Name().sendKeys("Session2");

        Select sessiontype1 = new Select(tim.Session1sessiontype());
        sessiontype1.selectByIndex(1);
        Select sessiontype2 = new Select(tim.Session2sessiontype());
        sessiontype2.selectByIndex(1);

        Thread.sleep(2000);
        tim.Session1endTime().click();
        tim.Session1endTime().sendKeys("09");
        tim.Session1endTime().sendKeys("00");
        tim.Session1endTime().sendKeys("a");

        Thread.sleep(1000);
        tim.Session2endTime().click();
        tim.Session2endTime().sendKeys("10");
        tim.Session2endTime().sendKeys("00");
        tim.Session2endTime().sendKeys("a");

        tim.CreateTemplateSubmitBtn().click();
        Thread.sleep(2000);
        tim.backBtn().click();


        List<WebElement> TemplateCards = driver.findElements(By.xpath("//*[contains(@class, 'menu-icon')]"));
        int BeforeCount = TemplateCards.size();
        TemplateCards.get(BeforeCount-1).click();
        Thread.sleep(2000);
        tim.DeleteBtn().click();
        Thread.sleep(1000);
        tim.ConfirmDelete().click();
        Thread.sleep(2000);
        int AfterCount = driver.findElements(By.xpath("//*[contains(@class, 'menu-icon')]")).size();

        return DeleteTemplateValidateTest(BeforeCount, AfterCount);
    }

    public boolean AdminEditEventValidateTest(String actualHeading, String expectedHeading) {
        System.out.println(actualHeading+" "+expectedHeading);
        if(actualHeading.contains(expectedHeading)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean adminEditEventCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.EventsTab().click();

        List<WebElement> AllEventsName = tim.AllEventsName();

        WebElement FirstEvent = AllEventsName.get(0);
        String FirstEventName = FirstEvent.getText();

        driver.findElement(By.xpath("//*[contains(@class, 'menu-icon')]")).click();
        tim.EventsEditBtn().click();
        Thread.sleep(1000);

        String displayedEventName = tim.EventName().getAttribute("value");

//System.out.println(displayedEventName);
        return AdminEditEventValidateTest(FirstEventName, displayedEventName);
    }

    public boolean AdminEditHolidayValidateTest(String actualHeading, String expectedHeading) {
        System.out.println(actualHeading+" "+expectedHeading);
        if(actualHeading.contains(expectedHeading)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean adminEditHolidayCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.HolidaysTab().click();

        List<WebElement> AllHolidaysName = tim.AllHolidaysName();

        WebElement FirstHoliday = AllHolidaysName.get(0);
        String FirstHolidayName = FirstHoliday.getText();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@class, 'menu-icon')]")).click();
        tim.HolidaysEditBtn().click();
        Thread.sleep(1000);

        String displayedEventName = tim.HolidayName().getAttribute("value");


//System.out.println(displayedEventName);
        return AdminEditHolidayValidateTest(FirstHolidayName, displayedEventName);
    }

    public boolean adminLandingPageValidateTest(String actualHeading, String expectedHeading) {
        System.out.println(actualHeading+" "+expectedHeading);
        if(actualHeading.contains(expectedHeading)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean adminLandingPageCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        String actualHeading = tim.adminTimetableModuleHeading().getText();
        String expectedHeading = "Timetable";

        return adminLandingPageValidateTest(actualHeading, expectedHeading);
    }

    public boolean AdminViewCalendarValidateTest(String actual, String expected) {
        System.out.println(actual+" "+expected);
        if(actual.contains(expected)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean adminViewCalendarCheck(WebDriver driver, String usermail, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("schooladmin", usermail, password);
        Thread.sleep(2000);

        tim.adminTimetableToggle().click();

        tim.timetableGrades().click();
        String TimetableSectionName = tim.TimetableSectionName().getText();
        String BtnText = tim.ViewOrAddTimetableBtn().getText();

        if(BtnText.contains("View")){
            tim.ViewOrAddTimetableBtn().click();
            String NavigationPath = tim.CurrentPagePath().getText();
            return AdminViewCalendarValidateTest(NavigationPath, TimetableSectionName);
        }
        else{
            tim.ViewOrAddTimetableBtn().click();
            String PageHeader = tim.CreateTemplatePageHeader().getText();
            return AdminViewCalendarValidateTest(PageHeader, TimetableSectionName);
        }
    }


    public boolean TimetableLandingPageValidateTest(String actual_header, String expected_header){
        if (actual_header.contains(expected_header)) {
            System.out.println("Time table Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean studentLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        tim.studentTimeTableToggle().click();
        Thread.sleep(2000);

        String actual_header = tim.GetHeader();
        String expected_header = "Timetable";
        return TimetableLandingPageValidateTest(actual_header, expected_header);
    }

    public boolean teacherLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        tim.rightswipemodules().click();
        Thread.sleep(1000);
        tim.rightswipemodules().click();
        Thread.sleep(1000);
        tim.rightswipemodules().click();

        tim.teacherTimeTableToggle().click();
        Thread.sleep(2000);

        String actual_header = tim.GetHeader();
        String expected_header = "Planner";
        return TimetableLandingPageValidateTest(actual_header, expected_header);
    }

    List<String> months = List.of("JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER",
            "NOVEMBER", "DECEMBER", "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY");

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

    private boolean PaginationValidateTest(boolean flag1, boolean flag2, boolean flag3) {
        System.out.println(flag1 +" "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }
    public boolean teacherPaginationCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);

        tim.rightswipemodules().click();
        Thread.sleep(1000);
        tim.rightswipemodules().click();
        Thread.sleep(1000);
        tim.rightswipemodules().click();

        tim.teacherTimeTableToggle().click();
        Thread.sleep(2000);

        String CurrMonthDisplayed = tim.DisplayedMonth().getText();
        int monthIndex = 0, i = 0;

        for(String st:months){
            if(CurrMonthDisplayed.contains(st)){
                monthIndex = i;
                break;
            }
            i+=1;
        }
        System.out.println(monthIndex);
        boolean flag1, flag2, flag3;
        tim.leftNavigationBtn().click();
        flag1= ValidateMonth(tim.DisplayedMonth().getText(), months.get(monthIndex-1));

        tim.leftNavigationBtn().click();
        flag2= ValidateMonth(tim.DisplayedMonth().getText(), months.get(monthIndex-2));

        tim.rightNavigationBtn().click();
        flag3 = ValidateMonth(tim.DisplayedMonth().getText(), months.get(monthIndex-1));

        return PaginationValidateTest(flag1, flag2, flag3);
    }
    public boolean studentPaginationCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        tim.studentTimeTableToggle().click();
        Thread.sleep(2000);

        String CurrMonthDisplayed = tim.DisplayedMonth().getText();
        int monthIndex = 0, i = 0;

        for(String st:months){
            if(CurrMonthDisplayed.contains(st)){
                monthIndex = i;
                break;
            }
            i+=1;
        }
        System.out.println(monthIndex);
        boolean flag1, flag2, flag3;
        tim.leftNavigationBtn().click();
        flag1= ValidateMonth(tim.DisplayedMonth().getText(), months.get(monthIndex-1));

        tim.leftNavigationBtn().click();
        flag2= ValidateMonth(tim.DisplayedMonth().getText(), months.get(monthIndex-2));

        tim.rightNavigationBtn().click();
        flag3 = ValidateMonth(tim.DisplayedMonth().getText(), months.get(monthIndex-1));

        return PaginationValidateTest(flag1, flag2, flag3);
    }

    private boolean ViewAllEventsValidateTest(boolean flag1, boolean flag2) {
        System.out.println(flag1 +" "+flag2);
        if(flag1 && flag2){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean studentViewEventsCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        tim.studentTimeTableToggle().click();
        Thread.sleep(2000);

        List<WebElement> ViewEventsHolidaysBtns = tim.ViewAllEventsHolidays();
        WebElement ViewAllEvents = ViewEventsHolidaysBtns.get(0);

        ViewAllEvents.click();

        boolean flag1, flag2;

        flag1 = tim.TemplateHeader().getText().contains("Events");

        flag2 = tim.EventsTab().getAttribute("class").contains("active");

        return ViewAllEventsValidateTest(flag1, flag2);
    }

    public boolean teacherViewEventsCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);

        tim.rightswipemodules().click();
        Thread.sleep(1000);
        tim.rightswipemodules().click();
        Thread.sleep(1000);
        tim.rightswipemodules().click();

        tim.teacherTimeTableToggle().click();
        Thread.sleep(2000);

        List<WebElement> ViewEventsHolidaysBtns = tim.ViewAllEventsHolidays();
        WebElement ViewAllEvents = ViewEventsHolidaysBtns.get(0);

        ViewAllEvents.click();

        boolean flag1, flag2;

        flag1 = tim.TemplateHeader().getText().contains("Events");

        flag2 = tim.EventsTab().getAttribute("class").contains("active");

        return ViewAllEventsValidateTest(flag1, flag2);
    }

    private boolean ViewAllHolidaysValidateTest(boolean flag1, boolean flag2) {
        System.out.println(flag1 +" "+flag2);
        if(flag1 && flag2){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean studentViewHolidaysCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        tim.studentTimeTableToggle().click();
        Thread.sleep(2000);

        List<WebElement> ViewEventsHolidaysBtns = tim.ViewAllEventsHolidays();
        WebElement ViewAllHolidays = ViewEventsHolidaysBtns.get(1);

        ViewAllHolidays.click();

        boolean flag1, flag2;

        flag1 = tim.TemplateHeader().getText().contains("Holidays");

        flag2 = tim.HolidaysTab().getAttribute("class").contains("active");

        return ViewAllHolidaysValidateTest(flag1, flag2);
    }

    public boolean teacherViewHolidaysCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.tim = new TimeTable(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);

        tim.rightswipemodules().click();
        Thread.sleep(1000);
        tim.rightswipemodules().click();
        Thread.sleep(1000);
        tim.rightswipemodules().click();

        tim.teacherTimeTableToggle().click();
        Thread.sleep(2000);

        List<WebElement> ViewEventsHolidaysBtns = tim.ViewAllEventsHolidays();
        WebElement ViewAllHolidays = ViewEventsHolidaysBtns.get(1);

        ViewAllHolidays.click();

        boolean flag1, flag2;

        flag1 = tim.TemplateHeader().getText().contains("Holidays");

        flag2 = tim.HolidaysTab().getAttribute("class").contains("active");

        return ViewAllHolidaysValidateTest(flag1, flag2);
    }


}
