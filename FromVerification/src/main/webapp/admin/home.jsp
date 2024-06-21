<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mail Verification</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <style>
    	body{
    		background:linear-gradient(270deg,rgba(204,153,255),rgba(229,204,255),rgba(255,204,255));
    	}
    	.container{
    		background-color:white;
    	}
        .heading {
            text-align: center;
        }
        .form-container {
            max-width: 600px;
            margin: auto;
            margin-top: 20px;
            padding: 20px;
            border: 1px solid black;
            border-radius: 5px;
            backgound-color:white;
        }
        .input-field {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
        }
        .radio-label {
            margin-right: 20px;
        }
        .submit-btn {
            padding: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="heading">FILL THE FORM</h1>
        <div class="form-container">
            <form action="addDetails">
                <div class="form-group">
                    <label for="registerNumber">Registration Number</label>
                    <input type="number" name="registerNumber" id="registerNumber" class="form-control input-field" placeholder="Enter your roll number" required>
                </div>
                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input type="text" name="firstName" id="firstName" class="form-control input-field" placeholder="Enter your first name" required>
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input type="text" name="lastName" id="lastName" class="form-control input-field" placeholder="Enter your last name" required>
                </div>
                <div class="form-group">
                    <label for="dob">Date of Birth</label>
                    <input type="date" name="dob" id="dob" class="form-control input-field" required>
                </div>
                <div class="form-group">
                    <label for="gender">Gender</label>
                    <input type="text" name="gender" id="gender" class="form-control input-field" placeholder="Enter your gender" required>
                </div>
                <div class="form-group">
                    <label for="email">Email ID</label>
                    <input type="email" name="email" id="email" class="form-control input-field" placeholder="Enter your email id" required>
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Phone Number</label>
                    <input type="text" name="phoneNumber" id="phoneNumber" class="form-control input-field" placeholder="Enter your phone number" required>
                </div>
                <div class="form-group">
                    <label for="city">City</label>
                    <input type="text" name="city" id="city" class="form-control input-field" placeholder="Enter your city name" required>
                </div>
                <div class="form-group">
                    <label for="department">Department</label>
                    <select name="department" id="department" class="form-control input-field" required>
                        <option disabled selected>Choose your department</option>
                        <option value="cse">CSE</option>
                        <option value="ece">ECE</option>
                        <option value="eee">EEE</option>
                        <option value="it">IT</option>
                        <option value="aids">AIDS</option>
                        <option value="civil">CIVIL</option>
                        <option value="mech">MECHANICAL</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>Address</label>
                    <textarea name="address" id="address" class="form-control input-field" placeholder="Enter your address" rows="5" required></textarea>
                </div>
                <div class="form-group">
                    <label>Residential Status</label>
                    <div>
                        <input type="radio" name="residentialStatus" id="resD" value="D" class="radio-label" required>
                        <label for="resD">D</label>
                        <input type="radio" name="residentialStatus" id="resH" value="H" class="radio-label">
                        <label for="resH">H</label>
                    </div>
                </div>
                <div class="form-group">
                    <label>Placement Involvement</label>
                    <div>
                        <input type="radio" name="placement" id="placeY" value="Y" class="radio-label" required>
                        <label for="placeY">Yes</label>
                        <input type="radio" name="placement" id="placeN" value="N" class="radio-label">
                        <label for="placeN">No</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary submit-btn">Submit</button>
            </form>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies (if needed) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js" integrity="sha384-ZmpFv2ATKWIqK3x+5NE5gFiFCGjKb0EGv4kLrGQtnYxK2xtBZQK9al8+QhhH2J5Z" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    <script>
        // Example of handling form submission with an alert
        document.querySelector('.submit-btn').addEventListener('click', function(event) {
        	if(document.getElementById('registerNumber'))
            alert("Form is submitted successfully and verification mail has been sent to the specified email id.");
        });
    </script>
</body>
</html>
