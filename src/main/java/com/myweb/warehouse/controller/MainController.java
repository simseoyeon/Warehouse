package com.myweb.warehouse.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myweb.warehouse.dto.DetailDto;
import com.myweb.warehouse.dto.InoutDto;
import com.myweb.warehouse.dto.ProductDto;
import com.myweb.warehouse.dto.SalesDto;
import com.myweb.warehouse.service.MainService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	private final MainService service;
	
	
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	//제품 조회
	@GetMapping("/product") //제품조회
	public String productPage(Model model) {
		//DB검색
		List<ProductDto> list = service.getProduct();
		int tot_incost = service.getToIncost();
		int tot_outcost = service.getToOutcost();
		model.addAttribute("list", list);
		//제품 조회의 매입단가와 출고단가 합계
		model.addAttribute("tot_incost", tot_incost);
		model.addAttribute("tot_outcost", tot_outcost);
		return "product";
	}
	
	
	//입출고 등록
	@GetMapping("/inout")
	public String inoutPage(Model model) {
		String nextno = service.getNextTno();
		model.addAttribute("nextno", nextno);
		return "inout";
	}
	
	@PostMapping("/regist")
	public String registInout(InoutDto dto) {
		service.putInout(dto);
		return "index";
	}
	
	//입출고내역조회
	@GetMapping("/detail")
	public String detailPage(Model model) {
		List<DetailDto> list = service.getInoutDetail();
		model.addAttribute("list", list);
		return "detail";
	}
	
	
	@GetMapping("/sales") //출고매출이익
	public String salesPage(Model model) {
		List<SalesDto> list = service.getSales();
		int tot_cnt = service.getTotcnt();
		int tot_outcost = service.sumTotOutCost() * tot_cnt;
		model.addAttribute("list", list);
		//제품 조회의 매입단가와 출고단가 합계
		model.addAttribute("tot_cnt", tot_cnt);
		model.addAttribute("tot_outcost", tot_outcost);
		return "sales";
	}
	
}
