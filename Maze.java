package maze;

import java.io.IOException;

/**
 * Group Members: Connor Allen, Cameron White, Liel van der Hoeven 
 * @author Liel van der Hoeven
 */

public class Maze 
{
    static Server server = new Server();
    static GUI gui = new GUI();
    public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException 
    {
        gui.createMaze();
        server.run();
    }
    public void update(char[][] button)
    {
        gui.updateColorn(button);
    }
}
