		$.buildGetTaskCountJSON = function() {	
			var jsonData = "{}";
			alert('JSON Data is:' + jsonData);
			var strData = JSON.stringify(jsonData);
			return strData;
		};					
		$(document).ready(function(){
			$('#btnRefresh').click(function() 
			{
				var send = $.buildGetTaskCountJSON();
	
				//var testdata = {}
				alert('JSON (Ready) is:' + send);
				$.ajax({
					//url: 'http://localhost:8080/test/post',
					url: 'http://localhost:8080/expd-jee-web/rest/users/count',
					type: 'GET',
					contentType: 'application/json; charset=utf-8',
					crossDomain: true,
					data: send,
					dataType: 'jsonp',
					success: function(data){
						//On ajax success do this
						alert("Task Count Retrieved: " + data);
					},
					error: function(xhr, ajaxOptions, thrownError) {
						alert("Error Occurred " + "HTTP Response Code: " + xhr.status);
						alert("Data: " + send);
					}
				});
			});
		});