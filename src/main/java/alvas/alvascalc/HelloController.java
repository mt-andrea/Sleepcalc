package alvas.alvascalc;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private int hossz = 465;
    @FXML
    private ComboBox<String> cbxLeOra;
    @FXML
    private ComboBox<String> cbxLePerc;
    @FXML
    private Label lblKeljFel;

    @FXML
    private ComboBox<String> cbxFelOra;

    @FXML
    private ComboBox<String> cbxFelPerc;

    @FXML
    private Label lblFekudjLe;

    private String nulla(int n) {
        if (n < 10)
            return "0" + n;
        return "" + n;
    }

    @FXML
    void felkel() {
        int ora = Integer.parseInt(cbxLeOra.getValue());
        int perc = Integer.parseInt(cbxLePerc.getValue());
        int ido = ora * 60 + perc + hossz;
        if (ido > 24 * 60) {
            ido -= 24 * 60;
        }
        lblKeljFel.setText("Kelj fel "+ido/60+":"+nulla(ido%60)+"-kor!");
    }
    @FXML
    void lefekszik() {
        int ora = Integer.parseInt(cbxFelOra.getValue());
        int perc = Integer.parseInt(cbxFelPerc.getValue());
        int ido = ora * 60 + perc - hossz;
        if (ido <0) {
            ido += 24 * 60;
        }
        lblFekudjLe.setText("Feküdj le "+ido/60+":"+nulla(ido%60)+"-kor!");
    }
    @FXML
    private ComboBox<String> cbxElAlvas;

    @FXML
    private void elalszik() {
        hossz=5*90+Integer.parseInt(cbxElAlvas.getValue());
        felkel();
        lefekszik();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbxLeOra.getItems().setAll("07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "00", "01", "02", "03", "04", "05", "06");
        cbxLeOra.setValue("22");
        cbxLePerc.getItems().setAll("00", "05", "15", "20", "25", "30", "35", "40", "45", "50", "55");
        cbxLePerc.setValue("45");
        cbxFelOra.getItems().setAll("07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "00", "01", "02", "03", "04", "05", "06");
        cbxFelOra.setValue("06");
        cbxFelPerc.getItems().setAll("00", "05", "15", "20", "25", "30", "35", "40", "45", "50", "55");
        cbxFelPerc.setValue("30");
        cbxElAlvas.getItems().setAll("05", "15", "20", "25", "30", "35", "40", "45", "50", "55");
        cbxElAlvas.setValue("15");
    }
}