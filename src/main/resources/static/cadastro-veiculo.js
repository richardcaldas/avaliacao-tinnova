function save(obj){
    
    const form = obj.closest('form');
    convertFormToJSON(form, function (data) {
        data = JSON.stringify(data);
        requestAJAX('POST', 'http://localhost:8080/veiculos', data, function (response) {
            alert('Veiculo inserido com sucesso');
            window.location = "/page/"
        });
    });

    

}


function convertFormToJSON(form, callback) {
    const data = {};
    $.each(form, function (i, obj) {
        const input = $(obj);
        if (input[0].type === "checkbox") {
            data[input.attr("name")] = input[0].checked;
        } else if (input[0].type === "radio" && input[0].checked === true) {
            data[input.attr("name")] = input.val();
        } else if (input[0].type !== "radio") {
            data[input.attr("name")] = input.val();
        }
    });
    delete data["undefined"];
    callback(data);
}


function requestAJAX(type, method, data, callback) {
    $.ajax({
        type: type,
        contentType: "application/json",
        url: method,
        data: data,
        dataType: 'json',
        timeout: 300000
    }).done(function (data) {
        callback(data);
    }).fail(function (failResponse) {
        console.log('ERRO');
    });
  }