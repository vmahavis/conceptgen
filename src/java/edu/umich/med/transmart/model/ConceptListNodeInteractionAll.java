package edu.umich.med.transmart.model;

public class ConceptListNodeInteractionAll
{
	private String conceptId;
	private String conceptName;
	private String conceptTypeName;
	private String elementSize;
	private String overlap;
	private double ppvalue;
	private double qvalue;
	private String conceptCategory;
	private String conceptTypeId;
	private String nodeColor;
	private String nodeLineColor;
	private boolean selectConcept;
	public ConceptListNodeInteractionAll(String conceptId, String conceptName, String conceptTypeName, String elementSize, String overlap,
			double ppvalue, double qvalue, String conceptCategory, String conceptTypeId, String nodeColor, String nodeLineColor, boolean selectConcept)
	{
		super();
		this.conceptId = conceptId;
		this.conceptName = conceptName;
		this.conceptTypeName = conceptTypeName;
		this.elementSize = elementSize;
		this.overlap = overlap;
		this.ppvalue = ppvalue;
		this.qvalue = qvalue;
		this.conceptCategory = conceptCategory;
		this.conceptTypeId = conceptTypeId;
		this.nodeColor = nodeColor;
		this.nodeLineColor = nodeLineColor;
		this.selectConcept = selectConcept;
	}
	public String getConceptId()
	{
		return conceptId;
	}
	public void setConceptId(String conceptId)
	{
		this.conceptId = conceptId;
	}
	public String getConceptName()
	{
		return conceptName;
	}
	public void setConceptName(String conceptName)
	{
		this.conceptName = conceptName;
	}
	public String getConceptTypeName()
	{
		return conceptTypeName;
	}
	public void setConceptTypeName(String conceptTypeName)
	{
		this.conceptTypeName = conceptTypeName;
	}
	public String getElementSize()
	{
		return elementSize;
	}
	public void setElementSize(String elementSize)
	{
		this.elementSize = elementSize;
	}
	public String getOverlap()
	{
		return overlap;
	}
	public void setOverlap(String overlap)
	{
		this.overlap = overlap;
	}
	public double getPpvalue()
	{
		return ppvalue;
	}
	public void setPpvalue(double ppvalue)
	{
		this.ppvalue = ppvalue;
	}
	public double getQvalue()
	{
		return qvalue;
	}
	public void setQvalue(double qvalue)
	{
		this.qvalue = qvalue;
	}
	public String getConceptCategory()
	{
		return conceptCategory;
	}
	public void setConceptCategory(String conceptCategory)
	{
		this.conceptCategory = conceptCategory;
	}
	public String getConceptTypeId()
	{
		return conceptTypeId;
	}
	public void setConceptTypeId(String conceptTypeId)
	{
		this.conceptTypeId = conceptTypeId;
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
	public boolean isSelectConcept()
	{
		return selectConcept;
	}
	public void setSelectConcept(boolean selectConcept)
	{
		this.selectConcept = selectConcept;
	}
}
