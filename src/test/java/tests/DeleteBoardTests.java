package tests;

import dto.Board;
import dto.User;
import manager.AppManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyBoardPage;

public class DeleteBoardTests extends AppManager {
    @BeforeMethod(alwaysRun = true)
    public void loginCreateBoard(){
        User user = User.builder().email("konstantinmqatest@gmail.com")
                .password("Password123!QA").build();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
        new LoginPage(getDriver()).login(user);
        Board board = Board.builder().boardTitle("11122").build();
        new BoardsPage(getDriver()).createNewBoard(board);

    }

    @Test
    public void deleteBoardPositiveTest(){
        new MyBoardPage(getDriver())
                .validateBoardName("11122",5);
        new MyBoardPage(getDriver()).deleteBoard();
    }
}
