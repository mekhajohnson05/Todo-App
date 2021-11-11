import React,{Component} from "react";
import TaskServices from "../Service/TaskServices";

export class TaskComponents extends Component{



    constructor(props){
        super(props)
        this.state={
            task:[],
            desc:"",
            isDone:""
        }
        this.handledescchange=this.handledescchange.bind(this)
       //this.handleisDone=this.handleisDone.bind(this);
    }

    handledescchange=(event)=>{
        this.setState({
            desc:event.target.value
        })
    }

 /*   handleisDone=(event)=>{
        this.setState({
            isDone:event.target.checked
        })
    }*/

    handlesave=(event)=>{
        console.log("success");
        let add={
            desc:this.state.desc,
            isDone:this.state.isDone
        }

    
        console.log(JSON.stringify(add));
        TaskServices.savetask(add).then((response)=>
        {
            console.log(response);
        })
    }
render(){
   

    return(
        <div className="container"
        style={{marginTop:20}} >
            
            <form className="">
            <span><b>Add</b></span>{"      "}
           { /*<input type="checkbox"  onChange={this.handleisDone}></input>*/}
            <input  style={{width: 500 }} type="text" placeholder="Enter Your Tasks" value={this.state.desc} onChange={this.handledescchange}></input>{"     "}
            <button  onClick={this.handlesave} className="btn btn-success" size="">Save</button>
           
            </form>
        </div>
    );
}

}
export default TaskComponents;