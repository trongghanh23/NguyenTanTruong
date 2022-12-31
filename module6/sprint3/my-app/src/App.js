import React from "react";
import './App.css'

class App extends React.Component {
   constructor() {
       super();
       this.state={
           data:[
               {
                   "id":1,
                   "name": "Foo",
                   "age": "30"

               }, {
                   "id":2,
                   "name": "Fooo",
                   "age": "30"

               },{
                   "id":2,
                   "name": "Fooo",
                   "age": "30"

               }
           ]
       }
   }
render() {
       return(
           <div>
               <Header/>
               <table>
                   <tbody>
                   {this.state.data.map((person,i)=> <TableRow key = {i} data={person}/>)}
                   </tbody>
               </table>
           </div>
       )
}
}

class Header extends React.Component{
    render() {

    return(
        <div>
          <h1>Header</h1>
        </div>
    )
}
}
class TableRow extends React.Component{
    render() {
        return(
           <tr>
               <td>id:{this.props.data.id}</td>
               <td>name:{this.props.data.name}</td>
               <td>age:{this.props.data.age}</td>
           </tr>
        )
    }
}

export default App;
