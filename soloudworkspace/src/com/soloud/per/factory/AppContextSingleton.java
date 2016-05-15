package com.soloud.per.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AppContextSingleton
{
	private static ApplicationContext appContext;
	private static AppContextSingleton appContextSingleton;
	static
	{
		init();
	}
	//private
	public AppContextSingleton()
	{
		
	}
	private static void init()
	{
		if(appContext == null)
		{
			try
			{
				//DOMCONFI
				appContext=new FileSystemXmlApplicationContext(new String[] {"C:/j2ee_works/Soloud/src/config/" + "appContext.xml"});		
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	public static synchronized AppContextSingleton getInstance()
	{
		if(appContextSingleton==null)
			appContextSingleton = new AppContextSingleton();
		return appContextSingleton;
	}
	public ApplicationContext getAppContext()
	{
		return appContext;
	}
}
