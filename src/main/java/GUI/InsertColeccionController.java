package GUI;


import dao.MahnColeccionDAO;
import dao.MahnSalaDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.MahnColeccion;
import models.MahnSala;

public class InsertColeccionController {

   

    @FXML private TextField nombreField;
    @FXML private TextField sigloField;
     @FXML private TextField observacionField;
    
    @FXML private ComboBox<MahnSala> salaCombo;

    private MahnSalaDAO salaDAO = new MahnSalaDAO();
    private MahnColeccionDAO coleccionDAO = new MahnColeccionDAO();

    private MahnColeccion coleccionToEdit;

    @FXML
    public void initialize() {
        salaCombo.setItems(FXCollections.observableArrayList(salaDAO.findAll()));
        
    }

    public void setColeccion(MahnColeccion coleccion) {
        this.coleccionToEdit = coleccion;
        nombreField.setText(coleccion.getNombre());
        sigloField.setText(coleccion.getSiglo());
        observacionField.setText(coleccion.getObservacion());
        salaCombo.setValue(coleccion.getIdSala());
        
    }

    @FXML
    private void onSave() {
        String nombre = nombreField.getText();
        String siglo = sigloField.getText();
        String observacion = observacionField.getText();
        MahnSala sala = salaCombo.getValue();

        if (nombre.isEmpty() || sala == null) {
            showAlert("Campos obligatorios", "Por favor complete nombre y sala.");
            return;
        }

        if (coleccionToEdit == null) {
            MahnColeccion nueva = new MahnColeccion();
            nueva.setNombre(nombre);
            nueva.setSiglo(siglo);
            nueva.setObservacion(observacion);
            nueva.setIdSala(sala);
            coleccionDAO.create(nueva);
        } else {
            coleccionToEdit.setNombre(nombre);
            coleccionToEdit.setSiglo(siglo);
             coleccionToEdit.setObservacion(observacion);
            coleccionToEdit.setIdSala(sala);
            coleccionDAO.update(coleccionToEdit);
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