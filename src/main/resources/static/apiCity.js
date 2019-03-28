var ciudad="";

var mirar =( function player(){

    function getCity(){

    ciudad = document.getElementById("ciudad").value;
        alert(ciudad);
         axios.get('/clima/'+ciudad).then(function(response){
            alert(response);
            a=response.data;
              
             console.log(response.data);

        }  )
                .catch(function (error) {
                    console.log(error);
                }); 
    }

    return {
        getCity:getCity

    }







})();
   
   