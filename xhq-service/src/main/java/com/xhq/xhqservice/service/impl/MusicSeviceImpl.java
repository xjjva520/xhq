package com.xhq.xhqservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.xhq.xhqservice.entity.Music;
import com.xhq.xhqservice.repository.solr.IMusicRepository;
import com.xhq.xhqservice.service.IDealDataService;

@Service("musciServiceImpl")
public class MusicSeviceImpl implements IDealDataService<Music>{
    @Autowired
    private IMusicRepository ir;
	
	@Override
	public Music findById(String id,String traceId) {
		return null;
	}

	@Override
	public Music findByName(String name,String traceId) {
		Pageable pageable = new PageRequest(0,10, Direction.DESC, "id");
		String keyWord = name.length() > 0 ? "*" + name + "*" : "*";
		Page<Music> find = ir.find(keyWord,pageable );
		Music music = find.getContent().get(0);
		System.out.println(music);
		return music;
	}

}
