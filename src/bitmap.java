import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Akira Saito
 * @code 831474
 */

public class bitmap{
    public static void main(String[] args) throws IOException {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Importar imagem");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        String caminhoImagem = null;
        int a = fileChooser.showOpenDialog(null);

        caminhoImagem = fileChooser.getSelectedFile().getAbsolutePath();

        File image = new File(caminhoImagem);

        BufferedImage imgBuffer = ImageIO.read(image);
        Integer altura = imgBuffer.getHeight();
        Integer largura = imgBuffer.getWidth()-1;

        //Mapeamento
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if(j != 0 && j != largura){
                    Integer v1 = imgBuffer.getRGB(j-1, i);
                    Integer v2 = imgBuffer.getRGB(j, i);
                    Integer v3 = imgBuffer.getRGB(j+1, i);

                    int redV1 = (v1 >> 16) & 0xFF;
                    int greenV1 = (v1 >> 8) & 0xFF;
                    int blueV1 = v1 & 0xFF;

                    int redV2 = (v2 >> 16) & 0xFF;
                    int greenV2 = (v2 >> 8) & 0xFF;
                    int blueV2 = v2 & 0xFF;

                    int redV3 = (v3 >> 16) & 0xFF;
                    int greenV3 = (v3 >> 8) & 0xFF;
                    int blueV3 = v3 & 0xFF;

                    //Média do valor RGB
                    int MediaRed = (redV1 + redV2 + redV3)/3;
                    int MediaGreen = (greenV1 + greenV2 + greenV3)/3;
                    int MediaBlue = (blueV1 + blueV2 + blueV3)/3;

                    int novaCor = new Color(MediaRed, MediaGreen, MediaBlue).getRGB();

                    //Trocar os valores (ANTI-ALIASING)
                    imgBuffer.setRGB(j, i, novaCor);
                }
            }
        }
        ImageIO.write(imgBuffer, "bmp", new File("C:\\Users\\asaito\\Desktop\\testeRGB.bmp"));
    }
}