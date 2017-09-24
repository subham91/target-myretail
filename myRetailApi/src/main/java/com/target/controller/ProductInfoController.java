package com.target.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.target.config.MyRetailException;
import com.target.dto.ProductInfoDTO;
import com.target.service.ProductInfoService;

@RestController
@RequestMapping("/products")
public class ProductInfoController {

	@Autowired
	ProductInfoService productInfoService;

	@GetMapping(value = "/{id}")
	public ProductInfoDTO getProductInfo(@PathVariable(value = "id") String productId)
			throws JSONException, MyRetailException {

		return productInfoService.getProductInfo(productId);
	}

	@PutMapping(value = "/{id}")
	public ProductInfoDTO updateProductInfo(@RequestBody ProductInfoDTO productInfoDTO,
			@PathVariable(value = "id") String productId) throws MyRetailException {

		return productInfoService.updateProductInfo(productInfoDTO, productId);

	}
}
