var form_check = false;

   $(function() {
   	$('#user_id').change(function() {
   		$('#check-button').show();
   		$('#check-image').hide();
   		form_check = false;
   	});

   	$('#check-button').click(function() {
   		var user_id = $('#user_id').val();

   		if (user_id == '') {
   			return;
   		}

   		/* Ajax 통신!*/
   		$.ajax({
   			url : "http://localhost:8080/susinsa_backend/api/user/join/check/id?user_id=" + user_id,
   			type : "GET",
   			dataType : "json",
   			data : "",
   			success : function(response) {
   				if (response.result != "success") {
   					console.error(response.message);
   					return;
   				}

   				if (response.data == true) {
   					$('#check-button').hide();
   					$('#check-image').show();
   					form_check = true;
   				}

   				if (response.data == false) {
   					alert('이미 존재하는 아이디입니다.');
   					$('#user_id').focus();
   					$('#user_id').val("");

   					return;
   				}
   			},
   			error : function(xhr, error) {
   				console.error("error " + error);
   			}
   		});
   		console.log(user_id);
   	});
   });