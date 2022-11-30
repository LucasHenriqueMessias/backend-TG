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