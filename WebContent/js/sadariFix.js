window.addEventListener("scroll", function() {
	var sadariSection = document.querySelector("#sadari");
	var sadariPopup = sadariSection.querySelector("div");
	var footer = document.querySelector("#footer");

	var absoluteSadariTop = window.pageYOffset
			+ sadariPopup.getBoundingClientRect().top;
	var absolutefooterTop = window.pageYOffset
			+ footer.getBoundingClientRect().top;

	if (absoluteSadariTop + 105 >= absolutefooterTop) {
		sadariPopup.className = "sadari-over";
	}
	if (absolutefooterTop - window.pageYOffset > 720)
		sadariPopup.className = "sadari-fix";
});
