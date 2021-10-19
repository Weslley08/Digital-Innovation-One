// Javascript é uma linguagem de baixa tipagem, ou seja não precisamos deixar explicito o tipo de dado

/*
Tipo primitivos de dados:

Boolean = Logico
String = Texto
Number = Numeros(inteiros, fracionados, reais e etc....)
*/

/*
var = declara uma variavel de escopo global, seu valor inicial é null,
let = declara uma variavel de escopo local, seu valor inicialmente também é null,
const = declara uma variavel de escopo local, imutavel, seu valor inicial deve ser obrigatorio e inalteravel;
*/

var tipoBoolean = true;
console.log(tipoBoolean, ":", typeof(tipoBoolean));

const tipoString = "Hello World"
console.log(tipoString, ":", typeof(tipoString));

let tipoNumber = 1;
console.log(tipoNumber, ":", typeof(tipoNumber));