package de.blackthonderjr;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public static JLabel ergebnis = new JLabel("ERGEBNIS: ");
    public static JTextArea rechnung = new JTextArea();
    public static JTextField number = new JTextField();
    public static JTextField steps = new JTextField();
    public static JTextArea hilfeText = new JTextArea();
    public static JEditorPane hilfeText2 = new JEditorPane();

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        JFrame frame = new JFrame("Wurzelziehen");
        frame.setSize(500, 550);

        Dimension frameSize = frame.getSize();
        int x = (screenSize.width - frameSize.width) / 2;
        int y = (screenSize.height - frameSize.height) / 2;

        frame.setLocation(x, y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(40, 40, 40)); // Dark Mode Hintergrund

        // Titel-Label
        JLabel titleLabel = new JLabel("Wurzelziehen-Rechner");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(200, 200, 200));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0, 10, 500, 30);
        frame.add(titleLabel);

        // Zahl-Eingabe
        JLabel numberLabel = new JLabel("Zahl:");
        numberLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        numberLabel.setForeground(new Color(220, 220, 220));
        numberLabel.setBounds(50, 60, 100, 20);
        frame.add(numberLabel);

        number.setFont(new Font("Arial", Font.PLAIN, 16));
        number.setBackground(new Color(60, 60, 60));
        number.setForeground(new Color(220, 220, 220));
        number.setCaretColor(new Color(255, 255, 255));
        number.setBounds(150, 60, 200, 25);
        frame.add(number);

        // Schritte-Eingabe
        JLabel stepsLabel = new JLabel("Schritte:");
        stepsLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        stepsLabel.setForeground(new Color(220, 220, 220));
        stepsLabel.setBounds(50, 100, 100, 20);
        frame.add(stepsLabel);

        steps.setFont(new Font("Arial", Font.PLAIN, 16));
        steps.setBackground(new Color(60, 60, 60));
        steps.setForeground(new Color(220, 220, 220));
        steps.setCaretColor(new Color(255, 255, 255));
        steps.setBounds(150, 100, 200, 25);
        frame.add(steps);

        // Ergebnis-Label
        ergebnis.setFont(new Font("Arial", Font.PLAIN, 20));
        ergebnis.setForeground(new Color(50, 205, 50));
        ergebnis.setHorizontalAlignment(SwingConstants.CENTER);
        ergebnis.setBounds(50, 450, 400, 25);
        frame.add(ergebnis);

        // Rechnungsanzeige
        rechnung.setFont(new Font("Arial", Font.PLAIN, 16));
        rechnung.setForeground(Color.WHITE);
        rechnung.setBackground(new Color(40, 40, 40));
        rechnung.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(rechnung);
        scrollPane.setBounds(50, 200, 400, 220);
        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBackground(new Color(40, 40, 40));
        frame.add(scrollPane);

        // Rechnen-Button
        JButton button = new JButton("Rechnen");
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(30, 144, 255));
        button.setForeground(Color.WHITE);
        button.setBounds(200, 150, 100, 30);
        frame.add(button);

        // Checkbox und Hilfetext
        JCheckBox hilfeCheckbox = new JCheckBox("Hilfe");
        hilfeCheckbox.setFont(new Font("Arial", Font.PLAIN, 14));
        hilfeCheckbox.setForeground(new Color(220, 220, 220));
        hilfeCheckbox.setBackground(new Color(40, 40, 40));
        hilfeCheckbox.setBounds(50, 430, 100, 20);
        frame.add(hilfeCheckbox);
        JCheckBox weitereHilfeCheckbox = new JCheckBox("Weitere Hilfe");
        weitereHilfeCheckbox.setFont(new Font("Arial", Font.PLAIN, 14));
        weitereHilfeCheckbox.setForeground(new Color(220, 220, 220));
        weitereHilfeCheckbox.setBackground(new Color(40, 40, 40));
        weitereHilfeCheckbox.setBounds(350, 430, 120, 20); // Position rechts von der ersten Checkbox
        frame.add(weitereHilfeCheckbox);
        button.addActionListener(e -> {
            if(Double.parseDouble(steps.getText().replace(",", ".")) > 50){
                steps.setText(null);
                return;
            }
            try {
                String numberInput = number.getText().replace(",", ".");
                String stepsInput = steps.getText().replace(",", ".");
                double zahl = Double.parseDouble(numberInput);
                int schritte = Integer.parseInt(stepsInput);

                ergebnis.setForeground(new Color(50, 205, 50));
                ergebnis.setText("ERGEBNIS: " + Rechner.rechnung(zahl, schritte));
                rechnung.setText(Rechner.getRechnung());
                Rechner.clearRechnung();
            } catch (NumberFormatException ex) {
                ergebnis.setForeground(Color.RED);
                ergebnis.setText("Ungültige Eingabe! Bitte Zahl und Schritte korrekt eingeben.");
            }
        });

        hilfeCheckbox.addActionListener(e -> {
            if (hilfeCheckbox.isSelected()) {
                if(weitereHilfeCheckbox.isSelected()){
                    weitereHilfeCheckbox.setSelected(false);
                    for (int i = 0; i < 400; i++) {
                        Dimension frameSize1 = frame.getSize();
                        frame.setSize(frameSize1.width - 1, frameSize1.height);

                        Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
                        int x1 = (screenSize1.width - frame.getWidth()) / 2;
                        int y1 = (screenSize1.height - frame.getHeight()) / 2;
                        frame.setLocation(x1, y1);
                        frame.remove(hilfeText2);

                    }
                    frame.remove(hilfeText);
                    frame.repaint();
                }
                for (int i = 0; i < 400; i++) {
                    Dimension frameSize1 = frame.getSize();
                    frame.setSize(frameSize1.width + 1, frameSize1.height);

                    Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
                    int x1 = (screenSize1.width - frame.getWidth()) / 2;
                    int y1 = (screenSize1.height - frame.getHeight()) / 2;
                    frame.setLocation(x1, y1);
                }

                hilfeText.setText("Erklärung: Was ist eine Wurzel?\n\n" +
                        "Eine Wurzel ist die Zahl, die mit sich selbst multipliziert\n" +
                        "eine andere Zahl ergibt. Zum Beispiel: Die Quadratwurzel von 16 ist 4,\n" +
                        "weil 4 x 4 = 16.\n\n" +
                        "In diesem Programm berechnen wir die\n" +
                        "Quadratwurzel einer Zahl schrittweise.\n\n" +
                        "Beispiel:\n" +
                        "a(0) = 1\n" +
                        "b(0) = 16\n\n" +
                        "a(1) = (1 + 16 / 2) = 8,5\n" +
                        "b(1) = 16 / 8,5 = 1,88\n\n" +
                        "a(2) = (8,5 + 1,88) / 2 = 5,19\n" +
                        "b(2) = 16 / 5,19 = 3,08\n\n" +
                        "So geht es weiter, bis die Zahlen sich annähern und\n" +
                        "die Quadratwurzel gefunden wird.");


                hilfeText.setFont(new Font("Arial", Font.PLAIN, 14));
                hilfeText.setForeground(new Color(220, 220, 220));
                hilfeText.setBackground(new Color(40, 40, 40));
                hilfeText.setEditable(false);
                hilfeText.setBounds(480, 50, 390, 450);
                frame.add(hilfeText);
                frame.repaint();
            } else {
                for (int i = 0; i < 400; i++) {
                    Dimension frameSize1 = frame.getSize();
                    frame.setSize(frameSize1.width - 1, frameSize1.height);

                    Dimension screenSize1 = Toolkit.getDefaultToolkit().getScreenSize();
                    int x1 = (screenSize1.width - frame.getWidth()) / 2;
                    int y1 = (screenSize1.height - frame.getHeight()) / 2;
                    frame.setLocation(x1, y1);
                    frame.remove(hilfeText2);

                }
                frame.remove(hilfeText);
                frame.repaint();
            }
        });

        // Weitere Hilfe
        weitereHilfeCheckbox.addActionListener(e -> {
            if (weitereHilfeCheckbox.isSelected()) {
                if(hilfeCheckbox.isSelected()) {
                    hilfeCheckbox.setSelected(false);
                    for (int i = 0; i < 400; i++) {
                        Dimension frameSize12 = frame.getSize();
                        frame.setSize(frameSize12.width - 1, frameSize12.height);

                        Dimension screenSize12 = Toolkit.getDefaultToolkit().getScreenSize();
                        int x12 = (screenSize12.width - frame.getWidth()) / 2;
                        int y12 = (screenSize12.height - frame.getHeight()) / 2;
                        frame.setLocation(x12, y12);
                    }
                    frame.remove(hilfeText);
                    frame.repaint();
                }
                for (int i = 0; i < 400; i++) {
                    Dimension frameSize12 = frame.getSize();
                    frame.setSize(frameSize12.width + 1, frameSize12.height);

                    Dimension screenSize12 = Toolkit.getDefaultToolkit().getScreenSize();
                    int x12 = (screenSize12.width - frame.getWidth()) / 2;
                    int y12 = (screenSize12.height - frame.getHeight()) / 2;
                    frame.setLocation(x12, y12);
                }

                hilfeText2.setContentType("text/html");
                hilfeText2.setText("<html>" +
                        "<head>" +
                        "    <style>" +
                        "        body {" +
                        "            font-family: Arial, sans-serif;" +
                        "            color: #dcdcdd;" +
                        "            background-color: #282828;" +
                        "        }" +
                        "        a {" +
                        "            color: #32CD32;" +
                        "            text-decoration: none;" +
                        "            font-size: 18px;" +
                        "        }" +
                        "        a:hover {" +
                        "            color: #ff6347;" + /* Hover-Farbe (rot) */
                        "        }" +
                        "    </style>" +
                        "</head>" +
                        "<body>" +
                        "    <h1><u><center>Wiki</center></u></h1>" +
                        "    <p><a href='https://www.matheretter.de/wiki/wurzel'>Mathe Retter</a></p>" +
                        "    <h1><u><center>Youtube</center></u></h1>" +
                        "    <p><a href='https://www.youtube.com/watch?v=MkcArrEhUQI&list=PLv8b855uAKpZyhOycVvoqshsZLYiE3GXJ'>Lehrer Schmidt</a></p>" +
                        "    <p><a href='https://www.youtube.com/watch?v=-wEJzyHB5us'>Daniel Jung</a></p>" +
                        "    <p><a href='https://www.youtube.com/watch?v=hV70xFlb99Q'>Schlau wie wow</a></p>" +
                        "</body>" +
                        "</html>");
                hilfeText2.setBounds(480, 50, 390, 450);
                frame.add(hilfeText2);
                frame.repaint();
            } else {
                for (int i = 0; i < 400; i++) {
                    Dimension frameSize12 = frame.getSize();
                    frame.setSize(frameSize12.width - 1, frameSize12.height);

                    Dimension screenSize12 = Toolkit.getDefaultToolkit().getScreenSize();
                    int x12 = (screenSize12.width - frame.getWidth()) / 2;
                    int y12 = (screenSize12.height - frame.getHeight()) / 2;
                    frame.setLocation(x12, y12);
                }

                frame.remove(hilfeText2);
                frame.repaint();
            }
        });

        // Footer Text
        JLabel footerLabel = new JLabel("Made by BlackThonder_Jr");
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        footerLabel.setForeground(new Color(200, 200, 200));
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        footerLabel.setBounds(0, 480, 500, 20);
        frame.add(footerLabel);

        number.addKeyListener(new KeyEvent());
        steps.addKeyListener(new KeyEvent());

        frame.setVisible(true);
    }
}
