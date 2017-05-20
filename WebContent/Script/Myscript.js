function validate()
{
	
	
	var flag = true;
	
	document.getElementById("cPartMsg").innerHTML="";
	
	
	var partStrengthVar = document.getElementById("numberreq").value;
	if(!partStrengthVar)
	{
		document.getElementById("cPartMsg").innerHTML="No. of Vehicles to request cannot be Empty";
		flag = false;
	}
	if(isNaN(partStrengthVar))
	{
		document.getElementById("cPartMsg").innerHTML="should be a number";
		flag = false;
	}
		return flag;
	}