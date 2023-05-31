package com.cmn.service;

import java.util.List;

public interface GoodsService {
	List<GoodsVO> selectGoodsList(GoodsVO goodsvo);

	List<TreeVO> selectCGoodsList();

	int registGoods(GoodsVO goodsVo);

	int editGoods(GoodsVO goodsVo);

	int deleteGoods(String string);

	CodeVO regiCategory(GoodsVO goodsVo);
}
