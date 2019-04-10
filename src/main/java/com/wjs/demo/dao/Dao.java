package com.wjs.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.wjs.demo.annotation.TargetDataSource;
import com.wjs.demo.commons.DataSourceKey;
import com.wjs.demo.domain.Bond;

@Mapper
public interface Dao {
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select count(*) from szse_bond")
	Integer total();
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select * from szse_bond limit #{start},20")
	List<Bond> getBonds(Integer start);

	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select count(*) from szse_bond where title like #{keyword}")
	Integer count(String keyword);
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select * from szse_bond where title like #{keyword} limit #{start},20")
	List<Bond> getKeywordBonds(String keyword,Integer start);
	
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select count(*) from szse_bond where publish_time>=#{fromDate}")
	Integer fromCount(String fromDate);
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select * from szse_bond where publish_time>=#{fromDate} limit #{start},20")
	List<Bond> getFromDateBonds(String fromDate,Integer start);
	
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select count(*) from szse_bond where publish_time<=#{toDate}")
	Integer toCount(String toDate);
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select * from szse_bond where publish_time<=#{toDate} limit #{start},20")
	List<Bond> getToDateBonds(String toDate,Integer start);
	
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select count(*) from szse_bond where publish_time>=#{fromDate} and publish_time<=#{toDate}")
	Integer rangeCount(String fromDate,String toDate);
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select * from szse_bond where publish_time>=#{fromDate} and publish_time<=#{toDate} limit #{start},20")
	List<Bond> getDateRangeBonds(String fromDate,String toDate,Integer start);
	
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select count(*) from szse_bond where title like #{keyword} and publish_time>=#{fromDate}")
	Integer keyFromCount(String keyword,String fromDate);
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select * from szse_bond where title like #{keyword} and publish_time>=#{fromDate} limit #{start},20")
	List<Bond> getKeywordFromDateBonds(String keyword,String fromDate,Integer start);
	
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select count(*) from szse_bond where title like #{keyword} and publish_time<=#{toDate}")
	Integer keyToCount(String keyword, String toDate);
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select * from szse_bond where title like #{keyword} and publish_time<=#{toDate} limit #{start},20")
	List<Bond> getKeywordToDateBonds(String keyword, String toDate, Integer start);
	
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select count(*) from szse_bond where title like #{keyword} and publish_time>=#{fromDate} and publish_time<=#{toDate}")
	Integer keyRangeCount(String keyword, String fromDate,String toDate);
	
	@TargetDataSource(dataSourceKey = DataSourceKey.DB_MASTER)
	@Select("select * from szse_bond where title like #{keyword} and publish_time>=#{fromDate} and publish_time<=#{toDate} limit #{start},20")
	List<Bond> getKeywordDateRangeBonds(String keyword,String fromDate,String toDate,Integer start);
	
}
