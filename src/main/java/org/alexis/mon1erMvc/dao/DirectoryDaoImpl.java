package org.alexis.mon1erMvc.dao;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.annotation.processing.FilerException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

@Repository("directoryDao")
public class DirectoryDaoImpl implements DirectoryDao {

	Log log = LogFactory.getLog(DirectoryDaoImpl.class);

	private String rootPath;

	@Override
	public DirectoryDto getDirectory(String url) throws IOException {
		log.debug(rootPath + "/" + url);
		
		String thePath = rootPath + "/" + url;
		
		DirectoryDto directoryDto = new DirectoryDto();
		File directory = new File(thePath);
		File[] listFiles = directory.listFiles();
		if (listFiles != null) {
			for (File file : listFiles) {
				log.debug(url);
				directoryDto.setUrl(url);
				
				if (file.isDirectory()) {
					directoryDto.addSubDirectory(file);
					log.debug("Directory : " + file.getName());
				} else {
					FileDto fileDto = new FileDto();
					fileDto.setFile(file);
					fileDto.setName(file.getName());
					fileDto.setPath(file.getPath());
					fileDto.setUrl(url + "-" + file.getName() );
					directoryDto.addFile(fileDto);
					log.debug("File : " + file.getName());
				}
			}
		}else {
			throw new FilerException("File doesn't exist");
		}
		return directoryDto;
	}

	@Resource(name = "rootPath")
	public void setRootPath(String path) {
		rootPath = path;
	}

	private DirectoryDto getRootDirectory() {
		return null;
	}
	
	public byte[] getImage(String name) {
		String path = rootPath + "/" + name;
		byte[] bytes = null;
		try {
			bytes = IOUtils.toByteArray(FileUtils.openInputStream(new File(path)));
		} catch (IOException e) {
			log.error(e);
		}
		return bytes;
	}
}
