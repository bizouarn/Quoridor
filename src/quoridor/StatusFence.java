package quoridor;

import javax.swing.*;

/**
 * Enumeration containing the StatusFence of the squares, Uses the cardinal points.
 * @author Pierre-Galaad 'P(x)' Naquet, Aymeric Bizouarn
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

	private String text;
	private ImageIcon image;

	StatusFence(String text, String pathFile) {
		this.text = text;
		String str = "./data/images/" + pathFile + ".png";
		this.image = new ImageIcon(str);
	}

	public String toString() {
		return text;
	}

	public ImageIcon getImage() {
		return this.image;
	}
}
