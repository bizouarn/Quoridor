package quoridor;

/**
 * Enumeration containing the StatusFence of the squares, Uses the cardinal points.
 * @author Pierre-Galaad 'P(x)' Naquet, Aymeric Bizouarn
 */
public enum StatusFence {
	NONE("   "),
	N(" N "),
	NE("NE "),
	NS("NS "),
	NW("NW "),
	E(" E "),
	ES("ES "),
	EW("EW "),
	S(" S "),
	SW("SW "),
	W(" W "),
	NES("NES"),
	NSW("NSW"),
	ESW("ESW"),
	NEW("NEW"),
	NESW("NESW");

	private String text;

	StatusFence(String text) {
		this.text = text;
	}

	public String toString() {
		return text;
	}
}
