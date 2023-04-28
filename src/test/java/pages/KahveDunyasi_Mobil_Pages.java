package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.MobilBrowserDriver;

import java.net.MalformedURLException;
import java.nio.file.Watchable;

public class KahveDunyasi_Mobil_Pages {
    public KahveDunyasi_Mobil_Pages() throws MalformedURLException {
        PageFactory.initElements((WebDriver)MobilBrowserDriver.getAppiumDriver(), this);
    }

    @FindBy(xpath = "//button[@class='menuOpen hidden-lg-up']")
    public WebElement menuButton;

    @FindBy(xpath = "//*[@class='kahve']")
    public WebElement sectionKahve;

    @FindBy(xpath = "//*[@src='https://img-kahvedunyasi.mncdn.com/kahvedunyasi/static/img/icons/menu/turk_kahvesi.svg']")
    public WebElement linkTurkKahvesi;
    @FindBy(xpath = "//*[@class='modal-container']")
    public WebElement advertisement;

    @FindBy(xpath="//*[@class='modal-close']")
    public WebElement buttonClose;

    @FindBy(xpath = "//h1[text()='Türk Kahvesi ']")
    public WebElement labelTurkKahvesi;

    @FindBy(xpath = "(//*[text()='SEPETE EKLE'])[1]")
    public WebElement buttonSepeteEkle;

    @FindBy(xpath = "//*[@class='product-add-modal__content']")
    public WebElement textSepeteEklenme;

    @FindBy(xpath = "//*[text()='Orta Kavrulmuş Türk Kahvesi 100g']")
    public WebElement arananUrun;

    @FindBy(xpath = "//a[text()='SEPETE GİT']")
    public WebElement buttonSepeteGit;

    @FindBy(xpath = "//*[@class='spinner-plus']")
    public WebElement buttonIncreaseProduct;

    @FindBy(xpath = "//*[text()='Sepet']")
    public WebElement textSepet;

    @FindBy(xpath = "//*[@class='yellow-price']")
    public WebElement totalPrice;

    @FindBy(xpath = "//a[@class='btn btnGreen']")
    public WebElement buttonAlisverisiTamamla;

    @FindBy(xpath = "//*[@class='step sm-mb30 xs-mb30 sm-ml10 md-ml30 lg-ml0']")
    public WebElement headersCheckoutPage;

}
