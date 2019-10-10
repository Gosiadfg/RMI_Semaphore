import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server{

	public static void main(String args[]){
		try
		{
			Adder stub = new AdderRemote(5);
			Registry registry = LocateRegistry.createRegistry(5000);
            registry.rebind("Server", stub);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}