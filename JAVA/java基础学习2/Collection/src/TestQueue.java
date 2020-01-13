import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther sofency
 * @date 2020/1/13 16:59
 * @package 测试队列
 */
public class TestQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("sofency");
        queue.offer("alice");
        queue.offer("textx");
        while(queue.size()>0){
            System.out.print(queue.remove()+" ");//先进先出  获取并删除队列的头元素
        }
    }

}
