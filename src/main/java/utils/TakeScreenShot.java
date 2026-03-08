package utils;

import lombok.Data;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenShot {

    public static void takeScreenShot(TakesScreenshot screenshot){
        String fileName = createFileName();
    }

    private static String createFileName(){
        SimpleDateFormat formater = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        String currentDate = formater.format(date);
        System.out.println(currentDate);
        String fileName = "src/test/test_logs/screenshot/scr-"+ currentDate +".png";
        return fileName;
    }
}
