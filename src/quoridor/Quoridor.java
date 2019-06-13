package quoridor;

// project import
import quoridor.Game;
import utilitary.RWFile;

// java import
import java.util.Scanner;

/**
* Permits to launch a session from which can be launch and saved games
* @author Aymeric Bizouarn , Pierre-Galaad 'P(x)' Naquet
*/
public class Quoridor {

	private Game game;
	private String fileName;

	/**
	 * Quoridor constructor
	 * Create an object Quoridor
	 * Serve as a platform to load and launch games
	 * @param fileName path to the file where the current game will be saved in
	 * @author Aymeric Bizouarn
	 */
	public Quoridor(String fileName) {
		this.fileName = fileName;
		Scanner scanner = new Scanner(System.in);
		int seizure = -1;
		while (seizure>2 || seizure<1){
			System.out.println("Write : \n1 - For new game\n2 - For load old game");
			seizure =scanner.nextInt();
		}
		if(seizure == 1){
			this.game = new Game();
		} else if(seizure == 2){
			this.loadOldGame();
		}
		this.launchGame(this.game);
	}

	/**
	 * Get Quoridor Game.
	 * @return the Game of the current Quoridor.
	 * @author Aymeric Bizouarn
	 */
	public Game getGame() {
		return this.game;
	}

	/**
	 * @return The previously saved game
	 * @author Aymeric Bizouarn
	 */
	public Game loadOldGame() {
		Game game = RWFile.readFile(this.fileName);
		return game;
	}

	/**
	 * Launch the chosen game
	 * @param game the desired game to launch
	 * @author Aymeric Bizouarn
	 */
	public void launchGame(Game game) {
		this.game.start();
	}

	/**
	 * Save the desired game into the saving file of the current Quoridor object
	 * @param game The desired game to save
	 * @author Aymeric Bizouarn
	 */
	public void saveGame(Game game) {
		RWFile.writeFile(this.fileName,this.game);
	}

}
