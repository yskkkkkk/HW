package com.yskkkkkk.july;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Omok {

	public static void main(String[] args) throws FileNotFoundException {
		int[][] omok = new int[19][19];

		System.setIn(new FileInputStream("Test5.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < omok.length; i++) {
			for (int j = 0; j < omok[i].length; j++) {
				omok[i][j] = sc.nextInt();
			}
		}  
		sc.close();
		
		int x = 0;
		int y = 0;
		int winner = 0;
		int sum = 0;
		boolean flag = false;
		
		out: for (int i = 0; i < omok.length; i++) {
			for (int j = 0; j < omok[i].length; j++) {
				if(omok[i][j] != 0) {
					x = i;
					y = j;
					for (int k = 1; k <= 6; k++) {
						if (k==6 && j+(1*k) < 19 && omok[i][j+(1*k)] != omok[i][j]) flag = true;  
						if (j+(1*k) < 19 && omok[i][j+(1*k)] == omok[i][j]) sum ++;
					}
					if (sum == 4 && flag == true){
						winner = omok[i][j];
						break out; 
					}else sum = 0;
					
					for (int k = 1; k <= 6; k++) {
						if (k==6 && i+(1*k) < 19 && j-(1*k) >= 0 && omok[i+(1*k)][j-(1*k)] == omok[i][j]) flag = true;  						
						if (i+(1*k) < 19 && j-(1*k) >= 0 && omok[i+(1*k)][j-(1*k)] == omok[i][j]) sum ++;
					}
					if (sum == 4 && flag == true){
						winner = omok[i][j];
						x = i+4;
						y = j-4;
						break out; 
					}else sum = 0;
					
					for (int k = 1; k <= 6; k++) {
						if (k==6 && i+(1*k) < 19 && omok[i+(1*k)][j] == omok[i][j]) flag = true;  						
						if (i+(1*k) < 19 && omok[i+(1*k)][j] == omok[i][j]) sum++;
					}
					if (sum == 4 && flag == true){
						winner = omok[i][j];
						break out; 
					}else sum = 0;
					
					for (int k = 1; k <= 6; k++) {
						if (k==6 && i+(1*k) < 19 && j+(1*k) < 19 && omok[i+(1*k)][j+(1*k)] == omok[i][j]) flag = true;  						
						if (i+(1*k) < 19 && j+(1*k) < 19 && omok[i+(1*k)][j+(1*k)] == omok[i][j]) sum++;
					}
					if (sum == 4 && flag == true){
						winner = omok[i][j];
						break out; 
					}else sum = 0;
				}
			}
		}	
		System.out.println(winner);
		System.out.println((x+1)+" "+(y+1));
		
	}

}
