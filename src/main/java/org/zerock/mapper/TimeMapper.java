package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	//시간으로 테스트
	@Select("select sysdate from dual")
	String getTime();
}
