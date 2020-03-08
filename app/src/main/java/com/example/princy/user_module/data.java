package com.example.princy.user_module;

public class data {
    private String product, images, images1,images2,quantity,catgory,subcat;
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
    public String getImages1() {
        return images1;
    }

    public void setImages1(String images1) {
        this.images1 = images1;
    }
    public String getImages2() {
        return images2;
    }

    public void setImages2(String images2) {
        this.images2 = images2;
    }
    public String getquantity(){
        return quantity;
    }

    public void setquantity(String quantity) {
        this.quantity = quantity;
    }

//    public String getCatgory() {
//        return product;
//    }
//
//    public void setCatgory(String catgory) {
//        this.catgory = catgory;
//    }
//
//    public String getSubcat() {
//        return product;
//    }
//
//    public void setSubcat(String subcat) {
//        this.subcat = subcat;
//    }
//




    public data(String product, String images, String images1,String images2,String quantity ) {
        this.product = product;
        this.quantity = quantity;
        this.images1 = images1;
        this.images = images;
        this.images2 = images2;
        this.subcat = subcat ;
        this.catgory = catgory ;
    }


}
