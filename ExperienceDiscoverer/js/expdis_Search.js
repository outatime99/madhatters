					
		$(document).ready(function(){
			$('#btn_search').click(function() 
				{
				//var send = "\"{search_text\" : \"" + $("input[name=search_text]").val() + "}\"";	;
				//var send2 = JSON.stringify(send);
				//alert('JSON (Ready) is:' + send2);
				var send2 = "{ \"query\": { \"match_all\": {}  }}";
				$.ajax({
					url: 'http://localhost:9200/expdis_ideas/_search',
					type: 'GET',
					contentType: 'application/json; charset=utf-8',
					crossDomain: true,
					data: send2,
					dataType: 'json',
				    success: function(data){
				    	//console.log(JSON.stringify(data.topics));
				    	$.each(data.hits.hits, function(idx, hit){
				    		//alert("Data: " + hit._source.idea_name);
				    		$('#resultsTable tr:last').after('<tr><td>'+hit._source.idea_business_unit+'</td><td><a href="idea.html?id='+hit._id+'">'+hit._source.idea_name+'</a></td><td>'+hit._source.idea_description+'</td><td>'+hit._source.idea_roi+'</td><td>'+hit._source.idea_duedate+'</td></tr>');
				    		//$("#nav").html('<a href="' + topic.link_src + '">' + topic.link_text + "</a>");
				    	});
					},
					error: function(xhr, ajaxOptions, thrownError) {
						alert("Error Occurred " + "HTTP Response Code: " + xhr.status);
						alert("Data: " + send2);
					    }
				});
			});
		});