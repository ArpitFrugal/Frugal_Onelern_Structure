package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Library {

	public WebDriver driver;

	By StudentImageClick = By.xpath("//div[@class='d-flex justify-content-center align-items-center flex-column']//div[2]//button[1]//img[1]");
//	By TeacherLibraryToggle = By.xpath("//img[@src='/images/library.svg']");
//	By StudentLibraryToggle = By.xpath("//img[@src='/images/library-white.svg']");
//	By TeacherBackButton = By.xpath("/html/body/header/div[1]/div[1]/button");

	By LibraryToggle = By.id("library");
	By BackButton = By.id("back_btn");
	By HeaderBackButton = By.id("inner_header_back_btn");

	// Grade check
	By EnglishGradeTextGrade1 = By.xpath("//div[@id='616064e79e1fe601b5ee7677']//span");
	By EnglishGradeTextGrade2 = By.xpath("//div[@id='61606c609e1fe601b5ee7690']//span");
	By EnglishGradeTextGrade3 = By.xpath("//div[@id='61606e699e1fe601b5ee7697']//span");
	By EnglishGradeTextGrade4 = By.xpath("//div[@id='616070b99e1fe601b5ee769f']//span");
	By EnglishGradeTextGrade5 = By.xpath("//div[@id='6160748b9e1fe601b5ee76a7']//span");


	// lesson name verify
	By FirstLessonText = By.xpath("//*[@id='item_1']/div/div[2]");
	By SecondLessonText = By.xpath("//*[@id='item_2']/div/div[2]");
	By ThirdLessonText = By.xpath("//*[@id='item_3']/div/div[2]");
	By InsideLessonHeading = By.xpath("/html/body/header/div[1]/div[1]/span");


	// lesson topics verify
	By EnvFirstLessonFirstTopicRefGrade1 = By.xpath("//*[@id='6220ae6e92520323185f705b']/div/div/div/h2");
	By EnvFirstLessonSecondTopicRefGrade1 = By.xpath("//*[@id='6220ae6e1da0f07e208ab956']/div/div/div/h2/span[2]");
	By EnvFirstLessonThirdTopicRefGrade1 = By.xpath("//*[@id='6220ae6e12604efa010ff0e2']/div/div/div/h2/span[2]");

	By EngThirdLessonFirstTopicRefGrade2 = By.xpath("//*[@id='622ae4eb86c5d6273ab3c668']/div/div/div/h2");
	By EngThirdLessonSecondTopicRefGrade2 = By.xpath("//*[@id='622ae4eb1d6b160b5664262a']/div/div/div/h2");
	By EngThirdLessonThirdTopicRefGrade2 = By.xpath("//*[@id='622ae4eb442a5dc3d209c006']/div/div/div/h2");

	By MathFirstLessonFirstTopicRefGrade3 = By.xpath("//*[@id='6225f85049ef78a1df908273']/div/div/div/h2");
	By MathFirstLessonSecondTopicRefGrade3 = By.xpath("//*[@id='6225f85030731be09847b5dc']/div/div/div/h2/span[2]");
	By MathFirstLessonThirdTopicRefGrade3 = By.xpath("//*[@id='6225f850b9cf5047f8a3513a']/div/div/div/h2/span[2]");

	By EngFirstLessonFirstTopicRefGrade4 = By.xpath("//*[@id='6228a6f9df9f3125a2007bd8']/div/div/div/h2");
	By EngFirstLessonSecondTopicRefGrade4 = By.xpath("//*[@id='6228a6f9e5ee41cc16ae495a']/div/div/div/h2");
	By EngFirstLessonThirdTopicRefGrade4 = By.xpath("//*[@id='6228a6f9cc5c3b068d477790']/div/div/div/h2");

	By MathFirstLessonFirstTopicRefGrade5 = By.xpath("//*[@id='6225ff0d50a3c5ff8177f83a']/div/div/div/h2");
	By MathFirstLessonSecondTopicRefGrade5 = By.xpath("//*[@id='6225ff0d1aabf5bae3ae7fde']/div/div/div/h2/span[2]");
	By MathFirstLessonThirdTopicRefGrade5 = By.xpath("//*[@id='6225ff0ded61257d6cf12d46']/div/div/div/h2/span[2]");



	By LessonHeading = By.xpath("/html/body/div[3]/div/div[2]/div/h1");



	// videocheck paths
	By EnvironmentalcoursebookGrade1 = By.xpath("//*[@id='61606a629e1fe601b5ee768c']/img");
//	By FirstLesson = By.xpath("//div[@id='item_1']");
//	By SecondLesson = By.xpath("//div[@id='item_2']");
//	By ThirdLesson = By.xpath("//div[@id='item_3']");
	By FirstLesson = By.id("item_1");
	By SecondLesson = By.id("item_2");
	By ThirdLesson = By.id("item_3");

//	By videosPageTab = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div[1]/div/button[2]");

	By videosPageTab = By.id("videos");
	By VideoWatchBtn = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div[2]/div[2]/div/div");

//	By VideoModalboxCloseBtn = By.xpath("/html/body/div[5]/div[1]/button");
//	By ContentsPageTab = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div[1]/div/button[1]");
//	By FirstTopic = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div[2]/a");
//	By SecondTopic = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div[3]/a/div/div");
//	By ThirdTopic = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div[4]/a/div/div");
//	By SecondTopicEng = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div[3]/a");
//	By ThirdTopicEng = By.xpath("/html/body/div[3]/div/div[2]/div/div/div/div/div[4]/a");
	By VideoModalboxCloseBtn = By.id("close_btn");
	By ContentsPageTab = By.id("contents");
	By FirstTopic = By.id("section_1");
	By SecondTopic = By.id("section_2");
	By ThirdTopic = By.id("section_3");
	By EnvVideoPathGrade1 = By.xpath("//*[@id='6220ae6ed7f6eba6ab133b62']/vm-hls/vm-video/vm-file/video");
	By EnglishCoursebookGrade2 = By.xpath("//*[@id='61606c609e1fe601b5ee7690']/img");
	By EngVideoPathGrade2 = By.xpath("//*[@id='6228a37120d7ac6ee7d2e2a1']/vm-hls/vm-video/vm-file/video");
	By EnglishCoursebookGrade3 = By.xpath("//*[@id='61606e699e1fe601b5ee7697']/img");
	By EngVideoPathGrade3 = By.xpath("//*[@id='6228b27ffc400b66ae89c2ee']/vm-hls/vm-video/vm-file/video");
	By MathematicsCoursebookGrade3 = By.xpath("//*[@id='61606ea59e1fe601b5ee7698']/img");
	By EnglishCoursebookGrade4 = By.xpath("//*[@id='616070b99e1fe601b5ee769f']/img");
	By EngVideoPathGrade4 = By.xpath("//*[@id='6228a6f9f706bdc5ad6d0189']/vm-hls/vm-video/vm-file/video");
	By MathematicsCoursebookGrade5 = By.xpath("//*[@id='616074c09e1fe601b5ee76a8']/img");
	By MathVideoPathGrade5 = By.xpath("//*[@id='6225ff0d25f26af7958b2a36']/vm-hls/vm-video/vm-file/video");
	By EnglishCoursebookGrade5 = By.xpath("//*[@id='6160748b9e1fe601b5ee76a7']/img");

	// search box paths
//	By SearchIcon = By.xpath("//img[@class='pointer']");
//	By SearchInput = By.xpath("//input[contains(@class,'search-box')]");
//	By HighlightTexts = By.xpath("//span[contains(@class,'j-highlight')]");
//	By TotalCount = By.xpath("//span[contains(@class,'total')]");
//	By WorkbookHeading = By.xpath("/html/body/header/div/div[1]/span");

	By SearchIcon = By.id("search_icon");
	By TeacherSearchIcon = By.xpath("//img[@class='pointer']");
	By SearchInput = By.id("search_box");
	By HighlightTexts = By.xpath("//span[contains(@class,'j-highlight')]");
	By TotalCount = By.id("search_total");

	By WorkbookHeading = By.id("book_title");

	// Audio check
	By AudioPlayer = By.xpath("//div[contains(@class,'audio-player')]");
	By AudioPlayBtn = By.xpath("//div[contains(@class,'player-controls')]/div/span");
	By CurrPlayTime = By.xpath("//div[contains(@class,'audio-time-slider')]/div/span");
	By EngCommunicationTopic = By.xpath("//div[text()='Communication Skills']");




	public Library(WebDriver driver2) {
		this.driver = driver2;
	}
	public WebElement StudentImageClick() {
		return driver.findElement(StudentImageClick);
	}
//	public WebElement TeacherLibraryToggle() {
//		return driver.findElement(TeacherLibraryToggle);
//	}
//	public WebElement StudentLibraryToggle() {
//		return driver.findElement(StudentLibraryToggle);
//	}
//	public WebElement BackButton() {
//		return driver.findElement(TeacherBackButton);
//	}

	public WebElement LibraryToggle() {return driver.findElement(LibraryToggle);}
	public WebElement BackButton() {
		return driver.findElement(BackButton);
	}

//	public WebElement TeacherBackButton(){
//		return driver.findElement(TeacherBackButton);
//	}

	// Grade Check
	public WebElement EnglishGradeTextGrade1(){return driver.findElement(EnglishGradeTextGrade1);}
	public WebElement EnglishGradeTextGrade2(){return driver.findElement(EnglishGradeTextGrade2);}
	public WebElement EnglishGradeTextGrade3(){return driver.findElement(EnglishGradeTextGrade3);}
	public WebElement EnglishGradeTextGrade4(){return driver.findElement(EnglishGradeTextGrade4);}
	public WebElement EnglishGradeTextGrade5(){return driver.findElement(EnglishGradeTextGrade5);}

	// lesson name verify
	public String LessonHeadingText(){
		String str = driver.findElement(LessonHeading).getText();
		return str.substring(2);
	}
	public WebElement FirstLessonText(){return driver.findElement(FirstLessonText);}
	public WebElement SecondLessonText(){return driver.findElement(SecondLessonText);}
	public WebElement ThirdLessonText(){return driver.findElement(ThirdLessonText);}
	public WebElement InsideLessonHeading(){return driver.findElement(InsideLessonHeading);}



	//lessons topic verify

	public WebElement EnvFirstLessonFirstTopicRefGrade1(){return driver.findElement(EnvFirstLessonFirstTopicRefGrade1);}
	public WebElement EnvFirstLessonSecondTopicRefGrade1(){return driver.findElement(EnvFirstLessonSecondTopicRefGrade1);}
	public WebElement EnvFirstLessonThirdTopicRefGrade1(){return driver.findElement(EnvFirstLessonThirdTopicRefGrade1);}

	public WebElement EngThirdLessonFirstTopicRefGrade2(){return driver.findElement(EngThirdLessonFirstTopicRefGrade2);}
	public WebElement EngThirdLessonSecondTopicRefGrade2(){return driver.findElement(EngThirdLessonSecondTopicRefGrade2);}
	public WebElement EngThirdLessonThirdTopicRefGrade2(){return driver.findElement(EngThirdLessonThirdTopicRefGrade2);}

	public WebElement MathFirstLessonFirstTopicRefGrade3(){return driver.findElement(MathFirstLessonFirstTopicRefGrade3);}
	public WebElement MathFirstLessonSecondTopicRefGrade3(){return driver.findElement(MathFirstLessonSecondTopicRefGrade3);}
	public WebElement MathFirstLessonThirdTopicRefGrade3(){return driver.findElement(MathFirstLessonThirdTopicRefGrade3);}

	public WebElement EngFirstLessonFirstTopicRefGrade4(){return driver.findElement(EngFirstLessonFirstTopicRefGrade4);}
	public WebElement EngFirstLessonSecondTopicRefGrade4(){return driver.findElement(EngFirstLessonSecondTopicRefGrade4);}
	public WebElement EngFirstLessonThirdTopicRefGrade4(){return driver.findElement(EngFirstLessonThirdTopicRefGrade4);}

	public WebElement MathFirstLessonFirstTopicRefGrade5(){return driver.findElement(MathFirstLessonFirstTopicRefGrade5);}
	public WebElement MathFirstLessonSecondTopicRefGrade5(){return driver.findElement(MathFirstLessonSecondTopicRefGrade5);}
	public WebElement MathFirstLessonThirdTopicRefGrade5(){return driver.findElement(MathFirstLessonThirdTopicRefGrade5);}



	// videoCheck
	public WebElement EnvironmentalcoursebookGrade1(){return driver.findElement(EnvironmentalcoursebookGrade1);}
	public WebElement FirstLesson(){return driver.findElement(FirstLesson);}
	public WebElement SecondLesson(){return driver.findElement(SecondLesson);}
	public WebElement ThirdLesson(){return driver.findElement(ThirdLesson);}
	public WebElement videosPageTab(){return driver.findElement(videosPageTab);}
	public WebElement VideoWatchBtn(){return driver.findElement(VideoWatchBtn);}
	public WebElement VideoModalboxCloseBtn(){return driver.findElement(VideoModalboxCloseBtn);}
	public WebElement ContentsPageTab(){return driver.findElement(ContentsPageTab);}
	public WebElement FirstTopic(){return driver.findElement(FirstTopic);}
	public WebElement SecondTopic(){return driver.findElement(SecondTopic);}
	public WebElement ThirdTopic(){return driver.findElement(ThirdTopic);}

//	public WebElement SecondTopicEng(){return driver.findElement(SecondTopicEng);}
//	public WebElement ThirdTopicEng(){return driver.findElement(ThirdTopicEng);}

	public WebElement EnvVideoPathGrade1(){return driver.findElement(EnvVideoPathGrade1);}
	public WebElement EnglishCoursebookGrade2(){return driver.findElement(EnglishCoursebookGrade2);}
	public WebElement EngVideoPathGrade2(){return driver.findElement(EngVideoPathGrade2);}
	public WebElement EnglishCoursebookGrade3(){return driver.findElement(EnglishCoursebookGrade3);}
	public WebElement EngVideoPathGrade3(){return driver.findElement(EngVideoPathGrade3);}
	public WebElement MathematicsCoursebookGrade3(){return driver.findElement(MathematicsCoursebookGrade3);}
	public WebElement EnglishCoursebookGrade4(){return driver.findElement(EnglishCoursebookGrade4);}
	public WebElement EngVideoPathGrade4(){return driver.findElement(EngVideoPathGrade4);}
	public WebElement MathematicsCoursebookGrade5(){return driver.findElement(MathematicsCoursebookGrade5);}
	public WebElement MathVideoPathGrade5(){return driver.findElement(MathVideoPathGrade5);}
	public WebElement EnglishCoursebookGrade5(){return driver.findElement(EnglishCoursebookGrade5);}

	// search box
	public WebElement TeacherSearchIcon(){return driver.findElement(TeacherSearchIcon);}
	public WebElement SearchIcon(){return driver.findElement(SearchIcon);}
	public WebElement SearchInput(){return driver.findElement(SearchInput);}
	public List<WebElement> HighlightTexts(){return driver.findElements(HighlightTexts);}
	public String TotalCount(){return driver.findElement(TotalCount).getText();}

	public WebElement WorkbookHeading(){return driver.findElement(WorkbookHeading);}

	// Audio Check
	public WebElement AudioPlayer(){return driver.findElement(AudioPlayer);}
	public WebElement AudioPlayBtn(){return driver.findElement(AudioPlayBtn);}
	public WebElement CurrPlayTime(){return driver.findElement(CurrPlayTime);}
	public WebElement EngCommunicationTopic(){return driver.findElement(EngCommunicationTopic);}


}
