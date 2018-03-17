function changeModel(){

var x= document.vehicleReg.make.options[document.vehicleReg.make.selectedIndex].value;


if(x=="BMW")
{
	document.getElementById("model").innerHTML='<option value="">--Select--</option><option value="128I">128I</option><option value="M3">M3</option><option value="M5">M5</option><option value="M6">M6</option><option value="X3">X3</option><option value="X5">X5</option><option value="X6">X6</option>';
}
else if(x=="CHEVROLET")
{
	document.getElementById("model").innerHTML='<option value="">--Select--</option><option value="AVEO">AVEO</option><option value="CAMERO">CAMERO</option><option value="SILVERADO">SILVERADO</option><option value="SUBURBAN">SUBURBAN</option><option value="TRAVERSE">TRAVERSE</option>';
}
else if(x=="FORD")
{
document.getElementById("model").innerHTML='<option value="">--Select--</option><option value="CROWN">CROWN</option><option value="VICTORIA">VICTORIA</option><option value="ESCAPE">ESCAPE</option><option value="FUSION">FUSION</option><option value="RANGER">RANGER</option><option value="TAURUS">TAURUS</option>';
}

else if(x=="HONDA")
{
document.getElementById("model").innerHTML='<option value="">--Select--</option><option value="ACCORD">ACCORD</option><option value="CIVIC">CIVIC</option><option value="FIT">FIT</option><option value="PILOT">PILOT</option>';
}

else if(x=="HYUNDAI")
{
document.getElementById("model").innerHTML='<option value="">--Select--</option><option value="ACCENT">ACCENT</option><option value="AZERA">AZERA</option><option value="ELANTRA">ELANTRA</option><option value="SONATA">SONATA</option>';
}

else if(x=="TOYOTA")
{
document.getElementById("model").innerHTML='<option value="">--Select--</option><option value="AVALON">AVALON</option><option value="CAMRY">CAMRY</option><option value="COROLLA">COROLLA</option><option value="TUNDRA">TUNDRA</option>';
}


}