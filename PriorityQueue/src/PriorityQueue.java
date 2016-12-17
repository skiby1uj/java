import java.io.PipedReader;
import java.util.concurrent.PriorityBlockingQueue;

import javax.xml.transform.Templates;

class Para<T>{
	public int waga;
	public T value;
	
	Para(T vlaue, int waga){
		this.waga = waga;
		this.value = vlaue;
	}
}


public class PriorityQueue<T>{
	Para[] queue;
	int n;//max ilosc elementow w kolejce
	int endQueue;
	
	PriorityQueue(int n){
		endQueue = 0;
		this.queue = new Para[n];
		this.n = n;
	}
	
	void add(T t, int waga){
		if(endQueue == 0){
			queue[0] = new Para(t, waga);
			endQueue++;
		}
		else{
			int i = findElement(0, endQueue, waga);
			System.out.println(i);
			/*if(queue[i] == null){
				queue[i] = new Para(t, waga);
			}
			else if(queue[i+1] != null && queue[i+1].waga <= waga){
				shiftTable(i+1);
				queue[i+1] = new Para(t, waga);
			}	
			else{*/
				shiftTable(i);
				queue[i] = new Para(t, waga);
			//}
			endQueue++;
		}
	}
	
	int findElement(int pocz, int koniec, int waga){
		
		while(pocz < koniec && queue[pocz].waga < waga){
			pocz++;
		}
		return pocz;
	}
	
//	int findElement(int pocz, int koniec, int waga){
//		if(koniec-1 <= pocz){
//			return pocz;
//		}
//		if(queue[(koniec-pocz)/2].waga > waga){
//			return findElement((koniec-pocz)/2+1, koniec, waga);
//		}
//		else {
//			return findElement(pocz, (koniec-pocz)/2, waga);
//		}
//	}
	
	void shiftTable(int pozycja){
		int tmp = endQueue;
		while(pozycja < tmp){
			queue[tmp] = queue[tmp-1];
			tmp--;
		}
	}

	T get(){
		T tomp = (T) queue[0].value;
		endQueue--;
		for(int i = 0; i < endQueue; i++){
			queue[i] = queue[i+1];
		}
		return (T) tomp;
	}
}
