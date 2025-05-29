package Services;
import dao.*;
import models.*;

import java.util.Date;
import java.util.UUID;

public class EntryService {
    private final MahnEntradaDAO entradaDAO         = new MahnEntradaDAO();
    private final MahnComisionTarjetaDAO comDAO     = new MahnComisionTarjetaDAO();
    private final QRService qrService               = new QRService();

    /**
     * Registra una venta de entrada, genera QR y calcula comisión.
     * Devuelve el texto del QR para mostrarlo o almacenarlo.
     */
    public String sellEntry(MahnVisitante visitante,
                            String tipoTarjeta,
                            String ultimosDigitos,
                            int unitPrice,
                            int quantity) throws Exception {
        // 1. Calcular total
        int total = unitPrice * quantity;

        // 2. Crear entidad MahnEntrada
        MahnEntrada entrada = new MahnEntrada();
        entrada.setIdVisitante(visitante);
        entrada.setTipoTarjeta(tipoTarjeta);
        entrada.setUltimosDigitosTarjeta(ultimosDigitos);
        entrada.setFechaVisita(new Date());
        entrada.setPrecioTotal(total);

        // 3. Generar un texto único para el QR
        String qrText = UUID.randomUUID().toString();
        entrada.setCodigoQr(qrText);

        // 4. Persistir entrada
        entradaDAO.create(entrada);

        // 5. Registrar comisión
        MahnComisionTarjeta com = comDAO.findAll().stream()
            .filter(c -> c.getTipoTarjeta().equals(tipoTarjeta))
            .findFirst()
            .orElseThrow();
        int comision = com.getComision() * total / 100;
        // ► aquí podrías guardar la comisión en otra entidad si la tienes

        // 6. Retornar texto QR y/o generar imagen PNG
        // qrService.saveQRCodeToFile(qrText, 200, 200, "qrs/" + qrText + ".png");
        return qrText;
    }
}