package tests;

import data_providers.BoardDP;
import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

public class BoardTests extends AppManager {

    @BeforeMethod(alwaysRun = true)
    public void login(){
        User user = User.builder().email("konstantinmqatest@gmail.com")
                .password("Password123!QA").build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        new LoginPage(getDriver()).login(user);
    }

    @Test
    public void createNewBoardPositiveTest(){
        Board board = Board.builder().boardTitle("11122").build();
        new BoardsPage(getDriver()).createNewBoard(board);
        new MyBoardPage(getDriver()).validateBoardName("11122",5);
    }

    @Test(dataProvider = "dataProviderBoards",dataProviderClass = BoardDP.class)
    public void createNewBoardPositiveTest_FromDP(Board board){
        new BoardsPage(getDriver()).createNewBoard(board);
    }


}
