package kr.or.ddit.reqNresp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forwardTest01.do")
public class ForwardTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 	- forward
		 		특정 JSP문서나 서블릿에 대한 요청을 다른 서블릿이나 JSP로 넘긴다.
		 		(이 때 HttpServletRequest객체와 HttpServletResponse객체를 공유하기 때문에
		 		파라미터를 넘길 수 있다.)
		 		문서가 이동해도 클라이언트의 웹브라우저의 나타나는 주소는 처음 요청할 때의 주소가 바뀌지 않는다.
		 		같은 서버 내부에서만 접근이 가능하다.
		 */
		
		/*
		 	데이터 공유하기
		 	이동되는 페이지로 값을 넘기려면 Request객체의 setAttribute()메서드를 이용하여
		 	데이터를 셋팅하고  받는 쪽에서는  Request객체의 getAttribute()메서드를 이용하여
		 	데이터를 읽어온다.
		 	
		 	보낼 때 형식)  Request객체.setAttribute("key값", 데이터)
		 			==> 'key값'은 문자열로 지정하고, '데이터'는 모든 종류의 데이터가 가능하다.
		 			
		 	받을 때 형식)  Request객체.getAttribute("key값");
		 */
		
		request.setAttribute("tel", "010-8229-7228");
		request.setAttribute("age", 30);
		
		// forward방식으로 문서 이동하기
		
		//Request객체의 getRequestDispatcher()메서드에 이동할 서블릿이나
		//JSP를 지정해 주는데 전체 URI경로 중에서 COntextPath 이후의 경로를 지정해 준다.
		// 예) 이동할 전체 주소가 '/webTest/forwardTest02.do'이면
		//		'/forwardTest02.do'를 지정해 준다.
		RequestDispatcher rd = request.getRequestDispatcher("/forwardTest02.do");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
