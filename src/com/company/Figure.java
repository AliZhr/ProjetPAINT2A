package com.company;
import java.awt.*;
import java.io.*;
//
public abstract class Figure implements Serializable{
    protected Point p;
    protected Color c;

    public Figure(){
        this.p = new Point(0,0);
    }
    public Figure(Point o){
        this.p = o;
    }
    public Figure(Point p, Color co){
        this.p = p;
        this.c = co;
    }

    public abstract void setBoundingBox(int hauteurBB, int largeurBB);
    protected abstract void setBoundingBox(Point origine, Point secondPoint);
    public abstract void draw(Graphics g);

    public int getX() {return this.p.getX();}
    public int getY() {return this.p.getY();}
    public java.awt.Color getColor() {return this.c;}

    @Override public String toString(){
        System.out.println("("+this.getX()+","+this.getY()+" et de couleur :"+this.c+".");
        return null;
    }
}
