		$.fn.formToJSON = function() {	
			var formdata = "{";
			formdata += "\"idea_name\" : \"" + $("input[name=idea_name]").val() + "\",";
			formdata += "\"idea_description\" : \"" + $("textarea[name=idea_description]").val() + "\",";
			formdata += "\"idea_business_unit\" : \"Corporate Finance\",",
			formdata += "\"idea_roi\" : " + $("input[name=idea_roi]").val() + ",";
			formdata += "\"idea_duedate\" : \"2016-10-15T12:07:55+02\",";
			formdata += "\"idea_skills\" : \"Test\"";
			/*formdata += "\"userID\" : \"TestUser\",";
			formdata += "\"ideaName\" : \"" + $("input[name=idea_name]").val() + "\",";
			formdata += "\"description\" : \"" + $("textarea[name=idea_description]").val() + "\",";
			formdata += "\"roi\" : \"" + $("input[name=idea_roi]").val() + "\",";
			formdata += "\"dueDate\" : \"" + $("input[name=idea_duedate]").val() + "\",";
			formdata += "\"votes\" : \"0\"";	*/		
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
					//url: 'http://localhost:8080/ideas/create',
					url: 'http://localhost:9200/expdis_ideas/idea',
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
						//alert("Data: " + send2);
					    }
				});
			});
		});
		


