    import java.util.*;
    public class test {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Deque<Integer> deque = new ArrayDeque<>();
            int n = in.nextInt();
            int m = in.nextInt();
            HashSet<Integer> unique = new HashSet<>();
            int max = 0;
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                deque.addLast(num);
                unique.add(num);
                if (deque.size() == m) {
                    max = Math.max(max, unique.size());
                    int first = deque.removeFirst();
                    if (!deque.contains(first)) {
                        unique.remove(first);
                    }
                }
            }
            System.out.println(max);
        }
    }




