package com.spring.mvc.springweb.board.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
@ToString
public class Board {

    private static int sequence; //순차적인 글 번호를 만들어주는 필드
    private int boardNo;    //글번호
    private String writer;  //작성자
    private String title;   //글제목
    private String content; //글내용

    public Board() {
        this.boardNo = ++sequence;
    }

    public Board(String writer, String title, String content) {
        this();
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

}
