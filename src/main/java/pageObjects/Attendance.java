package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.Base;

import java.util.List;

public class Attendance extends Base {
    public WebDriver driver;

    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
    By AttendanceToggle = By.id("attendance");
    By GetHeader = By.xpath("//*[@data-testid='module-name']");
    By presentMarksStudent = By.xpath("//*[contains(@class,'present ')]");
    By absentMarksStudent = By.xpath("//*[contains(@class,'absent ')]");
    By leaveMarksStudent = By.xpath("//*[contains(@class,'leave ')]");
    By holidayMarksStudent = By.xpath("//*[contains(@class,'holiday ')]");
    By presentCountStudent = By.xpath("//*[contains(@class,'present-tag')]/span[2]");
    By absentCountStudent = By.xpath("//*[contains(@class,'absent-tag')]/span[2]");
    By leaveCountStudent = By.xpath("//*[contains(@class,'leave-tag')]/span[2]");
    By holidayCountStudent = By.xpath("//*[contains(@class,'holidays-tag')]/span[2]");
    By holidayMarksTeacher =  By.xpath("//*[contains(@class,'active')]//button[contains(@class,'holiday')]");
    By presentMarksTeacher =  By.xpath("//*[contains(@class,'active')]//button[contains(@class,'present')]");
    By absentMarksTeacher = By.xpath("//*[contains(@class,'active')]//button[contains(@class,'absent')]");
    By leaveMarksTeacher = By.xpath("//*[contains(@class,'active')]//button[contains(@class,'leave')]");
    By notMarkedTeacher = By.xpath("//*[contains(@class,'active')]//button[contains(@class,'not-marked')]");
    By totalCountTeacher = By.xpath("//*[contains(@class,'total-students')]");
    By presentCountTeacher = By.xpath("//*[contains(@class,'present-students')]");
    By absentCountTeacher = By.xpath("//*[contains(@class,'absent-students')]");
    By leaveCountTeacher = By.xpath("//*[contains(@class,'leave-students')]");
    By editAttendanceBtn = By.xpath("//*[contains(@class,'edit-attendance-button')]");
    By markasholidayBtn = By.xpath("//*[contains(@class,'mark-as-holiday-button')]");
    By saveBtn = By.xpath("//button[@name='saveButton']");
    By attendancemarkoption = By.xpath("//*[contains(@class,'present-mark-box')]/div[contains(@class,'active')]/button[contains(@class,'present')]");
    By presentmarkoption = By.xpath("//*[contains(@class,'present-mark-box')]/div[2]/button[contains(@class,'present')]");
    By absentmarkoption = By.xpath("//*[contains(@class,'present-mark-box')]/div[2]/button[contains(@class,'absent')]");
    By leavemarkoption = By.xpath("//*[contains(@class,'present-mark-box')]/div[2]/button[contains(@class,'leave')]");


    By AttendancePercentage = By.xpath("//*[contains(@class,'at-cal-percentange')]");
    By AllDaysList = By.xpath("//*[contains(@class,'calendar ')]//span[contains(@class,'day') and not(contains(@class,'day-disabled')) and not(contains(@class,'day-name'))]");
    By DisplayedMonthStudent = By.xpath("//*[contains(@class,'at-date-txt')]");


    // Pagination
    By PaginationLeftBtn = By.xpath("//img[@alt='arrow-left']");
    By PaginationRightBtn = By.xpath("//img[@alt='arrow-right']");
    By DisplayedMonthTeacher = By.xpath("//*[contains(@class,'cal-box')]//input");



    public Attendance(WebDriver driver2) {
        this.driver = driver2;
    }

    @Step("Student account is selected...")
    public WebElement StudentImageClick() {
        return driver.findElement(StudentImageClick);
    }
    @Step("Doubts Module is opened...")
    public WebElement AttendanceToggle() { return driver.findElement(AttendanceToggle); }
    @Step("Fetching heading...")
    public WebElement GetHeader(){return driver.findElement(GetHeader);}
    @Step("Counting number of present marks on calendar...")
    public List<WebElement> presentMarksStudent(){return driver.findElements(presentMarksStudent);}
    @Step("Counting number of absent marks on calendar...")
    public List<WebElement> absentMarksStudent(){return driver.findElements(absentMarksStudent);}
    @Step("Counting number of leave marks on calendar...")
    public List<WebElement> leaveMarksStudent(){return driver.findElements(leaveMarksStudent);}
    @Step("Counting number of holiday marks on calendar...")
    public List<WebElement> holidayMarksStudent(){return driver.findElements(holidayMarksStudent);}
    @Step("Fetching not marked students for selected day...")
    public List<WebElement> notMarkedTeacher(){return driver.findElements(notMarkedTeacher);}
    @Step("Fetching number of days present count...")
    public WebElement presentCountStudent(){return driver.findElement(presentCountStudent);}
    @Step("Fetching number of days absent count...")
    public WebElement absentCountStudent(){return driver.findElement(absentCountStudent);}
    @Step("Fetching number of leave days count...")
    public WebElement leaveCountStudent(){return driver.findElement(leaveCountStudent);}
    @Step("Fetching number of holidays count...")
    public WebElement holidayCountStudent(){return driver.findElement(holidayCountStudent);}
    @Step("Counting number of holiday marks on calendar...")
    public List<WebElement> holidayMarksTeacher(){return driver.findElements(holidayMarksTeacher);}
    @Step("Counting number of present marks on calendar...")
    public List<WebElement> presentMarksTeacher(){return driver.findElements(presentMarksTeacher);}
    @Step("Counting number of absent marks on calendar...")
    public List<WebElement> absentMarksTeacher(){return driver.findElements(absentMarksTeacher);}
    @Step("Counting number of leave marks on calendar...")
    public List<WebElement> leaveMarksTeacher(){return driver.findElements(leaveMarksTeacher);}
    @Step("Fetching total number of students in the class...")
    public WebElement totalCountTeacher(){return driver.findElement(totalCountTeacher);}
    @Step("Fetching number of days present count...")
    public WebElement presentCountTeacher(){return driver.findElement(presentCountTeacher);}
    @Step("Fetching number of days absent count...")
    public WebElement absentCountTeacher(){return driver.findElement(absentCountTeacher);}
    @Step("Fetching number of days leave count...")
    public WebElement leaveCountTeacher(){return driver.findElement(leaveCountTeacher);}
    @Step("Clicked on edit attendance button...")
    public WebElement editAttendanceBtn(){return driver.findElement(editAttendanceBtn);}
    @Step("Clicked on mark as holiday button...")
    public WebElement markasholidayBtn(){return driver.findElement(markasholidayBtn);}
    @Step("Save button is clicked...")
    public WebElement saveBtn(){return driver.findElement(saveBtn);}
    @Step("Option for marking attendance is clicked...")
    public WebElement attendancemarkoption(){return driver.findElement(attendancemarkoption);}
    @Step("Option for marking present is clicked...")
    public WebElement presentmarkoption(){return driver.findElement(presentmarkoption);}
    @Step("Option for marking absent is clicked...")
    public WebElement absentmarkoption(){return driver.findElement(absentmarkoption);}
    @Step("Option for marking leave is clicked...")
    public WebElement leavemarkoption(){return driver.findElement(leavemarkoption);}
    @Step("Fetching the attendance percentage displayed...")
    public WebElement AttendancePercentage(){return driver.findElement(AttendancePercentage);}

    public List<WebElement> AllDaysList(){return driver.findElements(AllDaysList);}
    @Step
    public WebElement DisplayedMonthStudent(){return driver.findElement(DisplayedMonthStudent);}
    @Step
    public WebElement DisplayedMonthTeacher(){return driver.findElement(DisplayedMonthTeacher);}
    @Step
    public WebElement PaginationLeftBtn(){return driver.findElement(PaginationLeftBtn);}
    @Step
    public WebElement PaginationRightBtn(){return driver.findElement(PaginationRightBtn);}

}
