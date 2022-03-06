package com.Quartz.timer.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timer")
public class PlaygroundController {

	private PlaygroundService playgroundService;

	@Autowired
	public PlaygroundController(PlaygroundService playgroundService) {
		super();
		this.playgroundService = playgroundService;
	}
	
	@PostMapping("/runhelloworld")
	public void runHelloWorldJob() {
		this.playgroundService.runHelloWorldJob();
	}
	
	
}
