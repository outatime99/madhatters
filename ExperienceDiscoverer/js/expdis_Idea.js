
		$(document).ready(function(){
			function qs(key) {
				//return "TEST";
			    key = key.replace(/[*+?^$.\[\]{}()|\\\/]/g, "\\$&"); // escape RegEx meta chars
			    var match = location.search.match(new RegExp("[?&]"+key+"=([^&]+)(&|$)"));
			    return match && decodeURIComponent(match[1].replace(/\+/g, " "));
			}
			
			function getParameterByName(name, url) {
				
			    if (!url) {
			      url = window.location.href;
			    }
			    name = name.replace(/[\[\]]/g, "\\$&");
			    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
			        results = regex.exec(url);
			    if (!results) return null;
			    if (!results[2]) return '';
			    
			    return decodeURIComponent(results[2].replace(/\+/g, " "));
			}
			
			function vLoad() 
			{
				//alert('Button Clicked');
				var idVal = getParameterByName("id");
				var searchString = '{ "filter":{ "term":{"_id": "'+idVal+'"}}}';
				//alert('Id is:' + idVal);
				//alert('Search string is:' + searchString);
				$.ajax({
					url: 'http://localhost:9200/expdis_ideas/_search',
					type: 'POST',
					contentType: 'application/json; charset=utf-8',
					crossDomain: true,
					data: searchString,
					dataType: 'json',
				    success: function(data){
					     //alert("Success. Response is: " + data);
					     $.each(data.hits.hits, function(idx, hit){
					    	 $('#idea_name').val(hit._source.idea_name);
					    	 $('#idea_description').val(hit._source.idea_description);
					    	 $('#idea_roi').val(hit._source.idea_roi)
					    	 $('#idea_business_unit').val(hit._source.idea_business_unit)
					    	 $('#idea_duedate').val(hit._source.idea_duedate)
					    	 $('#idea_skills').val(hit._source.idea_skills)
					    	 //hit._source.idea_business_unit 
					     }); 
					},
					error: function(xhr, ajaxOptions, thrownError) {
						alert("Error Occurred " + "HTTP Response Code: " + xhr.status);
						alert("Data: " + send2);
					    }
				});
			}
			vLoad();
		});