window.addEventListener("load", function() {
	//현재비밀번호
	var section = document.getElementById("change-pwd"); // div

	var hiddenTextBox = section.getElementsByClassName("now-pwd")[0]; // 현재비밀번호입력란
	var nowTextBox = section.getElementsByClassName("now-pwd2")[0]; // 현재비밀번호입력란
	var nowButton = section.getElementsByClassName("now-check-button")[0];
	var nowCheckLabel = section.getElementsByClassName("now-check-text")[0];

	//var newTextBox = section.getElementsByClassName("new-pwd")[0]; // 새비밀번호입력란
	//var newTextBox2 = section.getElementsByClassName("new-pwd2")[0]; // 새비밀번호확인입력란
	//var newButton = section.getElementsByClassName("new-check-button")[0];

	nowButton.onclick = function() {
		if (nowTextBox.value==hiddenTextBox.value)
			nowCheckLabel.innerText="비밀번호가 일치합니다.";
	     else
	    	 nowCheckLabel.innerText="비밀번호가 틀렸습니다.";
	}
	
	//새로운비밀번호
	var newTextBox = section.getElementsByClassName("new-pwd")[0]; // 현재비밀번호입력란
	var newTextBox2 = section.getElementsByClassName("new-pwd2")[0];
	var newButton = section.getElementsByClassName("new-check-button")[0];
	var newCheckLabel = section.getElementsByClassName("new-check-text")[0];
	
	newButton.onclick = function() {
		if(nowTextBox.value!=""){
			
			if (newTextBox.value==newTextBox2.value)
				newCheckLabel.innerText="새비밀번호로 가능합니다.";
			
			else
				newCheckLabel.innerText="새비밀번호로 불가능합니다.";
		}
		else
			newCheckLabel.innerText="현재비밀번호를 입력하세요.";
	}

});
