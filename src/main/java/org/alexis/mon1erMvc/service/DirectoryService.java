package org.alexis.mon1erMvc.service;

import org.alexis.mon1erMvc.dao.DirectoryDto;

public interface DirectoryService {
	public DirectoryDto getDirectory(String path) throws Exception;

	public byte[] getImage(String name);
}
