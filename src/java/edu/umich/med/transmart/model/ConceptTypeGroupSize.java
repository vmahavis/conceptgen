package edu.umich.med.transmart.model;

public class ConceptTypeGroupSize
{
	private String conceptTypeId;
	private String conceptTypeName;
	private String conceptCategory;
	private String conceptSize;
	private String nodeColor;
	private String nodeLineColor;
	private boolean selectConceptType;
	public ConceptTypeGroupSize(String conceptTypeId, String conceptTypeName, String conceptCategory, String conceptSize, String nodeColor,
			String nodeLineColor, boolean selectConceptType)
	{
		super();
		this.conceptTypeId = conceptTypeId;
		this.conceptTypeName = conceptTypeName;
		this.conceptCategory = conceptCategory;
		this.conceptSize = conceptSize;
		this.nodeColor = nodeColor;
		this.nodeLineColor = nodeLineColor;
		this.selectConceptType = selectConceptType;
	}
	
	public String getConceptTypeId()
	{
		return conceptTypeId;
	}
	public void setConceptTypeId(String conceptTypeId)
	{
		this.conceptTypeId = conceptTypeId;
	}
	public String getConceptTypeName()
	{
		return conceptTypeName;
	}
	public void setConceptTypeName(String conceptTypeName)
	{
		this.conceptTypeName = conceptTypeName;
	}
	public String getConceptCategory()
	{
		return conceptCategory;
	}
	public void setConceptCategory(String conceptCategory)
	{
		this.conceptCategory = conceptCategory;
	}
	public String getConceptSize()
	{
		return conceptSize;
	}
	public void setConceptSize(String conceptSize)
	{
		this.conceptSize = conceptSize;
	}
	public String getNodeColor()
	{
		return nodeColor;
	}
	public void setNodeColor(String nodeColor)
	{
		this.nodeColor = nodeColor;
	}
	public String getNodeLineColor()
	{
		return nodeLineColor;
	}
	public void setNodeLineColor(String nodeLineColor)
	{
		this.nodeLineColor = nodeLineColor;
	}
	public boolean isSelectConceptType()
	{
		return selectConceptType;
	}
	public void setSelectConceptType(boolean selectConceptType)
	{
		this.selectConceptType = selectConceptType;
	}
}
