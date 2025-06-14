/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Alison Espinoza
 */
import dao.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.*;

import java.util.Date;

public class TicketSaleController {
    @FXML private TextField visitanteIdField;
    @FXML private ComboBox<String> cardTypeBox;
    @FXML private TextField cardDigitsField;
    @FXML private Label unitPriceLabel;
    @FXML private Spinner<Integer> quantitySpinner;
    @FXML private Label totalLabel;

    
    private final MahnPreciosDAO preciosDAO = new MahnPreciosDAO();
    private final MahnEntradaDAO entradaDAO = new MahnEntradaDAO();
    private final MahnComisionTarjetaDAO comDAO = new MahnComisionTarjetaDAO();

    @FXML
    public void initialize() {
        // cargar tipos de tarjeta disponibles
        comDAO.findAll().forEach(ct ->
            cardTypeBox.getItems().add(ct.getTipoTarjeta())
        );
        quantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1));
    }

    @FXML
    private void onCalculate() {
        String tipo = cardTypeBox.getValue();
        MahnPrecios precio = preciosDAO.findAll().stream()
            .filter(p -> p.getIdSala().getIdSala() == 1) // ejemplo sala default
            .findFirst().orElseThrow();
        int qty = quantitySpinner.getValue();
        int total = precio.getPrecio() * qty;
        unitPriceLabel.setText(String.valueOf(precio.getPrecio()));
        totalLabel.setText("Total: ₡" + total);
    }

    @FXML
    private void onSell() {
        MahnEntrada e = new MahnEntrada();
        e.setIdVisitante(new MahnVisitante(Integer.valueOf(visitanteIdField.getText())));
        e.setTipoTarjeta(cardTypeBox.getValue());
        e.setUltimosDigitosTarjeta(cardDigitsField.getText());
        e.setFechaVisita(new Date());
        e.setPrecioTotal(
            Integer.parseInt(totalLabel.getText().replaceAll("[^0-9]", ""))
        );
        entradaDAO.create(e);
        totalLabel.setText("Venta registrada.");
    }
}
