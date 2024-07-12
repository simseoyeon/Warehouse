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
public class ProductDto {
	private String p_code;
	private String p_name;
	private int p_size;
	private int p_incost;
	private int p_outcost;

}
