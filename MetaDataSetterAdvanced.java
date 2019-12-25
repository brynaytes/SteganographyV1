import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/**
 * Write a description of class MetaDataMaker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MetaDataSetterAdvanced
{
    static int a,r,g,b,b2;
    public static void main(String name,String s) {
        BufferedImage img = null;
        File f = null;
        int MAXPIXELS;
        double fractionIncrement;
        //Words
        char words[] = s.toCharArray();
        //char words[] = {'w','o','r','d','s','s','s','s','s','s','s','s','s','s','s','s','s','s','s','s','s','s','s'};
        try{
            f = new File(name);
            img = ImageIO.read(f);
        }catch(IOException e){
            System.out.println(e);
        }
        MAXPIXELS = (img.getHeight() / 10) * (img.getWidth()/ 10);
            int u=0;   
            
        //This for loop creates an identifier for the image
            String key = "aytes";
        for(int i=1;i < 6;i++){
           int p = img.getRGB(i,1);
                a = (p >> 24) & 0xff;
                r = (p >> 16) & 0xff;
                g = (p >> 8) & 0xff;
                b = p& 0xff;
                
                if(b > 40){
                        b= b-converterb(key.charAt(i-1));
                        }else{
                        b=b+converterb(key.charAt(i-1));
                        }
                
                p = (a<<24)|(r<<16)|(g<<8)|b;
                img.setRGB(i,0,p);
        }
        
        //Setting every 10 pixels to a letter
        for(int i = 0; i < img.getHeight(); i+= 10){

            for(int o =0; o < img.getWidth();o+=10){
                
                
                int p = img.getRGB(o,i);
                a = (p >> 24) & 0xff;
                r = (p >> 16) & 0xff;
                g = (p >> 8) & 0xff;
                b = p& 0xff;
                b2 = p& 0xff;
                //b=255;
                
                //if(s.length() > u && Character.isUpperCase(words[u])){
                if(s.length() > u){
                    
                    if(words[u] == ' '){
                        if(b > 40){
                        b-=37;
                        }else{
                        b+=37;
                        }   
                    }
                    if(Character.isUpperCase(words[u]) || words[u] == '(' || words[u] == ')'){
                        //System.out.print(words[u]);
                        if(r > 40){
                        r= r-convertera(words[u]);
                        }else{
                        r= r+convertera(words[u]);
                        }
                    }else{
                        if(b > 40){
                        b= b-converterb(words[u]);
                        }else{
                        b=b+converterb(words[u]);
                        }
                    }
                    
                }else{
                    //a= 255 - convertera(words[u]);
                    
                   //b=255;
                }
                
                u += 1;
                
                p = (a<<24)|(r<<16)|(g<<8)|b;
                img.setRGB(o,i+1,p);
            }
            
            //
        }
        try{
            f = new File("Out.png");
            ImageIO.write(img, "png", f);
        }catch(IOException e){
            System.out.println(e);
        }
        //System.out.printf("%nDone%n");
    }
    public static int converterb(char x){
        int c =0;
            switch(x){
                    case 'a': c = 1;
                    break; 
                    case 'b': c = 2;
                    break;
                    case 'c': c = 3;
                    break;
                    case 'd': c =4 ;
                    break;
                    case 'e': c=5 ;
                    break;
                    case 'f': c= 6;
                    break;
                    case 'g' : c=7;
                    break;
                    case 'h': c= 8;
                    break;
                    case 'i': c= 9;
                    break;
                    case 'j': c= 10;
                    break;
                    case 'k': c= 11;
                    break;
                    case 'l': c= 12;
                    break;
                    case 'm': c= 13;
                    break;
                    case 'n': c= 14;
                    break;
                    case 'o': c= 15;
                    break;
                    case 'p': c= 16;
                    break;
                    case 'q': c= 17;
                    break;
                    case 'r': c= 18;
                    break;
                    case 's': c= 19;
                    break;
                    case 't': c= 20;
                    break;
                    case 'u': c= 21;
                    break;
                    case 'v': c= 22;
                    break;
                    case 'w': c= 23;
                    break;
                    case 'x': c= 24;
                    break;
                    case 'y': c= 25;
                    break;
                    case 'z': c= 26;
                    break;
                    case '0': c=27;
                    break;
                    case '1': c=28;
                    break;
                    case '2': c=29;
                    break;
                    case '3': c=30;
                    break;
                    case '4': c=31;
                    break;
                    case '5': c=32;
                    break;
                    case '6': c=33;
                    break;
                    case '7': c=34;
                    break;
                    case '8': c=35;
                    break;
                    case '9': c=36;
                    break;
                    case ' ': c=37;
                    default: c = 0;
                    
                }
        
        return c;
    }
    
    public static int convertera(char x){
        int c =0;
            switch(x){
                    case 'A': c = 1;
                    break; 
                    case 'B': c = 2;
                    break;
                    case 'C': c = 3;
                    break;
                    case 'D': c =4 ;
                    break;
                    case 'E': c=5 ;
                    break;
                    case 'F': c= 6;
                    break;
                    case 'G' : c=7;
                    break;
                    case 'H': c= 8;
                    break;
                    case 'I': c= 9;
                    break;
                    case 'J': c= 10;
                    break;
                    case 'K': c= 11;
                    break;
                    case 'L': c= 12;
                    break;
                    case 'M': c= 13;
                    break;
                    case 'N': c= 14;
                    break;
                    case 'O': c= 15;
                    break;
                    case 'P': c= 16;
                    break;
                    case 'Q': c= 17;
                    break;
                    case 'R': c= 18;
                    break;
                    case 'S': c= 19;
                    break;
                    case 'T': c= 20;
                    break;
                    case 'U': c= 21;
                    break;
                    case 'V': c= 22;
                    break;
                    case 'W': c= 23;
                    break;
                    case 'X': c= 24;
                    break;
                    case 'Y': c= 25;
                    break;
                    case 'Z': c= 26;
                    break;
                    case ',': c=27;
                    break;
                    case '.': c=28;
                    break;
                    case '?': c=29;
                    break;
                    case '(': c=30;
                    break;
                    case ')': c=31;
                    break;
                    case '-': c=32;
                    break;
                    case '+': c=33;
                    break;
                    case '=': c=34;
                    break;
                    case '"': c=35;
                    break;
                    case '$': c=36;
                    break;
                    case ' ': c=37;
                    default: c = 1;
                    
                }
        
        return c;
    }
}
