import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.Scanner; 
/**
 * Write a description of class MetaDataMaker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MetaDataReaderAdvanced
{
    public static void main(String args[]){
        
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter the image name:");
       if(testForKey(input.nextLine())){
        //System.out.println("Enter the string to be encoded:");
        
        String name = input.nextLine();
        String text = going(name);
        System.out.println(text);
    }else{
        System.out.printf("This is not compatible.");
    }
    }
    public static String going(String name){
        BufferedImage img = null;
        File f = null;
        String all = "";
        try{
            f = new File(name);
            img = ImageIO.read(f);
        }catch(IOException e){
            System.out.println(e);
        }

        char txt = ' ', txt2 = ' ';
        for(int i = 0; i < img.getHeight(); i+= 10){

            for(int o =0; o < img.getWidth();o+=10){
                if(i+1 < img.getHeight() && o < img.getWidth() ){
                    int p = img.getRGB(o,i);
                    int a = (p >> 24) & 0xff;
                    int r = (p >> 16) & 0xff;
                    int g = (p >> 8) & 0xff;
                    int b = p& 0xff;

                    int p2 = img.getRGB(o,i+1);
                    int a2 = (p2 >> 24) & 0xff;
                    int r2 = (p2 >> 16) & 0xff;
                    int g2 = (p2 >> 8) & 0xff;
                    int b2 = p2& 0xff;
                    if(b != b2){
                        if(b > b2){
                        txt = converterb(b-b2);
                        }else{
                        txt = converterb(b2-b);
                        }
                        //System.out.printf("%c", txt);
                        all+= txt;
                        continue;
                    }
                    if(r != r2){
                        if(r>r2){
                        txt = converterr(r-r2);
                        }else{
                        txt = converterr(r2-r);
                        }
                        //System.out.printf("%c", txt);
                        all+=txt;
                        continue;
                    }
                    if(b2 == b-37||b2 == b+37){
                        txt = converterb(b-b2);
                        //System.out.printf("%c", txt);
                        all+=txt;
                        continue;
                    }
                    
                }
            }

            //System.out.printf("%n");

        }
        //System.out.printf("%n");
        return all; 
    }

    public static char converterb(int x){
        char c = ' ';
        switch(x){
            case 1: c = 'a';
            break; 
            case 2: c = 'b';
            break;
            case 3: c = 'c';
            break;
            case 4: c = 'd';
            break;
            case 5: c= 'e';
            break;
            case 6: c= 'f';
            break;
            case 7: c= 'g';
            break;
            case 8: c= 'h';
            break;
            case 9: c= 'i';
            break;
            case 10: c= 'j';
            break;
            case 11: c= 'k';
            break;
            case 12: c= 'l';
            break;
            case 13: c= 'm';
            break;
            case 14: c= 'n';
            break;
            case 15: c= 'o';
            break;
            case 16: c= 'p';
            break;
            case 17: c= 'q';
            break;
            case 18: c= 'r';
            break;
            case 19: c= 's';
            break;
            case 20: c= 't';
            break;
            case 21: c= 'u';
            break;
            case 22: c= 'v';
            break;
            case 23: c= 'w';
            break;
            case 24: c= 'x';
            break;
            case 25: c= 'y';
            break;
            case 26: c= 'z';
            break;
            case 27: c= '0';
            break;
            case 28: c= '1';
            break;
            case 29: c= '2';
            break;
            case 30: c= '3';
            break;
            case 31: c= '4';
            break;
            case 32: c= '5';
            break;
            case 33: c= '6';
            break;
            case 34: c= '7';
            break;
            case 35: c= '8';
            break;
            case 36: c= '9';
            break;
            case 37: c=' ';
            break;
            default: c = ' ';
        }

        return c;
    }

    public static char converterr(int x){
        char c = ' ';
        switch(x){
            case 1: c = 'A';
            break; 
            case 2: c = 'B';
            break;
            case 3: c = 'C';
            break;
            case 4: c = 'D';
            break;
            case 5: c= 'E';
            break;
            case 6: c= 'F';
            break;
            case 7: c= 'G';
            break;
            case 8: c= 'H';
            break;
            case 9: c= 'I';
            break;
            case 10: c= 'J';
            break;
            case 11: c= 'K';
            break;
            case 12: c= 'L';
            break;
            case 13: c= 'M';
            break;
            case 14: c= 'N';
            break;
            case 15: c= 'O';
            break;
            case 16: c= 'P';
            break;
            case 17: c= 'Q';
            break;
            case 18: c= 'R';
            break;
            case 19: c= 'S';
            break;
            case 20: c= 'T';
            break;
            case 21: c= 'U';
            break;
            case 22: c= 'V';
            break;
            case 23: c= 'W';
            break;
            case 24: c= 'X';
            break;
            case 25: c= 'Y';
            break;
            case 26: c= 'Z';
            break;
            case 27: c= ',';
            break;
            case 28: c= '.';
            break;
            case 29: c= '?';
            break;
            case 30: c= '(';
            break;
            case 31: c= ')';
            break;
            case 32: c= '-';
            break;
            case 33: c= '+';
            break;
            case 34: c= '=';
            break;
            case 35: c= '"';
            break;
            case 36: c= '$';
            break;
            case 37: c=' ';
            break;
            default: c = ' ';
        }

        return c;
    }
    public static boolean testForKey(String name){
        String key = "aytes";
        String holder = "";
        BufferedImage img = null;
        File f = null;
        try{
            f = new File(name);
            img = ImageIO.read(f);
        }catch(IOException e){
            System.out.println(e);
        }
        
        String words="";
        for(int i =1;i < 6;i++){
            int p = img.getRGB(i,0);
                    int a = (p >> 24) & 0xff;
                    int r = (p >> 16) & 0xff;
                    int g = (p >> 8) & 0xff;
                    int b = p& 0xff;

                    int p2 = img.getRGB(i,1);
                    int a2 = (p2 >> 24) & 0xff;
                    int r2 = (p2 >> 16) & 0xff;
                    int g2 = (p2 >> 8) & 0xff;
                    int b2 = p2& 0xff;
                    
                    if(b > b2){
                        holder += converterb(b-b2);
                        }else{
                        holder += converterb(b2-b);
                        }
        }
        if(holder.equals(key)){
            //System.out.printf("true");
            return true;
        }
        System.out.printf("false");
        return false;
    }
}
