package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//클라이언트가 보내온 자료 받기
		//형식) Request객체.getParameter("파라미터명")
		//		==> 해당 '파라미터명'에 설정된 '파라미터값'을 가져온다.
		//		==> 가져오는 '파라미터값'의 자료형은 'String'이다.
		String userName = request.getParameter("username");
		String job = request.getParameter("job");
		
		//형식) Request객체.getParameterValues("파라미터명")
		// 		==> 파라미터명이 같은 것이 여러 개일 경우에 사용한다.
		//		==> 가져오는 '파라미터값'의 자료형은 'String[]'이다.
		String[] hobbies = request.getParameterValues("hobby");
		
		// 처리 결과 출력하기
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>"
				+ "<title>Request객체 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Request 자료 처리 예제</h2>");
		out.println("<table border='1'>");
		out.println("<tr><td>이 름</td>");
		out.println("<td>" + userName + "</td></tr>");
		
		out.println("<tr><td>직 업</td>");
		out.println("<td>" + job + "</td></tr>");
		
		out.println("<tr><td>취 미</td>");
		out.println("<td>");
		for(String hobby : hobbies) {
			out.println(hobby + "<br>");
		}	
			out.println("</td></tr>");
			
			out.println("</table>");
			
			out.println("<br><hr><br>");
			
			out.println("<h2>Request객체의 메서드들...</h2>");
			out.println("<ol>");
			out.println("<li>클라이언트의 IP주소 : " + request.getRemoteAddr() + "</li>");
			out.println("<li>요청 메서드 : " + request.getMethod() + "</li>");
			out.println("<li>ContextPath : " + request.getContextPath() + "</li>");
			out.println("<li>프로토콜 : " + request.getProtocol() + "</li>");
			out.println("<li>URL정보 : " + request.getRequestURL() + "</li>");
			out.println("<li>URI정보 : " + request.getRequestURI() + "</li>");
			out.println("</ol>");
			out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
