package edu.umich.med.transmart.resource.util;


import java.util.ArrayList;

public class TextParser
{

	public String createTabDelimitedTextArray(ArrayList textArray, String[] header)
	{
		StringBuffer text = new StringBuffer();

		for (int i = 0; i < header.length; i++)
		{
			text.append(header[i] + "\t");
		}
		text.append("\n");

		for (int i = 0; i < textArray.size(); i++)
		{
			ArrayList record = (ArrayList) textArray.get(i);
			for (int j = 0; j < record.size(); j++)
			{
				text.append((String) record.get(j) + "\t");
			}
			text.append("\n");
		}

		return text.toString();
	}

	public String createCommaDelimitedText(ArrayList text)
	{
		StringBuffer temp = new StringBuffer();
		for (int i = 0; i < text.size(); i++)
		{
			if (i != 0)
			{
				temp.append(", " + text.get(i).toString());
			}
			else
			{
				temp.append(text.get(i).toString());
			}
		}
		return temp.toString();
	}

	public String createJsArray(ArrayList textArray)
	{

		String t = "";
		for (int i = 0; i < textArray.size(); i++)
		{
			ArrayList record = (ArrayList) textArray.get(i);
			StringBuffer text = new StringBuffer();
			for (int j = 0; j < record.size(); j++)
			{
				text.append(", \"" + (String) record.get(j) + "\"");
			}
			t = t + ", [ " + text.toString().replaceFirst(",", "") + " ]";
		}

		t = "[ " + t.replaceFirst(",", "") + " ]";

		return t;
	}

	public String createNewLineDelimitedText(ArrayList text)
	{
		StringBuffer temp = new StringBuffer();
		for (int i = 0; i < text.size(); i++)
		{
			if (i != 0)
			{
				temp.append("\n" + text.get(i).toString().trim());
			}
			else
			{
				temp.append(text.get(i).toString().trim());
			}
		}
		return temp.toString();
	}

	public ArrayList createArrayFromCommaDelimitedText(String text)
	{
		ArrayList array = new ArrayList();
		String[] tmp = text.split(",");

		for (int i = 0; i < tmp.length; i++)
		{
			array.add(tmp[i]);
		}

		return array;
	}

}
