import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;


// thanks and credit to https://alvinalexander.com/blog/post/java/getting-rgb-values-for-each-pixel-in-image-using-java-bufferedi/
// also to https://www.youtube.com/watch?v=lGX0Gc6d51s




class HelloWorld {

    public void printPixelARGB(int pixel) {
        int alpha = (pixel >> 24) & 0xff;
        int red = (pixel >> 16) & 0xff;
        int green = (pixel >> 8) & 0xff;
        int blue = (pixel) & 0xff;
        System.out.println("argb: " + alpha + ", " + red + ", " + green + ", " + blue);
    }

    


    public static void main(String args[]) throws IOException {
        int width = 990;
        int height = 600;
        String[] brightChars={" ", " ", ".", ":",  "/", "o", "%", "0", "8", "@", "#"};
        
        BufferedImage image = null;
        File f = null;
        while(true){
            try {
                Robot robot = new Robot();
                Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
                BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
                ImageIO.write(screenFullImage, "jpg", new File("screenshot.jpg"));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            

            try{
                f = new File("screenshot.jpg");
                image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                image = ImageIO.read(f);
            }catch(IOException e){
                System.out.println("Error: "+e);
            }
            
            int w = image.getWidth();
            int h = image.getHeight();
            StringBuilder currentRow = new StringBuilder();

            for (int i = 0; i < h; i=i+18) {
                
                for (int j = w/2; j < w; j= j+12) {
                    int pixel = image.getRGB(j, i);

                    //int alpha = (pixel >> 24) & 0xff;
                    int red = (pixel >> 16) & 0xff;
                    int green = (pixel >> 8) & 0xff;
                    int blue = (pixel) & 0xff;
                    int brightness = (red + green + blue)/3;
                    String rightChar = brightChars[(brightness*10/255)];
                    //System.out.print(rightChar);
                     
                    currentRow.append(rightChar);

                }
                String bigLine = currentRow.toString();
                System.out.println(bigLine);
                currentRow = new StringBuilder();
            }
        }


        
    }
}