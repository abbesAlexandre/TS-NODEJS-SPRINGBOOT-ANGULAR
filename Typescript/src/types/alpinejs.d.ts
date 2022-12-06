declare module "alpinejs" {

    type AlpineInstance = {
        readonly $el: HTMLElement
    }

    type WithAlpineInstance<T> = {
        [Key in keyof T]: T[Key] extends (...args: infer Args) => infer Return ? (this : T & AlpineInstance, 
            ...args: Args) => Return : T[Key]
    }

    const Alpine: {
        start(): void
        data<T>(componentName: string, callback: (params: any) => WithAlpineInstance<T>): void
    }

    const $el: any

    export default Alpine
}