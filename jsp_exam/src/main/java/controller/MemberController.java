package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImple;


@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);
    private RequestDispatcher rdp;
    private MemberService msv;
    private int isOk;
    private String destPage;
    
	private String id;
	private String pw;
	private String name;
	private String email;
	private String phone;
	private String regdate;
	private int event;
	private int auth;
	private MemberVO mvo;
	
	HttpSession ses;
	
    public MemberController() {
        msv = new MemberServiceImple();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		
		switch(path) {
		case "login":
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			mvo = new MemberVO(id, pw);
			
			MemberVO loginMvo = msv.login(mvo);
			if(loginMvo != null) {
				ses = request.getSession();
				ses.setAttribute("ses", loginMvo);
			}else {
				request.setAttribute("msg_login", 0);
			}
			destPage ="/";
			break;
			
		case "join":
			destPage ="/member/join.jsp";
			break;
			
		case "joinus":
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			name = request.getParameter("name");
			email = request.getParameter("email");
			phone = request.getParameter("phone");
			event = Integer.parseInt(request.getParameter("event"));
			mvo = new MemberVO(id, pw, name, email, phone, event);
			
			isOk = msv.join(mvo);
			log.info(">>> 회원가입 > "+(isOk>0?"성공":"실패"));
			destPage="/";
			break;
			
		case "logout":
			ses = request.getSession();
			ses.invalidate();
			destPage ="/";
			break;
			
		case "edit":
			id = request.getParameter("id");
			mvo = msv.detail(id);
			request.setAttribute("mvo", mvo);
			destPage="/member/modify.jsp";
			break;
			
		case "modify":
			id = request.getParameter("id");
			pw = request.getParameter("pw");
			email = request.getParameter("email");
			phone = request.getParameter("phone");
			event = Integer.parseInt(request.getParameter("event"));
			mvo = new MemberVO(id, pw, email, phone, event);
			
			isOk = msv.modify(mvo);
			log.info(">>> 회원정보 수정 > "+(isOk>0?"성공":"실패"));
			destPage ="/";
			break;
			
		case "remove":
			id = request.getParameter("id");
			isOk = msv.remove(id);
			log.info(">>> 회원탈퇴 > "+(isOk>0?"성공":"실패"));
			break;
		}
		
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
