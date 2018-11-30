import java.util.concurrent.ThreadLocalRandom;

abstract class Worker extends Thread {
	
	protected boolean run;
	
	//uspienie watku na dany czas
	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//uspienie watku na losowo wybrany czas z przedzialu
	public static void sleep(int minMillis, int maxMillis) {
		sleep(ThreadLocalRandom.current().nextInt(minMillis, maxMillis));
	}
	
	/*
	Unikalny identyfikator przedmiotu wyprodukowanego przez
	producenta i zuzytego przez konsumenta
	Identyfikator jest wspolny dla wszystkich producentow i
	bedzie zwiekszany przy produkcji kazdego nowego przedmiotu*/
	public static int itemID = 0;
	
    // Minimalny i maksymalny czas produkcji przedmiotu
    public static int MIN_PRODUCER_TIME = 100;
    public static int MAX_PRODUCER_TIME = 1000;

    // Minimalny i maksymalny czas konsumpcji (zu�ycia) przedmiotu
    public static int MIN_CONSUMER_TIME = 100;
    public static int MAX_CONSUMER_TIME = 1000;
    
    String name;
    Buffer buffer;
    
	@Override
	public void run() {
	}
    
    public void setRun(boolean run) {
    	this.run = run;
    }
    
    public boolean getRun() {
    	return run;
    }

}