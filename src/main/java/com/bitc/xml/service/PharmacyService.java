package com.bitc.xml.service;

import java.util.List;

import com.bitc.xml.dto.PharmacyFullDataItemDto;

public interface PharmacyService {
	List<PharmacyFullDataItemDto> getItemList() throws Exception;
	
}
