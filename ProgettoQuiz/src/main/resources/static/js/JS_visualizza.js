window.onload=(()=>{
	
		genera()
	
	
	document.getElementById("rispondi").addEventListener("click", submit);
	
	
})

function submit(){
		
		objR=scelta()
		fetch("/scelta",{
	method:"post",
	headers:{
			'content-Type':'application/json;charset=UTF-8'},
			body:JSON.stringify(objR)}
	).then(response => response.json())
	.then(data=>{
		var c=document.getElementById("corrette")
		
	
		
		if(data[2]==data[1]){
			 window.location.href = "/rp";
		}
		if(data[0]>0)	
		c.innerHTML=data[0]
		else
		c.innerHTML=0
		
		load();
		
		
	})
		
}

function dati(dataHtml){
	var domanda=document.getElementById("domanda")
	var r1=document.getElementById("l1")
	var r2=document.getElementById("l2")
	var r3=document.getElementById("l3")
	var r4=document.getElementById("l4")
	
	domanda.innerHTML=dataHtml.domanda
	r1.innerHTML=dataHtml.r1
	r2.innerHTML=dataHtml.r2
	r3.innerHTML=dataHtml.r3
	r4.innerHTML=dataHtml.r4
	
	console.log(dataHtml)
	
}

function scelta(){

		
		let lista={};
		let dom=document.getElementById("domanda");
		var sd=dom.innerText||dom.textContent;
		lista[sd]=false
	for(let i=0;i<4;i++){
		let d=document.getElementById("l"+(i+1));
		var s=d.innerText||d.textContent;
		var check=document.getElementById(""+(i+1));
		if(check.checked){
			lista[s]=true
		}else
		lista[s]=false
	}
	console.log(lista)


var radio=document.querySelectorAll('input[name="rbtn"]');

        radio.forEach(function(r) {
                r.checked = false;
            });
	
	return lista
	
}

function genera(){
	
	
	var f=document.getElementById("f");    
	var dom=document.createElement("label");
	dom.id="domanda";
	f.appendChild(dom)
	var br=document.createElement("br");
	
	let i=1;
	
	for(let y = 0; y < 4; y++){
	        
			var v=document.createElement("label");
			var radioBtn = document.createElement("input");
			
			v.id="l"+i;
			
			radioBtn.type = "radio";
			radioBtn.id = ""+i;
            radioBtn.name = "rbtn";
            radioBtn.value = false;
            radioBtn.textContent = "Opzione 1";
            
			
			i++;
	        f.appendChild(v);
	        f.appendChild(radioBtn);
	        
	        }
		
		
		
		var cor=document.createElement("label");
	    cor.innerText="Corrette";
	    var p=document.createElement("p");
	    p.id="corrette";
	    p.textContent=0;
	    f.appendChild(cor)
	    f.appendChild(p)
		
	    f.appendChild(br)
		var btn=document.createElement("button");
		btn.textContent="Rispondi";
		btn.type="button";
		btn.id="rispondi";
		btn.addEventListener("click", submit);
		f.appendChild(btn);
		load();
}
function load(){
	
		fetch("/load"
	).then(response => response.json())
		.then(data=>{
	
		    let quiz=data
			console.log(quiz.value+" Quiz")
			
			let domanda=quiz.domanda
			let r1=data.r1
			let r2=data.r2
			let r3=data.r3 
			let r4=data.r4
			console.log(domanda+" "+r1+" "+r2+" "+r3+" "+r4)
			
			dati(quiz)
			
		})
}


