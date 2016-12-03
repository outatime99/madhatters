		$.fn.formToJSON = function() {	
			var formdata = "{";
			formdata += "\"idea_name\" : \"" + $("input[name=idea_name]").val() + "\",";
			formdata += "\"idea_description\" : \"" + $("textarea[name=idea_description]").val() + "\",";
			formdata += "\"idea_roi\" : \"" + $("input[name=idea_roi]").val() + "\",";
			formdata += "\"idea_bu\" : \"" + $("input[name=idea_bu]").val() + "\",";
			formdata += "\"idea_duedate\" : \"" + $("input[name=idea_duedate]").val() + "\",";
			formdata += "\"idea_file\" : \"" + $("input[name=idea_file]").val() + "\",";
			formdata += "\"idea_skills\" : \"" + $("input[name=idea_skills]").val() + "\"";			
			formdata = formdata + "}";
			//alert('Greg JSON is:' + formdata);
			return formdata;
		};					
		$(document).ready(function(){
			$('#btn_createNewIdea').click(function() 
				{
				var send = $('#form_createNewIdea').formToJSON();
				var send2 = JSON.stringify(send);
				alert('JSON (Ready) is:' + send);
				$.ajax({
					url: 'http://localhost:8080/ideas/create',
					type: 'POST',
					contentType: 'application/json; charset=utf-8',
					crossDomain: true,
					data: send,
					dataType: 'json',
				    success: function(data){
					     alert("Success. Response is: " + data);
					},
					error: function(xhr, ajaxOptions, thrownError) {
						alert("Error Occurred " + "HTTP Response Code: " + xhr.status);
						alert("Data: " + send2);
					    }
				});
			});
		});