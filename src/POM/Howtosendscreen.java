package POM;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.time.Duration;
import java.util.List;

public class Howtosendscreen {

    private static MobileElement element = null;
    private AndroidDriver<MobileElement> driver;

    public static void nowRadioButton (AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/nowRadioButton")).click();
    }


    public static void optionCheckBox_email(AndroidDriver driver){

        List<MobileElement> checkbox1 = driver.findElements(By.id("il.co.mintapp.buyme:id/optionCheckBox"));
        checkbox1.get(2).click();
    }

    public static void swipetonextbutton (AndroidDriver driver){

        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()." +
                "scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"il.co.mintapp.buyme:id/goNextButton\"))"));
        driver.findElement(By.id("il.co.mintapp.buyme:id/goNextButton")).click();
    }


    public static void enteremail (AndroidDriver driver){

        List<MobileElement> writemail = driver.findElements(By.id("il.co.mintapp.buyme:id/description"));
        writemail.get(1).sendKeys("yaakov123@gmail.com");
        driver.hideKeyboard();

    }

    public static void submittopayment (AndroidDriver driver){
        driver.findElement(By.id("il.co.mintapp.buyme:id/goNextButton")).click();
    }


    public Howtosendscreen(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }
}
