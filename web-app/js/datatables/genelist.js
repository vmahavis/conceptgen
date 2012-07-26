$(document).ready(function() {
	
	$('#genelist').html( '<table cellpadding="0" cellspacing="0" border="0" class="display" id="genelistTable"></table>' );
	
	$('#genelistTable').dataTable({

		"bJQueryUI": true,
		"bAutoWidth": false,
		"aaData": data2,
		"aoColumns": [ 
	    { "sTitle": "Gene Symbol" , "sWidth": "20%"},
	    { "bVisible": false},  
	    { "sTitle": "Gene Name" , "sWidth": "80%"}
	   
	  ]
	});	
	
});