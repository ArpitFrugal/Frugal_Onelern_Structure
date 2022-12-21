package UserManagement;

import executions.UserManagementMethods;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.UserManagement;
import resources.Base;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

public class UserManagementFunctionalities extends Base {
    public WebDriver driver;
    public UserManagement usm;
    public UserManagementMethods usmmethods;

    @BeforeMethod // Method will work before each method inside this class
    public void standardLogic() throws IOException {
//        demoLogger.info("Standard logic building");
        driver = initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        usm = new UserManagement(driver); // Structured page object model function defined
        usmmethods = new UserManagementMethods(driver);
    }

    @Epic("This story represents the User Management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully get inside the User Management module.")
    @Story("UMFA_01")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminLanding(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(usmmethods.AdminLanding(driver, mobNumber, password));
    }

    @Epic("This story represents the User management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully create Institute or not")
    @Story("UMFA_02")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminAddInstituteCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(usmmethods.AdminAddInstituteCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the User management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully create School or not")
    @Story("UMFA_03")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminCreateSchoolCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(usmmethods.AdminCreateSchoolCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the User management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully create Grade or not")
    @Story("UMFA_04")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminCreateGradeCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(usmmethods.AdminCreateGradeCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the User management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully create Section or not")
    @Story("UMFA_05")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminCreateSection(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(usmmethods.AdminCreateSection(driver, mobNumber, password));
    }

    @Epic("This story represents the User Management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully create a student.")
    @Story("UMFA_06")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminCreateNewStudentCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(usmmethods.AdminCreateNewStudentCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the User Management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully navigayte to all pages of students and view them.")
    @Story("UMFA_07")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminStudentPaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(usmmethods.AdminStudentPaginationCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the User Management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully able to add collections.")
    @Story("UMFA_08")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminAddCollectionsCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(usmmethods.AdminAddCollectionsCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the User Management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully navigate to next and previous pages through navigation.")
    @Story("UMFA_09")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminCollectionPaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(usmmethods.AdminCollectionPaginationCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the User Management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully search the collection.")
    @Story("UMFA_10")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminCollectionsSearchCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(usmmethods.AdminCollectionsSearchCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the User Management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully able to add License.")
    @Story("UMFA_11")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminAddLicenseCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(usmmethods.AdminAddLicenseCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the User Management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully navigate to next and previous pages through navigation.")
    @Story("UMFA_12")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminLicensePaginationCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(usmmethods.AdminLicensePaginationCheck(driver, mobNumber, password));
    }

    @Epic("This story represents the User Management module of the onelern_school project.")
    @Description("Examine whether or not the admin can successfully search the collection.")
    @Story("UMFA_13")
    @Severity(SeverityLevel.BLOCKER)
    @Test(dataProvider = "adminData")
    public void AdminLicenseSearchCheck(String mobNumber, String password) throws IOException, InterruptedException {
        Assert.assertTrue(usmmethods.AdminLicenseSearchCheck(driver, mobNumber, password));
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name = "adminData")
    public Object[][] getadminData() throws FileAlreadyExistsException {
        return getProjectAdminData();
    }

}
