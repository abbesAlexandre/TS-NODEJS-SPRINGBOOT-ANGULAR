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
