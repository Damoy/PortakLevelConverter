package com.dzoum.portak.converter.app;

import java.io.File;

import com.dzoum.portak.converter.core.JsonConverter;
import com.dzoum.portak.converter.utils.Output;

public class Application {

	public static void main(String[] args) {
		convertAllRawLevelsToJsonFormat();
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