package Services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.ByteArrayOutputStream;

public class QRService {
    /** Genera un archivo PNG con el QR y devuelve su contenido en bytes. */
    public byte[] generateQRCodeImage(String text, int width, int height) throws Exception {
        QRCodeWriter qrWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", baos);
            return baos.toByteArray();
        }
    }

    /** Guarda el QR como imagen en disco (opcional). */
    public void saveQRCodeToFile(String text, int width, int height, String filePath) throws Exception {
        // 1. Genera la matriz
        QRCodeWriter qrWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        // 2. Obtiene la ruta y un OutputStream
        Path path = FileSystems.getDefault().getPath(filePath);
        try (OutputStream os = Files.newOutputStream(path)) {
            // 3. Escribe el PNG directamente al OutputStream
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", os);
        }
    }
}