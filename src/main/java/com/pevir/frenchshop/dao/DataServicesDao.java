package com.pevir.frenchshop.dao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import com.pevir.frenchshop.models.Article;
import com.pevir.frenchshop.models.LinkBody;

@Component
public class DataServicesDao implements IDataServicesDao {

	@Override
	public Article getDataByLink(LinkBody linkBody) {
		Article article = new Article();
//		if(linkBody.getOrigin() == "amazon") {
//			article = getDataAmazon(linkBody);
//		}
		String origin = linkBody.getOrigin();
		switch (origin) {
		case "amazon":
			article = getDataAmazon(linkBody);
			break;
			
		case "shein":
//			article = null;
			break;
		default:
			break;
		}

		return article;
	}

	private Article getDataAmazon(LinkBody linkBody){
		String name;
		WebElement price1;
		double price;
		WebElement imagePath;
		String image;
		// Initialisation du driver de chrome
		ChromeOptions chromeOptions = new ChromeOptions();

		WebDriver driver = new ChromeDriver();
//		Ouvrir la page web
		driver.get(linkBody.getPath());

		name = driver.findElement(By.xpath("//*[@id=\"productTitle\"]")).getText();
		price1 = driver.findElement(By.className("a-offscreen"));
		price =Double.parseDouble(removeLastChar( price1.getAttribute("innerHTML")).replace(",","." ));
		imagePath = driver.findElement(By.xpath("//*[@id=\"landingImage\"]"));
		image = imagePath.getAttribute("src");
		Article article = new Article(1, name, price, image, linkBody.getOrigin());
		driver.quit();
		return article;

	}

	private static String removeLastChar(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		return str.substring(0, str.length() - 1);
	}

}
