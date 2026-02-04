package tests;

import dto.User;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends AppManager {

    @Test
    public void loginPositiveTest(){
        User user = User.builder().email("konstantinmqatest@gmail.com")
                .password("Password123!QA").build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Assert.assertTrue(new BoardsPage(getDriver())
                .validateUrl("boards"));
    }
}
