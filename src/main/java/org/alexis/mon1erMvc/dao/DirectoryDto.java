package org.alexis.mon1erMvc.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class DirectoryDto extends FileDto {

	private Collection<FileDto> files = new ArrayList<FileDto>();
	private Collection<File> subDirectories = new ArrayList<File>();
	private String parent;
	
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public Collection<FileDto> getFiles() {
		return files;
	}
	public void setFiles(Collection<FileDto> files) {
		this.files = files;
	}
	public void addFile(FileDto fileDto) {
		files.add(fileDto);
	}
	public Collection<File> getSubDirectories() {
		return subDirectories;
	}
	public void addSubDirectory(File file) {
		subDirectories.add(file);
	}
}
