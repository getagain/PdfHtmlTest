package com.getagain.util;

import java.io.*;

public class CmdTest {
    public static void main(String[] args) throws Exception {
    	tesseract("inside_se_a_rl_085_image");
    	
    	System.out.println("containText: " + imageText("inside_se_a_rl_085_image"));

    }
    
    public static void tesseract(String filename) throws IOException{

    	String command = "cd \"C:\\work\\HtmlReview\\test7\\image\" && tesseract "+ filename +".jpg "+ filename;
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c",command);
       	
       	//ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Users\\AbhishekK\\Pictures\\112\" && client.bat && server.bat");
       	//ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Users\\AbhishekK\\Downloads\\speed-o-meter-1.0-bin\\speed-o-meter-1.0\" && "client.cmd");
       	// "cmd.exe", "/c", "cd \"C:\\Program Files\\Microsoft SQL Server\" && dir");

           builder.redirectErrorStream(true);
           Process p = builder.start();
           BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
           String line;
           while (true) {
               line = r.readLine();
               if (line == null) { break; }
               System.out.println(line);
           }
           
           
    }
           public static boolean imageText(String filename) throws IOException{
       // reading output
           
   	    BufferedReader br = null;
   	    
   	    
   			String sCurrentLine;
   			String oneLineImage = "";

   			String pdf_filePath = "C:\\work\\HtmlReview\\test7\\image\\" + filename + ".txt";
   			//			br = new BufferedReader(new FileReader(pdf_filePath));
   			 br = new BufferedReader(new InputStreamReader(new FileInputStream(pdf_filePath )));

   			while ((sCurrentLine = br.readLine()) != null) {
   				//System.out.println(sCurrentLine);
   				//if (sCurrentLine.contains(".indd") || sCurrentLine.contains("LIVE AREA") ){break;}
   				
   					//System.out.println(sCurrentLine);
   				oneLineImage = oneLineImage + sCurrentLine;
   				
   			}
   			boolean imageText = !oneLineImage.replaceAll(" ", "").isEmpty();
   			System.out.println("image text length: " + oneLineImage.length());
   			return imageText;

       }
              
}