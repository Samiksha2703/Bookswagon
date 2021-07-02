package com.bridgelabz.bookswagon;

import com.bridgelabz.bookswagon.base.Base;
import com.bridgelabz.bookswagon.pages.Dashboard;
import com.bridgelabz.bookswagon.pages.Login;
import com.bridgelabz.bookswagon.utility.CustomException;
import com.bridgelabz.bookswagon.utility.Utility;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.ExpectedExceptionsHolder;

import java.io.IOException;

public class BuyBookWithTopics extends Base {
    Login login;
    Dashboard dashboard;

    static Logger log = Logger.getLogger(BooksWagonTest.class.getName());

    //test to check functionality for login
    @Test(priority = 1)
    public void login_Into_Account() throws InterruptedException, IOException {
        login = new Login(webdriver);
        Boolean check = login.loginIntoAccount("shende.samiksha@rediffmail.com", "BookswagonSamiksha");
        if (check) {
            test.log(LogStatus.PASS, test.addScreenCapture(Utility.screenshot("loginPage")));
        } else {
            test.log(LogStatus.FAIL, test.addScreenCapture(Utility.screenshot("loginPage")));
        }
        Assert.assertTrue(check);
        log.info("Test case to check the login functionality");
    }

    //test to check the functionality of Books module
    @Test
    public void buyBook_WithGivenTopic() throws InterruptedException, CustomException {
        dashboard = new Dashboard(webdriver);
        try {
            Boolean check = dashboard.BuyBook(webdriver, "Lifestyle");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (CustomException e) {
            e.printStackTrace();
            //Assert.assertEquals("Searched Topic is not found in the list",e.getMessage());
        }
    }
}
