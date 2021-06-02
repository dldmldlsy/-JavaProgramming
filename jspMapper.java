package kr.ac.inha.mvc.mapper;

import java.util.HashMap;
import java.util.List;

public interface jspMapper {
		public List<?> boardList() throws Exception ; //이름만 생성. 예외처리해줌. 데이
		public int regitSubject(HashMap<String, String> hashmap) throws Exception;
}
