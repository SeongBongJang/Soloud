package com.soloud.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopyInputStream
{
	private InputStream in;
	private ByteArrayOutputStream copyIn;

	public CopyInputStream(InputStream in)
	{
		this.in = in;
		this.copyIn= new ByteArrayOutputStream();
		try{
			this.copy();
		}
		catch(IOException ex){
		}
	}

	private int copy() throws IOException
	{
		int read = 0;
		int chunk = 0;
		byte[] data = new byte[256];
		
		while(-1 != (chunk = in.read(data)))	{
			read += data.length;
			this.copyIn.write(data, 0, chunk);
		}
		return read;
	}
	
	public InputStream getCopy(){
		return (InputStream)new ByteArrayInputStream(this.copyIn.toByteArray());
	}
}