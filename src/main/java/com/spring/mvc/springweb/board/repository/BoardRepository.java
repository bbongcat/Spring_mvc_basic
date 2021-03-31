package com.spring.mvc.springweb.board.repository;

import com.spring.mvc.springweb.board.domain.Board;

import java.util.*;

public interface BoardRepository {

    //게시글 목록 가져오기
    List<Board> getArticles();

    //게시글 등록
    void insertArticle(Board article);

    //게시글 삭제
    void deleteArticle(int boardNo);

    //게시글 내용보기
    Board getContent(int boardNo);

    //게시글 수정
    void modifyArticle(Board article);


}
