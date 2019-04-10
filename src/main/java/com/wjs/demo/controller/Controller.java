package com.wjs.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wjs.demo.domain.Bond;
import com.wjs.demo.service.BondService;

@RestController
@RequestMapping("/bond")
public class Controller {

	@Autowired
	BondService bc;

	@GetMapping("/list")
	public ModelAndView listBond(@RequestParam(name = "pn", required = false, defaultValue = "1") Integer pageNum,
			Bond bond) {
		ModelAndView mav = new ModelAndView("list");

		List<Bond> allBondList = bc.getBonds((pageNum - 1) * 20);
		
		Integer total = bc.total();

		Integer totalPages;
		if (total % 20 == 0) {
			totalPages = total / 20;
		} else {
			totalPages = total / 20 + 1;
		}
		
		mav.addObject("current_page", pageNum);

		mav.addObject("total_pages", totalPages);

		mav.addObject("bond_list", allBondList);

		return mav;
	}
	
	@PostMapping("/mark")
	public Object val(@RequestBody Map<String, Object> reqMap) {
		Map<String,Integer> vals=(Map)reqMap.get("vals");
		for(String id:vals.keySet()) {
			bc.changeTag(vals.get(id), Integer.parseInt(id));
		}
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("msg", "success");
		return result;
	}
}