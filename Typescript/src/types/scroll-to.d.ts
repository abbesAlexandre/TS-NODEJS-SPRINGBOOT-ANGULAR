declare module "scroll-to" {
    const scrollTo: (x: number, y: number, options: {
        ease?: string,
        duration?: number
    }) => void
    export default scrollTo
}

