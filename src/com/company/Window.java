package com.company;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Window extends JFrame implements ActionListener {

    private final Drawing d1;

    public Window(String Title, int x, int y) {
        super(Title);
        this.d1 = new Drawing();
        this.setSize(x, y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPanel = this.getContentPane();


        JMenuBar menu = new JMenuBar();


        JMenu Fichier = new JMenu("Fichier");

        JMenuItem NouveauDessin = new JMenuItem("Nouveau");
        NouveauDessin.addActionListener(this);
        NouveauDessin.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

        JMenuItem Ouvrir = new JMenuItem("Ouvrir");
        Ouvrir.addActionListener(this);
        Ouvrir.setAccelerator(KeyStroke.getKeyStroke('O', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

        JMenuItem Enregistrer = new JMenuItem("Enregistrer");
        Enregistrer.setAccelerator(KeyStroke.getKeyStroke('S', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        Enregistrer.addActionListener(this);

        JMenuItem CtrlZ = new JMenuItem("CtrlZ");
        CtrlZ.setAccelerator(KeyStroke.getKeyStroke('Z', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));
        CtrlZ.addActionListener(this);

        JMenuItem Quitter = new JMenuItem("Quitter");
        Quitter.addActionListener(this);
        Quitter.setAccelerator(KeyStroke.getKeyStroke('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask(), false));

        Fichier.add(NouveauDessin);
        Fichier.add(Ouvrir);
        Fichier.add(Enregistrer);
        Fichier.add(CtrlZ);
        Fichier.addSeparator();
        Fichier.addSeparator();
        Fichier.add(Quitter);
        menu.add(Fichier);


        JMenu Apropos = new JMenu("A propos");
        JMenuItem Auteur = new JMenuItem("Auteur");
        Auteur.addActionListener(this);
        Apropos.add(Auteur);
        menu.add(Apropos);

        setJMenuBar(menu);
        setVisible(true);


        JPanel panneau = new JPanel();
        panneau.setLayout(new GridLayout(1, 2));

        JPanel Couleur = new JPanel();
        Couleur.setLayout(new GridLayout(2, 4));

        JPanel Figure = new JPanel();
        Figure.setLayout(new GridLayout(2, 2));


        JButton noir = new JButton("Noir");
        noir.setBackground(Color.black);
        noir.addActionListener(this);

        JButton rouge = new JButton("Rouge");
        rouge.setBackground(Color.red);
        rouge.addActionListener(this);

        JButton vert = new JButton("Vert");
        vert.setBackground(Color.green);
        vert.addActionListener(this);

        JButton bleu = new JButton("Bleu");
        bleu.setBackground(Color.blue);
        bleu.addActionListener(this);

        JButton jaune = new JButton("Jaune");
        jaune.setBackground(Color.yellow);
        jaune.addActionListener(this);

        JButton rose = new JButton("Rose");
        rose.setBackground(Color.pink);
        rose.addActionListener(this);

        JButton magenta = new JButton("Magenta");
        magenta.setBackground(Color.magenta);
        magenta.addActionListener(this);

        JButton orange = new JButton("Orange");
        orange.setBackground(Color.orange);
        orange.addActionListener(this);


        Couleur.add(noir);
        Couleur.add(rouge);
        Couleur.add(vert);
        Couleur.add(bleu);
        Couleur.add(jaune);
        Couleur.add(rose);
        Couleur.add(magenta);
        Couleur.add(orange);


        JButton Ellipse = new JButton("Ellipse");
        Ellipse.addActionListener(this);

        JButton Cercle = new JButton("Cercle");
        Cercle.addActionListener(this);

        JButton Carre = new JButton("Carre");
        Carre.addActionListener(this);

        JButton Rectangle = new JButton("Rectangle");
        Rectangle.addActionListener(this);

        Figure.add(Rectangle);
        Figure.add(Carre);
        Figure.add(Ellipse);
        Figure.add(Cercle);


        panneau.add(Couleur);
        panneau.add(Figure);
        contentPanel.add(panneau, "South");


        contentPanel.add(d1, "Center");

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Noir" -> {
                System.out.println("La couleur est noire");
                d1.setBackColor(Color.black);
            }
            case "Rose" -> {
                System.out.println("La couleur est rose");
                d1.setBackColor(Color.pink);
            }
            case "Jaune" -> {
                System.out.println("La couleur est jaune");
                d1.setBackColor(Color.yellow);
            }
            case "Bleu" -> {
                System.out.println("La couleur est bleue");
                d1.setBackColor(Color.blue);
            }
            case "Magenta" -> {
                System.out.println("La couleur est magenta");
                d1.setBackColor(Color.magenta);
            }
            case "Rouge" -> {
                System.out.println("La couleur est rouge");
                d1.setBackColor(Color.red);
            }
            case "Vert" -> {
                System.out.println("La couleur est verte");
                d1.setBackColor(Color.green);
            }
            case "Orange" -> {
                System.out.println("La couleur est orange");
                d1.setBackColor(Color.orange);
            }
            case "Rectangle" -> {
                System.out.println("La figure est un rectangle");
                d1.setFigure("Rectangle");
            }
            case "Carre" -> {
                System.out.println("La figure est un carré");
                d1.setFigure("Carre");
            }
            case "Ellipse" -> {
                System.out.println("La figure est une ellipse");
                d1.setFigure("Ellipse");
            }
            case "Cercle" -> {
                System.out.println("La figure est un cercle");
                d1.setFigure("Cercle");
            }
            case "Auteur" -> {
                JOptionPane info = new JOptionPane();
                info.showInternalMessageDialog(info, "Création de ZOUHAIRI Ali",
                        "Information générale", JOptionPane.INFORMATION_MESSAGE);
            }
            case "CtrlZ" -> {
                d1.ctrlZ();
            }
            case "Nouveau" -> {
                d1.resetpaint();
            }
            case "Ouvrir" -> {
                JFileChooser choixop = new JFileChooser();
                int user = choixop.showOpenDialog(this);
                if (user == JFileChooser.APPROVE_OPTION) {
                    String fileToOpen = choixop.getSelectedFile().getAbsolutePath();
                    d1.read(fileToOpen);
                } else {
                    System.out.println("Ouverture annulé");
                }
                break;
            }

            case "Enregistrer" -> {
                JFileChooser choixsave = new JFileChooser();
                int user = choixsave.showSaveDialog(this);
                if (user == JFileChooser.APPROVE_OPTION) {
                    String fileToSave = choixsave.getSelectedFile().getAbsolutePath();
                    d1.save(fileToSave);
                } else {
                    System.out.println("Enregistrement annulé");
                }
                break;
            }

            case "Quitter" -> System.exit(0);
        }


    }

    //
    public static void main(String[] args) {

        Window win = new Window("Test", 800, 600);
    }


}