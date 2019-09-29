package com.memorize.conf;

class DataSourceWrapper {

	private final String DATASOURCE_NAME;
	private String stringPattern = "ds.%s.%s";

	DataSourceWrapper(String datasourceName) {
		this.DATASOURCE_NAME = datasourceName;
	}

	String getStringUserValue() {
		return buildStringPropertyKey("user");
	}

	String getStringPasswordValue() {
		return buildStringPropertyKey("pass");
	}

	String getStringUrlValue() {
		return  buildStringPropertyKey("url");
	}

	String getStringDriverValue() {
		return buildStringPropertyKey("driver");
	}

	String getStringDialectValue() {
		return buildStringPropertyKey("dialect");
	}

	private String buildStringPropertyKey(String PropertyName) {
		return String.format(stringPattern, DATASOURCE_NAME, PropertyName);
	}
}
