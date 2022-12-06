import Alpine from 'alpinejs'

Alpine.data('myComponent', function (initial: number = 0){
    return{
        compteur : initial,
        increment (){
            this.compteur += 1
        },
        decerement(){
            this.compteur -= 1
            if (this.compteur < 0){
                (this.$el as HTMLSpanElement).style.display = "none"
            }
        }
    }
})

Alpine.start();
/**
const compteur = document.querySelector('#compteur')

let i = 0;

const increment = (e: Event) => {
    i++;
    const span = compteur?.querySelector('span')
    if (span) {
        span.innerText = i.toString();
    }
}
function printId(id: number | string) {
    if (typeof id == "number") {
        console.log((id * 3).toString());
    } else {
        console.log(id.toUpperCase())
    }
}

compteur?.addEventListener('click', increment)


import type {PickByValue} from 'utility-types'


/**
export class point{
    x = 0
    y = 0

    move (x: number, y: number){
        this.x += x
        this.y += y
        return this
    }
}

window.ga('send', {
    hitType: 'event',
    eventCategory: 'category'
})

import scrollTo from 'scroll-to'

scrollTo(500, 1200, {
    ease: 'out-bounce',
    duration: 1500
  });
  */