window.addEventListener("load", function() {
	var sectionBody = document.querySelector("#div_body");
	window.maxWidth = parseInt(sectionBody.style.width);
	window.maxHeight = parseInt(sectionBody.style.height);
	var sectionStep1 = document.querySelector("#step1");
	var sectionStep2 = document.querySelector("#step2");
	var clickLabel = sectionStep1.querySelector("div:last-child>label");
	var plus = sectionStep1.querySelector(".plus");
	var minus = sectionStep1.querySelector(".minus");
	var sadariCount = sectionStep1.querySelector(".sadari-count");
	plus.onclick = function() {
		if (parseInt(sadariCount.innerText) == 6)
			return;
		sadariCount.innerText = parseInt(sadariCount.innerText) + 1;
	};

	minus.onclick = function() {
		if (parseInt(sadariCount.innerText) == 2)
			return;
		sadariCount.innerText = parseInt(sadariCount.innerText) - 1;
	};

	clickLabel.onclick = function() {
		Yl.init();
	};
});
// 사다리 만드는.
var Yl = {
	getEl : function(strId) {
		if (document.querySelector(strId))
			return document.querySelector(strId);
	}
	// div 리턴
	,
	getDiv : function(sWidth, sHeight, sBgColor) {
		var d = document.createElement("div");
		if (sWidth)
			d.style.width = sWidth;
		if (sHeight)
			d.style.height = sHeight;
		if (sBgColor)
			d.style.backgroundColor = sBgColor;
		d.style.position = "absolute";
		d.style.overflow = "hidden";
		return d;
	},
	arrColor : [ '#8c7301', '#9b014f', '#0084a0', '#ad8e00', '#bb005f',
			'#00a0c2', '#8d3901', '#8f0197', '#156200', '#9ca53b', '#c9a601',
			'#d6006d', '#01b6de', '#80adaf', '#a44201', '#e0b800', '#ec0078',
			'#0021b0', '#92b7d7', '#013add' ],
	arrVerDiv : [] // 수직 선 div
	,
	arrHorDiv : [] // 수평 선 div
	,
	arrMovDiv : [] // 이동 선 div
	,
	arrIng : [] // 진행여부 체크용
	,
	arrMDiv : [] // 이동선 배열 번호값 저장, 이동후 확인용
	,
	nMaxWidth : 720 // 최고 넓이
	,
	nWidth : 0 // 사다리 넓이
	,
	nHeight : 380 // 사다리 높이 maxHeight - 120
	,
	nNum : 0,
	arrTopDiv : [] // 탑 div
	,
	arrBotDiv : [] // 아래 div
	,
	arrGoDiv : [] // go 버튼 div
	,
	resultArr : [] // 
	,
	init : function() {
		// 갯수
		this.nNum = parseInt(this.getEl(".sadari-count").innerText);

		// 넓이
		this.nWidth = parseInt(this.nMaxWidth / this.nNum);

		for (var i = 0; i < this.nNum; i++) {

			this.arrTopDiv[i] = this.getDiv(this.nWidth + "px", "50px", "");
			this.arrBotDiv[i] = this.getDiv(this.nWidth + "px", "50px", "");

			this.arrTopDiv[i].style.left = (i * this.nWidth) + "px";
			this.arrTopDiv[i].style.top = "20px";

			this.arrBotDiv[i].style.left = (i * this.nWidth) + "px";
			this.arrBotDiv[i].style.top = maxHeight - 40 + "px";

			this.arrTopDiv[i].style.fontSize = "12px";
			this.arrBotDiv[i].style.fontSize = "12px";

			this.arrTopDiv[i].align = "center";
			this.arrBotDiv[i].align = "center";

			this.arrTopDiv[i].innerHTML = '<img src="/upload/더덕구이.jpg" alt=' + (i + 1)
					+ ' id="inp_top_' + i + '" width="70px" tabindex="'
					+ (i + 1) + '" />';
			this.arrBotDiv[i].innerHTML = '<input type="text" id="inp_bot_' + i
					+ '" value="" style="width:100px" tabindex="'
					+ ((i + 1) + 50) + '" />';

			this.getEl("#div_body").appendChild(this.arrTopDiv[i]);
			this.getEl("#div_body").appendChild(this.arrBotDiv[i]);

			this.arrVerDiv[i] = this.getDiv("1px", this.nHeight + "px",
					"#bbbbbb");

			this.arrVerDiv[i].style.left = ((i * this.nWidth) + parseInt(this.nWidth / 2))
					+ "px";
			this.arrVerDiv[i].style.top = "70px";

			this.getEl("#div_body").appendChild(this.arrVerDiv[i]);

			this.resultArr[i] = [ this.arrTopDiv[i].querySelector("img").alt, 0 ];
		}

		this.getEl("#step1").style.display = "none";
		this.getEl("#step2").style.display = "block";
		this.getEl("#step2").className = "step2";

		var createLabel = document.createElement("label");
		createLabel.style.cursor = "pointer";
		createLabel.innerHTML = "준비";
		this.getEl("#step2").append(createLabel);
		this.getEl("#step2").onclick = function(e) {
			if (e.target.nodeName != "LABEL")
				return;
			createLabel.remove();
			Yl.create();
		};

	},
	create : function() { // 사다리 생성

		for (var i = 0; i < this.nNum; i++) {
			this.getEl("#inp_top_" + i).onclick = function(e) {
				Yl.start(parseInt(e.target.id /**/
				.substring(e.target.id.length - 1)));
			}
			this.arrTopDiv[i].append = this.getEl("#inp_top_" + i);
			this.arrBotDiv[i].innerHTML = this.getEl("#inp_bot_" + i).value;

			this.arrTopDiv[i].style.overflow = "auto";
			this.arrBotDiv[i].style.overflow = "auto";

			this.arrIng[i] = false;

			this.arrMDiv[i] = [];
		}

		for (var i = 0; i < (this.nNum * 7); i++) {

			var nLen = this.arrHorDiv.length;

			this.arrHorDiv[nLen] = this.getDiv(this.nWidth + "px", "1px",
					"#aaaaaa");

			var nRndLeft = (parseInt(Math.random() * (this.nNum - 1)) * this.nWidth)
					+ parseInt(this.nWidth / 2);
			var nRndTop = this.getRndTop();

			this.arrHorDiv[nLen].style.left = nRndLeft + "px";
			this.arrHorDiv[nLen].style.top = nRndTop + "px";

			this.getEl("#div_body").appendChild(this.arrHorDiv[nLen]);
		}
	},
	sRndTop : "",
	getRndTop : function() {
		var nRnd = parseInt(Math.random() * (this.nHeight - 50) + 80);

		if (this.sRndTop.indexOf("[" + nRnd + "]") < 0) {
			this.sRndTop += "[" + nRnd + "]";
			return nRnd;
		} else {
			return this.getRndTop();
		}
	},
	start : function(no) {
		if (this.arrIng[no]) {
			for (var i = 0; i < this.arrMDiv.length; i++) {
				for (var j = 0; j < this.arrMDiv[i].length; j++) {
					this.arrMovDiv[this.arrMDiv[i][j]].style.backgroundColor = "#CCCCCC";
					this.arrMovDiv[this.arrMDiv[i][j]].style.zIndex = 1;
				}

			}
			for (var i = 0; i < this.arrMDiv[no].length; i++) {
				this.arrMovDiv[this.arrMDiv[no][i]].style.backgroundColor = "#0000ff";
				this.arrMovDiv[this.arrMDiv[no][i]].style.zIndex = 2;
			}
		} else {

			var nSx = parseInt(this.arrVerDiv[no].style.left);
			var nSy = parseInt(this.arrVerDiv[no].style.top);

			this.moveStart("y", no, nSx, nSy);

			this.arrIng[no] = true; // 진행
		}

	},
	moveStart : function(sXy, pno, nSx, nSy) {

		var nLen = this.arrMovDiv.length;

		this.arrMovDiv[nLen] = this.getDiv("2px", "2px", this.arrColor[pno]);

		this.arrMDiv[pno].push(nLen);

		this.getEl("#div_body").appendChild(this.arrMovDiv[nLen]);

		this.arrMovDiv[nLen].style.left = nSx + "px";
		this.arrMovDiv[nLen].style.top = nSy + "px";

		this.arrMovDiv[nLen].style.zIndex = 3;

		var nEx = nSx;
		var nEy = nSy;
		if (sXy == "y")
			nEy = this.nHeight + 100;

		var bCk = false;

		for (var i = 0; i < this.arrHorDiv.length; i++) {

			var nx = parseInt(this.arrHorDiv[i].style.left);
			var ny = parseInt(this.arrHorDiv[i].style.top);
			var nw = parseInt(this.arrHorDiv[i].style.width);
			var nh = parseInt(this.arrHorDiv[i].style.height);

			if (sXy == "x") {
				if (ny == nSy) {
					if (nx == nSx) {
						nEx = nx + nw;
						break;
					} else if ((nx + nw) == nSx) {
						nEx = nx;
						break;
					}
				}
			} else {

				// 반복하면서 큰것중에서 제일 작은것으로
				if (ny > nSy) {

					if (nx == nEx || (nx + nw) == nEx) {

						if (bCk) {
							if (ny < nEy)
								nEy = ny;
						} else
							nEy = ny;

						bCk = true;
					}
				}
			}
		}

		this.move(nLen, pno, nSx, nSy, nEx, nEy);
	},
	nSpeed : 5,
	endCount : 0,

	move : function(no, pno, nSx, nSy, nEx, nEy) {

		var nx = parseInt(this.arrMovDiv[no].style.left);
		var ny = parseInt(this.arrMovDiv[no].style.top);
		var nw = parseInt(this.arrMovDiv[no].style.width);
		var nh = parseInt(this.arrMovDiv[no].style.height);

		var np;
		var bIng = true;

		var sXy = "";

		if (nSx != nEx) {
			np = nw + this.nSpeed;
			if (nEx < nSx) {
				if ((nSx - np) <= nEx) {
					bIng = false;
					np = nSx - nEx;
				}
				this.arrMovDiv[no].style.left = (nSx - np) + "px";
			} else {
				if ((nSx + np) >= nEx) {
					bIng = false;
					np = nEx - nSx;
				}
			}

			this.arrMovDiv[no].style.height = "4px";
			this.arrMovDiv[no].style.width = np + "px";

			sXy = "x";
		} else {

			np = nh + this.nSpeed;
			if ((nSy + np) >= nEy) {
				bIng = false;
				np = nEy - nSy;
			}

			this.arrMovDiv[no].style.width = "4px";
			this.arrMovDiv[no].style.height = np + "px";

			sXy = "y";
		}

		if (bIng) {

			setTimeout("Yl.move(" + no + "," + pno + "," + nSx + "," + nSy
					+ "," + nEx + "," + nEy + ")", 1);

		} else {

			if ((sXy == "x"))
				this.arrMovDiv[no].style.height = "2px";
			else
				this.arrMovDiv[no].style.width = "2px";

			if (nEy < this.nHeight + 30) {
				this.moveStart((sXy == "x") ? "y" : "x", pno, nEx, nEy);
			} else {
				for (var i = 0; i < this.arrVerDiv.length; i++) {
					if (nEx == parseInt(this.arrVerDiv[i].style.left)) {
						this.endCount++;
						console.log(this.resultArr[pno + 1]);
						this.resultArr[pno] = [
								this.arrTopDiv[pno].querySelector("img").alt,
								this.arrBotDiv[i].innerText ];
						break;
					}
				}
			}
		}
		if (this.endCount >= this.nNum)
			Yl.end();
	},
	end : function() {
		var createLabel = document.createElement("label");
		createLabel.style.cursor = "pointer";
		createLabel.innerHTML = "결과보기";
		this.getEl("#step2").append(createLabel);
		this.getEl("#step2").onclick = function(e) {
			if (e.target.nodeName != "LABEL")
				return;
			createLabel.remove();
			document.querySelector("#div_body").remove();
			// console.log(this.getEl("#div_body"));
			Yl.result();
		};
	},
	result : function() {
		this.getEl("#step2").style.width = 400 + "px";
		this.getEl("#step2").style.height = 300 + "px";
		this.getEl("#step2").style["margin-top"] = 75 + "px";

		var resultHeight = 300 / this.nNUm;
		var resultDiv = document.createElement("div");
		resultDiv.style.position = "relative";
		for (var i = 0; i < this.nNum; i++) {
			var resultSource = document.createElement("div");
			resultSource.className = "result" + (i + 1);
			resultSource.style.top = (i * resultHeight) + "px";
			resultSource.style["font-size"] = 30 + "px";
			resultSource.innerText = this.resultArr[i].join("=>");
			resultDiv.append(resultSource);
		}

		this.getEl("#step2").append(resultDiv);

		// var resetLabel = document.createElement("label");
		// resetLabel.className = "reset";
		// resetLabel.style.cursor = "pointer";
		// resetLabel.innerHTML = "다시하기";
		//		
		// this.getEl("#step2").append(resetLabel);
		// this.getEl("#step2").onclick = function(e) {
		// if (e.target.className == "reset") {
		// resetLabel.remove();
		// this.getEl("#step2").remove();
		// }
		// };
	}
};
