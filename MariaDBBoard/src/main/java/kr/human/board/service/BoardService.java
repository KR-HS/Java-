package kr.human.board.service;

import kr.human.board.vo.BoardCommentVO;
import kr.human.board.vo.BoardVO;
import kr.human.board.vo.PagingVO;

public interface BoardService {
	// 1개얻기 -- 내용보기/수정하기/삭제하기
	BoardVO selectByIdx(int idx, boolean isClick); // isClick : 조회수 증가 여부
	// 1페이지 얻기 --- 목록보기
	PagingVO<BoardVO> selectList(int currentPage, int pageSize, int blockSize);
	// 저장 -- 저장하기
	void insert(BoardVO vo);
	// 수정 -- 수정하기
	void update(BoardVO vo);
	// 삭제 -- 삭제하기
	void delete(BoardVO vo);
	
	// 댓글 저장
	void commentInsert(BoardCommentVO vo);
	// 댓글 수정
	void commentUpdate(BoardCommentVO vo);
	// 댓글 삭제
	void commentDelete(BoardCommentVO vo);
}
