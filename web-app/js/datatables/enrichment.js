$(document).ready(function() {
	
	$('#container').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="conceptTable"></table>' );
	
	$('#conceptTable').dataTable({

		"bJQueryUI": true,
		"bAutoWidth": false,
		"aaData": data,
		"sDom": '<"H"lfr>t<"F"ipT>',
		"oTableTools": {
            "sSwfPath": "../js/datatables/extras/TableTools/media/swf/copy_cvs_xls_pdf.swf",
            "aButtons": ["copy",
                {
            		"sExtends": "csv",
            		"sFieldBoundary": '"',
            		"sFileName": "compounds.csv"
                },
	            {
	        		"sExtends": "xls",
	        		"sButtonText": "TSV",
	        		"sFileName": "compounds.tsv"
	            },
	            {
	        		"sExtends": "pdf",
	        		"sFileName": "compounds.pdf",
	        		"sTitle": "Compounds"
	            },
	            "print"
            ]
		},
		"sPaginationType": "full_numbers",
		"aoColumns": [
		{ "bVisible": false},   
		{ "bVisible": false},   
	    { "sTitle": "Concept Name" , "sWidth": "45%"},
	    { "sTitle": "Concept Type" , "sWidth": "15%"},
	    { "bVisible": false}, 
	    { "sTitle": "Gene List Size" , "sWidth": "10%"},
	    { "sTitle": "P-Value", "sWidth": "10%" },
	    { "sTitle": "Q-Value", "sWidth": "10%" },
	    { "sTitle": "Category" , "sWidth": "10%"}
	  ]
	});	
	
});