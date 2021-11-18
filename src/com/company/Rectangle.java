package com.company;
import java.awt.*;
import java.io.*;
//
class Rectangle extends Figure{

    protected int longueur;
    protected int largeur;

    public Rectangle(int px, int py, Color c){
        super(new Point(px,py), c);
    }


    public int getLongueur(){
        return this.longueur;
    }
    public int getLargeur(){
        return this.largeur;
    }

    public void setLongueur(int x){
        this.longueur = x;
    }
    public void setLargeur(int y){
        this.largeur = y;
    }


    @Override
    public void setBoundingBox(int hauteurBB, int largeurBB) {

    }

    @Override
    protected void setBoundingBox(Point origine, Point secondPoint) {
        /*SI ON VEUT DESSINER EN BAS A GAUCHE*/
        if (secondPoint.getX() < origine.getX() & secondPoint.getY() < origine.getY())
        {
            Point secondOrigine = new Point(secondPoint.getX(), secondPoint.getY());
            Point secondPointBis = new Point(origine.getX(), origine.getY());
            super.p = secondOrigine;
            longueur = (secondPointBis.getY() - secondOrigine.getY());
            largeur = (secondPointBis.getX() - secondOrigine.getX());
        }
        /*SI ON VEUT DESSINER EN HAUT A DROITE*/
        else if (origine.getX() < secondPoint.getX() & secondPoint.getY() < origine.getY())
        {
            Point secondOrigine = new Point(origine.getX(), secondPoint.getY());
            Point secondPointBis = new Point(secondPoint.getX(), origine.getY());
            super.p = secondOrigine;
            longueur = (secondPointBis.getY() - secondOrigine.getY());
            largeur = (secondPointBis.getX() - secondOrigine.getX());
        }
        /*SI ON VEUT DESSINER EN BAS A GAUCHE*/
        else if (origine.getX() < secondPoint.getX() & origine.getY() < secondPoint.getY())
        {
            longueur = (secondPoint.getY() - origine.getY());
            largeur = (secondPoint.getX() - origine.getX());
        }
        /*SI ON VEUT DESSINER EN BAS A DROITE*/
        else if (secondPoint.getX() < origine.getX() & origine.getY() < secondPoint.getY())
        {
            Point secondOrigine = new Point(secondPoint.getX(), origine.getY());
            Point secondPointBis = new Point(origine.getX(), secondPoint.getY());
            super.p = secondOrigine;
            longueur = (secondPointBis.getY() - secondOrigine.getY());
            largeur = (secondPointBis.getX() - secondOrigine.getX());
        }


    }


    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillRect(this.p.getX(),this.p.getY(),this.largeur,this.longueur);
    }



    @Override public String toString(){
        System.out.println("("+super.getX()+","+super.getY()+"), de longueur= "+this.longueur+", de largeur= "+this.largeur+" et de couleur :"+super.getColor()+".");
        return null;

    }

}

