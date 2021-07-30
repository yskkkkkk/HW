package com.yskkkkkk.july.news;

import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class NewsDAODOMImpl implements INewsDAO {
	List<News> list;
	Document doc;
	
	@Override
	public List<News> getNewsList(String url) {
		list = new ArrayList<>();
		
		connectNews(url);
		NodeList  itemList= doc.getElementsByTagName("item");
		/*
		<item>
				<title>
				<![CDATA[ [카드뉴스]자동차 경고등, 왜 켜질까? ]]>
				</title>
				<link>https://www.etnews.com/20210719000218</link>
				<description>
				<![CDATA[ 운전 중 갑자기 계기판에 뜬 경고등에 당황한 적 있나요? 이유를 알면 해결 방법을 쉽게 찾을 수 있습니다. 김상희기자 hee0221@etnews.com ]]>
				</description>
				<author>
				<![CDATA[ 김상희 ]]>
				</author>
				<guid>20210719000218</guid>
				<comments>https://www.etnews.com/20210719000218</comments>
				<pubDate>Fri, 30 Jul 2021 07:00:00 +0900</pubDate>
          </item>
		 */
		for(int i=0; i<itemList.getLength(); i++) {
			 Node n = itemList.item(i);
			 NodeList  childList = n.getChildNodes();
			 
			 News news = new News();//item의 수만큼 News객체 생성			 
			 
//			 System.out.println("item자식의 개수: "+childList.getLength());  ==> 15
			 for(int j=0; j<childList.getLength(); j++) {
				 if(childList.item(j).getNodeType()== Node.ELEMENT_NODE) {//노드 구분 (태그, 텍스트)
					 String tagName = childList.item(j).getNodeName();
					 if( tagName.equals("title")) {  //태그명 얻기   <title>[카드뉴스]자동차 경고등, 왜 켜질까?</title>
//						 childList.item(j).getTextContent(); //[카드뉴스]자동차 경고등, 왜 켜질까?
						 news.setTitle(childList.item(j).getTextContent());
					 }else if (tagName.equals("link")) {
						 news.setLink(childList.item(j).getTextContent());
					 }else if (tagName.equals("description")) {
						 news.setDesc(childList.item(j).getTextContent());
						 break;
					 }
				 }
			 }
			 list.add(news);
		}
		return list;
	}

	@Override
	public News search(int index) {
		return null;
	}
	
	private void connectNews(String url) {
	   //공장(Factory) - 일꾼(Parser) - 파싱
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			doc = builder.parse(url);//DOM Programming의 시작!!
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}//connectNews

}