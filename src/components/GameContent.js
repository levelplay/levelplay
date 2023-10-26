import React from "react";
import TicTacToe from "./Tic Tac Toe";
export default function GameContent(props){
    return(
        <div className="gamecontent">
            <p className="gamecontent--users">{`${props.opponent} vs ${props.userName}`}</p>
            <div className="gamecontent--score">
                <p className="gamecontent--points">{`${props.opponentPoints}`}</p>
                <p className="gamecontent--userPoints">{props.userNamePoints}</p>
            </div>
            <div className="board">
                <TicTacToe/>
            </div>
            
        </div>
    )
}