package quoridor;

public enum Status {
	NONE("--"),
	Player1("P1"),
	Player2("P2");

	private String text;

	Status(String text) {
		this.text = text;
	}

	public String toString() {
		return text;
	}
}
