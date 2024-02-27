import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Homework23 extends BaseTest{
    @Test
    public void loginWithCorrectCredentialsUsingPageFactory() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //Steps
        loginPage.provideEmailToLogin("demo@class.com")
                .providePasswordToLogin("te$t$tudent")
                .clickSubmitBtnToLogin();
        //Assertions
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }


}

