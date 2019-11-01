package com.mongblog.web.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongblog.web.board.dao.BoardDAO;

import com.mongblog.web.board.model.BoardVO;
import com.mongblog.web.board.model.ReplyVO;
import com.mongblog.web.common.Pagination;
import com.mongblog.web.common.Search;
import com.mongblog.web.error.controller.NotFoundException;



@Service

public class BoardServiceImpl implements BoardService{



	@Inject

	private BoardDAO boardDAO;

	

	public List<BoardVO> getBoardList(Search search) throws Exception {

		return boardDAO.getBoardList(search);

	}



	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAO.insertBoard(boardVO);

		
	}


	@Transactional
	@Override
	public BoardVO getBoardContent(int bid) throws Exception {
		BoardVO boardVO = new BoardVO();
		boardDAO.updateViewCnt(bid);
	boardVO = boardDAO.getBoardContent(bid);
		
		 
	/*	try{boardVO.setBid(bid);
		boardVO.setCate_cd("111111111111111111111111111111111111111111");
		boardDAO.updateBoard(boardVO);
		}catch(RuntimeException e) {
			throw new NotFoundException();
		}*/
		return boardVO;
	}



	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAO.updateBoard(boardVO);
		
	}



	@Override
	public int getBoardListCnt(Search search) throws Exception {
		return boardDAO.getBoardListCnt(search);
	}

	// ´ñ±Û ¸®½ºÆ®

		@Override

		public List<ReplyVO> getReplyList(int bid) throws Exception {

			return boardDAO.getReplyList(bid);

		}



		@Override

		public int saveReply(ReplyVO replyVO) throws Exception {

			return boardDAO.saveReply(replyVO);

		}



		@Override

		public int updateReply(ReplyVO replyVO) throws Exception {

			return boardDAO.updateReply(replyVO);

		}



		@Override

		public int deleteReply(int rid) throws Exception {

			return boardDAO.deleteReply(rid);

		}



	


}




