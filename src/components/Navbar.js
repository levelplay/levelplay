import React from "react";

export default function Navbar(props){

    /**Function creates and copies an invite link */
    function inviteLink(){
        
        if(!props.hasAccount){
            alert("You need to sign up to sign up to do this")
            return;
        }
        //Code to create a link here. 
    }
    const styles = {
        textDecoration: "underline"
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
                onClick={inviteLink}
                style={styles}
                >Invite Link 
            </h4> 
        }
      </div>  
    )
}