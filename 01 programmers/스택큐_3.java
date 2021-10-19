package pro;
import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/42583

class Truck{
	int weight;
	int time;
	
	public Truck(int weight, int time) {
		this.weight = weight;
		this.time = time;
	}
}
public class SQ_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		
		System.out.println(solution(bridge_length, weight, truck_weights));

	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		
		
		ArrayList<Truck> bridge = new ArrayList();
		ArrayList<Truck> waiting = new ArrayList();
		int bridgeWeight = 0;
		int occupied = 0;
		
		for(int i = 0 ; i < truck_weights.length; i++) {
			waiting.add(new Truck(truck_weights[i], bridge_length));
		}
		
		Truck first = waiting.get(0);
		waiting.remove(0);
		
		bridge.add(first);
		bridgeWeight+=first.weight;
		occupied++;
		answer++;
		System.out.println("Time: " + answer);

		
		while(!bridge.isEmpty()) {
			//shift
			int len = bridge.size();
			for(int i = 0 ; i < len; i++) {
				Truck t = bridge.get(i);
				t.time -= 1;
				bridge.set(i, t);
			}
			Truck last = bridge.get(0);
			if(last.time == 0) {
				bridge.remove(0);
				bridgeWeight -= last.weight;
				occupied--;
			}
			
			if(waiting.size() != 0) {
				Truck wait = waiting.get(0);
				//add
				if(wait.weight + bridgeWeight <= weight && occupied + 1 <= bridge_length) {
					waiting.remove(0);
					bridge.add(wait);
					bridgeWeight += wait.weight;
					occupied++;
				}
				
			}
			answer++;
		}
		
		
		
		return answer;
		
	}
	
	public static void printList(ArrayList<Truck> list) {
		for(Truck t : list) {
			System.out.print(t.weight + " " + t.time  + "  ") ;
		}
		System.out.println();
	}

}
