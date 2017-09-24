package com.target.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.target.config.MyRetailException;
import com.target.domain.ProductPrice;
import com.target.dto.ProductInfoDTO;
import com.target.dto.ProductPriceInfoDTO;
import com.target.enums.ErrorEnum;
import com.target.repository.ProductPriceRepository;

@Service
public class ProductInfoService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ProductPriceRepository productPriceRepository;

	@Value("${api.url}")
	private String apiurl;

	public ProductInfoDTO getProductInfo(String productId) throws JSONException, MyRetailException {

		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		productInfoDTO.setId(Long.parseLong(productId));
		productInfoDTO.setName(getProductName(productId));
		productInfoDTO.setCurrent_price(getProductPrice(productId));

		return productInfoDTO;
	}

	private ProductPriceInfoDTO getProductPrice(String productId) {

		ProductPrice productPrice = productPriceRepository.findOne(Long.parseLong(productId));

		ProductPriceInfoDTO productPriceInfoDTO = new ProductPriceInfoDTO();
		productPriceInfoDTO.setValue(productPrice.getPrice());
		productPriceInfoDTO.setCurrency_code(productPrice.getCurrencyCode());
		return productPriceInfoDTO;
	}

	private String getProductName(String productId) throws JSONException, MyRetailException {
		
		String productName = "";
		
		try{

		String finaUrl = apiurl + productId
				+ "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";

		String response = restTemplate.getForObject(finaUrl, String.class);

		

		if (response != null) {

			JSONObject jsonObject = new JSONObject(response);
			if (jsonObject.has("product")) {
				JSONObject productNode = jsonObject.getJSONObject("product");
				if (productNode.has("item")) {
					JSONObject itemNode = productNode.getJSONObject("item");

					if (itemNode.has("product_description")) {
						JSONObject productDescriptionNode = itemNode.getJSONObject("product_description");
						productName = productDescriptionNode.getString("title");
					}
				} else {
					throw new MyRetailException(ErrorEnum.ERR_NO_DATA);
				}
			}

			else {
				throw new MyRetailException(ErrorEnum.ERR_NO_DATA);
			}
		} else {
			throw new MyRetailException(ErrorEnum.ERR_NO_DATA);
		}

		}
		catch(Exception ex){
			throw new MyRetailException(ErrorEnum.ERR_NO_DATA);
			
		}
		return productName;
	}

	public ProductInfoDTO updateProductInfo(ProductInfoDTO productInfoDTO, String productId) throws MyRetailException {

		ProductPrice productPrice = productPriceRepository.findOne(Long.parseLong(productId));
		
		if(productPrice != null){

		productPrice.setPrice(productInfoDTO.getCurrent_price().getValue());
		productPrice.setCurrencyCode(productInfoDTO.getCurrent_price().getCurrency_code());
		productPriceRepository.save(productPrice);
		}
		 else {
				throw new MyRetailException(ErrorEnum.ERR_NO_DATA);
			}

		return productInfoDTO;
	}

}
