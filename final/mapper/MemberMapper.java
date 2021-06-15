package kr.ac.inha.mapper;

import java.util.HashMap;

public interface MemberMapper {

	public int processAddMember(HashMap<String, String> hashmap)throws Exception;
	public int processUpdateMember(HashMap<String, String> hashmap) throws Exception;
	public HashMap<String, String> getMember(String id) throws Exception;
}
