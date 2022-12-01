function voltaPaginaEstoque(){
    window.open("../Estoque/pag-estoque.html", "_self");
}

var urlProdutos = "http://localhost:8080/produtos";
const camposProdutos = [
    
    'codOperacao',
    'dataValidade',
    'lote',
    'qtdeCaixa',
    'loja',
    'produto'

];


$(document).ready(function() {
    $("button").click(function() {

        const camposForm = $("form").serializeArray();

      //  if (this.id == 'btnIncluir') {
            var camposProdutosPost = camposProdutos;
            camposProdutosPost.shift();

            var jsonProdutos = valiidaCampos(camposForm, camposProdutosPost);

            get(urlProdutos, jsonProdutos);
        
            /*
        } else if (this.id == 'btnAlterar') {
            var jsonProdutos = valiidaCampos(camposForm, camposProdutos);
            var urlProdutosPut = urlProdutos
            var arrayProdutos = JSON.parse(jsonProdutos)

            urlProdutosPut += "/" + arrayProdutos.sku

            put(urlProdutosPut, jsonProdutos);
        }
*/
    })

});