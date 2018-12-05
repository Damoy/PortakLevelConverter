package com.dzoum.portak.converter.model;

import java.util.List;

public class Level {

	public int id;
	public String name;
	public int rows;
	public int cols;
	public int playerBasePowerAmount;
	public Player player;
	public Portal portal;
	public List<Energy> energies;
	public List<Door> doors;
	public List<Key> keys;
	public List<Wall> walls;
	public List<DestructibleWall> destructibleWalls;
	public List<Zombie> zombies;
	public List<Tile> emptyTiles;
	
	public Level() {
		
	}

	public Level(int id, String name, int rows, int cols, int playerBasePowerAmount, Player player, Portal portal,
			List<Energy> energies, List<Door> doors, List<Key> keys, List<Wall> walls,
			List<DestructibleWall> destructibleWalls, List<Zombie> zombies, List<Tile> emptyTiles) {
		this.id = id;
		this.name = name;
		this.rows = rows;
		this.cols = cols;
		this.playerBasePowerAmount = playerBasePowerAmount;
		this.player = player;
		this.portal = portal;
		this.energies = energies;
		this.doors = doors;
		this.keys = keys;
		this.walls = walls;
		this.destructibleWalls = destructibleWalls;
		this.zombies = zombies;
		this.emptyTiles = emptyTiles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getPlayerBasePowerAmount() {
		return playerBasePowerAmount;
	}

	public void setPlayerBasePowerAmount(int playerBasePowerAmount) {
		this.playerBasePowerAmount = playerBasePowerAmount;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Portal getPortal() {
		return portal;
	}

	public void setPortal(Portal portal) {
		this.portal = portal;
	}

	public List<Energy> getEnergies() {
		return energies;
	}

	public void setEnergies(List<Energy> energies) {
		this.energies = energies;
	}

	public List<Door> getDoors() {
		return doors;
	}

	public void setDoors(List<Door> doors) {
		this.doors = doors;
	}

	public List<Key> getKeys() {
		return keys;
	}

	public void setKeys(List<Key> keys) {
		this.keys = keys;
	}

	public List<Wall> getWalls() {
		return walls;
	}

	public void setWalls(List<Wall> walls) {
		this.walls = walls;
	}

	public List<DestructibleWall> getDestructibleWalls() {
		return destructibleWalls;
	}

	public void setDestructibleWalls(List<DestructibleWall> destructibleWalls) {
		this.destructibleWalls = destructibleWalls;
	}

	public List<Zombie> getZombies() {
		return zombies;
	}

	public void setZombies(List<Zombie> zombies) {
		this.zombies = zombies;
	}

	public List<Tile> getEmptyTiles() {
		return emptyTiles;
	}

	public void setEmptyTiles(List<Tile> emptyTiles) {
		this.emptyTiles = emptyTiles;
	}
	
}