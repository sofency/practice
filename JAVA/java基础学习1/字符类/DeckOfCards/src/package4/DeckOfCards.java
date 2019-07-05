package package4;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: package4
 * @Version: 1.0
 */
//刚开始的牌是按顺序放的按照suits的花色进行排的
public class DeckOfCards {
    public static void main(String[] args) {
        int[] deck=new int[52];//数组的定义方式
        String[] suits={"Spades","Hearts","Diamonds","Clubs"};//牌的花色
        String[] ranks={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};//牌的序号
        for (int i = 0; i < deck.length; i++) {
            deck[i]=i;//将牌按照1-52的方式进行标记
        }
        for (int i = 0; i < deck.length; i++) {//随机打算牌的下标号1-52
            int index=(int)(Math.random()*deck.length);
            int temp=deck[i];
            deck[i]=deck[index];
            deck[index]=temp;
        }
        for (int i = 0; i < 4; i++) {//原始的下标x/13的值代表花色  //x%13代表牌号
            String suit=suits[deck[i]/13];
            String rank=ranks[deck[i]%13];
            System.out.println("Card number "+deck[i]+": "+rank+" of "+suit);
        }
    }
}
