<%
/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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
%>

<%@ include file="/html/portlet/document_library/init.jsp" %>

<%
String tabs2 = ParamUtil.getString(request, "tabs2", "version-history");

String redirect = ParamUtil.getString(request, "redirect");

String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");

String uploadProgressId = "dlFileEntryUploadProgress";

DLFileEntry fileEntry = (DLFileEntry)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FILE_ENTRY);

fileEntry = fileEntry.toEscapedModel();

long fileEntryId = fileEntry.getFileEntryId();
long folderId = fileEntry.getFolderId();
String name = fileEntry.getName();
String title = fileEntry.getTitle();

String extension = StringPool.BLANK;

if (Validator.isNotNull(title)) {
	extension = FileUtil.getExtension(title);
}

String[] conversions = new String[0];

if (PrefsPropsUtil.getBoolean(PropsKeys.OPENOFFICE_SERVER_ENABLED, PropsValues.OPENOFFICE_SERVER_ENABLED)) {
	conversions = (String[])DocumentConversionUtil.getConversions(extension);
}

DLFolder folder = fileEntry.getFolder();

Lock lock = null;
Boolean isLocked = Boolean.FALSE;
Boolean hasLock = Boolean.FALSE;

try {
	lock = LockLocalServiceUtil.getLock(DLFileEntry.class.getName(), DLUtil.getLockId(fileEntry.getGroupId(), fileEntry.getFolderId(), fileEntry.getName()));

	isLocked = Boolean.TRUE;

	if (lock.getUserId() == user.getUserId()) {
		hasLock = Boolean.TRUE;
	}
}
catch (Exception e) {
}

String fileUrl = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/document/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + folderId + StringPool.SLASH + HttpUtil.encodeURL(title);
String webDavUrl = StringPool.BLANK;

if (portletDisplay.isWebDAVEnabled()) {
	StringBuilder sb = new StringBuilder();

	if (folderId != DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
		DLFolder curFolder = DLFolderLocalServiceUtil.getFolder(folderId);

		while (true) {
			sb.insert(0, HttpUtil.encodeURL(curFolder.getName(), true));
			sb.insert(0, StringPool.SLASH);

			if (curFolder.getParentFolderId() == DLFolderConstants.DEFAULT_PARENT_FOLDER_ID) {
				break;
			}
			else {
				curFolder = DLFolderLocalServiceUtil.getFolder(curFolder.getParentFolderId());
			}
		}
	}

	sb.append(StringPool.SLASH);
	sb.append(HttpUtil.encodeURL(title, true));

	Group group = themeDisplay.getScopeGroup();

	webDavUrl = themeDisplay.getPortalURL() + "/tunnel-web/secure/webdav/" + company.getWebId() + group.getFriendlyURL() + "/document_library" + sb.toString();
}

request.setAttribute("view_file_entry.jsp-fileEntry", fileEntry);
%>

<liferay-util:include page="/html/portlet/document_library/top_links.jsp" />

<c:if test="<%= isLocked.booleanValue() %>">
	<c:choose>
		<c:when test="<%= hasLock.booleanValue() %>">

			<%
			String lockExpirationTime = LanguageUtil.getTimeDescription(pageContext, DLFileEntryImpl.LOCK_EXPIRATION_TIME).toLowerCase();
			%>

			<div class="portlet-msg-success">
				<%= LanguageUtil.format(pageContext, "you-now-have-a-lock-on-this-document", lockExpirationTime, false) %>
			</div>
		</c:when>
		<c:otherwise>
			<div class="portlet-msg-error">
				<%= LanguageUtil.format(pageContext, "you-cannot-modify-this-document-because-it-was-locked-by-x-on-x", new Object[] {HtmlUtil.escape(PortalUtil.getUserName(lock.getUserId(), String.valueOf(lock.getUserId()))), dateFormatDateTime.format(lock.getCreateDate())}, false) %>
			</div>
		</c:otherwise>
	</c:choose>
</c:if>

<aui:layout>
	<aui:column columnWidth="<%= 75 %>" cssClass="file-entry-column file-entry-column-first" first="<%= true %>">

		<%
		String versionText = LanguageUtil.format(pageContext, "version-x", fileEntry.getVersion());

		if (Validator.isNull(fileEntry.getVersion())) {
			versionText = LanguageUtil.get(pageContext, "not-approved");
		}
		%>

		<h3 class="file-entry-title"><%= fileEntry.getTitle() + " (" + versionText + ")" %></h3>

		<div class="file-entry-categories">
			<liferay-ui:asset-categories-summary
				className="<%= DLFileEntry.class.getName() %>"
				classPK="<%= fileEntryId %>"
			/>
		</div>

		<div class="file-entry-tags">
			<liferay-ui:asset-tags-summary
				className="<%= DLFileEntry.class.getName() %>"
				classPK="<%= fileEntryId %>"
				message="tags"
			/>
		</div>

		<div class="file-entry-description">
			<%= fileEntry.getDescription() %>
		</div>

		<div class="custom-attributes">
			<liferay-ui:custom-attributes-available className="<%= DLFileEntry.class.getName() %>">
				<liferay-ui:custom-attribute-list
					className="<%= DLFileEntry.class.getName() %>"
					classPK="<%= (fileEntry != null) ? fileEntry.getFileEntryId() : 0 %>"
					editable="<%= false %>"
					label="<%= true %>"
				/>
			</liferay-ui:custom-attributes-available>
		</div>

		<div class="file-entry-author">
			<%= LanguageUtil.format(pageContext, "last-updated-by-x", HtmlUtil.escape(PortalUtil.getUserName(fileEntry.getUserId(), fileEntry.getUserName()))) %>
		</div>

		<div class="file-entry-date">
			<%= dateFormatDateTime.format(fileEntry.getModifiedDate()) %>
		</div>

		<div class="file-entry-downloads">
			<%= fileEntry.getReadCount() %> <liferay-ui:message key="downloads" />
		</div>

		<div class="file-entry-ratings">
			<liferay-ui:ratings
				className="<%= DLFileEntry.class.getName() %>"
				classPK="<%= fileEntryId %>"
			/>
		</div>

		<div class="file-entry-field">
			<label><liferay-ui:message key="url" /></label>

			<liferay-ui:input-resource
				url='<%= themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/document/" + themeDisplay.getScopeGroupId() + StringPool.SLASH + fileEntry.getUuid() %>'
			/>
		</div>

		<c:if test="<%= portletDisplay.isWebDAVEnabled() %>">
			<div class="file-entry-field">

				<%
				String webDavHelpMessage = null;

				if (BrowserSnifferUtil.isWindows(request)) {
					webDavHelpMessage = LanguageUtil.format(pageContext, "webdav-windows-help", new Object[] {"http://www.microsoft.com/downloads/details.aspx?FamilyId=17C36612-632E-4C04-9382-987622ED1D64", "http://www.liferay.com/web/guest/community/wiki/-/wiki/Main/WebDAV"});
				}
				else {
					webDavHelpMessage = LanguageUtil.format(pageContext, "webdav-help", "http://www.liferay.com/web/guest/community/wiki/-/wiki/Main/WebDAV");
				}
				%>

				<aui:field-wrapper helpMessage="<%= webDavHelpMessage %>" label="webdav-url">
					<liferay-ui:input-resource url="<%= webDavUrl %>" />
				</aui:field-wrapper>
			</div>
		</c:if>
	</aui:column>

	<aui:column columnWidth="<%= 25 %>" cssClass="detail-column detail-column-last" last="<%= true %>">
		<c:if test="<%= isLocked %>">
			<img alt="" class="locked-icon" src="<%= themeDisplay.getPathThemeImages() %>/file_system/large/overlay_lock.png">
		</c:if>

		<div class="file-entry-download">
			<liferay-ui:icon
				cssClass="file-entry-avatar"
				image='<%= "../file_system/large/" + DLUtil.getGenericName(extension) %>'
				message="download"
				url="<%= fileUrl %>"
			/>

			<div class="file-entry-name">
				<a href="<%= fileUrl %>">
					<%= title %>
				</a>
			</div>

			<c:if test="<%= conversions.length > 0 %>">
				<div class="file-entry-field file-entry-conversions">
					<label><liferay-ui:message key="other-available-formats" /></label>

					<%
					for (int i = 0; i < conversions.length; i++) {
						String conversion = conversions[i];
					%>

						<liferay-ui:icon
							image='<%= "../file_system/small/" + conversion %>'
							label="<%= true %>"
							message="<%= conversion.toUpperCase() %>"
							url='<%= fileUrl + "?targetExtension=" + conversion %>'
						/>

					<%
					}
					%>

				</div>
			</c:if>
		</div>

		<%
		request.removeAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
		%>

		<liferay-util:include page="/html/portlet/document_library/file_entry_action.jsp" />
	</aui:column>
</aui:layout>

<div class="file-entry-panels">
	<liferay-ui:panel-container extended="<%= false %>" persistState="<%= true %>">
		<liferay-ui:panel collapsible="<%= true %>" cssClass="version-history" extended="<%= true %>" persistState="<%= true %>" title='<%= LanguageUtil.get(pageContext, "version-history") %>'>

			<%
			boolean comparableFileEntry = false;
			boolean showNonApprovedDocuments = false;

			String[] comparableFileExtensions = PropsValues.DL_COMPARABLE_FILE_EXTENSIONS;

			for (int i = 0; i < comparableFileExtensions.length; i++) {
				if (StringPool.STAR.equals(comparableFileExtensions[i]) ||
					StringUtil.endsWith(title, comparableFileExtensions[i])) {

					comparableFileEntry = true;

					break;
				}
			}

			if ((user.getUserId() == fileEntry.getUserId()) || permissionChecker.isCompanyAdmin() || permissionChecker.isCommunityAdmin(scopeGroupId)) {
				showNonApprovedDocuments = true;
			}

			SearchContainer searchContainer = new SearchContainer();

			List<String> headerNames = new ArrayList<String>();

			headerNames.add("version");
			headerNames.add("date");
			headerNames.add("size");

			if (showNonApprovedDocuments) {
				headerNames.add("status");
			}

			headerNames.add("download");

			if (conversions.length > 0) {
				headerNames.add("convert-to");
			}

			headerNames.add(StringPool.BLANK);

			searchContainer.setHeaderNames(headerNames);

			if (comparableFileEntry) {
				searchContainer.setRowChecker(new RowChecker(renderResponse, RowChecker.ALIGN, RowChecker.VALIGN, RowChecker.FORM_NAME, null, RowChecker.ROW_IDS));
			}

			int status = StatusConstants.APPROVED;

			if (showNonApprovedDocuments) {
				status = StatusConstants.ANY;
			}

			List results = DLFileVersionLocalServiceUtil.getFileVersions(scopeGroupId, folderId, name, status);
			List resultRows = searchContainer.getResultRows();

			for (int i = 0; i < results.size(); i++) {
				DLFileVersion fileVersion = (DLFileVersion)results.get(i);

				ResultRow row = new ResultRow(new Object[] {fileEntry, fileVersion, conversions, isLocked, hasLock}, String.valueOf(fileVersion.getVersion()), i);

				StringBundler sb = new StringBundler(10);

				sb.append(themeDisplay.getPortalURL());
				sb.append(themeDisplay.getPathContext());
				sb.append("/document/");
				sb.append(themeDisplay.getScopeGroupId());
				sb.append(StringPool.SLASH);
				sb.append(folderId);
				sb.append(StringPool.SLASH);
				sb.append(HttpUtil.encodeURL(title));
				sb.append("?version=");
				sb.append(String.valueOf(fileVersion.getVersion()));

				String rowHREF = sb.toString();

				// Statistics

				row.addText(String.valueOf(fileVersion.getVersion()), rowHREF);
				row.addText(dateFormatDateTime.format(fileVersion.getCreateDate()), rowHREF);
				row.addText(TextFormatter.formatKB(fileVersion.getSize(), locale) + "k", rowHREF);

				// Status

				if (showNonApprovedDocuments) {
					row.addText(LanguageUtil.get(pageContext, (fileVersion.getStatus() == StatusConstants.APPROVED)? "approved" : "not-approved"));
				}

				// Download

				row.addJSP("/html/portlet/document_library/file_version_download.jsp");

				// Convert to

				if (conversions.length > 0) {
					row.addJSP("/html/portlet/document_library/file_version_convert_to.jsp");
				}

				// Action

				row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/html/portlet/document_library/file_version_action.jsp");

				// Add result row

				resultRows.add(row);
			}

			if (comparableFileEntry && !results.isEmpty()) {
				DLFileVersion fileVersion = (DLFileVersion)results.get(0);
			%>

				<portlet:actionURL var="compareVersionsURL">
					<portlet:param name="struts_action" value="/document_library/compare_versions" />
				</portlet:actionURL>

				<aui:form action="<%= compareVersionsURL %>" method="post" name="fm1" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "compare();" %>'>
					<aui:input name="backURL" type="hidden" value="<%= currentURL %>" />
					<aui:input name="fileEntryId" type="hidden" value="<%= fileEntryId %>" />
					<aui:input name="folderId" type="hidden" value="<%= folderId %>" />
					<aui:input name="name" type="hidden" value="<%= name %>" />
					<aui:input name="title" type="hidden" value="<%= title %>" />
					<aui:input name="sourceVersion" type="hidden" value="<%= fileVersion.getVersion() %>" />
					<aui:input name="targetVersion" type="hidden" value="<%= fileEntry.getVersion() %>" />

					<aui:button type="submit" value="compare-versions" />
				</aui:form>

			<%
			}
			%>

			<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" paginate="<%= false %>" />
		</liferay-ui:panel>

		<c:if test="<%= PropsValues.DL_FILE_ENTRY_COMMENTS_ENABLED && DLFileEntryPermission.contains(permissionChecker, fileEntry, ActionKeys.ADD_DISCUSSION) %>">
			<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" persistState="<%= true %>" title='<%= LanguageUtil.get(pageContext, "comments") %>'>
				<portlet:actionURL var="discussionURL">
					<portlet:param name="struts_action" value="/document_library/edit_file_entry_discussion" />
				</portlet:actionURL>

				<liferay-ui:discussion
					className="<%= DLFileEntry.class.getName() %>"
					classPK="<%= fileEntryId %>"
					formAction="<%= discussionURL %>"
					formName="fm2"
					ratingsEnabled="<%= enableCommentRatings %>"
					redirect="<%= currentURL %>"
					subject="<%= fileEntry.getTitle() %>"
					userId="<%= fileEntry.getUserId() %>"
				/>
			</liferay-ui:panel>
		</c:if>
	</liferay-ui:panel-container>
</div>

<aui:script>
	function <portlet:namespace />compare() {
		AUI().use(
			'selector-css3',
			function(A) {
				var rowIds = A.all('input[name=<portlet:namespace />rowIds]:checked');
				var sourceVersion = A.one('input[name="<portlet:namespace />sourceVersion"]');
				var targetVersion = A.one('input[name="<portlet:namespace />targetVersion"]');

				var rowIdsSize = rowIds.size();

				if (rowIdsSize == 1) {
					if (sourceVersion) {
						sourceVersion.val(rowIds.item(0).val());
					}
				}
				else if (rowIdsSize == 2) {
					if (sourceVersion) {
						sourceVersion.val(rowIds.item(1).val());
					}

					if (targetVersion) {
						targetVersion.val(rowIds.item(0).val());
					}
				}

				submitForm(document.<portlet:namespace />fm1);
			}
		);
	}

	function <portlet:namespace />initRowsChecked() {
		var rowIds = AUI().all('input[name=<portlet:namespace />rowIds]');

		rowIds.each(
			function(item, index, collection) {
				if (index >= 2) {
					item.set('checked', false);
				}
			}
		);
	}

	function <portlet:namespace />updateRowsChecked(element) {
		AUI().use(
			'selector-css3',
			function(A) {
				var rowsChecked = A.all('input[name=<portlet:namespace />rowIds]:checked');

				if (rowsChecked.size() > 2) {
					var index = 2;

					if (rowsChecked.item(2).compareTo(element)) {
						index = 1;
					}

					rowsChecked.item(index).set('checked', false);
				}
			}
		);
	}
</aui:script>

<aui:script use="event,node">
	<portlet:namespace />initRowsChecked();

	A.all('input[name=<portlet:namespace />rowIds]').on(
		'click',
		function(event) {
			<portlet:namespace />updateRowsChecked(event.currentTarget);
		}
	);
</aui:script>

<%
DLUtil.addPortletBreadcrumbEntries(fileEntry, request, renderResponse);
%>