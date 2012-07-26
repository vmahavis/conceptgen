package edu.umich.med.transmart.model;

public class ConceptInteractionDetail
{
	private String conceptId1;
	private String conceptName1;
	private String conceptTypeName1;
	private String elementSize1;
	private String conceptId2;
	private String conceptName2;
	private String conceptTypeName2;
	private String elementSize2;
	private String overlap;
	private String oddsRatio;
	private String ppvalue;

	public ConceptInteractionDetail(String conceptId1, String conceptName1, String conceptTypeName1, String elementSize1,
			String conceptId2, String conceptName2, String conceptTypeName2, String elementSize2, String overlap, String oddsRatio,
			String ppvalue)
	{
		super();
		this.conceptId1 = conceptId1;
		this.conceptName1 = conceptName1;
		this.conceptTypeName1 = conceptTypeName1;
		this.elementSize1 = elementSize1;
		this.conceptId2 = conceptId2;
		this.conceptName2 = conceptName2;
		this.conceptTypeName2 = conceptTypeName2;
		this.elementSize2 = elementSize2;
		this.overlap = overlap;
		this.oddsRatio = oddsRatio;
		this.ppvalue = ppvalue;
	}

	public String getConceptId1()
	{
		return conceptId1;
	}

	public void setConceptId1(String conceptId1)
	{
		this.conceptId1 = conceptId1;
	}

	public String getConceptName1()
	{
		return conceptName1;
	}

	public void setConceptName1(String conceptName1)
	{
		this.conceptName1 = conceptName1;
	}

	public String getConceptTypeName1()
	{
		return conceptTypeName1;
	}

	public void setConceptTypeName1(String conceptTypeName1)
	{
		this.conceptTypeName1 = conceptTypeName1;
	}

	public String getElementSize1()
	{
		return elementSize1;
	}

	public void setElementSize1(String elementSize1)
	{
		this.elementSize1 = elementSize1;
	}

	public String getConceptId2()
	{
		return conceptId2;
	}

	public void setConceptId2(String conceptId2)
	{
		this.conceptId2 = conceptId2;
	}

	public String getConceptName2()
	{
		return conceptName2;
	}

	public void setConceptName2(String conceptName2)
	{
		this.conceptName2 = conceptName2;
	}

	public String getConceptTypeName2()
	{
		return conceptTypeName2;
	}

	public void setConceptTypeName2(String conceptTypeName2)
	{
		this.conceptTypeName2 = conceptTypeName2;
	}

	public String getElementSize2()
	{
		return elementSize2;
	}

	public void setElementSize2(String elementSize2)
	{
		this.elementSize2 = elementSize2;
	}

	public String getOverlap()
	{
		return overlap;
	}

	public void setOverlap(String overlap)
	{
		this.overlap = overlap;
	}

	public String getOddsRatio()
	{
		return oddsRatio;
	}

	public void setOddsRatio(String oddsRatio)
	{
		this.oddsRatio = oddsRatio;
	}

	public String getPpvalue()
	{
		return ppvalue;
	}

	public void setPpvalue(String ppvalue)
	{
		this.ppvalue = ppvalue;
	}

}
