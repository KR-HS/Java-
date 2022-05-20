package kr.human.guest.vo;

import java.util.List;

public class PagingVO<T> {
	private List<T> list; // 글 목록을 저장할 변수
	
	// 값 4개를 넘겨받는다.
	private int totalCount;  // 데이터의 전체 개수 --- DB에서 읽어온다. 
	private int currentPage; // 현재 페이지 ---- 넘겨받는다.
	private int pageSize;    // 페이지당 글의 개수 ---- 넘겨받는다.
	private int blockSize;   // 페이지 번호 개수 : 넘겨 받는다.
	
	
	// 나머지 값 계산
	private int totalPage;  // 전체 페이지수
	private int startNo;    // 시작 글번호
	private int endNo;      // 끝 글번호
	private int startPage;  // 페이지 시작 번호
	private int endPage;    // 마지막 페이지 번호
	
	//----------------------------------------------
	// 4개 값을 넘겨받는 생성자 생성
	public PagingVO(int totalCount, int currentPage, int pageSize, int blockSize) {
		super();
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		calc(); // 유효성 검사
	}


	private void calc() {
		if(totalCount<0) currentPage=0;
		if(totalCount>0) { // 데이터가 있을때만 계산
			// 넘어온 값의 유효성검사
			if(currentPage<=0) currentPage=1;
			if(pageSize<=1) pageSize=5;
			if(blockSize<=1) blockSize=5;

			// 전체 페이지 = (전체개수-1)/페이지당 글수 +1
			totalPage=(totalCount-1)/pageSize+1;
			
			// 시작번호 = (현재페이지-1) * 페이지당 글수
			startNo = (currentPage-1)*pageSize; // 1페이지 : 0, 2페이지 : 5 , ...
			
			// 끝번호 = 시작번호 + 페이지당 글수 -1
			endNo = startNo + pageSize-1; // 1페이지 : 4 , 2페이지 : 9 , ....
			
			// 마지막 글 번호는 전체 개수를 넘을 수 없다.
			if(endNo>=totalCount) endNo=totalCount-1;
			
			// 시작페이지 번호 = (현재페이지-1)/페이지수 * 페이지수 +1
			startPage = (currentPage-1)/blockSize *blockSize+1;
			
			// 마지막 페이지 번호 = 시작페이지 + 페이지수 -1
			endPage = startPage + blockSize-1;
			
			// 마지막 페이지는 전체 페이지수를 넘을 수 없다.
			if(endPage>totalPage) endPage=totalPage;
		}
	}
	// -------------------------------------
	// 계산한 변수들은 변경되지 않기 때문에 Getter만 만들고
	// 글목록은 아직 저장되지 않았으므로 Getter와 Setter를 모두 만들어준다.

	public List<T> getList() {
		return list;
	}


	public void setList(List<T> list) {
		this.list = list;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public int getBlockSize() {
		return blockSize;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public int getStartNo() {
		return startNo;
	}


	public int getEndNo() {
		return endNo;
	}


	public int getStartPage() {
		return startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	@Override
	public String toString() {
		return "PagingVO [list=" + list + ", totalCount=" + totalCount + ", currentPage=" + currentPage + ", pageSize="
				+ pageSize + ", blockSize=" + blockSize + ", totalPage=" + totalPage + ", startNo=" + startNo
				+ ", endNo=" + endNo + ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}
	
	// 메서드 2개 추가
	//-----------------------------------------------	
	// 상단의 페이지 정보 출력 메서드
	public String getPageInfo() {
		String info = "전체 : "+totalCount+"개";
		// 페이지가 존재하면 페이지수도 출력
		if(totalPage>0) {
			info+="(" + currentPage+"/"+totalPage+"Page)";
		}
		return info;
	}
	
	// 하단의 페이지 번호 출력 메서드
	public String getPageList() {
		String pageList ="";
		if(totalCount>0) {
			// 시작 페이지가 1보다 크면 ◀ 버튼이 있다.
			if(startPage>1) {
				pageList+="<a href='?p="+(startPage-1)+"&s="+pageSize+"&b="+blockSize+"'>◀</a>";
			}
			// 페이지번호 출력
			for(int i=startPage;i<=endPage;i++) {
				if(i==currentPage) { // 현재 페이지는 링크가 없다.
 					pageList+="["+i +"] ";
				}else {
					pageList+="[<a href='?p="+i+"&s="+pageSize+"&b="+blockSize+"'>" + i + "</a>]";
				}
			}
			// 마지막 페이지가 전체 페이지보다 적다면 ▶버튼이 있다.
			if(endPage<totalPage) {
				pageList+="<a href='?p="+(endPage+1)+"&s="+pageSize+"&b="+blockSize+"'>▶</a>";
			}
		}		
		return pageList;
	}
}
