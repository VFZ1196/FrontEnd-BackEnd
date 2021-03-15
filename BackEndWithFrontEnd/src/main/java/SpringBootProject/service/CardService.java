package SpringBootProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringBootProject.repository.CardRepository;
import SpringBootProject.repository.DetailsRepository;

@Service
public class CardService {

	@Autowired
	public CardRepository cardRepository;

	@Autowired
	DetailsRepository detailsRepository;

}
