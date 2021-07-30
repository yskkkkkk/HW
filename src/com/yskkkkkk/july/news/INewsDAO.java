package com.yskkkkkk.july.news;

import java.util.List;

public interface INewsDAO {

	List<News> getNewsList(String url);
	News search(int index);
}
