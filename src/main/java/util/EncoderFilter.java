package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(description="한글 인코딩 기능을 구현", urlPatterns = {"/*"})
public class EncoderFilter implements Filter {
	ServletContext context; // 서블릿 
	
	public EncoderFilter() {
		System.out.println("EncoderFilter() 새 생성자 호출됨");
	}
	
	
	/** 필터가 수행될 때 자동 호출되는 초기 메서드 **/
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("utf-8 인코딩 준비 ...");
		context = fConfig.getServletContext();
	}
	
	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 여기서 실제 필터링 
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		// 경로 확인용 코드 
		// 애플리케이션의 컨텍스트 이름 
		// request의 타입은 ServletRequest 타입이기때문에 HttpServletRequest타입으로 형변환 시켜줘야한다
		String content = ((HttpServletRequest)request).getContextPath();
		String path = ((HttpServletRequest)request).getRequestURI();

		
		// 요청에 따른 필터 시작 (처리하기 직전) 
		long begin = System.currentTimeMillis();
		/****/
	
		chain.doFilter(request, response);
		
		
		// 응답에 따른 필터 처리 (처리한 후)
		//long end = System.currentTimeMillis();
		//System.out.println("필터 작업 시간 : " + (end-begin));
	}
	
	/** encoding 소멸 **/
	public void destroy() {
		System.out.println("encoding 소멸됨 ");
	}
	

}

