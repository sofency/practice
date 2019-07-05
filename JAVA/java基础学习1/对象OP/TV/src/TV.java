/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: PACKAGE_NAME
 * @Version: 1.0
 */
public class TV {
    int channel=1;//default channel is 1;
    int volumeLevel=1;//default volumeLevel is 1
    boolean on=false;//default TV is off  默认电视是关的

    public TV(){
    }
    public  void turnOn(){
        on = true;
    }
    public void turnOff() {
        on = false;
    }
    public void setChannel(int newChannel){
        if(on&&newChannel>=1&&newChannel<=120)
            channel=newChannel;//输入频道
    }
    public void setVolume(int newVolumeLevel){
        if(on&&newVolumeLevel>=1&&newVolumeLevel<=7)
            volumeLevel=newVolumeLevel;//输入音量
    }
    public void channelUp(){
        if(on&&channel<=120)
            channel++;//向上调台
    }
    public void channelDown(){
        if(on&&channel>0)
            channel--;//向下调台
    }
    public void volumeUp(){
        if(on&&volumeLevel<=7)
            volumeLevel++;
    }
    public void volumeDown(){
        if(on&&volumeLevel>0)
            volumeLevel--;
    }
}
