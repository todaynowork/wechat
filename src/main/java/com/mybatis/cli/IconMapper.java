package com.mybatis.cli;

import com.mybatis.Icon;
import java.util.List;

public interface IconMapper {

	 List<Icon> selectAllIcons();
	    
	 Icon selectById(Integer id);
	
}