package concarent.lab4.lotniskowiec;

public class Samolot implements Runnable {

	private int name;
	private Lotniskowiec lotniskowiec;

	public Samolot(int name, Lotniskowiec lotniskowiec) {
		this.name = name;
		this.lotniskowiec = lotniskowiec;
	}

	public void run() {
		while (true) {
			try {
				lot();
				chceLadowac();
				postoj();
				chceStartowac();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void lot() throws InterruptedException {
	
		
		
		double math=Math.random();
		
		double cos=math*10000;
		
		long cos2=(long) cos;
	
		long random = cos2* (name+1);
		System.out.println(name + " samolot w powietrzu.. bedzie latal "+(random)+"ms");
		Thread.sleep(random);
	}

	public void chceLadowac() throws InterruptedException {

		lotniskowiec.chceLadowac(name);
	}

	public void postoj() throws InterruptedException {
		double math=Math.random();
	
		double cos=math*1000;
		
		long cos2=(long) cos;
	
		long random = cos2* (name+1);
		System.out.println(name + " samolot na postoju... bedzie czekal "+(random)+"ms");
		Thread.sleep(random);
	}

	public void chceStartowac() throws InterruptedException {
		lotniskowiec.chceStartowac(name);
	}

}
