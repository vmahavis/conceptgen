package edu.umich.med.transmart.model;

public class ConceptDetail
{
	private String conceptId;
	private String conceptName;
	private String concept_type_name;
	private String elementSize;

	public ConceptDetail(String conceptId, String conceptName, String concept_type_name, String elementSize)
	{
		super();
		this.conceptId = conceptId;
		this.conceptName = conceptName;
		this.concept_type_name = concept_type_name;
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

	public String getConcept_type_name()
	{
		return concept_type_name;
	}

	public void setConcept_type_name(String concept_type_name)
	{
		this.concept_type_name = concept_type_name;
	}

	public String getElementSize()
	{
		return elementSize;
	}

	public void setElementSize(String elementSize)
	{
		this.elementSize = elementSize;
	}

}
