<%@ page contentType="text/html;charset=ISO-8859-1"  import="edu.umich.med.transmart.*; edu.umich.med.transmart.module.*; edu.umich.med.transmart.model.*" %>
<%

String conceptId = "746575";
String queryType = "conceptPublic";
String conceptTypeId = "0";
String owner = "Public";
double fdr = 0.05;
double pValue = 0.05;

ConceptJsService cjs = new ConceptJsService();
DataAssembler da = new DataAssembler();
ArrayList list = da.getConceptTypeGroupSize(conceptId, queryType, conceptTypeId, fdr, pValue, owner);
ArrayList list2 = da.getConceptDetail(conceptId, queryType);

String data = cjs.getConceptDirectInteraction(conceptId, pValue,fdr)
String data2 = cjs.conceptGeneList(conceptId);
String conceptName = "";

String pieInfo = "";

for(int i=0; i<list.size(); i++)
{
	ConceptTypeGroupSize cs = list.get(i);
	pieInfo +=  "['" + cs.getConceptTypeName() + "', " + cs.getConceptSize() + "],";
}

for(int i=0; i<list2.size(); i++)
{
	ConceptDetail cd = list2.get(i);
	conceptName = cd.getConceptName();
}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ConceptGen: Concept Viewer</title>


<!--  CSS --------------------------------------------------------------------------------------------------------------------------------->

<link rel="stylesheet" href="${resource(dir:'css',file:'template.css')}" />
<link rel="stylesheet" href="${resource(dir:'js/datatables/media/css',file:'demo_table_jui.css')}" />
<link rel="stylesheet" href="${resource(dir:'js/datatables/extras/TableTools/media/css',file:'TableTools_JUI.css')}" />
<link rel="stylesheet" href="${resource(dir:'js/jquery-ui/css/smoothness',file:'jquery-ui-1.8.16.custom.css')}" />
<link rel="stylesheet" href="${resource(dir:'js/jqplot',file:'jquery.jqplot.min.css')}" />

<!--  JS SCRIPT --------------------------------------------------------------------------------------------------------------------------->
<script>
var data = <%= data %>;
var data2 = <%= data2 %>;
</script>

<g:javascript src="jquery.min.js"/>
<g:javascript src="datatables/media/js/jquery.dataTables.js"/>
<g:javascript src="datatables/extras/TableTools/media/js/TableTools.js"/>
<g:javascript src="datatables/media/js/jquery.dataTables.js"/>
<g:javascript src="datatables/extras/TableTools/media/js/ZeroClipboard.js"/>


<g:javascript src="datatables/enrichment.js"/>
<g:javascript src="datatables/genelist.js"/>

<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
         <%= pieInfo %>
        ]);

        var options = {
          title: 'Concept Types'
        };

        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
</script>



</head>
<body>
<div id="mainFrame">
	<div id="conceptTitle">
		<%= conceptName %>
	</div>
	
	<div id="concepts" class="playout">
		<table width="100%">
		<tr>
			<td width="50%">
				<div id="genelist"></div>
			</td>
			<td width="50%">
			<div id="chart_div" style="width: 600px; height: 400px;"></div>
			</td>
		</tr>
		</table>
		<div class="lineFull"></div>
		<div id="container"></div>
	</div>
</div>
</body>
</html>