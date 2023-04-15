import './Counter.css'
import {useState} from 'react'

export default function Counter(){

    const [count,setCount] = useState(0);


    function incrementCounterFunction(){

        setCount(count+1)
        console.log(count)
        console.log('increment clicked')
    }

    function decrementCounterFunction(){

        setCount(count-1)
        console.log(count)
        console.log('increment clicked')
    }

    return (
        <div className="Counter">
            <span className="count">{count}</span>
            <div><button className="counterButton" onClick={incrementCounterFunction}
            >+1</button>
            <button className="counterButton" onClick={decrementCounterFunction}
            >-1</button>
            </div>
            
        </div>
    )
}