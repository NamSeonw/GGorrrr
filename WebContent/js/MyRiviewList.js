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
        console.log(sendData);
        var request = new XMLHttpRequest();
        request.open("POST", "listDelete-json", true);

        request.setRequestHeader('Content-Type',
            'application/x-www-form-urlencoded');

        request.onload = function () {
            var json = JSON.parse(request.responseText);
            console.log(json);

            for (var i = 0; i < json.length; i++) {
                var cloneForm = contentSection.firstElementChild.cloneNode(true);
                var title = cloneForm.firstElementChild;
                var content = cloneForm.lastElementChild;
                title.firstElementChild.innerText = "ㆍ " + json[i].address;
                content.firstElementChild.innerText = json[i].content;
                content.querySelector("#content_").innerText = json[i].content;
                content.lastElementChild.innerText = json[i].photo;
                contentSection.append(cloneForm);
            }
            if (json.length < 3)
                moreBtn.style.display = "none";
        };
        request.send(sendData);
    };
});