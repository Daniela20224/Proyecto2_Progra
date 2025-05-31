/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Alison Espinoza
 */import dao.*;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import models.*;

import java.io.IOException;
import java.util.List;

public class MaintenanceController {
    @FXML private ComboBox<String> entitySelector;
    @FXML private TableView<Object> table;
    
    // DAOs disponibles
    private final MahnColeccionDAO coleccionDAO = new MahnColeccionDAO();
    private final MahnSalaDAO salaDAO           = new MahnSalaDAO();
    // ... inyecta aquí el resto de DAOs
    
    @FXML
    public void initialize() {
        entitySelector.getItems().addAll(
            "Colección", "Sala", "Especie", "Visitante", "Temática", "Precios", "Valoración", "Entrada", "ComisiónTarjeta"
        );
    }
    
    @FXML
    private void onLoadEntity() {
        String ent = entitySelector.getValue();
        table.getColumns().clear();
        table.getItems().clear();
        
        switch (ent) {
            case "Colección":
                setupColumns(MahnColeccion.class);
                loadData(coleccionDAO.findAll());
                break;
            case "Sala":
                setupColumns(MahnSala.class);
                loadData(salaDAO.findAll());
                break;
            // añade cada entidad...
        }
    }
    
    private <T> void setupColumns(Class<T> clazz) {
        // Reflexión: crear TableColumn por cada getter de la entidad
        // (implementar según tu convención de nombres)
    }
    
    private <T> void loadData(List<T> data) {
        ObservableList<Object> items = FXCollections.observableArrayList(data);
        table.setItems(items);
    }

    @FXML private void onNew()    { /* abrir diálogo para crear */ }
    @FXML private void onEdit()   { /* abrir diálogo con objeto seleccionado */ }
    @FXML private void onDelete() {
        Object sel = table.getSelectionModel().getSelectedItem();
        if (sel == null) return;
        // dependiendo del tipo, invocar su DAO .delete(...)
    }
}