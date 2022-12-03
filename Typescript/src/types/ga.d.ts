interface Window {
    ga: (eventName: string, options: {
        hitType: string,
        eventCategory?: string
    }) => void
}

/** 
declare var ga: (eventName : string, options: {
    hitType : string,
    eventCategory?: string
}) => void
*/