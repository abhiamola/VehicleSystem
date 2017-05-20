function validLogin()
{
	document.getElementById("umsg").innerHTML="";
	document.getElementById("pmsg").innerHTML="";
	var uVar = document.forms["myForm"]["uId"].value;
	var flag=true;
	if(!uVar)
	{
		document.getElementById("umsg").innerHTML="User ID cannot be blank";
		flag=false;
	}
	else if(!uVar.match("([0-9]{6})") || uVar.length>6  )
	{
		document.getElementById("umsg").innerHTML="User ID should be number of 6 digits";
		flag=false;
	}
	var pVar = document.forms["myForm"]["pass"].value;
	if(!pVar)
	{
		document.getElementById("pmsg").innerHTML="Password cannot be blank";
		flag=false;
	}
	return flag;
}

function validRegister()
{
	document.getElementById("umsg").innerHTML="";
	document.getElementById("pmsg").innerHTML="";
	document.getElementById("pmsg1").innerHTML="";
	document.getElementById("unmsg").innerHTML="";
	document.getElementById("emsg").innerHTML="";
	var uVar = document.forms["myForm"]["uId"].value;
	var flag=true;
	var cVar = document.forms["myForm"]["uName"].value;
	if(!cVar)
	{
		document.getElementById("unmsg").innerHTML="Customer Name cannot be blank";
		flag=false;
	}
	else if(!cVar.match("^[a-z A-Z]{1,}$"))
	{
		document.getElementById("unmsg").innerHTML="Customer Name should not contain numeric or special characters";
		flag=false;
	}
	if(!uVar)
	{
		document.getElementById("umsg").innerHTML="User ID cannot be blank";
		flag=false;
	}
	else if(!uVar.match("([0-9]{6})") || uVar.length>6)
	{
		document.getElementById("umsg").innerHTML="User ID should be number of 6 digits";
		flag=false;
	}
	var pVar = document.forms["myForm"]["pass"].value;
	if(!pVar)
	{
		document.getElementById("pmsg").innerHTML="Password cannot be blank";
		flag=false;
	}
	else if(!pVar.match("^(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,20}"))
	{
		document.getElementById("pmsg").innerHTML="Password length should have minimum 8 chars and max 20 chars, at least 1 special chars and at least 1 number";
		flag=false;
	}
	var pVar1 = document.forms["myForm"]["pass1"].value;
	if(pVar1!=pVar)
	{
		document.getElementById("pmsg1").innerHTML="Password Not Matching";
		flag=false;
	}
	var eVar = document.forms["myForm"]["email"].value;
	if(!eVar)
	{
		document.getElementById("emsg").innerHTML="Email cannot be blank";
		flag=false;
	}
	else if(!eVar.match("^[a-z0-9._%+-]+@[a-z0-9.-]+[\.][a-z]{2,3}$"))
	{
		document.getElementById("emsg").innerHTML="Email should be in correct format";
		flag=false;
	}
	return flag;
}

function validUpd()
{
	document.getElementById("cmsg").innerHTML="";
	document.getElementById("dmsg").innerHTML="";
	document.getElementById("amsg").innerHTML="";
	document.getElementById("pmsg").innerHTML="";
	document.getElementById("emsg").innerHTML="";
	document.getElementById("omsg").innerHTML="";
	var cVar = document.forms["myForm"]["cName"].value;
	var flag=true;
	if(!cVar)
	{
		document.getElementById("cmsg").innerHTML="Customer Name cannot be blank";
		flag=false;
	}
	else if(!cVar.match("^[a-z A-Z]{1,}$"))
	{
		document.getElementById("cmsg").innerHTML="Customer Name should not contain numeric or special characters";
		flag=false;
	}
	var dVar = document.forms["myForm"]["dob"].value;
	if(!dVar)
	{
		document.getElementById("dmsg").innerHTML="DOB cannot be blank";
		flag=false;
	}
	else if(!dVar.match("^[0-9]{4}[-](0?[1-9]|1[012])[-](0?[1-9]|[12][0-9]|3[01])$"))
	{
		document.getElementById("dmsg").innerHTML="DOB should be in yyyy-mm-dd format and follow basic date rules";
		flag=false;
	}
	var aVar = document.forms["myForm"]["add"].value;
	if(!aVar)
	{
		document.getElementById("amsg").innerHTML="Address cannot be blank";
		flag=false;
	}
	var pVar = document.forms["myForm"]["phNo"].value;
	if(!pVar)
	{
		document.getElementById("pmsg").innerHTML="Phone number cannot be blank";
		flag=false;
	}
	else if(!pVar.match("^[0-9]{3}[-]([0-9]{7})$"))
	{
		document.getElementById("pmsg").innerHTML="Phone number format should be XXX-XXXXXXX";
		flag=false;
	}
	var eVar = document.forms["myForm"]["email"].value;
	if(!eVar)
	{
		document.getElementById("emsg").innerHTML="Email cannot be blank";
		flag=false;
	}
	else if(!eVar.match("^[a-z0-9._%+-]+@[a-z0-9.-]+[\.][a-z]{2,3}$"))
	{
		document.getElementById("emsg").innerHTML="Email should be in correct format";
		flag=false;
	}
	var eVar = document.forms["myForm"]["occ"].value;
	if(!eVar)
	{
		document.getElementById("omsg").innerHTML="Occupation cannot be blank";
		flag=false;
	}
	return flag;
}

function validBranchUpd()
{
	document.getElementById("bmsg").innerHTML="";
	document.getElementById("amsg").innerHTML="";
	document.getElementById("pmsg").innerHTML="";
	document.getElementById("emsg").innerHTML="";
	var bVar = document.forms["myForm"]["bLoc"].value;
	var flag=true;
	if(!bVar)
	{
		document.getElementById("bmsg").innerHTML="Branch Location cannot be blank";
		flag=false;
	}
	else if(!bVar.match("^[a-z A-Z 0-9]{1,}$"))
	{
		document.getElementById("bmsg").innerHTML="Branch Location should not contain special characters";
		flag=false;
	}
	var aVar = document.forms["myForm"]["add"].value;
	if(!aVar)
	{
		document.getElementById("amsg").innerHTML="Address cannot be blank";
		flag=false;
	}
	
	var eVar = document.forms["myForm"]["email"].value;
	if(!eVar)
	{
		document.getElementById("emsg").innerHTML="Email cannot be blank";
		flag=false;
	}
	else if(!eVar.match("^[a-z0-9._%+-]+@[a-z0-9.-]+[\.][a-z]{2,3}$"))
	{
		document.getElementById("emsg").innerHTML="Email should be in correct format";
		flag=false;
	}
	
	var pVar = document.forms["myForm"]["phNo"].value;
	if(!pVar)
	{
		document.getElementById("pmsg").innerHTML="Phone number cannot be blank";
		flag=false;
	}
	else if(!pVar.match("^[0-9]{3}[-]([0-9]{7})$"))
	{
		document.getElementById("pmsg").innerHTML="Phone number format should be XXX-XXXXXXX";
		flag=false;
	}
	
	return flag;
}

