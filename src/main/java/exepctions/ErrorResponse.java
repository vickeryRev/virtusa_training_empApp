package exepctions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.Data;

@Data

public class ErrorResponse {

	private HttpStatus stat;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd hh:mm:ss")
	private LocalDateTime timestamp;
	private String message;
	public ErrorResponse(HttpStatus stat, String message) {
		setTime();
		this.stat = stat;
		this.message = message;
	}
	
	public void setTime() {
		timestamp = LocalDateTime.now();
	}
	
	
	
}
