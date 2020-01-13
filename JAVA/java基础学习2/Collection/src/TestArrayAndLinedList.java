import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @auther sofency
 * @date 2020/1/13 16:29
 * @package PACKAGE_NAME
 */
public class TestArrayAndLinedList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(1,8);
        list.add(0,9);

        //打印出列表
        System.out.println(list);

        LinkedList<Object> linkedlist = new LinkedList<>(list);

        System.out.println(linkedlist.size());
        linkedlist.add(1,"red");
        linkedlist.removeLast();
        linkedlist.addFirst("green");

        //从前面开始遍历
        ListIterator<Object> iterator = linkedlist.listIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();

        System.out.println("从后面开始遍历");
        iterator = linkedlist.listIterator(linkedlist.size()-1);
        while(iterator.hasPrevious()){
            System.out.print(iterator.previous()+" ");
        }


    }
}
