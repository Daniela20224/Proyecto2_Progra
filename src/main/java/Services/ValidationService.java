package com.mycompany.proyecto2_progra;
import dao.MahnEntradaDAO;
import dao.MahnEntradaSalaDAO;
import models.MahnEntrada;
import models.MahnEntradaSala;
import models.MahnSala;

public class ValidationService {
    private final MahnEntradaDAO entradaDAO     = new MahnEntradaDAO();
    private final MahnEntradaSalaDAO salaDAO    = new MahnEntradaSalaDAO();

    /**
     * Valida el QR (texto) y registra el acceso a sala si es válido.
     * Devuelve el objeto MahnEntradaSala recién creado.
     */
    public MahnEntradaSala validateQRCode(String qrText, Integer idSala) {
        MahnEntrada e = entradaDAO.findAll().stream()
            .filter(x -> qrText.equals(x.getCodigoQr()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("QR no válido"));

        MahnEntradaSala es = new MahnEntradaSala();
        es.setIdEntrada(e);
        es.setIdSala(new MahnSala());
        es.getIdSala().setIdSala(idSala);
        salaDAO.create(es);
        return es;
    }
}