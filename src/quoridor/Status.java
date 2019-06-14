package quoridor;

public enum Status {
	NONE("NONE"),
	Player1("Player1"),
	Player2("Player2");

	private String text;

	Status(String text) {
		this.text = text;
	}

	public String toString() {
		return text;
	}
}
