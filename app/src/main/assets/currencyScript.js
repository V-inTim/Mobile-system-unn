var rectangleList = document.getElementById('currency-list');

function addCurrency(color, textColor, text) {
    var currency = document.createElement('div');
    currency.className = 'currency';
    currency.style.backgroundColor = color;
     currency.style.color = textColor;
     currency.innerText = text;
    rectangleList.appendChild(currency);
}

var xhr = new  XMLHttpRequest();
xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && xhr.status == 200) {
        var parser = new DOMParser();
        var doc = parser.parseFromStrong(xhr.responseText, 'text/xml');
        var valutes = doc.getElementsByTagName("Valute");
        for (var i=0; i<valutes.length; i++){
            var name = valutes[i].getElementsByTagName("Name")[0].textContent;
            var value = valutes[i].getElementsByTagName("Value")[0].textContent;
            addRectangle('white', 'black', name + " " + value);
        }
    }
}
xhr.open('GET', 'https://www.cbr.ru/scripts/XML_daily.asp', 'true');

