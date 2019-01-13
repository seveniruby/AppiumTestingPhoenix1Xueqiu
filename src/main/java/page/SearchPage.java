package page;

import driver.Driver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SearchPage extends BasePage{
    public SearchPage search(String keyword){
        find(By.className("android.widget.EditText")).sendKeys(keyword);
        return this;
    }
    public MainPage cancel(){
        find(By.id("action_close")).click();
        return new MainPage();
    }

    public ArrayList<String> getAll(){
        ArrayList<String> array=new ArrayList<String>();
        for(WebElement e: Driver.getCurrentDriver().findElements(By.id("stockName"))){
            array.add(e.getText());
        }
        return array;

    }

    public SearchPage getByStock(){
        return  this;

    }

    public ArrayList<String> addSelected(){
        ArrayList<String> array=new ArrayList<String>();
        AndroidElement select=(AndroidElement) find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        array.add(select.getAttribute("resourceId"));
        select.click();
        AndroidElement select2=(AndroidElement)find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        array.add(select2.getAttribute("resourceId"));
        return array;

    }

    public SearchPage removeSelected(){
        return this;

    }
}
