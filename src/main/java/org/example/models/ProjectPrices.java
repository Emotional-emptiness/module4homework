package org.example.models;

public class ProjectPrices {
    private String projectName;
    private double projectPrice;

    public ProjectPrices(String projectName, double projectPrice) {
        this.projectName = projectName;
        this.projectPrice = projectPrice;
    }

    public String getProjectName() {
        return projectName;
    }

    public double getProjectPrice() {
        return projectPrice;
    }
}
