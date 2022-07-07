// noinspection DuplicatedCode

function openPage(pageName, element, color) {
    let i, tabContent, tabLinks;
    tabContent = document.getElementsByClassName("tabContent");
    for (i = 0; i < tabContent.length; i++) {
        tabContent[i].style.display = "none";
    }
    tabLinks = document.getElementsByClassName("tabLink");
    for (i = 0; i < tabLinks.length; i++) {
        tabLinks[i].style.backgroundColor = "";
    }
    document.getElementById(pageName).style.display = "block";
    element.style.backgroundColor = color;
}
document.getElementById("defaultOpen").click();

function done() {
    document.getElementById("myButton").addEventListener("click", makeRequest);
}

function getDate(){
    return document.getElementById("dateInput").value;
}

function genRequest() {
    const apiKey = "api_key=jMCGWzvPkGAv5z78ewk6gflFHYTSutqrhc52I4yp"
    let date = getDate();
    date = (date !== "")? `date=${date}` : "";

    return "https://api.nasa.gov/planetary/apod?" + apiKey + "&" + date.toString();
}

function makeRequest() {
    const reqUrl = genRequest();
    console.log(reqUrl);
    let httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = handleRequest;
    httpRequest.open("GET", reqUrl);
    httpRequest.send();

    function handleRequest() {
        if (httpRequest.readyState === XMLHttpRequest.DONE && httpRequest.status === 200) {
            let data = JSON.parse(httpRequest.responseText);
            const {url, copyright, date, explanation, hdurl, media_type, service_version, title} = data;

            document.getElementById("copyright").innerHTML = copyright;
            document.getElementById("titleHolder").innerHTML = title;
            document.getElementById("imgHolder").src = url;
            document.getElementById("desc").textContent = explanation;
            document.getElementById("content").style.visibility = "visible";
            changeFont();
            changeFooter();
        }
    }
}

function changeFooter() {
    let footer = document.getElementById("footer");
    footer.style.position = "relative";
    footer.style.bottom = "0";
    footer.style.width = "100%";
    footer.style.textAlign = "center";
}

function changeFont() {
    document.getElementById("titleHolder").style.font = "1.5vw Times New Roman";
    document.getElementById("titleHolder").style.fontWeight = "bold";
    document.getElementById("copyright").style.font = "1.5vw Times New Roman";
    document.getElementById("copyright").style.fontWeight = "bold";
    document.getElementById("desc").style.font = "1.4vw Times New Roman";
}







