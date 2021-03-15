package SpringBootProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SpringBootProject.model.CardDetails;
import SpringBootProject.repository.DetailsRepository;
import SpringBootProject.service.DetailsService;

@RestController
public class DetailsController {
	
	@Autowired
	public DetailsRepository detailsRepository;
	
	@Autowired 
	public DetailsService detailsService;
	
	
	@PostMapping("/details")
	public CardDetails add(@RequestBody CardDetails details) {
		return detailsRepository.save(details);
	}
	
	@GetMapping("/details")
	public List<CardDetails> getAll() {
		return detailsRepository.findAll();
	}
	

}
