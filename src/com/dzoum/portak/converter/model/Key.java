package com.dzoum.portak.converter.model;

import java.util.List;

public class Key {

	public int id;
	public int row;
	public int col;
	public List<Integer> doorIds;
	
	public Key() {
		
	}
	
	public Key(int id, int row, int col, List<Integer> doorIds) {
		this.id = id;
		this.row = row;
		this.col = col;
		this.doorIds = doorIds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public List<Integer> getDoorIds() {
		return doorIds;
	}

	public void setDoorIds(List<Integer> doorIds) {
		this.doorIds = doorIds;
	}
	
}
