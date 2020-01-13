import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @auther sofency
 * @date 2020/1/13 17:11
 * @package PACKAGE_NAME
 */
public class TestPriorityQueue {
    //使用自定义的比较器
    static Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    };

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(4);
        queue.add(2);
        while(!queue.isEmpty()) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(cmp);
        queue1.offer(1);
        queue1.offer(4);
        queue1.offer(2);
        while(!queue1.isEmpty()) {
            System.out.print(queue1.remove() + " ");
        }


    }


}
