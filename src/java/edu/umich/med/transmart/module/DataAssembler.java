package edu.umich.med.transmart.module;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import edu.umich.med.transmart.db.JDBCExecuter;

public class DataAssembler
{
	private JDBCExecuter rs = new JDBCExecuter();
	private ResourceBundle msg = ResourceBundle.getBundle("edu.umich.med.transmart.resource.bundle.sql");
	private DataService ds = new DataService();

	// CONCEPT NETWORK GRAPH
	// ***********************************************************************************************************************************************

	public List getConceptInteraction(String conceptId, String conceptIdList, String queryType)
	{
		try
		{
			String query = msg.getString("conceptInteraction");
			
			if (queryType.equals("conceptPrivate"))
			{
				query = msg.getString("conceptInteractionPrivate");
			}
			
			query = query.replaceFirst("\\?", conceptId);
			query = query.replaceFirst("\\?", conceptIdList);
			
			ArrayList set = rs.select(query);

			return ds.createConceptInteraction(set);
		} catch (SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}

	public List getConceptCompleteInteraction(String conceptIdList)
	{
		try
		{
			String query = msg.getString("conceptCompleteInteraction");			
			query = query.replaceAll("\\?", conceptIdList);

			ArrayList set = rs.select(query);

			return ds.createConceptInteraction(set);
		} catch (SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}

	public List getConceptInteractionGeneFilter(String conceptId, String conceptIdList, String geneList, String drawCompleteGraph)
	{
		try
		{

			String query = msg.getString("conceptInteractionGeneFilter");
			if (drawCompleteGraph.equals("true"))
			{
				query = query.replaceFirst("\\?", geneList);
				query = query.replaceFirst("\\?", conceptIdList);
				query = query.replaceFirst("\\?", geneList);
				query = query.replaceFirst("\\?", conceptIdList);
			} else
			{
				query = query.replaceFirst("\\?", geneList);
				query = query.replaceFirst("\\?", conceptIdList);
				query = query.replaceFirst("\\?", geneList);
				query = query.replaceFirst("\\?", conceptId);
			}

			ArrayList set = rs.select(query);

			return ds.createConceptInteraction(set);
		} catch (SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}

	public List getConceptList(String conceptId)
	{
		try
		{
			String query = msg.getString("conceptList");
			query = query.replaceAll("\\?", conceptId);
			ArrayList set = rs.select(query);

			return ds.createConceptList(set);
		} catch (SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}

	// CONCEPT EXPLORER
	// ***********************************************************************************************************************************************

	public List getConceptDetail(String conceptId, String queryType)
	{
		try
		{
			String query = msg.getString("conceptDetail");

			if (queryType.equals("conceptPrivate"))
			{
				query = msg.getString("conceptDetailPrivate");
			}

			query = query.replaceAll("\\?", conceptId);
			ArrayList set = rs.select(query);

			return ds.createConceptDetail(set);
		} catch (SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}

	public List getConceptElements(String conceptId, String queryType)
	{
		try
		{
			String query = msg.getString("conceptElements");

			if (queryType.equals("conceptPrivate"))
			{
				query = msg.getString("conceptElementsPrivate");
			}

			query = query.replaceAll("\\?", conceptId);
			
			ArrayList set = rs.select(query);
			
			return ds.createConceptElements(set);
		} catch (SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}

	public List getOverlapConceptElements(String conceptId, String conceptId2, String queryType)
	{
		try
		{
			String query = msg.getString("conceptOverlapElementsExplore");

			if (queryType.equals("conceptPrivate"))
			{
				query = msg.getString("conceptOverlapElementsExplorePrivate");
			}

			query = query.replaceFirst("\\?", conceptId);
			query = query.replaceFirst("\\?", conceptId);
			query = query.replaceFirst("\\?", conceptId2);

			ArrayList set = rs.select(query);

			return ds.createConceptElements(set);
		} catch (SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}

	public List getConceptTypeGroupSize(String conceptId, String queryType, String conceptTypeId, double fdr, double pValue, String owner)
	{
		try
		{
			String query = "";

			if (queryType.equals("conceptPrivate"))
			{
				query = msg.getString("conceptTypeGroupSizePrivate");
				query = query.replaceFirst("\\?", conceptId);
				query = query.replaceFirst("\\?", String.valueOf(fdr));
				query = query.replaceFirst("\\?", String.valueOf(pValue));
				query = query.replaceFirst("\\?", owner);
				query = query.replaceFirst("\\?", conceptTypeId);
			} else
			{
				query = msg.getString("conceptTypeGroupSize");
				query = query.replaceFirst("\\?", conceptId);
				query = query.replaceFirst("\\?", String.valueOf(fdr));
				query = query.replaceFirst("\\?", String.valueOf(pValue));
				query = query.replaceFirst("\\?", conceptTypeId);
			}

			ArrayList set = rs.select(query);

			return ds.createConceptTypeGroupSize(set);
		} catch (SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}

	public List getFilterConceptTypeGroupSize(String conceptId, String queryType, String conceptTypeId, double fdr, double pValue, String owner)
	{
		try
		{
			String cTypeId = "0";
			String query = "";

			if (queryType.equals("conceptPrivate"))
			{
				query = msg.getString("conceptTypeGroupSizePrivate");
				query = query.replaceFirst("\\?", conceptId);
				query = query.replaceFirst("\\?", String.valueOf(fdr));
				query = query.replaceFirst("\\?", String.valueOf(pValue));
				query = query.replaceFirst("\\?", owner);
				query = query.replaceFirst("\\?", cTypeId);
			} else
			{
				query = msg.getString("conceptTypeGroupSize");
				query = query.replaceFirst("\\?", conceptId);
				query = query.replaceFirst("\\?", String.valueOf(fdr));
				query = query.replaceFirst("\\?", String.valueOf(pValue));
				query = query.replaceFirst("\\?", cTypeId);
			}

			ArrayList set = rs.select(query);

			return ds.createFilterConceptTypeGroupSize(set, conceptTypeId);
		} catch (SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}

	public List getConceptListNodeInteraction(String conceptId, String queryType, String conceptTypeId, double fdr, double pValue, String owner)
	{
		try
		{
			String query = "";

			if (queryType.equals("conceptPrivate"))
			{
				query = msg.getString("conceptListNodeInteractionPrivate");
				query = query.replaceFirst("\\?", conceptId);
				query = query.replaceFirst("\\?", String.valueOf(fdr));
				query = query.replaceFirst("\\?", String.valueOf(pValue));
				query = query.replaceFirst("\\?", owner);
				//query = query.replaceFirst("\\?", conceptTypeId);
			} 
			else
			{
				query = msg.getString("conceptListNodeInteraction");
				query = query.replaceFirst("\\?", conceptId);
				query = query.replaceFirst("\\?", String.valueOf(fdr));
				query = query.replaceFirst("\\?", String.valueOf(pValue));
				//query = query.replaceFirst("\\?", conceptTypeId);
			}

			ArrayList set = rs.select(query);

			return ds.createConceptListNodeInteraction(set);
		} catch (SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}
	
	public List getConceptListNodeInteractionAll(String conceptId, String queryType, String conceptTypeId, double fdr, double pValue, String owner)
	{
		try
		{
			String query = "";

			if (queryType.equals("conceptPrivate"))
			{
				query = msg.getString("conceptListNodeInteractionAllPrivate");
				query = query.replaceFirst("\\?", conceptId);
				query = query.replaceFirst("\\?", owner);
				query = query.replaceFirst("\\?", conceptTypeId);
			} else
			{
				query = msg.getString("conceptListNodeInteractionAll");
				query = query.replaceFirst("\\?", conceptId);
				query = query.replaceFirst("\\?", conceptTypeId);
			}

			ArrayList set = rs.select(query);

			return ds.createConceptListNodeInteractionAll(set);
		} catch (SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}

	// EDGE DETAIL
	// ***********************************************************************************************************************************************

	public List getEdgeDetail(String conceptId1, String conceptId2)
	{
		try
		{
			String query = msg.getString("edgeDetail");
			query = query.replaceFirst("\\?", conceptId1);
			query = query.replaceFirst("\\?", conceptId2);
			ArrayList set = rs.select(query);

			return ds.createEdgeDetail(set);
		} catch (SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}

	public List getConceptInteractionDetail(String conceptId1, String conceptId2)
	{
		try
		{
			String query = msg.getString("conceptInteractionDetail");
			String str = conceptId1 + ", " + conceptId2;
			query = query.replaceAll("\\?", str);
			ArrayList set = rs.select(query);

			return ds.createConceptInteractionDetail(set);
		} catch (SQLException e)
		{
			System.out.println(e);
			return null;
		}
	}

	public List getConceptExpand(String conceptId)
	{
		return null;
	}

	public List getConceptExpandInteraction(String conceptId)
	{
		return null;
	}

	public List getConceptExpandSubset(String conceptId)
	{
		return null;
	}

}
