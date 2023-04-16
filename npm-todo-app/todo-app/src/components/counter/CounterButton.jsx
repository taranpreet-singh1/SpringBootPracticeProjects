import './Counter.css'
import {useState} from 'react'
import {PropTypes} from 'prop-types'

export default function Counter(){

    const [count,setCount] = useState(0);

    function incrementCounterParentFunction(by){
        setCount(count + by)
    }

    function decrementCounterParentFunction(by){
        setCount(count - by)
    }

    function resetCounter(){
        setCount(0);
    }
    

    return (
        <>
            <span className="totalCount">{count}</span>
            <CounterButton by={1} incrementMethod={incrementCounterParentFunction} decrementMethod = {decrementCounterParentFunction}/>
            <CounterButton by={2} incrementMethod={incrementCounterParentFunction} decrementMethod = {decrementCounterParentFunction}/>
            <CounterButton by={3} incrementMethod={incrementCounterParentFunction} decrementMethod = {decrementCounterParentFunction}/>
            <button className="resetButton" onClick={resetCounter}
            >Reset</button>
        </>
    )
}


function CounterButton({by, incrementMethod, decrementMethod}){

    const [count,setCount] = useState(0);

    

    function incrementCounterFunction(){

        setCount(count+by)
        incrementMethod(by);
        console.log(count)
        console.log('increment clicked')
    }

    function decrementCounterFunction(){

        setCount(count-by)
        decrementMethod(by);
        console.log(count)
        console.log('increment clicked')
    }

    return (
        <div className="Counter">
 
            <div><button className="counterButton" onClick={incrementCounterFunction}
            >+{by}</button>
            <button className="counterButton" onClick={decrementCounterFunction}
            >-{by}</button>
            </div>
            
        </div>
    )
}

CounterButton.propTypes = {
    by: PropTypes.number
}

CounterButton.defaultProps = {
    by: 1
}