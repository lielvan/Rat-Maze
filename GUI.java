package maze;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Group Members: Connor Allen, Cameron White, Liel van der Hoeven 
 * @author Liel van der Hoeven
 */
public class GUI extends JFrame
{
    Grid grid = new Grid();
    Maze main = new Maze();
    private final int w = 100;
    private final int h = 100;
    JFrame frame = new JFrame("MAZE");
    JButton[][] buttons = new JButton[w][h];
    char maze[][] = grid.getGrid();
    int x = 1, y = 3;
    private String rpos;
    
    public void createMaze()
    {
        //Create the frame
        frame.setLayout(new GridLayout(w,h));
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setSize(1300, 700);
        for(int x = 0; x < w; x++)
        {
            for(int y = 0; y < h; y++)
            {
                buttons[x][y] = new JButton();
                frame.add(buttons[x][y]);
                buttons[x][y].setSize(7, 7);
                buttons[x][y].setBorderPainted(false);
                //buttons[x][y].setVisible(true);
            }
        }
        frame.setVisible(true);
        updateColor();
    }
    public void updateColor()
    {
        for(int x=0; x<w; x++)
        {
            for(int y=0; y<h; y++)
            {
                if(maze[x][y] == 'w')
                {
                    buttons[x][y].setBackground(Color.BLACK);
                    buttons[x][y].setForeground(Color.BLACK);
                    
                }
                else if(maze[x][y] == 'p')
                {
                    buttons[x][y].setBackground(Color.ORANGE);
                    buttons[x][y].setForeground(Color.ORANGE);
                   
                }
                else if(maze[x][y] == 'r')
                {
                    buttons[x][y].setBackground(Color.RED);
                    buttons[x][y].setForeground(Color.RED);
                    
                }
                else
                {
                    buttons[x][y].setBackground(Color.MAGENTA);
                    buttons[x][y].setForeground(Color.MAGENTA);
                    
                }
            }
        }
        //update maze
    }
    public void updateColorn(char[][] test)
    {
        for(int x=0; x<w; x++)
        {
            for(int y=0; y<h; y++)
            {
                if(test[x][y] == 'p')
                {
                    buttons[x][y].setBackground(Color.ORANGE);
                    buttons[x][y].setForeground(Color.ORANGE);
                    
                }
                else if(test[x][y] == 'r')
                {
                    buttons[x][y].setBackground(Color.RED);
                    buttons[x][y].setForeground(Color.RED);
                    
                }
            }
        }
        //update maze
    }
    public String getString(String oldpos)
    {   
        moveRat(oldpos);
       try
       {
        String topl, top, topr, left, middle, right, bottoml, bottom, bottomr;
        topl = String.valueOf(maze[x-1][y-1]);
        top = String.valueOf(maze[x-1][y]);
        topr = String.valueOf(maze[x-1][y+1]);
        left = String.valueOf(maze[x][y-1]);
        middle = String.valueOf(maze[x][y]);
        right = String.valueOf(maze[x][y+1]);
        bottoml = String.valueOf(maze[x+1][y-1]);
        bottom = String.valueOf(maze[x+1][y]);
        bottomr = String.valueOf(maze[x+1][y+1]);
        rpos = topl + top + topr + left + middle + right + bottoml + bottom + bottomr;
       }
       catch(ArrayIndexOutOfBoundsException aioobe)
       {
           System.err.println("It seems as if the rat steped out-of-bounds or successfully finished the maze");
       }
       return rpos;
     }
    public void moveRat(String oldrpos)
    {
        if(oldrpos.indexOf('r') == 1)
        {
            maze[x][y] = 'p';
            x--;
            maze[x][y] = 'r';
        }
        if(oldrpos.indexOf('r') == 3)
        {
            maze[x][y] = 'p';
            y--;
            maze[x][y] = 'r';
        }
        if(oldrpos.indexOf('r') == 5)
        {
            maze[x][y] = 'p';
            y++;
            maze[x][y] = 'r';
        }
        if(oldrpos.indexOf('r') == 7)
        {
            maze[x][y] = 'p';
            x++;
            maze[x][y] = 'r';
        }
        main.update(maze);
    }
}