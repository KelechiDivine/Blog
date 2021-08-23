package com.demonblog.service;

import com.demonblog.exceptions.General_TitleException;
import com.demonblog.model.Title;
import com.demonblog.repository.TitleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor

public class TitleService {
	
	private final TitleRepository titleRepository;
	private final Title title;
	
	@GetMapping
	public List<Title> getAllTiTle(){
		return titleRepository.findAll();
	}
	
	public void createTitle(Title title){
		titleRepository.save(title);
	}
	
	public void deleteTitle(Integer titleId){
		boolean title1 = titleRepository.existsById(titleId);
		
		if (title1 == title.deleteTitle()){
			log.info("Title have been deleted from the database.");
		}
	}
	
	
	public void updateTitle(String titleText, Integer titleId){
		
		Title title1 = titleRepository.findById(titleId).orElseThrow();
		
		if (title1 != null && !Objects.equals(title1.getTitleContentField(), titleText)){
			title1.setTitleContentField(titleText);
		}
		
//		(if (titleText.isEmpty()){
//			throw new General_TitleException("Titl")
//		}
	}
	
}
