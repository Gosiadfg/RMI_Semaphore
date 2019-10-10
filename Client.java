import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client{

	public static void main(String args[]){
		try
		{
			int i = 0;
			int x;
	
			Registry r = LocateRegistry.getRegistry(5000);
			Adder stub = (Adder)r.lookup("Server");			
	
			while(i<5){
				
				x = Integer.parseInt(args[0]);
				System.out.println("Waiting...");
				System.out.println("Take " + stub.take(x));

				try{
					Thread.sleep(2000);
				}
				catch(InterruptedException exc)
				{
					Thread.currentThread().interrupt();
				}

				stub.release(x);
				System.out.println("Release");
				i++;	
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}