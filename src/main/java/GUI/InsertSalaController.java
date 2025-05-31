package GUI;

import dao.MahnMuseosDAO;
import dao.MahnSalaDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.MahnMuseos;
import models.MahnSala;

public class InsertSalaController {

    @FXML private TextField nombreField;
    @FXML private TextArea descripcionArea;
    @FXML private ComboBox<MahnMuseos> museoCombo;

    private MahnSalaDAO salaDAO = new MahnSalaDAO();
    private MahnMuseosDAO museoDAO = new MahnMuseosDAO();

    private MahnSala salaToEdit;

    @FXML
    public void initialize() {
        museoCombo.setItems(FXCollections.observableArrayList(museoDAO.findAll()));
        
        System.out.println(museoDAO.findAll());
    }

    public void setSala(MahnSala sala) {
        this.salaToEdit = sala;
        nombreField.setText(sala.getNombre());
        descripcionArea.setText(sala.getDescripcion());
        museoCombo.setValue(sala.getIdMuseos());
    }

    @FXML
    private void onSave() {
        String nombre = nombreField.getText();
        String descripcion = descripcionArea.getText();
        MahnMuseos museo = museoCombo.getValue();

        if (nombre.isEmpty() || museo == null) {
            showAlert("Campos obligatorios", "Por favor complete nombre y museo.");
            return;
        }

        if (salaToEdit == null) {
            MahnSala nueva = new MahnSala();
            nueva.setNombre(nombre);
            nueva.setDescripcion(descripcion);
            nueva.setIdMuseos(museo);
            nueva.setNombreMuseo(museo.getNombre());
            salaDAO.create(nueva);
        } else {
            salaToEdit.setNombre(nombre);
            salaToEdit.setDescripcion(descripcion);
            salaToEdit.setIdMuseos(museo);
            salaToEdit.setNombreMuseo(museo.getNombre());
            salaDAO.update(salaToEdit);
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