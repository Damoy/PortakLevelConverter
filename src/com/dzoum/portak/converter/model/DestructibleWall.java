package com.dzoum.portak.converter.model;

public class DestructibleWall {

	public int row;
	public int col;
	
	public DestructibleWall() {
		
	}
	
	public DestructibleWall(int row, int col) {
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