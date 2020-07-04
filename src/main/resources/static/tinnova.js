$(document).ready(function() {

    setTableVeiculos();

    setInfoQuantidadeNaoVendido();

    setInfoVeiculosPorDecadaDeFabricacao();

    setInfoVeiculosFabricante();

    setTableVeiculosRegistradosUltimaSemana();
    
});

function setTableVeiculos(){
    
    requestAJAX('GET', 'http://localhost:8080/veiculos',undefined,function(response){
        var html = ""   
        response.forEach(element => {
            html +="<tr>"
            html += "<td><a href='javascript:deleteVeiculo(" + element.id + ")'>Deletar</a></td>"
            html += "<td>" + element.id + "</td>"
            html += "<td>" + element.veiculo + "</td>"
            html += "<td>" + element.marca + "</td>"
            html += "<td>" + element.ano + "</td>"
            html += "<td>" + element.descricao + "</td>"
            html += "<td>" + element.vendido + "</td>"
            html += "<td>" + element.created + "</td>"
            html += "<td>" + element.updated + "</td>"
            html += "</tr>"
        });
        $('#tableVeiculos > tbody').html(html);
    })
    
}

function setTableVeiculosRegistradosUltimaSemana(){
    
    requestAJAX('GET', 'http://localhost:8080/veiculos/registrados-ultima-semana',undefined,function(response){
        var html = ""   
        response.forEach(element => {
            html +="<tr>"
            html += "<td>" + element.id + "</td>"
            html += "<td>" + element.veiculo + "</td>"
            html += "<td>" + element.marca + "</td>"
            html += "<td>" + element.ano + "</td>"
            html += "<td>" + element.descricao + "</td>"
            html += "<td>" + element.vendido + "</td>"
            html += "<td>" + element.created + "</td>"
            html += "<td>" + element.updated + "</td>"
            html += "</tr>"
        });
        $('#tableregistradosUltimaSemama > tbody').html(html);
    })
    
}

function deleteVeiculo(id){

    requestAJAX('DELETE', 'http://localhost:8080/veiculos/'+id,undefined,function(response){
        setTableVeiculos();
    })
    
}

function setInfoQuantidadeNaoVendido(){

    requestAJAX('GET', 'http://localhost:8080/veiculos/quantidade-nao-vendidos',undefined,function(response){
        $('#spanQtdNaoVendidos').text(response);        
    })
    
}


function setInfoVeiculosPorDecadaDeFabricacao(){

    requestAJAX('GET', 'http://localhost:8080/veiculos/veiculos-por-decada-fabricacao',undefined,function(response){
        $('#spanDecadaDeFabricacao').text(JSON.stringify(response));
        
    })
    
}

function setInfoVeiculosFabricante(){

    requestAJAX('GET', 'http://localhost:8080/veiculos/veiculos-por-fabricante',undefined,function(response){
        $('#spanVeiculosFabricante').text(JSON.stringify(response));
        
    })
    
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