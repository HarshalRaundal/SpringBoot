package com.in28min.learn_spring_aop.aopexample.data;

import org.springframework.stereotype.Repository;

import com.in28min.learn_spring_aop.aopexample.annotations.TrackTime;

@Repository
public class DataService2 {
	// connection with database
	@TrackTime
	public int[] retrieveData() {
//		try {
//			Thread.sleep(30);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return new int[] {111,221,331,441,551};
	}
}
