package de.blackthonderjr;

import java.awt.*;
import java.awt.event.KeyListener;

import static de.blackthonderjr.MainFrame.*;

public class KeyEvent implements KeyListener {
    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
        if(e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
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
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {

    }
}
