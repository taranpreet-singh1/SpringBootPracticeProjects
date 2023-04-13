
const person = {
    name: 'Taran',
    address: '123 Bay Street Toronto',
    profiles: ['twitter','linkedin','instagram'],
    printProfile: () => {
        profiles.map(
            (profile) => {
                console.log(profile)
            }
        )
        console.log(person.profiles[0])
    }
}


export default function LearningJavaScript(){
    return(
        <>
        <div >{person.name}</div>
        <div>{person.address}</div>
        <div>{person.printProfile()}</div>
        </>
    )
}