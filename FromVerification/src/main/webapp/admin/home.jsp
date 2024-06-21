<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Mail Verification</title>
	<style>
		.heading {
            position: absolute;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        table, th, td {
            border: 1px solid black;
            width: 50%;
            border-spacing:4px;
        }
        .table-row {
            padding: 10px; /* Add padding to create space between rows */
        }
        .table-header {
            padding-right: 5px;
        }
        .input-field {
            width: 100%;
            padding: 5px;
        }
        input[type="text"], input[type="date"], input[type="email"], input[type="number"] {
            width: 80%;
            margin-left: 40px;
            border: 1px solid white;
            text-align: center;
        }
        .table-data {
            padding: 5px;
        }
        .tables {
            position: absolute;
            margin-top: 50px;
            margin-left: 370px;
        }
	</style>
</head>
<body>
	<h1 class="heading">FILL THE FORM</h1>
	<form action="addDetails">
		<table class="tables">
			<tr class="table-row">
				<th class="table-header">Registration Number</th>
				<td class=table-data>
					<input type="number" name="registerNumber" placeholder="Enter your roll number" class="input-field" required>
				</td>
			</tr>
			<tr class="table-row">
				<th class="table-header">First Name</th>
				<td class="table-data">
					<input type="text" name="firstName" placeholder="Enter your first name" class="input-field" required>
				</td>
			</tr>
			<tr class="table-row">
				<th class="table-header">Last Name</th>
				<td class="table-data">
					<input type="text" name="lastName" placeholder="Enter your last name" class="input-field" required>
				</td>
			</tr>
			<tr class="table-row">
				<th class="table-header">Date of Birth</th>
				<td class="table-data">
					<input type="date" name="dob" class="input-field" required>
				</td>
			</tr>
			<tr class="table-row">
				<th class="table-header">Gender</th>
				<td class="table-data">
					<input type="text" name="gender" placeholder="Enter your gender" class="input-field" required>
				</td>
			</tr>
			<tr class="table-row">
				<th class="table-header">Email ID</th>
				<td class="table-data">
					<input type="email" name="email" placeholder="Enter your email id" class="input-field" required>
				</td>
			</tr>
			<tr class="table-row">
				<th class="table-header">Phone Number</th>
				<td class="table-data">
					<input type="text" name="phoneNumber" placeholder="Enter your phone number" class="input-field"  required>
				</td>
			</tr>
			<tr class="table-row">
				<th class="table-header">City</th>
				<td class="table-data">
					<input type="text" name="city" placeholder="Enter your city name" class="input-field" required>
				</td>
			</tr>
			<tr class="table-row">
				<th class="table-header">Department</th>
				<td class="table-data">
					 <select name="department" class="input-field" required>
					 	<option disabled selected>Choose you department</option>
	                    <option value="cse">CSE</option>
	                    <option value="ece">ECE</option>
	                    <option value="eee">EEE</option>
	                    <option value="it">IT</option>
	                    <option value="aids">AIDS</option>
	                    <option value="civil">CIVIL</option>
	                    <option value="mech">MECHANICAL</option>
	                </select>
				</td>
			</tr>
			<tr class="table-row">
				<th class="table-header">Address</th>
				<td class="table-data">
					<textarea name="address" class="input-field" placeholder="Enter your address" rows="5" cols="5" style="width:96.5%" required></textarea>
				</td>
			</tr>
			<tr class="table-row">
				<th class="table-header">Residential Status</th>
				<td class="table-data">
					<input type="radio" name="residentialStatus" value="D" style="margin-left:100px" required>D
					<input type="radio" name="residentialStatus" value="H" style="margin-left:50px">H
				</td>
			</tr>
			<tr class="table-row">
				<th class="table-header">Placement Involvement</th>
				<td class="table-data">
					<input type="radio" name="placement" value="Y" style="margin-left:100px" required>Yes
					<input type="radio" name="placement" value="N" style="margin-left:50px">No
				</td>
			</tr>
			<tr>
				<th colspan="2" style="padding:10px">
					<input type="submit" value="Submit" style="padding:6px" class="Submitting">
				</th>
			</tr>
		</table>
	</form>
<script>
	document.querySelector('.Submitting').addEventListener('click', function(event) {
	    alert("Form is submitted successfully and verification mail has been sent to the specified email id.");
	});
</script>
</body>
</html>