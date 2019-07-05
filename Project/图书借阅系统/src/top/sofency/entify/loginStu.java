package top.sofency.entify;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.entify
 * @Version: 1.0
 */
public class loginStu {
    private String account;
    private String pwd;
    private String identify;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    @Override
    public String toString() {
        return "loginStu{" +
                "account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", identify='" + identify + '\'' +
                '}';
    }

    public loginStu() {
        super();
    }

    public loginStu(String account, String pwd, String identify) {
        super();
        this.account = account;
        this.pwd = pwd;
        this.identify = identify;
    }
}
