package com.spring.mvc;

import com.spring.mvc.springweb.score.domain.Score;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LombokTest {

    @Test
    void lombokTest() {

        Score score = new Score();
        score.setKor(100);
        score.getKor();
    }

    @Test
    void connectTest() {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "hr";
        String password = "hr";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("conn = " + conn);

            String sql = "select first_name from employees";
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("first_name");
                System.out.println("name = " + name);
            }


        } catch (Exception e) {

        }

    }
}