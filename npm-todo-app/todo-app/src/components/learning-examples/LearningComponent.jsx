
import {Component} from 'react'
import FirstComponent from './FirstComponent'
import SecondComponent from './SecondComponent'
import LearningJavaScript from './LearningJavaScript';

export default function App() {
  return (
    <div className="App">
      My Todo Application 
      <FirstComponent></FirstComponent>
      <SecondComponent></SecondComponent>
      <ThirdComponent/>
      <LearningJavaScript />
    </div>
  );
}





export class ThirdComponent extends Component{
  render(){
    return (
      <div className ="ThirdComponent">Third Component</div>
    )
  }
}
