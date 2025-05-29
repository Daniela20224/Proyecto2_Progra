
package Services;
import dao.MahnValoracionSalaDAO;
import dao.MahnSalaDAO;
import models.MahnSala;
import models.MahnValoracionSala;

import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;

public class RatingService {
    private final MahnValoracionSalaDAO rDAO  = new MahnValoracionSalaDAO();
    private final MahnSalaDAO salaDAO          = new MahnSalaDAO();

    /** Guarda una nueva valoración. */
    public void submitRating(int idSala, short estrellas, String observacion) {
        MahnSala sala = salaDAO.findById(idSala);
        MahnValoracionSala v = new MahnValoracionSala();
        v.setIdSala(sala);
        v.setEstrellas(estrellas);
        v.setObservacion(observacion);
        rDAO.create(v);
    }

    /** Calcula el promedio de estrellas de una sala. */
    public double getAverageRating(int idSala) {
        IntSummaryStatistics stats = rDAO.findAll().stream()
            .filter(v -> v.getIdSala().getIdSala().equals(idSala))
            .mapToInt(MahnValoracionSala::getEstrellas)
            .summaryStatistics();
        return stats.getAverage();
    }
}