package com.wjs.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wjs.demo.dao.Dao;
import com.wjs.demo.dao.TagDao;
import com.wjs.demo.domain.Bond;
import com.wjs.demo.service.BondService;

@Service
public class BondServiceImpl implements BondService {

	@Autowired
	private Dao dao;
	
	@Autowired
	private TagDao tagDao;

	@Override
	public Integer total() {
		Integer total = dao.total();
		return total;
	}

	@Override
	public List<Bond> getBonds(Integer start) {
		List<Bond> bondList = dao.getBonds(start);
		for(Bond b:bondList) {
			b.setMK((getTag(b.getId())));
		}
		return bondList;
	}

	@Override
	public List<Bond> getKeywordBonds(String keyword, Integer start) {
		List<Bond> KeywordBondList = dao.getKeywordBonds("%" + keyword + "%", start);
		for(Bond b:KeywordBondList) {
			b.setMK((getTag(b.getId())));
		}
		return KeywordBondList;
	}

	@Override
	public Integer count(String keyword) {
		Integer count = dao.count("%" + keyword + "%");
		return count;
	}

	@Override
	public List<Bond> getFromDateBonds(String fromDate, Integer start) {
		List<Bond> fromDateBondList = dao.getFromDateBonds(fromDate, start);
		for(Bond b:fromDateBondList) {
			b.setMK((getTag(b.getId())));
		}
		return fromDateBondList;
	}

	@Override
	public List<Bond> getToDateBonds(String toDate, Integer start) {
		List<Bond> toDateBondList = dao.getToDateBonds(toDate, start);
		for(Bond b:toDateBondList) {
			b.setMK((getTag(b.getId())));
		}
		return toDateBondList;
	}

	@Override
	public List<Bond> getDateRangeBonds(String fromDate, String toDate, Integer start) {
		List<Bond> dateRangeBondList = dao.getDateRangeBonds(fromDate, toDate, start);
		for(Bond b:dateRangeBondList) {
			b.setMK((getTag(b.getId())));
		}
		return dateRangeBondList;
	}

	@Override
	public List<Bond> getKeywordDateRangeBonds(String keyword, String fromDate, String toDate, Integer start) {
		List<Bond> keywordDateRangeBondList = dao.getKeywordDateRangeBonds("%" + keyword + "%", fromDate, toDate,
				start);
		for(Bond b:keywordDateRangeBondList) {
			b.setMK((getTag(b.getId())));
		}
		return keywordDateRangeBondList;
	}

	@Override
	public List<Bond> getKeywordFromDateBonds(String keyword, String fromDate, Integer start) {
		List<Bond> keywordFromDateBondList = dao.getKeywordFromDateBonds("%" + keyword + "%", fromDate, start);
		for(Bond b:keywordFromDateBondList) {
			b.setMK((getTag(b.getId())));
		}
		return keywordFromDateBondList;
	}

	@Override
	public List<Bond> getKeywordToDateBonds(String keyword, String toDate, Integer start) {
		List<Bond> keywordToDateBondList = dao.getKeywordToDateBonds("%" + keyword + "%", toDate, start);
		for(Bond b:keywordToDateBondList) {
			b.setMK((getTag(b.getId())));
		}
		return keywordToDateBondList;
	}

	@Override
	public Integer fromCount(String fromDate) {
		Integer fromCount=dao.fromCount(fromDate);
		return fromCount;
	}

	@Override
	public Integer toCount(String toDate) {
		Integer toCount=dao.toCount(toDate);
		return toCount;
	}

	@Override
	public Integer rangeCount(String fromDate, String toDate) {
		Integer rangeCount=dao.rangeCount(fromDate, toDate);
		return rangeCount;
	}

	@Override
	public Integer keyFromCount(String keyword, String fromDate) {
		Integer keyFromCount=dao.keyFromCount("%" + keyword + "%", fromDate);
		return keyFromCount;
	}

	@Override
	public Integer keyToCount(String keyword, String toDate) {
		Integer keyToCount=dao.keyToCount("%" + keyword + "%", toDate);
		return keyToCount;
	}

	@Override
	public Integer keyRangeCount(String keyword, String fromDate, String toDate) {
		Integer keyRangeCount=dao.keyRangeCount("%" + keyword + "%", fromDate, toDate);
		return keyRangeCount;
	}

	@Override
	public Integer getTag(Integer id) {
		if(tagDao.getTag(id)==null)
			return 0;
		else
			return 1;
	}

	@Override
	public void changeTag(Integer tag, Integer id) {
		if(tag==0)
			tagDao.deleteTag(id);
		else
			tagDao.insertTag(id);
		
	}


}

