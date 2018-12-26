package com.dzoum.portak.converter.app;

import java.io.File;

import com.dzoum.portak.converter.core.JsonConverter;
import com.dzoum.portak.converter.utils.Output;

public class Application {

	public static void main(String[] args) {
		// convertFile("level0.lvl");
		convertAllRawLevelsToJsonFormat();
	}
	
	private static void convertFile(String filePath) {
		File file = new File("./resources/rawlevels/" + filePath);
		Output.toFile("./resources/jsonlevels/" + file.getName().split(".lvl")[0] + ".json",
				JsonConverter.convertLvlFileToJson(file.getPath()));
	}
	
	private static void convertAllRawLevelsToJsonFormat() {
		File folder = new File("./resources/rawlevels");
		File[] lvlFiles = folder.listFiles();

		for(int i = 0; i < lvlFiles.length; ++i) {
			if(lvlFiles[i].isFile()) {
				Output.toFile("./resources/jsonlevels/" + lvlFiles[i].getName().split(".lvl")[0] + ".json",
						JsonConverter.convertLvlFileToJson(lvlFiles[i].getPath()));
			}
		}
	}
}