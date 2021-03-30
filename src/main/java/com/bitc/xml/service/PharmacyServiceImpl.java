package com.bitc.xml.service;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import com.bitc.xml.dto.PharmacyFullDataDto;
import com.bitc.xml.dto.PharmacyFullDataItemDto;

@Service
public class PharmacyServiceImpl implements PharmacyService {

	@Override
	public List<PharmacyFullDataItemDto> getItemList() throws Exception {
		
		//Controller에서 만들었던 소스를 Service에 가져오고 거기서는 Service를 사용함.
		//JAXB 라이브러리를 사용하여 xml데이터를 파싱
		JAXBContext jc = JAXBContext.newInstance(PharmacyFullDataDto.class);
		
		//언마샬 사용 준비
		Unmarshaller um = jc.createUnmarshaller();
		
		//실제 xml 데이터 파일을 로드하여 jaxb 라이브러리로 언마샬을 실행 후 대입
		PharmacyFullDataDto fullData = (PharmacyFullDataDto)um.unmarshal(new File("c://java102//pharmacyFullData.xml"));
		
		List<PharmacyFullDataItemDto> itemList = fullData.getBody().getItems().getItemList();
		
		//윗줄의 리스트만드는 방식을 세세하게 해보면 아래와 같다.
		/*
		PharmacyFullDataHeaderDto header = fullData.getHeader();
		PharmacyFullDataBodyDto body = fullData.getBody();
		
		System.out.println("header 정보 : " + header.getResultCode() + "\t" + header.getResultMsg());
		System.out.println("body 정보 : \n전체 데이터 수 : " + body.getTotalCount() + "\n현재 페이지 : " + body.getPageNo() + "\n한 페이지당 출력 수" + body.getNumOfRows());
		
		body의 아이템리스트를 가져와서 items에 저장, items의 getItemList를 사용해서 ItemDto에 리스트 저장
		PharmacyFullDataItemsDto items = body.getItems();
		List<PharmacyFullDataItemDto> itemList = items.getItemList();
		
		
		System.out.println(itemList.get(0).getDutyName());
		System.out.println(itemList.get(0).getDutyAddr());
		*/
		
		
		return itemList;
	}

}
