/**
 * 
 */
window.addEventListener("load", function() {
	// 현재 패스워드 일치 확인때 필요한 영역 설정
	var nowPwdSection = document.querySelector("#change-pwd");
	var nowPwdInput = nowPwdSection.querySelector('dd input[name="nowPwd"]');
	var nowPwd = nowPwdSection.querySelector('dd input[name="nowPwdCheck"]');
	var nowPwdTextLabel = document.querySelector(".now-pwd-check-text");

	// 현재 패스워드 확인
	nowPwdInput.onkeyup = function() {
		if (nowPwdInput.value == nowPwd.value)
			nowPwdTextLabel.innerText = "";
		else
			nowPwdTextLabel.innerText = "현재 비밀번호를 확인해주세요.";
	}

	// 새로운 패스워드 일치 확인때 필요한 영역 설정
	var newPwdSection = document.querySelector("#new-pwd");
	var newPwdInput = newPwdSection.querySelector("dd input");
	var newPwdChk = newPwdSection.querySelector("dd~dd input");
	var newPwdTextLabel = document.querySelector(".new-pwd-check-text");

	// 새로운 비밀번호 확인
	newPwdChk.onkeyup = function() {
		if (newPwdInput.value == newPwdChk.value)
			newPwdTextLabel.innerText = "비밀번호가 일치합니다.";
		else
			newPwdTextLabel.innerText = "비밀번호가 다릅니다.";
	}

	var pageSection = document.querySelector("#pageSection");
	var btn = pageSection.querySelector('input[name="commit"]');

});
