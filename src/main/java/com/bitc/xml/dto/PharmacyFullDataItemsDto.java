package com.bitc.xml.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="items")
public class PharmacyFullDataItemsDto {
	//xml파일에 보면 item element가 여러개 있기 때문에 리스트로 만들어야함
	private List<PharmacyFullDataItemDto> itemList;
	
	@XmlElement(name="item")
	public List<PharmacyFullDataItemDto> getItemList() {
		return itemList;
	}

	public void setItemList(List<PharmacyFullDataItemDto> itemList) {
		this.itemList = itemList;
	}
	
	
}
