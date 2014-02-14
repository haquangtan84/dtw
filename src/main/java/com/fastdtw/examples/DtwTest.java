/*
 * DtwTest.java   Jul 14, 2004
 *
 * Copyright (c) 2004 Stan Salvador
 * stansalvador@hotmail.com
 */

package com.fastdtw.examples;

import com.fastdtw.timeseries.TimeSeries;
import com.fastdtw.util.DistanceFunction;
import com.fastdtw.util.DistanceFunctionFactory;
import com.fastdtw.util.Utils;
import com.fastdtw.dtw.TimeWarpInfo;


public class DtwTest
{

   // PUBLIC FUNCTIONS
   public static void main(String[] args)
   {
	 String dataFile1 = "/Users/haquangtan/Desktop/sign/tst.csv";
     String dataFile2 = "/Users/haquangtan/Desktop/sign/1392047596192_2014-02-10_22-53.csv";
     
     TimeSeries tsI = new TimeSeries(dataFile1, false, false, ',');
     TimeSeries tsJ = new TimeSeries(dataFile2, false, false, ',');
     tsI = Utils.quantizeTS(tsI);
     tsJ = Utils.quantizeTS(tsJ);
        
         
     final DistanceFunction distFn;
         
     distFn = DistanceFunctionFactory.getDistFnByName("EuclideanDistance"); 
        
     final TimeWarpInfo info = com.fastdtw.dtw.DTW.getWarpInfoBetween(tsI, tsJ, distFn);

     System.out.println("Warp Distance: " + info.getDistance());
     System.out.println("Warp Path:     " + info.getPath());
     
   }  

} 
