package com.dzoum.portak.converter.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dzoum.portak.converter.model.DestructibleWall;
import com.dzoum.portak.converter.model.Direction;
import com.dzoum.portak.converter.model.Door;
import com.dzoum.portak.converter.model.Energy;
import com.dzoum.portak.converter.model.Key;
import com.dzoum.portak.converter.model.Level;
import com.dzoum.portak.converter.model.Player;
import com.dzoum.portak.converter.model.Portal;
import com.dzoum.portak.converter.model.Tile;
import com.dzoum.portak.converter.model.Wall;
import com.dzoum.portak.converter.model.Zombie;
import com.dzoum.portak.converter.utils.Output;
import com.google.gson.GsonBuilder;

public final class JsonConverter {

	public static String convertLvlFileToJson(String filePath) {
		Output.toConsole(">> Launches " + filePath + " conversion...\n");
		
		File file = new File(filePath);
		
		if(!file.exists()) {
			return null;
		}
		
		try {
			Scanner sc = new Scanner(file);
			StringBuilder sb = new StringBuilder();
			
			while(sc.hasNextLine()) {
				sb.append(sc.nextLine());
				sb.append("\n");
			}
			
			sc.close();
			return convertLevelToJson(buildLevelFromLvlFile(sb.toString()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static Level buildLevelFromLvlFile(String lvlFileContent) {
		String data = lvlFileContent.split("##levelData")[1].trim();
		String[] dataLines = data.split("\n");
		String[] sizesData = lvlFileContent.split("##numberOfTiles")[1].split("\n");
		
		int levelId = Integer.parseInt(lvlFileContent.split("##levelId")[1].trim().replaceAll("\n", ""));
		String levelName = lvlFileContent.split("##levelName")[1].trim();
		int rows = Integer.parseInt(sizesData[1]);
		int cols = Integer.parseInt(sizesData[2]);
		int row = 0;
		int col = 0;
		int powerAmount = Integer.parseInt(lvlFileContent.split("##powerAmount")[1].trim());
		
		Scanner sc;
		Player player = null;
		Portal portal = null;
		
		List<Energy> energies = new ArrayList<>();
		List<Door> doors = new ArrayList<>();
		List<Key> keys = new ArrayList<>();
		List<Wall> walls = new ArrayList<>();
		List<DestructibleWall> destructibleWalls = new ArrayList<>();
		List<Zombie> zombies = new ArrayList<>();
		List<Tile> emptyTiles = new ArrayList<>();
		
		Map<Integer, List<Integer>> keyMapping = new HashMap<>();
		
		for(int i = 0; i < dataLines.length; ++i) {
			sc = new Scanner(dataLines[i]);
			col = 0;
			
			while(sc.hasNextInt()) {
				int nextInt = sc.nextInt();
				
				if(nextInt >= 40 && nextInt <= 49) {
					int doorId = nextInt % 40;
					int keyId = (nextInt + 10) % 50;
					
					doors.add(new Door(doorId, row, col, keyId));
					List<Integer> keyDoors = keyMapping.get(keyId);
					
					if(keyDoors == null) {
						keyDoors = new ArrayList<>();
						keyMapping.put(keyId, keyDoors);
					}
					
					keyDoors.add(doorId);
				} else if(nextInt >= 50 && nextInt <= 59) {
					int keyId = nextInt % 50;
					List<Integer> doorIds = keyMapping.get(keyId);
					
					if(doorIds == null) {
						doorIds = new ArrayList<>();
						keyMapping.put(keyId, doorIds);
					}
					
					keys.add(new Key(keyId, row, col, doorIds));
				}
				else if(nextInt >= 71 && nextInt <= 90) {
					energies.add(new Energy(row, col, nextInt));
				} else {
					switch(nextInt) {
						case 0:
							player = new Player(row, col);
							break;
						case 1:
							emptyTiles.add(new Tile(row, col));
							break;
						case 2:
							walls.add(new Wall(row, col));
							break;
						case 3:
							zombies.add(new Zombie(row, col, Direction.RIGHT));
							break;
						case 4:
							zombies.add(new Zombie(row, col, Direction.LEFT));
							break;
						case 5:
							zombies.add(new Zombie(row, col, Direction.UP));
							break;
						case 6:
							zombies.add(new Zombie(row, col, Direction.DOWN));
							break;
						case 8:
							portal = new Portal(levelId, row, col);
							break;
						case 9:
							destructibleWalls.add(new DestructibleWall(row, col));
							break;
					}
				}
				
				++col;
			}
			
			++row;
			sc.close();
		}
		
		if(player == null) {
			if(!"The Start".equals(levelName))
				throw new IllegalStateException("Could not locate the player !");
		}
		
		return new Level(levelId, levelName, rows, cols, powerAmount, player,
				portal, energies, doors, keys, walls, destructibleWalls,
				zombies, emptyTiles);
	}
	
	private static String convertLevelToJson(Level level) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(level);
	}
	
}
