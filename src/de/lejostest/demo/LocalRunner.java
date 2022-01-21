package de.lejostest.demo;

import de.lejostest.api.vector.Vector2d;

public class LocalRunner {
    public static void main(String[] args) {

        /*
        Idee später:
        Ein-Dimensionaler Vektor spiegelt Geschwindigkeit wider.
        Dieser Vektor wird dann entsprechend den Innenwinkeln der Basis gedreht.
        Die drei resultierenden Vektoren sollten normiert sein in Richtung RU/s oder LE/s
        Zusammensetzung zu Gesamtbewegung durch Addieren der Vektoren
        TODO: Zusammensetzung überprüfen
        TODO: Simples Test-GUI; Drei einstellbare Vektoren; Darstellung der finalen Fahrbahn
        TODO: Überlegungen bezüglich Ableitung der drei Vektoren machen (Fahrrichtung -> Motoranweisungen)
         */


        Vector2d vector1 = new Vector2d(4.0, 1.0);
        Vector2d vector2 = new Vector2d(1.0, -1.0);
        Vector2d vector3 = new Vector2d(1.0, -1.0);

        Vector2d finalVector = vector1.add(vector2).add(vector3);
        System.out.println(finalVector);
    }
}
