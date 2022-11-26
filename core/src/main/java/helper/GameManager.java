package helper;


public class GameManager {

    private static GameManager ourInstance = new GameManager();

    public boolean gameStartedFromMainMenu, isPaused=true;
    public int lifeScore, coinScore, score;

    private GameManager() {

    }

    public static GameManager getInstance() {
        return ourInstance;
    }

}


// --------------- This is a singleton class pattern --------------------------
// public class GameManager {
//    private static GameManager ourInstance = new GameManager();
//
//    public static GameManager getInstance() {
//        return ourInstance;
//    }
//
//    private GameManager() {
//    }
// } --------------------------------------------------------------------------
