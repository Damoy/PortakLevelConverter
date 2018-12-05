package com.dzoum.portak.converter.model;

public class Zombie {

	public int row;
	public int col;
	public Direction direction;
	
	public Zombie() {
		
	}
	
	public Zombie(int row, int col, Direction direction) {
		this.row = row;
		this.col = col;
		this.direction = direction;
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

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
