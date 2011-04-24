
/**
 * Semaphore - counting semaphore class
 * 
 * Method interface is from http://download.oracle.com/javase/6/docs/api/	- java.util.concurrent.Semaphore
 * @author hideki
 */
public class Semaphore {
	private int permits = 0;
	
	public Semaphore(int permits){
		this.permits = permits;
	}
	
	public synchronized void acquire() throws InterruptedException{
		while(permits == 0){
			this.wait();
		}
		permits--;
	}
	
	public synchronized void release(){
		permits++;
		this.notifyAll();
	}
}
