package com.example.shopaholics;

public class ListActivityModel {
    int productid,productimage;
    String productname,priductprice,productdesc;

    public ListActivityModel() {
    }

    public ListActivityModel(int id, int images, String productname, String priductprice, String productdesc) {
        this.productid = id;
        this.productimage = images;
        this.productname = productname;
        this.priductprice = priductprice;
        this.productdesc = productdesc;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getProductimage() {
        return productimage;
    }

    public void setProductimage(int productimage) {
        this.productimage = productimage;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getPriductprice() {
        return priductprice;
    }

    public void setPriductprice(String priductprice) {
        this.priductprice = priductprice;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }
}
