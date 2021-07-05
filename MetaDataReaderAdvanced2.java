
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
public class MetaDataReaderAdvanced2 {

	public static String going(String name) {
		BufferedImage img = null;
		File f = null;
		String all = "";
		try {
			f = new File(name);
			img = ImageIO.read(f);
		} catch (IOException e) {
			// System.out.println(e);
		}

		char txt = ' ', txt2 = ' ';
		for (int i = 0; i < img.getHeight(); i += 10) {

			for (int o = 0; o < img.getWidth(); o += 10) {
				if (i + 1 < img.getHeight() && o < img.getWidth()) {
					int p = img.getRGB(o, i);
					int a = (p >> 24) & 0xff;
					int r = (p >> 16) & 0xff;
					int g = (p >> 8) & 0xff;
					int b = p & 0xff;

					int p2 = img.getRGB(o, i + 1);
					int a2 = (p2 >> 24) & 0xff;
					int r2 = (p2 >> 16) & 0xff;
					int g2 = (p2 >> 8) & 0xff;
					int b2 = p2 & 0xff;
					if (b != b2 && r != r2) {
						txt = '\n';
						all += txt;
						// System.out.println("found return");
						continue;

					}
					if (b != b2) {
						if (b > b2) {
							txt = converterb(b - b2);
						} else {
							txt = converterb(b2 - b);
						}
						// System.out.printf("%c", txt);
						all += txt;
						continue;
					}
					if (r != r2) {
						if (r > r2) {
							txt = converterr(r - r2);
						} else {
							txt = converterr(r2 - r);
						}
						// System.out.printf("%c", txt);
						all += txt;
						continue;
					}
					if (g != g2) {
						if (g > g2) {
							txt = converterg(g - g2);
						} else {
							txt = converterg(g2 - g);
						}
						// System.out.printf("%c", txt);
						all += txt;
						continue;
					}
					if (b2 == b - 37 || b2 == b + 37) {
						txt = converterb(b - b2);
						// System.out.printf("%c", txt);
						all += txt;
						continue;
					}

				}
			}

			// System.out.printf("%n");

		}
		// System.out.printf("%n");
		return all;
	}

	public static char converterb(int x) {
		return (char) (96 + x);
	}

	public static char converterr(int x) {

		return (char) (64 + x);
	}

	public static char converterg(int x) {
		return (char) (31 + x);
	}

	public static boolean testForKey(String name) {
		String key = "aytes";
		String holder = "";
		BufferedImage img = null;
		File f = null;
		try {
			f = new File(name);
			img = ImageIO.read(f);
		} catch (IOException e) {
			System.out.println(e);
		}

		String words = "";
		for (int i = 1; i < 6; i++) {
			int p = img.getRGB(i, 0);
			int a = (p >> 24) & 0xff;
			int r = (p >> 16) & 0xff;
			int g = (p >> 8) & 0xff;
			int b = p & 0xff;

			int p2 = img.getRGB(i, 1);
			int a2 = (p2 >> 24) & 0xff;
			int r2 = (p2 >> 16) & 0xff;
			int g2 = (p2 >> 8) & 0xff;
			int b2 = p2 & 0xff;

			if (b > b2) {
				holder += converterb(b - b2);
			} else {
				holder += converterb(b2 - b);
			}
		}
		// System.out.println(holder);
		if (holder.equals(key)) {
			// System.out.printf("true");
			return true;
		}
		// System.out.printf("false");
		return false;
	}

	public static boolean isValidImage(String val) {

		// name.substring(0,name.lastIndexOf('.'))
		int i = val.lastIndexOf('.');
		if (val.substring(i).equals(".png") || val.substring(i).equals(".jpg") || val.substring(i).equals(".PNG")
				|| val.substring(i).equals(".jpeg")) {
			return true;
		}
		return false;
	}
}
