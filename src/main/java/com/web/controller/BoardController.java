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
import org.springframework.web.bind.annotation.RequestMethod;

import com.web.common.FileUtil;
import com.web.common.FileVO;
import com.web.common.SearchVO;
import com.web.service.BoardService;
import com.web.vo.BoardReplyVO;
import com.web.vo.BoardVO;

/** 
* @packageName : com.web.controller 
* @fileName : BoardController.java 
* @author : WooSin Kim
* @date : 2020.12.01 
* @description : 
* =========================================================== 
* DATE					AUTHOR					NOTE 
* ----------------------------------------------------------- 
* 2020.12.01			WooSin Kim				최초 생성 
*/
@Controller 
public class BoardController {

    @Autowired
    private BoardService boardService;
    
    /** 
    * 리스트
    * @methodName : boardList 
    * @author : WooSin Kim
    * @date : 2020.12.01 
    * @param searchVO
    * @param modelMap
    * @return 
    */
    @RequestMapping(value = "/boardList", method = RequestMethod.GET)
    public String boardList(SearchVO searchVO, ModelMap modelMap) {
        
        if (searchVO.getBgno() == null) {
            searchVO.setBgno("1"); 
        }
        searchVO.pageCalculate( boardService.selectBoardCount(searchVO) ); // startRow, endRow

        List<?> listview  = boardService.selectBoardList(searchVO);
        
        modelMap.addAttribute("listview", listview);
        modelMap.addAttribute("searchVO", searchVO);
        
        return "board/BoardList";
    }
    
    /** 
    * 글 쓰기
    * @methodName : boardForm 
    * @author : WooSin Kim
    * @date : 2020.12.01 
    * @param request
    * @param modelMap
    * @return 
    */
    @RequestMapping(value = "/boardForm", method = RequestMethod.GET)
    public String boardForm(HttpServletRequest request, ModelMap modelMap) {
        String bgno = request.getParameter("bgno");
        String brdno = request.getParameter("brdno");
        if (brdno != null) {
            BoardVO boardInfo = boardService.selectBoardOne(brdno);
            List<?> listview = boardService.selectBoardFileList(brdno);
        
            modelMap.addAttribute("boardInfo", boardInfo);
            modelMap.addAttribute("listview", listview);
            bgno = boardInfo.getBgno();
        }
        modelMap.addAttribute("bgno", bgno);
        
        return "board/BoardForm";
    }
    
    /** 
    * 글 저장
    * @methodName : boardSave 
    * @author : WooSin Kim
    * @date : 2020.12.01 
    * @param request
    * @param boardInfo
    * @return 
    */
    @RequestMapping(value = "/boardSave", method = RequestMethod.GET)
    public String boardSave(HttpServletRequest request, BoardVO boardInfo) {
        String[] fileno = request.getParameterValues("fileno");
        
        FileUtil fs = new FileUtil();
        List<FileVO> filelist = fs.saveAllFiles(boardInfo.getUploadfile());

        boardService.insertBoard(boardInfo, filelist, fileno);

        return "redirect:/boardList?bgno=" + boardInfo.getBgno();
    }

    /** 
    * 글 읽기
    * @methodName : BoardRead 
    * @author : WooSin Kim
    * @date : 2020.12.01 
    * @param request
    * @param modelMap
    * @return 
    */
    @RequestMapping(value = "/boardRead", method = RequestMethod.GET)
    public String BoardRead(HttpServletRequest request, ModelMap modelMap) {
        
        String brdno = request.getParameter("brdno");
        
        boardService.updateBoardRead(brdno);
        BoardVO boardInfo = boardService.selectBoardOne(brdno);
        List<?> listview = boardService.selectBoardFileList(brdno);
        List<?> replylist = boardService.selectBoardReplyList(brdno);
        
        modelMap.addAttribute("boardInfo", boardInfo);
        modelMap.addAttribute("listview", listview);
        modelMap.addAttribute("replylist", replylist);
        
        return "board/BoardRead";
    }
    
    /** 
    * 글 삭제
    * @methodName : boardDelete 
    * @author : WooSin Kim
    * @date : 2020.12.01 
    * @param request
    * @return 
    */
    @RequestMapping(value = "/boardDelete", method = RequestMethod.GET)
    public String boardDelete(HttpServletRequest request) {
        String brdno = request.getParameter("brdno");
        String bgno = request.getParameter("bgno");
        
        boardService.deleteBoardOne(brdno);
        
        return "redirect:/boardList?bgno=" + bgno;
    }

    
    /** 
    * 댓글 저장
    * @methodName : BoardReplySave 
    * @author : WooSin Kim
    * @date : 2020.12.01 
    * @param request
    * @param boardReplyInfo
    * @param modelMap
    * @return 
    */
    @RequestMapping(value = "/boardReplySave", method = RequestMethod.GET)
    public String BoardReplySave(HttpServletRequest request, BoardReplyVO boardReplyInfo, ModelMap modelMap) {
        
        boardService.insertBoardReply(boardReplyInfo);

        modelMap.addAttribute("replyInfo", boardReplyInfo);
        
        return "board/BoardReadAjax4Reply";        
    }
    
    /** 
    * 댓글 삭제
    * @methodName : BoardReplyDelete 
    * @author : WooSin Kim
    * @date : 2020.12.01 
    * @param response
    * @param boardReplyInfo 
    */
    @RequestMapping(value = "/boardReplyDelete", method = RequestMethod.GET)
    public void BoardReplyDelete(HttpServletResponse response, BoardReplyVO boardReplyInfo) {
        
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=UTF-8");
        
        try {
            if (!boardService.deleteBoardReply(boardReplyInfo.getReno()) ) {
                response.getWriter().print(mapper.writeValueAsString("Fail"));
            } else {
                response.getWriter().print(mapper.writeValueAsString("OK"));
            }
        } catch (IOException ex) {
            System.out.println("오류: 댓글 삭제에 문제가 발생했습니다.");
        }
    }
   
}
