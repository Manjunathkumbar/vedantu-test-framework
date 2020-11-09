package com.vedantu.qa;

import com.vedantu.qa.base.TestBase;
import com.vedantu.qa.pages.HomePage;
import com.vedantu.qa.pages.JoinCallPage;
import com.vedantu.qa.pages.StartChatPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class VedantuE2ETest extends TestBase {

    StartChatPage startchatpage;
    JoinCallPage joincallpage;
    HomePage homepage;

    public VedantuE2ETest() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        initialization();
        startchatpage= new StartChatPage();
        joincallpage= new JoinCallPage();
        homepage= new HomePage();

    }

    @Test
    public void validateUsersareAbleJoinCall() {

        startchatpage.inputChatRoomName("testChatWindow");
        startchatpage.startChat();
        joincallpage.joinCall();
        String title = joincallpage.validateJoinCallPage();
        Assert.assertEquals("Talky",title );
    }

    @Test( dependsOnMethods = "validateUsersareAbleJoinCall" )
    public void validateUsersareAbleJoinCallForSameChatRoom(){

        startchatpage.inputChatRoomName("testChatWindow");
        startchatpage.startChat();
        joincallpage.joinCall();
        boolean isdisplayed = homepage.connecteduserDisplay();
        Assert.assertEquals(isdisplayed ,true);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
