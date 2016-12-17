import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;;

public class PamiecCzasList {

	public static void main(String[] args) throws InterruptedException {
		
//		TreeSet<Integer> list = new TreeSet<Integer>();
//		double startMemory = (Runtime.getRuntime().totalMemory() -  Runtime.getRuntime().freeMemory());
//		for(int i = 0; i < 10000; i++){
//			list.add(i);
//		}
//		
//		 double endMemory = (Runtime.getRuntime().totalMemory() -  Runtime.getRuntime().freeMemory());
//		 
//		 System.out.println(endMemory - startMemory);
//		 return;
		testArrayList();
		testHashSet();
		testLinkedList();
		testStack();
		testVector();
		testPriorityQueue();
		testTreeSet();
	}
	
	private static void testArrayList(){
		long timeAdd[] = new long[10];
		long timeRemove[] = new long[10];
		long timeContains[] = new long[10];
		for(int i =0; i < 10; i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			System.nanoTime();
			long time1 = System.nanoTime();
			for(int j = 0; j < 10000; j++){
				list.add(j);
			}
			long time2 = System.nanoTime();
			timeAdd[i] = (time2 - time1);
			//System.out.println("Czas add() ArrayList " + timeAdd[i]);
			
			System.nanoTime();
			long timeContainsStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.contains(j);
			}
			long timeContainsStop = System.nanoTime();
			timeContains[i] = (timeContainsStop - timeContainsStart);
			
			System.nanoTime();
			long timeRemoveStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.remove(j/2);
			}
			long timeRemoveStop = System.nanoTime();
			timeRemove[i] = (timeRemoveStop - timeRemoveStart);
			//System.out.println("Czas add() ArrayList " + timeRemove[i]);
			
			
//			System.out.println("Czas add() ArrayList " + timeRemove[i]);
		}
		System.out.println("Średni czas add() ArrayList " + sredniCzas(timeAdd)/1000000000  + "s");
		System.out.println("Odchylenie standard add() ArrayList " + odchylenieStandard(timeAdd)/1000000000 + "s");
		System.out.println("Średni czas remove() ArrayList " + sredniCzas(timeRemove)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe remove() ArrayList " + odchylenieStandard(timeRemove)/1000000000  + "s");
		System.out.println("Średni czas contains() ArrayList " + sredniCzas(timeContains)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe contains() ArrayList " + odchylenieStandard(timeContains)/1000000000  + "s");
		System.out.println("**************************************************************");
	}
	
	private static void testHashSet(){
		long timeAdd[] = new long[10];
		long timeRemove[] = new long[10];
		long timeContains[] = new long[10];
		for(int i =0; i < 10; i++){
			HashSet<Integer> list = new HashSet<Integer>();
			
			System.nanoTime();
			long time1 = System.nanoTime();
			for(int j = 0; j < 10000; j++){
				list.add(j);
			}
			long time2 = System.nanoTime();
			timeAdd[i] = (time2 - time1);
			//System.out.println("Czas add() HashSet " + timeAdd[i]);
			
			System.nanoTime();
			long timeContainsStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.contains(j);
			}
			long timeContainsStop = System.nanoTime();
			timeContains[i] = (timeContainsStop - timeContainsStart);
			
			System.nanoTime();
			long timeRemoveStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.remove(j/2);
			}
			long timeRemoveStop = System.nanoTime();
			timeRemove[i] = (timeRemoveStop - timeRemoveStart);
			//System.out.println("Czas add() HashSet " + timeRemove[i]);
			
			
//			System.out.println("Czas add() HashSet " + timeRemove[i]);
		}
		System.out.println("Średni czas add() HashSet " + sredniCzas(timeAdd)/1000000000  + "s");
		System.out.println("Odchylenie standard add() HashSet " + odchylenieStandard(timeAdd)/1000000000  + "s");
		System.out.println("Średni czas remove() HashSet " + sredniCzas(timeRemove)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe remove() HashSet " + odchylenieStandard(timeRemove)/1000000000  + "s");
		System.out.println("Średni czas contains() HashSet " + sredniCzas(timeContains)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe contains() HashSet " + odchylenieStandard(timeContains)/1000000000  + "s");
		System.out.println("**************************************************************");

	}
	
	private static void testLinkedList(){
		long timeAdd[] = new long[10];
		long timeRemove[] = new long[10];
		long timeContains[] = new long[10];
		for(int i =0; i < 10; i++){
			LinkedList<Integer> list = new LinkedList<Integer>();
			
			System.nanoTime();
			long time1 = System.nanoTime();
			for(int j = 0; j < 10000; j++){
				list.add(j);
			}
			long time2 = System.nanoTime();
			timeAdd[i] = (time2 - time1);
			//System.out.println("Czas add() HashSet " + timeAdd[i]);
			
			System.nanoTime();
			long timeContainsStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.contains(j);
			}
			long timeContainsStop = System.nanoTime();
			timeContains[i] = (timeContainsStop - timeContainsStart);
			
			System.nanoTime();
			long timeRemoveStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.remove(j/2);
			}
			long timeRemoveStop = System.nanoTime();
			timeRemove[i] = (timeRemoveStop - timeRemoveStart);
			//System.out.println("Czas add() HashSet " + timeRemove[i]);
			
			
//			System.out.println("Czas add() HashSet " + timeRemove[i]);
		}
		System.out.println("Średni czas add() LinkedList " + sredniCzas(timeAdd)/1000000000  + "s");
		System.out.println("Odchylenie standard add() LinkedList " + odchylenieStandard(timeAdd)/1000000000  + "s");
		System.out.println("Średni czas remove() LinkedList " + sredniCzas(timeRemove)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe remove() LinkedList " + odchylenieStandard(timeRemove)/1000000000  + "s");
		System.out.println("Średni czas contains() LinkedList " + sredniCzas(timeContains)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe contains() LinkedList " + odchylenieStandard(timeContains)/1000000000  + "s");
		System.out.println("**************************************************************");

	}
	
	private static void testStack(){
		long timeAdd[] = new long[10];
		long timeRemove[] = new long[10];
		long timeContains[] = new long[10];
		for(int i =0; i < 10; i++){
			Stack<Integer> list = new Stack<Integer>();
			
			System.nanoTime();
			long time1 = System.nanoTime();
			for(int j = 0; j < 10000; j++){
				list.add(j);
			}
			long time2 = System.nanoTime();
			timeAdd[i] = (time2 - time1);
			//System.out.println("Czas add() HashSet " + timeAdd[i]);
			
			System.nanoTime();
			long timeContainsStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.contains(j);
			}
			long timeContainsStop = System.nanoTime();
			timeContains[i] = (timeContainsStop - timeContainsStart);
			
			System.nanoTime();
			long timeRemoveStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.remove(j/2);
			}
			long timeRemoveStop = System.nanoTime();
			timeRemove[i] = (timeRemoveStop - timeRemoveStart);
			//System.out.println("Czas add() HashSet " + timeRemove[i]);
			
			
//			System.out.println("Czas add() HashSet " + timeRemove[i]);
		}
		System.out.println("Średni czas add() Stack " + sredniCzas(timeAdd)/1000000000  + "s");
		System.out.println("Odchylenie standard add() Stack " + odchylenieStandard(timeAdd)/1000000000  + "s");
		System.out.println("Średni czas remove() Stack " + sredniCzas(timeRemove)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe remove() Stack " + odchylenieStandard(timeRemove)/1000000000  + "s");
		System.out.println("Średni czas contains() Stack " + sredniCzas(timeContains)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe contains() Stack " + odchylenieStandard(timeContains)/1000000000  + "s");
		System.out.println("**************************************************************");

	}
	
	private static void testVector(){
		long timeAdd[] = new long[10];
		long timeRemove[] = new long[10];
		long timeContains[] = new long[10];
		for(int i =0; i < 10; i++){
			Vector<Integer> list = new Vector<Integer>();
			
			System.nanoTime();
			long time1 = System.nanoTime();
			for(int j = 0; j < 10000; j++){
				list.add(j);
			}
			long time2 = System.nanoTime();
			timeAdd[i] = (time2 - time1);
			//System.out.println("Czas add() HashSet " + timeAdd[i]);
			
			System.nanoTime();
			long timeContainsStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.contains(j);
			}
			long timeContainsStop = System.nanoTime();
			timeContains[i] = (timeContainsStop - timeContainsStart);
			
			System.nanoTime();
			long timeRemoveStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.remove(j/2);
			}
			long timeRemoveStop = System.nanoTime();
			timeRemove[i] = (timeRemoveStop - timeRemoveStart);
			//System.out.println("Czas add() HashSet " + timeRemove[i]);
			
			
//			System.out.println("Czas add() HashSet " + timeRemove[i]);
		}
		System.out.println("Średni czas add() Vector " + sredniCzas(timeAdd)/1000000000  + "s");
		System.out.println("Odchylenie standard add() Vector " + odchylenieStandard(timeAdd)/1000000000  + "s");
		System.out.println("Średni czas remove() Vector " + sredniCzas(timeRemove)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe remove() Vector " + odchylenieStandard(timeRemove)/1000000000  + "s");
		System.out.println("Średni czas contains() Vector " + sredniCzas(timeContains)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe contains() Vector " + odchylenieStandard(timeContains)/1000000000  + "s");
		System.out.println("**************************************************************");

	}
	
	private static void testPriorityQueue(){
		long timeAdd[] = new long[10];
		long timeRemove[] = new long[10];
		long timeContains[] = new long[10];
		for(int i =0; i < 10; i++){
			PriorityQueue<Integer> list = new PriorityQueue<Integer>();
			
			System.nanoTime();
			long time1 = System.nanoTime();
			for(int j = 0; j < 10000; j++){
				list.add(j);
			}
			long time2 = System.nanoTime();
			timeAdd[i] = (time2 - time1);
			//System.out.println("Czas add() HashSet " + timeAdd[i]);
			
			System.nanoTime();
			long timeContainsStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.contains(j);
			}
			long timeContainsStop = System.nanoTime();
			timeContains[i] = (timeContainsStop - timeContainsStart);
			
			System.nanoTime();
			long timeRemoveStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.remove(j/2);
			}
			long timeRemoveStop = System.nanoTime();
			timeRemove[i] = (timeRemoveStop - timeRemoveStart);
			//System.out.println("Czas add() HashSet " + timeRemove[i]);
			
			
//			System.out.println("Czas add() HashSet " + timeRemove[i]);
		}
		System.out.println("Średni czas add() PriorityQueue " + sredniCzas(timeAdd)/1000000000  + "s");
		System.out.println("Odchylenie standard add() PriorityQueue " + odchylenieStandard(timeAdd)/1000000000  + "s");
		System.out.println("Średni czas remove() PriorityQueue " + sredniCzas(timeRemove)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe remove() PriorityQueue " + odchylenieStandard(timeRemove)/1000000000  + "s");
		System.out.println("Średni czas contains() PriorityQueue " + sredniCzas(timeContains)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe contains() PriorityQueue " + odchylenieStandard(timeContains)/1000000000  + "s");
		System.out.println("**************************************************************");

	}

	
	private static void testTreeSet(){
		long timeAdd[] = new long[10];
		long timeRemove[] = new long[10];
		long timeContains[] = new long[10];
		for(int i =0; i < 10; i++){
			TreeSet<Integer> list = new TreeSet<Integer>();
			
			System.nanoTime();
			long time1 = System.nanoTime();
			for(int j = 0; j < 10000; j++){
				list.add(j);
			}
			long time2 = System.nanoTime();
			timeAdd[i] = (time2 - time1);
			//System.out.println("Czas add() HashSet " + timeAdd[i]);
			
			System.nanoTime();
			long timeContainsStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.contains(j);
			}
			long timeContainsStop = System.nanoTime();
			timeContains[i] = (timeContainsStop - timeContainsStart);
			
			System.nanoTime();
			long timeRemoveStart = System.nanoTime();
			for(int j = 9999; j >= 0; j--){
				list.remove(j/2);
			}
			long timeRemoveStop = System.nanoTime();
			timeRemove[i] = (timeRemoveStop - timeRemoveStart);
			//System.out.println("Czas add() HashSet " + timeRemove[i]);
			
			
//			System.out.println("Czas add() HashSet " + timeRemove[i]);
		}
		System.out.println("Średni czas add() TreeSet " + sredniCzas(timeAdd)/1000000000  + "s");
		System.out.println("Odchylenie standard add() TreeSet " + odchylenieStandard(timeAdd)/1000000000  + "s");
		System.out.println("Średni czas remove() TreeSet " + sredniCzas(timeRemove)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe remove() TreeSet " + odchylenieStandard(timeRemove)/1000000000  + "s");
		System.out.println("Średni czas contains() TreeSet " + sredniCzas(timeContains)/1000000000  + "s");
		System.out.println("Odchylenie standardiwe contains() TreeSet " + odchylenieStandard(timeContains)/1000000000  + "s");
		System.out.println("**************************************************************");

	}
	
	private static double sredniCzas(long time[]){
		double sum = 0;
		for(int i = 0; i < time.length; i++){
			sum += time[i];
		}
		return sum / time.length;
	}
	
	private static double odchylenieStandard(long time[]){
		double srednie = sredniCzas(time);
		double odchylenie = 0;
		for(int i = 0; i < time.length; i++){
			odchylenie += Math.pow((time[i] - srednie), 2);
		}
		odchylenie /= time.length;
		return Math.sqrt(odchylenie);
	}
}