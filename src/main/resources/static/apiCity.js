var ciudad="";

var mirar = (function () {


    function getInfoCity() {
    ciudad = document.getElementById("ciudad").value;
alert(ciudad);
        axios.get("/clima/"+ciudad)
                .then(function (response) {
                    alert("que paso"+response);
                    barajas = response.data;
                    console.log('saved successfully')
                    //document.getElementById("playAf").innerHTML = barajas ;                                    
                });
    }


    return {
        getInfoCity: getInfoCity
        

    };
})();