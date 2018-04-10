package com.vermeg.springboot.com.vermeg.springboot.domain;

public class XmlToCsv {
    private int id;
    private String name;
    private String status;
    private float duration;
    public XmlToCsv(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "XmlToCsv{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", duration in seconds=" + duration +
                '}';
    }
}
