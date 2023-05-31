package com.cmn.service.impl;

import java.util.List;

import com.cmn.service.CodeVO;
import com.cmn.service.GoodsVO;
import com.cmn.service.TreeVO;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("GoodsMapper")
public interface GoodsMapper {
	List<GoodsVO> selectGoodsList(GoodsVO goodsvo);

	List<TreeVO> selectCGoodsList();

	int registGoods(GoodsVO goodsVo);

	int editGoods(GoodsVO goodsVo);

	int deleteGoods(String string);

	CodeVO regiCategory(GoodsVO goodsVo);

}
