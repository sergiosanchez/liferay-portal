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

package com.liferay.portlet.softwarecatalog.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.liferay.portlet.softwarecatalog.model.SCProductVersion;
import com.liferay.portlet.softwarecatalog.service.SCProductVersionLocalServiceUtil;

/**
 * The extended model base implementation for the SCProductVersion service. Represents a row in the &quot;SCProductVersion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SCProductVersionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SCProductVersionImpl
 * @see com.liferay.portlet.softwarecatalog.model.SCProductVersion
 * @generated
 */
public abstract class SCProductVersionBaseImpl extends SCProductVersionModelImpl
	implements SCProductVersion {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a s c product version model instance should use the {@link SCProductVersion} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SCProductVersionLocalServiceUtil.addSCProductVersion(this);
		}
		else {
			SCProductVersionLocalServiceUtil.updateSCProductVersion(this);
		}
	}
}