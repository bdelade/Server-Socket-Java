package com.mygdx.server;

import java.io.Serializable;

public class Circle implements   Serializable {

	float X;
	float Y;
	float Diametre=15f;

	public Circle(float X, float Y) {
		this.X = X;
		this.Y = Y;
	}
	
	public float getX() {
		return X;
	}
	
	public float getY() {
		return Y;
	}
	
	public float getDiam() {
		return Diametre;
	}
	
	
}
