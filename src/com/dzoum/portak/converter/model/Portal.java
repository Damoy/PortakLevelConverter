package com.dzoum.portak.converter.model;

public class Portal {

	public int id;
	public int row;
	public int col;
	
	public Portal() {
		
	}

	public Portal(int id, int row, int col) {
		this.id = id;
		this.row = row;
		this.col = col;
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
	
}