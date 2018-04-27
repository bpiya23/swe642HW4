package org.gmu.swe642.hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * this is the mean and standard deviation calculator
 * 
 * @author saurav bhattacharyya
 *
 */
public class DataProcessor {

	DataBean bean = new DataBean();
	
	public DataProcessor() {
	}
	

	
	public DataBean calculate(String[] arr) {
		
		double mean = 0, stddev=0;
		
		if(arr != null && arr.length != 0 ) {
			
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
				int version= Integer.parseInt(arr[i].trim());
				mean +=version;
			}
			
			mean = mean/arr.length;
			bean.setMean(mean);
			bean.setStandardDeviation(getVariance( mean, arr));
			
			
		}
		return bean;
	}
	
	double getVariance(double mean, String[] arr) {
        
        double temp = 0;
        if(arr != null && arr.length != 0 ) {
			
			for (int i = 0; i < arr.length; i++) {
				int version= Integer.parseInt(arr[i].trim());
				temp += (version-mean)*(version-mean);
			}
			
			
			
			
			
		}
         
        return temp/(arr.length-1);
    }

    double getStdDev(double mean, String[] arr) {
        return Math.sqrt(getVariance( mean,  arr));
    }
	
	
}
