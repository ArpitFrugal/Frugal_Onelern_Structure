package executions;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pageObjects.LoginPage;
import pageObjects.UserManagement;
import resources.BaseLogin;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UserManagementMethods extends BaseLogin {
    public UserManagement usm;
    public LoginPage log;
    public WebDriver driver;
    public UserManagementMethods(WebDriver driver2) {
        super(driver2);
    }


    public boolean CreateGradeValidateTest(boolean flag) {
        if(flag){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean AdminCreateGradeCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.usm = new UserManagement(driver);
        boolean flag;
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        usm.InstituteClick().click();
        Thread.sleep(2000);
        usm.SearchInstitute().sendKeys("Automation");
        Thread.sleep(2000);
        usm.SelectInstitute().click();
        Thread.sleep(2000);
        usm.SearchSchool().click();
        usm.SearchSchool().sendKeys("School");
        usm.SelectSchool().click();
        Thread.sleep(2000);

        int gradesDisplayed = driver.findElements(By.xpath("//label[contains(@for,'form')]/input")).size();
        usm.AddGradeBtnClick().click();
        Thread.sleep(5000);

        if(usm.Grades().size()>0){
            usm.Grade1Check().click();
            Thread.sleep(2000);
            usm.SaveBtn().click();
            Thread.sleep(2000);

            System.out.println(driver.findElements(By.xpath("//label[contains(@for,'form')]/input")).size());
            flag = driver.findElements(By.xpath("//label[contains(@for,'form')]/input")).size() == gradesDisplayed+1;
        }
        else{
            flag=true;
        }

        return CreateGradeValidateTest(flag);

    }

    public boolean AdminAddInstituteCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.usm = new UserManagement(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);
        usm.InstituteClick().click();
        Thread.sleep(2000);
        usm.NewInstituteBtnClick().click();
        Thread.sleep(2000);
        usm.SelectCurriculum().click();
        usm.SelectCurriculum().sendKeys("CBSE");
        usm.SelectCurriculum().sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        usm.EnterInstituteName().sendKeys("Alphores_1");
        Thread.sleep(2000);
        usm.EnterInstituteCode().sendKeys("Alp_0001");
        Thread.sleep(2000);
        usm.CreateInstituteBtnClick().click();

        return true;
    }

    public boolean AdminCreateSchoolCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.usm = new UserManagement(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);
        usm.InstituteClick().click();
        Thread.sleep(2000);
        usm.SearchInstitute().click();
        Thread.sleep(2000);
        usm.SearchInstitute().sendKeys("Automation");
        Thread.sleep(2000);
        usm.SelectInstitute().click();
        Thread.sleep(2000);
        usm.AddSchoolBtnClick().click();
        Thread.sleep(2000);

        usm.EnterCurriculum().click();
        Thread.sleep(1000);
        usm.EnterCurriculum().sendKeys("CBSE");
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);

        usm.EnterSchoolName().sendKeys("Trinity");
        Thread.sleep(2000);
        usm.EnterSchoolCode().sendKeys("Tri_001");
        Thread.sleep(2000);
//        usm.EnterCurriculum().click();
//        Thread.sleep(1000);
//        usm.EnterCurriculum().sendKeys("CBSE");
//        Thread.sleep(2000);
//        Actions action = new Actions(driver);
//        action.sendKeys(Keys.CONTROL).clickAndHold().sendKeys(Keys.ENTER).build().perform();
//        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", usm.EnterPhoneNumber());
        usm.EnterLiveClassURL().sendKeys("https://meet.google.com/");
        usm.EnterAddress().sendKeys("Park Street");
        usm.EnterPhoneNumber().sendKeys("9876543210");
        js.executeScript("arguments[0].scrollIntoView();", usm.EnterState());
        usm.EnterZipCode().sendKeys("500080");
        usm.EnterCity().sendKeys("Hyderabad");
        usm.EnterState().sendKeys("Telangana");
        js.executeScript("arguments[0].scrollIntoView();", usm.CreateSchoolBtn());
        usm.EnterCountry().sendKeys("India");
        usm.EnterEmail().sendKeys("abc@test.com");
        usm.EnterWebsite().sendKeys("Website");
        usm.CreateSchoolBtn().click();


        return true;
    }

    public boolean CreateSectionValidateTest(int sectionsDisplayed, int sectionsDisplayedAfterAdding) {
        if(sectionsDisplayed+1 == sectionsDisplayedAfterAdding){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean AdminCreateSection(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.usm = new UserManagement(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);
        usm.InstituteClick().click();
        Thread.sleep(2000);
        usm.SearchInstitute().click();
        Thread.sleep(2000);
        usm.SearchInstitute().sendKeys("Automation");
        Thread.sleep(2000);
        usm.SelectInstitute().click();
        Thread.sleep(2000);
        usm.SearchSchool().click();
        usm.SearchSchool().sendKeys("School");
        Thread.sleep(2000);
        usm.SelectSchool().click();
        Thread.sleep(2000);
        List<WebElement> grades = usm.GradesDisplay();
        grades.get(0).click();
        Thread.sleep(2000);

        int sectionsDisplayed = driver.findElements(By.xpath("//*[contains(@class,'grade-card')]")).size();
        usm.AddsectionsBtn().click();
        Thread.sleep(2000);
        usm.InputSectionName().click();
        usm.InputSectionName().sendKeys("SectionA");
        Thread.sleep(2000);
        usm.AddSectionBtn().click();
        Thread.sleep(2000);
        int sectionsDisplayedAfterAdding = driver.findElements(By.xpath("//*[contains(@class,'grade-card')]")).size();

        return CreateSectionValidateTest(sectionsDisplayed, sectionsDisplayedAfterAdding);
    }

    public boolean AdminAddCollectionsCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.usm = new UserManagement(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);

        usm.CollectionsModule().click();
        usm.AddCollectionsBtn().click();

        String CollectionName = "New Collection";
        usm.CollectionNameInput().click();
        usm.CollectionNameInput().sendKeys(CollectionName);

        usm.CollectionDescriptionInput().click();
        usm.CollectionDescriptionInput().sendKeys("Description");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = usm.bottomDiv();
        js.executeScript("arguments[0].scrollIntoView();", element);

        Thread.sleep(2000);
        usm.AddPackagesBtn().click();
        usm.FirstPackage().click();

        usm.ConfirmPackages().click();

        usm.ConfirmCollection().click();
        Thread.sleep(2000);
        return AddCollectionsValidateTest(usm.FirstCollectionDisplayed().getText(), CollectionName);

    }

    public boolean AddCollectionsValidateTest(String actualText, String expectedText) {
        System.out.println(actualText+" "+expectedText);
        if(actualText.contains(expectedText)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }


    public boolean AdminAddLicenseCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.usm = new UserManagement(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);

        usm.UserManagementModule().click();
        Thread.sleep(1000);

        usm.LicensesModule().click();
        Thread.sleep(2000);
        usm.AddLicenseBtn().click();

        String LicenseName = "New License";
        usm.LicenseName().click();
        usm.LicenseName().sendKeys(LicenseName);

        Select InstituteOptions = new Select(usm.LicenseInstituteSelect());
        InstituteOptions.selectByVisibleText("Automation Test School");

        usm.TotalAllocatedLicenses().click();
        usm.TotalAllocatedLicenses().sendKeys("10");
//////////////////////////////////////////

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
        cal.add(Calendar.DAY_OF_MONTH, 7);
        String dateAfter = formatter.format(cal.getTime());

        String enddate = dateAfter.split("/")[0];
        String endmonth = dateAfter.split("/")[1];
        String endyear = dateAfter.split("/")[2];

        usm.StartDateInputBox().click();
        usm.StartDateInputBox().sendKeys(currdate);
        usm.StartDateInputBox().sendKeys(currmonth);
        usm.StartDateInputBox().sendKeys(curryear);

        usm.EndDateInputBox().click();
        usm.EndDateInputBox().sendKeys(enddate);
        usm.EndDateInputBox().sendKeys(endmonth);
        usm.EndDateInputBox().sendKeys(endyear);

        System.out.println(currdate+" "+enddate);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = usm.bottomDiv();
        js.executeScript("arguments[0].scrollIntoView();", element);

        Thread.sleep(2000);

        usm.AddCollectionBtn().click();
        usm.FirstCollection().click();

        usm.ConfirmCollections().click();

        usm.CreateLicenseBtn().click();
        Thread.sleep(2000);
        return AddLicenseValidateTest(usm.FirstCollectionDisplayed().getText(), LicenseName);

    }

    public boolean AddLicenseValidateTest(String actualText, String expectedText) {
        System.out.println(actualText+" "+expectedText);
        if(actualText.contains(expectedText)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean AdminCollectionPaginationCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.usm = new UserManagement(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);

        boolean flag1, flag2, flag3;

        usm.CollectionsModule().click();

        int i=0;

        Thread.sleep(2000);
        usm.nextNavigateBtn().click();
        usm.nextNavigateBtn().click();
        i+=2;
        Thread.sleep(1000);
        System.out.println(usm.paginationText().getText());
        flag1 = ValCompare(usm.paginationText().getText(), String.valueOf(i+1));

        Thread.sleep(1000);
        usm.prevNavigateBtn().click();
        i-=1;
        Thread.sleep(1000);
        System.out.println(usm.paginationText().getText());
        flag2 = ValCompare(usm.paginationText().getText(),String.valueOf(i+1));

        Thread.sleep(1000);
        usm.nextNavigateBtn().click();
        usm.nextNavigateBtn().click();
        i+=2;
        Thread.sleep(1000);
        System.out.println(usm.paginationText().getText());
        flag3 = ValCompare(usm.paginationText().getText(),String.valueOf(i+1));

        return CollectionPaginationValidateTest(flag1, flag2, flag3);
    }

    public boolean ValCompare(String actual, String expected){
        return actual.contains(expected);
    }

    public boolean CollectionPaginationValidateTest(boolean flag1, boolean flag2, boolean flag3) {
        System.out.println(flag1 + " " + flag2 + " " +flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }


    public boolean AdminCollectionsSearchCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.usm = new UserManagement(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);

        usm.CollectionsModule().click();

        usm.SearchInputBox().click();
        usm.SearchInputBox().sendKeys("New Collection");

        Thread.sleep(1000);
        return CollectionSearchValidateTest(usm.CollectionsDisplayed());

    }

    public boolean CollectionSearchValidateTest(List<WebElement> collectionsDisplayed) {
        System.out.println(collectionsDisplayed.size());
        if(collectionsDisplayed.size() > 0){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean AdminCreateNewStudentCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.usm = new UserManagement(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;


        usm.InstitutesModule().click();
        Thread.sleep(2000);

        usm.SearchInstitute().click();
        Thread.sleep(2000);
        usm.SearchInstitute().sendKeys("Automation");

        List<WebElement> institutesDisplayed = usm.InstitutesDisplayed();
        institutesDisplayed.get(0).click();


        WebElement firstSchool = usm.SchoolsDisplayed().get(0);
        firstSchool.click();
        Thread.sleep(2000);
        WebElement firstGrade = usm.GradesDisplayed().get(0);
        firstGrade.click();
        Thread.sleep(2000);
        WebElement firstSection = usm.SectionsDisplayed().get(0);
        firstSection.click();

        usm.AddStudentBtn().click();

        usm.StudentFirstName().click();
        usm.StudentFirstName().sendKeys("First Name");

        usm.StudentLastName().click();
        usm.StudentLastName().sendKeys("Last Name");

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

        String currdate = str.split("/")[0];
        String currmonth = str.split("/")[1];
        String curryear = str.split("/")[2];

//        usm.StudentDOB().click();
//        usm.StudentDOB().sendKeys(currdate);
//        usm.StudentDOB().sendKeys(currmonth);
//        usm.StudentDOB().sendKeys(curryear);

        usm.StudentGender().click();
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView();", usm.StudentEmail());
        Thread.sleep(2000);
        usm.ParentEmail().click();
        usm.ParentEmail().sendKeys("parentmail@gmail.com");

        usm.ParentName().click();
        usm.ParentName().sendKeys("Parent Name");

        usm.ParentMobileNumber().click();
        usm.ParentMobileNumber().sendKeys("9876543210");
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView();", usm.CurrentAddress());
        Thread.sleep(3000);
        usm.NextStep().click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-350)", "");
        Thread.sleep(1000);

        DateFormat dateFormat = new SimpleDateFormat("hh.mm aa");
        String dateString = dateFormat.format(new Date(Calendar.getInstance().getTimeInMillis()));
        String currhour = dateString.split("\\.")[0];
        String currmin  = dateString.split("\\.")[1].split(" ")[0];
        String ampm = dateString.split("\\.")[1].split(" ")[1];


        usm.StudentUsername().click();
        usm.StudentUsername().sendKeys("username"+currhour+currmin);
        js.executeScript("arguments[0].scrollIntoView();", usm.AddStudent());
        Thread.sleep(1000);
        usm.AddStudent().click();
        Thread.sleep(10000);
        List<WebElement> StudentsDisplayed = usm.StudentsDisplayed();

        boolean flag = false;

        for(WebElement webElement:StudentsDisplayed){
            if(webElement.getText().contains("First")){
                flag = true;
                break;
            }
        }
        return CreateStudentValidateTest(flag);

    }


    public boolean CreateStudentValidateTest(boolean flag) {
        System.out.println(flag);
        if(flag){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean AdminLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.usm = new UserManagement(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);

        String header = usm.GetHeader().getText();
        String ExpectedHeader = "OneLern";
        return LandingPageValidateTest(header,ExpectedHeader);
    }

    public boolean LandingPageValidateTest(String actualHeader, String expectedHeader) {
        if(actualHeader.contains(expectedHeader)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean AdminLicensePaginationCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.usm = new UserManagement(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);

        boolean flag1, flag2, flag3;

        usm.UserManagementModule().click();
        Thread.sleep(1000);

        usm.LicensesModule().click();

        int i=0;

        Thread.sleep(2000);
        usm.nextNavigateBtn().click();
        usm.nextNavigateBtn().click();
        i+=2;
        Thread.sleep(1000);
        System.out.println(usm.paginationText().getText());
        flag1 = ValCompare(usm.paginationText().getText(), String.valueOf(i+1));

        Thread.sleep(1000);
        usm.prevNavigateBtn().click();
        i-=1;
        Thread.sleep(1000);
        System.out.println(usm.paginationText().getText());
        flag2 = ValCompare(usm.paginationText().getText(),String.valueOf(i+1));

        Thread.sleep(1000);
        usm.nextNavigateBtn().click();
        usm.nextNavigateBtn().click();
        i+=2;
        Thread.sleep(1000);
        System.out.println(usm.paginationText().getText());
        flag3 = ValCompare(usm.paginationText().getText(),String.valueOf(i+1));

        return LicensePaginationValidateTest(flag1, flag2, flag3);
    }

//    public boolean ValCompare(String actual, String expected){
//        return actual.contains(expected);
//    }

    public boolean LicensePaginationValidateTest(boolean flag1, boolean flag2, boolean flag3) {
        System.out.println(flag1 + " " + flag2 + " " +flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean AdminLicenseSearchCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.usm = new UserManagement(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);

        usm.UserManagementModule().click();
        Thread.sleep(1000);

        usm.LicensesModule().click();

        usm.SearchInputBox().click();
        usm.SearchInputBox().sendKeys("New License");

        Thread.sleep(1000);
        return LicenseSearchValidateTest(usm.CollectionsDisplayed());
    }

    public boolean LicenseSearchValidateTest(List<WebElement> collectionsDisplayed) {
        System.out.println(collectionsDisplayed.size());
        if(collectionsDisplayed.size() > 0){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }
    List<String> paginationpage = List.of("1-", "16-", "31-", "46-", "61-");

    public boolean AdminStudentPaginationCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.usm = new UserManagement(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("projectadmin", mobNumber, password);
        Thread.sleep(2000);

        usm.InstitutesModule().click();
        Thread.sleep(2000);

        usm.SearchInstitute().click();
        Thread.sleep(2000);
        usm.SearchInstitute().sendKeys("Frugal");
        Thread.sleep(2000);

        List<WebElement> institutesDisplayed = usm.InstitutesDisplayed();
        Thread.sleep(2000);
        institutesDisplayed.get(0).click();

        WebElement firstSchool = usm.SchoolsDisplayed().get(0);
        firstSchool.click();
        Thread.sleep(2000);
        WebElement firstGrade = usm.GradesDisplayed().get(3); // temp
        firstGrade.click();
        Thread.sleep(2000);
        WebElement firstSection = usm.SectionsDisplayed().get(0);
        firstSection.click();

        int i=0;
        boolean flag1, flag2, flag3;

        flag1 = ValCompare(usm.StudentsPaginationText().getText(), paginationpage.get(i));
        Thread.sleep(2000);
        usm.PaginationNext().click();
        i+=1;
        usm.PaginationNext().click();
        i+=1;

        flag2 = ValCompare(usm.StudentsPaginationText().getText(), paginationpage.get(i));
        Thread.sleep(2000);
        usm.PaginationPrev().click();
        i-=1;

        flag3 = ValCompare(usm.StudentsPaginationText().getText(), paginationpage.get(i));
        Thread.sleep(2000);
        return StudentsPaginationValidateTest(flag1, flag2, flag3);

    }

    public boolean StudentsPaginationValidateTest(boolean flag1, boolean flag2, boolean flag3) {
        System.out.println(flag1+" "+flag2+" "+flag3);
        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }



}
