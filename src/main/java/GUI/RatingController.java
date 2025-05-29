/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Alison Espinoza
 */
package GUI;

import dao.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.*;

import models.MahnValoracionSala;

public class RatingController {
    @FXML private ComboBox<String> salaBox;
    @FXML private Spinner<Integer> starsSpinner;
    @FXML private TextArea obsArea;
    @FXML private Label statusLabel;

    private final MahnSalaDAO salaDAO       = new MahnSalaDAO();
    private final MahnValoracionSalaDAO rDAO = new MahnValoracionSalaDAO();

    @FXML
    public void initialize() {
        salaDAO.findAll().forEach(s ->
            salaBox.getItems().add(s.getNombre())
        );
        starsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 3));
    }

    @FXML
    private void onSubmit() {
        String nombreSala = salaBox.getValue();
        MahnSala sala = salaDAO.findAll().stream()
            .filter(s -> nombreSala.equals(s.getNombre()))
            .findFirst().orElse(null);
        if (sala == null) {
            statusLabel.setText("Seleccione una sala válida.");
            return;
        }
        MahnValoracionSala v = new MahnValoracionSala();
        v.setIdSala(sala);
        v.setEstrellas(starsSpinner.getValue().shortValue());
        v.setObservacion(obsArea.getText());
        rDAO.create(v);
        statusLabel.setText("¡Gracias por su valoración!");
    }
}