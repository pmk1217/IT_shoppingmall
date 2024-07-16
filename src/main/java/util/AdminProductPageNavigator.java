package util;

/**
 * 페이징 네비게이터 함수
 * @since 2020.02.05
 * @author freeflux
 */
public class AdminProductPageNavigator {
	
	/**
	 * 페이징 네비게이터를 만들어주는 함수
	 * @param totalCount	- 총수
	 * @param listCount		- 노출될 목록 게시물 수
	 * @param pagePerBlock	- 노출될 블록 수
	 * @param pageNum		- 페이지 번호
	 * @param searchType	- 검색 항목
	 * @param searchText	- 검색어
	 * @return
	 */
	public String getPageNavigator(int totalCount, int listCount, int pagePerBlock, int pageNum, String searchType, String searchText) {
		StringBuffer sb = new StringBuffer();
		// 대용량일때는 버퍼가 훨씬 속도가 빠름
		// 버퍼에는 뒤에 추가 시키는 append라는 메소드도 있음
		if(totalCount > 0) {
			int totalNumOfPage = (totalCount % listCount == 0) ? 
												totalCount / listCount :
												totalCount / listCount + 1;
			
			int totalNumOfBlock = (totalNumOfPage % pagePerBlock == 0) ?
												totalNumOfPage / pagePerBlock :
												totalNumOfPage / pagePerBlock + 1;
			
			int currentBlock = (pageNum % pagePerBlock == 0) ? 
										pageNum / pagePerBlock :
										pageNum / pagePerBlock + 1;
			
			int startPage = (currentBlock - 1) * pagePerBlock + 1; //첫번째면 1, 두번째면 11, 세번째면 21 연산식
			
			int endPage = startPage + pagePerBlock - 1;
			
			if(endPage > totalNumOfPage){
				endPage = totalNumOfPage;
			}
			
			boolean isNext = false;	// 좌우 화살표 보이는지, 안보이는지
			boolean isPrev = false;
			if(currentBlock < totalNumOfBlock){
				isNext = true;
			}
			
			if(currentBlock > 1){
				isPrev = true;
			}
			
			if(totalNumOfBlock == 1){
				isNext = false;
				isPrev = false;
			}
			
			if(pageNum > 1){
				sb.append("<a href=\"").append("selectAll?pageNum=1&amp;searchType="+searchType+"&amp;searchText="+searchText);
				sb.append("\" title=\"◀◀\">◀◀</a> &nbsp;");
			}
			
			if (isPrev) {
				int goPrevPage = startPage - pagePerBlock;			
				sb.append("&nbsp;<a class=\"page\" href=\"").append("selectAll?pageNum="+goPrevPage+"&amp;searchType="+searchType+"&amp;searchText="+searchText);
				sb.append("\" title=\"◁\">◁</a>");
			} else {
				
			}
			
			for (int i = startPage; i <= endPage; i++) {
				if (i == pageNum) {
					sb.append("<a class=\"page\" id=\"thispage\" href=\"#\"><strong>").append(i).append("</strong></a>");
				} else {
					sb.append("<a class=\"page\" href=\"").append("selectAll?pageNum="+i+"&amp;searchType="+searchType+"&amp;searchText="+searchText);
					sb.append("\" title=\""+i+"\">").append(i).append("</a>");
				}
			}
			
			if (isNext) {
				int goNextPage = startPage + pagePerBlock;
	
				sb.append("<a class=\"page\" href=\"").append("selectAll?pageNum="+goNextPage+"&amp;searchType="+searchType+"&amp;searchText="+searchText);
				sb.append("\" title=\"▷\">▷</a>");
			} else {
				
			}
			
			if(totalNumOfPage > pageNum){
				sb.append("&nbsp; <a href=\"").append("selectAll?pageNum="+totalNumOfPage+"&amp;searchType="+searchType+"&amp;searchText="+searchText);
				sb.append("\" title=\"▶▶\">▶▶</a>");
			}
			
		}
		return sb.toString();
	}
}
