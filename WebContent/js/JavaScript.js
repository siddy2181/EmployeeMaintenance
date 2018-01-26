function validateAge() {
	var value = document.getElementById("txtDateOfBirth").value;
	var today = new Date();
	var givenDate = new Date(value);
	var age = today.getFullYear() - givenDate.getFullYear();
	// alert(today.getFullYear()+" "+age+" "+givenDate.getFullYear());
	if (age <= 18 || age >= 58) {
		// alert("Invalid Age");
		var errName = document.getElementById("dobErr");
		errName.innerHTML = "Date of birth should be greater than 18 and less than 58";
		return false;
	} else {
		var errName = document.getElementById("dobErr");
		errName.innerHTML = " ";
		return true;
	}

}

function validateDateOfJoining() {
	var dob = document.getElementById("txtDateOfBirth").value;
	var doj = document.getElementById("txtDateOfJoining").value;
	var dobDate = new Date(dob).getFullYear();
	var dojDate = new Date(doj).getFullYear();

	if (dojDate < dobDate + 18 || dojDate > dobDate + 58) {
		var errName = document.getElementById("dojErr");
		errName.innerHTML = "Invalid Date of Joining";
		return false;

	} else {
		var errName = document.getElementById("dojErr");
		errName.innerHTML = " ";
		return true;
	}
}

function validate(){
	if(validateAge()==true && validateDateOfJoining()==true){
		return true;
	}else{
		return false;
	}
}


