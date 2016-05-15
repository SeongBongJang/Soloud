window.onload = function()
{
	document.getElementById("drop_button").onmouseover = function()	{
		this.src="/Soloud/image/drop/drop2.jpg";				
	};
	document.getElementById("drop_button").onmouseout = function()	{
		this.src="/Soloud/image/drop/drop.jpg";	
	};
	document.getElementById("cancel_button").onmouseover = function()	{
		this.src="/Soloud/image/drop/cancel.jpg";				
	};
	document.getElementById("cancel_button").onmouseout = function()	{
		this.src="/Soloud/image/drop/cancel2.jpg";	
	};
};