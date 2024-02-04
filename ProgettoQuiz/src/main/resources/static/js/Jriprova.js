window.onload=(()=>{
	genera()
	
	
	document.getElementById("rigioca").addEventListener("click", submit);
	
})
function genera(){
	
	fetch("/ris"	
	).then(response=>response.json())
	.then(data=>{
		let obj=data
		console.log(data)
		
	let u=obj[0];
	let t=obj[1];
	
    var f=document.getElementById("f");    
    
	var dom=document.createElement("button");
	var ris=document.createElement("label");
	
	
	ris.textContent="Giuste: "+u+" su "+t;
	
	dom.type="button";
	dom.id="rigioca";
	dom.textContent="Rigioca";
	
	f.append(ris)
	f.appendChild(dom)
	dom.addEventListener("click",submit)
		
	})
	
}
function submit(){
	window.location.href = "/v";
}

