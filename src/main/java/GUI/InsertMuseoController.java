package GUI;

import dao.MahnMuseosDAO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.MahnMuseos;

import java.time.ZoneId;
import java.util.Date;

public class InsertMuseoController {

    @FXML private TextField nombreField;
    @FXML private TextField tipoField;
    @FXML private TextField ubicacionField;
    @FXML private DatePicker fechaPicker;
    @FXML private TextField directorField;
    @FXML private TextField sitioWebField;

    private MahnMuseosDAO museoDAO = new MahnMuseosDAO();
    private MahnMuseos museoToEdit;

    @FXML
    public void initialize() {
        // Opcional: establecer fechaPicker a hoy
        fechaPicker.setValue(java.time.LocalDate.now());
    }

    public void setMuseo(MahnMuseos museo) {
        this.museoToEdit = museo;
        nombreField.setText(museo.getNombre());
        tipoField.setText(museo.getTipoMuseo());
        ubicacionField.setText(museo.getUbicacion());
        if (museo.getFechaFundacion() != null) {
            fechaPicker.setValue(museo.getFechaFundacion().toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate());
        }
        directorField.setText(museo.getNombreDirector());
        sitioWebField.setText(museo.getSitioWeb());
    }

    @FXML
    private void onSave() {
        String nombre   = nombreField.getText();
        String tipo     = tipoField.getText();
        String ubi      = ubicacionField.getText();

        if (nombre.isEmpty() || tipo.isEmpty() || ubi.isEmpty()) {
            showAlert("Campos obligatorios", "Complete nombre, tipo y ubicación.");
            return;
        }

        Date fecha = fechaPicker.getValue() == null
            ? null
            : Date.from(fechaPicker.getValue()
                          .atStartOfDay(ZoneId.systemDefault())
                          .toInstant());

        if (museoToEdit == null) {
            MahnMuseos nuevo = new MahnMuseos();
            nuevo.setNombre(nombre);
            nuevo.setTipoMuseo(tipo);
            nuevo.setUbicacion(ubi);
            nuevo.setFechaFundacion(fecha);
            nuevo.setNombreDirector(directorField.getText());
            nuevo.setSitioWeb(sitioWebField.getText());
            museoDAO.create(nuevo);
        } else {
            museoToEdit.setNombre(nombre);
            museoToEdit.setTipoMuseo(tipo);
            museoToEdit.setUbicacion(ubi);
            museoToEdit.setFechaFundacion(fecha);
            museoToEdit.setNombreDirector(directorField.getText());
            museoToEdit.setSitioWeb(sitioWebField.getText());
            museoDAO.update(museoToEdit);
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