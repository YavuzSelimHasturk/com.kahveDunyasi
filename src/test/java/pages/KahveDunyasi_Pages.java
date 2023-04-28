package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class KahveDunyasi_Pages {
    public KahveDunyasi_Pages() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="(//*[@href='/kahve-c-1798'])[1]")
    public WebElement linkKahve;

    @FindBy(xpath = "(//*[@class='modal-body'])[1]")
    public WebElement advertisement;

    @FindBy(xpath="//*[@class='modal-close']")
    public WebElement buttonClose;

    @FindBy(xpath="(//*[text()='Türk Kahvesi'])[1]")
    public WebElement linkTurkKahvesi;

    @FindBy(xpath = "//*[text()='Orta Kavrulmuş Türk Kahvesi 100g']")
    public WebElement arananUrun;

    @FindBy(xpath = "(//*[@value='SEPETE EKLE'])[1]")
    public WebElement buttonSepeteEkle;

    @FindBy(xpath = "//*[@class='product-add-modal__content']")
    public WebElement textSepeteEklenme;

    @FindBy(xpath = "//a[text()='SEPETE GİT']")
    public WebElement buttonSepeteGit;

    @FindBy(xpath = "//*[text()='Sepet']")
    public WebElement textSepet;

    @FindBy(xpath = "//*[@class='yellow-price']")
    public WebElement totalPrice;

    @FindBy(xpath = "//*[@class='spinner-plus']")
    public WebElement buttonIncreaseProduct;

    @FindBy(xpath = "//a[@class='btn btnGreen']")
    public WebElement buttonAlisverisiTamamla;

    @FindBy(xpath = "//*[@class='step sm-mb30 xs-mb30 sm-ml10 md-ml30 lg-ml0']")
    public WebElement headersCheckoutPage;


}
