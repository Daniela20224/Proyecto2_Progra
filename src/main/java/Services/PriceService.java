import dao.MahnPreciosDAO;
import models.MahnPrecios;
import models.MahnSala;

public class PriceService {
    private final MahnPreciosDAO preciosDAO = new MahnPreciosDAO();

    /** Devuelve el precio unitario de una sala. */
    public int getUnitPrice(MahnSala sala) {
        MahnPrecios p = preciosDAO.findAll().stream()
            .filter(x -> x.getIdSala().getIdSala().equals(sala.getIdSala()))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Sala sin precio"));
        return p.getPrecio();
    }

    /** Calcula el precio total dado un unitario y cantidad. */
    public int calculateTotal(int unitPrice, int quantity) {
        return unitPrice * quantity;
    }
}