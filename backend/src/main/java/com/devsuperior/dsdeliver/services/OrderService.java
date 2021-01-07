package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDto;
import com.devsuperior.dsdeliver.dto.ProductDto;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.repositories.OrderRepository;
import com.devsuperior.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired //injeção de dependência
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDto> findall(){
		List<Order> list = repository.findOrderWithProducts();
		return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
	}
}
