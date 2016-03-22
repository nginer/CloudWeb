package edu.muc.db.hbase;

import java.util.List;

public interface VoInter {

	/*
	 * 通过RowKey获取一个HBaseVO
	 */
	public HBaseVO getVoByTableNameAndRowKey(String tableName, String rowKey);

	/*
	 * 保存一个HBaseVO到HBase中
	 */
	public boolean saveVO(HBaseVO aVo);

	/*
	 * 保存HBaseVOs到HBase中
	 */
	public boolean saveVO(List<HBaseVO> vos);

	/*
	 * 获取所有的HBaseVO
	 */
	public List<HBaseVO> getAllVO(String tableName);

	/*
	 * 获取一个表的所有Rowkey
	 */
	public List<String> getAllRowKeysForTable(String tableName);

	/*
	 * 获取某个表中某一行某一列的内容
	 */

	public byte[] getValueOfColumn(String tableName, String rowKey,
			String familyName, String columnName);

	/*
	 * 获取RowKey介于StartRowKey和EndRowKey中的所有HBaseVO
	 */
	public List<HBaseVO> getVosWhichRowKeyBetween(String tableName,
			String startRowKey, String endRowKey);

}
