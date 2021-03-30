package com.spring.mvc.springweb.score.service;

import com.spring.mvc.springweb.score.domain.Score;
import com.spring.mvc.springweb.score.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    private final ScoreRepository scoreRepository;

    @Autowired
    public ScoreService(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    //점수를 저장하기 전에 총점, 평균 계산 처리
    public void insertService(Score score) {
        score.calcTotalAvg();
        scoreRepository.insertScore(score);
    }
}
