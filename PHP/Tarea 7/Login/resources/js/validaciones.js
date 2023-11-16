/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

function validarTamano(inputid, mintam, maxtam) {
    var input = document.getElementById(inputid);
    var texto = input.value;
    if (texto.length < mintam) {
        input.setCustomValidity("El valor ingresado debe tener como minimo " + mintam + " caracteres");
    } else if (texto.length > maxtam) {
        input.setCustomValidity("El valor ingresado debe tener como maximo " + maxtam + " caracteres");
    }else{
        input.setCustomValidity("");        
    }
}
