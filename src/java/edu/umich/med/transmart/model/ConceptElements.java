package edu.umich.med.transmart.model;

public class ConceptElements
{
	private String conceptId;
	private String elementId;
	private String elementName;
	private String elementDescription;
	private String elementOrigId;
	private boolean selectedElement;
	
	public ConceptElements(String conceptId, String elementId, String elementName, String elementDescription, String elementOrigId,
			boolean selectedElement)
	{
		super();
		this.conceptId = conceptId;
		this.elementId = elementId;
		this.elementName = elementName;
		this.elementDescription = elementDescription;
		this.elementOrigId = elementOrigId;
		this.selectedElement = selectedElement;
	}
	public String getConceptId()
	{
		return conceptId;
	}
	public void setConceptId(String conceptId)
	{
		this.conceptId = conceptId;
	}
	public String getElementId()
	{
		return elementId;
	}
	public void setElementId(String elementId)
	{
		this.elementId = elementId;
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
	public boolean isSelectedElement()
	{
		return selectedElement;
	}
	public void setSelectedElement(boolean selectedElement)
	{
		this.selectedElement = selectedElement;
	}
}
