package member.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

public class LoginService implements CommandProcess {

  @Override
  public String requestPro(HttpServletRequest request, HttpServletResponse response)
      throws Throwable {
    // 데이터
    /* 아이디속성X 네임속성으로 데이터를 가져온다 */
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");

    // DB
    MemberDAO memberDAO = MemberDAO.getInstance(); // 싱글톤 - 1번 생성해서 계속 사용한다.
    MemberDTO memberDTO = memberDAO.login(id, pwd);// 호출
    //자바는 리턴 값이 2개가 안된다
    
    // 응답
    if (memberDTO == null) {
      return "/member/loginFail.jsp";
    } else {

      // return "/member/loginOk.jsp?name="+name; //get방법

      // 쿠키
     /* Cookie cookie = new Cookie("memName", name); // 쿠키생성(쿠키명, 값)
      cookie.setMaxAge(30*60); // 쿠키적용시간 30분 -> 정보를 30분간만 유지해라
      //setPath()를 지정안해도 시간을 3000으로 늘리니까 된다....??;;;
      cookie.setPath("/"); // - 만약 URL을 /member/ 오 지정하면 member폴더로 쿠키전송해라    요렇게 하면 member폴더로 쿠키를 전송해라 라는의미임  
      response.addCookie(cookie); // 클라이언트로 보내기

      Cookie cookie2 = new Cookie("memId", id); // 쿠키생성(쿠키명, 값)
      cookie2.setMaxAge(30*60); // 쿠키적용시간 30분 -> 정보를 30분간만 유지해라
      cookie2.setPath("/");
      response.addCookie(cookie2); // 클라이언트로 보내기
      */
      //세션
    	HttpSession session = request.getSession(); //세션 생성
		session.setAttribute("memName", memberDTO.getName());
		session.setAttribute("memId", id);
		session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());

		
		//session.setAttribute("memDTO", memberDTO); 이렇게 통으로 해도됨 사용자 마음임
		
		return "/member/loginOk.jsp";
	}
}

}


