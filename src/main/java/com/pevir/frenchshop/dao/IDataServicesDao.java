package com.pevir.frenchshop.dao;

import com.pevir.frenchshop.models.Article;
import com.pevir.frenchshop.models.LinkBody;

public interface IDataServicesDao {

	Article getDataByLink(LinkBody linkBody);

}
