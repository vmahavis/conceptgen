package edu.umich.med.transmart.db;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Vector;


public class JDBCExecuter
{

	public Vector distinct = new Vector();
	private String url;
	private String username;
	private String passwd;
	private String driver;

	public JDBCExecuter()
	{
		ResourceBundle db = ResourceBundle.getBundle("edu.umich.med.transmart.resource.bundle.database");
		this.url = db.getString("url");
		this.username = db.getString("username");
		this.passwd = db.getString("passwd");
		this.driver = db.getString("driver");
	}

	public JDBCExecuter(String url, String driver, String username, String passwd)
	{
		this.url = url;
		this.username = username;
		this.passwd = passwd;
		this.driver = driver;
	}
	
	public ArrayList select(String query) throws SQLException
	{

		ArrayList resultList = new ArrayList();
		ArrayList recordList = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		ResultSetMetaData rmd = null;
		String value = "";

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, passwd);
			statement = connection.createStatement();
			result = statement.executeQuery(query);
			rmd = (ResultSetMetaData) result.getMetaData();
			int columnCount = rmd.getColumnCount();


			while (result.next())
			{
				recordList = new ArrayList();
				for (int i = 1; i <= columnCount; i++)
				{
					value = result.getString(i);
					if (value == null)
					{
						value = "";
					}
					else
					{
						value = value.trim();
					}
					recordList.add(value);
				}
				resultList.add(recordList);
			}
			result.close();
			result = null;
			statement.close();
			statement = null;
			connection.close();
			connection = null;

		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{

			if (result != null)
			{
				try
				{
					result.close();
				}
				catch (SQLException e)
				{
					System.out.println(e);
				}
				result = null;
			}
			if (statement != null)
			{
				try
				{
					statement.close();
				}
				catch (SQLException e)
				{
					System.out.println(e);
				}
				statement = null;
			}
			if (connection != null)
			{
				try
				{
					connection.close();
				}
				catch (SQLException e)
				{
					System.out.println(e);
				}
				connection = null;
			}

		}
		return resultList;
	}


	public ArrayList selectSingleList(String query) throws SQLException
	{

		ArrayList resultList = new ArrayList();
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		String value = "";

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, passwd);
			statement = connection.createStatement();
			result = statement.executeQuery(query);

			while (result.next())
			{
				value = result.getString(1);
				resultList.add(value);
			}
			result.close();
			result = null;
			statement.close();
			statement = null;
			connection.close();
			connection = null;

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{

			if (result != null)
			{
				try
				{
					result.close();
				}
				catch (SQLException e)
				{
					System.out.println(e);
				}
				result = null;
			}
			if (statement != null)
			{
				try
				{
					statement.close();
				}
				catch (SQLException e)
				{
					System.out.println(e);
				}
				statement = null;
			}
			if (connection != null)
			{
				try
				{
					connection.close();
				}
				catch (SQLException e)
				{
					System.out.println(e);
				}
				connection = null;
			}

		}
		return resultList;
	}
	
	public String selectSingleValue(String query) throws SQLException
	{
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		String value = "";

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, passwd);
			statement = connection.createStatement();
			result = statement.executeQuery(query);

			while (result.next())
			{
				value = result.getString(1);
			}
			result.close();
			result = null;
			statement.close();
			statement = null;

		} catch (Exception e)
		{
			System.out.println(e);
		} finally
		{
			if (statement != null)
			{
				try
				{
					statement.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				statement = null;
			}
			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				connection = null;
			}
		}
		return value;
	}

	public HashMap hashResult(String query) throws SQLException
	{

		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;

		String key = "";
		String val = "";

		HashMap hashedList = new HashMap();

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, passwd);
			statement = connection.createStatement();
			result = statement.executeQuery(query);

			while (result.next())
			{
				key = String.valueOf(result.getInt(1));
				val = result.getString(2);
				hashedList.put(key, val);
			}

			result.close();
			result = null;
			statement.close();
			statement = null;

		} catch (Exception e)
		{
			System.out.println(e);
		} finally
		{
			if (statement != null)
			{
				try
				{
					statement.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				statement = null;
			}
			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				connection = null;
			}
		}

		return hashedList;
	}

	public HashMap dbHashing(String query) throws SQLException
	{

		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;

		String key = "";
		String val = "";

		HashMap hashedList = new HashMap();
		HashMap value = new HashMap();

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, passwd);
			statement = connection.createStatement();
			result = statement.executeQuery(query);

			while (result.next())
			{
				key = result.getString(1);
				val = result.getString(2);

				if (hashedList.containsKey(key))
				{
					value = (HashMap) hashedList.get(key);
					value.put(val, val);
				} else
				{
					value = new HashMap();
					value.put(val, val);
					distinct.add(key);
				}
				hashedList.put(key, value);
			}

			result.close();
			result = null;
			statement.close();
			statement = null;

		} catch (Exception e)
		{
			System.out.println(e);
		} finally
		{
			if (statement != null)
			{
				try
				{
					statement.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				statement = null;
			}
			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				connection = null;
			}
		}

		return hashedList;
	}

	public HashMap vectorMap(String query) throws SQLException
	{

		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;

		String key = "";
		String val = "";

		HashMap hashedList = new HashMap();
		Vector value = new Vector();

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, passwd);
			statement = connection.createStatement();
			result = statement.executeQuery(query);

			while (result.next())
			{
				key = result.getString(1);
				val = result.getString(2);

				if (hashedList.containsKey(key))
				{
					value = (Vector) hashedList.get(key);
					value.add(val);
				} else
				{
					value = new Vector();
					value.add(val);
					distinct.add(key);
				}
				hashedList.put(key, value);
			}

			result.close();
			result = null;
			statement.close();
			statement = null;

		} catch (Exception e)
		{
			System.out.println(e);
		} finally
		{
			if (statement != null)
			{
				try
				{
					statement.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				statement = null;
			}
			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				connection = null;
			}
		}

		return hashedList;
	}

	public HashMap dbDoubleHashing(String query) throws SQLException
	{

		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		String key = "";
		String val1 = "";
		String val2 = "";
		HashMap doubleHash = new HashMap();
		HashMap hashedList1 = new HashMap();
		HashMap hashedList2 = new HashMap();

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, passwd);
			statement = connection.createStatement();
			result = statement.executeQuery(query);

			while (result.next())
			{
				key = result.getString(1);
				val1 = result.getString(2);
				val2 = result.getString(3);

				hashedList1.put(key, val1);
				hashedList2.put(key, val2);
			}

			result.close();
			result = null;
			statement.close();
			statement = null;

		} catch (Exception e)
		{
			System.out.println(e);
		} finally
		{
			if (statement != null)
			{
				try
				{
					statement.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				statement = null;
			}
			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				connection = null;
			}
		}
		doubleHash.put("1", hashedList1);
		doubleHash.put("2", hashedList2);

		return doubleHash;
	}

	public Vector getData(String query) throws SQLException
	{

		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		String val = "";
		Vector value = new Vector();

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, passwd);
			statement = connection.createStatement();
			result = statement.executeQuery(query);

			while (result.next())
			{
				val = result.getString(1);
				value.add(val);
			}

			result.close();
			result = null;
			statement.close();
			statement = null;

		} catch (Exception e)
		{
			System.out.println(e);
		} finally
		{
			if (statement != null)
			{
				try
				{
					statement.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				statement = null;
			}
			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				connection = null;
			}
		}

		return value;
	}

	public HashMap getValues(String query) throws SQLException
	{

		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		String val1 = "";
		String val2 = "";
		HashMap value = new HashMap();

		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, passwd);
			statement = connection.createStatement();
			result = statement.executeQuery(query);

			while (result.next())
			{

				val1 = result.getString(1);
				val2 = result.getString(2);
				value.put("1", val1);
				value.put("2", val2);

			}

			result.close();
			result = null;
			statement.close();
			statement = null;

		} catch (Exception e)
		{
			System.out.println(e);
		} finally
		{
			if (statement != null)
			{
				try
				{
					statement.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				statement = null;
			}
			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				connection = null;
			}
		}

		return value;
	}

	public boolean execQuery(String command) throws SQLException
	{
		boolean value = false;
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;

		try
		{

			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, passwd);
			statement = connection.createStatement();
			result = statement.executeQuery(command);
			value = true;

			result.close();
			result = null;
			statement.close();
			statement = null;
			connection.close();
			connection = null;
		}

		catch (Exception e)
		{
			System.out.println(e);
			value = false;
		} finally
		{

			if (result != null)
			{
				try
				{
					result.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				result = null;
			}
			if (statement != null)
			{
				try
				{
					statement.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				statement = null;
			}
			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
					System.out.println(e);
				}
				connection = null;
			}
		}

		return value;
	}
	
	public boolean batchExecQuery(Vector query) throws SQLException
	{

		boolean value = false;
		Connection connection = null;
		Statement stmt = null;
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, passwd);
			stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			connection.setAutoCommit(false);

			for (int i = 0; i < query.size(); i++)
			{
				stmt.addBatch((String) query.get(i));
			}

			stmt.executeBatch();
			value = true;

			connection.commit();
			stmt.close();
			stmt = null;
			connection.close();
			connection = null;
		}
		catch (BatchUpdateException b)
		{

			System.err.println("SQLException: " + b.getMessage());
			System.err.println("SQLState:  " + b.getSQLState());
			System.err.println("Message:  " + b.getMessage());
			System.err.println("Vendor:  " + b.getErrorCode());
			System.err.println("Update counts:  ");
			value = false;
			connection.rollback();
		}
		catch (Exception e)
		{
			System.out.println(e);
			value = false;
			connection.rollback();
		}

		finally
		{

			if (stmt != null)
			{
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{
				}
				stmt = null;
			}
			if (connection != null)
			{
				try
				{
					connection.close();
				}
				catch (SQLException e)
				{
				}
				connection = null;
			}
		}

		return value;
	}

	public boolean batchExecQuery(String command, Vector values) throws SQLException
	{

		boolean value = false;
		Connection connection = null;
		PreparedStatement stmt = null;
		try
		{
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, passwd);
			connection.setAutoCommit(false);
			stmt = connection.prepareStatement(command);

			for (int i = 0; i < values.size(); i++)
			{
				double[] val = (double[]) values.get(i);
				for (int j = 0; j < val.length; j++)
				{
					stmt.setDouble((j + 1), val[j]);
				}

				stmt.addBatch();

			}

			stmt.executeBatch();
			value = true;

			connection.commit();
			stmt.close();
			stmt = null;
			connection.close();
			connection = null;
		} catch (BatchUpdateException b)
		{

			System.err.println("SQLException: " + b.getMessage());
			System.err.println("SQLState:  " + b.getSQLState());
			System.err.println("Message:  " + b.getMessage());
			System.err.println("Vendor:  " + b.getErrorCode());
			System.err.println("Update counts:  ");
			value = false;
			connection.rollback();
		} catch (Exception e)
		{
			System.out.println(e);
			value = false;
			connection.rollback();
		}

		finally
		{

			if (stmt != null)
			{
				try
				{
					stmt.close();
				} catch (SQLException e)
				{
				}
				stmt = null;
			}
			if (connection != null)
			{
				try
				{
					connection.close();
				} catch (SQLException e)
				{
				}
				connection = null;
			}
		}

		return value;
	}
}
