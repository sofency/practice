import java.io.Serializable;
import java.util.*;

/**
 * @auther sofency
 * @date 2020/1/13 18:04
 * @package 测试hashset
 */
public class TestSet {

    public static void main(String[] args) {

        System.out.println("测试hashset的方法");
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Parais");
        set.add("new York");
        set.add("new York");//不允许添加重复的元素
        set.add("beijing");
        System.out.println(set);
        for(String s :set){
            System.out.println(s.toUpperCase().hashCode());
        }

        //可已使用Collection 里面的所有方法、
        Set<String> set1= new HashSet<>();
        set1.add("new York");
        set1.add("alice");
        set.addAll(set1);
        System.out.println(set);
        set.retainAll(set1);//保留两个集合共有的元素
        System.out.println(set);

        Set<String> set2 = new LinkedHashSet<>();//维持了有序插入
        set2.add("11");
        set2.add("22");
        set2.remove("22");
        System.out.println(set2);

        TreeSet<Integer> tree = new TreeSet<>();//可以传入比较器
        tree.add(1);
        tree.add(4);
        tree.add(2);
        tree.add(3);
        tree.add(5);
        Iterator iterator = tree.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());//自定义的排序默认是按值的大小进行排序的
        }
        System.out.println(tree.first());//返回列表的第一个值 即最小的数字
        System.out.println(tree.last());//返回列表的最后一个值即最大的值
        System.out.println(tree.lower(3));  //比3小的相邻值的大小
        System.out.println(tree.higher(3));//比3稍微大的相邻值的大小


        TreeSet<Student> treeset = new TreeSet<>(new demo());//比较器
        Student stu1 = new Student(1,"sofency");
        Student stu2 = new Student(4,"alice");
        Student stu3 = new Student(3,"ahoj");
        Student stu4 = new Student(2,"ahoj");
        treeset.add(stu1);
        treeset.add(stu2);
        treeset.add(stu3);
        treeset.add(stu4);
        Iterator iterator1 = treeset.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next().toString());//自定义的排序默认是按值的大小进行排序的
        }
    }
}
