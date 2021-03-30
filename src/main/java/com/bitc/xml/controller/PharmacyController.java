package com.bitc.xml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.xml.dto.PharmacyFullDataItemDto;
import com.bitc.xml.service.PharmacyService;

@Controller
public class PharmacyController {
	@Autowired
	private PharmacyService pharmacyService;
	
	@RequestMapping(value="/pharmacy/fullData",method=RequestMethod.GET)
	public ModelAndView pharmacyFullData() throws Exception{
		ModelAndView mv = new ModelAndView("/pharmacy/fullData");

		List<PharmacyFullDataItemDto> itemList = pharmacyService.getItemList();
		
		mv.addObject("pharmacyDatas",itemList);
		
		return mv;
	}
}
