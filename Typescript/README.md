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

différence type interface :

type Point = { toujours meme facon d'écrire
    props
}

interface Point{ bcp moins flexible et se base pas sur les types primaire
    x: number
    get (): number
}

interface Point est de type string ne marche pas c'est forcément des choses qui vont ressembler a des objet
types non modifiable plus tard alors que interface nn.

interface Point{ 
    x: number
}
interface Point{ 
    y: number
}

const p : Point; aura donc propriété x et y

interface peuvent etre implémenter

class TwoDPoint implements Point{ intéré de préciser qu'on implémente est si jamais on décide de modifier l'interface toutes les classes qui implémente vont plus etre valide
    x=0
    y=0
}

function draw(p: Point){
    
}

draw(new TwoDimensionPoint())

si il faut choisir prendre type par défault car c'est eux qui permettent de faire le plus de chose et si besoin de definir la forme d'un objet et que je sais que je vais devoir utiliser implement ou qu'on doit créer une library qui va etre étendu et on doit laisser les choses ouvertes dans ce cas la j'utilise une interface.

3 nouveaux types (ENUM, TUPLE, ) :

unknow presque pareille que any exemple :

function a (arg: any){ quand utilise any automatiquement typescript retire la vérification des types
    arg.demo = 3
}
function a (arg: unknow){ objectif utiliser le narowing car on sais pas quel type arrivera plus tard tjrs priorisé unknown et pas any
    if (arg instanceof HTMLInputElement){
        arg.value = "Hello"
    }
}

les literrals : 
const a = "azaza" type sera azaza
const a = {isPrivate: true, isPublic: false} il détecte que a c'est un objet et que isprivate c'est un boolean il donne pas la valeur psk sa peut etre amener a changer
const a = {isPrivate: true as true, isPublic: false} il va comprendre que le type dans private est necessairement true
const a = {isPrivate: true as const, isPublic: false} il va comprendre que le type dans private est une constante et que sa change jamais donc private sera tjrs true
const a = {isPrivate: true, isPublic: false} as const On peut l'appliquer a l'objet 
js const fait référence a un objet qui peut etre amener a changer dans le temps
alors que typeScript c'est inchangeable

const a = [1,2,3] as const c'est un type qu'on appel tuple. Cela permet de faire la distinction entre un tableau qui as une taille non défini et un tableau qui as une taille fixe.

const a: [string, number] = ['tomate', 2] ne peut avoir un 3eme élément car taille 2 et on sais quel type dans chacune des valeurs
const b : (string | number)[] = ['tomate', 2] 

type ListItem = [string, number]

const a : ListItem = ['tomate', 2]
const b : ListItem = ['tomate', 3]

si on utilise des array.push() typescripte va etre capable de fusioné a et b.

type ListItem = [string, number]

const a : ListItem = ['tomate', 2]
const b : ListItem = ['banane', 3]

function merge<T extends unknown[], U extends unknown[]>(a: T, b: U) : [...T, ...U]{
    return [...a, ...b]
}
[] tuple
extends unknown[] -> copy un tableau dont on ne sais pas le type encore
const c = merge(an b) il s'att a un string, number, string, number

tableau fixe préféré les topples

const c =  [] as string

console.log(c[0].toUpperCase()) erreur dans le navigateur psk c[0] = undefined

il faut donc faire 

if(c[0]){
    console.log(c[0].toUpperCase())
}


ENUM : 

enum STEPS {
    Intro = "Intro",
    Selection = "Selection",
    Panier = "Panier",
    Paiement = "Paiement"  plus utile pendant le deboggage de rajouter = ""
}

const step : STEPS = STEPS.Selection

if (step == STEPS.Intro)

enum type const

const enum enum STEPS {
    Intro = "Intro",
    Selection = "Selection",
    Panier = "Panier",
    Paiement = "Paiement"  plus utile pendant le deboggage de rajouter = ""
}

interet d'utiliser les enums et pas des objet qui font la même chose c'est que le jours ou les enum sont supporter en js c'est du temps gagner et plus cours a écrire

enum permet de représenter une valeur qui est possiblement dans une série de valeur donné.

déclaration :

export class Point {
    x = 0

}

    "include": [
        "src/types/**/*"
    ]

  types utilitaires : 

  class chat {

  } 
  class poisson {

  } 

  type AnimalOptions = {nager: any} | {sauter:any}
  type AnimalFromOption<T> = T extends {nager:any} ? poisson : chat

  function generator<T extends AnimalOptions>(options: T): AnimalFromOptions{
    if ("nager" in options){
        return new poisson()
    }else{
        return new chat();
    }
  }

  inféré le texte :

  class Poisson {
    cri(){
        return false
    }
  }
    class Chat {
    cri(){
        return "miaouou"
    }
  }

  type AnimalCri<T> = T extends {cri: () => infer U} ? U : never

  type A = AnimalCri<Chat> retourne string
  type B = AnimalCri<Poisson> retourne type boolean

  class FeatureFlags{
    env: 'hello'
    darkMode (){return true}
    privateMode (){return true}
    nsfwMode (){return true}
  }

  type OptionsFlag<T> = {
    [key in keyof T]+?: boolean                                                                 +? = tout optionnel 
    +readonly [key in keyof T]+?: boolean                                                       la même avec +readonly
    +readonly [key in keyof T]: T[key] extends () => boolean ? boolean : never                  Si extends d'une fonction qui retourne un boolean sinon je renvoie never
    +readonly [key in keyof T as `get${String & key}`]: T[key] extends () => boolean ? boolean : never  
  }

  type A = OptionsFlag<FeatureFlags>

  list type utilitaire :

  Partial : prendre un type et rendre toutes ces propriété optionnel
  Required : inverse
  ReadOnly : transformer toutes les propriété en readonly
  Record : créer un objet qui aurait des clés d'un certain type et les valeurs d'un autre
  Pick : prendre a partir d'un type seulement certaine clef
  Omit : permet de retirer une propriété
  Exclude : Retirer dans un union type certaines valeurs

  type OptionsFlag<T> = {
    +readonly [key in keyof T as Exclude<key, 'env'>]: T[key]               retire la clef env
    +readonly [key in keyof T as T[key] extends () => boolean ? key : never>]: T[key]
  }

  Extract : inverse de exclude
  NonNullable : permet retirer les options null
  Parameters : permet d'extraire un tuple 
  ConstructorParameters : meme chose que parameters mais pr constructeur
  ReturnType : renvoie le type de retour d'une fonction
  InstanceType : retourne le type qui correspond a une instance d'une classe
  ThisParameterType : permet extraire le this d'un type
  OmitThisParameter : inverse de thisParameterType
  ThisType : permet d'obtenir le type de this
*/