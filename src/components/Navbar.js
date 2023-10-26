import React from "react";

export default function Navbar(props){

    /**Function creates and copies an invite link */
    function inviteLink(){
        //Code to create the link here
    }
    return(
      <div className="navbar">
        <h2 className="navbar--title">
            LevelPlay
        </h2>
        {!props.gameInitiated ?
            <h4 className="navbar--login-status" 
                onClick={props.updateLogin}>
                 {!props.login ? "LOGIN" : "SIGN UP"} 
            </h4> :
            <h4 className="navbar--login-status"
                onClick={props.hasAccount ? alert("You need to sign up to sign up to do this") : inviteLink}
                >{props.hasAccount ? "Invite link" : "SIGN UP"} 
            </h4> 
        }
      </div>  
    )
}