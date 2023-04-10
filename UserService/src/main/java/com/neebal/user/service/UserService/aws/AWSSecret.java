package com.neebal.user.service.UserService.aws;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AWSSecret {
	private String username	;
	private String password	;
	private String engine	;
	private String host	;
	private String port;
	private String dbname ;
	

}
