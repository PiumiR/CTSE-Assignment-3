package com.example.item.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.item.service.entity.Item;
import com.example.item.service.service.ItemService;

import VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/items")
@Slf4j
public class ItemController {

	@Autowired(required = false)
	private ItemService itemService;
	
	@PostMapping("/")
	public Item saveItem(@RequestBody Item item) {
		log.info("Inside saveItem of itemController");
		return itemService.saveItem(item);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getItemWithOrder(@PathVariable("id") Long itemId) {
		log.info("Inside saveItem of ItemController");
		return itemService.getItemWithOrder(itemId);
	}

}
