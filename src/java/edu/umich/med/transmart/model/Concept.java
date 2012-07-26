package edu.umich.med.transmart.model;

public class Concept
{
	private String conceptId;
	private String conceptName;
	private String elementSize;

	public Concept(String conceptId, String conceptName, String elementSize)
	{
		super();
		this.conceptId = conceptId;
		this.conceptName = conceptName;
		this.elementSize = elementSize;
	}

	public String getElementSize()
	{
		return elementSize;
	}

	public void setElementSize(String elementSize)
	{
		this.elementSize = elementSize;
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

}
