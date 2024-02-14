package fr.btsciel.fxmlsimplepropertybinding;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class CercleProperty {
    private DoubleProperty hauteur = new SimpleDoubleProperty();
    private DoubleProperty largeur = new SimpleDoubleProperty();
    private DoubleProperty perimetre = new SimpleDoubleProperty();


    private DoubleProperty rayon = new SimpleDoubleProperty();
    public void CerclePropertyrcle(double radius) {
        this.rayon.set(radius);
    }
    public DoubleProperty rayonProperty() {
        return rayon;
    }

    public double calculateSurface() {
        double pi = Math.PI;
        double rayonValue = rayon.get();
        return pi * rayonValue * rayonValue;
    }
}




//public DoubleProperty hauteurProperty() {
//        return hauteur;
//    }
//
//
//    public DoubleProperty largeurProperty() {
//        return largeur;
//    }
//
//
//
//    public DoubleProperty perimetreProperty() {
//        return perimetre;
//    }
//
//
//
//    public DoubleProperty surfaceProperty() {
//        return surface;
//    }
//}
