package game.state;
 
import game.Game;
import game.character.Player;
import game.controller.MouseAndKeyBoardPlayerController;
import game.controller.PlayerController;
import game.level.Level;
 
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
 
public class LevelState extends BasicGameState {
	 
    private Level  level;
    private String startinglevel;
    private Player player;
    private PlayerController playerController;
 
    public LevelState(String startingLevel){
        this.startinglevel = startingLevel;
    }
 
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
 
        //once we initialize our level, we want to load the right level
        level = new Level(startinglevel);
 
        //at the start of the game we don't have a player yet
        player = new Player(128, 416);
        level.addCharacter(player);
 
        //and we create a controller, for now we use the MouseAndKeyBoardPlayerController
        playerController = new MouseAndKeyBoardPlayerController(player);
    }
 
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
        //every update we have to handle the input from the player
        playerController.handleInput(container.getInput(), delta);
    }
 
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        g.scale(Game.SCALE, Game.SCALE);
        //render the level
        level.render();
    }
 
    @Override
    public void keyPressed(int key, char code)
    {
        if(key == Input.KEY_ESCAPE)
        {
            System.exit(0);
        }
    }
 
    public int getID() {
        //this is the id for changing states
        return 0;
    }
 
}