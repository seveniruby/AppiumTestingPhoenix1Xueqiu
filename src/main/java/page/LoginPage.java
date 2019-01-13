package page;

import driver.Driver;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By other=text("手机及其他登录");
    private By passwordLogin=text("邮箱手机号密码登录");
    private By username=By.id("login_account");
    private By password=By.xpath("//*[@password='true']");
    private By login=By.id("button_next");
    By msg=By.id("md_content");

    String message;

    public LoginPage passwordFail(String username, String password){
        find(other).click();
        find(passwordLogin).click();
        find(this.username).sendKeys(username);
        find(this.password).sendKeys(password);
        find(login).click();
        message=find(msg).getText();
        find(By.id("md_buttonDefaultPositive")).click();
        return this;
    }

    public MainPage passwordSuccess(String username, String password){
        find(other).click();
        find(passwordLogin).click();
        find(this.username).sendKeys(username);
        find(this.password).sendKeys(password);
        find(login).click();
        return new MainPage();
    }

    public String getMessage(){
        return message;
    }

    public ProfilePage gotoProfile(){
        //find(By.id("iv_close")).click();
        //find(By.id("iv_action_back")).click();
        find(By.xpath("//*[contains(@resource-id, 'iv_close') or contains(@resource-id, 'iv_action_back')]")).click();
        return new ProfilePage();
    }

}
