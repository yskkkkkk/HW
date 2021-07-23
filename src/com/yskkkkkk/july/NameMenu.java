package com.yskkkkkk.july;

public class NameMenu {

	boolean insertName(String name, String[] names) {
		boolean result = false;
		for (int i = 0; i < names.length; i++) {
			if(names[i]==null) {
				names[i] = name;
				result = true;
				break;
			}
		}
		return result;
	};
	
	void updateName(String oldName, String newName, String[] names) {
		int index;
		for (index = 0; index < names.length; index++) {
			if (names[index].equals(oldName)) {
				names[index] = newName;
				break;
			}
		}
	};
	
	String[] deleteName(String name, String[] names) {
		String[] result = new String[5];
		for (int i = 0; i < names.length; i++) {
			if (names[i] != null && !names[i].equals(name)) {
				result[i] = names[i];
			}
		}
		return result;	
	};
	
	void selectName(String[] names) {
		System.out.println("#이름목록");
		for (String string : names) {
			if(string != null) {
				System.out.println(string);
			}
		}
	};
	
	boolean checkDupulicated(String name, String[] names) {
		boolean result = false;
		for (String string : names) {
			if (string != null && string.equals(name)) {
				result = true;
				break;
			}
		}
		return result;
	}
}
