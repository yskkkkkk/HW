package com.yskkkkkk.july;

import java.util.Scanner;

public class NameMenuTest {
	
	public static void main(String[] args) {
		NameMenu nameMenu = new NameMenu();
		boolean flag = true;
		String[] names = new String[5];
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("<이름메뉴>\r\n" + 
					"1.추가 2.검색 3.수정 4.삭제 5.종료");
			System.out.print("번호입력 ==> ");
			switch (sc.nextInt()) {
			case 1:
				System.out.print("이름입력: ");
				String insertName = sc.next();
				if (nameMenu.checkDupulicated(insertName, names)) {
					System.out.println("입력하신 이름은 이미 목록에 존재합니다.");
				}else if (!nameMenu.insertName(insertName, names)) {
					System.out.println("이미 목록이 가득찼습니다.");
				}  
				break;
			case 2:
				nameMenu.selectName(names);
				break;
			case 3:
				System.out.print("기존이름입력: ");
				String oldName = sc.next();
				if (!nameMenu.checkDupulicated(oldName, names)) {
					System.out.println("입력하신 기존이름이 목록에 존재하지 않습니다.");
					continue;
				}
				System.out.print("변경이름입력: ");
				String newName = sc.next();
				if (oldName.equals(newName)){
					System.out.println("같은 이름으로 변경할 수 없습니다.");
				}else if (nameMenu.checkDupulicated(newName, names)) {
					System.out.println("변경이름이 이미 목록에 존재합니다.");
				}else {
					nameMenu.updateName(oldName, newName, names);					
				}
				break;
			case 4:
				System.out.print("삭제이름입력: ");
				String delName = sc.next();
				if (nameMenu.checkDupulicated(delName, names))
					names = nameMenu.deleteName(delName, names);
				else
					System.out.println("입력하신 이름이 존재하지 않습니다.");
				break;
			case 5:
				flag = false;
				break;
			default:
				System.out.println("메뉴에 없는 번호를 입력하셨습니다. 다시 입력해 주세요.");
				break;
			}
			if (flag) System.out.println("----------------------");
		} while (flag);
		sc.close();
		System.out.println(" -- END -- ");
	}

}
