package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnRegisterLink();
        registerPage.verifyRegisterPageText("Register");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandetory() {
        homePage.clickOnRegisterLink();
        registerPage.registerButtonClick();
        registerPage.verifyFirstNameErrorMessage("First name is required.");
        registerPage.verifyLastNameErrorMessage("Last name is required.");
        registerPage.verifyEmailErrorMessage("Email is required.");
        registerPage.verifyPasswordErrorMessage("Password is required.");
        registerPage.verifyConfirmPasswordErrorMessage("Password is required.");
    }


    @Test(groups = {"regression"})
    public void VerifyThatUserShouldCreateAccountSuccessfully() {
        homePage.clickOnRegisterLink();
        registerPage.selectGender("Male");
        registerPage.firstNameClick("abc");
        registerPage.lastNameClick("xyz");
        registerPage.selectDateOfBirth("11", "November", "2011");
        registerPage.enterEmailId("acb00101@yahoo.com");
        registerPage.passwordClick("password");
        registerPage.confirmPasswordClick("password");
        registerPage.registerButtonClick();
        registerPage.verifyRegisterText("Your registration completed");
    }


}
