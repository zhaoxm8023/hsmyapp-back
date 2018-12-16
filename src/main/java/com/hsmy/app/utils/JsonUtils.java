package com.hsmy.app.utils;

import java.io.IOException;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonUtils {

	@SuppressWarnings("unchecked")
	public static final Map<String, Object> decode(String jsonString) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(jsonString, Map.class);
		} catch (IOException e) {
			throw new RuntimeException("JSON解析失败", e);
		}
	}

	/**
	 * 序列化
	 */
	public static String toJSONString(Object entity) {
		return JSON.toJSONString(entity);
	}

	/**
	 * 反序列化
	 */
	public static <T> T toObject(String json, Class<T> c) {
		return JSON.parseObject(json, c);
	}
}
