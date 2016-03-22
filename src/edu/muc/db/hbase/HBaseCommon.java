package edu.muc.db.hbase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.util.Bytes;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author 贾晓栋 JDBC辅助类 用于构建数据库连接（采用单例模式）
 */
public class HBaseCommon implements HBaseInterface {

	/**
	 * HBase的配置类，由它在eclipse中配置的HBase信息，包括ip，端口号等 使用类变量，保证单例
	 */
	public static Configuration configuration;
	private static HBaseAdmin admin;

	public static Configuration getConfiguration() {
		return HBaseCommon.configuration;
	}

	/**
	 * 初始化块，主要是配置IP和端口
	 */
	static {
		// 创建对象
		configuration = HBaseConfiguration.create();

		// 配置ZooKeeper
		configuration.set("hbase.zookeeper.property.clientPort", "2181");

		configuration.set("hbase.zookeeper.quorum", "10.10.167.12");

		// 配置Master的ip
		configuration.set("hbase.master", "10.10.167.12:60000");

	}

	/**
	 * 删除一个表
	 */
	@Override
	public boolean dropTable(String tableName) {
		boolean flag = false;
		try {
			admin = new HBaseAdmin(configuration);

			// 首先判断表是否存在
			if (admin.tableExists(tableName)) {
				System.out.println("表已经存在！");
				/*
				 * 开始删除表
				 */
				admin.disableTable(tableName);
				admin.deleteTable(tableName);
				flag = true;
			} else {
				System.out.println("表不存在！");
				flag = false;
			}

		} catch (MasterNotRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * 判断表是否存在
	 * 
	 * @param tableName
	 * @return
	 */

	public static boolean isTableExist(String tableName) {
		boolean flag = false;
		try {
			admin = new HBaseAdmin(configuration);

			// 首先判断表是否存在
			if (admin.tableExists(tableName)) {
				System.out.println("表已经存在！");
				flag = true;
			} else {
				System.out.println("表不存在！");
				flag = false;
			}

		} catch (MasterNotRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	/**
	 * 根据XML来生成表
	 */
	@Override
	public boolean createTableFromXML(File file) {
		// TODO Auto-generated method stub
		// 从XML中获取一个HBaseVO对象
		HBaseVO vo = HBaseCommon.getHBaseVOFromXML(file).get(0);
		// 获取列族列表
		Set<String> familySet = vo.getAllFamilyNames();
		List<String> familyList = new ArrayList<String>();
		for (String familyName : familySet) {
			familyList.add(familyName);
		}
		// 生成表描述对象
		MyTableDescripetor descripetor = new MyTableDescripetor();
		descripetor.setTableName(vo.getTableName());
		descripetor.setFamilyList(familyList);
		// 开始建立表
		this.createTable(descripetor);
		return true;
	}

	/**
	 * 使用一个表描述对象来建表，只建立到列族，支持多列族
	 * 
	 * @param descripeter
	 * @return
	 */
	public boolean createTable(MyTableDescripetor descripeter) {

		try {
			admin = new HBaseAdmin(configuration);

			// 首先判断表是否存在
			if (admin.tableExists(descripeter.getTableName())) {
				System.out.println("表已经存在！");
				return false;
			} else {
				/*
				 * 创建表
				 */
				// 首先创建表描述对象
				HTableDescriptor descriptor = new HTableDescriptor(
						descripeter.getTableName());
				for (int i = 0; i < descripeter.getFamilyList().size(); i++) {
					HColumnDescriptor columnDescriptor = new HColumnDescriptor(
							descripeter.getFamilyList().get(i));
					descriptor.addFamily(columnDescriptor);
				}

				admin.createTable(descriptor);
			}

		} catch (MasterNotRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;

	}

	/**
	 * 测试建表函数，只表名和唯一的列族名
	 * 
	 * @param tableNameString
	 *            表名
	 * @param columnsFamilyString
	 *            列族名
	 * @return
	 */
	public static boolean creatTable(String tableNameString,
			String columnsFamilyString) {

		try {
			admin = new HBaseAdmin(configuration);
			// 首先判断表是否存在
			if (admin.tableExists(tableNameString)) {
				System.out.println("表已经存在！");
				return false;
			} else {
				/*
				 * 创建表
				 */
				// 首先创建表描述对象
				HTableDescriptor descriptor = new HTableDescriptor(
						tableNameString);

				// 创建ＨＢａｓｅ表只要先指定列族就可以了，不用制定到列

				HColumnDescriptor columnDescriptor1 = new HColumnDescriptor(
						columnsFamilyString);
				descriptor.addFamily(columnDescriptor1);

				admin.createTable(descriptor);
			}

		} catch (MasterNotRunningException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	/**
	 * 将一个XML中的数据转化为一个HBaseVO
	 * 
	 * @param file
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List<HBaseVO> getHBaseVOFromXML(File file) {
		System.out.println("开始getHBaseVOFromXML");
		// 创建返回对象
		List<HBaseVO> vos = new ArrayList<HBaseVO>();
		if (file.exists() && file.isFile()) {

			SAXReader reader = new SAXReader();
			Document document;
			try {
				document = reader.read(file);

				// 获取根节点
				Element root = document.getRootElement();

				/*
				 * 获取表名
				 */
				Element tableNameElement = root.element("tableName");
				String tableName = tableNameElement.getText();

				// 获取此文件中的所有数据
				Element dataList = root.element("dataList");

				System.out.println("开始遍历dataList");
				for (Iterator iterator = dataList.elementIterator("data"); iterator
						.hasNext();) {
					Element aData = (Element) iterator.next();
					// 创建一个HBaseVO
					HBaseVO vo = new HBaseVO();
					// 设置表名
					vo.setTableName(tableName);
					// 获取RowKey对象
					Element rowKeyElement = aData.element("rowKey");
					// 设置RowKey
					vo.setRowKey(rowKeyElement.getText());

					/*
					 * 获取并遍历列族
					 */
					HashMap<String, HashMap<String, String>> valueMap = new HashMap<String, HashMap<String, String>>();
					Element familyListElement = aData.element("familyList");
					for (Iterator familyIterator = familyListElement
							.elementIterator("family"); familyIterator
							.hasNext();) {

						Element familyElement = (Element) familyIterator.next();
						String familyName = familyElement
								.attributeValue("name");

						/*
						 * 遍历列名，获取内容
						 */
						HashMap<String, String> columnMap = new HashMap<String, String>();
						for (Iterator qualifierIterator = familyElement
								.elementIterator("qualifier"); qualifierIterator
								.hasNext();) {
							Element qualifierElement = (Element) qualifierIterator
									.next();
							String qualifierName = qualifierElement
									.attributeValue("name");
							Element valueElement = qualifierElement
									.element("value");
							String valueString = valueElement.getText();
							// 拷贝数据，将列名和数值考入
							columnMap.put(qualifierName, valueString);
						}
						// 拷贝数据
						valueMap.put(familyName, columnMap);
					}
					vo.setValueMap(valueMap);
					vos.add(vo);
				}

			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("不是文件！");
			return null;
		}

		return vos;

	}

	/**
	 * 
	 * @param fileNameString
	 *            文件路径
	 * @param createTable
	 *            如果表不存在是否创建表标记
	 * @return 返回是否成功
	 */
	public boolean putDataFromXML(File file, boolean createTable) {
		System.out.println("开始putDataFromXML");
		if (file.exists() && file.isFile()) {
			SAXReader reader = new SAXReader();
			Document document;
			try {
				document = reader.read(file);

				// 获取根节点
				Element root = document.getRootElement();
				Element tableNameElement = root.element("tableName");
				String tableName = tableNameElement.getText();
				if (HBaseCommon.isTableExist(tableName)) {
					// 如果表存在
					// 开始读取数据， 并将数据转化为VO
					System.out.println("开始将XML转化为VO");
					List<HBaseVO> vos = HBaseCommon.getHBaseVOFromXML(file);
					if (null != vos) {
						HBaseVODao dao = new HBaseVODao();
						System.out.println("从XML中得到的VO对象数为" + vos.size());
						dao.saveVO(vos);
					} else {
						System.out.println("得到的VO列表为空！");
						return false;
					}

				} else {
					// 如果表不存在
					/*
					 * 判断是否要建立表，然后进行操作
					 */
					if (createTable == true) {
						/*
						 * 开始创建表
						 */
						this.createTableFromXML(file);
						/*
						 * 添加数据
						 */
						putDataFromXML(file, false);
					} else {
						System.out.println("表不存在，且没有建表");
						return false;
					}
				}
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("不是文件！");
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param fileNameString
	 *            目录路径
	 * @param createTable
	 *            如果表不存在是否创建表标记
	 * @return 返回是否成功
	 */
	public boolean putDataFromDirectory(File file, boolean createTable) {

		boolean flag = false;
		// 判断是否是路径
		if (file.isFile()) {
			flag = putDataFromXML(file, createTable);
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			boolean[] bools = new boolean[files.length];
			flag = true;
			for (int i = 0; i < files.length; i++) {
				if (files[i].isFile()) {
					bools[i] = putDataFromXML(file, createTable);
				} else if (files[i].isDirectory()) {
					// 如果是路径，则递归判段
					bools[i] = putDataFromDirectory(files[i], createTable);
				}
			}
			for (int i = 0; i < files.length; i++) {
				if (bools[i] == false) {
					flag = false;
				}
			}
		}

		return flag;
	}

	/**
	 * 获取一个表中所有列族的名称
	 */
	@SuppressWarnings("resource")
	@Override
	public List<String> getFamilyNamesForTable(String tableName) {
		// TODO Auto-generated method stub
		List<String> familysList = new ArrayList<String>();
		HTable table;
		try {
			table = new HTable(HBaseCommon.getConfiguration(), tableName);
			HTableDescriptor descriptor = table.getTableDescriptor();
			Set<byte[]> familyNames = descriptor.getFamiliesKeys();
			for (byte[] bs : familyNames) {
				familysList.add(Bytes.toString(bs));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return familysList;
	}

	/**
	 * 获取某一个列族下所有列的名称
	 * 
	 * @param tableName
	 * @param familyName
	 * @return
	 */
	@Override
	public List<String> getQualifierForFamily(String tableName,
			String familyName) {
		// TODO Auto-generated method stub
		List<String> qualifierStrings = new ArrayList<String>();
		HBaseVODao dao = new HBaseVODao();
		HBaseVO vo = dao.getVoByTableNameAndRowKey(tableName, dao
				.getAllRowKeysForTable(tableName).get(0));
		Set<String> nameSet = vo.getColumnNamesOfAFamily(familyName);
		for (String string : nameSet) {
			qualifierStrings.add(string);
		}
		return qualifierStrings;

	}

	/**
	 * 获取一个表的XML描述对象
	 * 
	 * @param file
	 * @return
	 */
	@Override
	public Document getXMLDocumentForTable(String tableName) {
		// TODO Auto-generated method stub
		Document document = DocumentHelper.createDocument();
		HBaseVODao dao = new HBaseVODao();
		HBaseVO vo = dao.getVoByTableNameAndRowKey(tableName, dao
				.getAllRowKeysForTable(tableName).get(0));
		List<HBaseVO> vos = new ArrayList<HBaseVO>();
		vos.add(vo);
		document = this.getXMLDocumentForVOs(vos);
		return document;

	}

	/**
	 * 获取一个HBaseVO的XML描述对象
	 * 
	 * @param vo
	 * @return
	 */
	/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * 郭朋：调用这里的这个函数来将用户自己构建的表结构生成一个document对象，
	 * 将root下的节点挂载到总的服务描述xml中
	 */
	@Override
	public Document getXMLDocumentForVOs(List<HBaseVO> vos) {
		// TODO Auto-generated method stub
		System.out.println("2++++++++++++++++++++++++++++++++++++");
		Document document = DocumentHelper.createDocument();
		System.out.println("3++++++++++++++++++++++++++++++++++++");
		// 生成根节点tableStructure
		Element rootElement = document.addElement("root");
		System.out.println("4++++++++++++++++++++++++++++++++++++");
		// 设置tableName节点
		Element tableNameElement = rootElement.addElement("tableName");
		System.out.println("5++++++++++++++++++++++++++++++++++++");
		System.out.println(vos.get(0).getTableName());
		System.out.println("5.1++++++++++++++++++++++++++++++++++++");
		tableNameElement.setText(vos.get(0).getTableName());
		System.out.println("6++++++++++++++++++++++++++++++++++++");

		// 生成数据列表
		Element dataListElement = rootElement.addElement("dataList");
		System.out.println("7++++++++++++++++++++++++++++++++++++");
		for (int i = 0; i < vos.size(); i++) {
			/**
			 * 对每一个VO元素生成一个Data
			 */
			System.out.println("8++++++++++++++++++++++++++++++++++++");
			HBaseVO vo = vos.get(i);
			Element dataElement = dataListElement.addElement("data");
			Element rowKeyElement = dataElement.addElement("rowKey");
			// 设置RowKey
			rowKeyElement.setText(vo.getRowKey());
			// 开始遍历FamilyList
			Element familyListElement = dataElement.addElement("familyList");
			Set<String> familyNameSet = vo.getAllFamilyNames();
			HashMap<String, HashMap<String, String>> valueMap = vo
					.getValueMap();
			for (String familyName : familyNameSet) {
				Element familyElement = familyListElement.addElement("family");
				familyElement.addAttribute("name", familyName);
				HashMap<String, String> columnMap = valueMap.get(familyName);
				Set<String> columnNameSet = columnMap.keySet();
				for (String columnName : columnNameSet) {
					Element qualifierElement = familyElement
							.addElement("qualifier");
					qualifierElement.addAttribute("name", columnName);
					Element valueElement = qualifierElement.addElement("value");
					valueElement.setText(columnMap.get(columnName));

				}
			}
		}
		/**
		 * 写出测试
		 * 
		 * OutputStream os; try { os = new FileOutputStream("D:" +
		 * File.separator + "SqlMapConfig.xml"); XMLWriter writer = new
		 * XMLWriter(os, OutputFormat.createPrettyPrint());
		 * 
		 * writer.write(document); writer.close(); } catch
		 * (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (UnsupportedEncodingException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		return document;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public HashMap<String, String> getDescribetionForTableFromXML(File file) {
		// TODO Auto-generated method stub
		HashMap<String, String> columnNameMap = new HashMap<String, String>();
		if (file.exists() && file.isFile()) {
			SAXReader reader = new SAXReader();
			Document document;
			try {
				document = reader.read(file);

				// 获取根节点
				Element root = document.getRootElement();

				/*
				 * 获取表名
				 */
				Element tableNameElement = root.element("tableName");
				String tableName = tableNameElement.getText();
				String tableNameDesc = tableNameElement
						.attributeValue("describetion");
				columnNameMap.put(tableName, tableNameDesc);

				// 获取此文件中的所有数据
				Element dataList = root.element("dataList");

				System.out.println("开始遍历dataList");
				for (Iterator iterator = dataList.elementIterator("data"); iterator
						.hasNext();) {
					Element aData = (Element) iterator.next();
					// 创建一个HBaseVO
					HBaseVO vo = new HBaseVO();
					// 设置表名
					vo.setTableName(tableName);
					// 获取RowKey对象
					Element rowKeyElement = aData.element("rowKey");
					// 设置RowKey
					vo.setRowKey(rowKeyElement.getText());

					/*
					 * 获取并遍历列族
					 */
					HashMap<String, HashMap<String, String>> valueMap = new HashMap<String, HashMap<String, String>>();
					Element familyListElement = aData.element("familyList");
					for (Iterator familyIterator = familyListElement
							.elementIterator("family"); familyIterator
							.hasNext();) {

						Element familyElement = (Element) familyIterator.next();
						String familyName = familyElement
								.attributeValue("name");
						String familyNameDesc = familyElement
								.attributeValue("describetion");
						columnNameMap.put(tableName + "=" + familyName,
								familyNameDesc);

						/*
						 * 遍历列名，获取内容
						 */
						HashMap<String, String> columnMap = new HashMap<String, String>();
						for (Iterator qualifierIterator = familyElement
								.elementIterator("qualifier"); qualifierIterator
								.hasNext();) {
							Element qualifierElement = (Element) qualifierIterator
									.next();
							String qualifierName = qualifierElement
									.attributeValue("name");
							String qualifierNameDesc = qualifierElement
									.attributeValue("describetion");
							columnNameMap.put(tableName + "=" + familyName
									+ "=" + qualifierName, qualifierNameDesc);
							Element valueElement = qualifierElement
									.element("value");
							String valueString = valueElement.getText();
							// 拷贝数据，将列名和数值考入
							columnMap.put(qualifierName, valueString);
						}
						// 拷贝数据
						valueMap.put(familyName, columnMap);
					}
					vo.setValueMap(valueMap);
				}

			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("不是文件！");
			return null;
		}

		return columnNameMap;

	}
}
