package com.virtusa.web;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sanity")
public class sanityController {

	@RequestMapping("/")
	public String sanityCheck() {
		return "this is working, i think maybe? yes!";
	}
}
