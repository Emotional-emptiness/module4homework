package org.example.models;

public class BestProject {
    private String projectName;
    private double projectRating;

    public BestProject(String projectName, double projectRating) {
        this.projectName = projectName;
        this.projectRating = projectRating;
    }

    public String getProjectName() {
        return projectName;
    }

    public double getProjectRating() {
        return projectRating;
    }
}
