package com.dzoum.portak.converter.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class Output {

	public static void toConsole(String s) {
		System.out.print(s);
	}
	
	public static void toFile(String folderPath, String filePath, String content) {
		try {
			File folder = new File(folderPath);
			folder.mkdirs();
			File file = new File(filePath);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
