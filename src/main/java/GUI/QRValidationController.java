package GUI;

import dao.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.*;

public class QRValidationController {
    @FXML private TextField qrCodeField;
    @FXML private Label resultLabel;

    private final MahnEntradaDAO entradaDAO = new MahnEntradaDAO();
    private final MahnEntradaSalaDAO salaDAO = new MahnEntradaSalaDAO();

    @FXML
    private void onValidate() {
        String qr = qrCodeField.getText().trim();
        MahnEntrada e = entradaDAO.findAll().stream()
            .filter(x -> qr.equals(x.getCodigoQr()))
            .findFirst().orElse(null);

        if (e == null) {
            resultLabel.setText("QR no válido o no encontrado.");
        } else {
            // registrar acceso a la sala si se desea:
            MahnEntradaSala es = new MahnEntradaSala();
            es.setIdEntrada(e);
            es.setIdSala(e.getMahnEntradaSalaCollection().iterator().next().getIdSala());
            salaDAO.create(es);
            resultLabel.setText("Acceso válido. Bienvenido: " + e.getIdVisitante().getNombre());
        }
    }
}