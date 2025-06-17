import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {

	public static void main(String[] args) {
		PriorityQueue<Integer> minheap=new PriorityQueue<Integer>();
		minheap.add(20);
		minheap.add(5);
		minheap.add(15);
		minheap.add(10);
		System.out.println("MIN heap output");
		while(!minheap.isEmpty())
		{
			System.out.println(minheap.poll());
		}
		PriorityQueue<Integer> maxheap=new PriorityQueue<Integer>(Collections.reverseOrder());
		maxheap.add(20);
		maxheap.add(5);
		maxheap.add(15);
		maxheap.add(10);
		System.out.println("MAX heap output");
		while(!maxheap.isEmpty())
		{
			System.out.println(maxheap.poll());
		}
	}
}
