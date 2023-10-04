import java.util.*;

public class slidingWindow {
    static class pair {
        int value;
        int index;
    }

    static class comp implements Comparator<pair> {
        public int compare (pair a, pair b) {
            return a.value - b.value;
        }
    }

    static class comp1 implements Comparator<pair> {
        public int compare (pair a, pair b) {
            return b.value - a.value;
        }
    }

    public static void main (String argv []) {
        Scanner sliding = new Scanner(System.in);
        int n = sliding.nextInt();
        int k = sliding.nextInt();
        int[] min = new int[n - k + 1];
        int[] max = new int[n - k + 1];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sliding.nextInt();
        }
        PriorityQueue<pair> withinWindow = new PriorityQueue<>(new comp());
        PriorityQueue<pair> withinWindorReverse = new PriorityQueue<>(new comp1());
        for (int i = 0; i < k; i++) {
            pair temp = new pair();
            temp.value = arr[i];
            temp.index = i;
            withinWindow.add(temp);
            withinWindorReverse.add(temp);
        }
        min[0] = withinWindow.peek().value;
        max[0] = withinWindorReverse.peek().value;
        for (int i = 1; i <= n - k; i++) {
            while (withinWindow.peek().index < i) {
                withinWindow.poll();
            }
            while (withinWindorReverse.peek().index < i) withinWindorReverse.poll();
            pair temp = new pair();
            temp.value = arr[i + k - 1];
            temp.index = i + k - 1;
            withinWindow.add(temp);
            withinWindorReverse.add(temp);
            min[i] = withinWindow.peek().value;
            max[i] = withinWindorReverse.peek().value;
        }
        for (int i = 0; i <= n - k; i++) {
            System.out.print(min[i] + " ");
        }
        System.out.println();
        for (int i = 0; i <= n - k; i++) {
            System.out.print(max[i] + " ");
        }
    }
}
