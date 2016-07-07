package rat;

import java.io.*;
import java.net.*;

/**
 * Group Members: Connor Allen, Cameron White, Liel van der Hoeven 
 * @author Liel van der Hoeven
 */

public class Client
{
    static Socket socket;
    static ObjectOutputStream out;
    static ObjectInputStream in;
    static String ratposition, move;
    static Rat rat = new Rat();
    
    public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException
    {
        
	try
        {
            ratposition = "pooprppww";
            socket = new Socket("localhost", 13000);
            System.out.println("Connected to localhost in port 13000");
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.getInputStream());
            do
            {
                try
                {
                    move = rat.nextStep(ratposition);
                    System.out.println(move);
                    out.writeObject(move);
                    ratposition = (String)in.readObject();
                    Thread.sleep(20);
                }
                catch(SocketException soexception)
                {
                    System.err.println("Disconnected from the server");
                }
                if(ratposition.equals("wwwwwwwww"))
                {
                    System.err.println("The rat seems to be lost...");
                }
            }while(!ratposition.equals("ooooooooo"));
        }
        catch(UnknownHostException unknownHost)
        {
            System.err.println("Who are you trying to connect to?...");
	}
	catch(IOException ioException)
        {
            ioException.printStackTrace();
	}
        finally
        {
            out.close();
            in.close();
            socket.close();
        }
    }
}