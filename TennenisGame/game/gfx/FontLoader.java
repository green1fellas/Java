package game.gfx;

import java.awt.*;
import java.io.*;
import java.net.URL;

public class FontLoader {

//    public Font loadFont(String path, float size){
//
//        try{
//            File fontFile = new File(this.getClass().getResource(path).toURI());
//            return Font.createFont(Font.TRUETYPE_FONT, fontFile).deriveFont(Font.PLAIN, size);
//        } catch (Exception e){
//            e.printStackTrace();
//            System.exit(1);
//        }
//        return null;
//    }



//    private static InputStream myStream = null;
//    private static Font myFont = null;
//
//    public Font loadFont(String path, float size){
//
//        try {
//            myStream = new BufferedInputStream(
//                    new FileInputStream(path));
//            myFont = Font.createFont(Font.TRUETYPE_FONT, myStream).deriveFont(Font.PLAIN, size);
//        } catch(Exception e){
//            e.printStackTrace();
//            System.err.println("Font not loaded");
//            }
//            return myFont;
//        }




//    public Font loadFont(String path, float size){
//        try {
//            return Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream(path)).deriveFont(Font.PLAIN, size);
//        } catch (FontFormatException | IOException e){
//            e.printStackTrace();
//            System.exit(1);
//        }
//        return null;
//    }
    public Font loadFont(String path, float size) {
        try {
            return (Font.createFont(Font.TRUETYPE_FONT, FontLoader.class.getClassLoader().getResourceAsStream(path)).deriveFont(Font.PLAIN, size));
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
        return null;
    }
}
