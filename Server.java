package maze;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Group Members: Connor Allen, Cameron White, Liel van der Hoeven 
 * @author Liel van der Hoeven
 */
public class Server 
{
    ServerSocket providerSocket;
    Socket connection = null;
    ObjectOutputStream out;
    ObjectInputStream in;
    String ratposition;
    GUI g = new GUI();
    
    public void run() throws ClassNotFoundException, InterruptedException
    {
        try
        {
            String move;
            int count = 0;
            int maxcount = 50000;
            providerSocket = new ServerSocket(13000);
            System.out.println("Waiting for Client to connect...");
            connection = providerSocket.accept();
            out = new ObjectOutputStream(connection.getOutputStream());
            out.flush();
            in = new ObjectInputStream(connection.getInputStream());
            do
            {
                    ratposition = (String)in.readObject();
                    System.out.println(ratposition);
                    move = g.getString(ratposition);
                    System.out.println(move);
                    if(ratposition.equals("ppwwpworo"))
                    {
                        move = "ooooooooo";
                    }
                    if(count == maxcount)
                    {
                        move = "wwwwwwwww";
                    }
                    out.writeObject(move);
                    count++;
              }while(!ratposition.equals("ppwwpworo"));
                out.close();
                in.close();
                providerSocket.close();
            }
	catch(IOException ioException)
        {
            ioException.printStackTrace();
	}
    }    
}