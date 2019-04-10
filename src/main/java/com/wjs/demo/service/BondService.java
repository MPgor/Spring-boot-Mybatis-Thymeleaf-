package com.wjs.demo.service;

import java.util.List;

import com.wjs.demo.domain.Bond;

public interface BondService {

	public Integer total();

	public List<Bond> getBonds(Integer start);

	public Integer getTag(Integer id);
	
	public Integer count(String keyword);

	public List<Bond> getKeywordBonds(String keyword, Integer start);

	public Integer fromCount(String fromDate);
	
	public List<Bond> getFromDateBonds(String fromDate, Integer start);

	public Integer toCount(String toDate);
	
	public List<Bond> getToDateBonds(String toDate, Integer start);

	public Integer rangeCount(String fromDate,String toDate);
	
	public List<Bond> getDateRangeBonds(String fromDate, String toDate, Integer start);

	public Integer keyFromCount(String keyword,String fromDate);
	
	public List<Bond> getKeywordFromDateBonds(String keyword, String fromDate, Integer start);

	public Integer keyToCount(String keyword, String toDate);
	
	public List<Bond> getKeywordToDateBonds(String keyword, String toDate, Integer start);

	public Integer keyRangeCount(String keyword, String fromDate,String toDate);
	
	public List<Bond> getKeywordDateRangeBonds(String keyword, String fromDate, String toDate, Integer start);

	public void changeTag(Integer tag,Integer id);
}

