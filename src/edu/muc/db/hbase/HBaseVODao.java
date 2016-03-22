package edu.muc.db.hbase;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NavigableMap;
import java.util.Set;

import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.RetriesExhaustedWithDetailsException;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.FirstKeyOnlyFilter;
import org.apache.hadoop.hbase.util.Bytes;


public class HBaseVODao implements VoInter {
	private HTablePool pool;
	private HTable table;

	@Override
	public HBaseVO getVoByTableNameAndRowKey(String tableName, String rowKey) {
		// TODO Auto-generated method stub
		HBaseVO vo = new HBaseVO();
		vo.setTableName(tableName);
		vo.setRowKey(rowKey);
		// 创建valueMap对象
		HashMap<String, HashMap<String, String>> valueMap = new HashMap<String, HashMap<String, String>>();
		try {
			table = new HTable(HBaseCommon.getConfiguration(), tableName);

			/*
			 * 获取所有列族的名称
			 */
			HTableDescriptor descriptor = table.getTableDescriptor();
			Set<byte[]> familyNames = descriptor.getFamiliesKeys();

			/*
			 * 用Get查询
			 */
			Get g = new Get(Bytes.toBytes(rowKey));
			Result result = table.get(g);

			if (!result.isEmpty()) {
				for (byte[] bs : familyNames) {
					HashMap<String, String> columnHashMap = new HashMap<String, String>();
					// 获取一个列族名
					String afamilyName = Bytes.toString(bs);
					// 获取此列族下的内容
					NavigableMap<byte[], byte[]> columnsMap = result
							.getFamilyMap(bs);
					// 获取此列族下的列名集合
					Set<byte[]> columnNameSet = columnsMap.keySet();
					// 将查出来的数据复制到HashMap中
					for (byte[] columnName : columnNameSet) {
						columnHashMap.put(Bytes.toString(columnName),
								Bytes.toString(columnsMap.get(columnName)));
					}

					valueMap.put(afamilyName, columnHashMap);
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Setter
		vo.setValueMap(valueMap);
		return vo;
	}

	@Override
	public boolean saveVO(HBaseVO aVo) {
		// TODO Auto-generated method stub

		/*
		 * 非空检测
		 */
		if (null == aVo) {
			System.out.println("插入对象不可为空！");
			return false;
		}
		/*
		 * 获取aVo的属性值
		 */
		String tableNameString = aVo.getTableName();
		String rowKey = aVo.getRowKey();
		HashMap<String, HashMap<String, String>> valueMap = aVo.getValueMap();

		/*
		 * 构造Put对象
		 */
		pool = new HTablePool(HBaseCommon.getConfiguration(), 1000);
		HTableInterface table = pool.getTable(tableNameString);
		Put put = new Put(rowKey.getBytes());

		/**
		 * 开始put数据
		 */
		// 获取所有的列名
		Set<String> familyNameSet = valueMap.keySet();

		// 遍历列名，获取<Column, value>
		for (String familyNameString : familyNameSet) {

			HashMap<String, String> columnMap = valueMap.get(familyNameString);

			Set<String> columnSet = columnMap.keySet();

			for (String columnNameString : columnSet) {
				String valueString = columnMap.get(columnNameString);
				put.add(Bytes.toBytes(familyNameString),
						Bytes.toBytes(columnNameString),
						Bytes.toBytes(null != valueString ? valueString : ""));
			}
		}
		try {
			table.put(put);
		} catch (RetriesExhaustedWithDetailsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	@Override
	public boolean saveVO(List<HBaseVO> vos) {
		// TODO Auto-generated method stub
		HBaseVODao dao = new HBaseVODao();
		System.out.println("在DAO里开始保存数据;Dao得到的VO数为：" + vos.size());
		for (HBaseVO hBaseVO : vos) {
			dao.saveVO(hBaseVO);

		}

		return true;
	}

	/**
	 * 获取一个表中所有的 VO对象
	 */
	@Override
	public List<HBaseVO> getAllVO(String tableName) {
		// TODO Auto-generated method stub
		List<HBaseVO> vos = null;
		List<String> rowkeysList = this.getAllRowKeysForTable(tableName);
		System.out.println("表中共有" + rowkeysList.size() + "条数据 ");
		vos = this.getVosWhichRowKeyBetween(tableName, rowkeysList.get(0),
				rowkeysList.get(rowkeysList.size() - 1) + "1");
		return vos;
	}

	/**
	 * 获取一个表中的所有RowKey
	 */

	@Override
	public List<String> getAllRowKeysForTable(String tableName) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		if (null == tableName || tableName.equals(null)
				|| tableName.length() <= 0) {
			System.out.println("表名不能为空！");
			return null;
		}
		List<String> rowKeyList = new ArrayList<String>();
		try {
			table = new HTable(HBaseCommon.getConfiguration(),
					tableName.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scan scan = new Scan();
		scan.setFilter(new FirstKeyOnlyFilter());
		ResultScanner scanner = null;
		try {
			scanner = table.getScanner(scan);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] key;
		for (Result rr : scanner) {
			key = rr.getRow();
			rowKeyList.add(new String(key));
		}
		return rowKeyList;

	}

	/**
	 * 获取一个表中某一行中某一列族下某一列的值
	 */
	@Override
	public byte[] getValueOfColumn(String tableName, String rowKey,
			String familyName, String columnName) {
		// TODO Auto-generated method stub
		HBaseVO vo = new HBaseVO();
		vo.setRowKey(rowKey);
		byte[] re = null;
		try {
			table = new HTable(HBaseCommon.getConfiguration(), tableName);
			Get g = new Get(Bytes.toBytes(rowKey));
			Result result = table.get(g);
			List<KeyValue> columnKeyValues = result.getColumn(
					Bytes.toBytes(familyName), Bytes.toBytes(columnName));
			re = columnKeyValues.get(0).getValue();
		} catch (IOException e) {

		}
		return re;

	}

	/**
	 * 获取RowKey从start到 end中的所有的VO对象
	 */
	@Override
	public List<HBaseVO> getVosWhichRowKeyBetween(String tableName,
			String startRowKey, String endRowKey) {
		// TODO Auto-generated method stub
		if (startRowKey.compareTo(endRowKey) > 0) {
			System.out.println("startRowKey必须小于endRowKey");
			return null;
		}

		List<HBaseVO> list = new ArrayList<HBaseVO>();
		if (null == tableName || tableName.equals(null)
				|| tableName.length() <= 0) {
			System.out.println("表名不能为空！");
			return null;
		}
		try {
			table = new HTable(HBaseCommon.getConfiguration(),
					tableName.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scan scan = new Scan();
		scan.setStartRow(Bytes.toBytes(startRowKey));
		scan.setStopRow(Bytes.toBytes(endRowKey));
		ResultScanner scanner = null;
		try {
			scanner = table.getScanner(scan);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HBaseVO vo = null;
		for (Result result : scanner) {

			vo = new HBaseVO();
			// TODO Auto-generated method stub

			vo.setTableName(tableName);
			vo.setRowKey(new String(result.getRow()));
			// 创建valueMap对象
			HashMap<String, HashMap<String, String>> valueMap = new HashMap<String, HashMap<String, String>>();
			try {
				table = new HTable(HBaseCommon.getConfiguration(), tableName);

				/*
				 * 获取所有列族的名称
				 */
				HTableDescriptor descriptor = table.getTableDescriptor();
				Set<byte[]> familyNames = descriptor.getFamiliesKeys();

				/*
				 * 用Get查询
				 */

				if (!result.isEmpty()) {
					for (byte[] bs : familyNames) {
						HashMap<String, String> columnHashMap = new HashMap<String, String>();
						// 获取一个列族名
						String afamilyName = Bytes.toString(bs);
						// 获取此列族下的内容
						NavigableMap<byte[], byte[]> columnsMap = result
								.getFamilyMap(bs);
						Set<byte[]> columnNameSet = columnsMap.keySet();
						for (byte[] columnName : columnNameSet) {
							columnHashMap.put(Bytes.toString(columnName),
									Bytes.toString(columnsMap.get(columnName)));
						}

						valueMap.put(afamilyName, columnHashMap);
					}
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vo.setValueMap(valueMap);

			list.add(vo);

		}

		return list;

	}

	/**
	 * 测试方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * 测试案例
		 */
		// 保存测试

		HBaseVODao dao = new HBaseVODao();
		HBaseVO vo = new HBaseVO();

		vo.setTableName("Architecture");

		vo.setRowKey("fdsaf");

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

		/*
		 * 测试保存
		 */
		// dao.saveVO(vo);

		/*
		 * 测试按RowKey查询
		 */
		HBaseVO aVo = dao.getVoByTableNameAndRowKey("Architecture", "fdsaf");
		System.out.println(aVo);

		List<String> keysList = dao.getAllRowKeysForTable("Architecture");
		for (String string : keysList) {
			System.out.println(string);
		}

		/*
		 * 测试按RowKey范围查询
		 */

		List<HBaseVO> list = dao.getVosWhichRowKeyBetween("Architecture", "a",
				"g");

		System.out.println("++++++++++++++++++++++++==");
		for (HBaseVO avo : list) {
			System.out.println(avo);
		}

		/*
		 * 测试查询所有
		 */

		List<HBaseVO> alllist = dao.getAllVO("Architecture");

		System.out.println("+++++++++++++++++++++fdsafdsafdsa+++==");
		for (HBaseVO avo : alllist) {
			System.out.println(avo);
		}

		/*
		 * 测试获取属性
		 */

		System.out.println(Bytes.toString(dao.getValueOfColumn("Architecture",
				"jxd", "info", "race")));

	}
}
