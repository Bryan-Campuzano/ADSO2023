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
function validarFormulario() {
    var username = document.getElementById("email");
    var password = document.getElementById("password");

    if (username.value.trim() === "" || password.value.trim() === "") {
        alert("Por favor, completa todos los campos.");
        return false;
    }
    return true;
}

function validarEmail(inputId) {
    var input = document.getElementById(inputId);
    var email = input.value;

    if (!isValidEmail(email)) {
        input.setCustomValidity("El correo electrónico no es válido.");
    } else {
        input.setCustomValidity(""); // Restablece el mensaje de error personalizado
    }
}

function isValidEmail(email) {
    // Función para validar un correo electrónico
    // Puedes personalizar esta función según tus necesidades
    var emailPattern = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;
    return emailPattern.test(email);
}