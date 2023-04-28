package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileBrowserType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.KahveDunyasi_Mobil_Pages;
import pages.KahveDunyasi_Pages;
import utilities.ConfigReader;
import utilities.MobilBrowserDriver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.net.MalformedURLException;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertTrue;

public class KahveDunyasi_Mobil_Tests extends TestBaseRapor {

    AppiumDriver driver;
    KahveDunyasi_Mobil_Pages mobilePage = new KahveDunyasi_Mobil_Pages();

    {
        try {
            driver = MobilBrowserDriver.getAppiumDriver();
        } catch (
                MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }

    public KahveDunyasi_Mobil_Tests() throws MalformedURLException {
    }

    @Override
    public void reportInformation() {
        reportOwnersName = "Yavuz Selim";
        reportName = "Kahve Dunyasi Mobil Automation_";
        reportPageHeader = "Turkish Coffee buying test";
        documentsTitle = "Kahve Dunyasi Test";
    }

    @Test
    public void TC_001() {
        extentTest = extentReports.createTest("MOBIL_TC_001", "Turkish coffee page opening test");
        // go to kahvedunyasi.com homepage
        driver.get(ConfigReader.getProperty("url"));
        //extentTest.info("Homepage opened");
        extentTest.info("Homepage opened");

        // close the advertisement
        ReusableMethods.bekle(3);
     //   if (mobilePage.advertisement.isDisplayed()) {
      //     mobilePage.buttonClose.click();}

        //go to the kahve section in dropdown
        ReusableMethods.bekle(3);
        mobilePage.menuButton.click();
        mobilePage.sectionKahve.click();
        ReusableMethods.bekle(2);

        // click on a Turk kahvesi product and verify that the relevant product page opens
        mobilePage.linkTurkKahvesi.click();
        ReusableMethods.bekle(3);

        // verify that the Turk Kahvesi page is opened correctly
        assertTrue(mobilePage.labelTurkKahvesi.isDisplayed());
        extentTest.info("Turkish coffee page opened correctly");
    }

    @Test
    public void TC_002() {
        extentTest = extentReports.createTest("MOBIL_TC_002", "Test for adding Turkish coffee products to cart");

        // verify that the finding product is displayed
        assertTrue(mobilePage.arananUrun.isDisplayed());

        // click on the "sepete ekle" button of the relevant product
        mobilePage.buttonSepeteEkle.click();
        extentTest.info("Turkish coffee product has been added to cart");

        // verified that the warning appears that the product has been added to the cart
        ReusableMethods.bekle(2);
        assertTrue(mobilePage.textSepeteEklenme.isDisplayed());
        extentTest.info("It has been confirmed that Turkish coffee has been added to cart");
    }

    @Test
    public void TC_003() {
        extentTest = extentReports.createTest("MOBIL_TC_003", "Test of quantity change and purchase of Turkish coffees in the cart");
        // click the sepete git button
        ReusableMethods.bekle(2);
        mobilePage.buttonSepeteGit.click();

        // verify that the Sepet page opened successfully
        ReusableMethods.bekle(3);
        assertTrue(mobilePage.textSepet.isDisplayed());
        extentTest.info("Went to the cart page");

        //verify that the price changes when increase the number of products
        ReusableMethods.bekle(2);
        String firstPrice = mobilePage.totalPrice.getText();
        mobilePage.buttonIncreaseProduct.click();
        mobilePage.buttonIncreaseProduct.click();
        ReusableMethods.bekle(2);
        String lastPrice = mobilePage.totalPrice.getText();
        assertNotEquals(firstPrice, lastPrice);
        extentTest.info("Effect of increasing the number of products on price confirmed");

        // click the "Alisverisi Tamamla" button
        mobilePage.buttonAlisverisiTamamla.click();

        // verify that the checkout page is opened correctly
        ReusableMethods.bekle(3);
        assertTrue(mobilePage.headersCheckoutPage.isDisplayed());
        extentTest.info("Checkout page is opened correctly");

        driver.quit();
    }
}


