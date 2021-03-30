package com.spring.mvc;

import com.spring.mvc.springweb.score.domain.Score;
import org.junit.jupiter.api.Test;

public class LombokTest {

    @Test
    void lombokTest() {

        Score score = new Score();
        score.setKor(100);
        score.getKor();
    }
}
