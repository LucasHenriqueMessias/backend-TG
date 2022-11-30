function formataCPF(cpf) {
    let elementoAlvo = cpf;
    let cpfAtual = cpf.value;
    let cpfAtualizado;
    cpfAtualizado = cpfAtual.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, function (regex, argumento1, argumento2, argumento3, argumento4) {
        return argumento1 + '.' + argumento2 + '.' + argumento3 + '-' + argumento4;
    });
    elementoAlvo.value = cpfAtualizado;
}

function formataTelefone(telefone) {
    let elementoAlvo = telefone;
    let telefoneAtual = telefone.value;
    let telefoneAtualizado;
    telefoneAtualizado = telefoneAtual.replace(/(\d{2})(\d{5})(\d{4})/, function (regex, argumento1, argumento2, argumento3) {
        return `(${argumento1})${argumento2}-${argumento3}`;
    });
    elementoAlvo.value = telefoneAtualizado;
}  

function validarSenha(){
    senha = document.getElementsByName('senha').value;
    senha2 = document.getElementsByName('senha2').value;
 
    if(senha!= senha2) {
         senha2.setCustomValidity("Senhas diferentes!");
        return false; 
    }
    return true;
 }

 function voltaPaginaLogin(){
    window.open("/Login/index.html", "_self");
}

function formataCNPJ(cnpj) {
    let elementoAlvo = cnpj;
    let cnpjAtual = cnpj.value;
    let cpfAtualizado;
    cpfAtualizado = cnpjAtual.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, function (regex, argumento1, argumento2, argumento3, argumento4) {
        return argumento1 + '.' + argumento2 + '.' + argumento3 + '-' + argumento4;
    });
    elementoAlvo.value = cpfAtualizado;
}