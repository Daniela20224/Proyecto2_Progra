package GUI;

import dao.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import models.*;

public class RatingController {

    @FXML private ComboBox<String> salaBox;
    @FXML private Spinner<Integer> starsSpinner;
    @FXML private TextArea obsArea;
    @FXML private Label statusLabel;

    @FXML private ToggleButton star1, star2, star3, star4, star5;
private ToggleButton[] stars;
    @FXML private Label fichaSalaLabel;
    @FXML private VBox fichaSalaBox;
    @FXML private VBox valoracionesBox;
    @FXML private TableView<MahnValoracionSala> valoracionTable;
    @FXML private TableColumn<MahnValoracionSala, String> salaCol;
    @FXML private TableColumn<MahnValoracionSala, Integer> estrellasCol;
    @FXML private TableColumn<MahnValoracionSala, String> obsCol;
    @FXML private Button verValoracionesButton;
    @FXML private Button borrarValoracionButton;

    private final MahnSalaDAO salaDAO = new MahnSalaDAO();
    private final MahnValoracionSalaDAO rDAO = new MahnValoracionSalaDAO();

    private ObservableList<MahnValoracionSala> valoracionesList = FXCollections.observableArrayList();

   @FXML
public void initialize() {
    // Carga las salas en el ComboBox sin tocar nada
    salaDAO.findAll().forEach(s -> salaBox.getItems().add(s.getNombre()));

    // Configura el Spinner (si lo usas)
    starsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 3));

    // Inicializa el arreglo de estrellas
    stars = new ToggleButton[]{star1, star2, star3, star4, star5};

    // Asigna el manejador para marcar estrellas cuando se haga clic
    for (int i = 0; i < stars.length; i++) {
        final int index = i;
        stars[i].setOnAction(e -> marcarEstrellas(index));
    }

    // Configura la tabla de valoraciones
    setupValoracionTable();

    // Oculta el panel de valoraciones inicialmente
    valoracionesBox.setVisible(false);
}

    
    
private void marcarEstrellas(int index) {
    int estrellasSeleccionadas = index + 1;  // Porque index es base 0

    for (int i = 0; i < stars.length; i++) {
        if (i <= index) {
            stars[i].setSelected(true);
            stars[i].setText("★");
        } else {
            stars[i].setSelected(false);
            stars[i].setText("☆");
        }
    }
    // Actualizar el spinner con el número correcto de estrellas
    starsSpinner.getValueFactory().setValue(estrellasSeleccionadas);
}



   private void setupStarButtons() {
    ToggleButton[] stars = {star1, star2, star3, star4, star5};
    for (int i = 0; i < stars.length; i++) {
        final int index = i;
        stars[i].setOnAction(e -> {
            // Marcar hasta la estrella clickeada
            for (int j = 0; j < stars.length; j++) {
                stars[j].setSelected(j <= index);
            }
            // Actualizar spinner o valor
            starsSpinner.getValueFactory().setValue(index + 1);
        });
    }
}


    @FXML
    private void onSubmit() {
        String nombreSala = salaBox.getValue();
        MahnSala sala = salaDAO.findAll().stream()
            .filter(s -> nombreSala != null && nombreSala.equals(s.getNombre()))
            .findFirst()
            .orElse(null);

        if (sala == null) {
            statusLabel.setText("Seleccione una sala válida.");
            statusLabel.setStyle("-fx-text-fill: red;");
            return;
        }

        MahnValoracionSala v = new MahnValoracionSala();
        v.setIdSala(sala);
        v.setEstrellas(starsSpinner.getValue().shortValue());
        v.setObservacion(obsArea.getText());

        rDAO.create(v);

        statusLabel.setText("¡Gracias por su valoración!");
        statusLabel.setStyle("-fx-text-fill: green;");
        limpiarFormulario();
    }

    private void limpiarFormulario() {
        salaBox.getSelectionModel().clearSelection();
        obsArea.clear();
        for (ToggleButton star : new ToggleButton[]{star1, star2, star3, star4, star5}) {
            star.setSelected(false);
        }
        starsSpinner.getValueFactory().setValue(3);
    }

    @FXML
    private void onVerValoraciones() {
        valoracionesList.setAll(rDAO.findAll());
        valoracionTable.setItems(valoracionesList);
        valoracionesBox.setVisible(!valoracionesBox.isVisible());
    }

    private void setupValoracionTable() {
        salaCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getIdSala().getNombre()));
        estrellasCol.setCellValueFactory(new PropertyValueFactory<>("estrellas"));
        obsCol.setCellValueFactory(new PropertyValueFactory<>("observacion"));
    }

    @FXML
    private void onBorrarValoracion() {
        MahnValoracionSala seleccionada = valoracionTable.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            rDAO.delete(seleccionada);
            valoracionesList.remove(seleccionada);
        }
    }

    @FXML
    private void onSalaSeleccionada() {
        String nombreSala = salaBox.getValue();
        MahnSala sala = salaDAO.findAll().stream()
            .filter(s -> s.getNombre().equals(nombreSala))
            .findFirst()
            .orElse(null);

        if (sala != null) {
            fichaSalaLabel.setText("Sala: " + sala.getNombre() + "\nDescripción: " + sala.getDescripcion());
        } else {
            fichaSalaLabel.setText("");
        }
    }
}
