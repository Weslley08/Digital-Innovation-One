// Função por parametro

let quantidadeTestes = 5;

function impressora(testes) {
    for (let i = 1; i <= testes; i++) {
       console.log("Teste de impressão " + i);
    }
}
impressora(quantidadeTestes);

// Função normal

function testeMensagem() {
    console.log("Hello World");
}
testeMensagem();