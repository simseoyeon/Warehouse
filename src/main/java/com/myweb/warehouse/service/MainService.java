package com.myweb.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myweb.warehouse.dao.MainDao;
import com.myweb.warehouse.dto.DetailDto;
import com.myweb.warehouse.dto.InoutDto;
import com.myweb.warehouse.dto.ProductDto;
import com.myweb.warehouse.dto.SalesDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MainService {
	private final MainDao dao;
	
	public List<ProductDto> getProduct(){
		return dao.selectProductTbl();
	}
	public int getToIncost() {
		return dao.sumIncost();
	}
	public int getToOutcost() {
		return dao.sumOutcost();
	}
	public String getNextTno() {  //입출고번호 자동입력 -> 마지막 번호 + 1
		String next_no;
		String last_no = dao.selectLastTno();
		next_no = String.valueOf(Integer.parseInt(last_no) + 1);
		return next_no;
 	}
	
	public void putInout(InoutDto dto) {
		dao.insertInoutTbl(dto);
	}


	public List<DetailDto> getInoutDetail(){
		return dao.selectInoutDetail();
	}
	
	public List<SalesDto> getSales(){
		return dao.selectSales();
	}
	
	public int getTotcnt() {
		return dao.sumTotCnt();
	}
	
	public int sumTotOutCost() {
		return dao.sumTotOutCost();
	}
	
	
}