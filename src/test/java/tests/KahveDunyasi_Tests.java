package tests;


import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KahveDunyasi_Pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.*;

public class KahveDunyasi_Tests extends TestBaseRapor {
    KahveDunyasi_Pages kDElements = new KahveDunyasi_Pages();

    @Override
    public void reportInformation() {
        reportOwnersName = "Yavuz Selim";
        reportName = "Kahve Dunyasi Web Automation_";
        reportPageHeader = "Turkish Coffee buying test";
        documentsTitle = "Kahve Dunyasi Test";
    }

    @Test
    public void TC_001() {

        extentTest = extentReports.createTest("WEB_TC_001", "Turkish coffee page opening test");
        // go to kahvedunyasi.com homepage
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Homepage opened");

        // Verify that kahvedunyasi homepage is opened correctly
        String kdStr = "kahvedunyasi.com";
        assertTrue(Driver.getDriver().getCurrentUrl().contains(kdStr));
        extentTest.info("Kahve Dunyasi homepage is opened correctly");

        // close the advertisement
        ReusableMethods.bekle(3);
        if (kDElements.advertisement.isDisplayed()) {
            kDElements.buttonClose.click();
        }

        // Go to the "Kahve" section
        ReusableMethods.bekle(3);
        ReusableMethods.hover(kDElements.linkKahve);

        // Click on a Turk Kahvesi product and verify that the relevant product page opens.
        assertTrue(kDElements.linkTurkKahvesi.isDisplayed());
        kDElements.linkKahve.click();

        // verify that the Turk Kahvesi Page is opened correctly
        ReusableMethods.bekle(3);
        String turkKahveStr = "Kahve Çeşitleri";
        assertTrue(Driver.getDriver().getTitle().contains(turkKahveStr));
        extentTest.info("Turkish coffee page opened correctly");
    }

    @Test
    public void TC_002() {

        extentTest = extentReports.createTest("WEB_TC_002", "Test for adding Turkish coffee products to cart");

        // verify that the finding product is displayed
        kDElements.linkKahve.sendKeys(Keys.PAGE_DOWN);
        assertTrue(kDElements.arananUrun.isDisplayed());


        // click on the "sepete ekle" button of the relevant product
        kDElements.buttonSepeteEkle.click();
        extentTest.info("Turkish coffee product has been added to cart");

        // verified that the warning appears that the product has been added to the cart
        ReusableMethods.bekle(2);
        assertTrue(kDElements.textSepeteEklenme.isDisplayed());
        extentTest.info("It has been confirmed that Turkish coffee has been added to cart");
    }

    @Test
    public void TC_003() {
        extentTest = extentReports.createTest("WEB_TC_003", "Test of quantity change and purchase of Turkish coffees in the cart");
        // click the sepete git button
        kDElements.buttonSepeteGit.click();

        // verify that the Sepet page opened successfully
        ReusableMethods.bekle(2);
        assertTrue(kDElements.textSepet.isDisplayed());
        extentTest.info("Went to the cart page successfully");

        //verify that the price changes when increase the number of products
        ReusableMethods.bekle(2);
        String firstPrice = kDElements.totalPrice.getText();
        kDElements.buttonIncreaseProduct.click();
        kDElements.buttonIncreaseProduct.click();
        ReusableMethods.bekle(2);
        String lastPrice = kDElements.totalPrice.getText();
        assertNotEquals(firstPrice, lastPrice);
        extentTest.info("Effect of increasing the number of products on price confirmed");

        // click the "Alisverisi Tamamla" button
        kDElements.buttonAlisverisiTamamla.click();

        // verify that the checkout page is opened correctly
        ReusableMethods.bekle(3);
        assertTrue(kDElements.headersCheckoutPage.isDisplayed());
        extentTest.info("Checkout page is opened correctly");

        // close driver
        Driver.closeDriver();
    }
}
