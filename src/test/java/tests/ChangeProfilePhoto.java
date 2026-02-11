package tests;

import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AtlassianProfilePage;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class ChangeProfilePhoto extends AppManager {
    BoardsPage boardsPage;

    @BeforeMethod
    public void login(){
        User user = User.builder().email("konstantinmqatest@gmail.com")
                .password("Password123!QA").build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        boardsPage = new BoardsPage(getDriver());
}
@Test
    public void changeProfilePhoto(){
        boardsPage.openMyAccount();
    List<String> tabs =new ArrayList<>(getDriver().getWindowHandles());
    System.out.println(tabs);
    getDriver().switchTo().window(tabs.get(1));
    AtlassianProfilePage atlassianProfilePage =new AtlassianProfilePage
            (getDriver());
    atlassianProfilePage.changeMyProfilePhoto
            ("src/main/resources/img.jpg");

}
}
