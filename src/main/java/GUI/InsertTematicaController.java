package GUI;


import dao.MahnSalaDAO;
import dao.MahnTematicaDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.MahnTematica;
import models.MahnSala;

public class InsertTematicaController {

   

    @FXML private TextField nombreField;
    
    @FXML private TextField epocaField;
    @FXML private TextArea caracteristicasTematica;
    @FXML private ComboBox<MahnSala> salaCombo;

    private MahnSalaDAO salaDAO = new MahnSalaDAO();
    private MahnTematicaDAO tematicaDAO = new MahnTematicaDAO();

    private MahnTematica tematicaToEdit;

    @FXML
    public void initialize() {
        salaCombo.setItems(FXCollections.observableArrayList(salaDAO.findAll()));
        
        System.out.println(salaDAO.findAll());
    }

    public void setTematica(MahnTematica tematica) {
        this.tematicaToEdit = tematica;
        nombreField.setText(tematica.getNombre());
        nombreField.setText(tematica.getEpoca());
        caracteristicasTematica.setText(tematica.getCaracteristicas());
        salaCombo.setValue(tematica.getIdSala());
    }

    @FXML
    private void onSave() {
        String nombre = nombreField.getText();
        String epoca = epocaField.getText();
        String caracteristicas = caracteristicasTematica.getText();
        MahnSala sala = salaCombo.getValue();

        if (nombre.isEmpty() || sala == null) {
            showAlert("Campos obligatorios", "Por favor complete nombre y museo.");
            return;
        }

        if (tematicaToEdit == null) {
            MahnTematica nueva = new MahnTematica();
            nueva.setNombre(nombre);
            nueva.setEpoca(epoca);
            nueva.setCaracteristicas(caracteristicas);
            nueva.setIdSala(sala);
            tematicaDAO.create(nueva);
        } else {
            tematicaToEdit.setNombre(nombre);
            tematicaToEdit.setEpoca(epoca);
            tematicaToEdit.setCaracteristicas(caracteristicas);
            tematicaToEdit.setIdSala(sala);
            tematicaDAO.update(tematicaToEdit);
        }

        close();
    }

    @FXML
    private void onCancel() {
        close();
    }

    private void close() {
        Stage stage = (Stage) nombreField.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}