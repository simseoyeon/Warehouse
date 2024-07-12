package com.myweb.warehouse.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InoutDto {
	
	private String t_no;
	private String p_code;
	private String t_type;
	private int t_cnt;
	private String t_date;
	private String c_code;
}
