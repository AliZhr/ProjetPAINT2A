package com.company;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

import java.awt.event.*;



public class Drawing extends JPanel implements MouseListener, MouseMotionListener, Serializable {

    public ArrayList<Figure> figures;
    private String figuretype;
    private Color c;
    private final int x,y;
    private Point firstPoint;
    private Point secondPoint;
    protected Figure currentFigure;

    public Drawing(){
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        c = Color.black;
        figuretype = "Rectangle";
        figures = new ArrayList<Figure>();
        x=0;
        y=0;

    }

    //public int getSecondX(){return this.secondX;};
    //public int getSecondY(){return this.secondY;};

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        for(Figure f : figures){
            f.draw(g);
            this.repaint();
        }
    }

    public void setBackColor(Color color){
        this.c=color;
    }
    public void setFigure(String arg){
        this.figuretype=arg;
    }

    public ArrayList <Figure> getList(){
        return this.figures;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        secondPoint = new Point(e.getX(), e.getY());
        currentFigure.setBoundingBox(firstPoint, secondPoint);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (c != Color.white) {
            firstPoint = new Point(e.getX(), e.getY());
            if (figuretype.equals("Ellipse")) {
                figures.add(currentFigure= new Ellipse(firstPoint.getX(), firstPoint.getY(), this.c));
            } else if (figuretype.equals("Rectangle")) {
                figures.add(currentFigure= new Rectangle(firstPoint.getX(), firstPoint.getY(), this.c));
            } else if (figuretype.equals("Cercle")) {
                figures.add(currentFigure= new Cercle(firstPoint.getX(), firstPoint.getY(), this.c));
            } else if (figuretype.equals("Carre")) {
                figures.add(currentFigure= new Carre(firstPoint.getX(), firstPoint.getY(), this.c));
            }
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        secondPoint.setX(e.getX());
        secondPoint.setY(e.getY());
        currentFigure.setBoundingBox(firstPoint, secondPoint);
        System.out.println(figures);
        repaint();
    }



    public void ctrlZ() {
        figures.remove(figures.size() - 1);
        repaint();
    }


    public void resetpaint() {
        figures.clear();
        repaint();
    }

    public void save(String nameFile) {
        try {
            FileOutputStream fileOut = new FileOutputStream(nameFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(figures);
            out.close();
            System.out.println("\nSAVED\n");
        } catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();

        }

    }


    public void read(String nameFile) {
        try {
            FileInputStream fileIn = new FileInputStream(nameFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            figures = (ArrayList<Figure>) in.readObject();
            System.out.println("OUVERT");
            in.close();
            fileIn.close();
            repaint();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}