package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bardao.Bardao;
import com.example.demo.entity.BarItem;

@RestController
public class BarController {
	
	@Autowired
	Bardao bardao;
	
	@RequestMapping("/")
	public String showItem() {
		return "Additem.jsp";
	}
	
	@GetMapping(path="/Baritem")
	public List<BarItem> Baritem() {
		return bardao.findAll();
	}
	
	@GetMapping("/Baritem/{id}")
	public Optional<BarItem> BaritemById(@PathVariable int id) {
		return bardao.findById(id);
	}
	
	@PostMapping(path ="/Baritem" , consumes = {"application/json"})
	public BarItem Postitem(@RequestBody BarItem bitem) {
		bardao.save(bitem);
		return bitem;
	}
	
	@DeleteMapping("/Baritem/{id}")
	public String Delete(@PathVariable int id) {
		bardao.deleteById(id);
		return "Deleted..!!";	
	}
	
	@PutMapping(path ="/Baritem" , consumes = {"application/json"})
	public BarItem update(@RequestBody BarItem bitem) {
		bardao.save(bitem);
		return bitem;
	}
	
	

}
