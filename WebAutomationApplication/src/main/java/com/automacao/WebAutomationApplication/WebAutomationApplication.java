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

	private static final String URL = "https://www.tiktok.com/pt-BR";
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

			Thread.sleep(5000);

			WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginContainer\"]/div/div/div[2]"));
			loginButton.click();

			Thread.sleep(15000);

			WebElement emailInput = driver.findElement(By
					.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div"));
			emailInput.sendKeys("teytesss343@gmail.com");
			Thread.sleep(5000);

			WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
			passwordInput.sendKeys("Corujinhaead4m4");

			WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[3]"));
			nextButton.click();

			Thread.sleep(25000);

			WebElement element = driver.findElement(By.xpath(XPATH));
			element.click();

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}

