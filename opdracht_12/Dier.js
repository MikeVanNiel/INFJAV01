export default class Dier {

    constructor(naam, aantalPoten) {
        this._naam = naam;
        this._aantalPoten = aantalPoten;
    }

    getNaam() {
        return this._naam;
    }

    getAantalPoten() {
        return this._aantalPoten;
    }

    spreek() {}
}