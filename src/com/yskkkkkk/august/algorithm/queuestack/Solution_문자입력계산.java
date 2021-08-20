package com.yskkkkkk.august.algorithm.queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Solution_문자입력계산 {

	public static void main(String[] args) throws ScriptException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		for (int i = 1; i <= 10; i++) {
			br.readLine();
			String input = br.readLine();
			System.out.println("#"+i+" "+engine.eval(input));
		}
		br.close();
	}
}
