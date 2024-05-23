var rectangleList = document.getElementById('rectangle-list');

function addRectangle(color, textColor, text) {
    var rectangle = document.createElement('div');
    rectangle.className = 'rectangle';
    rectangle.style.backgroundColor = color;
    rectangle.style.color = textColor;
    rectangle.innerText = text;
    rectangleList.appendChild(rectangle);
}

addRectangle('blue', 'white', "I");
addRectangle('black', 'green', "You");
addRectangle('red', 'white', "He");
addRectangle('yellow', 'black', "She");