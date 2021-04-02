package com.spring.mvc.springweb.board.repository;

import com.spring.mvc.springweb.board.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("memoryBoardRepo")
public class MemoryBoardRepository implements BoardRepository {

    private static Map<Integer, Board> boardMap = new HashMap<>();

    static {
        boardMap.put(1, new Board( "김철수", "안녕하심까", "만나서 반갑"));
        boardMap.put(2, new Board( "박영희", "안녕하세요", "ㅎㅇ"));
        boardMap.put(3, new Board( "고길동", "ㅋㅋ", "ㅋ"));
    }

    @Override
    public List<Board> getArticles() {
        List<Board> articles = new ArrayList<>();
        for (int boardNo : boardMap.keySet()) {
            Board board = boardMap.get(boardNo);
            articles.add(board);
        }
        return articles;
    }

    @Override
    public void insertArticle(Board article) {
        boardMap.put(article.getBoardNo(), article);
    }

    @Override
    public void deleteArticle(int boardNo) {
        boardMap.remove(boardNo);
    }

    @Override
    public Board getContent(int boardNo) {
        return boardMap.get(boardNo);
    }

    @Override
    public void modifyArticle(Board article) {
        boardMap.put(article.getBoardNo(), article);
    }
}