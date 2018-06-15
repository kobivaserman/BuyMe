package POM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

public class Enterandhomescreen {

    private static MobileElement element = null;
    private final AndroidDriver<MobileElement> driver;


    public static void googleButtontoreg (AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/googleButton")).click();
    }

    public static void choosecategor(AndroidDriver driver){

        List<MobileElement> giftsList = driver.findElements(By.id("il.co.mintapp.buyme:id/t_title"));
        giftsList.get(2).click();
    }


    public static void chooseabusiness (AndroidDriver driver){

        List<MobileElement> giftsList = driver.findElements(By.id("il.co.mintapp.buyme:id/businessName"));
        giftsList.get(1).click();
    }


    public static void writesumofmoney (AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/priceEditText")).sendKeys("200");
    }


    public static void submittonextpage (AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/purchaseButton")).click();
    }


    public Enterandhomescreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }
}

