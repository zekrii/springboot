package com.vermeg.springboot.com.vermeg.springboot.domain;

public class TableExtracted {
    private int id;
    private String name;
    private String status;
    private long nbrRows;
    private int duration;
    private int size;
    private float rowsPerSecond;
    private float bitesPerSeconds;


    public TableExtracted(){}

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

    public long getNbrRows() {
        return nbrRows;
    }

    public void setNbrRows(long nbrRows) {
        this.nbrRows = nbrRows;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setNbrRows(String int1) {
    }

    public float getRowsPerSecond() {
        return rowsPerSecond;
    }

    public void setRowsPerSecond() {
       float f= (float) this.getNbrRows()/((float)this.getDuration()/1000);
        this.rowsPerSecond = f;
    }

    public float getBitesPerSeconds() {
        return bitesPerSeconds;
    }

    public void setBitesPerSeconds() {
       float f= (float)this.size/((float) this.duration/1000);
        this.bitesPerSeconds = f;
    }

    @Override
    public String toString() {
        return "TableExtracted{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", nbrRows=" + nbrRows +
                ", duration=" + duration +
                ", size=" + size +
                ", rowsPerSecond=" + rowsPerSecond +
                ", bitesPerSeconds=" + bitesPerSeconds +
                '}';
    }
}
