import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class main2 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\kamyab\\Desktop\\shora.PNG");
        BufferedImage image = null;
        image = ImageIO.read(file);
        image.createGraphics();
    }
}
