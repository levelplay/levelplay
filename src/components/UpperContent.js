import React from "react"

export default function UpperContent(props){


    function handlClick(){
        console.log("Hello world")
    }



    return(
        <div className="upperContent">
            {!props.gameInitiated ? 

                <div>
                    <h1 className="upperContent--title">{ props.login?
                            "Welcome back to LevelPlay, Ready to play?" : "Welcome to LevelPlay, Ready to play "
                    }</h1>
                </div> :

                <div className="upperContent--gameplay">
                    <div className="upperContent-main-btn" onClick={handlClick}>Add a friend</div>
                    <div className="upperContent-btns">
                        <div className="generic-black-btn" onClick={handlClick}>FRIENDS</div>
                        <div className="generic-black-btn" onClick={handlClick}>AUTOMATCH</div>  
                    </div>

                </div>

                }
            <hr className="upperContent--hr"/>
         </div>
    )
    
}