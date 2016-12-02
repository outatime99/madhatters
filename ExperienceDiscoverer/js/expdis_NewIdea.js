		$.fn.formToJSON = function() {	
			var formdata = "{";
			formdata += "\"user_name\" : \"" + $("input[name=name]").val() + "\",";
			formdata += "\"user_surname\" : \"" + $("input[name=surname]").val() + "\"";				
			formdata = formdata + "}";
			//alert('Greg JSON is:' + formdata);
			return formdata;
		};					
		$(document).ready(function(){
			$('#btnSubmit').click(function() 
				{
				var send = $('#form').formToJSON();
				var send2 = JSON.stringify(send);
				//var testdata = {}
				alert('JSON (Ready) is:' + send);
				$.ajax({
					//url: 'http://localhost:8080/test/post',
					url: 'http://localhost:8080/expd-jee-web/rest/users/create',
					type: 'POST',
					contentType: 'application/json; charset=utf-8',
					crossDomain: true,
					data: send,
					dataType: 'json',
				    success: function(data){
					     //On ajax success do this
					     alert(data);
					},
					error: function(xhr, ajaxOptions, thrownError) {
						alert("Error Occurred " + "HTTP Response Code: " + xhr.status);
						alert("Data: " + send2);

					    }
				});
			});
		});