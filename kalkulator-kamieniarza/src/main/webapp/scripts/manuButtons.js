$(document).ready(function() {
	$('.main').hide();
	$('#Home').fadeIn();

	$('#buttons').buttonset();
	$('#bmain').prop('checked', true).button('refresh');
	$('#buttons').on("change", function(event) {
		var id = $("#buttons :radio:checked + label").text();
		$('.main').fadeOut();
		$('#' + id).fadeIn();

	});

	$('button').button();
	
	$('#ceny_wykonczen').accordion({
		heightStyle : "content"
	
	});

	$("#wymiary_podstawowe_accordion").accordion({
		heightStyle : "content"
		
	});
	
	$("#wymiary_rozszerzone_accordion").accordion({
		heightStyle : "content",active: false, collapsible: true
		
	});
	
	

	$("#wykonczeniadiv").accordion({
		heightStyle : "content"
	});

	

	
	
});