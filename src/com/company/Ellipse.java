package com.company;

import java.awt.Color;
import java.awt.Graphics;


class Ellipse extends Figure {
    protected int g_axe;
    protected int p_axe;

    public Ellipse(int a, int b) {
        super();
        g_axe = a;
        p_axe = b;
    }

    public Ellipse(Point p, int a, int b) {
        super(p);
        this.g_axe = a;
        this.p_axe = b;
    }

    public Ellipse(int px, int py, Color c) {
        super(new Point(px, py), c);
    }

    public int getG_axe() {
        return this.g_axe;
    }

    public int getP_axe() {
        return this.p_axe;
    }

    public void setG_axe(int a) {
        this.g_axe = a;
    }

    public void setP_axe(int b) {
        this.p_axe = b;
    }


    public void setBoundingBox(int hauteurBB, int largeurBB) {
        this.g_axe = hauteurBB;
        this.p_axe = largeurBB;
    }


    @Override
    protected void setBoundingBox(Point origine, Point secondPoint) {

        if (origine.getX() < secondPoint.getX() & origine.getY() < secondPoint.getY()) {
            p_axe = (secondPoint.getX() - origine.getX()) / 2;
            g_axe = (secondPoint.getY() - origine.getY()) / 2;
        } else if (origine.getX() < secondPoint.getX() & secondPoint.getY() < origine.getX()) {
            Point secondOrigine = new Point(origine.getX(), secondPoint.getY());
            Point secondPointBis = new Point(secondPoint.getX(), origine.getY());
            super.p = secondOrigine;
            p_axe = (secondPointBis.getX() - secondOrigine.getX()) / 2;
            g_axe = (secondPointBis.getY() - secondOrigine.getY()) / 2;
        } else if (secondPoint.getX() < origine.getX() & origine.getY() < secondPoint.getY()) {
            Point secondOrigine = new Point(secondPoint.getX(), origine.getY());
            Point secondPointBis = new Point(origine.getX(), secondPoint.getY());
            super.p = secondOrigine;
            p_axe = (secondPointBis.getX() - secondOrigine.getX()) / 2;
            g_axe = (secondPointBis.getY() - secondOrigine.getY()) / 2;
        } else if (secondPoint.getX() < origine.getX() & secondPoint.getY() < origine.getY()) {
            Point secondOrigine = new Point(secondPoint.getX(), secondPoint.getY());
            Point secondPointBis = new Point(origine.getX(), origine.getY());
            super.p = secondOrigine;
            p_axe = (secondPointBis.getX() - secondOrigine.getX()) / 2;
            g_axe = (secondPointBis.getY() - secondOrigine.getY()) / 2;
        }
    }


    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillOval(this.p.getX(), this.p.getY(), this.p_axe * 2, this.g_axe * 2);
    }


    @Override
    public String toString() {
        System.out.println("(" + super.getX() + "," + super.getY() + "), demi axe = " + this.p_axe + ", de grand axe = " + this.g_axe + " et de couleur :" + super.getColor() + ".");
        return null;
    }
}