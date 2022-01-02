package com.jzmemoryhole.backend.Modules;

public class MemoryMail {
    private String text;
    private String date;
    private String Img;// 暂时保留，Img存储图片地址

    public MemoryMail(String text, String date) {
        this.text = text;
        this.date = date;
        this.Img = null;
    }

    // 日后解决图片的问题后，再写这个构造方法
    public MemoryMail(String text, String date, String Img) {

    }

    public MemoryMail(){
        
    }

    public String getText() {
        return this.text;
    }

    public String getDate() {
        return this.date;
    }

    public String getImg(){
        return this.Img;
    }
}
