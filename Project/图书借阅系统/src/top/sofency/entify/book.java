package top.sofency.entify;

/**
 * @Auther :sofency
 * @Date: ${DATA}
 * @Description: top.sofency.entify
 * @Version: 1.0
 */
public class book {
    private String bookId;//书的编号
    private String bookName;//书名
    private String address;//图书存储位置
    private int BookNumber;//同名书的数量
    private int remainNumber;//剩余数量
    private String clarifyString;//书的类型
    private String author;//作者

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public int getRemainNumber() {
        return remainNumber;
    }
    public void setRemainNumber(int remainNumber) {
        this.remainNumber = remainNumber;
    }
    public String getClarifyString() {
        return clarifyString;
    }
    public void setClarifyString(String clarifyString) {
        this.clarifyString = clarifyString;
    }
    public int getBookNumber() {
        return BookNumber;
    }
    public void setBookNumber(int bookNumber) {
        this.BookNumber = bookNumber;
    }


    @Override
    public String toString() {
        return "book [bookId=" + bookId + ", bookName=" + bookName + ", address=" + address + ", BookNumber="
                + BookNumber + ", remainNumber=" + remainNumber + ", clarifyString=" + clarifyString + ", author="
                + author + "]";
    }
    public  book(){//无参构造器

        super();
    }
    public book(String bookId, String bookName, String address, int bookNumber, int remainNumber, String clarifyString,
                String author) {
        super();
        this.bookId = bookId;
        this.bookName = bookName;
        this.address = address;
        setBookNumber(bookNumber);
        this.remainNumber = remainNumber;
        this.clarifyString = clarifyString;
        this.author = author;
    }
}

