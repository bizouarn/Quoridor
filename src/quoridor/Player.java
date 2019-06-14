package quoridor;

/**
 * Player
 *
 * @author Aymeric Bizouarn
 */
public abstract class Player {
    /**
     * The Game
     */
    private Game game;
    /**
     * The player Name.
     */
    private String name;
    /**
     * The player nbFences.
     */
    private int nbFences;

    /**
     * Player constructor
     * it cans either be human or bot
     * it has a dedidcated pawn and a number of fences left.
     * @author Aymeric Bizouarn
     */
    public Player(String name,Game game) {
        this.name = name;
        this.nbFences = 10;
        this.game = game;
    }

    public abstract void play();

    public String getName() {
        return this.name;
    }

    /**
     * Return number of player fence remaining.
     * @return the number of fences left playable by the player
     * @author Aymeric Bizouarn
     */
    public int checkNbRestingFences() {
        return this.nbFences;
    }

    /**
     * Set Player nbFences.
     * @param nbFences The player nbFences.
     * @author Aymeric Bizouarn
     */
    public void setNbFences(int nbFences) {
        this.nbFences = nbFences;
    }

    public Game getGame() {
        return game;
    }
}
