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
public class SalesDto {
	private String p_code;
	private String p_name;
	private int t_cnt;
	private int tot_cnt;
	private int tot_outcost;
}
