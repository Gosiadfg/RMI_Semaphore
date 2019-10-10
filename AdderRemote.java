import java.rmi.*;
import java.util.concurrent.Semaphore;
import java.rmi.server.UnicastRemoteObject;

public class AdderRemote extends UnicastRemoteObject implements Adder
{
	private Semaphore semaphore;
	public int counter = 0;
	
	AdderRemote(int maxX)throws RemoteException
	{
		super();
        this.semaphore = new Semaphore(maxX, true);
	}
	
	@Override
	public int take(int x) throws InterruptedException
	{
        this.semaphore.acquire(x);
		return counter++;
    }

	@Override
    public void release(int x)
	{
        this.semaphore.release(x);
    }
}