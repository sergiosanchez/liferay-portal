/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * Provides the remote service interface for Layout. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see LayoutServiceUtil
 * @see com.liferay.portal.service.base.LayoutServiceBaseImpl
 * @see com.liferay.portal.service.impl.LayoutServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LayoutService extends BaseService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LayoutServiceUtil} to access the layout remote service. Add custom service methods to {@link com.liferay.portal.service.impl.LayoutServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds a layout with additional parameters.
	*
	* <p>
	* This method handles the creation of the layout including its resources,
	* metadata, and internal data structures. It is not necessary to make
	* subsequent calls to any methods to setup default groups, resources, ...
	* etc.
	* </p>
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param parentLayoutId the primary key of the parent layout
	(optionally {@link LayoutConstants#DEFAULT_PARENT_LAYOUT_ID})
	* @param localeNamesMap the layout's locales and localized names
	* @param localeTitlesMap the layout's locales and localized titles
	* @param descriptionMap the layout's locales and localized
	descriptions
	* @param keywordsMap the layout's locales and localized keywords
	* @param robotsMap the layout's locales and localized robots
	* @param type the layout's type (optionally {@link
	LayoutConstants#TYPE_PORTLET}). The possible types can be
	found in {@link LayoutConstants}.
	* @param hidden whether the layout is hidden
	* @param friendlyURL the layout's locales and localized friendly URLs.
	To see how the URL is normalized when accessed, see {@link
	com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil#normalize(
	String)}.
	* @param serviceContext the service context to be applied. Must set
	the UUID for the layout. Can set the creation date,
	modification date, and expando bridge attributes for the
	layout. For layouts that belong to a layout set prototype, an
	attribute named <code>layoutUpdateable</code> can be used to
	specify whether site administrators can modify this page
	within their site.
	* @return the layout
	* @throws PortalException if a group with the primary key could not be
	found, if the group did not have permission to manage the
	layouts involved, if layout values were invalid, or if a
	portal exception occurred
	* @deprecated As of 6.2.0, replaced by {@link #addLayout(long, boolean,
	long, Map, Map, Map, Map, Map, String, String, boolean, Map,
	ServiceContext)}
	*/
	@java.lang.Deprecated
	public com.liferay.portal.model.Layout addLayout(long groupId,
		boolean privateLayout, long parentLayoutId,
		java.util.Map<java.util.Locale, java.lang.String> localeNamesMap,
		java.util.Map<java.util.Locale, java.lang.String> localeTitlesMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Map<java.util.Locale, java.lang.String> keywordsMap,
		java.util.Map<java.util.Locale, java.lang.String> robotsMap,
		java.lang.String type, boolean hidden, java.lang.String friendlyURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException;

	/**
	* Adds a layout with additional parameters.
	*
	* <p>
	* This method handles the creation of the layout including its resources,
	* metadata, and internal data structures. It is not necessary to make
	* subsequent calls to any methods to setup default groups, resources, ...
	* etc.
	* </p>
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param parentLayoutId the primary key of the parent layout (optionally
	{@link LayoutConstants#DEFAULT_PARENT_LAYOUT_ID})
	* @param localeNamesMap the layout's locales and localized names
	* @param localeTitlesMap the layout's locales and localized titles
	* @param descriptionMap the layout's locales and localized descriptions
	* @param keywordsMap the layout's locales and localized keywords
	* @param robotsMap the layout's locales and localized robots
	* @param type the layout's type (optionally {@link
	LayoutConstants#TYPE_PORTLET}). The possible types can be found
	in {@link LayoutConstants}.
	* @param typeSettings the settings to load the unicode properties object.
	See {@link com.liferay.portal.kernel.util.UnicodeProperties
	#fastLoad(String)}.
	* @param hidden whether the layout is hidden
	* @param friendlyURLMap the layout's locales and localized friendly URLs.
	To see how the URL is normalized when accessed, see {@link
	com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil#normalize(
	String)}.
	* @param serviceContext the service context to be applied. Must set the
	UUID for the layout. Can set the creation date, modification
	date, and expando bridge attributes for the layout. For layouts
	that belong to a layout set prototype, an attribute named
	<code>layoutUpdateable</code> can be used to specify whether site
	administrators can modify this page within their site.
	* @return the layout
	* @throws PortalException if a group with the primary key could not be
	found, if the group did not have permission to manage the layouts
	involved, if layout values were invalid, or if a portal exception
	occurred
	*/
	public com.liferay.portal.model.Layout addLayout(long groupId,
		boolean privateLayout, long parentLayoutId,
		java.util.Map<java.util.Locale, java.lang.String> localeNamesMap,
		java.util.Map<java.util.Locale, java.lang.String> localeTitlesMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Map<java.util.Locale, java.lang.String> keywordsMap,
		java.util.Map<java.util.Locale, java.lang.String> robotsMap,
		java.lang.String type, java.lang.String typeSettings, boolean hidden,
		java.util.Map<java.util.Locale, java.lang.String> friendlyURLMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException;

	/**
	* Adds a layout with single entry maps for name, title, and description to
	* the default locale.
	*
	* <p>
	* This method handles the creation of the layout including its resources,
	* metadata, and internal data structures. It is not necessary to make
	* subsequent calls to any methods to setup default groups, resources, ...
	* etc.
	* </p>
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param parentLayoutId the primary key of the parent layout (optionally
	{@link LayoutConstants#DEFAULT_PARENT_LAYOUT_ID})
	* @param name the layout's locales and localized names
	* @param title the layout's locales and localized titles
	* @param description the layout's locales and localized descriptions
	* @param type the layout's type (optionally {@link
	LayoutConstants#TYPE_PORTLET}). The possible types can be found
	in {@link LayoutConstants}.
	* @param hidden whether the layout is hidden
	* @param friendlyURL the layout's locales and localized friendly URLs. To
	see how the URL is normalized when accessed, see {@link
	com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil#normalize(
	String)}.
	* @param serviceContext the service context to be applied. Must set the
	UUID for the layout. Can specify the creation date, modification
	date, and expando bridge attributes for the layout. For layouts
	that belong to a layout set prototype, an attribute named
	<code>layoutUpdateable</code> can be used to specify whether site
	administrators can modify this page within their site.
	* @return the layout
	* @throws PortalException if a group with the primary key could not be
	found, if the group did not have permission to manage the layouts
	involved, if layout values were invalid, or if a portal exception
	occurred
	*/
	public com.liferay.portal.model.Layout addLayout(long groupId,
		boolean privateLayout, long parentLayoutId, java.lang.String name,
		java.lang.String title, java.lang.String description,
		java.lang.String type, boolean hidden, java.lang.String friendlyURL,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException;

	public com.liferay.portal.kernel.repository.model.FileEntry addTempFileEntry(
		long groupId, java.lang.String folderName, java.lang.String fileName,
		java.io.InputStream inputStream, java.lang.String mimeType)
		throws PortalException;

	/**
	* Deletes the layout with the primary key, also deleting the layout's child
	* layouts, and associated resources.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param layoutId the primary key of the layout
	* @param serviceContext the service context to be applied
	* @throws PortalException if the user did not have permission to delete the
	layout, if a matching layout could not be found , or if some
	other portal exception occurred
	*/
	public void deleteLayout(long groupId, boolean privateLayout,
		long layoutId, com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException;

	/**
	* Deletes the layout with the plid, also deleting the layout's child
	* layouts, and associated resources.
	*
	* @param plid the primary key of the layout
	* @param serviceContext the service context to be applied
	* @throws PortalException if the user did not have permission to delete the
	layout, if a layout with the primary key could not be found , or
	if some other portal exception occurred
	*/
	public void deleteLayout(long plid,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException;

	public void deleteTempFileEntry(long groupId, java.lang.String folderName,
		java.lang.String fileName) throws PortalException;

	/**
	* Exports the layouts that match the primary keys and the criteria as a
	* byte array.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param layoutIds the primary keys of the layouts to be exported
	* @param parameterMap the mapping of parameters indicating which
	information to export. For information on the keys used in
	the map see {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param startDate the export's start date
	* @param endDate the export's end date
	* @return the layouts as a byte array
	* @throws PortalException if a group or any layout with the primary key
	could not be found, if the group did not have permission to
	manage the layouts, or if some other portal exception
	occurred
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public byte[] exportLayouts(long groupId, boolean privateLayout,
		long[] layoutIds,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws PortalException;

	/**
	* Exports all layouts that match the criteria as a byte array.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param parameterMap the mapping of parameters indicating which
	information to export. For information on the keys used in
	the map see {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param startDate the export's start date
	* @param endDate the export's end date
	* @return the layout as a byte array
	* @throws PortalException if a group with the primary key could not be
	found, if the group did not have permission to manage the
	layouts, or if some other portal exception occurred
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public byte[] exportLayouts(long groupId, boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws PortalException;

	/**
	* @deprecated As of 7.0.0, replaced by {@link
	com.liferay.portlet.exportimport.service.ExportImportService#exportLayoutsAsFile(
	ExportImportConfiguration)}
	*/
	@java.lang.Deprecated
	public java.io.File exportLayoutsAsFile(
		com.liferay.portlet.exportimport.model.ExportImportConfiguration exportImportConfiguration)
		throws PortalException;

	/**
	* Exports all layouts that match the primary keys and criteria as a file.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param layoutIds the primary keys of the layouts to be exported
	(optionally <code>null</code>)
	* @param parameterMap the mapping of parameters indicating which
	information to export. For information on the keys used in
	the map see {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param startDate the export's start date
	* @param endDate the export's end date
	* @return the layouts as a File
	* @throws PortalException if a group or any layout with the primary key
	could not be found, it the group did not have permission to
	manage the layouts, or if some other portal exception
	occurred
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public java.io.File exportLayoutsAsFile(long groupId,
		boolean privateLayout, long[] layoutIds,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws PortalException;

	/**
	* @deprecated As of 7.0.0, replaced by {@link
	com.liferay.portlet.exportimport.service.ExportImportService#exportLayoutsAsFileInBackground(
	ExportImportConfiguration)}
	*/
	@java.lang.Deprecated
	public long exportLayoutsAsFileInBackground(
		com.liferay.portlet.exportimport.model.ExportImportConfiguration exportImportConfiguration)
		throws PortalException;

	/**
	* @deprecated As of 7.0.0, replaced by {@link
	com.liferay.portlet.exportimport.service.ExportImportService#exportLayoutsAsFileInBackground(
	long)}
	*/
	@java.lang.Deprecated
	public long exportLayoutsAsFileInBackground(
		long exportImportConfigurationId) throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public long exportLayoutsAsFileInBackground(java.lang.String taskName,
		long groupId, boolean privateLayout, long[] layoutIds,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public long exportLayoutsAsFileInBackground(java.lang.String taskName,
		long groupId, boolean privateLayout, long[] layoutIds,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String fileName) throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public byte[] exportPortletInfo(long companyId, java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws PortalException;

	/**
	* Exports the portlet information (categories, permissions, ... etc.) as a
	* byte array.
	*
	* @param plid the primary key of the layout
	* @param groupId the primary key of the group
	* @param portletId the primary key of the portlet
	* @param parameterMap the mapping of parameters indicating which
	information to export. For information on the keys used in
	the map see {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param startDate the export's start date
	* @param endDate the export's end date
	* @return the portlet information as a byte array
	* @throws PortalException if a layout, group, or portlet with the
	primary key could not be found, if the group did not have
	permission to manage the layouts involved, or if some other
	portal exception occurred
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public byte[] exportPortletInfo(long plid, long groupId,
		java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws PortalException;

	/**
	* @deprecated As of 7.0.0, replaced by {@link
	com.liferay.portlet.exportimport.service.ExportImportService#exportPortletInfoAsFile(
	ExportImportConfiguration)}
	*/
	@java.lang.Deprecated
	public java.io.File exportPortletInfoAsFile(
		com.liferay.portlet.exportimport.model.ExportImportConfiguration exportImportConfiguration)
		throws PortalException;

	/**
	* Exports the portlet information (categories, permissions, ... etc.) as a
	* file.
	*
	* @param plid the primary key of the layout
	* @param groupId the primary key of the group
	* @param portletId the primary key of the portlet
	* @param parameterMap the mapping of parameters indicating which
	information to export. For information on the keys used in
	the map see {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param startDate the export's start date
	* @param endDate the export's end date
	* @return the portlet information as a file
	* @throws PortalException if a layout, group, or portlet with the
	primary key could not be found, it the group did not have
	permission to manage the layouts involved, or if some other
	portal exception occurred
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public java.io.File exportPortletInfoAsFile(long plid, long groupId,
		java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public java.io.File exportPortletInfoAsFile(java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate)
		throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public long exportPortletInfoAsFileInBackground(java.lang.String taskName,
		long plid, long groupId, java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String fileName) throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public long exportPortletInfoAsFileInBackground(java.lang.String taskName,
		java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String fileName) throws PortalException;

	/**
	* Returns all the ancestor layouts of the layout.
	*
	* @param plid the primary key of the layout
	* @return the ancestor layouts of the layout
	* @throws PortalException if a matching layout could not be found or if a
	portal exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portal.model.Layout> getAncestorLayouts(
		long plid) throws PortalException;

	@com.liferay.portal.kernel.cache.thread.local.ThreadLocalCachable
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getDefaultPlid(long groupId, long scopeGroupId,
		java.lang.String portletId) throws PortalException;

	/**
	* Returns the primary key of the default layout for the group.
	*
	* @param groupId the primary key of the group
	* @param scopeGroupId the primary key of the scope group. See {@link
	ServiceContext#getScopeGroupId()}.
	* @param privateLayout whether the layout is private to the group
	* @param portletId the primary key of the portlet
	* @return Returns the primary key of the default layout group; {@link
	LayoutConstants#DEFAULT_PLID} otherwise
	* @throws PortalException if a group, layout, or portlet with the primary
	key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long getDefaultPlid(long groupId, long scopeGroupId,
		boolean privateLayout, java.lang.String portletId)
		throws PortalException;

	/**
	* Returns the layout matching the UUID, group, and privacy.
	*
	* @param uuid the layout's UUID
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @return the matching layout
	* @throws PortalException if a matching layout could not be found, if the
	user did not have permission to view the layout, or if some other
	portal exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.Layout getLayoutByUuidAndGroupId(
		java.lang.String uuid, long groupId, boolean privateLayout)
		throws PortalException;

	/**
	* Returns the name of the layout.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param layoutId the primary key of the layout
	* @param languageId the primary key of the language. For more information
	See {@link Locale}.
	* @return the layout's name
	* @throws PortalException if a matching layout could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getLayoutName(long groupId, boolean privateLayout,
		long layoutId, java.lang.String languageId) throws PortalException;

	/**
	* Returns the layout references for all the layouts that belong to the
	* company and belong to the portlet that matches the preferences.
	*
	* @param companyId the primary key of the company
	* @param portletId the primary key of the portlet
	* @param preferencesKey the portlet's preference key
	* @param preferencesValue the portlet's preference value
	* @return the layout references of the matching layouts
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.LayoutReference[] getLayoutReferences(
		long companyId, java.lang.String portletId,
		java.lang.String preferencesKey, java.lang.String preferencesValue);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portal.model.Layout> getLayouts(
		long groupId, boolean privateLayout);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portal.model.Layout> getLayouts(
		long groupId, boolean privateLayout, long parentLayoutId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portal.model.Layout> getLayouts(
		long groupId, boolean privateLayout, long parentLayoutId,
		boolean incomplete, int start, int end) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLayoutsCount(long groupId, boolean privateLayout,
		long parentLayoutId);

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String[] getTempFileNames(long groupId,
		java.lang.String folderName) throws PortalException;

	/**
	* @deprecated As of 7.0.0, replaced by {@link
	com.liferay.portlet.exportimport.service.ExportImportService#importLayouts(
	ExportImportConfiguration, File)}
	*/
	@java.lang.Deprecated
	public void importLayouts(
		com.liferay.portlet.exportimport.model.ExportImportConfiguration exportImportConfiguration,
		java.io.File file) throws PortalException;

	/**
	* @deprecated As of 7.0.0, replaced by {@link
	com.liferay.portlet.exportimport.service.ExportImportService#importLayouts(
	ExportImportConfiguration, InputStream)}
	*/
	@java.lang.Deprecated
	public void importLayouts(
		com.liferay.portlet.exportimport.model.ExportImportConfiguration exportImportConfiguration,
		java.io.InputStream is) throws PortalException;

	/**
	* Imports the layouts from the byte array.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param parameterMap the mapping of parameters indicating which
	information will be imported. For information on the keys
	used in the map see {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param bytes the byte array with the data
	* @throws PortalException if a group with the primary key could not be
	found, if the group did not have permission to manage the
	layouts, or if some other portal exception occurred
	* @see com.liferay.portlet.exportimport.lar.LayoutImporter
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public void importLayouts(long groupId, boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		byte[] bytes) throws PortalException;

	/**
	* Imports the layouts from the file.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param parameterMap the mapping of parameters indicating which
	information will be imported. For information on the keys
	used in the map see {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param file the LAR file with the data
	* @throws PortalException if a group with the primary key could not be
	found, if the group did not have permission to manage the
	layouts and publish, or if some other portal exception
	occurred
	* @see com.liferay.portlet.exportimport.lar.LayoutImporter
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public void importLayouts(long groupId, boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.File file) throws PortalException;

	/**
	* Imports the layouts from the input stream.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param parameterMap the mapping of parameters indicating which
	information will be imported. For information on the keys
	used in the map see {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param is the input stream
	* @throws PortalException if a group with the primary key could not be
	found, if the group did not have permission to manage the
	layouts, or if some other portal exception occurred
	* @see com.liferay.portlet.exportimport.lar.LayoutImporter
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public void importLayouts(long groupId, boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.InputStream is) throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public long importLayoutsInBackground(java.lang.String taskName,
		long groupId, boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.File file) throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public long importLayoutsInBackground(java.lang.String taskName,
		long groupId, boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.InputStream inputStream) throws PortalException;

	/**
	* @deprecated As of 7.0.0, replaced by {@link
	com.liferay.portlet.exportimport.service.ExportImportService#importPortletInfo(
	ExportImportConfiguration, File)} (
	*/
	@java.lang.Deprecated
	public void importPortletInfo(
		com.liferay.portlet.exportimport.model.ExportImportConfiguration exportImportConfiguration,
		java.io.File file) throws PortalException;

	/**
	* @deprecated As of 7.0.0, replaced by {@link
	com.liferay.portlet.exportimport.service.ExportImportService#importPortletInfo(
	ExportImportConfiguration, InputStream)} (
	*/
	@java.lang.Deprecated
	public void importPortletInfo(
		com.liferay.portlet.exportimport.model.ExportImportConfiguration exportImportConfiguration,
		java.io.InputStream is) throws PortalException;

	/**
	* Imports the portlet information (categories, permissions, ... etc.) from
	* the file.
	*
	* @param plid the primary key of the layout
	* @param groupId the primary key of the group
	* @param portletId the primary key of the portlet
	* @param parameterMap the mapping of parameters indicating which
	information will be imported. For information on the keys
	used in the map see {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param file the LAR file with the data
	* @throws PortalException if a group, layout, or portlet with the
	primary key could not be found, or if the group did not have
	permission to manage the layouts
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public void importPortletInfo(long plid, long groupId,
		java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.File file) throws PortalException;

	/**
	* Imports the portlet information (categories, permissions, ... etc.) from
	* the input stream.
	*
	* @param plid the primary key of the layout
	* @param groupId the primary key of the group
	* @param portletId the primary key of the portlet
	* @param parameterMap the mapping of parameters indicating which
	information will be imported. For information on the keys
	used in the map see {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param is the input stream
	* @throws PortalException if a group, portlet, or layout with the
	primary key could not be found or if the group did not have
	permission to manage the layouts
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public void importPortletInfo(long plid, long groupId,
		java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.InputStream is) throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public void importPortletInfo(java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.File file) throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public void importPortletInfo(java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.InputStream is) throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public long importPortletInfoInBackground(java.lang.String taskName,
		long plid, long groupId, java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.File file) throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public long importPortletInfoInBackground(java.lang.String taskName,
		long plid, long groupId, java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.InputStream is) throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public void importPortletInfoInBackground(java.lang.String taskName,
		java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.File file) throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public void importPortletInfoInBackground(java.lang.String taskName,
		java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.InputStream is) throws PortalException;

	/**
	* Schedules a range of layouts to be published.
	*
	* @param sourceGroupId the primary key of the source group
	* @param targetGroupId the primary key of the target group
	* @param privateLayout whether the layout is private to the group
	* @param layoutIdMap the layouts considered for publishing, specified
	by the layout IDs and booleans indicating whether they have
	children
	* @param parameterMap the mapping of parameters indicating which
	information will be used. See {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param groupName the group name (optionally {@link
	DestinationNames#LAYOUTS_LOCAL_PUBLISHER}). See {@link
	DestinationNames}.
	* @param cronText the cron text. See {@link
	com.liferay.portal.kernel.cal.RecurrenceSerializer
	#toCronText}
	* @param schedulerStartDate the scheduler start date
	* @param schedulerEndDate the scheduler end date
	* @param description the scheduler description
	* @throws PortalException if the group did not have permission to
	manage and publish
	* @deprecated As of 7.0.0, replaced by {@link #schedulePublishToLive(long,
	long, boolean, long[], Map, String, Date, Date, String,
	String, Date, Date, String)}
	*/
	@java.lang.Deprecated
	public void schedulePublishToLive(long sourceGroupId, long targetGroupId,
		boolean privateLayout,
		java.util.Map<java.lang.Long, java.lang.Boolean> layoutIdMap,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.lang.String scope, java.util.Date startDate,
		java.util.Date endDate, java.lang.String groupName,
		java.lang.String cronText, java.util.Date schedulerStartDate,
		java.util.Date schedulerEndDate, java.lang.String description)
		throws PortalException;

	/**
	* Schedules a range of layouts to be published.
	*
	* @param sourceGroupId the primary key of the source group
	* @param targetGroupId the primary key of the target group
	* @param privateLayout whether the layout is private to the group
	* @param layoutIds the layouts considered for publishing, specified by the
	layout IDs
	* @param parameterMap the mapping of parameters indicating which
	information will be used. See {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param groupName the group name (optionally {@link
	DestinationNames#LAYOUTS_LOCAL_PUBLISHER}). See {@link
	DestinationNames}.
	* @param cronText the cron text. See {@link
	com.liferay.portal.kernel.cal.RecurrenceSerializer #toCronText}
	* @param schedulerStartDate the scheduler start date
	* @param schedulerEndDate the scheduler end date
	* @param description the scheduler description
	* @throws PortalException if the group did not have permission to manage
	and publish
	*/
	public void schedulePublishToLive(long sourceGroupId, long targetGroupId,
		boolean privateLayout, long[] layoutIds,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.lang.String groupName, java.lang.String cronText,
		java.util.Date schedulerStartDate, java.util.Date schedulerEndDate,
		java.lang.String description) throws PortalException;

	/**
	* Schedules a range of layouts to be published.
	*
	* @param sourceGroupId the primary key of the source group
	* @param targetGroupId the primary key of the target group
	* @param privateLayout whether the layout is private to the group
	* @param layoutIds the layouts considered for publishing, specified by
	the layout IDs
	* @param parameterMap the mapping of parameters indicating which
	information will be used. See {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param scope the scope of the pages. It can be
	<code>all-pages</code> or <code>selected-pages</code>.
	* @param startDate the start date
	* @param endDate the end date
	* @param groupName the group name (optionally {@link
	DestinationNames#LAYOUTS_LOCAL_PUBLISHER}). See {@link
	DestinationNames}.
	* @param cronText the cron text. See {@link
	com.liferay.portal.kernel.cal.RecurrenceSerializer
	#toCronText}
	* @param schedulerStartDate the scheduler start date
	* @param schedulerEndDate the scheduler end date
	* @param description the scheduler description
	* @throws PortalException if the group did not have permission to
	manage and publish
	* @deprecated As of 7.0.0, replaced by {@link #schedulePublishToLive(long,
	long, boolean, long[], Map, String, String, Date, Date,
	String)}
	*/
	@java.lang.Deprecated
	public void schedulePublishToLive(long sourceGroupId, long targetGroupId,
		boolean privateLayout, long[] layoutIds,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.lang.String scope, java.util.Date startDate,
		java.util.Date endDate, java.lang.String groupName,
		java.lang.String cronText, java.util.Date schedulerStartDate,
		java.util.Date schedulerEndDate, java.lang.String description)
		throws PortalException;

	/**
	* Schedules a range of layouts to be stored.
	*
	* @param sourceGroupId the primary key of the source group
	* @param privateLayout whether the layout is private to the group
	* @param layoutIdMap the layouts considered for publishing, specified by
	the layout IDs and booleans indicating whether they have children
	* @param parameterMap the mapping of parameters indicating which
	information will be used. See {@link
	com.liferay.portlet.exportimport.lar.PortletDataHandlerKeys}.
	* @param remoteAddress the remote address
	* @param remotePort the remote port
	* @param remotePathContext the remote path context
	* @param secureConnection whether the connection is secure
	* @param remoteGroupId the primary key of the remote group
	* @param remotePrivateLayout whether remote group's layout is private
	* @param startDate the start date
	* @param endDate the end date
	* @param groupName the group name. Optionally {@link
	DestinationNames#LAYOUTS_LOCAL_PUBLISHER}). See {@link
	DestinationNames}.
	* @param cronText the cron text. See {@link
	com.liferay.portal.kernel.cal.RecurrenceSerializer #toCronText}
	* @param schedulerStartDate the scheduler start date
	* @param schedulerEndDate the scheduler end date
	* @param description the scheduler description
	* @throws PortalException if a group with the source group primary key was
	not found or if the group did not have permission to publish
	*/
	public void schedulePublishToRemote(long sourceGroupId,
		boolean privateLayout,
		java.util.Map<java.lang.Long, java.lang.Boolean> layoutIdMap,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.lang.String remoteAddress, int remotePort,
		java.lang.String remotePathContext, boolean secureConnection,
		long remoteGroupId, boolean remotePrivateLayout,
		java.util.Date startDate, java.util.Date endDate,
		java.lang.String groupName, java.lang.String cronText,
		java.util.Date schedulerStartDate, java.util.Date schedulerEndDate,
		java.lang.String description) throws PortalException;

	/**
	* Sets the layouts for the group, replacing and prioritizing all layouts of
	* the parent layout.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param parentLayoutId the primary key of the parent layout
	* @param layoutIds the primary keys of the layouts
	* @param serviceContext the service context to be applied
	* @throws PortalException if a group or layout with the primary key could
	not be found, if the group did not have permission to manage the
	layouts, if no layouts were specified, if the first layout was
	not page-able, if the first layout was hidden, or if some other
	portal exception occurred
	*/
	public void setLayouts(long groupId, boolean privateLayout,
		long parentLayoutId, long[] layoutIds,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException;

	/**
	* Deletes the job from the scheduler's queue.
	*
	* @param groupId the primary key of the group
	* @param jobName the job name
	* @param groupName the group name (optionally {@link
	DestinationNames#LAYOUTS_LOCAL_PUBLISHER}). See {@link
	DestinationNames}.
	* @throws PortalException if the group did not permission to manage staging
	and publish
	*/
	public void unschedulePublishToLive(long groupId, java.lang.String jobName,
		java.lang.String groupName) throws PortalException;

	/**
	* Deletes the job from the scheduler's persistent queue.
	*
	* @param groupId the primary key of the group
	* @param jobName the job name
	* @param groupName the group name (optionally {@link
	DestinationNames#LAYOUTS_LOCAL_PUBLISHER}). See {@link
	DestinationNames}.
	* @throws PortalException if a group with the primary key could not be
	found or if the group did not have permission to publish
	*/
	public void unschedulePublishToRemote(long groupId,
		java.lang.String jobName, java.lang.String groupName)
		throws PortalException;

	public com.liferay.portal.model.Layout updateIconImage(long plid,
		byte[] bytes) throws PortalException;

	/**
	* Updates the layout with additional parameters.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param layoutId the primary key of the layout
	* @param parentLayoutId the primary key of the layout's new parent
	layout
	* @param localeNamesMap the layout's locales and localized names
	* @param localeTitlesMap the layout's locales and localized titles
	* @param descriptionMap the locales and localized descriptions to
	merge (optionally <code>null</code>)
	* @param keywordsMap the locales and localized keywords to merge
	(optionally <code>null</code>)
	* @param robotsMap the locales and localized robots to merge
	(optionally <code>null</code>)
	* @param type the layout's new type (optionally {@link
	LayoutConstants#TYPE_PORTLET})
	* @param hidden whether the layout is hidden
	* @param friendlyURL the layout's locales and new friendly URLs. To
	see how the URL is normalized when accessed, see {@link
	com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil#normalize(
	String)}.
	* @param iconImage whether the icon image will be updated
	* @param iconBytes the byte array of the layout's new icon image
	* @param serviceContext the service context to be applied. Can set the
	modification date and expando bridge attributes for the
	layout.
	* @return the updated layout
	* @throws PortalException if a group or layout with the primary key
	could not be found, if the user did not have permission to
	update the layout, if a unique friendly URL could not be
	generated, if a valid parent layout ID to use could not be
	found, or if the layout parameters were invalid
	* @deprecated As of 6.2.0, replaced by {@link #updateLayout(long, boolean,
	long, long, Map, Map, Map, Map, Map, String, boolean, Map,
	boolean, byte[], ServiceContext)}
	*/
	@java.lang.Deprecated
	public com.liferay.portal.model.Layout updateLayout(long groupId,
		boolean privateLayout, long layoutId, long parentLayoutId,
		java.util.Map<java.util.Locale, java.lang.String> localeNamesMap,
		java.util.Map<java.util.Locale, java.lang.String> localeTitlesMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Map<java.util.Locale, java.lang.String> keywordsMap,
		java.util.Map<java.util.Locale, java.lang.String> robotsMap,
		java.lang.String type, boolean hidden, java.lang.String friendlyURL,
		java.lang.Boolean iconImage, byte[] iconBytes,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException;

	/**
	* Updates the layout with additional parameters.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param layoutId the primary key of the layout
	* @param parentLayoutId the primary key of the layout's new parent layout
	* @param localeNamesMap the layout's locales and localized names
	* @param localeTitlesMap the layout's locales and localized titles
	* @param descriptionMap the locales and localized descriptions to merge
	(optionally <code>null</code>)
	* @param keywordsMap the locales and localized keywords to merge
	(optionally <code>null</code>)
	* @param robotsMap the locales and localized robots to merge (optionally
	<code>null</code>)
	* @param type the layout's new type (optionally {@link
	LayoutConstants#TYPE_PORTLET})
	* @param hidden whether the layout is hidden
	* @param friendlyURLMap the layout's locales and localized friendly URLs.
	To see how the URL is normalized when accessed see {@link
	com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil#normalize(
	String)}.
	* @param iconImage whether the icon image will be updated
	* @param iconBytes the byte array of the layout's new icon image
	* @param serviceContext the service context to be applied. Can set the
	modification date and expando bridge attributes for the layout.
	* @return the updated layout
	* @throws PortalException if a group or layout with the primary key could
	not be found, if the user did not have permission to update the
	layout, if a unique friendly URL could not be generated, if a
	valid parent layout ID to use could not be found, or if the
	layout parameters were invalid
	*/
	public com.liferay.portal.model.Layout updateLayout(long groupId,
		boolean privateLayout, long layoutId, long parentLayoutId,
		java.util.Map<java.util.Locale, java.lang.String> localeNamesMap,
		java.util.Map<java.util.Locale, java.lang.String> localeTitlesMap,
		java.util.Map<java.util.Locale, java.lang.String> descriptionMap,
		java.util.Map<java.util.Locale, java.lang.String> keywordsMap,
		java.util.Map<java.util.Locale, java.lang.String> robotsMap,
		java.lang.String type, boolean hidden,
		java.util.Map<java.util.Locale, java.lang.String> friendlyURLMap,
		boolean iconImage, byte[] iconBytes,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws PortalException;

	/**
	* Updates the layout replacing its type settings.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param layoutId the primary key of the layout
	* @param typeSettings the settings to load the unicode properties object.
	See {@link com.liferay.portal.kernel.util.UnicodeProperties
	#fastLoad(String)}.
	* @return the updated layout
	* @throws PortalException if a matching layout could not be found or if the
	user did not have permission to update the layout
	*/
	public com.liferay.portal.model.Layout updateLayout(long groupId,
		boolean privateLayout, long layoutId, java.lang.String typeSettings)
		throws PortalException;

	/**
	* Updates the look and feel of the layout.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param layoutId the primary key of the layout
	* @param themeId the primary key of the layout's new theme
	* @param colorSchemeId the primary key of the layout's new color scheme
	* @param css the layout's new CSS
	* @param wapTheme whether the theme is for WAP browsers
	* @return the updated layout
	* @throws PortalException if a matching layout could not be found, or if
	the user did not have permission to update the layout and
	permission to apply the theme
	*/
	public com.liferay.portal.model.Layout updateLookAndFeel(long groupId,
		boolean privateLayout, long layoutId, java.lang.String themeId,
		java.lang.String colorSchemeId, java.lang.String css, boolean wapTheme)
		throws PortalException;

	/**
	* Updates the name of the layout matching the group, layout ID, and
	* privacy.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param layoutId the primary key of the layout
	* @param name the layout's new name
	* @param languageId the primary key of the language. For more information
	see {@link Locale}.
	* @return the updated layout
	* @throws PortalException if a matching layout could not be found, if the
	user did not have permission to update the layout, or if the new
	name was <code>null</code>
	*/
	public com.liferay.portal.model.Layout updateName(long groupId,
		boolean privateLayout, long layoutId, java.lang.String name,
		java.lang.String languageId) throws PortalException;

	/**
	* Updates the name of the layout matching the primary key.
	*
	* @param plid the primary key of the layout
	* @param name the name to be assigned
	* @param languageId the primary key of the language. For more information
	see {@link Locale}.
	* @return the updated layout
	* @throws PortalException if a layout with the primary key could not be
	found, or if the user did not have permission to update the
	layout, or if the name was <code>null</code>
	*/
	public com.liferay.portal.model.Layout updateName(long plid,
		java.lang.String name, java.lang.String languageId)
		throws PortalException;

	/**
	* Updates the parent layout ID of the layout matching the group, layout ID,
	* and privacy.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param layoutId the primary key of the layout
	* @param parentLayoutId the primary key to be assigned to the parent
	layout
	* @return the matching layout
	* @throws PortalException if a valid parent layout ID to use could not be
	found, if a matching layout could not be found, or if the user
	did not have permission to update the layout
	*/
	public com.liferay.portal.model.Layout updateParentLayoutId(long groupId,
		boolean privateLayout, long layoutId, long parentLayoutId)
		throws PortalException;

	/**
	* Updates the parent layout ID of the layout matching the primary key. If a
	* layout matching the parent primary key is found, the layout ID of that
	* layout is assigned, otherwise {@link
	* LayoutConstants#DEFAULT_PARENT_LAYOUT_ID} is assigned.
	*
	* @param plid the primary key of the layout
	* @param parentPlid the primary key of the parent layout
	* @return the layout matching the primary key
	* @throws PortalException if a layout with the primary key could not be
	found, if the user did not have permission to update the layout,
	or if a valid parent layout ID to use could not be found
	*/
	public com.liferay.portal.model.Layout updateParentLayoutId(long plid,
		long parentPlid) throws PortalException;

	/**
	* Updates the parent layout ID and priority of the layout.
	*
	* @param plid the primary key of the layout
	* @param parentPlid the primary key of the parent layout
	* @param priority the layout's new priority
	* @return the layout matching the primary key
	* @throws PortalException if a portal exception occurred
	*/
	public com.liferay.portal.model.Layout updateParentLayoutIdAndPriority(
		long plid, long parentPlid, int priority) throws PortalException;

	/**
	* Updates the priority of the layout matching the group, layout ID, and
	* privacy, setting the layout's priority based on the priorities of the
	* next and previous layouts.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param layoutId the primary key of the layout
	* @param nextLayoutId the primary key of the next layout
	* @param previousLayoutId the primary key of the previous layout
	* @return the updated layout
	* @throws PortalException if a matching layout could not be found or if the
	user did not have permission to update the layout
	*/
	public com.liferay.portal.model.Layout updatePriority(long groupId,
		boolean privateLayout, long layoutId, long nextLayoutId,
		long previousLayoutId) throws PortalException;

	/**
	* Updates the priority of the layout matching the group, layout ID, and
	* privacy.
	*
	* @param groupId the primary key of the group
	* @param privateLayout whether the layout is private to the group
	* @param layoutId the primary key of the layout
	* @param priority the layout's new priority
	* @return the updated layout
	* @throws PortalException if a matching layout could not be found or if the
	user did not have permission to update the layout
	*/
	public com.liferay.portal.model.Layout updatePriority(long groupId,
		boolean privateLayout, long layoutId, int priority)
		throws PortalException;

	/**
	* Updates the priority of the layout matching the primary key.
	*
	* @param plid the primary key of the layout
	* @param priority the layout's new priority
	* @return the updated layout
	* @throws PortalException if a layout with the primary key could not be
	found
	*/
	public com.liferay.portal.model.Layout updatePriority(long plid,
		int priority) throws PortalException;

	/**
	* @deprecated As of 7.0.0, replaced by {@link
	com.liferay.portlet.exportimport.service.ExportImportService#validateImportLayoutsFile(
	ExportImportConfiguration, File)}
	*/
	@java.lang.Deprecated
	public com.liferay.portlet.exportimport.lar.MissingReferences validateImportLayoutsFile(
		com.liferay.portlet.exportimport.model.ExportImportConfiguration exportImportConfiguration,
		java.io.File file) throws PortalException;

	/**
	* @deprecated As of 7.0.0, replaced by {@link
	com.liferay.portlet.exportimport.service.ExportImportService#validateImportLayoutsFile(
	ExportImportConfiguration, InputStream)}
	*/
	@java.lang.Deprecated
	public com.liferay.portlet.exportimport.lar.MissingReferences validateImportLayoutsFile(
		com.liferay.portlet.exportimport.model.ExportImportConfiguration exportImportConfiguration,
		java.io.InputStream inputStream) throws PortalException;

	/**
	* @throws PortalException
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public com.liferay.portlet.exportimport.lar.MissingReferences validateImportLayoutsFile(
		long groupId, boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.File file) throws PortalException;

	/**
	* @throws PortalException
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public com.liferay.portlet.exportimport.lar.MissingReferences validateImportLayoutsFile(
		long groupId, boolean privateLayout,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.InputStream inputStream) throws PortalException;

	/**
	* @deprecated As of 7.0.0, replaced by {@link
	com.liferay.portlet.exportimport.service.ExportImportService#validateImportPortletInfo(
	ExportImportConfiguration, File)}
	*/
	@java.lang.Deprecated
	public com.liferay.portlet.exportimport.lar.MissingReferences validateImportPortletInfo(
		com.liferay.portlet.exportimport.model.ExportImportConfiguration exportImportConfiguration,
		java.io.File file) throws PortalException;

	/**
	* @deprecated As of 7.0.0, replaced by {@link
	com.liferay.portlet.exportimport.service.ExportImportService#validateImportPortletInfo(
	ExportImportConfiguration, InputStream)}
	*/
	@java.lang.Deprecated
	public com.liferay.portlet.exportimport.lar.MissingReferences validateImportPortletInfo(
		com.liferay.portlet.exportimport.model.ExportImportConfiguration exportImportConfiguration,
		java.io.InputStream inputStream) throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public com.liferay.portlet.exportimport.lar.MissingReferences validateImportPortletInfo(
		long plid, long groupId, java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.File file) throws PortalException;

	/**
	* @deprecated As of 7.0.0, with no direct replacement
	*/
	@java.lang.Deprecated
	public com.liferay.portlet.exportimport.lar.MissingReferences validateImportPortletInfo(
		long plid, long groupId, java.lang.String portletId,
		java.util.Map<java.lang.String, java.lang.String[]> parameterMap,
		java.io.InputStream inputStream) throws PortalException;
}