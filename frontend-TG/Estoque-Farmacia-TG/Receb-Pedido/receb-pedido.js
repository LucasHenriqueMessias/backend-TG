function formataCPF(cpf) {
    let elementoAlvo = cpf;
    let cpfAtual = cpf.value;
    let cpfAtualizado;
    cpfAtualizado = cpfAtual.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, function (regex, argumento1, argumento2, argumento3, argumento4) {
        return argumento1 + '.' + argumento2 + '.' + argumento3 + '-' + argumento4;
    });
    elementoAlvo.value = cpfAtualizado;
}

let container = document.querySelector('div');
let input = document.querySelector('input');
let icon = document.querySelector('img');

icon.addEventListener('click', function(){
    container.classList.toggle('visible');
    if(container.classList.contains('visible')) {
        icon.src = 'Images/eye-off.svg';
        input.type = 'password';
    } else {
        icon.scr ='Images/eye.svg';
        input.type = 'password';
    }
})

function voltaPaginaEstoque(){
    window.open("../Estoque/pag-estoque.html", "_self");
}

function Confirma()
{
alert("Recebimento confirmado!");
}

function Negar()
{
alert("Recebimento Negado");
}


var urlPedido = "http://localhost:8080/Pedido";
const camposPedido = [
    'numPedido',
    'dataCriacao',
    'status',
    //ArrayList<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();
    'loja'

];

//API
$(document).ready(function() {
    $("button").click(function() {

        const camposForm = $("form").serializeArray();

        if (this.id == 'btnEnviar') { //Confirmar Pedido
            var camposPedidoPost = camposPedido;
            camposPedidoPost.shift();

            var jsonPedido = valiidaCampos(camposForm, camposPedidoPost);

            post(urlPedido, jsonPedido);

        } else if (this.id == 'btnNegar') { //Negar Pedido
            var jsonPedido = valiidaCampos(camposForm, camposPedido);
            var urlPedidoPut = urlPedido
            var arrayPedido = JSON.parse(jsonPedido)

            urlPedidoPut += "/" + arrayPedido.sku

            del(urlPedidoPut, jsonPedido); //delete palavra reservada, alterada para del
        }

    })

});