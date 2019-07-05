/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class TestTv {
    public static void main(String[] args) {
        TV tv=new TV();
        tv.turnOn();//打开电视
        tv.setChannel(30);//在30频道
        tv.volumeLevel = 4;//声音在4

        TV tv1=new TV();
        tv1.turnOn();
       /* tv1.setChannel(30);//在30频道
        tv1.volumeLevel = 4;//声音在4*///没有这两行 会初始化所有的为零
        tv1.channelDown();
        tv1.volumeDown();

        System.out.println("tv's channel is "+tv.channel+" and volume level is "+tv.volumeLevel);
        System.out.println("tv1's channel is "+tv1.channel+" and volume level is "+tv1.volumeLevel);

    }
}
