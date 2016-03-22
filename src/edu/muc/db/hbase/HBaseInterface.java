package edu.muc.db.hbase;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;

public interface HBaseInterface {

	/**
	 * 删除一个表
	 */

	public boolean dropTable(String tableName);

	/**
	 * 获取一个表中所有列族的名称
	 */
	public List<String> getFamilyNamesForTable(String tableName);

	/**
	 * 获取某一个列族下所有列的名称
	 * 
	 * @param tableName
	 * @param familyName
	 * @return
	 */
	public List<String> getQualifierForFamily(String tableName,
			String familyName);

	/**
	 * 用XML对象来创建表
	 * 
	 * @param file
	 * @return
	 */
	public boolean createTableFromXML(File file);

	/**
	 * 获取一个XML描述表中的列描述信息
	 */

	public HashMap<String, String> getDescribetionForTableFromXML(File file);

	/**
	 * 获取一个表的XML描述对象
	 * 
	 * @param file
	 * @return
	 */
	public Document getXMLDocumentForTable(String tableName);

	/**
	 * 获取一个HBaseVO的XML描述对象
	 * 
	 * @param vo
	 * @return
	 */
	public Document getXMLDocumentForVOs(List<HBaseVO> vos);

}
