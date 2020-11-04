import { Hond } from './Hond';
import { Kat } from './Kat';

const fikkie = new Hond('Fikkie', 4);
const minoes = new Kat('Minoes', 4);

console.log('Hond naam: ' + fikkie.getNaam());
console.log('Hond aantal poten: ' + fikkie.getAantalPoten());
console.log('Hond spreekt: ' + fikkie.spreek());

console.log('Kat naam: ' + minoes.getNaam());
console.log('Kat aantal poten: ' + minoes.getAantalPoten());
console.log('Kat spreekt: ' + minoes.spreek());



