package org.alexis.mon1erMvc.service;

import javax.annotation.Resource;

import org.alexis.mon1erMvc.dao.DirectoryDao;
import org.alexis.mon1erMvc.dao.DirectoryDto;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("directoryService")
public class DirectoryServiceImpl implements DirectoryService {

	Log log = LogFactory.getLog(DirectoryServiceImpl.class);

	@Resource(name = "directoryDao")
	DirectoryDao directoryDao;

	@Override
	public DirectoryDto getDirectory(String url) throws Exception {
		log.debug(url);
		
		url = url.replace('-', '/');
		
		if (!url.endsWith("/") && !url.isEmpty()) {
			log.debug("add /");
			url = url.concat("/");
		}

		try {
			return directoryDao.getDirectory(url);
		} catch (Exception e) {
			log.warn(e);
			return directoryDao.getDirectory("");
		}
	}
	
	public byte[] getImage(String name) {
		return directoryDao.getImage(name);
	}
}
