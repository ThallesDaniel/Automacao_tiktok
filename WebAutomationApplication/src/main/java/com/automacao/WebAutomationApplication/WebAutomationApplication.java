package com.automacao.WebAutomationApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import io.github.bonigarcia.wdm.WebDriverManager;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class WebAutomationApplication {

	private static final String URL = "https://www.tiktok.com/pt-BR/";
	private static final String XPATH = "//*[@id=\"main-content-homepage_hot\"]/div[1]/div[2]/div/div[2]/div[2]/button[1]/span";

	public static void main(String[] args) {
		SpringApplication.run(WebAutomationApplication.class, args);
	}

	@Scheduled(fixedDelay = 1000)
	public void automateWebActions() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {
			driver.get(URL);

			WebElement element = driver.findElement(By.xpath(XPATH));
			element.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500)");

			Thread.sleep(30 * 60 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
