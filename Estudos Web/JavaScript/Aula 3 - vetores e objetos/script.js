// Como declarar um array
var arrayWes = ["Weslley", 21];
var arrayTay = [20, "Tayná"];

console.log("Meu array é: ", arrayWes);
console.log("Meu array é: ", arrayTay);

// Acessando array pelo indice
console.log("O meu nome é: ", arrayWes[0]);

// unshift() = adiciona um item no inicio do array
arrayTay.unshift("Tayná");
arrayTay.unshift(20);

// Push() = adiciona um item no final do array
arrayWes.push(arrayTay);

// shift() = remove o primeiro item do array
function testeShift() {
    let array = [];
    array = arrayTay.shift();
    return array;
} console.log("Esse é o item removido de ArrayTay: ", testeShift());

// Pop() = remove o ultimo item do array
function testePop() {
    let array = [];
    array = arrayTay.pop();
    return array;
} console.log("Esse é o item removido de ArrayTay: ", testePop());

// forEach() = intera o array
arrayWes.forEach(function(item, index){console.log("item: ", item, "||","indice: ", index)});

// indexOf() = retorna o indice do item
console.log("Indice do item Weslley é: ", arrayWes.indexOf("Weslley"));

// splice() = remove ou substitui um item pelo indice
function testeSplice() {
    let listaCarros = ["Sandero", "Palio", "Vectra", "Tesla Model 3", "Nissan"];
    console.log("Minha lista de carro: ", listaCarros);

    listaCarros.splice(0, 2);
    return listaCarros;
} console.log("Lista de carros removendo os dois primeiros indices: ", testeSplice());

// slice() = retorna apenas uma parte do array 
    let lista = arrayWes.slice(0, 1);
    console.log("Minha lista: ", lista);


