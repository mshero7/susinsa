package com.cafe24.susinsa.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cafe24.susinsa.service.FileUploadService;

@RestController("FileUploadAPIController")
@RequestMapping("/api/file")
public class FileUploadController {
	@Autowired
	private FileUploadService fileUploadService;
	
	@PostMapping("/upload")
	public String upload(MultipartFile multipartFile, Model model) {
		System.out.println("1============================================");
		String url = fileUploadService.restore(multipartFile);
		
		return "result";
	}
}