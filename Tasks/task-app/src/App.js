import React, { Component} from 'react'
import './App.css';
import { SiAddthis } from "react-icons/si";
import 'bootstrap/dist/css/bootstrap.min.css';

import TaskComponents from './component/TaskComponent';
import ViewComponents from './component/ViewComponents';


class App extends Component {
  state={
    divconter:false,
  }
  render() {
    var handlechange= e =>{
      this.setState({divconter:!this.divconter});

    }

    const x=this.state.divconter;
    return(
      <div className="container"
      style={{marginTop:30}}>
       
        <span style={{marginRight:30}} onClick={handlechange}>{x?'':<b><SiAddthis />  Click To Add Task</b>}</span>
        {
          x &&(  <div> <TaskComponents/></div>)
          }
           <div
            style={{marginTop:30}}>
          <ViewComponents/>
        </div>
      </div>
   
    );
  }
}

export default App;
