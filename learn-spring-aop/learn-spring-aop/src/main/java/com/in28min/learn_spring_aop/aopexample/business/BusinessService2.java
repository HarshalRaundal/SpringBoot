package com.in28min.learn_spring_aop.aopexample.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.in28min.learn_spring_aop.aopexample.data.DataService2;

@Service
public class BusinessService2 {

	private DataService2 dataService2;

	public BusinessService2(DataService2 dataService2) {
		this.dataService2 = dataService2;
	}

	public int calculateMin() {
		int[] data = dataService2.retrieveData();
//		throw new RuntimeException("Throw runtime exception");
		return Arrays.stream(data).min().orElse(0);
	}
	// business logic
	// Data

}
