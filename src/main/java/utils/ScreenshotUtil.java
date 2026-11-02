package utils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class ScreenshotUtil {
	
	public static String captureScreenshot(WebDriver driver, String scenarioName) {
		
		
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		
		String fileName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";
		
		Path destination = Paths.get(
                "target", "screenshots", fileName);
		

        try {
            Files.createDirectories(destination.getParent());

            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);

            Files.copy(source.toPath(), destination);

            return destination.toString();

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to capture screenshot", e);
        }

		
	}

}
