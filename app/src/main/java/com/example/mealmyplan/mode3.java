package com.example.mealmyplan;

public class mode3 {
    String  name,img,cal,prot,carb,fat,Vitamin;

    public mode3(String name, String img, String cal , String prot, String carb, String fat, String vitamin) {
        this.name = name;
        this.img = img;
        this.cal = cal;
        this.prot = prot;
        this.carb = carb;
        this.fat = fat;
        Vitamin = vitamin;
    }

    public mode3() {


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCal() {
        return cal;
    }

    public void setCal(String cal) {
        this.cal = cal;
    }

    public String getProt() {
        return prot;
    }

    public void setProt(String prot) {
        this.prot = prot;
    }

    public String getCarb() {
        return carb;
    }

    public void setCarb(String carb) {
        this.carb = carb;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getVitamin() {
        return Vitamin;
    }

    public void setVitamin(String vitamin) {
        Vitamin = vitamin;
    }
}