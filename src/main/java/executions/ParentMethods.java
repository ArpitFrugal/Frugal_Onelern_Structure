package executions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.LoginPage;
import pageObjects.Notebook;
import pageObjects.Parent;
import resources.BaseLogin;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ParentMethods extends BaseLogin {
    public Parent par;
    public LoginPage log;
    public WebDriver driver;


    public ParentMethods(WebDriver driver2) throws FileNotFoundException {
        super(driver2);
    }

    public boolean ParentStudentAttendanceCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.par = new Parent(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        par.StudentImageClick().click();
        Thread.sleep(2000);
        par.AttendanceToggle().click();
        Thread.sleep(2000);

        int attendancePercentage = Integer.parseInt(par.AttendancePercentage().getText().split(" ")[1].split("%")[0]);

        par.BackBtn().click();

        par.HomepageMenuBtn().click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement SwitchParent = par.SwitchParent();
        js.executeScript("arguments[0].scrollIntoView();", SwitchParent);
        Thread.sleep(2000);
        SwitchParent.click();

        System.out.println(par.ParentPercentageDisplayed().getText());
        int parentAttendancePercentage = Integer.parseInt(par.ParentPercentageDisplayed().getText().split(" ")[0].split("%")[0]);

        return StudentAttendanceValidateTest(attendancePercentage, parentAttendancePercentage);
    }

    public boolean StudentAttendanceValidateTest(int attendancePercentage, int parentAttendancePercentage) {
        if(attendancePercentage == parentAttendancePercentage){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }


    public boolean ParentStudentViewProfileCheck(WebDriver driver, String mobNumber, String password) throws  IOException, InterruptedException {
        this.par = new Parent(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);

        par.ParentImageClick().click();
        Thread.sleep(5000);

        String StudentName = par.DisplayedAccountName().getText();

        par.ViewProfileButton().click();

        String StudentNameInside = par.DisplayedAccountName().getText();

        return StudentViewProfileValidateTest(StudentName, StudentNameInside);
    }

    public boolean StudentViewProfileValidateTest(String studentName, String studentNameInside) {
        if(studentName.contains(studentNameInside)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }



}
