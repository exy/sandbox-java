package org.alexis.mon1erMvc.dao;


public interface DirectoryDao {

	public DirectoryDto getDirectory(String path) throws Exception;

	public byte[] getImage(String name);

}