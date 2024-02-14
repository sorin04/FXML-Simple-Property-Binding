package fr.btsciel.fxmlsimplepropertybinding;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class RectangleProperty {

    private DoubleProperty hauteur = new SimpleDoubleProperty();
    private DoubleProperty largeur = new SimpleDoubleProperty();
    private DoubleProperty perimetre = new SimpleDoubleProperty();


    private DoubleProperty surface = new SimpleDoubleProperty();





    public DoubleProperty hauteurProperty() {
        return hauteur;
    }



    public DoubleProperty largeurProperty() {
        return largeur;
    }



    public DoubleProperty perimetreProperty() {
        perimetre.bind(largeur.add(hauteur).multiply(2));
        return perimetre;
    }

    public DoubleProperty surfaceProperty() {
        return surface;
    }
}
