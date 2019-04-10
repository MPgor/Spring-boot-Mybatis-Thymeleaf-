package com.wjs.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wjs.demo.domain.Bond;
import com.wjs.demo.service.BondService;

@RestController
@RequestMapping("/bond")
public class SearchController {

	@Autowired
	BondService bc;

	@RequestMapping("/search")
	public ModelAndView searchBond(@RequestParam(name = "keyword", required = true) String keyword,
			@RequestParam(name = "fromdate", required = true) String fromDate,
			@RequestParam(name = "todate", required = true) String toDate,
			@RequestParam(name = "pn", required = true, defaultValue = "1") Integer pageNum, Bond bond) {
		ModelAndView mav = new ModelAndView("search");
		
		List<Bond> resultList=null;
		
		int count=0;
		
		if(!keyword.equals("")&&fromDate.equals("")&&toDate.equals("")){
			resultList = bc.getKeywordBonds(keyword, (pageNum - 1) * 20);
			count=bc.count(keyword);
		}else if(!keyword.equals("")&&!fromDate.equals("")&&toDate.equals("")){
			resultList = bc.getKeywordFromDateBonds(keyword, fromDate, (pageNum - 1) * 20);
			count=bc.keyFromCount(keyword, fromDate);
		}else if(!keyword.equals("")&&fromDate.equals("")&&!toDate.equals("")){
			resultList=bc.getKeywordToDateBonds(keyword, toDate, (pageNum - 1) * 20);
			count=bc.keyToCount(keyword, toDate);
		}else if(keyword.equals("")&&!fromDate.equals("")&&toDate.equals("")){
			resultList=bc.getFromDateBonds(fromDate, (pageNum - 1) * 20);
			count=bc.fromCount(fromDate);
		}else if(keyword.equals("")&&!fromDate.equals("")&&!toDate.equals("")){
			resultList=bc.getDateRangeBonds(fromDate, toDate, (pageNum - 1) * 20);
			count=bc.rangeCount(fromDate, toDate);
		}else if(keyword.equals("")&&fromDate.equals("")&&!toDate.equals("")){
			resultList=bc.getToDateBonds(toDate, (pageNum - 1) * 20);
			count=bc.toCount(toDate);
		}else if(!keyword.equals("")&&!fromDate.equals("")&&!toDate.equals("")){
			resultList=bc.getKeywordDateRangeBonds(keyword, fromDate, toDate, (pageNum - 1) * 20);
			count=bc.keyRangeCount(keyword, fromDate, toDate);
		}
		
		if (resultList.isEmpty())
			mav.addObject("note", "没有包含该关键字标题的公告，请重试");

		Integer totalPages;
		if (count % 20 == 0) {
			totalPages = count / 20;
		} else {
			totalPages = count / 20 + 1;
		}

		mav.addObject("keyword", keyword);
		
		mav.addObject("from", fromDate);
		
		mav.addObject("to", toDate);

		mav.addObject("current_page", pageNum);

		mav.addObject("total_pages", totalPages);

		mav.addObject("bond_list", resultList);

		return mav;

	}
	
}
