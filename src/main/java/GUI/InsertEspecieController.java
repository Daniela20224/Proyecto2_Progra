package GUI;

import dao.MahnColeccionDAO;
import dao.MahnEspecieDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.MahnColeccion;
import models.MahnEspecie;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class InsertEspecieController {

    @FXML private TextField nombreCientificoField;
    @FXML private TextField nombreComunField;
    @FXML private DatePicker fechaExtincionPicker;
    @FXML private TextField epocaField;
    @FXML private TextField pesoField;
    @FXML private TextField TamanoField;
    @FXML private TextArea CaracteristicasEspecie;
    @FXML private ComboBox<MahnColeccion> coleccionCombo;

    private MahnEspecieDAO especieDAO = new MahnEspecieDAO();
    private MahnColeccionDAO coleccionDAO = new MahnColeccionDAO();
    private MahnEspecie especieToEdit;

    @FXML
    public void initialize() {
        coleccionCombo.setItems(FXCollections.observableArrayList(coleccionDAO.findAll()));
    }

    public void setEspecie(MahnEspecie especie) {
        this.especieToEdit = especie;
        nombreCientificoField.setText(especie.getNombreCientifico());
        nombreComunField.setText(especie.getNombreComun());

        if (especie.getFechaExtincion() != null) {
            fechaExtincionPicker.setValue(especie.getFechaExtincion().toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate());
        }

        epocaField.setText(especie.getEpoca());
        pesoField.setText(String.valueOf(especie.getPeso()));
        TamanoField.setText(especie.getTamano());
        CaracteristicasEspecie.setText(especie.getCaracteristicas());
        coleccionCombo.setValue(especie.getIdColeccion());
    }

    @FXML
    private void onSave() {
        String nombreCientifico = nombreCientificoField.getText();
        String nombreComun = nombreComunField.getText();
        LocalDate fechaLocal = fechaExtincionPicker.getValue();
        String epoca = epocaField.getText();
        String pesoText = pesoField.getText();
        String tamano = TamanoField.getText();
        String caracteristicas = CaracteristicasEspecie.getText();
        MahnColeccion coleccion = coleccionCombo.getValue();

        if (nombreCientifico.isEmpty() || nombreComun.isEmpty() || fechaLocal == null ||
                epoca.isEmpty() || pesoText.isEmpty() || tamano.isEmpty() || caracteristicas.isEmpty() || coleccion == null) {
            showAlert("Campos obligatorios", "Por favor complete todos los campos antes de guardar.");
            return;
        }

        int peso;
        try {
            peso = Integer.parseInt(pesoText);
        } catch (NumberFormatException e) {
            showAlert("Dato inválido", "El peso debe ser un número entero.");
            return;
        }

        Date fechaExtincion = Date.from(fechaLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());

        if (especieToEdit == null) {
            MahnEspecie nueva = new MahnEspecie();
            nueva.setNombreCientifico(nombreCientifico);
            nueva.setNombreComun(nombreComun);
            nueva.setFechaExtincion(fechaExtincion);
            nueva.setEpoca(epoca);
            nueva.setPeso(peso);
            nueva.setTamano(tamano);
            nueva.setCaracteristicas(caracteristicas);
            nueva.setIdColeccion(coleccion);
            especieDAO.create(nueva);
        } else {
            especieToEdit.setNombreCientifico(nombreCientifico);
            especieToEdit.setNombreComun(nombreComun);
            especieToEdit.setFechaExtincion(fechaExtincion);
            especieToEdit.setEpoca(epoca);
            especieToEdit.setPeso(peso);
            especieToEdit.setTamano(tamano);
            especieToEdit.setCaracteristicas(caracteristicas);
            especieToEdit.setIdColeccion(coleccion);
            especieDAO.update(especieToEdit);
        }

        close();
    }

    @FXML
    private void onCancel() {
        close();
    }

    private void close() {
        Stage stage = (Stage) nombreComunField.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
