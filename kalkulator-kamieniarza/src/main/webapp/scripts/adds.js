$(document).ready(function() {
	var is=true;
	$("#hide").click(function() {
		
			$("#newAdd").toggle("fast",function(){
				myFunction();
				
				
			});
			function myFunction() {
				
				if(is){
					$("#hide").css({'margin-left':'180px'});
					$("#hide").css("background-position", "-20px 0px");
					is=false;
				} else {
					$("#hide").css({'margin-left':'0px'});
					$("#hide").css("background-position", "0px 0px");
					is=true;
				}            
			}
	});
	
	
});