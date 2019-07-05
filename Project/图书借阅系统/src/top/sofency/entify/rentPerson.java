package top.sofency.entify;
import java.sql.Date;
/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.entify
 * @Version: 1.0
 */
public class rentPerson {
    private Date rentDate;//借书日期
    private String bookId;//借书编号//主码
    private String identify;//身份编号
    private Date returnDate;//归还日期

    public Date getRentDate() {
        return rentDate;
    }

    public void setRentDate(Date rentDate) {
        this.rentDate = rentDate;
    }

    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public Date getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }


    public rentPerson() {
        super();
    }


    @Override
    public String toString() {
        return "RentPerson [rentDate=" + rentDate + ", bookId=" + bookId + ", identify=" + identify + ", returnDate="
                + returnDate + "]";
    }

    public rentPerson(Date rentDate, String bookId, String identify, Date returnDate) {
        super();
        this.rentDate = rentDate;
        this.bookId = bookId;
        this.identify = identify;
        this.returnDate = returnDate;
    }

}

