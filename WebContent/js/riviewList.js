window.addEventListener("load", function () {
    var section = document.querySelector("#middlebox");
    var contentSection = section.querySelector("#content_main");
    var moreBtn = section.querySelector("#more-more");
    var pageSection = section.querySelector('input[name="p"]');
    var page = (Number)(pageSection.value);
    
    moreBtn.onclick = function (e) {
        page = page + 1;
        if (e.target.nodeName != "A")
            return;
        e.preventDefault();

        var data = [["page", page]];
        var sendData = [];
        sendData[0] = data[0].join("=");
        var request = new XMLHttpRequest();
        request.open("POST", "list-json", true);

        request.setRequestHeader('Content-Type',
            'application/x-www-form-urlencoded');

        request.onload = function () {
            var json = JSON.parse(request.responseText);
            for (var i = 0; i < json.length; i++) {
                var cloneForm = contentSection.firstElementChild.cloneNode(true);
                var title = cloneForm.firstElementChild;
                var content = cloneForm.lastElementChild;
                var month;
                var day;
                var year;
                title.firstElementChild.innerText = "ㆍ " + json[i].address;
                title.lastElementChild.innerText = json[i].regdate;
                if((title.lastElementChild.innerText).length==11){
                	month =(title.lastElementChild.innerText).substring(0,2);
                	day = (title.lastElementChild.innerText).substring(4,5);
                    year = (title.lastElementChild.innerText).substring(7,11);
                    title.lastElementChild.innerText = year+"-"+month+"-"+"0"+day;     	
                }
                else{
                    month = (title.lastElementChild.innerText).substring(0,2);
                    day = (title.lastElementChild.innerText).substring(4,6);
                    year = (title.lastElementChild.innerText).substring(8,12);
                    title.lastElementChild.innerText = year+"-"+month+"-"+day;
                }
                content.firstElementChild.innerText = json[i].content;
                content.lastElementChild.innerText = json[i].photo;
                contentSection.append(cloneForm);
            }
            if (json.length < 3)
                moreBtn.style.display = "none";
        };

        request.send(sendData);
    };
});
