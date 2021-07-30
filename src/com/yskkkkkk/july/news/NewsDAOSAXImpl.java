package com.yskkkkkk.july.news;

import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO{//구현체
    List<News> list;
	
    News news;
    String content;
    
	@Override
	public List<News> getNewsList(String url) {
		list = new ArrayList<>();
		connectNews(url);
		
		return list;
	}

	@Override
	public News search(int index) {
		return null;
	}

    private void connectNews(String url) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
//		SAXHandler sh = new SAXHandler();
//		parser.parse(url, sh);
			parser.parse(url, new SAXHandler());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//connectNews
    
    /////////////////////////////  <내부클래스 시작> //////////////////////////////////////
    public class SAXHandler extends DefaultHandler {
    	StringBuilder b;
    	boolean flag;//기본값 false
    	News n;
   	
    	@Override
    	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
              if(qName.equals("item")) {
            	  news = new News();
            	  flag = true;
              }
    	}

    	@Override
    	public void endElement(String uri, String localName, String qName) throws SAXException {
    		//qName == 태그명
    	   	
    		if(qName.equals("item")) {
    			list.add(news);
    			news = null;
    			flag = false;
    			
    		}else if(qName.equals("title")) {
    			if(flag)news.setTitle(content);
    		}else if(qName.equals("link")) {
    			if(flag)news.setLink(content);
    	    }else if(qName.equals("description")) {
    	    	if(flag)news.setDesc(content);
            }

    	}//endElement

    	@Override
    	public void characters(char[] ch, int start, int length) throws SAXException {
              content = new String(ch,start,length);
    	}

    }//inner class

}
