package com.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.common.FileUtil;
import com.web.common.FileVO;
import com.web.common.SearchVO;
import com.web.service.Board8Svc;
import com.web.vo.BoardReplyVO;
import com.web.vo.BoardVO;

@Controller 
public class BoardController {

    @Autowired
    private Board8Svc boardSvc;
    
    /**
     * 리스트.
     */
    @RequestMapping(value = "/boardList")
    public String boardList(SearchVO searchVO, ModelMap modelMap) {
        
        if (searchVO.getBgno() == null) {
            searchVO.setBgno("1"); 
        }
        searchVO.pageCalculate( boardSvc.selectBoardCount(searchVO) ); // startRow, endRow

        List<?> listview  = boardSvc.selectBoardList(searchVO);
        
        modelMap.addAttribute("listview", listview);
        modelMap.addAttribute("searchVO", searchVO);
        
        return "board/BoardList";
    }
    
    /** 
     * 글 쓰기. 
     */
    @RequestMapping(value = "/boardForm")
    public String boardForm(HttpServletRequest request, ModelMap modelMap) {
        String bgno = request.getParameter("bgno");
        String brdno = request.getParameter("brdno");
        if (brdno != null) {
            BoardVO boardInfo = boardSvc.selectBoardOne(brdno);
            List<?> listview = boardSvc.selectBoard8FileList(brdno);
        
            modelMap.addAttribute("boardInfo", boardInfo);
            modelMap.addAttribute("listview", listview);
            bgno = boardInfo.getBgno();
        }
        modelMap.addAttribute("bgno", bgno);
        
        return "board/BoardForm";
    }
    
    /**
     * 글 저장.
     */
    @RequestMapping(value = "/boardSave")
    public String boardSave(HttpServletRequest request, BoardVO boardInfo) {
        String[] fileno = request.getParameterValues("fileno");
        
        FileUtil fs = new FileUtil();
        List<FileVO> filelist = fs.saveAllFiles(boardInfo.getUploadfile());

        boardSvc.insertBoard(boardInfo, filelist, fileno);

        return "redirect:/boardList?bgno=" + boardInfo.getBgno();
    }

    /**
     * 글 읽기.
     */
    @RequestMapping(value = "/boardRead")
    public String board8Read(HttpServletRequest request, ModelMap modelMap) {
        
        String brdno = request.getParameter("brdno");
        
        boardSvc.updateBoard8Read(brdno);
        BoardVO boardInfo = boardSvc.selectBoardOne(brdno);
        List<?> listview = boardSvc.selectBoard8FileList(brdno);
        List<?> replylist = boardSvc.selectBoard8ReplyList(brdno);
        
        modelMap.addAttribute("boardInfo", boardInfo);
        modelMap.addAttribute("listview", listview);
        modelMap.addAttribute("replylist", replylist);
        
        return "board/BoardRead";
    }
    
    /**
     * 글 삭제.
     */
    @RequestMapping(value = "/boardDelete")
    public String boardDelete(HttpServletRequest request) {
        String brdno = request.getParameter("brdno");
        String bgno = request.getParameter("bgno");
        
        boardSvc.deleteBoardOne(brdno);
        
        return "redirect:/boardList?bgno=" + bgno;
    }

    /* ===================================================================== */
    
    /**
     * 댓글 저장.
     */
    @RequestMapping(value = "/boardReplySave")
    public String board8ReplySave(HttpServletRequest request, BoardReplyVO boardReplyInfo, ModelMap modelMap) {
        
        boardSvc.insertBoardReply(boardReplyInfo);

        modelMap.addAttribute("replyInfo", boardReplyInfo);
        
        return "board/BoardReadAjax4Reply";        
    }
    
    /**
     * 댓글 삭제.
     */
    @RequestMapping(value = "/boardReplyDelete")
    public void board8ReplyDelete(HttpServletResponse response, BoardReplyVO boardReplyInfo) {
        
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        
        try {
            if (!boardSvc.deleteBoard8Reply(boardReplyInfo.getReno()) ) {
                response.getWriter().print(mapper.writeValueAsString("Fail"));
            } else {
                response.getWriter().print(mapper.writeValueAsString("OK"));
            }
        } catch (IOException ex) {
            System.out.println("오류: 댓글 삭제에 문제가 발생했습니다.");
        }
    }
   
}
