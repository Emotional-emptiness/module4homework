package org.example.services;

import org.example.models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<LongestProject> findLongestProject() {
        return executeQuery("/home/kali/IdeaProjects/module4homework/sql/find_longest_project.sql",
                "PROJECT_NAME", "PROJECT_DURATION", (column1, column2) -> new LongestProject(column1, column2));
    }

    public List<MaxProject> findMaxProject() {
        return executeQuery("/home/kali/IdeaProjects/module4homework/sql/find_max_project.sql",
                "PROJECT_NAME", "PROJECT_COST", (column1, column2) -> new MaxProject(column1, column2));
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        return executeQuery("/home/kali/IdeaProjects/module4homework/sql/find_max_salary_worker.sql",
                "NAME", "SALARY", (column1, column2) -> new MaxSalaryWorker(column1, column2));
    }

    public List<MinProject> findMinProject() {
        return executeQuery("/home/kali/IdeaProjects/module4homework/sql/find_min_project.sql",
                "PROJECT_NAME", "PROJECT_COST", (column1, column2) -> new MinProject(column1, column2));
    }

    public List<YoungestEldestWorkers> findYoungestEldestWorkers() {
        return executeQuery("/home/kali/IdeaProjects/module4homework/sql/find_youngest_eldest_workers.sql",
                "NAME", "AGE", (column1, column2) -> new YoungestEldestWorkers(column1, column2));
    }

    public List<BestProject> findBestProject() {
        return executeQuery("/home/kali/IdeaProjects/module4homework/sql/find_best_project.sql",
                "PROJECT_NAME", "PROJECT_RATING", (column1, column2) -> new BestProject(column1, column2));
    }

    public List<ProjectPrices> findProjectPrices() {
        return executeQuery("/home/kali/IdeaProjects/module4homework/sql/print_project_prices.sql",
                "PROJECT_NAME", "PROJECT_PRICE", (column1, column2) -> new ProjectPrices(column1, column2));
    }

    private <T> List<T> executeQuery(String sqlFilePath, String column1, String column2, ResultSetMapper<T> mapper) {
        List<T> result = new ArrayList<>();

        try {
            Connection connection = Database.getInstance().getConnection();
            String query = readFileContent(sqlFilePath);

            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    T item = mapper.map(resultSet.getString(column1), resultSet.getInt(column2));
                    result.add(item);
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private String readFileContent(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private interface ResultSetMapper<T> {
        T map(String column1, int column2);
    }
}
