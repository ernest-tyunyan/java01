package edu.javaproject.dao;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DBInit {
    public static void startUp() throws Exception {
        URL url1 = DictionaryDaoImlTest.class.getClassLoader().getResource("scratch_1.sql");
        URL url2 = DictionaryDaoImlTest.class.getClassLoader().getResource("scratch.sql");

        List<String> str1 = Files.readAllLines(Paths.get(url1.toURI()));
        String sql1 = str1.stream().collect(Collectors.joining());

        List<String> str2 = Files.readAllLines(Paths.get(url1.toURI()));
        String sql2 = str2.stream().collect(Collectors.joining());

        try (Connection con = ConnectionBuilder.getConnection(); Statement stmt = con.createStatement();) {
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);


        }
    }
}
