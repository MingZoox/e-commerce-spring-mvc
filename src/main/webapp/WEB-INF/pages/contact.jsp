<%-- 
    Document   : contact
    Created on : 24-Nov-2018, 11:25:32 AM
    Author     : TVD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contact</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container">
		<div class="contact">
			<h2 class=" contact-in">CONTACT</h2>

			<div class="col-md-6 contact-top">
				<h3>Info</h3>
				<div class="map">
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3723.861118552001!2d105.78051921457939!3d21.03824229283124!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab354920c233%3A0x5d0313a3bfdc4f37!2sVNU%20University%20of%20Engineering%20and%20Technology!5e0!3m2!1sen!2s!4v1634469713599!5m2!1sen!2s"></iframe>
				</div>

				<p>At vero eos et accusamus et iusto odio dignissimos ducimus
					qui blanditiis praesentium voluptatum deleniti atque corrupti quos
					dolores et quas</p>
				<p>Et harum quidem rerum facilis est et expedita distinctio. Nam
					libero tempore, cum soluta nobis est eligendi optio cumque nihil
					impedit quo minus id</p>
				<ul class="social ">
					<li><span><i> </i>124 Avenue Street, Los
							angeles,California </span></li>
					<li><span><i class="down"> </i>+ 00 123 456 7890</span></li>
					<li><a href="mailto:info@example.com"><i class="mes">
						</i>info@example.com</a></li>
				</ul>
			</div>
			<div class="col-md-6 contact-top">
				<h3>Want to work with me?</h3>
				<div>
					<span>Your Name </span> <input type="text" value="" id="name">
				</div>
				<div>
					<span>Your Email </span> <input type="text" value="" id="email" >
				</div>
				<div>
					<span>Subject</span> <input type="text" value="" id="subject">
				</div>
				<div>
					<span>Your Message</span>
					<textarea id="message"> </textarea>
				</div>
				<input type="submit" value="SEND" onclick="post();myFunction()">
			</div>
			<div class="clearfix"></div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

	<script>
		function myFunction() {
			swal("Success!", "Thank you for your contacting!", "success").
			then((value)=>{
				location.reload();
			});
		}

		function post() {
			var name = $("#name").val();
			var email = $("#email").val();
			var subject = $("#subject").val();
			var message = $("#message").val();

			var settings = {
				"url" : "http://localhost:8080/java/sendcontact",
				"method" : "POST",
				"timeout" : 0,
				"headers" : {
					"Content-Type" : "application/json"
				},
				"data" : JSON.stringify({
					"name" : name,
					"email" : email,
					"subject" : subject,
					"message" : message
				}),
			};
			$.ajax(settings).done(function(response) {
				
			});
		}
	</script>
</body>
</html>
