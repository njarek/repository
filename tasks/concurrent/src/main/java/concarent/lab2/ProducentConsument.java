package concarent.lab2;


public class ProducentConsument {

	public static void main(String[] args) {
		ProducentConsument producentConsument = new ProducentConsument();
		producentConsument.go();
	}

	BlockingQueue blockingQueue = new BlockingQueue(5);

	private void go() {
		Thread producent = new Thread(new Runnable() {

			public void run() {
				try {
					sent("producent");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});

		Thread consument = new Thread(new Runnable() {

			public void run() {
				try {
					take("consument");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		producent.start();
		consument.start();
	}

	private void sent(String threadname) throws InterruptedException {
		int y = 0;
		for (int i = 0; i < 100; i++) {
			Thread.sleep((long) (Math.random() * 500));
			String message = "" + "" + Math.random();
			blockingQueue.put(message, threadname);
			System.out.println("producent sent " + message + " message " + y++);
		}
	}

	private void take(String string) throws InterruptedException {
		Thread.sleep(2000);
		for (int i = 0; i < 100; i++) {
			Thread.sleep(1000);

			System.out.println("consumet take " + blockingQueue.take() + " "
					+ i);
		}

	}

}
