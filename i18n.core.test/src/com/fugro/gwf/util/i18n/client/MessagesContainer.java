package com.fugro.gwf.util.i18n.client;

import javax.inject.Inject;

import org.eclipse.e4.core.services.nls.Translation;

public class MessagesContainer
{
	@Inject
	@Translation
	private Messages messages;

	public Object getExportFilesDataBinding_errorMessage_folderDoesNotExist()
	{
		return messages.exportFilesDataBinding_errorMessage_folderDoesNotExist;
	}
}
