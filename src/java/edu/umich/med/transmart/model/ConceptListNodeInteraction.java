package edu.umich.med.transmart.model;

public class ConceptListNodeInteraction
{
	private String conceptId;
	private String conceptName;
	private String conceptTypeName;
	private String elementSize;
	private String overlap;
	private String ppvalue;
	private String qvalue;
	private String conceptCategory;
	private boolean selectConcept;
	public ConceptListNodeInteraction(String conceptId, String conceptName, String conceptTypeName, String elementSize, String overlap,
			String ppvalue, String qvalue, String conceptCategory, boolean selectConcept)
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
	public String getPpvalue()
	{
		return ppvalue;
	}
	public void setPpvalue(String ppvalue)
	{
		this.ppvalue = ppvalue;
	}
	public String getQvalue()
	{
		return qvalue;
	}
	public void setQvalue(String qvalue)
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
	public boolean isSelectConcept()
	{
		return selectConcept;
	}
	public void setSelectConcept(boolean selectConcept)
	{
		this.selectConcept = selectConcept;
	}

}
