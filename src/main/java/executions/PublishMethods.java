package executions;

import org.openqa.selenium.*;
import pageObjects.LoginPage;
import pageObjects.Publish;
import resources.BaseLogin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PublishMethods extends BaseLogin {
    public Publish pub;
    public LoginPage log;
    public WebDriver driver;
    JavascriptExecutor js;
    Map<String, String> map = new HashMap<>();


    public PublishMethods(WebDriver driver2) {
        super(driver2);
    }

    public void ThreadSleep5000() throws InterruptedException {
        Thread.sleep(5000);
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

    // Landing page check
    public boolean LandingPageValidateTest(String actual_header, String expected_header ){
        System.out.println(actual_header + " "+ expected_header);
        if (actual_header.equals(expected_header)) {
            System.out.println("Notebook Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean studentLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.pub = new Publish(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(2000);

        String actual_header = pub.PublishGetHeader();
        String expected_header = "Teacher Published Content";
        return LandingPageValidateTest(actual_header, expected_header);
    }

    public boolean teacherLanding(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.pub = new Publish(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(2000);

        String actual_header = pub.PublishGetHeader();
        String expected_header = "Publish Content";
        return LandingPageValidateTest(actual_header, expected_header);
    }


    // New Content Btn Check
    public boolean PublishNewBtnValidateTest(List<WebElement> tabs){
        if (tabs.size() > 1) {
            System.out.println("Notebook Module is active");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherPublishNewContentBtnCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.pub = new Publish(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(5000);

        pub.PublishNewContentBtn().click();
        Thread.sleep(2000);
        List<WebElement> tabs = pub.PublishNewContentTabs();

        return PublishNewBtnValidateTest(tabs);
    }

    // publish content

    public boolean NewContentValidateTest(String actual_text, String expected_text) {
        System.out.println(actual_text+" "+expected_text);
        if(expected_text.contains(actual_text)){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    public boolean studentPublishNewContentCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.pub = new Publish(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(2000);

        String FirstContent = pub.PublishContentOnTop().getText();
        if (mob >= 9000000001l && mob <= 9000000020l) {
            String GradeContent = map.get("Grade 1");
            return NewContentValidateTest(FirstContent, GradeContent);
        }

        else if (mob >= 9000000021l && mob <= 9000000040l) {
            String GradeContent = map.get("Grade 2");
            return NewContentValidateTest(FirstContent, GradeContent);
        }

        else if (mob >= 9000000041l && mob <= 9000000060l) {
            String GradeContent = map.get("Grade 3");
            return NewContentValidateTest(FirstContent, GradeContent);
        }

        else if (mob >= 9000000061l && mob <= 9000000080l) {
            String GradeContent = map.get("Grade 4");
            return NewContentValidateTest(FirstContent, GradeContent);
        }

        else if (mob >= 9000000081l && mob <= 9000000100l) {
            String GradeContent = map.get("Grade 5");
            return NewContentValidateTest(FirstContent, GradeContent);
        }
        return false;
    }


    public boolean teacherPublishNewContentCheck(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        this.pub = new Publish(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(5000);

        pub.PublishNewContentBtn().click();
        Thread.sleep(5000);

        List<WebElement> ContentOptions = pub.ContentOptions();
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

        if(mob >= 9000000101l && mob <= 9000000104l){
            String publishContent = "Grade 1 Content " + Publish.contentSequenceCounter;
            map.put("Grade 1",publishContent);

            pub.PublishContentDescriptionTextArea().click();
            pub.PublishContentDescriptionTextArea().sendKeys(publishContent);
            Thread.sleep(3000);
            pub.NextStepBtn().click();
            Thread.sleep(3000);
            List<WebElement> GradeSectionInput = pub.PublishGradeSectionInput();
            for(WebElement webElement : GradeSectionInput){
                webElement.click();
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
            }
            Thread.sleep(3000);
            pub.FinalPublishBtn().click();
            Thread.sleep(5000);
            pub.BackAfterPublish().click();

            String actual_time = pub.FirstContentTime().getText();
            String expected_time = "a minute ago a few seconds ago";
            return NewContentValidateTest(actual_time, expected_time);
        }
        else if (mob >= 9000000105l && mob <= 9000000108l) {
            String publishContent = "Grade 2 Content " + Publish.contentSequenceCounter;
            map.put("Grade 2",publishContent);

            pub.PublishContentDescriptionTextArea().click();
            pub.PublishContentDescriptionTextArea().sendKeys(publishContent);
            Thread.sleep(3000);
            pub.NextStepBtn().click();
            Thread.sleep(3000);
            List<WebElement> GradeSectionInput = pub.PublishGradeSectionInput();
            for(WebElement webElement : GradeSectionInput){
                webElement.click();
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
            }
            Thread.sleep(3000);
            pub.FinalPublishBtn().click();
            Thread.sleep(5000);
            pub.BackAfterPublish().click();

            String actual_time = pub.FirstContentTime().getText();
            String expected_time = "a minute ago a few seconds ago";
            return NewContentValidateTest(actual_time, expected_time);
        }

        else if (mob >= 9000000109l && mob <= 9000000112l) {
            String publishContent = "Grade 3 Content " + Publish.contentSequenceCounter;
            map.put("Grade 3",publishContent);

            pub.PublishContentDescriptionTextArea().click();
            pub.PublishContentDescriptionTextArea().sendKeys(publishContent);
            Thread.sleep(3000);
            pub.NextStepBtn().click();
            Thread.sleep(3000);
            List<WebElement> GradeSectionInput = pub.PublishGradeSectionInput();
            for(WebElement webElement : GradeSectionInput){
                webElement.click();
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
            }
            Thread.sleep(3000);
            pub.FinalPublishBtn().click();
            Thread.sleep(5000);
            pub.BackAfterPublish().click();

            String actual_time = pub.FirstContentTime().getText();
            String expected_time = "a minute ago a few seconds ago";
            return NewContentValidateTest(actual_time, expected_time);
        }

        else if (mob >= 9000000113l && mob <= 9000000116l) {
            String publishContent = "Grade 4 Content " + Publish.contentSequenceCounter;
            map.put("Grade 4",publishContent);

            pub.PublishContentDescriptionTextArea().click();
            pub.PublishContentDescriptionTextArea().sendKeys(publishContent);
            Thread.sleep(3000);
            pub.NextStepBtn().click();
            Thread.sleep(3000);
            List<WebElement> GradeSectionInput = pub.PublishGradeSectionInput();
            for(WebElement webElement : GradeSectionInput){
                webElement.click();
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
            }
            Thread.sleep(3000);
            pub.FinalPublishBtn().click();
            Thread.sleep(5000);
            pub.BackAfterPublish().click();

            String actual_time = pub.FirstContentTime().getText();
            String expected_time = "a minute ago a few seconds ago";
            return NewContentValidateTest(actual_time, expected_time);
        }

        else if (mob >= 9000000117l && mob <= 9000000120l) {
            String publishContent = "Grade 5 Content " + Publish.contentSequenceCounter;
            map.put("Grade 5",publishContent);

            pub.PublishContentDescriptionTextArea().click();
            pub.PublishContentDescriptionTextArea().sendKeys(publishContent);
            Thread.sleep(3000);
            pub.NextStepBtn().click();
            Thread.sleep(3000);
            List<WebElement> GradeSectionInput = pub.PublishGradeSectionInput();
            for(WebElement webElement : GradeSectionInput){
                webElement.click();
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
            }
            Thread.sleep(3000);
            pub.FinalPublishBtn().click();
            Thread.sleep(5000);
            pub.BackAfterPublish().click();

            String actual_time = pub.FirstContentTime().getText();
            String expected_time = "a minute ago a few seconds ago";
            return NewContentValidateTest(actual_time, expected_time);
        }
        return false;
    }

    // Views and Likes

    public boolean ViewsandLikesValidateTest(int ActualValue, int ExpectedValue) {
        System.out.println(ActualValue + " " + ExpectedValue);
        if(ActualValue == ExpectedValue){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean studentPublishViewsandLikes(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1, flag2;
        this.pub = new Publish(driver);
        Long mob = Long.parseLong(mobNumber);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(2000);

        String PrevViewCount = pub.OutsideViewCount().getText();
        Thread.sleep(2000);
        pub.ContentMetaData().click();
        Thread.sleep(2000);
        String CurrViewCount = pub.InsideViewCount().getText();
        Thread.sleep(2000);
        String PrevLikeCount = pub.LikeCount().getText();
        Thread.sleep(2000);
        flag1 = ViewsandLikesValidateTest(Integer.parseInt(CurrViewCount), Integer.parseInt(PrevViewCount) +1);
        Thread.sleep(2000);
        WebElement yesbtn = pub.LikeBtn();
        WebElement nobtn = pub.DisLikeBtn();

        System.out.println(yesbtn.getAttribute("class"));
        if(yesbtn.getAttribute("class").contains("likes")){
            nobtn.click();
            Thread.sleep(2000);
            String CurrLikeCount = pub.LikeCount().getText();
            Thread.sleep(2000);
            flag2 = ViewsandLikesValidateTest(Integer.parseInt(CurrLikeCount), Integer.parseInt(PrevLikeCount)-1);
        }
        else{
            yesbtn.click();
            Thread.sleep(2000);
            String CurrLikeCount = pub.LikeCount().getText();
            Thread.sleep(2000);
            flag2 = ViewsandLikesValidateTest(Integer.parseInt(CurrLikeCount), Integer.parseInt(PrevLikeCount)+1);
        }

        if (flag1 && flag2){
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    // Pagination
    List<String> list = List.of("1 - 10", "11 - 20", "21 - 30", "31 - 40", "41 - 50", "51 - 60", "61 - 70", "71 - 80", "81 - 90", "91 - 100", "101 - 120");

    public boolean CheckEnabled(WebElement nextNavigate) {
        return !nextNavigate.getAttribute("class").contains("disabled");
    }

    public boolean PaginationValidateTest(String Actual_Text, String Expected_Text) {
        System.out.println(Actual_Text + " "+ Expected_Text);
        return Actual_Text.contains(Expected_Text);
    }

    public boolean studentPublishPagination(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1 = true, flag2 = true, flag3 = true, flag4 = true;
        this.pub = new Publish(driver);
        String CurrPaginationText;
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(10000);

        int i=0;
        // one click forward
        if(CheckEnabled(pub.NextNavigate())){
            pub.NextNavigate().click(); Thread.sleep(2000);
            i+=1;
            CurrPaginationText = pub.PaginationText().getText(); Thread.sleep(2000);
            flag1= PaginationValidateTest(CurrPaginationText, list.get(i)); Thread.sleep(2000);
        }

        // two clicks forward
        if(CheckEnabled(pub.NextNavigate())) {
            pub.NextNavigate().click(); Thread.sleep(2000);
            i+=1;
            if(CheckEnabled(pub.NextNavigate())){
                pub.NextNavigate().click(); Thread.sleep(2000);
                i+=1;
            }
            CurrPaginationText = pub.PaginationText().getText(); Thread.sleep(2000);
            flag2= PaginationValidateTest(CurrPaginationText, list.get(i)); Thread.sleep(2000);
        }


        // one click back
        if(CheckEnabled(pub.BackNavigate())){
            pub.BackNavigate().click(); Thread.sleep(2000);
            i-=1;
            CurrPaginationText = pub.PaginationText().getText();
            flag3= PaginationValidateTest(CurrPaginationText, list.get(i));
        }

        // two click back
        if(CheckEnabled(pub.BackNavigate())){
            pub.BackNavigate().click(); Thread.sleep(2000);
            i-=1;
            if(CheckEnabled(pub.BackNavigate())){
                pub.BackNavigate().click(); Thread.sleep(2000);
                i-=1;
            }
            CurrPaginationText = pub.PaginationText().getText();
            flag4= PaginationValidateTest(CurrPaginationText, list.get(i));
        }


        if(flag1 && flag2 && flag3 && flag4){
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean teacherPublishPagination(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1 = true, flag2 = true, flag3 = true, flag4 = true;
        String CurrPaginationText;
        this.pub = new Publish(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(10000);

        int i=0;
        // one click forward
        if(CheckEnabled(pub.NextNavigate())){
            pub.NextNavigate().click(); Thread.sleep(2000);
            i+=1;
            CurrPaginationText = pub.PaginationText().getText(); Thread.sleep(2000);
            flag1= PaginationValidateTest(CurrPaginationText, list.get(i)); Thread.sleep(2000);
        }

        // two clicks forward
        if(CheckEnabled(pub.NextNavigate())) {
            pub.NextNavigate().click(); Thread.sleep(2000);
            i+=1;
            if(CheckEnabled(pub.NextNavigate())){
                pub.NextNavigate().click(); Thread.sleep(2000);
                i+=1;
            }
            CurrPaginationText = pub.PaginationText().getText(); Thread.sleep(2000);
            flag2= PaginationValidateTest(CurrPaginationText, list.get(i)); Thread.sleep(2000);
        }


        // one click back
        if(CheckEnabled(pub.BackNavigate())){
            pub.BackNavigate().click(); Thread.sleep(2000);
            i-=1;
            CurrPaginationText = pub.PaginationText().getText();
            flag3= PaginationValidateTest(CurrPaginationText, list.get(i));
        }

        // two click back
        if(CheckEnabled(pub.BackNavigate())){
            pub.BackNavigate().click(); Thread.sleep(2000);
            i-=1;
            if(CheckEnabled(pub.BackNavigate())){
                pub.BackNavigate().click(); Thread.sleep(2000);
                i-=1;
            }
            CurrPaginationText = pub.PaginationText().getText();
            flag4= PaginationValidateTest(CurrPaginationText, list.get(i));
        }


        if(flag1 && flag2 && flag3 && flag4){
            System.out.println("PASSED");
            return true;
        }
        else {
            return false;
        }
    }

    // PublishTeacherCategoryFilters_Student
    public int TotalContentCount(){
        List<String> pagination_text = List.of(pub.PaginationText().getText().split(" "));
        return Integer.parseInt(pagination_text.get(pagination_text.size() - 1));
    }
    public boolean studentPublishTeacherFilter(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1 = true, flag2 = true;
        this.pub = new Publish(driver);
        js = (JavascriptExecutor) driver;
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("student", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(10000);

        pub.TeacherNameInput().click();
        String TeacherName = pub.FirstTeacherInList().getText();
        pub.FirstTeacherInList().click();
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("//*[text()='Category']"));
        js.executeScript("arguments[0].scrollIntoView();", element);

        Thread.sleep(2000);
        pub.FirstCategoryFilterOption().click();
        Thread.sleep(2000);

        if (TotalContentCount() != 0){
            List<WebElement> DoubtCards = pub.DoubtCards();
            for(int i=0;i<DoubtCards.size();i++){
                System.out.println(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[" + (i + 2) + "]/a/div/div[1]/div[2]/h3")).getText());
                if(!TeacherName.equals(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[" + (i + 2) + "]/a/div/div[1]/div[2]/h3")).getText())){
                    flag1 = false;
                }
            }
            for(int i=0;i<DoubtCards.size();i++){
                if(!pub.FirstCategoryFilterOption().getText().equals(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[" + (i + 2) + "]/div[2]/div[2]/span")).getText())){
                    flag2 = false;
                }
            }
        }

        if(flag1 && flag2){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }

    // PublishSubjectLessonCategoryFilters_Teacher

    public boolean Validate(String element, String selectedSubject) {
        if (element.contains(selectedSubject)){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean teacherSubjectLessonCategoryFilters(WebDriver driver, String mobNumber, String password) throws IOException, InterruptedException {
        boolean flag1= true, flag2 = true, flag3 = true;
        this.pub = new Publish(driver);
        BaseLogin user = new BaseLogin(driver);
        user.userLogin("teacher", mobNumber, password);
        Thread.sleep(2000);
        pub.PublishToggle().click();
        Thread.sleep(5000);

        List<WebElement> FilterOptions = pub.TeacherFilterOptions();
        int j=0;
        for(WebElement webElement:FilterOptions){
            if(j==0 || j==3 || j==4){
                Thread.sleep(3000);
                webElement.click();
                Thread.sleep(3000);
                webElement.sendKeys(Keys.ARROW_DOWN);
                webElement.sendKeys(Keys.ENTER);
            }
            else{
                Thread.sleep(5000);
                webElement.click();
                Thread.sleep(5000);
                webElement.sendKeys(Keys.ENTER);
            }
            j+=1;
        }
        String SelectedSubject = List.of(FilterOptions.get(1).getText().split("\n")).get(1);
        String SelectedLesson = List.of(FilterOptions.get(3).getText().split("\n")).get(1);
        String SelectedCategory = List.of(FilterOptions.get(4).getText().split("\n")).get(1);

        List<WebElement> PublishedContentList = pub.ContentList();
        int contentssize = PublishedContentList.size()-1;
        Thread.sleep(5000);
        //Subject
        for(int i=0;i<contentssize;i++){
            flag1= Validate(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/table/tbody/tr["+(i+1)+"]/td[1]")).getText(), SelectedSubject);
            Thread.sleep(2000);
            if(!flag1){break;}
        }
        // Lesson name
        for(int i=0;i<contentssize;i++){
            flag2= Validate(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/table/tbody/tr["+(i+1)+"]/td[2]")).getText(), SelectedLesson);
            Thread.sleep(2000);
            if(!flag2){break;}
        }
        // category
        for(int i=0;i<contentssize;i++){
            flag3= Validate(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/table/tbody/tr["+(i+1)+"]/td[3]")).getText(), SelectedCategory);
            Thread.sleep(2000);
            if(!flag3){break;}
        }

        if(flag1 && flag2 && flag3){
            System.out.println("PASSED");
            return true;
        }
        else{
            return false;
        }
    }





}
