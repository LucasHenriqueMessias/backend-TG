function voltaPaginaInicial(){
    window.open("../Página Inicial/pag-inicial.html", "_self");
}

var urlPedidos = "http://localhost:8080/Pedido";
const camposPedidos = [
    'numPedido',
    'dataCriacao',
    'status',
    //ArrayList<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();
    'loja'
];


$(document).ready(function() {
    $("button").click(function() {

        const camposForm = $("form").serializeArray();

        if (this.id == 'btnIncluir') { //ainda não possui botão
            var camposPedidosPost = camposPedidos;
            camposPedidosPost.shift();

            var jsonPedidos = valiidaCampos(camposForm, camposPedidosPost);

            post(urlPedidos, jsonPedidos);

        } else if (this.id == 'btnAlterar') { //ainda não possui botão
            var jsonPedidos = valiidaCampos(camposForm, camposPedidos);
            var urlPedidosPut = urlPedidos
            var arrayPedidos = JSON.parse(jsonPedidos)

            urlPedidosPut += "/" + arrayPedidos.sku

            put(urlPedidosPut, jsonPedidos);
        }

    })

});