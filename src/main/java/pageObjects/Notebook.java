package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Notebook {
    public WebDriver driver;

    By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
//    By TeacherNotebookToggle = By.xpath("//img[@src='/images/notebook.svg']");
//    By StudentNotebookToggle = By.xpath("//img[@src='/images/notebook-white.svg']");
//    By BackButton = By.xpath("//header/div[1]/div[1]/button[1]/img[1]");
    By NotebookToggle = By.id("notebook");
    By BackButton = By.id("inner_header_back_btn");

    //landing page
    By GetHeader = By.xpath("/html/body/header/div[1]/h2");


    // Grade check
    By CoursebooksGradeTextGrade = By.className("svelte-uh84k1");

//    By EnglishGradeTextGrade1 = By.xpath("//div[@id='616064e79e1fe601b5ee7677']//span[@class='svelte-uh84k1']");
//    By EnglishGradeTextGrade2 = By.xpath("//div[@id='61606c609e1fe601b5ee7690']//span[@class='svelte-uh84k1']");
//    By EnglishGradeTextGrade3 = By.xpath("//div[@id='61606e699e1fe601b5ee7697']//span[@class='svelte-uh84k1']");
//    By EnglishGradeTextGrade4 = By.xpath("//div[@id='616070b99e1fe601b5ee769f']//span[@class='svelte-uh84k1']");
//    By EnglishGradeTextGrade5 = By.xpath("//div[@id='6160748b9e1fe601b5ee76a7']//span[@class='svelte-uh84k1']");


    // lesson name verify
    By EnvironmentalCoursebookGrade1 = By.xpath("//*[@id='61606a629e1fe601b5ee768c']/img");
    By MathematicsCoursebookGrade2 = By.xpath("//*[@id='61606cd19e1fe601b5ee7691']/img");
    By SocialStudiesCoursebookGrade3 = By.xpath("//*[@id='616070109e1fe601b5ee769e']/img");
    By ScienceCoursebookGrade4 = By.xpath("//*[@id='616071349e1fe601b5ee76a1']/img");
    By SocialStudiesCoursebookGrade5 = By.xpath("//*[@id='616075449e1fe601b5ee76aa']/img");
    By FirstLesson = By.id("item_1");
    By SecondLesson = By.id("item_2");
    By ThirdLesson = By.id("item_3");
    By FirstLessonText = By.xpath("//*[@id='item_1']/div/div[2]");
    By SecondLessonText = By.xpath("//*[@id='item_2']/div/div[2]");
    By ThirdLessonText = By.xpath("//*[@id='item_3']/div/div[2]");
    By LessonHeading = By.xpath("/html/body/div[3]/div/div[2]/div/h1");
//    By LessonHeading = By.id();
    // highlights
    By LibraryToggle = By.id("library");
    By FirstTopic = By.id("section_1");
    By SecondTopic = By.id("section_2");
    By ThirdTopic = By.id("section_3");
    By EnvFirstLessonFirstTopicRefGrade1 = By.xpath("//*[@id='6220ae6e92520323185f705b']/div/div/div/h2");
    By greenBtn = By.xpath("//label[@for='green']");
    By notesBtn = By.xpath("//*[@class='radio-item notes']");
//    By notesBtn = By.className("radio-item notes");
    By notesTextarea = By.id("annotator-field-0");
    By saveNoteBtn = By.xpath("//a[@href='#save']");
    By bookmarkBtn = By.xpath("//*[@class='radio-item bookmark']");
//    By bookmarkBtn = By.className("radio-item bookmark");
    By deleteBtn = By.xpath("//div[contains(@class,'radio-item deleteannotation')]");
    By random_text_to_click = By.xpath("//p[contains(@class,'svelte')]");

    By SearchIcon = By.xpath("//img[@class='pointer']");
    By SearchInput = By.id("search_box");
    By contents = By.xpath("//*[contains(@class,'bookmark student-state ')]");

    // highlights
    public WebElement LibraryToggle() { return driver.findElement(LibraryToggle); }
    public WebElement FirstTopic(){return driver.findElement(FirstTopic);}
    public WebElement SecondTopic(){return driver.findElement(SecondTopic);}
    public WebElement ThirdTopic(){return driver.findElement(ThirdTopic);}
    public WebElement EnvFirstLessonFirstTopicRefGrade1(){return driver.findElement(EnvFirstLessonFirstTopicRefGrade1);}
    public WebElement greenBtn(){return driver.findElement(greenBtn);}
    public WebElement notesBtn(){return driver.findElement(notesBtn);}
    public WebElement notesTextarea(){return driver.findElement(notesTextarea);}
    public WebElement saveNoteBtn(){return driver.findElement(saveNoteBtn);}
    public WebElement bookmarkBtn(){return driver.findElement(bookmarkBtn);}
    public WebElement deleteBtn(){return driver.findElement(deleteBtn);}
    public WebElement random_text_to_click(){return driver.findElement(random_text_to_click);}


    public WebElement SearchIcon(){return driver.findElement(SearchIcon);}
    public WebElement SearchInput(){return driver.findElement(SearchInput);}
    public List<WebElement> contents(){return driver.findElements(contents);}




    public Notebook(WebDriver driver2) {
        this.driver = driver2;
    }
    public WebElement StudentImageClick() {
        return driver.findElement(StudentImageClick);
    }
//    public WebElement TeacherNotebookToggle() {
//        return driver.findElement(TeacherNotebookToggle);
//    }
//    public WebElement StudentNotebookToggle() {
//        return driver.findElement(StudentNotebookToggle);}
    public WebElement NotebookToggle() {
        return driver.findElement(NotebookToggle);
    }
    public WebElement BackButton() {
        return driver.findElement(BackButton);
    }

    // landing page
    public String GetHeader(){return driver.findElement(GetHeader).getText();}


    // Grade Check
    public WebElement CoursebooksGradeTextGrade(){return driver.findElement(CoursebooksGradeTextGrade);}

//    public WebElement EnglishGradeTextGrade1(){return driver.findElement(CoursebooksGradeTextGrade);}
//    public WebElement EnglishGradeTextGrade2(){return driver.findElement(EnglishGradeTextGrade2);}
//    public WebElement EnglishGradeTextGrade3(){return driver.findElement(EnglishGradeTextGrade3);}
//    public WebElement EnglishGradeTextGrade4(){return driver.findElement(EnglishGradeTextGrade4);}
//    public WebElement EnglishGradeTextGrade5(){return driver.findElement(EnglishGradeTextGrade5);}


    // lesson name verify
    public WebElement EnvironmentalCoursebookGrade1(){return driver.findElement(EnvironmentalCoursebookGrade1);}
    public WebElement MathematicsCoursebookGrade2(){return driver.findElement(MathematicsCoursebookGrade2);}
    public WebElement SocialStudiesCoursebookGrade3(){return driver.findElement(SocialStudiesCoursebookGrade3);}
    public WebElement ScienceCoursebookGrade4(){return driver.findElement(ScienceCoursebookGrade4);}
    public WebElement SocialStudiesCoursebookGrade5(){return driver.findElement(SocialStudiesCoursebookGrade5);}
    public WebElement FirstLesson(){return driver.findElement(FirstLesson);}
    public WebElement SecondLesson(){return driver.findElement(SecondLesson);}
    public WebElement ThirdLesson(){return driver.findElement(ThirdLesson);}
    public String FirstLessonText(){return driver.findElement(FirstLessonText).getText();}
    public String SecondLessonText(){return driver.findElement(SecondLessonText).getText();}
    public String ThirdLessonText(){return driver.findElement(ThirdLessonText).getText();}
    public String LessonHeading(){return driver.findElement(LessonHeading).getText().substring(2);}

}
