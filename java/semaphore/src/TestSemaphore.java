/**
 * TestSemaphore - test semaphore
 * 
 * This test code is originally from
 * http://programmingexamples.wikidot.com/java-semaphore
 * 
 * @author hideki
 */
public class TestSemaphore extends Thread {
	private static final int MAX_AVAILABELE = 2;
	private static final int MAX_PROCESS = 5;

	private int id = -1;
	private Semaphore semaphore = null;

	public TestSemaphore(int id, Semaphore semaphore) {
		this.id = id;
		this.semaphore = semaphore;
	}


	private void critical() {
		System.out.println("Thread " + id + " entering critical section");
		try {
			// sleep 10 sec
			Thread.sleep(3 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		System.out.println("Thread " + id + " leaving critical section");
	}

	public void run() {
		for (int i = 0; i < 2; ++i) {
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			critical();
			semaphore.release();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(MAX_AVAILABELE);
		TestSemaphore[] p = new TestSemaphore[MAX_PROCESS];
		for (int i = 0; i < MAX_PROCESS; i++) {
			p[i] = new TestSemaphore(i, semaphore);
			p[i].start();
		}
	}
}
