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
	/**
	 * Méthode permettant de récuperer les données d'une page et fonction du site 
	 */
	public Article getDataByLink(LinkBody linkBody) {
		Article article = new Article();

		String origin = linkBody.getOrigin();
		switch (origin) {
		case "amazon":
			article = getDataAmazon(linkBody);
			break;
			
		case "shein":
			article = getDataShein(linkBody);
			break;
		default:
			break;
		}

		return article;
	}

	/**
	 * Méthode pour récuperer le nom, le prix, et l'image sur la page de détail de la page amazon
	 * 
	 * @author katina
	 * 
	 * @param linkBody
	 * @return Article
	 */
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
	

	/**
	 * Méthode pour récuperer le nom, le prix, et l'image sur la page de détail de la page shein
	 * 
	 * @author katina
	 * 
	 * @param linkBody
	 * @return Article
	 */
	private Article getDataShein(LinkBody linkBody){
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

		name = driver.findElement(By.xpath("//*[@id=\"goods-detail-v3\"]/div/div[1]/div/div[2]/div[2]/div/div[1]/h1")).getText();
		price1 = driver.findElement(By.xpath("//*[@id=\"goods-detail-v3\"]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/div/span"));
		price =Double.parseDouble(removefirstChar( price1.getAttribute("innerHTML")).replace(",","." ));
		imagePath = driver.findElement(By.xpath("//*[@id=\"goods-detail-v3\"]/div/div[1]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/img"));
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
	
	  public static String removefirstChar(String str)
	    {
	        if (str == null || str.length() == 0) {
	            return str;
	        }
	        return str.substring(1);
	    }

}
