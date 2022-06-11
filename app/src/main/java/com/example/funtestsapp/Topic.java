package com.example.funtestsapp;

public class Topic {
    public int id=-1;
    public String name;
    public String num;

    @Override
    public String toString(){
        String result="";
        result+="树洞信息编号:"+this.id+"\n";
        result+="树洞信息名称："+this.name+"\n";
        result+="树洞内容："+this.num+"\n";
        return result;
    }
}
