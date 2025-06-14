package GUI;

import dao.MahnComisionTarjetaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.MahnComisionTarjeta;

public class InsertComisionController {

    @FXML
    private ComboBox<String> comboTipoTarjeta;  // Cambiado a ComboBox para tipos de tarjeta
    @FXML
    private TextField comisionField;
private MahnComisionTarjetaDAO comisionTarjetaDAO = new MahnComisionTarjetaDAO();

    private MahnComisionTarjeta ComisionTarjetaToEdit;

@FXML
public void initialize() {
    // Usar exactamente los mismos valores que en la BD
    List<String> tiposDisponibles = new ArrayList<>(List.of(
        "VISA", "Mastercard", "American Express", "Dinner Club", "Union Pay"
    ));

    List<String> yaUsadas = comisionTarjetaDAO.findAll().stream()
        .map(c -> c.getTipoTarjeta().toUpperCase())
        .collect(Collectors.toList());

    tiposDisponibles.removeIf(t -> yaUsadas.contains(t.toUpperCase()));

    comboTipoTarjeta.getItems().addAll(tiposDisponibles);
}
    public void setComision(MahnComisionTarjeta ComisionTarjeta) {
        this.ComisionTarjetaToEdit = ComisionTarjeta;
        comboTipoTarjeta.setValue(ComisionTarjeta.getTipoTarjeta());
        comisionField.setText(String.valueOf(ComisionTarjeta.getComision())); // numérico a texto
    }

 @FXML
private void onSave() {
    String tipoTarjeta = comboTipoTarjeta.getValue();
    int comision;

    if (tipoTarjeta == null || tipoTarjeta.isEmpty() || comisionField.getText().isEmpty()) {
        showAlert("Campos obligatorios", "Complete todos los campos.");
        return;
    }

    try {
        comision = Integer.parseInt(comisionField.getText());
    } catch (NumberFormatException e) {
        showAlert("Error de formato", "La comisión debe ser un número válido.");
        return;
    }

    // Validar rango
    if (comision < 0 || comision > 100) {
        showAlert("Valor inválido", "La comisión debe estar entre 0 y 100.");
        return;
    }

    // Validar duplicado
    boolean existe = comisionTarjetaDAO.findAll().stream()
        .anyMatch(c -> c.getTipoTarjeta().equalsIgnoreCase(tipoTarjeta)
                    && (ComisionTarjetaToEdit == null || !c.getIdComision().equals(ComisionTarjetaToEdit.getIdComision())));

    if (existe) {
        showAlert("Duplicado", "Ya existe una comisión registrada para esta tarjeta.");
        return;
    }

    if (ComisionTarjetaToEdit == null) {
        MahnComisionTarjeta nuevo = new MahnComisionTarjeta();
        nuevo.setTipoTarjeta(tipoTarjeta);
        nuevo.setComision(comision);
        comisionTarjetaDAO.create(nuevo);
    } else {
        ComisionTarjetaToEdit.setTipoTarjeta(tipoTarjeta);
        ComisionTarjetaToEdit.setComision(comision);
        comisionTarjetaDAO.update(ComisionTarjetaToEdit);
    }

    close();
}

    @FXML
    private void onCancel() {
        close();
    }

    private void close() {
        Stage stage = (Stage) comboTipoTarjeta.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
