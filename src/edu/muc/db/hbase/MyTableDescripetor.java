package edu.muc.db.hbase;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Shimon 描述表对象的实体类
 *
 */
public class MyTableDescripetor {

	/*
	 * 属性
	 */

	// 表名
	private String tableName;

	// 列族列表
	private List<String> familyList;

	// 列限定词Table
	/*
	 * 其中 HashMap中， String为列名，List<String>为此列下的qualifier
	 */
	private HashMap<String, List<String>> qualifiers;

	/*
	 * 构造方法
	 */

	public MyTableDescripetor(String tableName, List<String> familyList,
			HashMap<String, List<String>> qualifiers) {
		super();
		this.tableName = tableName;
		this.familyList = familyList;
		this.qualifiers = qualifiers;
	}

	public MyTableDescripetor() {
	}

	/*
	 * Getters & Setters
	 */
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<String> getFamilyList() {
		return familyList;
	}

	public void setFamilyList(List<String> familyList) {
		this.familyList = familyList;
	}

	public HashMap<String, List<String>> getQualifiers() {
		return qualifiers;
	}

	public void setQualifiers(HashMap<String, List<String>> qualifiers) {
		this.qualifiers = qualifiers;
	}

}
