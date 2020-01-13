import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @auther sofency
 * @date 2020/1/13 16:24
 * @package PACKAGE_NAME
 */
public class TestIterator {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        collection.add("new york");
        collection.add("beijing");
        collection.add("dallas");
        collection.add("madison");

        Iterator<String> iterator = collection.iterator();//设置遍历器
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toUpperCase());
        }
    }

}
