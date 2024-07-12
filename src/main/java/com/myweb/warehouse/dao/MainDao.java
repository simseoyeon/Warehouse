package com.myweb.warehouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.myweb.warehouse.dto.DetailDto;
import com.myweb.warehouse.dto.InoutDto;
import com.myweb.warehouse.dto.ProductDto;
import com.myweb.warehouse.dto.SalesDto;

@Mapper
public interface MainDao {
	@Select("select * from tbl_product_01")
	public List<ProductDto> selectProductTbl() throws DataAccessException;
	@Select("select sum(p_incost) from tbl_product_01")
	public int sumIncost() throws DataAccessException;
	@Select("select sum(p_outcost) from tbl_product_01")
	public int sumOutcost() throws DataAccessException;
	@Select("select max(t_no) from tbl_inout_01")
	public String selectLastTno() throws DataAccessException;
	

	
	//@Insert("insert into tbl_inout_01 values (#{t_no}, #{p_code}, #{t_type}, #{t_cnt}, #{t_date}, #{c_code})")
	@Insert("insert into tbl_inout_01 (t_no, p_code, t_type, t_cnt, t_date, c_code) values (#{t_no}, #{p_code}, #{t_type}, #{t_cnt}, #{t_date}, #{c_code})")
	public void insertInoutTbl(InoutDto dto) throws DataAccessException;
	
	@Select("select i.t_no, i.p_code, p.p_name, i.t_type, i.t_cnt, c.c_code, c.c_name, i.t_date "
			+ "from tbl_inout_01 i "
			+ "join tbl_company_01 c on i.c_code = c.c_code "
			+ "join tbl_product_01 p on i.p_code = p.p_code ")
	public List<DetailDto> selectInoutDetail() throws DataAccessException;
	
	@Select("select p.p_code, p.p_name, t.t_cnt, t.t_cnt*(p.p_outcost-p.p_incost) as p_outcost "
			+ "from tbl_product_01 p "
			+ "join "
			+ "(select p_code, sum(t_cnt) t_cnt "
				+ "from tbl_inout_01 where t_type='O'"
				+ "group by p_code) t "
			+ "on p.p_code = t.p_code;")
	public List<SalesDto> selectSales() throws DataAccessException;
	
	@Select("select sum(t_cnt) from tbl_inout_01 where t_type='O'")
	public int sumTotCnt() throws DataAccessException;
	
	@Select("select sum(p_outcost) - sum(p_incost) from tbl_product_01 where t_type='O'")
	public int sumTotOutCost() throws DataAccessException;
}
