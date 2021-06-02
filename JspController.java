package kr.ac.inha.mvc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.inha.mvc.service.JspService;

//12주차 이론
@Controller //컨트롤러라고 어노테이션 지정. -> 앞으로 컨트롤러 역할하는 거. 
public class JspController {
	
	@Autowired //new한거랑 똑같은 효과
	JspService jspService;
	
	@RequestMapping("/") //클라이언트 요청이 왔을때 이루어져야하므로 어노테이션써줌. 
	public ModelAndView hello() {
		ModelAndView mv= new ModelAndView();//여기서만 쓰는 지역변수 객체 mv만들어줌.
		mv.setViewName("hello");  //jsp파일연결할 거니까 그 연결할 jsp파일이름 넣어줌 (설정할때 .jsp로 해놨기때문에 .jsp안적어줘도됨) 
		return mv; 
	}
	//pom.xml이랑 application.properties 설정 추가! 자동리로드설정. 
	//원래는 수정해도 서버껐다켜야 바뀌는뎅 이 두 설정하면 자동리로드됨. 
	//속성설정하고 파일연결해주는 것만 했음 우린. 
	//그냥 넘겨주지않고 데이터를 가공하거나 데이터를 넘겨주려면 '서비스'가 필요. 
	// 서비스에서 가공하지않는다면 프로그램은 잘 돌아가지만 보통 그렇게는 하지않음. 
	//우리가 하는 건 컨트롤러부터 작성하는 것. 
	//서비스를 작성할 거라고 했는데 어떻게 할까? -> 컨트롤러처럼 서비스도 어노테이션으로 서비스만듦. 
	// 
	
	@RequestMapping("/hello.do")
	public String hellodo() {
		return "hello"; 
		//return "hello world"; 하면 에러페이지뜸 
		//RestController하면 string을 리턴해주면 리턴값이 그대로 client로 넘어가지만
		//그냥 Controller로 string을 리턴해주면 text로 넘어가는 게 아니라 매핑된 파일이 넘어감. 
		//그래서 return을 파일이름이랑 똑같게 하지않으면 에러가 남. 
	}
	

	//12주차 실습 
	@RequestMapping("/gugudan")
	/*
	public String gugudan(int num) { //정수로 입력받음 
		String result="구구단: ";
		for(int i=1;i<=9;i++) {
			result+=num+"*"+i+"="+(num*i)+" ";
		}
		return "gugudan";
	}*/ //이렇게 하면 result값이 전달이 안됨. 값을 gugudan.jsp로 전달해야함. 
	
	//이때 ModelAndView 사용!
	public ModelAndView gugudan(Integer num) { //리턴 타입 모델앤뷰 !! 
		ModelAndView mv=new ModelAndView(); //모델앤뷰객체 생성
		mv.setViewName("gugudan");
		if(num!=null) {
		String result="구구단: ";
		for(int i=1;i<=9;i++) {
			result=result+num+"*"+i+"="+(num*i)+" ";
		}
		//모델앤뷰는 데이터도 넘겨줄 수 있음. 
		//데이터를 넘겨주는 addObject(화면에서 가져올 변수이름, 넘길 값)
		mv.addObject("gugu",result); 
		mv.addObject("title","구구단");
		//이 넘긴 데이터를 화면(뷰=jsp)에서 가져올 때에는 jps파일에서 ${변수이름}을 통해 가져온다. 
		}
		return mv; //모델앤뷰리턴 모델앤뷰를 통해 화면호출
	}
	//http://localhost:8080/gugudan?num=2 이렇게 주소창적으면 2단 나옴. 

	//1~100까지 구하는 코드 
	@RequestMapping("/sum")
	public ModelAndView sum() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("gugudan");
		int sum=0;
		for(int i=1;i<=100;i++) {
			sum+=i;
		}
		mv.addObject("gugu",sum);
		mv.addObject("title","1부터100까지의합");
		return mv;
	}
	//localhost:8080/sum-> 5050출력됨
	//(사용자 요청: sum, gugudan.jsp파일, ${gugu}에 들어있는 값은 1-100의 총합.)
	//같은 gugudan.jsp 페이지를 호출했는데 결과값이 달라짐. 아까랑 지금이랑 gugu에 담겨져있는게 다름(사실html코드도 다름. 수정했으니까)  
	
	//이렇게 mvc로 나누어놓으면 기존페이지 재활용이 편해진다. 
	
	//localhost:8080/gugudan하면 파라미터를 넣지않아서 whitelabel에러페이지뜸
	//예외처리필요. gugudan메서드의 파라미터 타입을 int말고 Integer로 씀 
	//Integer는 int와 다르게 null을 입력받을 수 있기때문에!->근데 에러남 ㅋㅋ (Integer쓰면 파라미터입력안했을때 에러페이지는 안뜨고 빈화면뜸.)
	//if(num!=null){}로 에러처리 위에 해줬음. -> 파라미터입력안하면 에러페이지는 아니고 그냥 빈화면 뜸.
	//그냥 int로 하고 trycatch로 하면? 그래도 애초에 int에 null이 들어갈 수 없어서 오류페이지뜸.=>Integer로 넣어랑
	
	//구구단일 때랑 합일때 웹페이지의 타이틀을 바꾸고싶으면? addObject로 넘겨주고 jsp에서 처리하면됨. ->위에 적었음. 
	
	/*
	//스프링으로 css하기 강의실습자료 board.txt-> 안예쁨 ㅜㅜ 예쁘게 꾸밀거얌! 
	@RequestMapping("/board.do")
	public ModelAndView board() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("title","과목정보");
		mv.setViewName("board"); 
		return mv;
	}
	*/
//파라미터를 받아서 과목정보title을 바꿔주고 싶다
//->원래아는대로 파라미터 String으로 받아서 ?subNm=과목정보1 넣으면 됨. 
//-> 입력안하면 그냥 local~나오고 subNm입력하면 입력한대로 나옴
	
//근데 지금은 그냥 기본 과목정보를 보여주다가 파라미터를 받고싶을때 받아서 보여주고싶을 경우.  
//@RequestParam이라는 어노테이션이 있음. 
//@RequestParam("title")이용->파라미터이름변경:subNm=과목정보넘겨주면 오류남. title=과목정보하면 실행됨.
//옵션값 지정해주는 방법도 있음.
//@RequestParam(value="title")->?title=과목정보하면 실행됨. title2=~하면 오류남.
//@RequestParam(value="title",required=false)
	//->title2=과목정보해도 오류 안남. 대신 결과는 title이 local~로 나옴. 
//@RequestParam(value="title",required=true)->title2하면 에러남. 
//@RequestParam(value="title",required=false,defaultValue="과목정보")
	//->사용자가 값을 안보내줬을 경우 기본적으로 세팅할 값. title2하거나 값안보내줬을때 기본값인 과목정보라고 뜸 
//(@RequestParam(defaultValue="과목") ->일케 하니까 과목 나왔음. 
//@RequestParam(value="title",required=true, defaultValue="과목") 
	//->일케하면 title2해도 과목이라고 뜸. (이거 오류안나넹???) 
	
	@RequestMapping("/board.do")
	public ModelAndView board(@RequestParam(value="title",required=false, defaultValue="과목정보")String subNm) throws Exception {
		 
		ModelAndView mv = new ModelAndView();
		mv.addObject("title",subNm); //어노테이션때문에 주소창에 title이라고 써줘야해도 여긴 subNm그대로
		mv.setViewName("board"); 
		
		//서비스는 어떻게 쓸까? 서비스클래스만들고 호출해서 쓰면 됨. 포함관계로 연결.   
		//여태 화면-컨트롤러 연결하는 법배웠는데 컨트롤러-서비스는 어떻게 해야할까?
		//컨트롤러클래스안에 서비스 선언하고 호출해서 씀. 
		//서비스클래스 ㄱ ㄱ 
		//jspService=new JspService();
		mv.addObject("count",jspService.count()); 
		//페이지 아무리 호출해도 0이됨 왜? new라고 해서! -> 
		//service에서 count를 static으로 선언해주면 잘 됨. 
		//근데 스프링에서는 static을 쓰진않고 jspservice선언할때 @Autowired해줌. -> 맨위
		
		//이거랑 boardcontroller.java가서 한거랑 비교.  
		
		
		//13주차 실습
		List<?> boardList= jspService.boardList();  //서비스의 boardList()를 통해서 데이터를 가져와라! 
		mv.addObject("boardList", boardList);  //화면에 데이터 넘기기
		return mv;
	}
	
	
	// /regSubject.do 등록페이지나오게 
	@RequestMapping("/regSubject.do")
	public ModelAndView regSubject() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("boardDetail"); 
		mv.addObject("title", "과목등록"); 
		return mv;
	}
	
	// /regiitSubject.do 
		@RequestMapping("/regitSubject.do")
		public ModelAndView regitSubject(String id, String subject, String grade, String useYn, String description, String regUser) throws Exception{
			System.out.println(id+subject+grade);
			HashMap<String, String> hashmap=new HashMap<>();  //dto안쓰면 이렇게 hashmap이용해서 가져오기. 
			hashmap.put("id", id);
			hashmap.put("subject", subject);
			hashmap.put("grade", grade);
			hashmap.put("useYn", useYn);
			hashmap.put("description", description);
			hashmap.put("regUser", regUser);
			try { //에러처리해주기!! 
			jspService.regitSubject(hashmap);
			}catch(Exception e) {
				e.printStackTrace();
			}

			return board(""); //얘가 exception throw하니까 이 함수에도 exception throw해주기 
		}
}
