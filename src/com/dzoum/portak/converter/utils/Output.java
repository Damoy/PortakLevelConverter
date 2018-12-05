package com.dzoum.portak.converter.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class Output {

	public static void toConsole(String s) {
		System.out.print(s);
	}
	
	public static void toFile(String filePath, String content) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filePath)));
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
