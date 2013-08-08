package org.alexis.mon1erMvc.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alexis.mon1erMvc.dao.DirectoryDto;
import org.alexis.mon1erMvc.service.DirectoryService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController {
	Log log = LogFactory.getLog(ImageController.class);
	
	@Resource(name="directoryService")
	DirectoryService directoryService;
	
	@RequestMapping(value="/images", method = RequestMethod.GET)
	public String getImages(Model model) throws Exception {
		return getImages("", model);
	}

	@RequestMapping(value="/images/{url}", method = RequestMethod.GET)
	public String getImages(@PathVariable String url, Model model) throws Exception {		
		log.debug("url : " + url);
		DirectoryDto dir = directoryService.getDirectory(url);
		model.addAttribute("directory", dir);
		return "images";
	}
	
	@RequestMapping(value="/image/{name:.+}", method = RequestMethod.GET, produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_JPEG_VALUE})
	@ResponseBody
	public byte[] getImage(@PathVariable("name") String name, HttpServletResponse response, HttpServletRequest request) throws IOException {
	    return directoryService.getImage(name);
		//return null;
	}

}
