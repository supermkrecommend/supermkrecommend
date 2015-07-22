function handleChangepromotionstandard(clickedbox, event) {
    var aa = clickedbox.options[clickedbox.selectedIndex].value;
    var discountStandard = aa.split("/");
    document.getElementById("salse").textContent = discountStandard[0];
    document.getElementById("minCount").textContent = discountStandard[1];
    document.getElementById("maxCount").textContent = discountStandard[2];
}