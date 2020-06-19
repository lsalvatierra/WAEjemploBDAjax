/*$("#formlogin").submit(function (event) {
    if ($("#txtusuario").val() === "") {
        $("#erroremail").text("Ingrese su usuario").show();
        return false;
    }else{
        $("#erroremail").hide();   
        return false;
    }
    if ($("#txtpassword").val() === "") {
        $("#errorpassword").text("Ingrese su password").show();
        return false;
    }else{
        $("#errorpassword").hide();   
        return false;
    }
    if ($("#txtusuario").val() !== "" && $("#txtpassword").val() !== "") {
        return;
    }
});*/
$(document).on("click", "#btnlogin", function () {
    if ($("#txtusuario").val() === "") {
        $("#erroremail").text("Ingrese su usuario");
    }else{
        $("#erroremail").text("");
    }
    if ($("#txtpassword").val() === "") {
        $("#errorpassword").text("Ingrese su password");
        return false;
    } else{
        $("#errorpassword").text("");
    }   
    if ($("#txtusuario").val() !== "" && $("#txtpassword").val() !== "") {
        $("#formlogin").submit();
    }
});

