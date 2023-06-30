document.getElementById("select").addEventListener("click", function () {

    const hobby = document.getElementsByName("hobby");
    const categories = document.getElementById("categories");

    for (let i = 0; hobby.length; i++) {

        if (hobby[i].checked) {
            categories.innerHTML += document.getElementsByTagName("label")[i].innerHTML + "," + " ";

        }

    }

})

//전체 선택 중 1개를 제외한다면 전체가 제외한다. 
document.getElementById("all").addEventListener("click", function () {

    const hobby = document.getElementsByName("hobby");

    for (let i = 0; i < hobby.length; i++) {

        if (this.checked) {
            hobby[i].checked = true;
        } else {
            hobby[i].checked = false;
        }
    }

})


