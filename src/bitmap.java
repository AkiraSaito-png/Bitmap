import javax.imageio.ImageIO;
import javax.swing.text.html.HTMLWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class bitmap{
    public static void main(String[] args) throws IOException {
        //Abre a imagem
        File image = new File("C:\\Users\\asaito\\Desktop\\teste.bmp");

        BufferedImage imgBuffer = ImageIO.read(image);

        byte[] pixels = (byte[]) imgBuffer.getRaster().getDataElements(0,0, imgBuffer.getWidth(), imgBuffer.getHeight(), null);

        for (int i = 0; i < pixels.length; i = i +3) {
            String r = Integer.toHexString(pixels[i]);
            String g = Integer.toHexString(pixels[i+1]);
            String b = Integer.toHexString(pixels[i+2]);
        }
    }
}
