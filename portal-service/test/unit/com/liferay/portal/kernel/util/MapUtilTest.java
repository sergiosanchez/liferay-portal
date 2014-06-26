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

package com.liferay.portal.kernel.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * @author Sampsa Sohlman
 * @author Manuel de la Peña
 */
@RunWith(Enclosed.class)
public class MapUtilTest {

	public static class WhenCreatingALinkedHashMapFromArray {

		@Test
		public void testDelimiterCustom() throws Exception {
			Map<String, String> map = MapUtil.toLinkedHashMap(
				new String[] {"one,1"}, ",");

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue("1"));
		}

		@Test
		public void testDelimiterDefault() throws Exception {
			Map<String, String> map = MapUtil.toLinkedHashMap(
				new String[] {"one:1"});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue("1"));
		}

		@Test
		public void testParamsInvalid() throws Exception {
			Map<String, Object> map = MapUtil.toLinkedHashMap(
				new String[] {"one"});

			Assert.assertTrue(map.isEmpty());

			map = MapUtil.toLinkedHashMap(new String[] {"one:two:three:four"});

			Assert.assertTrue(map.isEmpty());
		}

		@Test
		public void testParamsNull() throws Exception {
			Map<String, Object> map = MapUtil.toLinkedHashMap(null);

			Assert.assertTrue(map.isEmpty());
		}

		@Test
		public void testParamsTypeBoolean() throws Exception {
			Map<String, Object> map = MapUtil.toLinkedHashMap(
				new String[] {"one:true:boolean"});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue(true));
			Assert.assertTrue(map.get("one") instanceof Boolean);

			map = MapUtil.toLinkedHashMap(
				new String[] {"one:true:" + Boolean.class.getName()});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue(true));
			Assert.assertTrue(map.get("one") instanceof Boolean);
		}

		@Test
		public void testParamsTypeBooleanInvalidValue() throws Exception {
			Map<String, Object> map = MapUtil.toLinkedHashMap(
				new String[] {"one:foo:boolean"});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue(false));
			Assert.assertTrue(map.get("one") instanceof Boolean);

			map = MapUtil.toLinkedHashMap(
				new String[] {"one:foo:" + Boolean.class.getName()});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue(false));
			Assert.assertTrue(map.get("one") instanceof Boolean);
		}

		@Test
		public void testParamsTypeComposite() throws Exception {
			Map<String, Object> map = MapUtil.toLinkedHashMap(
				new String[] {"one:1:" + Byte.class.getName()});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue((byte)1));
			Assert.assertTrue(map.get("one") instanceof Byte);

			map = MapUtil.toLinkedHashMap(
				new String[] {"one:1:" + Float.class.getName()});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue((float)1));
			Assert.assertTrue(map.get("one") instanceof Float);

			map = MapUtil.toLinkedHashMap(
				new String[] {"one:1:" + Object.class.getName()});

			Assert.assertEquals(0, map.size());
		}

		@Test
		public void testParamsTypeDouble() throws Exception {
			Map<String, Object> map = MapUtil.toLinkedHashMap(
				new String[] {"one:1.0:double"});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue(1.0d));
			Assert.assertTrue(map.get("one") instanceof Double);

			map = MapUtil.toLinkedHashMap(
				new String[] {"one:1.0:" + Double.class.getName()});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue(1.0d));
			Assert.assertTrue(map.get("one") instanceof Double);
		}

		@Test(expected = NumberFormatException.class)
		public void testParamsTypeDoubleInvalidCompositeValue()
			throws Exception {

			MapUtil.toLinkedHashMap(
				new String[] {"one:foo:" + Double.class.getName()});

			Assert.fail();
		}

		@Test(expected = NumberFormatException.class)
		public void testParamsTypeDoubleInvalidValue() throws Exception {
			MapUtil.toLinkedHashMap(new String[]{"one:foo:double"});

			Assert.fail();
		}

		@Test
		public void testParamsTypeInteger() throws Exception {
			Map<String, Object> map = MapUtil.toLinkedHashMap(
				new String[] {"one:1:int"});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue(1));
			Assert.assertTrue(map.get("one") instanceof Integer);

			map = MapUtil.toLinkedHashMap(
				new String[] {"one:1:" + Integer.class.getName()});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue(1));
			Assert.assertTrue(map.get("one") instanceof Integer);
		}

		@Test(expected = NumberFormatException.class)
		public void testParamsTypeIntegerInvalidCompositeValue()
			throws Exception {

			MapUtil.toLinkedHashMap(
				new String[] {"one:foo:" + Integer.class.getName()});

			Assert.fail();
		}

		@Test(expected = NumberFormatException.class)
		public void testParamsTypeIntegerInvalidValue() throws Exception {
			MapUtil.toLinkedHashMap(new String[]{"one:foo:int"});

			Assert.fail();
		}

		@Test
		public void testParamsTypeLong() throws Exception {
			Map<String, Object> map = MapUtil.toLinkedHashMap(
				new String[] {"one:1:long"});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue(1l));
			Assert.assertTrue(map.get("one") instanceof Long);

			map = MapUtil.toLinkedHashMap(
				new String[] {"one:1:" + Long.class.getName()});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue(1l));
			Assert.assertTrue(map.get("one") instanceof Long);
		}

		@Test(expected = NumberFormatException.class)
		public void testParamsTypeLongInvalidCompositeValue()
			throws Exception {

			MapUtil.toLinkedHashMap(
				new String[] {"one:foo:" + Long.class.getName()});

			Assert.fail();
		}

		@Test(expected = NumberFormatException.class)
		public void testParamsTypeLongInvalidValue() throws Exception {
			MapUtil.toLinkedHashMap(new String[]{"one:foo:long"});

			Assert.fail();
		}

		@Test
		public void testParamsTypeShort() throws Exception {
			Map<String, Object> map = MapUtil.toLinkedHashMap(
				new String[] {"one:1:short"});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue((short)1));
			Assert.assertTrue(map.get("one") instanceof Short);

			map = MapUtil.toLinkedHashMap(
				new String[] {"one:1:" + Short.class.getName()});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue((short)1));
			Assert.assertTrue(map.get("one") instanceof Short);
		}

		@Test(expected = NumberFormatException.class)
		public void testParamsTypeShortInvalidCompositeValue()
			throws Exception {

			MapUtil.toLinkedHashMap(
				new String[] {"one:foo:" + Short.class.getName()});

			Assert.fail();
		}

		@Test(expected = NumberFormatException.class)
		public void testParamsTypeShortInvalidValue() throws Exception {
			MapUtil.toLinkedHashMap(new String[]{"one:foo:short"});

			Assert.fail();
		}

		@Test
		public void testParamsTypeString() throws Exception {
			Map<String, Object> map = MapUtil.toLinkedHashMap(
				new String[] {"one:X:" + String.class.getName()});

			Assert.assertEquals(1, map.size());
			Assert.assertTrue(map.containsKey("one"));
			Assert.assertTrue(map.containsValue("X"));
			Assert.assertTrue(map.get("one") instanceof String);
		}

		@Test
		public void testParamsZeroLength() throws Exception {
			Map<String, String> map = MapUtil.toLinkedHashMap(new String[0]);

			Assert.assertTrue(map.isEmpty());
		}

	}

	public static class WhenCreatingAMapFromArray {

		@Test
		public void testSucceed() {
			String[] array = new String[] {
				PropsKeys.MESSAGE_BOARDS_EMAIL_FROM_ADDRESS,
				PropsKeys.ADMIN_EMAIL_FROM_ADDRESS,
				PropsKeys.MESSAGE_BOARDS_EMAIL_FROM_NAME,
				PropsKeys.ADMIN_EMAIL_FROM_NAME, "allowAnonymousPosting",
				PropsKeys.MESSAGE_BOARDS_ANONYMOUS_POSTING_ENABLED,
				"emailFromAddress", PropsKeys.MESSAGE_BOARDS_EMAIL_FROM_ADDRESS,
				"emailFromName", PropsKeys.MESSAGE_BOARDS_EMAIL_FROM_NAME,
				"emailHtmlFormat", PropsKeys.MESSAGE_BOARDS_EMAIL_HTML_FORMAT,
				"emailMessageAddedEnabled",
				PropsKeys.MESSAGE_BOARDS_EMAIL_MESSAGE_ADDED_ENABLED,
				"emailMessageUpdatedEnabled",
				PropsKeys.MESSAGE_BOARDS_EMAIL_MESSAGE_UPDATED_ENABLED,
				"enableFlags", PropsKeys.MESSAGE_BOARDS_FLAGS_ENABLED,
				"enableRatings", PropsKeys.MESSAGE_BOARDS_RATINGS_ENABLED,
				"enableRss", PropsKeys.MESSAGE_BOARDS_RSS_ENABLED,
				"messageFormat",
				PropsKeys.MESSAGE_BOARDS_MESSAGE_FORMATS_DEFAULT, "priorities",
				PropsKeys.MESSAGE_BOARDS_THREAD_PRIORITIES, "ranks",
				PropsKeys.MESSAGE_BOARDS_USER_RANKS, "recentPostsDateOffset",
				PropsKeys.MESSAGE_BOARDS_RECENT_POSTS_DATE_OFFSET, "rssDelta",
				PropsKeys.SEARCH_CONTAINER_PAGE_DEFAULT_DELTA,
				"rssDisplayStyle", PropsKeys.RSS_FEED_DISPLAY_STYLE_DEFAULT,
				"rssFeedType", PropsKeys.RSS_FEED_TYPE_DEFAULT,
				"subscribeByDefault",
				PropsKeys.MESSAGE_BOARDS_SUBSCRIBE_BY_DEFAULT};

			Map<String, String> map = MapUtil.fromArray(array);

			Assert.assertNotNull(map);

			for (int i = 0; i < array.length; i += 2) {
				Assert.assertEquals(array[i + 1], map.get(array[i]));
			}
		}

		@Test
		public void testWithOddLength() {
			try {
				MapUtil.fromArray(new String[] {"one", "two", "three"});

				Assert.fail();
			}
			catch (IllegalArgumentException iae) {
				Assert.assertEquals(
					"Array length is not an even number", iae.getMessage());
			}
		}

		@Test
		public void testWithZeroLength() {
			Map<String, String> map = MapUtil.fromArray(new String[] {});

			Assert.assertTrue(map.isEmpty());
		}

	}

	public static class WhenFilteringByPredicateFilter {

		@Test
		public void testSuceed() throws Exception {
			Map<String, String> inputMap = new HashMap<String, String>();

			inputMap.put("1", "one");
			inputMap.put("2", "two");
			inputMap.put("3", "three");
			inputMap.put("4", "four");
			inputMap.put("5", "five");

			Map<String, String> outputMap = MapUtil.filter(
				inputMap, new HashMap<String, String>(),
				new PredicateFilter<String>() {

					@Override
					public boolean filter(String string) {
						int value = GetterUtil.getInteger(string);

						if ((value % 2) == 0) {
							return true;
						}

						return false;
					}

				});

			Assert.assertEquals(2, outputMap.size());
			Assert.assertEquals("two", outputMap.get("2"));
			Assert.assertEquals("four", outputMap.get("4"));
		}

		@Test
		public void testWithPrefix() throws Exception {
			Map<String, String> inputMap = new HashMap<String, String>();

			inputMap.put("x1", "one");
			inputMap.put("2", "two");
			inputMap.put("x3", "three");
			inputMap.put("4", "four");
			inputMap.put("x5", "five");

			Map<String, String> outputMap = MapUtil.filter(
				inputMap, new HashMap<String, String>(),
				new PrefixPredicateFilter("x"));

			Assert.assertEquals(2, outputMap.size());
			Assert.assertEquals("two", outputMap.get("2"));
			Assert.assertEquals("four", outputMap.get("4"));
		}

	}

}