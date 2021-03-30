package com.spring.mvc.springweb.score.repository;

import com.spring.mvc.springweb.score.domain.Score;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MemoryScoreRepositoryTest {

    @Test
    void repoTest() {

        ScoreRepository repository = new MemoryScoreRepository();

        Score test1 = new Score();
        test1.setName("김철수");
        test1.setKor(100);
        test1.setEng(99);
        test1.setMath(87);

        Score test2 = new Score();
        test2.setName("김철수");
        test2.setKor(96);
        test2.setEng(100);
        test2.setMath(99);

        repository.insertScore(test1);
        repository.insertScore(test2);

        //전체 조회 테스트
        List<Score> scoreList = repository.selectAllScores();
        System.out.println(scoreList);
        
        //개별 조회 테스트
        System.out.println("=================");
        Score selectOne = repository.selectOne(2);
        System.out.println("selectOne = " + selectOne);

        //삭제 테스트
        repository.deleteScore(1);
        Score delOne = repository.selectOne(1);
        System.out.println("delOne = " + delOne);


    }

}