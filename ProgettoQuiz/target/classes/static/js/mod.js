window.onload=(()=>{
	
	genera()
	onsubmit= e=>{
	e.preventDefault()
		submit()
		}
})
function genera(){
	
	var f=document.getElementById("f");
	 
	 var d=document.createElement("label")
	 var d1= document.createElement("input")
	 var br1=document.createElement("br");
	 
	 var r1=document.createElement("label")
	 var i1= document.createElement("input")
	 var b1=document.createElement("input")
	 var br2=document.createElement("br");
	 
	 var r2=document.createElement("label")
	 var i2= document.createElement("input")
	 var b2=document.createElement("input")
	 var br3=document.createElement("br");
	 
	 
	 var r3=document.createElement("label")
	 var i3= document.createElement("input")
	 var b3=document.createElement("input")
	 var br4=document.createElement("br");
	 
	 var r4=document.createElement("label")
	 var i4= document.createElement("input")
	 var b4=document.createElement("input")
	 var br5=document.createElement("br");
	 
	 
	 d.textContent="Inserisci domanda";
	 d1.id="d1";
	 d1.type="text";
	 
	 r1.textContent="Inserisci risposta A";
	 r2.textContent="Inserisci risposta B";
	 r3.textContent="Inserisci risposta C";
	 r4.textContent="Inserisci risposta D";
	 
	 i1.id="i1";
	 i2.id="i2";
	 i3.id="i3";
	 i4.id="i4";
	 
	 i1.type="text";
	 i2.type="text";
	 i3.type="text";
	 i4.type="text";
	 
	 
	 b1.id="b1";
	 b2.id="b2";
	 b3.id="b3";
	 b4.id="b4";
	 
	 b1.value=false;
	 b2.value=false;
	 b3.value=false;
	 b4.value=false;
	 
	 b1.type="radio";
	 b2.type="radio";
	 b3.type="radio";
	 b4.type="radio";
	 
	 b1.name="rb";
	 b2.name="rb";
	 b3.name="rb";
	 b4.name="rb";
	
	 
	 
	 
	 f.appendChild(d)
	 f.appendChild(d1)
	 f.appendChild(br1)
	 f.appendChild(r1)
	 f.appendChild(i1)
	 f.appendChild(b1)
	 f.appendChild(br2)
	 f.appendChild(r2)
	 f.appendChild(i2)
	 f.appendChild(b2)
	 f.appendChild(br3)
	 f.appendChild(r3)
	 f.appendChild(i3)
	 f.appendChild(b3)
	 f.appendChild(br4)
	 f.appendChild(r4)
	 f.appendChild(i4)
	 f.appendChild(b4)
	 f.appendChild(br5)
	 
	 var btn=document.createElement("button");
		btn.textContent="Modifica Domanda";
		btn.type="submit";
		f.appendChild(btn)
	 }
	 
	 function submit(){
	let lista={};	 
		 
	let domanda=document.getElementById("d1").value
	let r1=document.getElementById("i1").value
	let r2=document.getElementById("i2").value
	let r3=document.getElementById("i3").value
	let r4=document.getElementById("i4").value
	
	var check1=document.getElementById("b1")
	var check2=document.getElementById("b2")
	var check3=document.getElementById("b3")
	var check4=document.getElementById("b4")
	
	if(check1.checked){
		check1=true
		}else{
		check1=false}
	if(check2.checked){
		check2=true
		}else{
		check2=false}
	if(check3.checked){
		check3=true
		}else{
		check3=false}
	if(check4.checked){
		check4=true
		}else{
		check4=false}
		
		lista.domanda=domanda
		lista.r1=r1;
	    lista.r2=r2;
	    lista.r3=r3;
	    lista.r4=r4;
	    
	    lista.i1=check1
	    lista.i2=check2
	    lista.i3=check3
	    lista.i4=check4
	
	console.log(lista)
	
	

	
	fetch("/k/restDom",{
		
		method:"post",
		
		headers:{
			'content-Type':'application/json;charset=UTF-8'
		},
		body:JSON.stringify(lista)
		}).then(response=>{
	if (!response.ok) {
      throw new Error('Errore nella richiesta: ' + response.statusText);
    }
		window.location.href = "/a";
		})
		
	
		}