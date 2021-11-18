package com.company;
import java.awt.Color;
import java.awt.Graphics;


class Carre extends Rectangle{

    /*public Carre(int cote){
        super(cote, cote);
    }
    public Carre(Point o, int cote){
        super(o, cote, cote);
    }*/
    public Carre(int px, int py, Color c){
        super(px,py, c);
    }


    public void setLongueur(int cote){
        super.setLongueur(cote);
        super.setLargeur(cote);
    }
    public void setLargeur(int cote){
        super.setLongueur(cote);
        super.setLargeur(cote);
    }


    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.longueur = this.largeur = hauteurBB;
    }

    @Override
    protected void setBoundingBox(Point origine, Point secondPoint) {
        super.setBoundingBox(origine, secondPoint);
        if (largeur < longueur)
        {
            longueur = largeur;
            /*SI ON VEUT DESSINER EN HAUT A DROITE*/
            if (origine.getX() < secondPoint.getX() & secondPoint.getY() < origine.getY())
            {
                super.p.setY(origine.getY() - longueur);
            }
            /*SI ON VEUT DESSINER EN HAUT A GAUCHE*/
            else if (secondPoint.getX() < origine.getX() & secondPoint.getY() < origine.getY())
            {
                super.p.setY(origine.getY() - longueur);
            }
        }

        else {
            largeur = longueur;
            /*SI ON VEUT DESSINER EN BAS A GAUCHE*/
            if (secondPoint.getX() < origine.getX() & origine.getY() < secondPoint.getY())
            {
                super.p.setX(origine.getX() - largeur);
            }
            /*SI ON VEUT DESSINER EN BAS A DROITE*/
            else if (secondPoint.getX() < origine.getX() & secondPoint.getY() < origine.getY())
            {
                super.p.setX(origine.getX() - largeur);
            }
        }
    }



    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillRect(this.p.getX(),this.p.getY(),this.longueur,this.largeur);
    }

    @Override public String toString(){
        System.out.println("("+super.getX()+","+super.getY()+"), de côté= "+this.longueur+" et de couleur :"+super.getColor()+".");
        return null;
    }


}
