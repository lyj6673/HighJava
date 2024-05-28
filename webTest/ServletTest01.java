package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	서블릿이란 ==> 컨테이너(서블릿 엔진)에 의해 관리되는 자바 기반 웹 컴포넌트로서
 				동적인 웹 컨텐츠 생성을 가능하게 해 준다.
 				
 	실행할 URL주소 ==> http://localhost:80/webTest/servletTest01.do
 	- http : 프로토콜
 	- localhost : 서버의 컴퓨터이름(도메인명) 또는 서버의 IP주소
 	- 80 : 포트번호 (포트번호가 80번일 경우네는 생략 가능하다.)
 	- .webTest : 컨텍스트 패스 (보통은 웹 프로젝트의 이름으로 지정한다.)
 	- .servletTest01.do : 서블릿 요청 URl
 */

// 이 예제는 배포 서술자(web.xml)를 이용해서 실행할 Servlet을 설정하여 처리하는 예제이다.

// Servlet클래스는 HttpServlet클래스를 상속해서 작성한다.
public class ServletTest01 extends HttpServlet {

	
	/*
	 	이 영역에 service()메서드 또는 doGet()메서드나 doPost()메서드를
	 	재정의해서 작성한다.
	 	
	 	doGet()메서드나 doPost()메서드는 service()메서드를 통해서 호출된다.
	 	이 메서드들의 매개변수로 다음과 같이 2개의 객체를 지정해 준다.
	 	- HttpServletRequest객체 => 서비스 요청에 관련된 정보 및 메서드를 관리하는 객체
	 	- HttpServletResponse객체 => 서비스 응답에 관련된 정보 및 메서드를 관리하는 객체
	 */
	
	//doGet()메서드 ==> Get방식의 요청을 처리하는 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8"); //응답 문서의 인코딩 방식 지정
		
		// 응답 문서의 ContentType 지정
		resp.setContentType("text/html; charset=utf-8"); 
		
		//처리한 결과를 응답으로 보내려면 PrintWriter객체를 생성한다.
		// => HttpServletResponse객체의 getWriter()메서드를 이용하여 생성한다.
		PrintWriter out = resp.getWriter();
		
		//처리한 내용을 출력(전송)한다.
		// 방법1) PrintWriter객체의 append()메서드 이용하기
		
		out.append("<html>")
		.append("<head><meta charset='utf-8'>"
				+ "<title>첫번째 서블릿 연습</title></head>")
		.append("<body>")
		.append("<h2 style='text-align:center;'>")
		.append("안녕하세요. 첫번째 Servlet 프로그램입니다..<br>")
		.append("만나서 반갑습니다...</h2>")
		.append("</body>")
		.append("</html>");
		
	}
	//doPost()메서드 ==> POST방식의 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
