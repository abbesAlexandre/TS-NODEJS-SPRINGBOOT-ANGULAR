# springBoot-Angular

/** * cours typescript

alias :
const a = "firstname"

type : possibilité créer alias a la volé ou générique avec params

type User = {firstname : string | number, lastname: string}
type Username = User['firstname']
type Username = keyof User
type identity<ArgType> = (arg: argType) => ArgType
keyof union type qui contient l'ensemble des clés donc sois firstname sois lastname



const n = 3
const b = true
const d = null
const arr = ['aze','aze', 'aze']
const user = {firstname:"Alexandre", lastname:"Abbes"}
const date = new Date();
const cb: (e: MouseEvent) => void = (e:MouseEvent): number => {
    return 3
}

const compteur = document.querySelector('#compteur') as HTMLButtonElement

narowing :

function printId(id: number | string): void{
    console.log(id.toString());
}



contrainte :

function consoleSize<Type extends {length: number}>(arg: Type): Type {
    console.log(arg.length)
    return arg
}

const test = consoleSize(3) not working waiting for something where length work like an array
const test2 = consoleSize(['3', 2]) ok

readonly : 

function reverse<T>(arr : readonly T[]): readonlyT[]{
    return arr.reverse();  readonly empêche la modification de l'array
    return [...arr].reverse(); créer un nouveau tableau afin de retourner le résultat sans modifier le tableau d'origine
}

class :

class A {
   private a = 3 pas 100% private
   #a = 3 100 % privé
   protected a = 3  sa veut dire que les enfants peuvent acceder a cette props

   log(){
    console.log(this.a) ici sa pose pas de problème pr voir la propriété
    console.log(this.#a)
   }
}

const aInstance = new A();
console.log(aInstance.a)  pas possible car propriété privé
aInstance.log()

class B extends A {
    log(){
        conssole.log(this.a)
    }
}

class colleciton<T>{
    constructor(private items: T[]){

    }
    add (item: T): this{
        this.items.push(item)
        return this
    }
    first(): T | null{
        return this.items[0] || null
    }

    isEqual (a: this){
        return a.this == this.items permet de s'assurer qu'on compare bien la meme chose (ex comparé collection avec un enfant qui as d'autre method en plus = marche pas)
    }
}

const a = new Collection([1,2]) juste avec init il comprend que t c'est des nombres
const b = a.first() comprend que ici number ou null attendu
const c = a.add(3) collection dont le type correspond a celui de this

class Subscriber{
    on(this: HTMLInputElement, name: string, cb: Function){
        this. sera les propriété de HTMlInputElement
    }
}

typescript compare les classes celon leur structure :

class point{
    x = 0
    y = 0
}

class geometry{
    x = 0
    y = 0
    surface = 0
}

function getX(p: point){
    return p.x
}

getX(new Geometry()); pas d'erreur psk meme structure mais ici il s'attend a quelque chose qui est une classe avec une propriété x. Inconvénient du duck typing.

notion abstrait : force les classes enfant a déclarer dans leur structure toutes les méthodes abstraite du parent

abstract class Geometry {
    x = 0
    y = 0
    abstract surface (): number
}

claass Triangle extends Geometry {
    x = 2
    y = 2

    surface (){
        return 3
    }
}

method static : 

abstract class Geometry {
   static #origin: {x: number, y: number}

   static{ permet de définir des propriété a la volé
    Geometry.#origin = {x:0, y: 0}
   }
}


Geometry.origin
*/