import React from "react";
import UpperContent from "./UpperContent";
import Form from "./Form";
import GameContent from "./GameContent";

export default function MainContent(props){

    const [data, setData] = React.useState({
        userName:"You",
        userNamePoints:0,
        opponent:"Opponent",
        opponentPoints:0,
        userMove:true,
        opponentMove:false
    })
    function updateData(){
        setData(prevState =>{
            return{
                ...prevState,
                /**This code needs to be updated when the add friend button
                 *  and that section has functionality. */
                userName:"Username-Example",
                opponent:"Opponent Username"
            }
        })
    }
    

    return(
        <div className="mainContent">
           <UpperContent
                login={props.login}
                gameInitiated={props.gameInitiated}
           />
           {!props.gameInitiated &&
           <Form
                props={props}
                login={props.login}
                hasAccount={props.hasAccount}
                updateAccount = {props.updateAccount}
                updateGameInitiated = {props.updateGameInitiated}
           />
            }
           {props.gameInitiated &&
           <GameContent
                opponent={data.opponent}
                opponentPoints = {data.opponentPoints}
                userName={data.userName}
                userNamePoints={data.userNamePoints}
                updateData={updateData}
           />
            }
        </div>
    )
}
