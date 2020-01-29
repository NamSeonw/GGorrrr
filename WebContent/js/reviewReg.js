window.addEventListener("load", function() {
	// 현재비밀번호
	
	var div = document.querySelector("#star-rating");
	var imgs = document.querySelectorAll("#star-rating img");
	//var imgs = document.querySelector("#star-rating");
	var star = document.querySelector("#star-rating>input");
	var add=0;

	// var newTextBox = section.getElementsByClassName("new-pwd")[0]; //
	// 새비밀번호입력란
	// var newTextBox2 = section.getElementsByClassName("new-pwd2")[0]; //
	// 새비밀번호확인입력란
	// var newButton = section.getElementsByClassName("new-check-button")[0];

	div.onclick = function(e) {
		
		if (e.target.nodeName != 'IMG')
			return;
	

		if (e.target.src == "http://192.168.0.83:8080/images/binstar2.png"){
			star.value="0";	
			if(e.target.name=="star1"){
				imgs[0].src = "/images/bookmark2.png";
				add=Number(star.value)+1;
			}
			else if(e.target.name=="star2"){
				imgs[0].src = "/images/bookmark2.png";
				imgs[1].src = "/images/bookmark2.png";
				add=Number(star.value)+2;
			}
			else if(e.target.name=="star3"){
				imgs[0].src = "/images/bookmark2.png";
				imgs[1].src = "/images/bookmark2.png";
				imgs[2].src = "/images/bookmark2.png";
				add=Number(star.value)+3;
			}
			else if(e.target.name=="star4"){
				imgs[0].src = "/images/bookmark2.png";
				imgs[1].src = "/images/bookmark2.png";
				imgs[2].src = "/images/bookmark2.png";
				imgs[3].src = "/images/bookmark2.png";
				add=Number(star.value)+4;
			}
			else if(e.target.name=="star5"){
				imgs[0].src = "/images/bookmark2.png";
				imgs[1].src = "/images/bookmark2.png";
				imgs[2].src = "/images/bookmark2.png";
				imgs[3].src = "/images/bookmark2.png";
				imgs[4].src = "/images/bookmark2.png";
			    add=Number(star.value)+5;
			}	
			
		}
		
		else if(e.target.src == "http://192.168.0.83:8080/images/bookmark2.png"){
				e.target.src = "/images/binstar2.png";
				add=Number(star.value)-1;
			}

		
		star.value=String(add);
		console.log(star.value);
	};
});
