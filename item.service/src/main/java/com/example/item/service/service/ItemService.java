package com.example.item.service.service;

import com.example.item.service.entity.Item;
import com.example.item.service.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import VO.Order;

@Service
@Slf4j
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/")
	public Item saveItem(Item item) {
		log.info("Inside saveItem of ItemController");
		return itemRepository.save(item);
		
	}
	
	public ResponseTemplateVO getItemWithOrder(Long itemId) {
		log.info("Inside getItemWithOrder of ItemService");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Item item = itemRepository.findByItemId(itemId);
		
		Order order = restTemplate.getForObject("http://ORDER-SERVICE/orders/" + item.getOrderId(),Order.class);
		vo.setItem(item);
		vo.setOrder(order);
		
		return vo;
	}
	
	

}
