package com.getagain.util;

import java.io.*;

import com.google.common.io.ByteStreams;

public class imageMagic {
	static String basepath1 = "\"C:\\work\\HtmlReview\\test-tx\\wcgtx\\wcgtx_jpeg\\sm\"";
	static String basepath2 = "\"C:\\work\\HtmlReview\\test-tx\\wcgtx\\wcgtx_png\\sm\"";
	
	public static void main(String[] args) throws Exception {
    	
    	imgMagic("wcg_tx_se_s_em_002");
    	
    	    }
    
    public static String imgMagic(String filename) throws IOException, InterruptedException{

//System.out.println("Start");
String output = "";

    	String command1 = "cd " + basepath1 + " && convert " 
    			+ filename + ".jpg -blur 3x2 " + filename + "_jpg.gif";
    						
    	
    	String command2 = "cd " + basepath2 + " && convert " 
    			+ filename + ".png -blur 3x2 " + filename + "_png.gif";
    						
    	
    	String command3 = "cd " + basepath1 + " && compare -fuzz 20% -compose src " 
    						+ basepath1+"\\"+filename + "_jpg.gif " + basepath2+"\\"+filename + "_png.gif " + basepath1+"\\"+filename + "_comp.gif";
    	
    	String command4 = "cd " + basepath1 + " && convert " 
    						+filename + "_comp.gif -morphology Smooth Square:1.25 " +filename + "_comp-smooth.gif";
    	
 
    	String command5 = "cd " + basepath1 + " && compare -metric rmse " 
    			+basepath1+"\\"+ filename + "_comp-smooth.gif " +basepath1+"\\"+"white.png null";
    	
        ProcessBuilder builder1 = new ProcessBuilder("cmd.exe", "/c",command1);
        builder1.redirectErrorStream(true);
        Process p1 = builder1.start();
        
        ProcessBuilder builder2 = new ProcessBuilder("cmd.exe", "/c",command2);
        builder2.redirectErrorStream(true);
        Process p2 = builder2.start();
        
        Thread.sleep(10000);
        ProcessBuilder builder3 = new ProcessBuilder("cmd.exe", "/c",command3);
        builder3.redirectErrorStream(true);
        Process p3 = builder3.start();
        
        Thread.sleep(10000);    
        ProcessBuilder builder4 = new ProcessBuilder("cmd.exe", "/c",command4);
        builder4.redirectErrorStream(true);
        Process p4 = builder4.start();
        
        Thread.sleep(10000); 
        ProcessBuilder builder5 = null;
        
        builder5 = new ProcessBuilder("cmd.exe", "/c",command5);
        builder5.redirectErrorStream(true);
        Process p5 = builder5.start();

        InputStream is = p5.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        String line = null;
        while ((line = reader.readLine()) != null){
           System.out.println(line);
        	output = output+line;
        }

        //System.out.println("Done.");
        return output;

    }            
}