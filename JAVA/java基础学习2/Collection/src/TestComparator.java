import java.io.Serializable;
import java.util.*;

/**
 * @auther sofency
 * @date 2020/1/13 16:42
 * @package PACKAGE_NAME
 */

/**
 * 比较器
 */
class demo implements Comparator<Student>,Serializable{

    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getStuId()>o2.getStuId()){
            return -1;
        }else if(o1.getStuId()==o2.getStuId()){
            return 0;
        }else{
            return 1;
        }
    }
}

/**
 * 测试对象类
 */
class Student {
    private int stuId;
    private String stuName;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Student() {
    }

    public Student(int stuId, String stuName) {
        this.stuId = stuId;
        this.stuName = stuName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}

public class TestComparator{
    public static void main(String[] args) {
        Student stu1 = new Student(1,"sofency");
        Student stu2 = new Student(2,"alice");
        Student stu3 = new Student(3,"ahoj");
        List<Student> list = new ArrayList<>();
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        demo d = new demo();//比较容器类
        Iterator iterator = list.iterator();
        //需求找出比stu2的id小的学生的姓名
        while(iterator.hasNext()){
            Student stu = (Student) iterator.next();
            if(d.compare(stu,stu2)==1){
                System.out.println(stu.getStuName());
            }
        }
    }
}