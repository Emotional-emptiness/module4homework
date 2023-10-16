package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<LongestProject> findLongestProject() {
        List<LongestProject> result = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "/home/kali/IdeaProjects/module4homework/sql/find_longest_project.sql";
            String query = readFileContent(sqlFilePath);

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String projectName = resultSet.getString("PROJECT_NAME");
                int projectDuration = resultSet.getInt("PROJECT_DURATION");
                LongestProject project = new LongestProject(projectName, projectDuration);
                result.add(project);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<MaxProject> findMaxProject() {
        List<MaxProject> result = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "/home/kali/IdeaProjects/module4homework/sql/find_max_project.sql";
            String query = readFileContent(sqlFilePath);

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String projectName = resultSet.getString("PROJECT_NAME");
                int projectCost = resultSet.getInt("PROJECT_COST");
                MaxProject project = new MaxProject(projectName, projectCost);
                result.add(project);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "/home/kali/IdeaProjects/module4homework/sql/find_max_salary_worker.sql";
            String query = readFileContent(sqlFilePath);

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int salary = resultSet.getInt("SALARY");
                MaxSalaryWorker worker = new MaxSalaryWorker(name, salary);
                result.add(worker);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public List<MinProject> findMinProject() {
        List<MinProject> result = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "/home/kali/IdeaProjects/module4homework/sql/find_min_project.sql";
            String query = readFileContent(sqlFilePath);

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String projectName = resultSet.getString("PROJECT_NAME");
                int projectCost = resultSet.getInt("PROJECT_COST");
                MinProject project = new MinProject(projectName, projectCost);
                result.add(project);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        List<YoungestEldestWorkers> result = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "/home/kali/IdeaProjects/module4homework/sql/find_youngest_eldest_workers.sql";
            String query = readFileContent(sqlFilePath);

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int age = resultSet.getInt("AGE");
                YoungestEldestWorkers worker = new YoungestEldestWorkers(name, age);
                result.add(worker);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    public List<BestProject> findBestProject() {
        List<BestProject> result = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "/home/kali/IdeaProjects/module4homework/sql/find_best_project.sql";
            String query = readFileContent(sqlFilePath);

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String projectName = resultSet.getString("PROJECT_NAME");
                double projectRating = resultSet.getDouble("PROJECT_RATING");
                BestProject project = new BestProject(projectName, projectRating);
                result.add(project);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    public List<ProjectPrices> findProjectPrices() {
        List<ProjectPrices> result = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "/home/kali/IdeaProjects/module4homework/sql/print_project_prices.sql";
            String query = readFileContent(sqlFilePath);

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String projectName = resultSet.getString("PROJECT_NAME");
                double projectPrice = resultSet.getDouble("PROJECT_PRICE");
                ProjectPrices project = new ProjectPrices(projectName, projectPrice);
                result.add(project);
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    private String readFileContent(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }
}
