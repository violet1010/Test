package ykse.TestAutomation.Common;
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.RandomAccessFile;  
public class FromEndRF {
	public static String read(String filename) {  
        return read(filename, "gb2312");  
        
    }  
  
    public static String read(String filename, String charset) {  
        RandomAccessFile rf = null;  
        String res = "";
        try {  
            rf = new RandomAccessFile(filename, "r");  
            long len = rf.length();  
            long start = rf.getFilePointer();  
            long nextend = start + len - 1;  
            String line;  
            rf.seek(nextend);  
            int c = -1;  
         
            while (nextend > start) {  
                c = rf.read();  
                if (c == '\n' || c == '\r') {  
                    line = rf.readLine();  
                    if (line != null) {  
                    	line = new String(line.getBytes("iso8859-1"),  
                                charset);
                 
                    	if(line.contains("步骤_"))
                    			{
                    		res = line.split("步骤_")[1].split("\\. ")[1];
                    		return res;
                    			}
                    	if(line.contains("检查点_"))
            			{
            		res = line.split("检查点_")[1].split("\\. ")[1];
            		return res;
            			}
            			
            
                          
                    } else {  
                        
                    }  
                    nextend--;  
                }  
                nextend--;  
                rf.seek(nextend);  
                if (nextend == 0) {// 当文件指针退至文件开始处，输出第一行  
                    line = rf.readLine();  
                    System.out.println("读取到日志文件第一行: "+"filename"+line);  
                }  
            }  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (rf != null)  
                    rf.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }
            
        } 
        return res;
        
    }  
  
    public static void main(String args[]) {  
    	String xx = read("target/testlog/output/logs/app_android.log"); 
    	//System.out.println(xx);
    } 
}
