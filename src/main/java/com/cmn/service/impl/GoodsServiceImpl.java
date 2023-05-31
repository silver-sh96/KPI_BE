package com.cmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cmn.service.CodeVO;
import com.cmn.service.GoodsService;
import com.cmn.service.GoodsVO;
import com.cmn.service.TreeVO;

@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService {

	@Resource(name = "GoodsMapper")
	private GoodsMapper goodsMapper;

	@Override
	public List<GoodsVO> selectGoodsList(GoodsVO goodsVo) {
		return goodsMapper.selectGoodsList(goodsVo);
	}

	@Override
	public List<TreeVO> selectCGoodsList() {
		return goodsMapper.selectCGoodsList();
	}

	@Override
	public int registGoods(GoodsVO goodsVo) {
		return goodsMapper.registGoods(goodsVo);
	}
	@Override
	public int editGoods(GoodsVO goodsVo) {
		return goodsMapper.editGoods(goodsVo);
	}

	@Override
	public CodeVO regiCategory(GoodsVO goodsVo) {
		return goodsMapper.regiCategory(goodsVo);
	}
	
	@Override 
	public int deleteGoods(String string) {
		return goodsMapper.deleteGoods(string);
	}

}
