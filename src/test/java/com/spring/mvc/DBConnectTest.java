package com.spring.mvc;

import com.spring.mvc.jdbc.basic.JdbcBasic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBConnectTest {

    @Test
    @DisplayName("데이터베이스 연결에 성공해야 한다.")
    void connect() {

        //db접속 설정 정보 작성
        String userId = "hr";
        String userPw = "hr";
        String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe"; //db 접속 위치
        String driverName = "oracle.jdbc.driver.OracleDriver"; //드라이버 클래스 이름

        try {
            //드라이버 로딩
            Class.forName(driverName);

            //연결 정보 생성 (Connection 객체)
            Connection connection = DriverManager.getConnection(dbUrl, userId, userPw);

            System.out.println("연결 성공!");

        } catch (Exception e) {
            System.out.println("연결 실패!");
            e.printStackTrace();

        }
    }

    @Test
    @DisplayName("주어진 데이터를 jdbc_basic 테이블에 잘 저장해야 한다.")
    void insertTest() {

        JdbcBasic jdbcBasic = new JdbcBasic();

        jdbcBasic.insertData(3, "도레미파솔라시도", "조수미");

    }

    @Test
    @DisplayName("데이터 수정과 삭제가 성공해야 한다.")
    void modifyDeleteTest() {

        //수정 테스트
        JdbcBasic jdbcBasic = new JdbcBasic();
        jdbcBasic.updateData(1, "바꿔", "이정현");

        //삭제 테스트
        jdbcBasic.deleteData(2);

    }

    @Test
    @DisplayName("테스트 데이터 삽입")
    void insertTestDatas() {

        JdbcBasic jdbcBasic = new JdbcBasic();

        for (int i = 1; i <= 10; i++) {
            jdbcBasic.insertData(i, "테스트 내용" + i, "작성자" + i);
        }

    }

    @Test
    @DisplayName("전체 조회에 성공해야 한다")
    void selectAllTest() {

        JdbcBasic jdbcBasic = new JdbcBasic();
        List<String[]> results = jdbcBasic.selectAll();

        System.out.println("================= 조회 결과 ==================");
        for (String[] result : results) {
            System.out.println(Arrays.toString(result));
        }
        System.out.println("============================================");

    }
}

