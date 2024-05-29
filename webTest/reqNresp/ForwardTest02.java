package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forwardTest02.do")
public class ForwardTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// parameter자료 받기
		String userName = request.getParameter("username");
		
		// setAttribute()로 설정한 데이터 받기
		String tel = (String)request.getAttribute("tel");
		int age = (int)request.getAttribute("age");
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>"
				+ "<title>forward 방식 연습</title></head>");
		out.println("<body>");
		out.println("<h3>forward 결과</h3><hr>");
		
		out.println("<table border='1'>");
		out.println("<tr><td>이 름</td>");
		out.println("<td>" + userName + "</td></tr>");
		
		out.println("<tr><td>전화번호</td>");
		out.println("<td>" + tel + "</td></tr>");
		
		out.println("<tr><td>나이</td>");
		out.println("<td>" + age + "</td></tr>");
		
			out.println("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
