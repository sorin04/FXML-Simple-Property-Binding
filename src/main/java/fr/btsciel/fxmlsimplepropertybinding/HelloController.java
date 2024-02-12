package fr.btsciel.fxmlsimplepropertybinding;

import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public TextField hauteur;
    public TextField largeur;
    public TextField surface;
    public TextField perimetre;

    public Slider slider_Hauteur;


    DoubleProperty h;
    DoubleProperty l;
    DoubleProperty s;
    DoubleProperty p;

    StringConverter sc = new DoubleStringConverter();






    @Override
    public void initialize(URL location, ResourceBundle resources) {
        p.bind(l.add(h).multiply(2));
        s.bind(l.multiply(h));
        perimetre.textProperty().bind(p.asString());
        surface.textProperty().bind(s.asString());

        Bindings.bindBidirectional(hauteur.textProperty(),h,sc);
        Bindings.bindBidirectional(largeur.textProperty(),l,sc);

        Bindings.bindBidirectional(hauteur.textProperty(),slider_Hauteur.valueProperty(),sc);

        slider_Hauteur.visibleProperty().bind(Bindings.when(h.greaterThan(100))
                .then(false)
                .otherwise(true));

        perimetre.backgroundProperty().bind(Bindings.when(p.greaterThan(1500))
                .then(new Background(new BackgroundFill(Color.RED,null,null)))
                .otherwise(new Background(new BackgroundFill(Color.AQUA,null,null))));

    }
}