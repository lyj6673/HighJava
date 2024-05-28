package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	이 예제는 애노테이션(@WebServlet)을 이용하여 Servlet을 설정하여 처리하는 예제
 	( @WebServlet 애노테이션은 Servlet버전 3.0이상에서 사용할 수 있다.)
 	
 	- @WebServlet 애노테이션의 속성들...
 	1. name : 서블릿 이름을 설정한다. (기본값 : 빈문자열(""))
 	2. urlPatterns : 서블릿의 URL패턴의 목록을 설정한다.	(기본값 : 빈배열({})
 		예) urlPatterns="/url1" 또는 urlPatterns={"/url1"}
 			==> URL패턴이 1개일 경우
 		예) urlPatterns={"/url1", "/url2", ...}
 			==> URL패턴이 2개 이상일 경우
 	3. value : urlPatterns와 같다.
 	4. description : 주석(설명글)을 설정한다.
 */
// @WebServlet("/servletTest02.ddit") // ==> URL패턴만 지정할 경우
@WebServlet(
		description = "애노테이션을 이용한 서블릿",
		urlPatterns = {"/servletTest02.ddit"}
	)
public class ServletTest02 extends HttpServlet {
	
	//doGet()메서드 ==> Get방식의 요청을 처리하는 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		
		//출력용 스트림 객체 생성
		PrintWriter out = resp.getWriter();
		
		//처리한 내용을 출력(전송)한다.
		// 방법2) PrintWriter객체의 print(), println(), printf()를 이용한다.
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>"
				+ "<title>두번째 Servlet연습</title></head>");
		out.println("<body>");
		out.println("<h2 style='text-align:center; color:red;'>");
		out.println("두번쨰 Servlet예제입니다. <br>");
		out.println("@WebServlet애노테이션을 이용한 예제입니다.<br>");
		out.println("ContentextPath >> "+req.getContextPath()+"</h2>");
		out.println("</body></html>");
	}
	
	//doPost()메서드 ==> POST방식의 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
