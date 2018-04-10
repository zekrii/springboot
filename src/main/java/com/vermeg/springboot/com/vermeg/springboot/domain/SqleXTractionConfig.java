package com.vermeg.springboot.com.vermeg.springboot.domain;

import java.util.Date;

public class SqleXTractionConfig {
    private int id;
    private Date generated;
    private String genarator;
    private String solifeMetadata;
    private String databaseRef;
    private String dataBaseUrl;

    public SqleXTractionConfig() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getGenerated() {
        return generated;
    }

    public void setGenerated(Date generated) {
        this.generated = generated;
    }

    public String getGenarator() {
        return genarator;
    }

    public void setGenarator(String genarator) {
        this.genarator = genarator;
    }

    public String getSolifeMetadata() {
        return solifeMetadata;
    }

    public void setSolifeMetadata(String solifeMetadata) {
        this.solifeMetadata = solifeMetadata;
    }

    public String getDatabaseRef() {
        return databaseRef;
    }

    public void setDatabaseRef(String databaseRef) {
        this.databaseRef = databaseRef;
    }

    public String getDataBaseUrl() {
        return dataBaseUrl;
    }

    public void setDataBaseUrl(String dataBaseUrl) {
        this.dataBaseUrl = dataBaseUrl;
    }

    @Override
    public String toString() {
        return "SqleXTractionConfig{" +
                "id=" + id +
                ", generated=" + generated +
                ", genarator='" + genarator + '\'' +
                ", solifeMetadata='" + solifeMetadata + '\'' +
                ", databaseRef='" + databaseRef + '\'' +
                ", dataBaseUrl='" + dataBaseUrl + '\'' +
                '}';
    }
}
