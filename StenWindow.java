package Proj;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

public class StenWindow extends JFrame{
	/**
	 * 
	 */
	static BufferedImage img = null;
    
    
    Popupbox pop;
    File f = null;
    ActionHandler ah;
    JButton Bencode, Bdecode, Bsummary;
    JPanel buttonHolder,pathHolder;
    JFileChooser j;
    int fileChooserCode;
    JLabel Lpath;
    StenWindow SW;
    
    public static void main(String[] args) {
		
		new StenWindow();
	}
    
    
	public StenWindow() {
		SW = this;
		setSize(400,400);
		setTitle("Steganography");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(2,1));
		
		pop = new Popupbox(this);
		
		buttonHolder = new JPanel();
		Bencode = new JButton("Encode");
		Bdecode = new JButton("Decode");
		Bsummary = new JButton("?");
		
		buttonHolder.add(Bencode);
		buttonHolder.add(Bdecode);
		buttonHolder.add(Bsummary);
		add(buttonHolder);
		
		
		pathHolder = new JPanel();
		Lpath = new JLabel(" ");
		pathHolder.add(Lpath);
		add(pathHolder);
		
		
		ah = new ActionHandler();
		
		Bencode.addActionListener(ah);
		Bdecode.addActionListener(ah);
		Bsummary.addActionListener(ah);
		pack();
		setVisible(true);
	}
	
	
	
	private class ActionHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			 if(e.getSource() == Bsummary) {
					JOptionPane.showMessageDialog(null, "Steganography is the technique of hiding secret data within an \nordinary, non-secret, file or message in order to avoid detection\n\n"
														+ "Click encode to select an image to write text to."
														+ "\nCick decode to select an image and see text inside it.");
					
			 }else {
			j = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
			fileChooserCode = j.showOpenDialog(null);
			
			if(fileChooserCode == JFileChooser.APPROVE_OPTION) {
				f = j.getSelectedFile().getAbsoluteFile();
				
				
			
			if(MetaDataReaderAdvanced2.isValidImage(f.toString())){
				Lpath.setText("Path:  "+f.toString());
				pack();
			if(e.getSource() == Bencode) {
				
				pop.setTextField("");
				pop.appear(false, j.getSelectedFile().getAbsoluteFile().toString());
				
				
			}else if(e.getSource() == Bdecode) {
					if(MetaDataReaderAdvanced2.testForKey(f + "")){
	                pop.setTextField(MetaDataReaderAdvanced2.going(f.toString()));
	                pop.appear(true,j.getSelectedFile().getAbsoluteFile().toString());
				}else {
					JOptionPane.showMessageDialog(null, "This image doesn't have any data in it");
				}
			}
			
			}else {
				JOptionPane.showMessageDialog(null, "The image needs to be a jpg or png");

			}
			}
		}
	
	}
	}
}
