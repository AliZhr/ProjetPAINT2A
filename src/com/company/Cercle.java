package com.company;
import java.awt.Color;
import java.awt.Graphics;

class Cercle extends Ellipse{

    public Cercle(int px, int py, Color c){
        super(px,py, c);
    }


    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.g_axe = this.p_axe = hauteurBB;
    }

    @Override
    protected void setBoundingBox(Point origine, Point secondPoint) {
        super.setBoundingBox(origine, secondPoint);
        if (p_axe < g_axe)
        {
            g_axe = p_axe;
            /*SI ON VEUT DESSINER EN HAUT A DROITE*/
            if (origine.getX() < secondPoint.getX() & secondPoint.getY() < origine.getY())
            {
                super.p.setY(origine.getY() - g_axe * 2);
            }
            /*SI ON VEUT DESSINER EN HAUT A GAUCHE*/
            else if (secondPoint.getX() < origine.getX() & secondPoint.getY() < origine.getY())
            {
                super.p.setY(origine.getY() - g_axe * 2);
            }
        }

        else
        {
            p_axe = g_axe;
            /*SI ON VEUT DESSINER EN BAS A GAUCHE*/
            if (secondPoint.getX() < origine.getX() & origine.getY() < secondPoint.getY())
            {
                super.p.setX(origine.getX() - p_axe * 2);
            }
            /*SI ON VEUT DESSINER EN BAS A DROITE*/
            else if (secondPoint.getX() < origine.getX() & secondPoint.getY() < origine.getY())
            {
                super.p.setX(origine.getX() - p_axe * 2);
            }
        }
    }





    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillOval(this.p.getX(),this.p.getY(),this.p_axe *2,this.g_axe *2);
    }

    @Override public String toString(){
        System.out.println("("+super.getX()+","+super.getY()+"), diamètre = "+this.p_axe+" et de couleur :"+super.getColor()+".");
        return null;
    }
}