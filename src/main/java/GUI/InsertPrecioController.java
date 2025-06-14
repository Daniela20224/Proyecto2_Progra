package GUI;

import dao.MahnPreciosDAO;
import dao.MahnSalaDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.MahnPrecios;
import models.MahnSala;

public class InsertPrecioController {

    @FXML private TextField precioLunesSabadoField;
    @FXML private TextField precioDomingoField;
    @FXML private ComboBox<MahnSala> salaCombo;

    private MahnSalaDAO salaDAO = new MahnSalaDAO();
    private MahnPreciosDAO preciosDAO = new MahnPreciosDAO();

    private MahnPrecios preciosToEdit;

    @FXML
    public void initialize() {
        salaCombo.setItems(FXCollections.observableArrayList(salaDAO.findAll()));
    }

    public void setPrecios(MahnPrecios precios) {
        this.preciosToEdit = precios;
        precioLunesSabadoField.setText(String.valueOf(precios.getPrecioLunesASabado()));
        precioDomingoField.setText(String.valueOf(precios.getPrecioDomingo()));
        salaCombo.setValue(precios.getIdSala());
    }

    @FXML
    private void onSave() {
        try {
            int precioLunesSabado = Integer.parseInt(precioLunesSabadoField.getText());
            int precioDomingo = Integer.parseInt(precioDomingoField.getText());
            MahnSala sala = salaCombo.getValue();

            if (sala == null) {
                showAlert("Campos obligatorios", "Por favor seleccione una sala.");
                return;
            }

            if (preciosToEdit == null) {
                MahnPrecios nueva = new MahnPrecios();
                nueva.setPrecioLunesASabado(precioLunesSabado);
                nueva.setPrecioDomingo(precioDomingo);
                nueva.setIdSala(sala);
                preciosDAO.create(nueva);
            } else {
                preciosToEdit.setPrecioLunesASabado(precioLunesSabado);
                preciosToEdit.setPrecioDomingo(precioDomingo);
                preciosToEdit.setIdSala(sala);
                preciosDAO.update(preciosToEdit);
            }

            close();

        } catch (NumberFormatException e) {
            showAlert("Error de formato", "Los precios deben ser números enteros.");
        }
    }

    @FXML
    private void onCancel() {
        close();
    }

    private void close() {
        Stage stage = (Stage) precioLunesSabadoField.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
