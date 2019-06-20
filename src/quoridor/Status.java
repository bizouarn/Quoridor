package quoridor;

/**
 * Enumeration containing the Status of the squares, if it contains a player or not
 * @author Pierre-Galaad 'P(x)' Naquet, Aymeric Bizouarn
 */
public enum Status {
	NONE("--"),
	Player1("P1"),
	Player2("P2");

	/**
	 * Permits the terminal representation of the square status. -- : none | P1 : Player1 | P2 : Player2
	 */
	private String text;

	Status(String text) {
		this.text = text;
	}

	public String toString() {
		return text;
	}
}
