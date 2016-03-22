package edu.muc.db.hbase;

import java.util.HashMap;
import java.util.Set;

/**
 * 用来描述对象
 * 
 * @author Shimon
 *
 */
public class HBaseVO {

	// 表名
	private String tableName;

	// RowKey
	private String rowKey;

	// 所有的属性 familyName columnName value
	private HashMap<String, HashMap<String, String>> valueMap;

	/*
	 * 构造方法
	 */

	public HBaseVO() {
		super();
	}

	/**
	 * @param tableName
	 * @param rowKey
	 * @param valueMap
	 */
	public HBaseVO(String tableName, String rowKey,
			HashMap<String, HashMap<String, String>> valueMap) {
		super();
		this.tableName = tableName;
		this.rowKey = rowKey;
		this.valueMap = valueMap;
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

	public String getRowKey() {
		return rowKey;
	}

	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}

	public HashMap<String, HashMap<String, String>> getValueMap() {
		return valueMap;
	}

	public void setValueMap(HashMap<String, HashMap<String, String>> valueMap) {
		this.valueMap = valueMap;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		// 构造StringBuilder
		StringBuilder temp = new StringBuilder();
		// 添加RowKey
		temp.append("---------------\n" + this.rowKey + "\n");

		// 获取所有的列名
		Set<String> familyNameSet = valueMap.keySet();

		// 遍历列名，获取<Column, value>
		for (String familyNameString : familyNameSet) {

			HashMap<String, String> columnMap = valueMap.get(familyNameString);

			Set<String> columnSet = columnMap.keySet();
			temp.append(familyNameString + "\n");

			for (String columnNameString : columnSet) {
				String valueString = columnMap.get(columnNameString);
				temp.append("\t" + columnNameString + "=" + valueString + "\n");
			}
		}

		return temp.toString();
	}

	/**
	 * 获取所有的列族
	 * 
	 * @return
	 */
	public Set<String> getAllFamilyNames() {
		Set<String> familyNameSet = valueMap.keySet();
		return familyNameSet;
	}

	/**
	 * 获取某一个列族下的所有列名
	 * 
	 * @param args
	 */

	public Set<String> getColumnNamesOfAFamily(String familyName) {
		HashMap<String, String> columnMap = valueMap.get(familyName);
		Set<String> columnSet = null;
		if (null != columnMap) {
			columnSet = columnMap.keySet();
		}
		return columnSet;
	}

	public static void main(String[] args) {
		HBaseVO vo = new HBaseVO();

		vo.setTableName("Architecture");

		vo.setRowKey("jxd");

		HashMap<String, HashMap<String, String>> infoFamily = new HashMap<String, HashMap<String, String>>();
		HashMap<String, String> raceHashMap = new HashMap<String, String>();
		raceHashMap.put("race", "hanzu");
		raceHashMap.put("village", "黑土口村");
		infoFamily.put("info", raceHashMap);
		vo.setValueMap(infoFamily);

		HashMap<String, String> textHashMap = new HashMap<String, String>();
		textHashMap.put("text", "111");
		textHashMap.put("video", "111222");
		infoFamily.put("craft", textHashMap);

		System.out.println(vo);
	}
}
