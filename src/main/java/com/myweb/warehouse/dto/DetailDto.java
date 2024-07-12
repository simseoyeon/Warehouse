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
public class DetailDto {
	private String t_no;
	private String p_code;
	private String p_name;
	private String t_type;
	private int t_cnt;
	private String c_code;
	private String c_name;
	private String t_date;
}
