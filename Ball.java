package Pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	//tamaño de la pelota
	private static final int DIAMETER = 55;
	
	//x e y posicion de la pelota
	private int x=50;
	private int y=50;
	//velocidad
	private int xs=1;
	private int ys=1;
	private Prueba pru;
	
	public Ball(Prueba pru) {
		this.pru=pru;
	}
	//Metodo para el movimiento
	public void move() {
		if (x + xs< 0)
			xs = 1;	
		if (x + xs > pru.getWidth() - DIAMETER)
			xs = -1;
		if (y + ys < 0)
			ys = 1;
		if (y + ys > pru.getHeight() - DIAMETER)
			ys = -1;
		if (x + xs < pru.palo.getRightX() - 15) {
				pru.score ++;
		 int num = 0;
			if (num!=pru.getScore()) {
				setX(100);
				setY(100);
				setXs(1);
				setYs(1);
			}
			num =pru.getScore();
		 }
		if (x + xs > pru.palo2.getRightX()-42) {
			pru.score2 ++;
			int num2 = 0;
		if (num2!=pru.getScore2()) {
			setX(100);
			setY(100);
			setXs(-1);
			setYs(1);
		}
		num2 =pru.getScore2();
		}
		if (collision()){
			xs = 1;
			x = pru.palo.getRightX()+DIAMETER;
		}
		if (collision2()){
			xs = -1;
			x = pru.palo2.getRightX()-DIAMETER-15;
		}

		x += xs;
		y += ys;
	}
	//Con este metodo detectamos las colisiones
	private boolean collision() {
		return pru.palo.getBounds().intersects(getBounds());
	}
	private boolean collision2() {
		return pru.palo2.getBounds().intersects(getBounds());
	}
	
	
	//Para pintar la pelota
	public void paint(Graphics g) {    
		   
	    g.fillOval(x, y, DIAMETER, DIAMETER);   
	  }    
	//Metodo para pasar la informacion de la pelota en un objeto
	private Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setXs(int xs) {
		this.xs = xs;
	}
	public void setYs(int ys) {
		this.ys = ys;
	}
	
}
