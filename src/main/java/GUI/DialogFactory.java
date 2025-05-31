package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.*;

import java.io.IOException;

public class DialogFactory {

    public static void openInsertDialog(String entityName, Object toEdit) {
        try {
            FXMLLoader loader;
            Parent root;
            Stage stage = new Stage();

            switch (entityName) {
                case "Sala":
                    loader = new FXMLLoader(DialogFactory.class.getResource("/fxml/InsertSalaDialog.fxml"));
                    root = loader.load();
                    if (toEdit != null) {
                        InsertSalaController c = loader.getController();
                        c.setSala((MahnSala) toEdit);
                    }
                    stage.setTitle((toEdit == null ? "Insertar" : "Editar") + " Sala");
                    break;

//                case "Colección":
//                    loader = new FXMLLoader(DialogFactory.class.getResource("/GUI/InsertColeccionDialog.fxml"));
//                    root = loader.load();
//                    if (toEdit != null) {
//                        InsertColeccionController c = loader.getController();
//                        c.setColeccion((MahnColeccion) toEdit);
//                    }
//                    stage.setTitle((toEdit == null ? "Insertar" : "Editar") + " Colección");
//                    break;

//                case "Especie":
//                    loader = new FXMLLoader(DialogFactory.class.getResource("/GUI/InsertEspecieDialog.fxml"));
//                    root = loader.load();
//                    if (toEdit != null) {
//                        InsertEspecieController c = loader.getController();
//                        c.setEspecie((MahnEspecie) toEdit);
//                    }
//                    stage.setTitle((toEdit == null ? "Insertar" : "Editar") + " Especie");
//                    break;

                // Puedes seguir con "Temática", "Precio", etc.
                default:
                    throw new IllegalArgumentException("Entidad no reconocida: " + entityName);
            }

            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}