window.addEventListener("load", function() {
	// 인기검색어 객체 가져오기
	var word = new Array();
	var ranking = document.querySelectorAll("#ranking li a");
	var view = document.querySelector("#view");
	
//======================인기검색어 동작===================
	
	//랭킹클래스 안에 태그들의 값들을 가져와서 Array에 저장
	for(var i=0; i<3; i++){
        str = ranking[i].innerHTML;
        word[i] = str;		//str을 순서대로 배열 형태로 저장
        console.log(word[i]);
    }
    
	//2초마다 갱신을 하며 1개씩 출력
    var i=0;	
    var interval = setInterval(function(){	
        if(i>word.length-1){		//모두 출력되면  반복이 종료되므로 
            i=0;		//다시 i를 0으로 초기화
        }
         view.innerHTML = "<a href=\"\">"+(i+1)+". "+ word[i] + "</a>";
          i++;	  
      }, 2000);			//2초마다 갱신
      
	
	
});
