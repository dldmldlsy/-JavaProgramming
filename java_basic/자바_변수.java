package week2; //2주차 실습

public class Ex1 {
	int ins; //인스턴스변수(지역변수아님) 
	final static double PI=3.14; //이왕이면 final쓸때static도 같이 쓰쟝 (왠지 공부) 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int radius1;
		
		//int %5;  
		//int a+b;
		//int 1b;// 숫자가 먼저 올 수 없음
		
		int $a;
		int _int; 
		 
	
		
		//키워드는 색깔이 바뀜 
		//char int 
		//키워드 아닌 거는 까만색
		//indjtk
		//키워드인지아닌지 색으로 구분하면돼서 외울필요 x. 
		
		//관례를 반드시 따라주기! (2주차이론강의노트에 있음) 
		int radius2;
		
		//자바에선 sizeof를 통해 알 순 없지만 아래처럼 확인가능
		System.out.println(Integer.BYTES); //Integer: 대문자로 시작하는 걸 보아하니 클래스!
		System.out.println(Short.BYTES); //Short: 대문자로 시작하는 걸 보아하니 클래스!
		System.out.println(Long.BYTES);
		
		//강노에는 없는 내용  (이해가 잘 안감 ㅜ) 
		int radius3=10; //기본 데이터 타입 객체
		Integer r=10; //참조객체
		r=radius3; 
		//원래는 참조객체로 선언된 변수안에에 일반객체가 들어갈 수 없당. 
		//이런 게 되는 건 클래스안에 특수하게 구현되어있기때문임. 
		//일반적으로는 참조객체에 일반객체대입안되는데 데이터타입클래스 (integer, Long)이런 건 됨! 
		
		//그래서 우리는 일반 데이터타입으로 10을 저장할 수도 있고 integer클래스객체로 10을 저장할 수도 있음.
		// 어떤 게 나을까? 두 방법의 차이는 null저장가능여부!
		
		//Integer같은 클래스 안에는 null을 저장할 수 있는데 일반 객체값에는 null을 넣어을 수 없음. 
		//호환이 되지만 null저장가능여부는다름! 클래스타입에만 null을 넣을 수 있다.
		
		//올해 좀 더 깊숙한 내용 다룰려고함~ 
		
		
		//<변수의 초기화>
		
		//매서드안에 선언한 변수를 지역변수, 메서드 밖에 선언하는 변수를 인스턴스변수(???????
		//클래스안에 변수선언!
		//자바는 전역변수를 지원하지않기때문에 클래스 밖에는 변수선언 x, 
		
		//지역변수는 메서드안에서만! 인스턴스 변수는 클래스안에 
		//지역변수는 초기화안하고 호출하면 출력 안됨.
		//인스턴스변수는 똑같이 출력했을때 초기화를 안해서 출력이 안되는 건 아니고 
		// static 메서드는 static변수(클래스변수)만 호출할수있음!
		//위에 static int ins;라고 하면 초기화안해도 출력됨.
		//초기화가 자동으로 됨. 초기화값은 강의노트에 있음! 다 외우기! 차피 다 0 
		
		
		//강의노트 13p작성
		
		int mach;
		int distance;
		mach=340;
		distance=mach*60*60;
		System.out.println("소리가 1시간동안 가는 거리 : "+distance+"m");
		
		double radius;
		double area;
		radius=10.0;
		area=radius*radius*PI; //PI는 위에 클래스변수로 설정해둠 
		System.out.println("반지름이 "+r+"인 원의 넓이 : "+area);
		
		
	}

}
