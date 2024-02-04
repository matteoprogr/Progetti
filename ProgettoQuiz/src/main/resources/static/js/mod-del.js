window.onload=(()=>{
     
     let c=0;
	genera()
	
	document.getElementById("modifica").addEventListener("click", submit);

    document.getElementById("cancella").addEventListener("click", canc);

})

function genera(){
	
		fetch("/k/md"	
	).then(response=>response.json())
	.then(data=>{
		let obj=data
		console.log(obj)
		
	    var f=document.getElementById("f");
		let i=1;
		
		obj.forEach(function(dom){
			var v=document.createElement("label");
			var radioBtn = document.createElement("input");
			var br=document.createElement("br");
			
			v.id=""+i;
			v.textContent=dom.testo;
			radioBtn.type = "radio";
			radioBtn.id = "rb"+i;
            radioBtn.name = "rbtn";
            radioBtn.value = false;
            radioBtn.textContent = "Opzione 1";
            
			
			i++;
	        f.appendChild(v);
	        f.appendChild(radioBtn);
	        f.appendChild(br)
	        
	        c=v.id
		})
		console.log("c:"+c)
	
		var btn=document.createElement("button");
		btn.textContent="Modifica";
		btn.type="button";
		btn.id="modifica";
		btn.addEventListener("click", submit);
       

		
		var btnC=document.createElement("button");
		btnC.textContent="Cancella";
		btnC.type="button";
		btnC.id="cancella";
		btnC.addEventListener("click", canc);
		
		
		f.appendChild(btn)
		f.appendChild(btnC)
		
	})
}

function submit(){
	
	console.log("C "+c)
	
	let domanda1=document.getElementById("1");
	
	if(domanda1){
		console.log("trovata")
	}else
	console.error("non trovata")
	
	let lista={};
	for(let i=0;i<c;i++){
		let d=document.getElementById(i+1);
		var s=d.innerText||d.textContent;
		var check=document.getElementById("rb"+(i+1))
		if(check.checked){
			lista[s]=true
		}else
		lista[s]=false
	}
	console.log(lista)
	
	
	
	fetch("/k/scelta",{
	method:"post",
	headers:{
			'content-Type':'application/json;charset=UTF-8'},
			body:JSON.stringify(lista)
	}).then(response=>{
	if (!response.ok) {
      throw new Error('Errore nella richiesta: ' + response.statusText);
    }
	})
	.catch(error => {
    console.error('Errore durante la richiesta:', error);
  });
   window.location.href = "/z";
}

function canc(){
	
	console.log("C "+c)
	
	let domanda1=document.getElementById("1");
	
	if(domanda1){
		console.log("trovata")
	}else
	console.error("non trovata")
	
	let lista={};
	for(let i=0;i<c;i++){
		let d=document.getElementById(i+1);
		var s=d.innerText||d.textContent;
		var check=document.getElementById("rb"+(i+1))
		if(check.checked){
			lista[s]=true
		}else
		lista[s]=false
	}
	console.log(lista)
	
	
	fetch("/k/cancella",{
	method:"post",
	headers:{
			'content-Type':'application/json;charset=UTF-8'},
			body:JSON.stringify(lista)
	}).then(response=>{
	if (!response.ok) {
      throw new Error('Errore nella richiesta: ' + response.statusText);
    }
	})
	.catch(error => {
    console.error('Errore durante la richiesta:', error);
  });
   window.location.href = "/a";
}

