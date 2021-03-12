package SpringBootProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBootProject.repository.CardRepository;

@Service
public class CardService {
	
	@Autowired
	public CardRepository cardRepository;

}
