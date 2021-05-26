package kr.ac.inha.board.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//스프링 프레임워크에서 컨트롤러역할을 한다고 지정해줘야 함. 
//어노테이션 이용 
//레스트컨트롤러라는 역할을 하는 클래스이다! 
@RestController
public class BoardController {
//스프링은 객체생성을 위해 new 안함. 
//서버요청을 받을 때 헬로우월드를 리턴하게끔 해줘야 함. 
	
	//호출되는 위치가 중요 (hello라는 요청을 받을때 실행) 
	@RequestMapping("/hello")
	public String hello() {
		return "hello world!!";
	} 
	//http://localhost:8080/hello-> 위 문구 출력됨
	//우리가 여태 하던 건 메인으로 시작해서 메인으로 끝나는 프로그래밍
	//스프링기반의 웹서버프로그래밍은 사용자 요청을 받아 사용자의 요청이 처리가 되는 프로그래밍
	
	//파라미터를 받아서 파라미터를 출력하는 프로그래밍은 어떻게 할 수 있을까? 

	@RequestMapping("/inha")
	public String inha(String param) {
		return param+"inha.ac.kr";
	} //param안줘서 nullinha.ac.kr이라고 출력됨. 
	
	//파라미터주는 방법 
	//inha뒤에물음표하고 파라미터 적어줌 :  ?param=www. (get방식) 

	//연습문제2
	@RequestMapping("/name")
	public String name(String id) {
		return "당신의 학번은 : "+id;
	}
	//어렵지않아요! 자바프로그래밍하는 건데 규칙에 따라서 하면 돼요 (어노테이션 등)
	
	//맨위에 @RestController라는 선언이 없으면 어떻게 될까? 
	//-> 매핑을 시키지 못함. 실행이 안되진않는데 whitelabel error page뜸
	
	//ctrl+shift+o: 사용하지않는 import 정리해줌
	
	//오늘 요약: 스프링 프레임워크는 mvc패턴 방식으로 동삭. 어노테이션 조심하기
	
	//만약 BoardController2를 만들어서 안에 똑같은 내용을 넣으면 ?=>실행안됨. 
	// hello라는 메소드가 두개라서 뭘 호출해야할지모름-> error.
	//메소드명은 다른 파일에 같은 거 있어도 상관없음. 리퀘스트매핑(~) ~이게 달라야하는 거. 
	
	
	//연습문제3 (과제) 
	
	
}
