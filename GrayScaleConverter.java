import edu.duke.*;
import java.io.*;

public class GrayScaleConverter {
    
    public static ImageResource makeGray(ImageResource inImage) {

        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //for each pixel in outImage
        for (Pixel pixel: outImage.pixels()) {
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            //compute inPixel's red + inPixel's blue + inPixel's green
            //divide that sum by 3 (call it average)
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
            //set pixel's red to average
            pixel.setRed(average);
            //set pixel's green to average
            pixel.setGreen(average);
            //set pixel's blue to average
            pixel.setBlue(average);
        }
        //outImage is your answer
        return outImage;
    }    

	public static void selectAndConvertAndSaveGray () {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			ImageResource inImage = new ImageResource(f);
			ImageResource gray = makeGray(inImage);
            String fname = inImage.getFileName();
			String newName = "gray-" + fname;
			gray.setFileName(newName);
			gray.save();
			gray.draw();
		}
	}

    public static ImageResource makeInverted(ImageResource inImage) {

        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        //for each pixel in outImage
        for (Pixel pixel: outImage.pixels()) {
            //look at the corresponding pixel in inImage
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            
            pixel.setRed(255-inPixel.getRed());

            pixel.setGreen(255-inPixel.getGreen());

            pixel.setBlue(255-inPixel.getBlue());
        }
        //outImage is your answer
        return outImage;
    }    

	public static void selectAndConvertAndSaveInverted () {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			ImageResource inImage = new ImageResource(f);
			ImageResource inverted = makeInverted(inImage);
            String fname = inImage.getFileName();
			String newName = "inverted-" + fname;
			inverted.setFileName(newName);
			inverted.save();
			inverted.draw();
		}
	}



    public static void main(String[] args) {
        // selectAndConvertAndSaveGray();
        selectAndConvertAndSaveInverted();
    }
}
