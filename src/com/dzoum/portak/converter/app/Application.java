package com.dzoum.portak.converter.app;

import java.io.File;

import com.dzoum.portak.converter.core.JsonConverter;
import com.dzoum.portak.converter.utils.Output;

public class Application {

	public static void main(String[] args) {
		// convertFile("level12.lvl");
		convertAllRawLevelsToJsonFormat();
	}
	
	@SuppressWarnings("unused")
	private static void convertFile(String filePath) {
		String destFolderPath = "./resources/jsonlevels/raw/";
		File file = new File("./resources/rawlevels/" + filePath);
		Output.toFile(destFolderPath, destFolderPath + file.getName().split(".lvl")[0] + ".json",
				JsonConverter.convertLvlFileToJson(file.getPath()));
	}
	
	private static void convertAllRawLevelsToJsonFormat() {
		File folder = new File("./resources/rawlevels");
		File[] lvlFiles = folder.listFiles();
		String destFolderPath = "./resources/jsonlevels/raw/";

		for(int i = 0; i < lvlFiles.length; ++i) {
			if(lvlFiles[i].isFile()) {
				Output.toFile(destFolderPath, destFolderPath + lvlFiles[i].getName().split(".lvl")[0] + ".json",
						JsonConverter.convertLvlFileToJson(lvlFiles[i].getPath()));
			}
		}
	}
}