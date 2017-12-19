package com.zking.entity;

public class Person {
    private String pid;
    private String pname;
    private String page;

    public Person(String pid, String pname, String page) {
        this.pid = pid;
        this.pname = pname;
        this.page = page;
    }

    public Person() {

    }

    @Override
    public String toString() {
        return "Person{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", page='" + page + '\'' +
                '}';
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
