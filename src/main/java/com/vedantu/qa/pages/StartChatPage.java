package com.vedantu.qa.pages;

import com.vedantu.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartChatPage extends TestBase {

    @FindBy(xpath ="//input[@placeholder='choose a room name']")
    WebElement chatRoom;

    @FindBy(xpath ="//button[text() = 'Start a chat']")
    WebElement startChatButton;


    public StartChatPage() {
        PageFactory.initElements(driver, this);
    }


    public String validateStartChatPage(){
        String title = driver.getTitle();
        return title;
    }

    public void inputChatRoomName( String chatroom_name){
        chatRoom.sendKeys(chatroom_name);
    }

    public void startChat(){
        startChatButton.click();
    }
}
