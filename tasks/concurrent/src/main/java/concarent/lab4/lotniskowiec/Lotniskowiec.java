package concarent.lab4.lotniskowiec;

import java.util.concurrent.locks.Lock;

import concarent.lab1.JareksLock;

public class Lotniskowiec {

	Lock lock = new JareksLock();
	private int maxSize;
	private int k;
	private int count=0;
	private int countChceLadowac=0;
	
	public Lotniskowiec(int maxSize,int iloscSamolotow) {
	this.maxSize=maxSize;
	this.k=maxSize/2;
	System.out.println(k);
	
	}

	public void chceLadowac(int name) throws InterruptedException {
		System.out.println(name + " samolot chce ladowac");	
		lock.lock();
		countChceLadowac++;
		lock.unlock();
		
		System.out.println(countChceLadowac +"----------------------------- samolotow w kolejce na ladfowabnie "+countChceLadowac);
		
		ladowanie(name);
		wyladowalem(name);
		
		lock.lock();
		countChceLadowac--;
		lock.unlock();
		System.out.println(countChceLadowac +"----------------------------- samolotow w kolejce na ladfowabnie "+countChceLadowac);
	}

	public synchronized void ladowanie(int name) throws InterruptedException {
		
		while(count>=maxSize){
			this.notifyAll();
			this.wait();
		}
		
		System.out.println(name + " samolot laduje...");
		Thread.sleep(1000);
		
		this.notifyAll();
	}

	public void wyladowalem(int name) {
		count++;
		System.out.println(name + " samolot wyladlowal");
		System.out.println("=============================   na pokladzie jest "+count);
	}

	public  void chceStartowac(int name) throws InterruptedException {
		System.out.println(name + " samolot chce Startowac, w kolejce na ladowanie jest: "+countChceLadowac);
		
		
		
		start(name);
		wystartowalem(name);
		

	}

	public synchronized void start(int name) throws InterruptedException {
		
		while ((k>=count&&countChceLadowac>0)&&(count!=maxSize)) {
			this.notifyAll();
			this.wait();
			
		} 
		System.out.println(name + " samolot startuje...");
		Thread.sleep(2000);
		
		this.notifyAll();
	}

	public void wystartowalem(int name) {
		count--;
		System.out.println(name + " samolot wystartowal");
		System.out.println("=============================   na pokladzie jest "+count);
	}
	
	public static void main(String[] args) {
		int iloscSamolotow=20;
		Lotniskowiec lotniskowiec = new Lotniskowiec(4,iloscSamolotow);
		
		for(int i=0;i<iloscSamolotow;i++){
		Thread thread=new Thread(new Samolot(i, lotniskowiec));
		thread.start();
		}
		
	}
}
