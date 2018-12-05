package com.dzoum.portak.converter.model;

public class Wall {

	public int row;
	public int col;
	
	public Wall() {
		
	}
	
	public Wall(int row, int col) {
		this.row = row;
		this.col = col;
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