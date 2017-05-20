function validateForm(){
	var flag = true;
	document.getElementById("mNameMsg").innerHTML = "";
	document.getElementById("vCodeMsg").innerHTML = "";
	document.getElementById("exPriceMsg").innerHTML = "";
	document.getElementById("colourMsg").innerHTML = "";
	document.getElementById("vAvailableMsg").innerHTML = "";
	document.getElementById("sCapacityMsg").innerHTML = "";
	document.getElementById("stockDateMsg").innerHTML = "";
	document.getElementById("bLocationMsg").innerHTML = "";
	
	var mNameVar = document.getElementById("mName").value;
	if(!mNameVar)
	{
		document.getElementById("mNameMsg").innerHTML="Manufacturer's Name Cannot be Empty";
		flag = false;
	}
	var vCodeVar = document.getElementById("vCode").value;
	if(!vCodeVar)
	{
		document.getElementById("vCodeMsg").innerHTML="Vehicle Code Cannot be Empty";
		flag = false;
	}
	var exPriceVar = document.getElementById("exPrice").value;
	if(!exPriceVar)
	{
		document.getElementById("exPriceMsg").innerHTML="Ex Showroom Price Cannot be Empty";
		flag = false;
	}
	var colourVar = document.getElementById("colour").value;
	if(!colourVar)
	{
		document.getElementById("colourMsg").innerHTML="Vehicle colour Cannot be Empty";
		flag = false;
	}
	var vAvailableVar = document.getElementById("vAvailable").value;
	if(!vAvailableVar)
	{
		document.getElementById("vAvailableMsg").innerHTML="Available Vehicle Cannot be Empty";
		flag = false;
	}
	var sCapacityVar = document.getElementById("sCapacity").value;
	if(!sCapacityVar)
	{
		document.getElementById("sCapacityMsg").innerHTML="Seating Capacity Cannot be Empty";
		flag = false;
	}
	var stockDateVar = document.getElementById("stockDate").value;
	if(!stockDateVar)
	{
		document.getElementById("stockDateMsg").innerHTML="Date of Stock Cannot be Empty";
		flag = false;
	}
	var bLocationVar = document.getElementById("bLocation").value;
	if(!bLocationVar)
	{
		document.getElementById("bLocationMsg").innerHTML="Branch Location Cannot be Empty";
		flag = false;
	}
	if(isNaN(exPriceVar))
	{
		document.getElementById("exPriceMsg").innerHTML="ExShowroom Price should be a number";
		flag = false;
	}
	if(isNaN(vAvailableVar))
	{
		document.getElementById("vAvailableMsg").innerHTML="Available Vehicle should be a number";
		flag = false;
	}
	if(isNaN(sCapacityVar))
	{
		document.getElementById("sCapacityMsg").innerHTML="Seating Capacity should be a number";
		flag = false;
	}
	var matches = /^(\d{1,2})[-\/][a-zA-Z]{3}[-\/](\d{4})$/.exec(stockDateVar);
    if (matches == null){
      document.getElementById("stockDateMsg").innerHTML="Enter valid Date in dd-Mon-yyyy Format";
      flag = false;
    }

	return flag;
}

function atLeastOneRadio() {
	if(document.getElementById("approveRequest").checked == false){
		alert("first not selected");
	}
    return false;
}

function check(){
    var radios = document.getElementsByName("approveRequest");

    for (var i = 0, len = radios.length; i < len; i++) {
         if (radios[i].checked) {
             flag = true;
             break;
         }
         else{
        	 flag = false;
         }
    }
    if(flag){
    	return flag;
    }
    else{
    	alert("Select an Entry");
    }
    return flag;
}