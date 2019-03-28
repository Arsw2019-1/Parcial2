   
var ciudad="";
var Company=(function(){
   
   
   
   
 function getCity(){
            ciudad= document.getElementById("ciudad").value;
            axios.get('/clima/cl/'+ciudad).then(function (response) {
                alert("que paso"+response);
                    barajas = response.data;
                    console.log('saved successfully')


         
                })
                .catch(function (error) {

                    console.log(error);
                });
            
        };

    return {

        getEmpresa:getEmpresa
    };
    })(); 
   
   
   