package quoridor;

import javax.swing.*;

/**
 * Enumeration containing the StatusFence of the squares, Uses the cardinal points.
 * @author Pierre-Galaad Naquet, Aymeric Bizouarn
 */
public enum StatusFence {
	NONE("   ", "NONE"),
	N(" N ", "N"),
	NE("NE ", "NE"),
	NS("NS ", "NS"),
	NW("NW ", "NW"),
	E(" E ", "E"),
	ES("ES ", "ES"),
	EW("EW ", "EW"),
	S(" S ", "S"),
	SW("SW ", "SW"),
	W(" W ", "W"),
	NES("NES", "NES"),
	NSW("NSW", "NSW"),
	ESW("ESW", "ESW"),
	NEW("NEW", "NEW"),
	NESW("NESW", "NESW");

	/**
	 * The written representation of the square's fences status
	 */
	private String text;
	/**
	 * The graphical representation for the GUI
	 */
	private ImageIcon image;

	/**
	 * StatusFence constructor
	 * @param text the terminal representation
	 * @param pathFile the part permitting to get the image | Used to find the file in the data : ./data/images/[pathFile].png
	 * @author Pierre-Galaad Naquet
	 */
	StatusFence(String text, String pathFile) {
		this.text = text;
		String str = pathFile + ".png";
		this.image = new ImageIcon(str);
	}

	public String toString() {
		return text;
	}

	public ImageIcon getImage() {
		return this.image;
	}
}
