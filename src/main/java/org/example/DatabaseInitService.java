package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitService {

    public static void main(String[] args) {

        Connection connection = Database.getInstance().getConnection();

        String sqlFilePath = "/home/kali/IdeaProjects/module4homework/sql/init_db.sql";

        try {

            Statement statement = connection.createStatement();


            BufferedReader reader = new BufferedReader(new FileReader(sqlFilePath));
            String line;
            StringBuilder query = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                query.append(line);
                if (line.endsWith(";")) {

                    statement.execute(query.toString());
                    query.setLength(0);
                }
            }


            reader.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}

