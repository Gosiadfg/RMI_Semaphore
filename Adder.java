import java.rmi.*;

public interface Adder extends Remote
{
	public void release(int x) throws RemoteException;
	public int take(int x) throws RemoteException, InterruptedException;
}