import React,{Component} from "react";
import TaskServices from "../Service/TaskServices";
import table from 'react-bootstrap'
export class ViewComponents extends Component{
    constructor(props){
        super(props)
        this.state={
            tasks:[] 
        }
    }
    //to fetch data when page load
    componentDidMount(){
        TaskServices.viewall().then((response)=>
        {
            this.setState({tasks:response.data})
            console.log(response.data);
        })
      
    }

    handlecheck(id) {
        console.log(id);
      TaskServices.update(id).then((res)=>{
          TaskServices.viewall().then((res)=>{
              this.setState({tasks: res.data});
          })
      });
  }

  handledelete(id){
    console.log(id);
    console.log(JSON.stringify(id));
    TaskServices.delete(id).then((response)=>
    {
        this.componentDidMount();
        console.log(response);
    })
}    

    render(){
        return(
            <>
                <div className="container">
                <table className="table table-striped">
                    <thead >
                           <tr>
                            <th ></th>
                            <th >Tasks</th>
                            <th ></th>
                            </tr>
                    </thead>
                    <tbody>
                        {this.state.tasks.map(
                            t=>
                                <tr>
                                    <td>{<input type="checkbox" className="from-check-input" defaultChecked={t.isDone} 
                                    onChange={this.handlecheck.bind(this, t.id)}/>}</td>
                                    <td className="ck"> { t.isDone?(
                                         <span style={{textDecoration: 'line-through'}}>{t.desc}</span>) :(<span>{t.desc}</span>)}</td>
                                    <td> {<button type="button" className="btn btn-success" onClick={this.handledelete.bind(this, t.id)}> 
                                    Delete
                                    </button>}</td>
                                </tr>
                        )}
                    </tbody>
                </table></div>

              </>
    
        )
    }
}
export default ViewComponents
    