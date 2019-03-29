package com.xhq.xhqservice.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="xjj")
public class XhqConfig {
	
	private String dataName;
	
	private String dataPass;

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getDataPass() {
		return dataPass;
	}

	public void setDataPass(String dataPass) {
		this.dataPass = dataPass;
	}

	

}
