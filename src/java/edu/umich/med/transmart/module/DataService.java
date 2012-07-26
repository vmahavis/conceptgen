package edu.umich.med.transmart.module;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import edu.umich.med.transmart.model.Concept;
import edu.umich.med.transmart.model.ConceptDetail;
import edu.umich.med.transmart.model.ConceptElements;
import edu.umich.med.transmart.model.ConceptInteraction;
import edu.umich.med.transmart.model.ConceptInteractionDetail;
import edu.umich.med.transmart.model.ConceptListNodeInteraction;
import edu.umich.med.transmart.model.ConceptListNodeInteractionAll;
import edu.umich.med.transmart.model.ConceptTypeGroupSize;
import edu.umich.med.transmart.model.EdgeDetail;
import edu.umich.med.transmart.resource.util.TextParser;

public class DataService
{
	public List createConceptInteraction(ArrayList dbResult)
	{

		List list = new ArrayList();

		for (int i = 0; i < dbResult.size(); i++)
		{
			ArrayList row = (ArrayList) dbResult.get(i);
			String conceptId1 = (String) row.get(0);
			String conceptName1 = (String) row.get(1);
			String conceptTypeName1 = (String) row.get(2);
			String conceptNodeColor1 = (String) row.get(3);
			String conceptNodeLineColor1 = (String) row.get(4);
			String elementSize1 = (String) row.get(5);
			String conceptId2 = (String) row.get(6);
			String conceptName2 = (String) row.get(7);
			String conceptTypeName2 = (String) row.get(8);
			String conceptNodeColor2 = (String) row.get(9);
			String conceptNodeLineColor2 = (String) row.get(10);
			String elementSize2 = (String) row.get(11);
			String overlap = (String) row.get(12);

			list.add(new ConceptInteraction(conceptId1, conceptName1, conceptTypeName1, conceptNodeColor1, conceptNodeLineColor1,
					elementSize1, conceptId2, conceptName2, conceptTypeName2, conceptNodeColor2, conceptNodeLineColor2, elementSize2,
					overlap));
		}
		return list;
	}

	public List createConceptList(ArrayList dbResult)
	{

		List list = new ArrayList();

		for (int i = 0; i < dbResult.size(); i++)
		{
			ArrayList row = (ArrayList) dbResult.get(i);
			String conceptId = (String) row.get(0);
			String conceptName = (String) row.get(1);
			String elementSize = (String) row.get(2);

			list.add(new Concept(conceptId, conceptName, elementSize));
		}
		return list;
	}

	public List createConceptDetail(ArrayList dbResult)
	{

		List list = new ArrayList();

		for (int i = 0; i < dbResult.size(); i++)
		{
			ArrayList row = (ArrayList) dbResult.get(i);

			String conceptId = (String) row.get(0);
			String conceptName = (String) row.get(1);
			String concept_type_name = (String) row.get(2);
			String element_size = (String) row.get(3);

			list.add(new ConceptDetail(conceptId, conceptName, concept_type_name, element_size));
		}
		return list;
	}

	public List createConceptElements(ArrayList dbResult)
	{

		List list = new ArrayList();

		for (int i = 0; i < dbResult.size(); i++)
		{
			ArrayList row = (ArrayList) dbResult.get(i);
			String conceptId = (String) row.get(0);
			String elementId = (String) row.get(1);
			String elementName = (String) row.get(2);
			String elementDescription = (String) row.get(3);
			String elementOrigId = (String) row.get(4);
			boolean selectedElement = false;

			list.add(new ConceptElements(conceptId, elementId, elementName, elementDescription, elementOrigId, selectedElement));
		}

		return list;
	}

	public List createEdgeDetail(ArrayList dbResult)
	{

		List list = new ArrayList();

		for (int i = 0; i < dbResult.size(); i++)
		{
			ArrayList row = (ArrayList) dbResult.get(i);
			String conceptId1 = (String) row.get(0);
			String elementId1 = (String) row.get(1);
			String conceptId2 = (String) row.get(2);
			String elementId2 = (String) row.get(3);
			String elementName = (String) row.get(4);
			String elementDescription = (String) row.get(5);
			String elementOrigId = (String) row.get(6);
			
			list.add(new EdgeDetail(conceptId1, elementId1, conceptId2, elementId2, elementName, elementDescription, elementOrigId));
		}

		return list;
	}

	public List createConceptTypeGroupSize(ArrayList dbResult)
	{

		List list = new ArrayList();

		for (int i = 0; i < dbResult.size(); i++)
		{
			ArrayList row = (ArrayList) dbResult.get(i);
			String conceptTypeId = (String) row.get(0);
			String conceptTypeName = (String) row.get(1);
			String conceptCategory = (String) row.get(2);
			String nodeColor = (String) row.get(3);
			String nodeLineColor = (String) row.get(4);
			String conceptSize = (String) row.get(5);

			list.add(new ConceptTypeGroupSize(conceptTypeId, conceptTypeName, conceptCategory, conceptSize, nodeColor, nodeLineColor, true));
		}

		return list;
	}

	public List createFilterConceptTypeGroupSize(ArrayList dbResult, String param)
	{
		TextParser t = new TextParser();
		ArrayList booleanList = t.createArrayFromCommaDelimitedText(param);

		List list = new ArrayList();

		for (int i = 0; i < dbResult.size(); i++)
		{
			ArrayList row = (ArrayList) dbResult.get(i);
			String conceptTypeId = (String) row.get(0);
			String conceptTypeName = (String) row.get(1);
			String conceptCategory = (String) row.get(2);
			String nodeColor = (String) row.get(3);
			String nodeLineColor = (String) row.get(4);
			String conceptSize = (String) row.get(5);
			boolean selectedConceptType = true;

			if (booleanList.contains(conceptTypeId))
			{
				selectedConceptType = false;
			}

			list.add(new ConceptTypeGroupSize(conceptTypeId, conceptTypeName, conceptCategory, conceptSize, nodeColor, nodeLineColor, selectedConceptType));
		}

		return list;
	}

	public List createConceptListNodeInteraction(ArrayList dbResult)
	{

		List list = new ArrayList();

		for (int i = 0; i < dbResult.size(); i++)
		{
			ArrayList row = (ArrayList) dbResult.get(i);
			String conceptId = (String) row.get(0);
			String conceptName = (String) row.get(1);
			String conceptTypeName = (String) row.get(2);
			String elementSize = (String) row.get(3);
			String overlap = (String) row.get(4);
			double pvalTemp = Double.parseDouble((String) row.get(5));
			double qvalTemp = Double.parseDouble((String) row.get(6));
			String conceptCategory = (String) row.get(7);

			DecimalFormat formatter = new DecimalFormat("0.######E0");
			String ppvalue = formatter.format(pvalTemp);
			String qvalue = formatter.format(qvalTemp);
			boolean selectConcept = false;

			list.add(new ConceptListNodeInteraction(conceptId, conceptName, conceptTypeName, elementSize, overlap, ppvalue, qvalue,
					conceptCategory, selectConcept));
		}

		return list;
	}

	public List createConceptListNodeInteractionAll(ArrayList dbResult)
	{

		List list = new ArrayList();

		for (int i = 0; i < dbResult.size(); i++)
		{
			ArrayList row = (ArrayList) dbResult.get(i);
			String conceptId = (String) row.get(0);
			String conceptName = (String) row.get(1);
			String conceptTypeName = (String) row.get(2);
			String elementSize = (String) row.get(3);
			String overlap = (String) row.get(4);
			double ppvalue = Double.parseDouble((String) row.get(5));
			double qvalue = Double.parseDouble((String) row.get(6));
			ppvalue = (-1 * Math.log(ppvalue));
			qvalue = (-1 * Math.log(qvalue));
			String conceptCategory = (String) row.get(7);
			String conceptTypeId = (String) row.get(8);
			String nodeColor = (String) row.get(9);
			String nodeLineColor = (String) row.get(10);
			boolean selectConcept = false;

			list.add(new ConceptListNodeInteractionAll(conceptId, conceptName, conceptTypeName, elementSize, overlap, ppvalue, qvalue,
					conceptCategory,conceptTypeId,nodeColor,nodeLineColor, selectConcept));
		}

		return list;
	}
	public List createConceptInteractionDetail(ArrayList dbResult)
	{

		List list = new ArrayList();

		for (int i = 0; i < dbResult.size(); i++)
		{
			ArrayList row = (ArrayList) dbResult.get(i);
			String conceptId1 = (String) row.get(0);
			String conceptName1 = (String) row.get(1);
			String conceptTypeName1 = (String) row.get(2);
			String elementSize1 = (String) row.get(3);
			String conceptId2 = (String) row.get(4);
			String conceptName2 = (String) row.get(5);
			String conceptTypeName2 = (String) row.get(6);
			String elementSize2 = (String) row.get(7);
			String overlap = (String) row.get(8);
			String oddsRatio = (String) row.get(9);
			double pvalTemp = Double.parseDouble((String) row.get(10));
			DecimalFormat formatter = new DecimalFormat("0.######E0");
			String pValue = formatter.format(pvalTemp);

			list.add(new ConceptInteractionDetail(conceptId1, conceptName1, conceptTypeName1, elementSize1, conceptId2, conceptName2,
					conceptTypeName2, elementSize2, overlap, oddsRatio, pValue));
		}

		return list;
	}

}
