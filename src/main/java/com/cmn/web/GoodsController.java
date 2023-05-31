package com.cmn.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cmn.service.CodeVO;
import com.cmn.service.GoodsService;
import com.cmn.service.GoodsVO;
import com.cmn.service.TreeVO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class GoodsController {

	ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private GoodsService goodsService;

	// 상위 코드 데이터 select
	@RequestMapping(value = "/GoodsList.do")
	public List<GoodsVO> GoodsList(GoodsVO goodsVo, @RequestBody String data, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		JsonNode jsonNode = objectMapper.readTree(data);

		goodsVo.setGOODS_CODE(jsonNode.get("GOODS_CODE").asText());
		goodsVo.setGOODS_NAME(jsonNode.get("GOODS_NAME").asText());
		goodsVo.setITEM_CATEGORY(jsonNode.get("ITEM_CATEGORY").asText());
		goodsVo.setSELLING_PRICE(jsonNode.get("SELLING_PRICE").asText());
		goodsVo.setPURCHASE_COSE(jsonNode.get("PURCHASE_COSE").asText());
		goodsVo.setSELLING_PRICE_E(jsonNode.get("SELLING_PRICE_E").asText());
		goodsVo.setPURCHASE_COSE_E(jsonNode.get("PURCHASE_COSE_E").asText());
		goodsVo.setSPEC(jsonNode.get("SPEC").asText());
		goodsVo.setUNIT(jsonNode.get("UNIT").asText());

		List<GoodsVO> goodsList = goodsService.selectGoodsList(goodsVo);

		return goodsList;
	}

	@RequestMapping(value = "/CGoodsList.do")
	public List<TreeVO> CGoodsList(TreeVO treeVo) throws Exception {
		List<TreeVO> goodsList = goodsService.selectCGoodsList();
		return goodsList;
	}

	@RequestMapping(value = "/GoodsRegist.do")
	public int GoodsRegist(CodeVO codeVo, GoodsVO goodsVo, @RequestBody String data) throws Exception {

		JsonNode jsonNode = objectMapper.readTree(data);

		goodsVo.setGOODS_NAME(jsonNode.get("GOODS_NAME").asText());
		goodsVo.setITEM_CATEGORY(jsonNode.get("ITEM_CATEGORY").asText());
		goodsVo.setSELLING_PRICE(jsonNode.get("SELLING_PRICE").asText());
		goodsVo.setPURCHASE_COSE(jsonNode.get("PURCHASE_COSE").asText());
		goodsVo.setSPEC(jsonNode.get("SPEC").asText());
		goodsVo.setUNIT(jsonNode.get("UNIT").asText());
		goodsVo.setREGISTRANT(jsonNode.get("REGISTRANT").asText());
		goodsVo.setMODIFIER(jsonNode.get("MODIFIER").asText());

		CodeVO code = goodsService.regiCategory(goodsVo);

		goodsVo.setCODENUM("PRD_" + code.getCOMMON_CODE().replaceAll("[^0-9]", "") + "_");
		goodsVo.setCODE(code.getCOMMON_CODE());

		int result = goodsService.registGoods(goodsVo);

		return 1;
	}

	@RequestMapping(value = "/GoodsEdit.do")
	public int GoodsEdit(GoodsVO goodsVo, @RequestBody String data) throws Exception {

		System.out.println("GoodsEdit");
		JsonNode jsonNode = objectMapper.readTree(data);

		goodsVo.setGOODS_CODE(jsonNode.get("GOODS_CODE").asText());
		goodsVo.setGOODS_NAME(jsonNode.get("GOODS_NAME").asText());
		goodsVo.setITEM_CATEGORY(jsonNode.get("ITEM_CATEGORY").asText());
		goodsVo.setSELLING_PRICE(jsonNode.get("SELLING_PRICE").asText());
		goodsVo.setPURCHASE_COSE(jsonNode.get("PURCHASE_COSE").asText());
		goodsVo.setSPEC(jsonNode.get("SPEC").asText());
		goodsVo.setUNIT(jsonNode.get("UNIT").asText());
		goodsVo.setMODIFIER(jsonNode.get("MODIFIER").asText());

		int result = goodsService.editGoods(goodsVo);

		return 1;
	}

	@RequestMapping(value = "/GoodsDelete.do")
	public int GoodsDelete(GoodsVO goodsVo, HttpServletRequest request, HttpServletResponse response,
			@RequestBody List<String> data) throws Exception {
		for (int i = 0; data.size() > i; i++) {
			int result = goodsService.deleteGoods(data.get(i));
		}
		return 1;
	}
}
