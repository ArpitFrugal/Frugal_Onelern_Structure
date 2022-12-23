package executions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pageObjects.LoginPage;
import pageObjects.StudentGroups;
import resources.Base;
import resources.BaseLogin;

import java.io.IOException;
import java.util.List;

public class StudentGroupsMethods extends BaseLogin {
    public StudentGroups sg;
    public LoginPage log;
    public WebDriver driver;

    public StudentGroupsMethods(WebDriver driver2) {
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

    public boolean AddGroupBtnValidateTest(String actual_header){
        System.out.println(actual_header);
        if (actual_header.contains("Create Group")) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean TeacherAddGroupBtnCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.sg = new StudentGroups(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        sg.rightswipemodules().click();
        sg.StudentGroupsToggle().click();
        Thread.sleep(1000);
        sg.AddGroupBtn().click();
        Thread.sleep(1000);

        String actual_header = sg.GetHeader().getText();
        return AddGroupBtnValidateTest(actual_header);
    }

    public boolean AddGroupValidateTest(String actual_header){
        System.out.println(actual_header);
        if (actual_header.contains("New Group")) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean TeacherAddGroupCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.sg = new StudentGroups(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        sg.rightswipemodules().click();
        sg.StudentGroupsToggle().click();
        Thread.sleep(1000);
        sg.AddGroupBtn().click();
        Thread.sleep(1000);

        sg.GroupNameInput().click();
        sg.GroupNameInput().sendKeys("New Group");

        sg.AddStudentsBtn().click();
        Thread.sleep(3000);
        sg.SelectAllStudents().click();

        sg.SelectAllStudentsSubmit().click();
        sg.SaveGroup().click();

        String CreatedGroup = sg.GroupCards().get(0).getText();
        return AddGroupValidateTest(CreatedGroup);
    }

    public boolean DeleteGroupValidateTest(int before_size, int after_size){
        System.out.println(before_size+" "+after_size);
        if (before_size == after_size) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean TeacherDeleteGroupCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.sg = new StudentGroups(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        sg.rightswipemodules().click();
        sg.StudentGroupsToggle().click();
        Thread.sleep(1000);

        int GroupsCountBeforeDeleting = sg.GroupCards().size();

        sg.MoreOptionsBtn().click();
        sg.DeleteOption().click();
        Thread.sleep(1000);
        sg.DeleteConfirmationBtn().click();
        Thread.sleep(3000);
        int GroupsCountAfterDeleting = sg.GroupCards().size();

        return DeleteGroupValidateTest(GroupsCountBeforeDeleting, GroupsCountAfterDeleting + 1);
    }

    public boolean EditGroupValidateTest(int size, String actual_header){
        System.out.println(size+" "+actual_header);
        if (size>0 && actual_header.contains("Edit Group")) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean TeacherEditGroupCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.sg = new StudentGroups(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        sg.rightswipemodules().click();
        sg.StudentGroupsToggle().click();
        Thread.sleep(1000);

        Actions action = new Actions(driver);
        sg.SearchInputBox().click();
        sg.SearchInputBox().sendKeys("New Group");

        sg.MoreOptionsBtn().click();
        sg.EditOption().click();

        String Header = sg.GetHeader().getText();

        sg.GroupNameInput().click();
        action.sendKeys(Keys.CONTROL).clickAndHold().sendKeys("A").build().perform();

        sg.GroupNameInput().sendKeys("Edited Group");
        sg.UpdateGroupNameSubmit().click();
        Thread.sleep(2000);
        sg.SearchInputBox().click();
        sg.SearchInputBox().sendKeys("Edited Group");

        return EditGroupValidateTest(sg.GroupCards().size(), Header);
    }

    public boolean SearchValidateTest(int size){
        System.out.println(size);
        if (size > 0) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean TeacherSearchGroupCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.sg = new StudentGroups(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        sg.rightswipemodules().click();
        sg.StudentGroupsToggle().click();
        Thread.sleep(15000);

        sg.SearchInputBox().click();
        sg.SearchInputBox().sendKeys("New Group");
        int size = sg.GroupCards().size();

        return SearchValidateTest(size);
    }

    public boolean LandingPageValidateTest(String actual_header){
        System.out.println(actual_header);
        if (actual_header.contains("Student Groups")) {
            System.out.println("Student Groups Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.sg = new StudentGroups(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        sg.rightswipemodules().click();
        sg.StudentGroupsToggle().click();
        Thread.sleep(2000);

        String actual_header = sg.GetHeader().getText();
        return LandingPageValidateTest(actual_header);
    }

    public boolean GroupPublishValidateTest(String GroupName){
        System.out.println(GroupName);
        if (GroupName.contains("New Group")) {
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean PublishStudentGroupsCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.sg = new StudentGroups(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        sg.rightswipemodules().click();
        sg.StudentGroupsToggle().click();
        Thread.sleep(10000);

        sg.AddGroupBtn().click();
        Thread.sleep(1000);

        sg.GroupNameInput().click();
        sg.GroupNameInput().sendKeys("New Group");

        sg.AddStudentsBtn().click();
        Thread.sleep(3000);
        sg.SelectAllStudents().click();

        sg.SelectAllStudentsSubmit().click();
        sg.SaveGroup().click();

        // -----------------------------------------
        driver.navigate().to(prop.getProperty("website")+"teacher");
        sg.PublishToggle().click();

        Thread.sleep(5000);
        sg.PublishNewContentBtn().click();
        Thread.sleep(5000);

        List<WebElement> ContentOptions = sg.ContentOptions();
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

        sg.PublishContentDescriptionTextArea().click();
        sg.PublishContentDescriptionTextArea().sendKeys("Description");
        Thread.sleep(3000);
        sg.NextStepBtn().click();
        Thread.sleep(3000);

        sg.PublishToGroup().click();
        Select grades = new Select(sg.GroupDropDown());

        grades.selectByValue("New Group");
        Thread.sleep(3000);
        String groupName = grades.getFirstSelectedOption().getText();
        Thread.sleep(1000);
        return GroupPublishValidateTest(groupName);
    }

}
