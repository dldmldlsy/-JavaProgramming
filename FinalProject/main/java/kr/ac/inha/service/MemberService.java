package kr.ac.inha.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.inha.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	MemberMapper mapper;
	public int processUpdateMember(HashMap<String, String> hashmap) throws Exception{
		return mapper.processUpdateMember(hashmap);
	}
	public int deleteMember(String id) throws Exception {
		return mapper.deleteMember(id);
	}
	
	public int processAddMember(HashMap<String, String> hashmap) throws Exception {
		return mapper.processAddMember(hashmap);
	}
	
	public HashMap<String, String> getMember(String id) throws Exception{
		return mapper.getMember(id);
	}
	
	
	
	
}
