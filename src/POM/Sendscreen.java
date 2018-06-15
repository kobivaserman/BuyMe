package POM;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

public class Sendscreen {

    private static MobileElement element = null;
    private final AndroidDriver<MobileElement> driver;


    public static void towhomthegift(AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/toEditText")).sendKeys("Dear Einat");
        driver.hideKeyboard();
    }

    public static void watkindofevent(AndroidDriver driver){
        driver.findElement(By.id("android:id/text1")).click();
    }

    public static void pickabless(AndroidDriver driver){

        List<MobileElement> blesslist = driver.findElements(By.id("android:id/text1"));
        blesslist.get(8).click();
    }

    public static void blessEditText(AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/blessEditText")).clear();
        driver.findElement(By.id("il.co.mintapp.buyme:id/blessEditText")).sendKeys("Gote morgan my sunshine!");
        driver.hideKeyboard();
    }


    public static void scrolldown(AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/scrollArrows")).click();
    }


    public static void whosendthegift(AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/userFrom")).clear();
        driver.findElement(By.id("il.co.mintapp.buyme:id/userFrom")).sendKeys("Yaakov");
        driver.hideKeyboard();
    }

    public static void submit (AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/goNextButton")).click();
    }




    public Sendscreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }
}
