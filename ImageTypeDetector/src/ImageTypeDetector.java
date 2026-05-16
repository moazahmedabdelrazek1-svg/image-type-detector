import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

/*  1: Run the Programme
    2: Input the File Location and the total image file name in the terminal
    3: press Enter
    4: in the output he shows the type ,wedth,height and the Header.
EX:  C:\\Users\\Mega Store\\OneDrive\\Pictures\\Saved Pictures\\image.png
(output)-> 
File Type: PNG
Width: 814
Height: 372
Header: 89 50 4E 47 0D 0A 1A 0A 00 00 00 0D 
*/




public class ImageTypeDetector {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String path = input.nextLine();

        try {

            FileInputStream file = new FileInputStream(path);

            byte[] bytes = new byte[12];
            file.read(bytes);
            file.close();

            String type = "Unknown";

            if ((bytes[0] & 0xFF) == 0xFF &&
                (bytes[1] & 0xFF) == 0xD8 &&
                (bytes[2] & 0xFF) == 0xFF) {
                type = "JPEG";
            }

            else if ((bytes[0] & 0xFF) == 0x89 &&
                     bytes[1] == 0x50 &&
                     bytes[2] == 0x4E &&
                     bytes[3] == 0x47) {
                type = "PNG";
            }

            else if (bytes[0] == 'G' &&
                     bytes[1] == 'I' &&
                     bytes[2] == 'F') {
                type = "GIF";
            }

            else if (bytes[0] == 'B' &&
                     bytes[1] == 'M') {
                type = "BMP";
            }

            else if ((bytes[0] & 0xFF) == 0x49 &&
                     (bytes[1] & 0xFF) == 0x49 &&
                     (bytes[2] & 0xFF) == 0x2A) {
                type = "RAW";
            }

            else if ((bytes[0] == 'I' && bytes[1] == 'I') ||
                     (bytes[0] == 'M' && bytes[1] == 'M')) {
                type = "TIFF";
            }

            System.out.println("File Type: " + type);

            // ALWAYS try to get image info
            File imgFile = new File(path);
            BufferedImage img = ImageIO.read(imgFile);

            if (img != null) {
                System.out.println("Width: " + img.getWidth());
                System.out.println("Height: " + img.getHeight());
            } else {
                System.out.println("Width: Not available");
                System.out.println("Height: Not available");
            }

            System.out.print("Header: ");
            for (int i = 0; i < 12; i++) {
                System.out.printf("%02X ", bytes[i]);
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
