package SpringBootProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBootProject.repository.DetailsRepository;

@Service
public class DetailsService {
	
	@Autowired
	public DetailsRepository detailsRepository;
	
	

}
