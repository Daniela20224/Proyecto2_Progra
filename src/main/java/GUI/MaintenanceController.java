package GUI;

import dao.*;
import java.lang.reflect.Field;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import models.*;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaintenanceController {

    // Componentes de UI
    @FXML private TableView<Object> table;
    @FXML private TextField filterText;
    @FXML private ComboBox<String> advancedFilter;

    // Selector interno de entidad (no visible en FXML)
    private String selectedEntity;

    // Mapas de entidades
    private final Map<String, GenericDAO<?, ?>> daoMap = new HashMap<>();
    private final Map<String, Class<?>> entityClassMap = new HashMap<>();

    @FXML
    public void initialize() {
        // Inicializar DAO y clases
        daoMap.put("Museo", new MahnMuseosDAO());
        daoMap.put("Sala", new MahnSalaDAO());
        daoMap.put("Coleccion", new MahnColeccionDAO());
        daoMap.put("Especie", new MahnEspecieDAO());
        daoMap.put("Visitante", new MahnVisitanteDAO());
        daoMap.put("Tematica", new MahnTematicaDAO());
        daoMap.put("Precios", new MahnPreciosDAO());
        daoMap.put("ComisionTarjeta", new MahnComisionTarjetaDAO());
        daoMap.put("Entrada", new MahnEntradaDAO());
        daoMap.put("Valoración", new MahnValoracionSalaDAO());

        entityClassMap.put("Museo", MahnMuseos.class);
        entityClassMap.put("Sala", MahnSala.class);
        entityClassMap.put("Coleccion", MahnColeccion.class);
        entityClassMap.put("Especie", MahnEspecie.class);
        entityClassMap.put("Visitante", MahnVisitante.class);
        entityClassMap.put("Tematica", MahnTematica.class);
        entityClassMap.put("Precios", MahnPrecios.class);
        entityClassMap.put("ComisionTarjeta", MahnComisionTarjeta.class);
        entityClassMap.put("Entrada", MahnEntrada.class);
        entityClassMap.put("Valoracion", MahnValoracionSala.class);
    }

    // Métodos para navegación del menú lateral
    @FXML private void onMenuSala()           { loadEntity("Sala"); }
    @FXML private void onMenuMuseos()           { loadEntity("Museo"); }
    @FXML private void onMenuColeccion()      { loadEntity("Coleccion"); }
    @FXML private void onMenuEspecie()        { loadEntity("Especie"); }
    @FXML private void onMenuTematica()       { loadEntity("Tematica"); }
    @FXML private void onMenuPrecio()         { loadEntity("Precios"); }
    @FXML private void onMenuComision()       { loadEntity("ComisionTarjeta"); }
    @FXML private void onMenuEntrada()        { loadEntity("Entrada"); }
    @FXML private void onMenuValoracion()     { loadEntity("Valoracion"); }
    @FXML private void onMenuReporte()        { System.out.println("Ir a reportes (a implementar)."); }

    private void loadEntity(String entityName) {
        selectedEntity = entityName;
        table.getItems().clear();
        table.getColumns().clear();

        GenericDAO<?, ?> dao = daoMap.get(selectedEntity);
        Class<?> clazz = entityClassMap.get(selectedEntity);
        if (dao == null || clazz == null) return;

        List<?> data = dao.findAll();
        setupColumns(clazz);
        table.setItems(FXCollections.observableArrayList(data));
        
        // Esto se asegura que el ComboBox tenga los nombres de los campos
        
        
advancedFilter.getItems().clear();
for (Field field : clazz.getDeclaredFields()) {
    if (isSimpleType(field.getType())) {
        advancedFilter.getItems().add(field.getName());
    }
    
    advancedFilter.setValue(null); // Limpia la selección actual

}

    }

   @FXML
private void onApplyFilters() {
    if (selectedEntity == null) return;

    String query = filterText.getText().toLowerCase().trim();
    String selectedField = advancedFilter.getValue(); // puede ser null

    GenericDAO<?, ?> dao = daoMap.get(selectedEntity);
    Class<?> clazz = entityClassMap.get(selectedEntity);
    if (dao == null || clazz == null) return;

    List<?> fullData = dao.findAll(); // cargar todos los datos frescos
    ObservableList<Object> filtered = FXCollections.observableArrayList();

    for (Object item : fullData) {
        if (selectedField != null && !selectedField.isEmpty()) {
            // Solo busca en el campo seleccionado
            try {
                Method getter = clazz.getMethod("get" + capitalize(selectedField));
                Object value = getter.invoke(item);
                if (value != null && value.toString().toLowerCase().contains(query)) {
                    filtered.add(item);
                }
            } catch (Exception e) {
                e.printStackTrace(); // Opcional: ver errores si el campo no existe
            }
        } else {
            // Buscar en todos los campos
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.getName().startsWith("get")) {
                    try {
                        Object value = method.invoke(item);
                        if (value != null && value.toString().toLowerCase().contains(query)) {
                            filtered.add(item);
                            break;
                        }
                    } catch (Exception ignored) {}
                }
            }
        }
    }

    table.setItems(filtered);
}


    @FXML
    private void onNew() {
        if (selectedEntity == null) return;
        DialogFactory.openInsertDialog(selectedEntity, null);
        loadEntity(selectedEntity); // Refrescar
    }

    @FXML
    private void onEdit() {
        if (selectedEntity == null) return;
        Object selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) return;
        DialogFactory.openInsertDialog(selectedEntity, selected);
        loadEntity(selectedEntity); // Refrescar
    }

    @FXML
    private void onDelete() {
        Object selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) return;

        GenericDAO<Object, ?> dao = (GenericDAO<Object, ?>) daoMap.get(selectedEntity);
        dao.delete(selected);
        table.getItems().remove(selected);
    }

   private <T> void setupColumns(Class<T> clazz) {
    table.getColumns().clear();

    for (Field field : clazz.getDeclaredFields()) {
        String fieldName = field.getName();
        Class<?> type = field.getType();

        if (isSimpleType(type)) {
            TableColumn<Object, Object> col = (TableColumn<Object, Object>) new TableColumn<>(capitalize(fieldName));
            col.setCellValueFactory(new PropertyValueFactory<>(fieldName));
            table.getColumns().add(col);
        }
    }
}
   
   private boolean isSimpleType(Class<?> type) {
    return type.isPrimitive()
        || type == String.class
        || type == Integer.class
        || type == Long.class
        || type == Double.class
        || type == Float.class
        || type == Boolean.class
        || type == BigDecimal.class
        || type == Date.class;
}
   private String capitalize(String str) {
    return str.substring(0, 1).toUpperCase() + str.substring(1);
}
   

    private String decapitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toLowerCase() + s.substring(1);
    }
}