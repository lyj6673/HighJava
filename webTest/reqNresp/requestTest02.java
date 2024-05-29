package kr.or.ddit.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestTest02.do")
public class requestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식으로 전달되는 데이터의 인코딩 방식 설정
		request.setCharacterEncoding("utf-8");

		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		String op = request.getParameter("op");
		double result = 0.0;
		boolean calcOk = true;
		switch(op) {
		case "+" :
			result = num1+num2;
			break;
		case "-" :
			result = num1-num2;
			break;
		case "*" :
			result = num1*num2;
			break;
		case "/" :
			if(num2==0) {
				calcOk =false;
			}else {
				result = num1/(double)num2; break;
			}
			break;
		case "%" :
			if(num2==0) {
				calcOk =false;
			}else {
				result = num1%(double)num2; break;
			}
			break;
			
		}

		// 처리 결과 출력하기
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>"
				+ "<title>Request객체 연습</title></head>");
		out.println("<body>");
		out.println("<hr>");
		out.println("<h2>계산 결과</h2>");
		out.println("<hr>");
		out.println("<p>"+num1+op+num2+" = ");
		if(calcOk) {
			out.println(result);
		}else {
			out.println("계산 불능(0으로 나누기)");
		}
		out.println("</p>");
			out.println("</body></html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
