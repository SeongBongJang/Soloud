package test;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest 
{
	public static void main(String[] a)
	{
		try {
			BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("C:/Users/BK/Documents/hello/1.txt"));
			os.write(123);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
