package com.appcode.db;

import com.appcode.code.model.Code;

import java.util.ArrayList;
import java.util.List;

public class CodeManager {
	public static final int CATEGORY_UI = 1;
	public static final int CATEGORY_SQLITE = 2;
	public static final int CATEGORY_NET = 3;

	public static List<Code> getCodeByCategory(int category) {
		switch (category) {
			case CATEGORY_UI:
				return getUICode();
			case CATEGORY_SQLITE:
				return getSQLiteCode();
			case CATEGORY_NET:
				return getNetCode();
			default:
				return null;
		}
	}

	public static List<Code> getUICode() {
		List<Code> codes = new ArrayList<>();
		codes.add(new Code(1, "MaterialDesignLibrary", "https://github.com/navasmdc/MaterialDesignLibrary"));
		codes.add(new Code(3, "AndroidFillableLoaders", "https://github.com/JorgeCastilloPrz/AndroidFillableLoaders"));
		codes.add(new Code(3, "Android基础", "android"));
		codes.add(new Code(3, "Android基础", "android"));
		codes.add(new Code(3, "Android基础", "android"));
		return codes;
	}

	public static List<Code> getSQLiteCode() {
		List<Code> codes = new ArrayList<>();
		codes.add(new Code(3, "GreenDao", "android"));
		codes.add(new Code(3, "OrmLite", "android"));
		codes.add(new Code(3, "Room", "android"));
		return codes;
	}

	public static List<Code> getNetCode() {
		List<Code> codes = new ArrayList<>();
		codes.add(new Code(3, "OkHttp", "android"));
		codes.add(new Code(3, "Volley", "android"));
		codes.add(new Code(3, "Retrofit", "android"));
		return codes;
	}

}
