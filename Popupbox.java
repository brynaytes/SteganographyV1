
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Popupbox extends JDialog {
	JPanel PtextHolder, PbuttonHolder, PpathHolder, PmaxNumberHolder, PstuffHolder;
	JTextArea TF;
	JButton Bcancel, Bok;
	ActionHandler ah;
	JLabel Lpath, LmaxLetterNumber;
	int maxNum = 0;
	// simply looking at text is true, sending data to be written is false
	boolean readOrWrite;

	String fileName;

	public Popupbox(StenWindow sw) {
		super(sw, true);

		setSize(400, 400);
		setLayout(new BorderLayout());

		PtextHolder = new JPanel();
		TF = new JTextArea(15, 30);

		JScrollPane s = new JScrollPane(TF);

		PtextHolder.add(s);

		Lpath = new JLabel();

		add(PtextHolder, BorderLayout.CENTER);

		PbuttonHolder = new JPanel();
		Bcancel = new JButton("Cancel");
		Bok = new JButton("Ok");
		PbuttonHolder.add(Bcancel);
		PbuttonHolder.add(Bok);

		PpathHolder = new JPanel();
		PmaxNumberHolder = new JPanel();

		LmaxLetterNumber = new JLabel(" ");
		PmaxNumberHolder.add(LmaxLetterNumber);
		PpathHolder.add(Lpath);

		ah = new ActionHandler();
		Bcancel.addActionListener(ah);
		Bok.addActionListener(ah);

		PstuffHolder = new JPanel();
		PstuffHolder.setLayout(new GridLayout(3, 1));
		PstuffHolder.add(PpathHolder);
		PstuffHolder.add(PmaxNumberHolder);
		PstuffHolder.add(PbuttonHolder);
		add(PstuffHolder, BorderLayout.SOUTH);
		// pack();
		setVisible(false);
	}

	public void appear(boolean rw, String f) {
		fileName = f;
		Lpath.setText("File path: " + f);
		if (rw == false) {
			showNumberOfLetters();
		} else {
			dontShowNumberOfLetters();
		}
		// System.out.println(f);
		readOrWrite = rw;
		setVisible(true);
	}

	public void setTextField(String words) {
		TF.setText(words);

	}

	public void showNumberOfLetters() {
		maxNum = MetaDataSetterAdvanced2.getMaxLetters(fileName);
		LmaxLetterNumber.setText("This image can hold: " + maxNum + " characters");
	}

	public void dontShowNumberOfLetters() {
		LmaxLetterNumber.setText(" ");
	}

	private class ActionHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == Bok) {
				if (readOrWrite) {
					// accept text for the text area
					setVisible(false);

				} else {
					MetaDataSetterAdvanced2.going(fileName, TF.getText());
					setVisible(false);
					JOptionPane.showMessageDialog(null,
							"New file created as: " + (fileName.substring(0, fileName.lastIndexOf('.')) + "NEW.png"));
				}

			} else if (e.getSource() == Bcancel) {
				setVisible(false);

			}

		}

	}
}
