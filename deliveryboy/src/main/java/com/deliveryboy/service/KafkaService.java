package com.deliveryboy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.deliveryboy.config.AppConstants;

@Service
public class KafkaService {
	
	Logger logger = LoggerFactory.getLogger(KafkaService.class);
	@Autowired
	private KafkaTemplate<String , String> kaftaTemplate;
	
	public boolean updateLocation(String location) {
		kaftaTemplate.send(AppConstants.LOCATION_TOPIC_NAME,location);
		logger.info("message produced");
		return true;
	}

}
