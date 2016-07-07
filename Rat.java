package rat;

/**
 * Group Members: Connor Allen, Cameron White, Liel van der Hoeven 
 * @author Liel van der Hoeven
 * Rat algorithm found by Cameron White
 */
public class Rat
{
    char posarray[][] = new char[3][3];
    int num = 0;
    String nextmove = "";
    char dir = 'e';
    
    public String nextStep(String pos)
    {
        nextmove = "";
        for(int x=0; x<3; x++)
        {
            for(int y=0; y<3; y++)
            {
                posarray[x][y] = pos.charAt(num);
                num++;
            }
        }
        num = 0;
        move();
        newString();
        return nextmove;
    }
    public void move()
    {
        if(dir == 'n')
        {
            if(posarray[1][0] == 'p')
            {
                dir = 'w';
                posarray[1][0] = 'r';
                posarray[1][1] = 'p';
                System.out.println("The rat is now heading West");
            }
            if(dir == 'n')
            {
                if(posarray[0][1] == 'p')
                {
                    posarray[0][1] = 'r';
                    posarray[1][1] = 'p';
                    System.out.println("The rat is still heading North");
                }
                else
                {
                    dir='e';
                }
            }
        }
        else if(dir == 's')
        {
            if(posarray[1][2] == 'p')
            {
                dir = 'e';
                posarray[1][2] = 'r';
                posarray[1][1] = 'p';
                System.out.println("The rat is now heading East");
            }
            if(dir == 's')
            {
                if(posarray[2][1] == 'p')
                {
                    posarray[2][1] = 'r';
                    posarray[1][1] = 'p';
                    System.out.println("The rat is still heading South");
                }
                else
                {
                    dir='w';
                }
            }
        }
        else if(dir == 'e')
        {
            if(posarray[0][1] == 'p')
            {
                dir = 'n';
                posarray[0][1] = 'r';
                posarray[1][1] = 'p';
                System.out.println("The rat is now heading North");
            }
            if(dir == 'e')
            {
                if(posarray[1][2] == 'p')
                {
                    posarray[1][2] = 'r';
                    posarray[1][1] = 'p';
                    System.out.println("The rat is still heading East");
                }
                else
                {
                    dir='s';
                }
            }
        }
        else if(dir == 'w')
        {
            if(posarray[2][1] == 'p')
            {
                dir = 's';
                posarray[2][1] = 'r';
                posarray[1][1] = 'p';
                System.out.println("The rat is now heading South");
            }
            if(dir == 'w')
            {
                if(posarray[1][0] == 'p')
                {
                    posarray[1][0] = 'r';
                    posarray[1][1] = 'p';
                    System.out.println("The rat is still heading West");
                }
                else
                {
                    dir='n';
                }
            }
        }
    }
    public void newString()
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                nextmove += String.valueOf(posarray[i][j]);
            }
        }
    }
}
