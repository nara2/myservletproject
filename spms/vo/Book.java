package spms.vo;

import java.util.Date;

public class Book {
	protected int		bno;
	protected String	bname;
	protected String	author;
	protected Date		bdate;
	protected int		price;
	protected int		bcount;
	protected int		totalprice;
	protected String 	image;
	
	public int getBno() {
		return bno;
	}
	public Book setBno(int bno) {
		this.bno = bno;
		return this;
	}
	public String getBname() {
		return bname;
	}
	public Book setBname(String bname) {
		this.bname = bname;
		return this;
	}
	public String getAuthor() {
		return author;
	}
	public Book setAuthor(String author) {
		this.author = author;
		return this;
	}
	public Date getBdate() {
		return bdate;
	}
	public Book setBdate(Date bdate) {
		this.bdate = bdate;
		return this;
	}
	public int getPrice() {
		return price;
	}
	public Book setPrice(int price) {
		this.price = price;
		return this;
	}
	public int getBcount() {
		return bcount;
	}
	public Book setBcount(int bcount) {
		this.bcount = bcount;
		return this;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public Book setTotalprice(int totalprice) {
		this.totalprice = totalprice;
		return this;
	}
	public String getImage() {
		return image;
	}
	public Book setImage(String image) {
		this.image = image;
		return this;
	}
	
}
