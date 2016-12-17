import java.util.concurrent.PriorityBlockingQueue;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class Main {

	public static void main(String[] args) {
//		PriorityQueue<Character> tmp = new PriorityQueue<Character>(10);
//		tmp.add('c', );
//		tmp.add('r', 0);
//		tmp.add('a', 1);
//		tmp.add('b', 2);
//		tmp.add('c', 10);
//		tmp.add('r', 10);
//		tmp.add('a', 10);
//		tmp.add('b', 10);
	
//		System.out.println(tmp.get());
//		System.out.println(tmp.get());
//		System.out.println(tmp.get());
//		System.out.println(tmp.get());
		
//		for(int i = 0; i < 10; i++){
//			System.out.println((int)(Math.random()*10));
//
//		}
		
//		for(int i = 0; i < 100; i++){
//			tmp.add('c', (int)(Math.random()*10));
//		}

		PriorityBlockingQueue<Character> tmp = new PriorityBlockingQueue<Character>();
		for(int i = 0; i < 100; i++){
			tmp.add('c', (int)(Math.random()*10));
		}
	}
}


