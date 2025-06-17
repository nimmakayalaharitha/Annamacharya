import java.util.*;
public class Priority {
    public static void main(String[] args) {
        // 1. Sort numbers using queue
    	Queue<Integer> q=new LinkedList<Integer>();
		q.add(5);
		q.add(2);
		q.add(8);
		((List<Integer>) q).sort(Comparator.naturalOrder());
		System.out.println("sorted:"+q);

        // 2. Play most fun game first
        PriorityQueue<Game> games = new PriorityQueue<>((a, b) -> b.fun - a.fun);
        games.add(new Game("Chess", 6));
        games.add(new Game("Football", 9));
        games.add(new Game("Coding", 10));
        System.out.println("Play: " + games.poll().name);

        // 3. Urgent tasks first
        PriorityQueue<Task> tasks = new PriorityQueue<>((a, b) -> b.priority - a.priority);
        tasks.add(new Task("Laundry", 1));
        tasks.add(new Task("Project", 5));
        System.out.println("Do: " + tasks.poll().name);

        // 4. Top 2 smallest numbers
        PriorityQueue<Integer> nums = new PriorityQueue<>(Arrays.asList(12, 3, 7, 1, 9));
        System.out.println("Min 2: " + nums.poll() + ", " + nums.poll());

        // 5. Cartoon-style queue
        Queue<String> cartoon = new LinkedList<>(Arrays.asList("Eat 🍕", "Sleep 😴", "Code 💻"));
        System.out.println("Cartoon Queue:");
        cartoon.forEach(task -> System.out.println(" -> " + task));
   }

    static class Game {
        String name; int fun;
        Game(String n, int f) { name = n; fun = f; }
    }

    static class Task {
        String name; int priority;
        Task(String n, int p) { name = n; priority = p; }
    }
}