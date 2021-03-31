package com.spring.mvc.springweb.board.controller;

import com.spring.mvc.springweb.board.domain.Board;
import com.spring.mvc.springweb.board.domain.ModifyBoard;
import com.spring.mvc.springweb.board.repository.BoardRepository;
import com.spring.mvc.springweb.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Controller
public class BoardController {

    //의존 관계 설정
    private final BoardService boardService;
    private final BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository, BoardService boardService) {
        this.boardRepository = boardRepository;
        this.boardService = boardService;
    }

    //글 작성 화면 요청
    @GetMapping("/board/write")
    public String write() {
        return "board/write";
    }

    //글 작성 처리 요청
    @PostMapping("/board/write")
    public String write(Board article) {

        boardRepository.insertArticle(article);
        return "redirect:/board/list";
    }

    //글 목록 요청
    @GetMapping("/board/list")
    public String list(Model model) {
        model.addAttribute("articles", boardRepository.getArticles());

        return "/board/list";
    }

    //글 상세보기 요청
    @GetMapping("/board/content")
    public String article(int boardNo, Model model) {
        model.addAttribute("article", boardRepository.getContent(boardNo));
        return "board/modify";
    }

    //게시글 삭제 요청
    @GetMapping("/board/delete?boardNo=xxx")
    public String delete(int boardNo, RedirectAttributes ra) {

        boardRepository.deleteArticle(boardNo);
        ra.addFlashAttribute("msg", "delOk");

        return "redirect:/board/list";
    }

    //게시글 수정 처리 요청
    @PostMapping("/board/modify")
    public String modify(ModifyBoard modArticle) {
        Board board = boardRepository.getContent(modArticle.getBoardNo());
        board.setWriter(modArticle.getTitle());
        board.setTitle(modArticle.getTitle());
        board.setContent(modArticle.getContent());
        boardRepository.modifyArticle(board);

        return "redirect:/board/content?boardNo="+modArticle.getBoardNo();
    }

}
