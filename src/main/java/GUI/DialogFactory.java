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

                case "Museo":
                    loader = new FXMLLoader(DialogFactory.class.getResource("/fxml/InsertMuseoDialog.fxml"));
                    root = loader.load();
                    if (toEdit != null) {
                        InsertMuseoController c = loader.getController();
                        c.setMuseo((MahnMuseos) toEdit);
                    }
                    stage.setTitle((toEdit == null ? "Insertar" : "Editar") + " Museo");
                    break;

                case "Coleccion":
                    loader = new FXMLLoader(DialogFactory.class.getResource("/fxml/InsertColeccionDialog.fxml"));
                    root = loader.load();
                    if (toEdit != null) {
                        InsertColeccionController c = loader.getController();
                        c.setColeccion((MahnColeccion) toEdit);
                    }
                    stage.setTitle((toEdit == null ? "Insertar" : "Editar") + " Museo");
                    break;

                case "Especie":
                    loader = new FXMLLoader(DialogFactory.class.getResource("/GUI/InsertEspecieDialog.fxml"));
                    root = loader.load();
                    if (toEdit != null) {
                        InsertEspecieController c = loader.getController();
                        c.setEspecie((MahnEspecie) toEdit);
                    }
                    stage.setTitle((toEdit == null ? "Insertar" : "Editar") + " Especie");
                    break;
                
                    
                     case "Tematica":
                    loader = new FXMLLoader(DialogFactory.class.getResource("/fxml/InsertTematicaDialog.fxml"));
                    root = loader.load();
                    if (toEdit != null) {
                        InsertTematicaController c = loader.getController();
                        c.setTematica((MahnTematica) toEdit);
                    }
                    stage.setTitle((toEdit == null ? "Insertar" : "Editar") + " Museo");
                    break;
                    
                    
                     case "Precios":
                    loader = new FXMLLoader(DialogFactory.class.getResource("/fxml/InsertPrecioDialog.fxml"));
                    root = loader.load();
                    if (toEdit != null) {
                        InsertPrecioController c = loader.getController();
                        c.setPrecios((MahnPrecios) toEdit);
                    }
                    stage.setTitle((toEdit == null ? "Insertar" : "Editar") + " Museo");
                    break;
                    
                    
                     case "ComisionTarjeta":
                    loader = new FXMLLoader(DialogFactory.class.getResource("/fxml/InsertComisionDialog.fxml"));
                    root = loader.load();
                    if (toEdit != null) {
                        InsertComisionController c = loader.getController();
                        c.setComision((MahnComisionTarjeta) toEdit);
                    }
                    stage.setTitle((toEdit == null ? "Insertar" : "Editar") + " Museo");
                    break;
                    

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
