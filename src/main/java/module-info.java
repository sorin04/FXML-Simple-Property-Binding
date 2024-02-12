module fr.btsciel.fxmlsimplepropertybinding {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.btsciel.fxmlsimplepropertybinding to javafx.fxml;
    exports fr.btsciel.fxmlsimplepropertybinding;
}