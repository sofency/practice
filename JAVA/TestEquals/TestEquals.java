package TestEquals;

import java.util.Objects;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.TestEquals
 * @Version: 1.0
 */
public class TestEquals {
    public static void main(String[] args){
        Object obj;
        User u1= new User(123,"sofency","1998");
        User u2= new User(123,"sofency","198");
        System.out.println(u1.equals(u2));//重写equal进行判断ID是否相等

    }
}
class User{
    int id;
    String name;
    String pwd;

    //右键User选择生成 选择getter setter
    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);//查询内存位置
    }
}
