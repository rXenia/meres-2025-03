async function getAllIngatlan() {
    var endpoint = 'http://localhost:5000/api/ingatlan';
    var request = await fetch(endpoint);
    var response = await request.json();
    return response;
}

(async ()=>{
    var response = await getAllIngatlan();
    console.log(response);
    var table = document.getElementById("table");

    for (var i = 0; i < response.length; i++){
        var tr = document.createElement("tr");

        var td1 = document.createElement("td");
        td1.innerHTML = response[i].kategoriaNev;

        var td2 = document.createElement("td");
        td2.innerHTML = response[i].leiras;

        var td3 = document.createElement("td");
        td3.innerHTML = response[i].hirdetesDatuma;

        var td4 = document.createElement("td");
        if(response[i].tehermentes == true){
            td4.innerHTML = "Igen";
        }
        else{
            td4.innerHTML = "Nem";
        }
        
        var td5 = document.createElement("td");
        td5.style.backgroundImage = "url('" + response[i].kepUrl + "')";
        td5.style.backgroundSize = "cover";
        td5.style.backgroundRepeat = "no-repeat";
        td5.style.backgroundPosition = "center";


        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);

        table.appendChild(tr);
    }
})();


async function getKategoriak() {
    var endpoint = 'http://localhost:5000/api/kategoriak';
    var request = await fetch(endpoint);
    var response = await request.json();
    return response;
}

(async ()=>{
    var response = await getKategoriak();

    var select = document.getElementById('form-select');

    for (var i = 0; i < response.length; i++){
        var opt = document.createElement('option');
        opt.value = i+1;
        opt.innerHTML = response[i].megnevezes;
        select.appendChild(opt);
    }
})();

window.onload = function() {
    getCurrentDate();
};

function getCurrentDate(){
    var currentdate = new Date();
    var formatted;
        
    formatted = currentdate.getFullYear() + '-'
    + ('0' + (currentdate.getMonth()+1)).slice(-2) + '-'
    + ('0' + currentdate.getDate()).slice(-2);
    
    document.getElementById("currentDate").value = formatted;
}


async function createIngatlan() {
    try {
        var data = {
            kategoriaId: document.getElementById("form-select").value,
            kategoria: {
                id: document.getElementById("form-select").value,
                megnevezes: "abcd"
            },
            leiras: document.getElementById("description").value,
            hirdetesDatuma: document.getElementById("currentDate").value,
            tehermentes: document.getElementById("tehermentes").checked,
            kepUrl: document.getElementById("kepurl").value
        };
    
        const request = await fetch('http://localhost:5000/api/ujingatlan', {
          method: 'POST',
          headers: { "Content-type": "application/json" },
          body: JSON.stringify(data)
        });
      
        const response = await request.json();

        if(response.status == 200){
            document.getElementById("alert").style.visibility = "hidden";
            window.location.href = "offers.html";
        }
        else{
            document.getElementById("alert").style.visibility = "visible";
            document.getElementById("error").innerHTML = response.status + " " + response.title;
        }

    } catch (error) {
        return error;
    }
}