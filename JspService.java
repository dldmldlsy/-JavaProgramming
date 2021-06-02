package kr.ac.inha.mvc.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.inha.mvc.mapper.jspMapper;

//12주차이론때 만듦. 
@Service // 이 어노테이션을 지정함으로써 얘는 앞으로 서비스가 되는 거.
//dao도 마찬가지로 앞으로 얘는 dao다라는 어노테이션 작성해주면 됨. 
public class JspService {
	// JspController안에 JspService선언했음.
	int count = 0;

	public String count() {
		return count++ + ""; // 페이지호출횟수
	}
	// ->jspController로 가서 count넘겨주기

	// 13주차실습
	// 데이터 리스트형태로 리턴해주는 메서드
	@Autowired
	jspMapper mapper; // mapper선언

	public List<?> boardList() throws Exception {
		return mapper.boardList();
		// 데이터베이스에 접근하는 건 서비스에서 직접접근하는 게 아니라 mapper에서 접근(dao방식도 있지마 ㄴ우리는 매퍼이용)
		// 그래서 우리는 매퍼를 호출해서 매퍼에 있는 boardList를 호출할 거임. ->mapper선언하고 mapper.boardList()를
		// 리턴. -> 매퍼가서 메서드만들기.
	}
	
	public int regitSubject(HashMap<String, String> hashmap) throws Exception {
		return mapper.regitSubject(hashmap);
		
	}
}
