
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.*;  
import javax.swing.*; 
public class MetaDataWindowAdvanced
{
    static JFrame frame = new JFrame("Flow Layout");
    static BufferedImage img = null;
    static File f = null;
    static MetaDataReaderAdvanced READER = new MetaDataReaderAdvanced();
    static MetaDataSetterAdvanced SETTER = new MetaDataSetterAdvanced();
    public static void main(String[] args){
        
        int width = 400;
        int height = 300;
        //Makes frame
        frame.setVisible(true);
        frame.setSize(width,height);
        frame.setLayout(new GridLayout(3,1));
        
        
        //makes panel1
        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0,100,300);
         
         //makes panel2
        JPanel panel2 = new JPanel();
        panel2.setBounds(0,100,300,100);
        
        //makes panel3
        JPanel panel3 = new JPanel();
        panel3.setBounds(0,200,300,200);
        
        //Creates buttons
        JButton encode, decode,link;
        link = new JButton("Enter target Image");
        encode = new JButton("Encode");
        decode = new JButton("Decode");
        panel1.add(link);
        panel1.add(encode);
        panel1.add(decode);
        
        
        //Just a blank label
        JLabel label1 = new JLabel();
        label1.setText("");
        panel2.add(label1);
        
        //ok buttons and errors
        //error
        JLabel err = new JLabel("k");
        //panel2.add(err);
        
        JButton ok, okEncode;
        ok = new JButton("done");
        okEncode = new JButton("ok");
        //panel2.add(ok);
        //panel2.add(okEncode);
        
        
        
        //adds input and output
        JTextArea in_out = new JTextArea();
        in_out.setRows(30);
        in_out.setColumns(30);
        panel3.add(in_out);
            //in_out.setText("stuff");
        
       //adds panel 
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        
        
        
                                                                        
        
            link.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                err.setText("Enter the file name and extension");
                panel2.add(err);
                panel2.add(ok);
                panel2.remove(okEncode);
                in_out.setText("Enter new filename with extension");
                repaintFrame();
            }
            }); 
            
            ok.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                link.setText(in_out.getText());
                panel2.remove(ok);
                panel2.remove(err);
                panel2.remove(okEncode);
                in_out.setText("");
                repaintFrame();
            }
            });
            
            decode.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                panel2.remove(okEncode);
                panel2.remove(err);
                panel2.remove(ok);
                try{
                    f = new File(link.getText());
                    img = ImageIO.read(f);
                }catch(IOException e){
                     panel2.add(err);
                    err.setText("File not found");
                }
                
                if(READER.testForKey(link.getText()))
                in_out.setText(READER.going(link.getText()));
                else{
                    panel2.add(err);
                    err.setText("this isnt a compatable image");
                }
                repaintFrame();
            }
            });
            
            encode.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                
                panel2.add(err);
                panel2.remove(ok);
                try{
                    f = new File(link.getText());
                    img = ImageIO.read(f);
                    panel2.add(okEncode);
                     int maxPixel = (img.getHeight() / 10) * (img.getWidth() / 10);
                     err.setText(link.getText() + " can hold:  "+ maxPixel +" characters");
                }catch(IOException e){
                    err.setText("File not found");
                }
                
                repaintFrame();
            }
            });
            
            okEncode.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                panel2.remove(okEncode);
                
                
                SETTER.main(link.getText(),in_out.getText());
                err.setText("Done, the image was saved into out.png");
                
                repaintFrame();
            }
            });
            
    }
    
    private static void repaintFrame(){
        frame.invalidate();
                    frame.validate();
                    frame.repaint();
    }
}
