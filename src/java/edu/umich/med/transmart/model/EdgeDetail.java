package edu.umich.med.transmart.model;

public class EdgeDetail
{
	private String conceptId;
	private String elementId1;
	private String conceptId2;
	private String elementId2;
	private String elementName;
	private String elementDescription;
	private String elementOrigId;
	
	public EdgeDetail(String conceptId, String elementId1, String conceptId2, String elementId2, String elementName, String elementDescription,
			String elementOrigId)
	{
		super();
		this.conceptId = conceptId;
		this.elementId1 = elementId1;
		this.conceptId2 = conceptId2;
		this.elementId2 = elementId2;
		this.elementName = elementName;
		this.elementDescription = elementDescription;
		this.elementOrigId = elementOrigId;
	}

	public String getConceptId()
	{
		return conceptId;
	}

	public void setConceptId(String conceptId)
	{
		this.conceptId = conceptId;
	}

	public String getElementId1()
	{
		return elementId1;
	}

	public void setElementId1(String elementId1)
	{
		this.elementId1 = elementId1;
	}

	public String getConceptId2()
	{
		return conceptId2;
	}

	public void setConceptId2(String conceptId2)
	{
		this.conceptId2 = conceptId2;
	}

	public String getElementId2()
	{
		return elementId2;
	}

	public void setElementId2(String elementId2)
	{
		this.elementId2 = elementId2;
	}

	public String getElementName()
	{
		return elementName;
	}

	public void setElementName(String elementName)
	{
		this.elementName = elementName;
	}

	public String getElementDescription()
	{
		return elementDescription;
	}

	public void setElementDescription(String elementDescription)
	{
		this.elementDescription = elementDescription;
	}

	public String getElementOrigId()
	{
		return elementOrigId;
	}

	public void setElementOrigId(String elementOrigId)
	{
		this.elementOrigId = elementOrigId;
	}	
}
