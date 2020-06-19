$(document).on("click", "#btnagregar", function () {
    $("#txtcodigo").val("");
    $("#txtnombre").val("");
    $("#txtcredito").val("");
    $('#modalcurso').modal('show');
});
$(document).on("click", "#btnregistrarcurso", function () {
    if ($("#txtcodigo").val() === "") {
        $.ajax({
            type: 'post',
            contentType: "application/json",
            url: '/WAEjemploBDAjax/RegistrarCursoController',
            data: JSON.stringify({
                nomcurso: $("#txtnombre").val(),
                credito: $("#txtcredito").val()
            }),
            success: function (data, textStatus, jqXHR) {
                if (data) {
                    alert("Se registró correctamente.");
                    ListarCursos();
                } else {
                    alert("Ocurrio un error en la base de datos.");
                }
            }
        });
    } else {
        $.ajax({
            type: 'post',
            contentType: "application/json",
            url: '/WAEjemploBDAjax/RegistrarCursoController',
            data: JSON.stringify({
                idcurso: $("#txtcodigo").val(),
                nomcurso: $("#txtnombre").val(),
                credito: $("#txtcredito").val()
            }),
            success: function (data, textStatus, jqXHR) {
                if (data) {
                    alert("Se actualizó correctamente.");
                    ListarCursos();
                } else {
                    alert("Ocurrio un error en la base de datos.");
                }
            }
        });
    }
    $('#modalcurso').modal('hide');
});
$(document).on("click", ".btnactualizar", function () {
    $("#txtcodigo").val($(this).attr("data-codcurso"));
    $("#txtnombre").val($(this).attr("data-nomcurso"));
    $("#txtcredito").val($(this).attr("data-credcurso"));
    $('#modalcurso').modal('show');
});
$(document).on("click", ".btneliminar", function () {
    $.ajax({
        type: 'post',
        contentType: "application/json",
        url: '/WAEjemploBDAjax/EliminarCursoController',
        data: JSON.stringify({
            idcurso: $(this).attr("data-codcurso")
        }),
        success: function (data, textStatus, jqXHR) {
            if (data) {
                alert("Se eliminó correctamente.");
                ListarCursos()
            } else {
                alert("Ocurrio un error en la base de datos.");
            }
        }
    });

});
function ListarCursos() {
    $.ajax({
        type: 'post',
        url: '/WAEjemploBDAjax/ListarCursosController',
        dataType: 'json',
        success: function (data, textStatus, jqXHR) {
            $("#tblcurso > tbody").html("");
            $.each(data, function (index, value) {
                $("#tblcurso > tbody").append("<tr>" +
                        "<td>" + value.idcurso + "</td>" +
                        "<td>" + value.nomcurso + "</td>" +
                        "<td>" + value.credito + "</td>" +
                        "<td><button type='button' " +
                        " data-codcurso='" + value.idcurso +
                        "' data-nomcurso='" + value.nomcurso +
                        "' data-credcurso='" + value.credito +
                        "' class='btn btn-info btnactualizar'>Actualizar</button></td>" +
                        "<td><button type='button' data-codcurso='" + value.idcurso +
                        "' class='btn btn-danger btneliminar' >Eliminar</button></td>" +
                        "</tr>");
            });
        }
    });
}

