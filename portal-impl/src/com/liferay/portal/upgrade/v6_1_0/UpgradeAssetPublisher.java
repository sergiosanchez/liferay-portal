/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.liferay.portal.upgrade.v6_1_0;

import com.liferay.portal.kernel.upgrade.BaseUpgradePortletPreferences;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;

import javax.portlet.PortletPreferences;
public class UpgradeAssetPublisher extends BaseUpgradePortletPreferences {

	@Override
	protected String[] getPortletIds() {
		return new String[] {"101_INSTANCE_%"};
	}

	@Override
	protected String upgradePreferences(
			long companyId, long ownerId, int ownerType, long plid,
			String portletId, String xml)
		throws Exception {

		PortletPreferences portletPreferences =
			PortletPreferencesFactoryUtil.fromXML(
				companyId, ownerId, ownerType, plid, portletId, xml);

		String classNameIds = portletPreferences.getValue("classNameIds", null);

		if (Validator.isNotNull(classNameIds)) {
			long igClassNameId = PortalUtil.getClassNameId(
				"com.liferay.portlet.imagegallery.model.IGImage");

			long dlClassNameId = PortalUtil.getClassNameId(
				DLFileEntry.class.getName());

			if (classNameIds.indexOf(String.valueOf(igClassNameId)) != -1) {
				classNameIds = classNameIds.replace(
					String.valueOf(igClassNameId),
					String.valueOf(dlClassNameId));

				portletPreferences.setValue("classNameIds", classNameIds);
			}
		}

		return PortletPreferencesFactoryUtil.toXML(portletPreferences);
	}

}