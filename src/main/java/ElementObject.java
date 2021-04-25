import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementObject {
    @FindBy(css = "div[class='desk-notif-card__login-new-item-title']")
    private WebElement enter;//первичная кнопка входа

    @FindBy(css = "input[class='Textinput-Control']")
    private WebElement inputLogin;

    @FindBy(css = "button[type='submit']")
    private WebElement enterButton; //Кнопка входа после введения логина и пароля ( используется дважды)

    @FindBy(css = "input[data-t='field:input-passwd']")
    private WebElement inputPass;

    @FindBy(css = "div[class='desk-notif-card__mail-title']")
    private WebElement mailButton;

    @FindBy(css = "span>span>span>span[title='Simbirsoft theme']")
    private List<WebElement> letters;

    @FindBy(css = "span[class='mail-ComposeButton-Text']")
    private WebElement createLetterButton;

    @FindBy(xpath = ".//span[text()='Кому']/../../div/div/div")
    private WebElement fieldTo;

    @FindBy(xpath = ".//span[text()='Тема']/../../div/input")
    private WebElement fieldTheme;

    @FindBy(css = "div[placeholder='Напишите что-нибудь']")
    private WebElement fieldText;

    @FindBy(xpath = ".//span[text()='Отправить']/../../..")
    private WebElement sendLetterButton;

    private WebDriver driver;
    private WebDriverWait wait;

    public ElementObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public void clickEnter() {
        enter.click();
    }

    public void clickLoginEnter() {
        enterButton.click();
    }

    public void clickMailButton() {
        mailButton.click();
    }

    public void sendLogin(String login) {
        inputLogin.sendKeys(login);
    }

    public void sendPass(String pass) {
        inputPass.sendKeys(pass);
    }

    public void createLetter() {
        createLetterButton.click();
    }

    public void sendTo(String who) {
        fieldTo.sendKeys(who);
    }

    public void sendTheme(String theme) {
        fieldTheme.sendKeys(theme);
    }

    public void sendText(String text) {
        fieldText.sendKeys(text);
    }

    public void clickSendButton() {
        sendLetterButton.click();
    }

    public Integer getCountLetters() {
        return letters.size();
    }

}
