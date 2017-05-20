function retValid()
{
	

var msg=null;
if(document.forms["search_form"]["seating"].value=="")
	{
	msg="Pleasse Enter all the fields to continue";
	}

if(msg!=null)
	{
	document.getElementById("Error").innerHTML=msg;
	return false;
	}
return true;

}