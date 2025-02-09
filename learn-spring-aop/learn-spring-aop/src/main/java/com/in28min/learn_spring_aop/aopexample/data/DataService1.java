package com.in28min.learn_spring_aop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {
	// connection with database
	public int[] retrieveData() {
		return new int[] {11,22,33,44,55};
	}
}
