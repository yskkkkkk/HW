package com.yskkkkkk.july.news;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NewsMain {
	JFrame jFrame;
	JButton jButton;
	JList list;
	JTextArea jTextArea;

	INewsDAO dao;
	
	public NewsMain() {

//		dao = new NewsDAODOMImpl();
		dao = new NewsDAOSAXImpl();

		createGUI();
		addEvent();
		showList();
	}
	
	public void createGUI() {
		jFrame= new JFrame("NewsList");
		JPanel p = new JPanel();
		jButton = new JButton("News List 호출");
		list = new JList();
		jTextArea = new JTextArea("");
		jTextArea.setLineWrap(true);
		p.setLayout(new BorderLayout());
		p.add(jButton, "North");
		p.add(list);
		
		jFrame.setLayout(new GridLayout(2,1,5,5));
		jFrame.add(p);
		jFrame.add(jTextArea);
		jFrame.setSize(800,800);
		jFrame.setVisible(true);
	}
	public void addEvent() {
		jFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				System.exit(0);
			}
		});
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showList();
			}
		});
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				News n = (News)list.getSelectedValue();
				jTextArea.setText(n.getDesc());
			}
		});
	}
	public void showList() {
		java.util.List<News> datas = dao.getNewsList("http://rss.etnews.com/Section902.xml");
		list.removeAll();
		list.setListData(datas.toArray());
	}
	
	
	public static void main(String[] args) {
		new NewsMain();
	}

}