package util;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: com.sofency.entries
 * @Version: 1.0
 */
public class studentBean {

    private String sname;
    private int sage;

    public studentBean() {
    }

    public studentBean(String sname, int sage) {
        this.sname = sname;
        this.sage = sage;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }
}

