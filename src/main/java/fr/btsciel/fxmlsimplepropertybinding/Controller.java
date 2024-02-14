package fr.btsciel.fxmlsimplepropertybinding;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;

import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public TextField hauteur;
    @FXML
    public TextField largeur;
    @FXML
    public TextField surface;
    @FXML
    public TextField perimetre;

    @FXML
    public Slider slider_Hauteur;
    @FXML
    public Slider slider_Largeur;
    @FXML
    public Rectangle rectangle;




    @FXML
    private CercleProperty cercleProperty = new CercleProperty();


    StringConverter sc = new DoubleStringConverter() {
        @Override
        public Double fromString(String value) {
            value = value.replace(",", ".");
            value = value.replace("m", "").trim();
            BigDecimal bd = new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
            return bd.doubleValue();
        }

        @Override
        public String toString(Double value) {
            DecimalFormat df = new DecimalFormat("#.00 m");
            return df.format(value);
        }
    };

    Double SEUIL_P = 1500.0;
    Double SEUIL_S= 5000.0;

    RectangleProperty rectangleProperty=new RectangleProperty();




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        perimetre.textProperty().bind(rectangleProperty.perimetreProperty().asString("%.2f m"));

        surface.textProperty().bind(rectangleProperty.surfaceProperty().asString("%.2f m²"));

        rectangle.widthProperty().bind(slider_Largeur.valueProperty());
        rectangle.heightProperty().bind(slider_Hauteur.valueProperty());




        Bindings.bindBidirectional(hauteur.textProperty(),rectangleProperty.hauteurProperty(),sc);
        Bindings.bindBidirectional(largeur.textProperty(),rectangleProperty.largeurProperty(),sc);

        Bindings.bindBidirectional(hauteur.textProperty(),slider_Hauteur.valueProperty(),sc);

        slider_Hauteur.visibleProperty().bind(Bindings.when(rectangleProperty.hauteurProperty().greaterThan(100))
                .then(false)
                .otherwise(true));

        perimetre.backgroundProperty().bind(Bindings.when(rectangleProperty.perimetreProperty().greaterThan(SEUIL_P))
                .then(new Background(new BackgroundFill(Color.RED,null,null)))
                .otherwise(new Background(new BackgroundFill(Color.AQUA,null,null))));

        Bindings.bindBidirectional(largeur.textProperty(),slider_Largeur.valueProperty(),sc);


        slider_Largeur.visibleProperty().bind(Bindings.when(rectangleProperty.largeurProperty().greaterThan(100))
                .then(false)
                .otherwise(true));



        surface.backgroundProperty().bind(Bindings.when(rectangleProperty.surfaceProperty().greaterThan(SEUIL_S))
                .then(new Background(new BackgroundFill(Color.RED, null, null)))
                .otherwise(new Background(new BackgroundFill(Color.AQUA, null, null))));

        surface.backgroundProperty().bind(Bindings.when(rectangleProperty.surfaceProperty().greaterThan(SEUIL_S))

                .then(new Background(new BackgroundFill(Color.RED,null,null)))
                .otherwise(new Background(new BackgroundFill(Color.AQUA,null,null))));

    }
}