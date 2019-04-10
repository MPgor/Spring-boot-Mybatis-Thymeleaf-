package com.wjs.demo.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.wjs.demo.annotation.TargetDataSource;
import com.wjs.demo.commons.DataSourceKey;

@Mapper
public interface TagDao {

	@TargetDataSource(dataSourceKey = DataSourceKey.DB_SLAVE1)
	@Select("select id from szse_tag where id=#{id}")
	Integer getTag(Integer id);
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_SLAVE1)
	@Insert("insert into szse_tag (id) values (#{id})")
	void insertTag(Integer id);
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_SLAVE1)
	@Delete("delete from szse_tag where id=#{id}")
	void deleteTag(Integer id);
}
