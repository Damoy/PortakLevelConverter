package com.dzoum.portak.converter.model;

public class Door {

	public int id;
	public int row;
	public int col;
	public int keyId;
	
	public Door() {
		
	}
	
	public Door(int id, int row, int col, int keyId) {
		this.id = id;
		this.row = row;
		this.col = col;
		this.keyId = keyId;
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

	public int getKeyId() {
		return keyId;
	}

	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}
	
}
