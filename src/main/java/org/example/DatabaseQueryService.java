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

    public List<MaxProjectCountClient> findMaxProjectsClient() {
        List<MaxProjectCountClient> result = new ArrayList<>();

        try {

            Connection connection = Database.getInstance().getConnection();


            String sqlFilePath = "/home/kali/IdeaProjects/module4homework/sql/find_max_projects_client.sql";
            String query = readFileContent(sqlFilePath);


            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int projectCount = resultSet.getInt("PROJECT_COUNT");
                MaxProjectCountClient client = new MaxProjectCountClient(name, projectCount);
                result.add(client);
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

