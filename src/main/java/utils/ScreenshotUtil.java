package utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Screenshots;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = screenshotName + "_" + timestamp + ".png";
        String screenshotPath = ConfigReader.getProperty("screenshot.path") + fileName;

        try {
            File screenshotDir = new File(ConfigReader.getProperty("screenshot.path"));
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
            }

            String screenshotFilePath = Selenide.screenshot(screenshotName);

            if (screenshotFilePath != null) {
                File sourceFile = new File(screenshotFilePath);
                File destinationFile = new File(screenshotPath);
                Files.copy(sourceFile.toPath(), destinationFile.toPath(),
                          StandardCopyOption.REPLACE_EXISTING);

                System.out.println("Screenshot saved at: " + screenshotPath);
                return screenshotPath;
            } else {
                System.out.println("Failed to capture screenshot");
                return null;
            }

        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
            return null;
        }
    }

    public static String takeScreenshot() {
        String screenshotPath = Selenide.screenshot("screenshot_" + System.currentTimeMillis());
        if (screenshotPath != null) {
            System.out.println("Screenshot saved at: " + screenshotPath);
        }
        return screenshotPath;
    }
}
