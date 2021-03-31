package com.spring.mvc.springweb.board.repository;

import com.spring.mvc.springweb.board.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryBoardRepository implements BoardRepository {

    //key: 글번호, value: 글 제목
    private static Map<Integer, Board> boardMap = new HashMap<>();

    static {
        boardMap.put(1, new Board("김철수", "안녕하심까", "저는 김철수라고 합니다."));
        boardMap.put(2, new Board("박영희", "반갑습니다", "ㅎㅇ"));
        boardMap.put(3, new Board("고길동", "ㅋ", "ㅋㅋ"));
    }

    //게시글 목록 가져오기
    @Override
    public List<Board> getArticles() {
        List<Board> articles = new ArrayList<>();
        for (int boardNo : boardMap.keySet()) {
            Board board = boardMap.get(boardNo);
            articles.add(board);
        }
        return articles;
    }

    //게시글 등록
    @Override
    public void insertArticle(Board article) {
        boardMap.put(article.getBoardNo(), article);
    }

    //게시글 삭제
    @Override
    public void deleteArticle(int boardNo) {
        boardMap.remove(boardNo);
    }

    //게시글 내용보기
    @Override
    public Board getContent(int boardNo) {
        return boardMap.get(boardNo);
    }

    //게시글 수정
    @Override
    public void modifyArticle(Board article) {
        boardMap.put(article.getBoardNo(), article);
    }
}
