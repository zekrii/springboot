package com.vermeg.springboot.com.vermeg.springboot.domain;

public class DataWhJob {

        private String Id;
        private String nom;
        private String jobId;
        private String extractionBatchJobId;
        private boolean execution;
        private float duration;

    public DataWhJob() {
    }

    public DataWhJob(String id, String nom, String jobId, String extractionBatchJobId, boolean execution, float duration) {

        Id = id;
        this.nom = nom;
        this.jobId = jobId;
        this.extractionBatchJobId = extractionBatchJobId;
        this.execution = execution;
        this.duration = duration;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getExtractionBatchJobId() {
        return extractionBatchJobId;
    }

    public void setExtractionBatchJobId(String extractionBatchJobId) {
        this.extractionBatchJobId = extractionBatchJobId;
    }

    public boolean isExecution() {
        return execution;
    }

    public void setExecution(boolean execution) {
        this.execution = execution;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "DataWhJob{" +
                "Id='" + Id + '\'' +
                ", nom='" + nom + '\'' +
                ", jobId='" + jobId + '\'' +
                ", extractionBatchJobId='" + extractionBatchJobId + '\'' +
                ", execution=" + execution +
                ", duration=" + duration +
                '}';
    }
}
