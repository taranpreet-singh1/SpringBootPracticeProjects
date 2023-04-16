
import './App.css';
import CounterButton from './components/counter/CounterButton';
import Counter from './components/counter/CounterButton'
import TodoApp from './components/todo/TodoApp'


function App() {
  return (
    <div className="App">
      {/* <Counter /> */}
      <TodoApp />
    </div>
  );
}


/* function PlayingWithProps(properties){
  console.log(properties.property1)
  console.log(properties.property2)
  return(
    <div></div>
  )
} */



export default App;
