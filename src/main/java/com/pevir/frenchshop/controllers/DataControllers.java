package com.pevir.frenchshop.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pevir.frenchshop.dao.DataServicesDao;
import com.pevir.frenchshop.models.Article;
import com.pevir.frenchshop.models.LinkBody;

@RestController
public class DataControllers {

	private DataServicesDao dataServiceDao;

	public DataControllers(DataServicesDao dataServiceDao) {
		this.dataServiceDao = dataServiceDao;
	}

	@PostMapping("/french-shop/api/v1/article")
	public Article getData(@RequestBody LinkBody linkBody) {
		Article article = new Article();
		article = dataServiceDao.getDataByLink(linkBody);
		return article;

	}
}
