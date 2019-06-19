package quoridor;

// project import
import gui.MenuGui;
import quoridor.Game;
import utilitary.RWFile;

// java import
import java.awt.*;
import java.util.Scanner;

/**
* Permits to launch a session from which can be launch and saved games
* @author Aymeric Bizouarn , Pierre-Galaad 'P(x)' Naquet
*/
public class Quoridor {

	/**
	 * The Game.
	 */
	private Game game;
	/**
	 * The save file name.
	 */
	private final String fileName = "./data/save/SavedGame.bin";

	private Boolean gui = true;

	/**
	 * Quoridor constructor
	 * Create an object Quoridor
	 * Serve as a platform to load and launch games
	 * @author Aymeric Bizouarn , Pierre-Galaad 'P(x)' Naquet
	 */
	public Quoridor() {
		new MenuGui();
	}
	public Quoridor(String[] args){
		this.gui = true;
		for(String string : args){
			if(string.equals("nogui")){
				this.gui = false;
			}
		}
		if(!this.gui) {
			Scanner scanner = new Scanner(System.in);
			int choice = -1;
			while (choice > 2 || choice < 1) {
				System.out.println("Write : \n1 - For new game\n2 - For load old game");
				choice = scanner.nextInt();
			}
			if (choice == 1) {
				this.game = new Game(this.gui);
			} else if (choice == 2) {
				this.loadOldGame();
			}
			this.launchGame(this.game);
		} else {
			new MenuGui();
		}
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
	 * @return the previously saved game
	 * @author Aymeric Bizouarn
	 */
	public static Game loadOldGame() {
		Game savedGame = RWFile.readFile("./data/save/SavedGame.bin");
		return savedGame;
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
