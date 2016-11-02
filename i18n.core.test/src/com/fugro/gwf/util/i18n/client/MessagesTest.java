package com.fugro.gwf.util.i18n.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.translation.TranslationService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class MessagesTest
{
	private Messages messages;
	private MessagesContainer messagesContainer;

	private void setProperties(String fileName)
	{
		FileInputStream propFile;
		try
		{
			propFile = new FileInputStream(fileName);
			Properties p = new Properties(System.getProperties());
			p.load(propFile);

			// set the system properties
			System.setProperties(p);
			// display new properties
			System.getProperties().list(System.out);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	@Ignore
	public void testDutchMessage()
	{
		setProperties("equinox_nl.properties");
		IEclipseContext context = EclipseContextFactory.create();
		messagesContainer = ContextInjectionFactory.make(MessagesContainer.class, context);
	//	context.set(TranslationService.LOCALE, "nl");
		Assert.assertEquals("Folder bestaat niet!", messagesContainer.getExportFilesDataBinding_errorMessage_folderDoesNotExist());
	}

	@Test
	public void testEnglishMessage()
	{
		setProperties("en.properties");
		IEclipseContext context = EclipseContextFactory.create();
		messagesContainer = ContextInjectionFactory.make(MessagesContainer.class, context);
		Assert.assertEquals("Folder does not exist!", messagesContainer.getExportFilesDataBinding_errorMessage_folderDoesNotExist());
	}

}
